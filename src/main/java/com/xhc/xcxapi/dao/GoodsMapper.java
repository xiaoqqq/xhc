package com.xhc.xcxapi.dao;

import com.xhc.xcxapi.entity.GoodsBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiaoqqq by 2018/4/20 12:51
 * @desc: TODO
 */

@Mapper
public interface GoodsMapper {
    @Select("select * from xhc.goods where goods_id = #{goods_id}")
    List<GoodsBean> findGoodsById(String goods_id);

    @Select("select * from xhc.goods where goods_name = #{goods_name}")
    List<GoodsBean> findGoodsByName(String goods_name);
}
