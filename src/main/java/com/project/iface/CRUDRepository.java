package com.project.iface;

import java.util.*;

public interface CRUDRepository<T, P> {
	public boolean save(T obj);

	public Collection<T> findAll();

	public int deleteByPrimaryKey(P obj);
}
