package com.xhc.xhcapi.dao;

import com.xhc.xhcapi.entity.GoodsSizeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiaoqqq by 2018/4/20 12:51
 * @desc: FBA运费
 */

@Mapper
public interface FbaFeeMapper {
    //    String SQL_SELECT_FINDGOODSBYVOLUME = "select * from xhc.goods_size where volume = #{volume}";
    String SQL_SELECT_FINDGOODSBYVOLUME = "select * from goods_size where abs(volume - #{volume}) and volume>3999 and #{weight} <= max_weight limit 1";

    @Select(SQL_SELECT_FINDGOODSBYVOLUME)
    List<GoodsSizeBean> findGoodsByVolume(@Param("volume") double volume, @Param("weight") double weight);

}
