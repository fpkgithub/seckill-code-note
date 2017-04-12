package seckill;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test, junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class SeckillDaoTest
{

	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;

	@Test
	public void test1()
	{
		System.out.println(123);
	}

	@Test
	public void testQueryById() throws Exception
	{
		long id = 1000;
		System.out.println("test1");
		Seckill seckill = seckillDao.queryById(id);
		System.out.println("***************开始TestQueryById****************");
		System.out.println(seckill.getName());
		System.out.println(seckill);
		System.out.println("***************结束TestQueryById****************");
	}

	@Test
	public void testQueryAll() throws Exception
	{
		/*
		 * Caused by: org.apache.ibatis.binding.BindingException: 
		 * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
		 */
		//List<Seckill> queryAll(int offet, int limit);
		//java没有保留形参的纪录queryAll(int offet, int limit)-->queryAll(arg0,arg1)
		List<Seckill> list = seckillDao.queryAll(0, 100);
		for (Seckill seckill : list)
		{
			System.out.println(seckill);
		}
	}

	@Test
	public void testReduceNumber() throws Exception
	{
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1000L, killTime);
		System.out.println("updateCount=" + updateCount);
	}

}
