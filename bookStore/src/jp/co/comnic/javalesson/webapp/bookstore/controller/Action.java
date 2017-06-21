package jp.co.comnic.javalesson.webapp.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>ビジネス・ロジックを実行するActionクラスのためのインターフェイス。</p>
 * <p>Design Patternの1つである「Command Pattern」の簡易実装。</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public interface Action {

	/**
	 * <p>ビジネス・ロジックを実行する。</p>
	 * 
	 * @param request HTTPリクエスト・オブジェクト
	 * @param response HTTPレスポンス・オブジェクト
	 * @return ビジネス・ロジック実行後の遷移先パス
	 * @throws ServletException
	 * @throws IOException
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
