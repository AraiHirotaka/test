package jp.co.comnic.javalesson.webapp.bookstore.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

import jp.co.comnic.javalesson.webapp.bookstore.dao.*;
import model.Account;


/**
 * <p>コントローラーの処理に関連する便利なメソッドをまとめたユーティリティ・クラス。</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class ControllerUtils {

	/**
	 * <p>渡されたサーブレット・パスからエンティティの完全修飾クラス名を生成して返す。</p>
	 * <p>
	 * ここで渡されるサーブレット・パスは「/employees/...」のようなものを想定し、この場合、エンティティ・クラス
	 * の完全修飾名は「jp.co.comnic.javalesson.webapp.ems.entity.employee」となる。
	 * したがって、サーブレット・パスとエンティティ・クラスとの対応ルールやパッケージ名を変更する場合にはこのメソッドは機能しない
	 * 点に注意。
	 * </p>
	 * 
	 * @param servletPath リクエストURLに含まれるサーブレット・パス 
	 * @return エンティティ・クラスの完全修飾クラス名
	 */
	public static String getFullyQualifiedClassName(String servletPath) {
		
		String className = servletPath.substring(1, servletPath.lastIndexOf('/') - 1);
		String packageName = "jp.co.comnic.javalesson.webapp.ems.entity.";
		String firstCharacter = String.valueOf(className.charAt(0));
		firstCharacter = firstCharacter.toUpperCase();
		
		return packageName + className.replaceFirst(".", firstCharacter);
	}

	/**
	 * <p>リクエスト・パラメーターの値からエンティティ・オブジェクトを生成して返す。</p>
	 * 
	 * @param request 
	 * @param entity
	 */
	public static void populateEntity(HttpServletRequest request, Object entity) {

		// リクエスト・パラメーターの集合をMapオブジェクトとして取得
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		// Map<String, String>に変換
		Map<String, String> propertyMap = new HashMap<>();
		for (String key : parameterMap.keySet()) {
			propertyMap.put(key, parameterMap.get(key)[0]);
		}

		try {

			// 日付形式への対応
//			DateConverter dateConverter = new DateConverter();
//			dateConverter.setPattern("yyyy-MM-dd");
//			
			// コンバーターの登録
//			ConvertUtils.register(dateConverter, java.util.Date.class);
			ConvertUtils.register(new AccountConverter(), Account.class);
			
			// Apache Commons ProjectのBeanUtilsを使用して
			// Mapオブジェクトからエンティティ・オブジェクトへ値をセット
			BeanUtils.populate(entity, propertyMap);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * リクエスト・パラメーターとして送られてきたString型のdept_idからDepartmentオブジェクト
	 * に変換するBeanUtils用カスタム・コンバーター
	 */
	private static class AccountConverter implements Converter {

		@Override
		public <T> T convert(Class<T> accountClass, Object value) {
			
			T account = null;	
			
			try {
				
				account = accountClass.cast(
						new AccountDao().findById(Integer.parseInt((String)value)));
				
			} catch (NumberFormatException | DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return account;
		}
	}
	
	/**
	 * <p>データベースに関連するエラー・メッセージから最も重要な短いメッセージを取り出して返す。</p>
	 * 
	 * @param e 例外オブジェクト
	 * @return 例外オブジェクトから取り出した簡略なメッセージ
	 */
	public static String getShortMessage(Throwable e) {

		String errorMessage = e.getCause().getMessage().split(":")[3];
		
		if (errorMessage.endsWith("Error Code")) {
			errorMessage = errorMessage.replaceAll("Error Code", "");
		}
		
		return errorMessage;
	}
}
