package com.light.ibatis;


import java.io.Reader;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapConfig {
	private static final SqlMapClient sqlMap;
	
	static{
		try{
			String resource = "com/light/ibatis/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("아이바티스 초기화 에러.................................."+e);
			
		}
	}
	
	public static SqlMapClient getSqlMapInstance(){
		return sqlMap;
	}

}
