package jp.co.comnic.javalesson.webapp.bookstore.dao;

/**
 * <p>DAO層で発生した例外をまとめるカスタムの例外クラス。上位層に伝播する。</p>
 * 
 * @author M.Yoneyama
 * @version 1.0
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException(Exception e) {
		super("an exception occur in the DAO layer.", e);
	}
}
