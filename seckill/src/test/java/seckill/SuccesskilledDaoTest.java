/**
 * 
 */
package seckill;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SuccesskilledDao;
import org.seckill.entity.Successkilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class SuccesskilledDaoTest
{

	@Resource
	private SuccesskilledDao successkilledDao;

	/**
	 * Test method for {@link org.seckill.dao.SuccesskilledDao#insertSuccessKilled(long, java.lang.String)}.
	 */
	@Test
	public void testInsertSuccessKilled()
	{
		long seckillId = 1001L;
		long userPhone = 13502181181L;
		int insertCount = successkilledDao.insertSuccessKilled(seckillId, userPhone);
		System.out.println("insertCount=" + insertCount);

	}

	/**
	 * Test method for {@link org.seckill.dao.SuccesskilledDao#queryByIdWithSeckill(long)}.
	 */
	@Test
	public void testQueryByIdWithSeckill()
	{
		long seckillId = 1001L;
		long userPhone = 13502181181L;
		Successkilled successkilled = successkilledDao.queryByIdWithSeckill(seckillId, userPhone);
		System.out.println(successkilled);
		System.out.println(successkilled.getSeckill());
	}

}
