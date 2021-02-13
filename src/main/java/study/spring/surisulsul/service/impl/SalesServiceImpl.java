package study.spring.surisulsul.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import study.spring.surisulsul.model.Sales;
import study.spring.surisulsul.service.SalesService;

@Slf4j
@Service
public class SalesServiceImpl implements SalesService{
	
	/** MyBatis 세션 객체 주입 설정 */
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int getSalesCount(Sales input) throws Exception {
		int result = 0;
		
		try {
			result = sqlSession.selectOne("SalesMapper.selectCountAll", input);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("매출 데이터 수 조회에 실패했습니다.");
		}

		return result;
	}

}