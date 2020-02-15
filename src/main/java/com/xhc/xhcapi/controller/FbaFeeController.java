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
     * 通过 商品id 获取 商品list
     *
     * @param volume 体积
     * @return 商品list
     */
    @CrossOrigin
    @RequestMapping(value = "/search")
    public BaseBean<Object> getGoodsById(double volume, double weight) {
        BaseBean<Object> baseBean = new BaseBean<>();
        List<GoodsSizeBean> feeSizeBean = fbaFeeMapper.findGoodsByVolume(volume, weight);
        if (feeSizeBean.size() > 0) {
            for (GoodsSizeBean bean :
                    feeSizeBean) {
                baseBean.setCode(0);
                baseBean.setMessage("查询成功");
                baseBean.setRsult(bean);
            }
        } else {
            baseBean.setCode(-1);
            baseBean.setMessage("没有这个商品");
        }
        return baseBean;
    }
}
