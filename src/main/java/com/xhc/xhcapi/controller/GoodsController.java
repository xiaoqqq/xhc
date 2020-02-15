package com.xhc.xhcapi.controller;

import com.xhc.xhcapi.dao.GoodsMapper;
import com.xhc.xhcapi.entity.BaseBean;
import com.xhc.xhcapi.entity.GoodsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoqqq by 2018/4/20 12:05
 * @desc: TODO
 */

@RestController
@RequestMapping(value = "/search_goods")
public class GoodsController {

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 通过 商品id 获取 商品list
     *
     * @param g_id 商品id
     * @return 商品list
     */
    @CrossOrigin
    @RequestMapping(value = "/goods_id")
    public BaseBean<Object> getGoodsById(int g_id) {
        BaseBean<Object> baseBean = new BaseBean<>();
        List<GoodsBean> goods = goodsMapper.findGoodsById(g_id);
        if (goods.size() > 0) {
            for (GoodsBean bean :
                    goods) {
                baseBean.setCode(0);
                baseBean.setMessage("查询成功");
                baseBean.setResult(bean);
            }
        } else {
            baseBean.setCode(-1);
            baseBean.setMessage("没有这个商品");
        }
        return baseBean;
    }

    /**
     * 获取商品名一样的商品
     *
     * @param g_name 商品名
     * @return 商品list（商品名相同）
     */
    @CrossOrigin
    @RequestMapping(value = "/goods_name")
    public BaseBean<Object> getGoodsByName(String g_name) {
        BaseBean<Object> baseBean = new BaseBean<>();
        List<GoodsBean> lists = new ArrayList<>();
        List<GoodsBean> goods = goodsMapper.findGoodsByName(g_name);
        if (goods.size() > 0) {
            for (GoodsBean bean :
                    goods) {
                baseBean.setCode(0);
                baseBean.setMessage("查询成功");
                lists.add(bean);
                baseBean.setResult(lists);
            }
        } else {
            baseBean.setCode(-1);
            baseBean.setMessage("没有这个商品");
        }

        return baseBean;
    }
}
