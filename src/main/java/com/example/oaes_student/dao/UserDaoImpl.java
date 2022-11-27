package com.example.oaes_student.dao;

import com.example.oaes_student.entity.User;
import com.example.oaes_student.util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByUserId(long userId) {
        Session session = SessionUtil.getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userID", userId));
        User user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public void save(User user) {
        Session session = SessionUtil.getSession();
        try {
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userID", user.getUserID()));
            User user1 = (User) criteria.uniqueResult();
            tx.commit();
            user.setUserID(user1.getUserID());
            session.clear();
            session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (HibernateException he) {
            System.err.println("Hibernate Exception FOUND!! ->  " + he);
        }

        session.close();
    }
}
