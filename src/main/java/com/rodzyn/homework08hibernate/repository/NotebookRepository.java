package com.rodzyn.homework08hibernate.repository;

import com.rodzyn.homework08hibernate.model.notebook.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE notebook SET " +
            "notebook.title = :title, notebook.note = :note, notebook.update_date = :updateDate " +
            "WHERE notebook.id = :id", nativeQuery = true)
    void updateNote(@Param("title") String title, @Param("note") String note,
                    @Param("updateDate") String date, @Param("id") Long id);


    /*
     @Query("update Customer c set c.name = :name WHERE c.id = :customerId")
     void setCustomerName(@Param("customerId") Long id, @Param("name") String name);
         */
}
/*
    @Query(value = "SELECT * FROM cars WHERE cars.model = :model", nativeQuery = true)
    List<Car> findCarsByModelMyImpl(@Param("model") String model);

 */