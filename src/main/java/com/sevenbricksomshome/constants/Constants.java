package com.sevenbricksomshome.constants;

public interface Constants {

	static final public String OK = "0";
	static final public String OK_ONE = "1";
	static final public String FAIL = "-1";
	static final public String FAIL_ACCOUNT_NULL = "-2";
	
	
	
	//배송관련
	static final public String SEARCH_OK = "20000"; //완료
	static final public String SEARCH_NONE = "20001"; //검색 결과 없음
	
	
	static final public String SEARCH_COMPANY_CODE = "30000"; //회사 코드 값
	static final public String SEARCH_COMPANY = "30001"; //회사
	static final public String SEARCH_COMPANY_IP = "30002"; //회사 IP 허용이 아님
	
	static final public String SEARCH_COUNT_MAX = "40000"; //최대 검색 수량
	static final public String SEARCH_DATA = "40001"; //필수 데이터 누락
	static final public String SEARCH_DATA_MAX = "40002"; //데이터 자리수 초과
	static final public String INSERT_MAX = "40003"; //최대 등록 건수 초과
	static final public String INSERT_SAME = "40004"; //중복 데이터
	
	static final public String PARAM_DATA = "40005"; //파라미터 데이터 누락

	// EBS API 관련
	static final public String API_KEY_NONE      = "401"; // API KEY 정보가 없습니다.
	static final public String API_KEY_UNEQUAL   = "402"; // API KEY 정보가 일치하지 않습니다.
	static final public String EBS_ID_NONE       = "403"; // 초등온 회원의 암호화키 정보가 없습니다.
	static final public String SEARCH_MONTH_NONE = "404"; // 검색 월 정보가 없습니다.
	static final public String CONTENT_TYPE_NONE = "405"; // 과목 정보가 없습니다.
	static final public String USER_TYPE_NONE    = "406"; // 사용자 타입 정보가 없습니다.
	static final public String START_DATE_NONE   = "407"; // 서비스 시작일 정보가 없습니다.
	static final public String END_DATE_NONE     = "408"; // 서비스 종료일 정보가 없습니다.
	static final public String USER_SAME         = "409"; // 이미 등록되어 있는 사용자입니다.
	static final public String EBS_ID_UNEQUAL    = "410"; // 사용자 정보가 없습니다.
}


