package com.adonai.tool.dbms;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisHandler {
	private SqlSessionFactory sqlMapper = null;

	public boolean isConnection() {
		return sqlMapper != null;
	}

	public void setSqlSessionFactory(String config) {
		if (this.sqlMapper == null) {
			try {
				Reader e = Resources.getResourceAsReader(config);
				this.sqlMapper = (new SqlSessionFactoryBuilder()).build(e);
				e.close();
			} catch (Exception arg2) {
				arg2.printStackTrace();
			}
		}

	}

	public <E> E selectOne(String qry) {
		SqlSession session = this.sqlMapper.openSession();

		try {
			return session.selectOne(qry);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public <E> E selectOne(String qry, Object para) {
		SqlSession session = this.sqlMapper.openSession();

		try {
			return session.selectOne(qry, para);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public <E> List<E> selectList(String qry) {
		SqlSession session = this.sqlMapper.openSession();

		try {
			return session.selectList(qry);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public <E> List<E> selectList(String qry, Object para) {
		SqlSession session = this.sqlMapper.openSession();

		try {
			return session.selectList(qry, para);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public int insert(String qry) {
		SqlSession session = this.sqlMapper.openSession(true);
		int rtInt = 0;

		try {
			rtInt = session.insert(qry);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rtInt;
	}

	public int insert(String qry, Object para) {
		SqlSession session = this.sqlMapper.openSession(true);
		int rtInt = 0;

		try {
			rtInt = session.insert(qry, para);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rtInt;
	}

	public int update(String qry) {
		SqlSession session = this.sqlMapper.openSession(true);
		int rtInt = 0;

		try {
			rtInt = session.update(qry);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rtInt;
	}

	public int update(String qry, Object para) {
		SqlSession session = this.sqlMapper.openSession(true);
		int rtInt = 0;

		try {
			rtInt = session.update(qry, para);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rtInt;
	}

	public int delete(String qry) {
		SqlSession session = this.sqlMapper.openSession(true);
		int rtInt = 0;

		try {
			rtInt = session.delete(qry);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rtInt;
	}

	public int delete(String qry, Object para) {
		SqlSession session = this.sqlMapper.openSession(true);
		int rtInt = 0;

		try {
			rtInt = session.delete(qry, para);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rtInt;
	}
}
