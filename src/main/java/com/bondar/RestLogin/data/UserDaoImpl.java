package com.bondar.RestLogin.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bondar.RestLogin.model.User;

@Repository @javax.transaction.Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext	private EntityManager em;

	@Override
	public User findUserByUsername(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        criteria.select(user).where(cb.equal(user.get("name"), name));
		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public User findUserById(long id) {
		return em.find(User.class, id);
	}

}
