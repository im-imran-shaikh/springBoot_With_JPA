1) To auto increment primary key using spring data jpa use @GeneratedValue of javax.persistence.GeneratedValue;

2) To update value in database you need to create an update query
	@Modifying
	@Query("UPDATE SmartPhone SET price = ?1 WHERE Id = ?2")
	@Transactional
	void updatePrice(int Id, int price);
	
	@Modifying is use  when we want to update from database
	@Transactional is use