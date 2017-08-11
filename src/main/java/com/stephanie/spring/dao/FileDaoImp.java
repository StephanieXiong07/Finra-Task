package com.stephanie.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.stephanie.spring.entity.UploadFile;

@Repository
public class FileDaoImp implements FileDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public UploadFile save(UploadFile f) {
		// TODO Auto-generated method stub
		em.persist(f);
		return f;
	}

	@Override
	public UploadFile getFile(Integer id) {
		// TODO Auto-generated method stub
		return em.find(UploadFile.class, id);
		
	}

	@Override
	public List<UploadFile> getAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT ufile FROM UploadFile ufile");
		return q.getResultList();
	}

}
