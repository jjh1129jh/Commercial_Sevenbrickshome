package com.sevenbricksomshome.service.web.visitlog.impl;

import com.sevenbricksomshome.constants.Constants;
import com.sevenbricksomshome.dao.web.visitlog.VisitLogSqlMapDAO;
import com.sevenbricksomshome.service.web.visitlog.VisitLogService;
import com.sevenbricksomshome.util.ValidationCheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;


@Slf4j
@Service("VisitLogService")
public class VisitLogServiceImpl implements VisitLogService{

	@Autowired
	private VisitLogSqlMapDAO visitLogSqlMapDAO;
	
	/**
	 * 접속 로그 등록
	 * 
	 * @param paramMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	@Transactional(rollbackFor={Exception.class}, propagation = Propagation.REQUIRES_NEW)
	public HashMap<String, Object> insertVisitLog(
			HashMap<String, Object> paramMap) throws Exception{
		log.debug("VisitLogServiceImpl insertVisitLog START");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		log.debug("sbUserId      : "+paramMap.get("sbUserId"));
		log.debug("regId         : "+paramMap.get("regId"));
		log.debug("modId         : "+paramMap.get("modId"));

		log.debug("workType      : "+paramMap.get("workType"));
		
		try{
			boolean check  = true;

			String workType = String.valueOf(paramMap.get("workType"));

			if(true != ValidationCheckUtil.emptyCheck(workType)){
				check = false;
				map.put("msgCode", Constants.FAIL);
				map.put("msgDesc","구분 정보가 없습니다.");
			}
			
			if(true == check){
				
				paramMap.put("sbUserId", paramMap.get("sbUserId"));
				paramMap.put("regId", paramMap.get("regId"));
				paramMap.put("modId", paramMap.get("modId"));
				paramMap.put("sbVisitLogId", ("VL").concat(String.valueOf(System.currentTimeMillis())));

				paramMap.put("type", "W");

				visitLogSqlMapDAO.insertVisitLog(paramMap);

				map.put("msgCode", Constants.OK);
				map.put("msgDesc", "등록되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
            throw e;
		}
		
		log.debug("VisitLogServiceImpl insertVisitLog END");
		return map;
	}

}
