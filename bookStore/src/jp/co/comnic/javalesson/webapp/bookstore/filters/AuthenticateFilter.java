package jp.co.comnic.javalesson.webapp.bookstore.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>ユーザーがログイン認証済みかどうかを確認するためのFilter。ユーザーが未ログインであればログイン画面に遷移。</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 *
 */
@WebFilter("/*") // アプリケーションに対するすべてのリクエストに対してこのFilterを適用
public class AuthenticateFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Nothing to do
	}
	
	/* 
	 * <p>Filter処理の本体。リクエストが処理される直前、およびレスポンスが返送される直前に対する処理を記述。</p>
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// このメソッドが受け取る引数はHTTPに依存しないServletRequestおよびServletResponseであることに注意。
		
		ServletContext servletContext = ((HttpServletRequest)request).getServletContext();
		String servletPath = ((HttpServletRequest)request).getServletPath(); // HTTPリクエスト・パスを取得
		HttpSession session = ((HttpServletRequest)request).getSession(); // HttpSessionオブジェクトの取得
		
		String authenticated = (String)session.getAttribute("isAuthenticated");
		
		// ログイン認証済みもしくは許可されたパスの場合
		if (("AUTHENTICATED".equals(authenticated)) || AuthenticatePathMatcher.matches(servletPath)) {
			
			
			//↑このメソッドの↑の処理はリクエストフィルター
			chain.doFilter(request, response); // リクエストされたリソースの処理へ（繋げない場合でも必ず記述する）
			//この処理にかえって来たあとレスポンスを行うため。
			//↓このメソッドの↓の処理はレスポンスフィルター
			
			
		} else {
			// それ以外のリクエストはすべてログイン画面へリダイレクト
			((HttpServletResponse)response).sendRedirect(servletContext.getContextPath() + "/login");
		}
	}

	@Override
	public void destroy() {
		// Nothing to do
	}
}
