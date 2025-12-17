package com.sevenbricksomshome.dao.web.visitlog;

import jakarta.annotation.PostConstruct;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class VisitLogSqlMapDAO extends SqlSessionDaoSupport{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@PostConstruct
	void init() {
		setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	/**
	 * 접속 로그 등록
	 * 
	 * @param Map
	 * @return
	 * @throws DataAccessException
	 */
	public int insertVisitLog(HashMap<String, Object> paramMap)
			throws DataAccessException {
		logger.debug("VisitLogSqlMapDAO insertVisitLog START");
		String sqlId = "VisitLog.insertVisitLog";
		logger.debug("VisitLogSqlMapDAO insertVisitLog END");
		return getSqlSession().insert(sqlId, paramMap);
	}
}
