package com.sevenbricksomshome.init;

import com.sevenbricksomshome.util.ValidationCheckUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class ManagerDraftAction {

	public boolean adminCheckLogin(HttpSession session) throws Exception {
		if (session == null) {
			return false;
		}
		String ntsoftId = (String) session.getAttribute("ntsoftId");
		String ntsoftManagerId = (String) session.getAttribute("ntsoftManagerId");
		String ntsoftManagerName = (String) session.getAttribute("ntsoftManagerName");
		String managerType = (String) session.getAttribute("managerType");
		String sbCompanyId = (String) session.getAttribute("sbCompanyId");
		log.debug("======================== MANAGER CHECKLOGIN START =========================");
		log.debug("ntsoftId             : "+ ntsoftId);
		log.debug("ntsoftManagerId      : "+ ntsoftManagerId);
		log.debug("ntsoftManagerName    : "+ ntsoftManagerName);
		log.debug("managerType          : "+ managerType);
		log.debug("sbCompanyId          : "+ sbCompanyId);
		log.debug("========================= MANAGER CHECKLOGIN END ==========================");
		if ((ntsoftId == null) || ("".equals(ntsoftId)) || (ntsoftManagerId == null) || ("".equals(ntsoftManagerId))) {
			return false;
		}
		
		if (managerType.equals("MA") || managerType.equals("GU")) {
			return false;
		}
		return true;
	}
	
	public boolean adminCheckLogin(HttpSession session,String t) throws Exception {
		if (session == null) {
			return false;
		}
		String ntsoftId = (String) session.getAttribute("ntsoftId");
		String ntsoftManagerId = (String) session.getAttribute("ntsoftManagerId");
		String ntsoftManagerName = (String) session.getAttribute("ntsoftManagerName");
		String managerType = (String) session.getAttribute("managerType");
		String sbCompanyId = (String) session.getAttribute("sbCompanyId");
		log.debug("======================== MANAGER CHECKLOGIN START =========================");
		log.debug("ntsoftId             : "+ ntsoftId);
		log.debug("ntsoftManagerId      : "+ ntsoftManagerId);
		log.debug("ntsoftManagerName    : "+ ntsoftManagerName);
		log.debug("managerType          : "+ managerType);
		log.debug("sbCompanyId          : "+ sbCompanyId);
		log.debug("========================= MANAGER CHECKLOGIN END ==========================");
		if ((ntsoftId == null) || ("".equals(ntsoftId)) || (ntsoftManagerId == null) || ("".equals(ntsoftManagerId))) {
			return false;
		}
		
		if (!managerType.equals(t)) {
			return false;
		}
		return true;
	}

	public boolean webCheckLogin(HttpSession session)throws Exception{
		
		if(session == null){
			return false;
		}else{


			log.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			log.debug(String.valueOf(session));
			log.debug(session.getId());
			log.debug(String.valueOf(session.getAttribute("sbUserId")));
			log.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");


			String sbUserId     = (String)session.getAttribute("sbUserId");
			String loginId      = (String)session.getAttribute("loginId");
			String userName     = (String)session.getAttribute("userName");
			log.debug("======================== USER CHECKLOGIN START =========================");
			log.debug(" sbUserId          : "+ sbUserId);
			log.debug(" loginId           : "+ loginId);
			log.debug(" userName          : "+ userName);
			log.debug("======================== USER CHECKLOGIN END ===========================");

			log.debug("======================================= session ID Start2 =======================================");
			log.debug("=============== Session ID                 :"+session.getId());
			log.debug("======================================= session ID End2   =======================================");
			if(null==sbUserId||("").equals(sbUserId)){
				return false;
			}else{
				return true;
			}
		}
	}
}
