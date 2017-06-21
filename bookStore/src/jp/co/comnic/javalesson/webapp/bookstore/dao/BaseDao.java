package jp.co.comnic.javalesson.webapp.bookstore.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 * <p>DAOクラスの共通となる基底クラス。</p>
 * 
 * @author M.Yoneyama
 * @version 2.0
 */
public class BaseDao {

	protected EntityManager em = Persistence.createEntityManagerFactory("ems-v3").createEntityManager();
	protected EntityTransaction tx = em.getTransaction();
	protected CriteriaBuilder builder = em.getCriteriaBuilder();
	
	/**
	 * <p>全件検索</p>
	 * 
	 * @param query
	 * @param root
	 * @return 検索結果のエンティティ・オブジェクトが格納されたリスト
	 */
	protected <T> List<T> findAll(CriteriaQuery<T> query, Root<T> root) {
		return em.createQuery(query.select(root)).getResultList();
	}
	
	/**
	 * <p>主キー検索</p>
	 * 
	 * @param entityClass
	 * @param id
	 * @return 検索結果のエンティティ・オブジェクト
	 */
	public <T> T findById(Class<T> entityClass, Serializable id) {
		return em.find(entityClass, id);
	}
		
	/**
	 * <p>新規レコードの挿入</p>
	 * 
	 * @param entity
	 */
	public void insert(Object entity) throws DaoException {

		try {
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * <p>既存レコードの削除</p>
	 * 
	 * @param entityClass 削除するレコードに対応するエンティティ・クラス
	 * @param id 削除するレコードのID
	 */
	public <T> void remove(Class<T> entityClass, Serializable id) throws DaoException {
		// エンティティ・オブジェクトを取得して削除
		remove(em.find(entityClass, id));
	}
	
	/**
	 * <p>既存レコードの削除</p>
	 * 
	 * @param entity 削除するエンティティ・オブジェクト
	 */
	public void remove(Object entity) throws DaoException {
		try {
			tx.begin();
			em.remove(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public void update(Object entity) throws DaoException {
		try {
			tx.begin();
			em.merge(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}