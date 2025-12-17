package com.sevenbricksomshome.init;

import jakarta.servlet.http.HttpServlet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceInitializeServlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String default_file_store_path = "";
	private static String default_file_store_folder = "";
	private static String webService_url= "";
	private static String appService_url ="";


	public void init(){
		log.debug("ServiceInitializeServlet - init start");
		default_file_store_path = getInitParameter("DEFAULT_FILE_STORE_PATH");
		default_file_store_folder = getInitParameter("DEFAULT_FILE_STORE_FOLDER");
		webService_url = getInitParameter("WEBSERVICE_URL");
		appService_url = getInitParameter("APPSERVICE_URL");
		
		//NoticeThreadJob.getInstance();
		//BirthDayThreadJob.getInstance();
		log.debug("ServiceInitializeServlet - init end");
	}
	
	public static String getDefaultFileStorePath(){
		return default_file_store_path;
	}

	public static String getDefaultFileStoreFolder() {
		return default_file_store_folder;
	}

	public static String getAppServiceUrl(){
		return appService_url;
	}
	
	public static String getWebServiceUrl(){
		return webService_url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void main(String[] args) {
		System.out.println(default_file_store_path);
	}
}
