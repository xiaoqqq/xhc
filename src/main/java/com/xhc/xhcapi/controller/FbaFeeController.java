package com.xhc.xhcapi.controller;

import com.xhc.xhcapi.dao.FbaFeeMapper;
import com.xhc.xhcapi.dao.GoodsMapper;
import com.xhc.xhcapi.entity.BaseBean;
import com.xhc.xhcapi.entity.GoodsBean;
import com.xhc.xhcapi.entity.GoodsSizeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoqqq by 2018/4/20 12:05
 * @desc: TODO
 */

@RestController
@RequestMapping(value = "/fee")
public class FbaFeeController {

    @Autowired
    FbaFeeMapper fbaFeeMapper;

    /**
     * 通过商品的体积，以及重量计算fba运费
     *
     * @param chang
     * @param kuan
     * @param gao
     * @param weight
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/search")
    public BaseBean<Object> getGoodsById(double chang, double kuan, double gao, double weight) {
        BaseBean<Object> baseBean = new BaseBean<>();
        double volume = chang * kuan * gao;
        if (chang >= 150 || kuan >= 150 || gao >= 150) { // 大件大号，根据重量来判断运费
            double chang1 = 150;
            double kuan1 = 150;
            double gao1 = 150;
            List<GoodsSizeBean> feeSizeBean = fbaFeeMapper.findGoodsByWeight(chang1, kuan1, gao1, weight);
            response(weight, baseBean, volume, feeSizeBean);
        } else {
            List<GoodsSizeBean> feeSizeBean = fbaFeeMapper.findGoodsByVolume(volume, weight);
            response(weight, baseBean, volume, feeSizeBean);
        }
        return baseBean;
    }

    /**
     * 返回结果
     *
     * @param weight
     * @param baseBean
     * @param volume
     * @param feeSizeBean
     */
    private void response(double weight, BaseBean<Object> baseBean, double volume, List<GoodsSizeBean> feeSizeBean) {
        if (feeSizeBean.size() > 0) {
            for (GoodsSizeBean bean :
                    feeSizeBean) {
                baseBean.setCode(0);
                baseBean.setMessage("查询成功");
                baseBean.setResult(bean);
            }
        } else {
            baseBean.setCode(-1);
            baseBean.setMessage("error");
        }
    }
}
