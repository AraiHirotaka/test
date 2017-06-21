package jp.co.comnic.javalesson.webapp.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.webapp.bookstore.dao.AccountDao;
import jp.co.comnic.javalesson.webapp.bookstore.dao.DaoException;
import model.Account;

/**
 * <p>ログイン認証処理を実行するActionインターフェイスの実装。</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class LoginAction implements Action {

	/* (non-Javadoc)
	 * @see jp.co.comnic.javalesson.webapp.ems.controller.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String forwardPath = "login";
		
		try {
			// クライアントから送られてきたメール・アドレスとパスワードを使用して認証処理をAccountDaoに委譲し、
			// 結果をAccountオブジェクトとして取得
			Account account = new AccountDao().loginAuthenticate(email, password);
			
			if (account != null) { // テーブルにマッチするレコードが存在する場合認証成功
				
				// セッション管理を開始し、セッションのスコープ・オブジェクトとなるHttpSessionに
				// 認証済みを表すboolean値とログイン・ユーザー名をセット
				request.getSession().setAttribute("isAuthenticated", "AUTHENTICATED");
//				request.getSession().setAttribute("loginUsername", account.getUsername());
				
				// トップページにリダイレクト
				forwardPath = null;
				response.sendRedirect("/" + request.getServletContext().getServletContextName() + "/");
				
			} else {
				request.setAttribute("error", "[ERROR] Invalid e-mail or password.");
				forwardPath = "login";
			}
		} catch (DaoException e) {
			throw new ServletException(e);
		}
		
		return forwardPath;
	}
}
