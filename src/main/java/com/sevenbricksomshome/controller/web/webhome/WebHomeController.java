package com.sevenbricksomshome.controller.web.webhome;

import com.sevenbricksomshome.init.ManagerDraftAction;
import com.sevenbricksomshome.service.web.visitlog.VisitLogService;
import com.sevenbricksomshome.util.RequestLogUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;


@Slf4j
@Controller
public class WebHomeController extends ManagerDraftAction{

	@Autowired
	private VisitLogService visitLogService;

	/**
	 * 인덱스 화면으로 이동.
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/")
	public String  indexIntro(HttpSession session,HttpServletRequest request) {

		log.debug("WebIndexController  indexIntro START");

		try{
			// 접속 로그 저장
			HashMap<String, Object> visitLogParamMap = RequestLogUtil.getVisitLogParameterMap(request);

			visitLogParamMap.put("regId", "SYSTEM");
			visitLogParamMap.put("modId", "SYSTEM");
			visitLogParamMap.put("workType", "INDEX");
			visitLogService.insertVisitLog(visitLogParamMap);

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		log.debug("WebIndexController  indexIntro END");
		return "/index";
	}

    /**
     * SNS 공구용 인덱스
     * @param request
     * @return
     */
	@RequestMapping(value="/promo")
	public String promoIntro(HttpServletRequest request) {

		log.debug("WebIndexController promoIntro START");

		try{
			// 접속 로그 저장
			HashMap<String, Object> visitLogParamMap = RequestLogUtil.getVisitLogParameterMap(request);

			visitLogParamMap.put("regId", "SYSTEM");
			visitLogParamMap.put("modId", "SYSTEM");
			visitLogParamMap.put("workType", "PROMOTION");
			visitLogService.insertVisitLog(visitLogParamMap);

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		log.debug("WebIndexController promoIntro END");
		return "/promo";
	}
}