package com.project.iface;

public interface EmployeeRepository<T, P> extends CRUDRepository<T, P> {
	public int updateEmailByPrimaryKey(P primaryKey, String updatedEmail);

	public int updatePhoneNumberByPrimaryKey(P primaryKey, Long updatedPhoneNumber);

	public int deleteByFirstName(String employeeName);
}
