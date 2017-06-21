package jp.co.comnic.javalesson.webapp.bookstore.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

/**
 * <p>Actionの実装クラスのインスタンスを生成して返すファクトリー。</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
@WebListener // リスナーの登録
public class ActionFactory implements ServletContextListener {

	// web.xmlに記述されたcontext-paramを利用するために必要
	private static ServletContext context;
	
	/**
	 * <p>クライアントのリクエスト・パスを元に適切なActionの実装クラスのインスタンスを生成する。</P>
	 * <p>リクエスト・パスとActionクラスの対応付けはweb.xmlファイルcontext-paramタグを使用して設定し、
	 * ServletContextオブジェクトのgetInitParameterメソッドを使用して取得する。
	 * </p>
	 * 
	 * @param servletPath クライアントからのリクエスト・パス
	 * @return Actionの実装
	 * @throws ServletException
	 */
	public static Action getAction(String servletPath) throws ServletException {
		
		Action action = null;
		
		// 引数で渡されたServletパスに対応するActionの実装クラス名を取得
		String actionClassName = context.getInitParameter(servletPath);
		
		try {
			// 取得したActionの実装クラス名からインスタンスを生成
			action = (Action)Class.forName(actionClassName).newInstance();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		// 生成したActionの実装クラスのインスタンスを返す
		return action;
	}
	
	/* (non-Javadoc)
	 * ServletContextListenerインターフェイスをimplementsしたクラスのcontextInitializedメソッドは
	 * コンテナの起動時自動的に呼び出される
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// コンテナ起動時にServletContextオブジェクトを受け取ってフィールドにセット
		context = sce.getServletContext();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Not implements
	}
}
