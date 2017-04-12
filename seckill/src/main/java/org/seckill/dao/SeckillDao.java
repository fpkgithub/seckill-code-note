package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

/*
 * Dao接口
 */

public interface SeckillDao
{
	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return 如果影响的行数>1，表示更新的记录行数
	 */
	int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

	/**
	 * 更具ID查询秒杀对象
	 * @param seckillId
	 * @return
	 */

	Seckill queryById(long seckillId);

	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit);

}
