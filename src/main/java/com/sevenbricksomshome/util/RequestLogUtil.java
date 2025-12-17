package com.sevenbricksomshome.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RequestLogUtil {
   
   /**
    * 접속 로그 저장
    * @param request
    * @param 
    * @throws Exception
    */
   // https://linked2ev.github.io/java/2019/05/22/JAVA-1.-java-get-clientIP/
   public static HashMap<String, Object> getVisitLogParameterMap(HttpServletRequest request) {
      
      String visitIp          = getClientIP(request);
      String visitReferDomain = getClientDomainName(request);
      String visitRefer       = getClientDomain(request);
      String visitOriginAgent = getClientAgent(request);
      String visitAgent       = getClientBrower(request);
      String visitOs          = getClientOS(request);

      
      // pushHistory에 저장.
      HashMap<String, Object> visitLogParamMap = new HashMap<String, Object>();
      visitLogParamMap.put("type", "A"); // 관리자에서 로그 등록
      visitLogParamMap.put("visitIp", visitIp);
      visitLogParamMap.put("visitReferDomain", visitReferDomain);
      visitLogParamMap.put("visitRefer", visitRefer);
      visitLogParamMap.put("visitOriginAgent", visitOriginAgent);
      visitLogParamMap.put("visitAgent", visitAgent);
      visitLogParamMap.put("visitOs", visitOs);
      
      return visitLogParamMap;
   }
   
   /**
    * 접속자 IP
    * @param request
    * @param 
    * @throws Exception
    */
   // https://linked2ev.github.io/java/2019/05/22/JAVA-1.-java-get-clientIP/
   public static String getClientIP(HttpServletRequest request) {
      String ip = request.getHeader("X-Forwarded-For");
      log.debug("> X-FORWARDED-FOR : " + ip);
   
      if (ip == null) {
         ip = request.getHeader("Proxy-Client-IP");
         log.debug("> Proxy-Client-IP : " + ip);
      }
      if (ip == null) {
         ip = request.getHeader("WL-Proxy-Client-IP");
         log.debug(">  WL-Proxy-Client-IP : " + ip);
      }
      if (ip == null) {
         ip = request.getHeader("HTTP_CLIENT_IP");
         log.debug("> HTTP_CLIENT_IP : " + ip);
      }
      if (ip == null) {
         ip = request.getHeader("HTTP_X_FORWARDED_FOR");
         log.debug("> HTTP_X_FORWARDED_FOR : " + ip);
      }
      if (ip == null) {
         ip = request.getRemoteAddr();
         log.debug("> getRemoteAddr : "+ip);
      }
      
      log.debug("Result : IP Address : "+ip);
   
      return ip;
   }
   
   /**
    * 접속자 Agent
    * @param request
    * @param 
    * @throws Exception
    */
   public static String getClientAgent(HttpServletRequest request) {
      String agent = request.getHeader("User-Agent");
      
      log.debug("Result : agent : "+agent);
   
      return agent;
   }
   
   /**
    * 접속자 브라우저
    * @param request
    * @param 
    * @throws Exception
    */
   public static String getClientBrower(HttpServletRequest request) {
      String agent = request.getHeader("User-Agent");
      
      String brower = null;

      if (agent != null) {
         if (agent.indexOf("Trident") > -1) {
            brower = "MS IE";
         } else if (agent.indexOf("Edg") > -1) {
            brower = "MS Edg";
         }else if (agent.indexOf("KAKAOTALK") > -1) {
            brower = "KAKAOTALK";
         } else if (agent.indexOf("Chrome") > -1) {
            brower = "Chrome";
         } else if (agent.indexOf("Safari") > -1) {
            brower = "Safari";
         } else if (agent.indexOf("Opera") > -1) {
            brower = "Opera";
         }
      }
      
      log.debug("Result : brower : "+brower);
   
      return brower;
   }
   
   /**
    * 접속자 OS
    * @param request
    * @param 
    * @throws Exception
    */
   public static String getClientOS(HttpServletRequest request) {
      String agent = request.getHeader("User-Agent");
      
      // OS 구분
      String os = null;
      
      if(agent.indexOf("Android") != -1) {
         os = "Android";
      }else if(agent.indexOf("iPhone") != -1) {
         os = "iPhone";
      }else if(agent.indexOf("Linux") != -1) {
         os = "Linux";
      }else if(agent.indexOf("Mac OS") != -1) {
         os = "Mac OS";
      }else if(agent.indexOf("Windows") != -1) {
         os = "Windows";
      }else {
         os = "etc";
      } 
      
      log.debug("Result : OS : "+os);
   
      return os;
   }
   
   /**
    * 접속자 도메인(REFER)
    * @param request
    * @param 
    * @throws Exception
    */
   public static String getClientDomain(HttpServletRequest request) {

      String referer = request.getHeader("REFERER");
      
      log.debug("Result : Referer : "+referer);
   
      return referer;
   }
   
   /**
    * 접속자 도메인(REFER에서 도메인명만 추출)
    * @param request
    * @param 
    * @throws Exception
    */
   public static String getClientDomainName(HttpServletRequest request) {
      
      String referer = request.getHeader("REFERER");
      
      log.debug("Referer : "+referer);
      
      if(referer==null||referer.equals("")) {
         return null;
      }
      
      String result="";
      Pattern urlPattern = Pattern.compile("^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$");
      Matcher m = urlPattern.matcher(referer);

      if (m.matches()) {
         /*for(int i=0; i<=m.groupCount();i++) {
            System.out.println(m.group(i));
         }*/
         
         if(m.groupCount()>=2){
            result = m.group(2);
         }
         
         if(result.contains("www.")) {
            result = result.substring(4, result.length());
         }
      }
      
      log.debug("Result : domainName : "+result);
      
      return result;
   }
}