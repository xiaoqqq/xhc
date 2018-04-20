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
    String SQL_SELECT_FINDGOODSBYID = "select * from xhc.Xhc_GoodsType where g_id = #{g_id}";
    String SQL_SELECT_FINDGOODSBYNAME = "select * from xhc.Xhc_GoodsType where g_name = #{g_name}";

    @Select(SQL_SELECT_FINDGOODSBYID)
    List<GoodsBean> findGoodsById(int g_id);

    @Select(SQL_SELECT_FINDGOODSBYNAME)
    List<GoodsBean> findGoodsByName(String g_name);
}
