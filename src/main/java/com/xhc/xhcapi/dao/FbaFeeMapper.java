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
    String SQL_SELECT_FINDGOODS_BY_VOLUME = "select * from goods_fee where abs(volume - #{volume}) >= 0 and volume >= #{volume} and #{weight} + packge_weight <= max_weight limit 1";
    String SQL_SELECT_FINDGOODS_BY_WEIGHT = "select * from goods_fee where #{weight} + packge_weight <= max_weight and chang = 150 or kuan = 150 or gao = 150 limit 1";

    @Select(SQL_SELECT_FINDGOODS_BY_VOLUME)
    List<GoodsSizeBean> findGoodsByVolume(@Param("volume") double volume, @Param("weight") double weight);

    @Select(SQL_SELECT_FINDGOODS_BY_WEIGHT)
    List<GoodsSizeBean> findGoodsByWeight(@Param("chang") double chang, @Param("kuan") double kuan, @Param("gao") double gao, @Param("weight") double weight);
}
