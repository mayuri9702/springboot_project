package com.citi.ex.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.citi.ex.dto.Person;
import com.citi.ex.utils.DBUtils;
@Component  // singleton object --> utils package where singleton object --> class level annotations
@Repository // singleton object --> it should be marked to all repo impl --> to increase the readability --> class level annotations

// @Bean // singleton object  --> not allowing us to import --> it method level annotation
public class PersonRepositoryImpl implements PersonRepository {

	/*
	private PersonRepositoryImpl() {
		
		
	}
	private static PersonRepository personRepository;
	public static PersonRepository getInstance() {
		if(personRepository==null) {
			personRepository= new PersonRepositoryImpl();
			return personRepository;
		}
		return personRepository;
	}*/
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public String addPerson(Person person) {
		//Connection connection=DBUtils.getConnection();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String insertQuery="insert into person (firstName, lastName, panCard, aadharCard)"+
									" values(?,?,?,?)"; //  insert statement --> person table in our persondb
									// personID will auto generate because of auto increment
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setString(3, person.getPanCard());
			preparedStatement.setString(4, person.getAadharCard());
			// execute -> DDL --> boolean
			// executeUpdate --> DML --> no. of affected rows
			// executeQuery --> DQL --> ResultSet --> it will hold the rows/records retrieved from DB
			int res=preparedStatement.executeUpdate();
			if(res>0) 
				return "success";
			else
				return "fail";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return "fail";
	}

	@Override
	public String updatePerson(int personId, Person person) {
		// Connection connection=DBUtils.getConnection();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String updateQuery="update person set personID=?,firstName=?,lastName=?,panCard=?,aadharCard=? where personID=?";
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1,person.getPersonID());
			preparedStatement.setString(2,person.getFirstName());
			preparedStatement.setString(3,person.getLastName());
			preparedStatement.setString(4,person.getPanCard());
			preparedStatement.setString(5,person.getAadharCard());
			preparedStatement.setInt(6,personId);
			int res=preparedStatement.executeUpdate();
			
			if(res>0)
				return "success";
			else
				return "fail";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtils.closeConnection(connection);
		}
		return "fail";
	}

	@Override
	public String deletePerson(int personId) {
		//Connection connection=DBUtils.getConnection();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String deleteQuery="delete from person where personID=?"; //  insert statemnet --> person table in our persondb
									// personID will auto generate because of autoincrement
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, personId);
			int res=preparedStatement.executeUpdate();
			if(res>0) 
				return "success";
			else
				return "fail";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return "fail";
	}

	@Override
	public Optional<Person> getPersonById(int personId) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		String query="select * from person where personID=?";
		
		//connection=DBUtils.getConnection();
		
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, personId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				Person person=new Person();
				person.setPersonID(resultSet.getInt("personId")); // -->
				person.setFirstName(resultSet.getString("firstName"));
				person.setLastName(resultSet.getString("lastName"));
				person.setPanCard(resultSet.getString("panCard"));
				person.setAadharCard(resultSet.getString("aadharCard"));
				// empty : when there is no record
				// of : when we are firm for getting something
				// ofNullable : not sure
				return Optional.of(person);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		return Optional.empty();
	}

	@Override
	public List<Person> getAllPersons() {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		List <Person>list=null;
		boolean flag=false;
		
		//connection=DBUtils.getConnection();
		String query="select * from person";
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			list=new ArrayList<>();
			while(resultSet.next()) {
				Person person=new Person();
				person.setPersonID(resultSet.getInt("personId")); // -->
				person.setFirstName(resultSet.getString("firstName"));
				person.setLastName(resultSet.getString("lastName"));
				person.setPanCard(resultSet.getString("panCard"));
				person.setAadharCard(resultSet.getString("aadharCard"));
				
				if(person!=null && !flag) {  // improve the condition
					flag=true;
					list=new ArrayList<>();
				}
				list.add(person);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		return list;
	}

}