package com.mytech.employee.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mytech.employee.dao.EmployeeDAO;
import com.mytech.employee.dao.model.Department;
import com.mytech.employee.dao.model.Employee;
import com.mytech.employee.dao.repository.DepartmentRepository;
import com.mytech.employee.dao.repository.EmployeeRepository;
import com.mytech.employee.service.model.EmployeeDto;
import com.mytech.employee.service.model.FieldModel;
import com.mytech.employee.service.model.QueryModel;
import com.mytech.employee.service.model.ResponseData;
import com.mytech.employee.service.model.SuperResponse;
import com.mytech.employee.util.JsonMapper;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.QueueSupplier;
import rx.Observable;

import javax.persistence.Query;

@Service
public class EmplomentServiceImpl implements EmplomentService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	AccountServiceImplV2 accountServiceImplV2;
	
	static Map<String, String> fieldMap = new HashMap<String, String>() {
		{
			put("job", "job");
			put("ename", "ename");
			put("depno", "depno");
			
			
		}
	};
	
	static Map<String, String> fieldMap1 = new HashMap<String, String>() {
		{
			put("depno", "depno");
			put("deploc", "deploc");
		}
	};
	
	
	/**
	 * Connection cnn = myEntityManager.unwrap(java.sql.Connection.class);
Statement st = cnn.createStatement();
ResultSet rs = st.executeQuery(query);
	 */
	
	
	/*
	 * 
	 * 
	
	
	Actor actor = this.jdbcTemplate.queryForObject(
	        "select first_name, last_name from t_actor where id = ?",
	        new Object[]{1212L},
	        new RowMapper<Actor>() {
	            public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Actor actor = new Actor();
	                actor.setFirstName(rs.getString("first_name"));
	                actor.setLastName(rs.getString("last_name"));
	                return actor;
	            }
	        });*/
	
	public void getEmployee() {

		Query query = em.createNativeQuery("select ename,job from Employee where empno = ?");
		query.setParameter(1, 1);
		// String val = (String) query.getSingleResult();

//	System.out.println("val ===== " + val);

		List<Object[]> results = query.getResultList();

		results.stream().forEach((record) -> {
			// Long id = ((BigInteger) record[0]).longValue();
			String firstName = (String) record[0];
			String jobName = (String) record[1];

			System.out.println("firstName ===== " + firstName + "  jobName= " + jobName);

		});
	}

	public List<EmployeeDto> getAllEmployees(long teamId) {
		List<Employee> employees = employeeRepository.findByDepartmentNumber(teamId);
		List<EmployeeDto> employeeDtos = employees.stream().map(p -> new EmployeeDto(p)).collect(Collectors.toList());
		
		/*
		List<ResponseData> responseDataList = buildQueryModels().stream().map(
				e -> employeeDAO.fetchData(e)).collect(Collectors.toList());
		
		SuperResponse superResponse = new SuperResponse();
		
		/*
		responseDataList.stream().forEach(
				e-> e.getTags().entrySet().stream().forEach(
						
						e1-> e1.getValue().stream().forEach(
								
								e2->System.out.println(e2);
						);
								
								
								
						);
				);
		
		for (ResponseData responseData : responseDataList) {
			Map<String, List<FieldModel>> tags = responseData.getTags();

			for (Map.Entry<String, List<FieldModel>> entry : tags.entrySet()) {
				String key = entry.getKey();
				List<FieldModel> fieldModelList = entry.getValue();

				for (FieldModel fieldModel : fieldModelList) {
					superResponse.addFieldModel(key, fieldModel);
				}
			}
		}*/
		
		 
		
		 JsonMapper<SuperResponse> responseDataMapper =
			      JsonMapper.serverInstance(SuperResponse.class);
		  
		try {
			System.out.println(responseDataMapper.toJson(accountServiceImplV2.getSummary("111").toBlocking().single()));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Flux<String> flux1 = Flux.just("{1}", "{2}", "{3}", "{4}");
		Flux<String> flux2 = Flux.just("|A|", "|B|", "|C|");
	
		
		
		List<Flux<String>> fluxLoop = new ArrayList();
		
		fluxLoop.add(flux1);
		fluxLoop.add(flux2);
		
		
		System.out.println("\n=== Flux.zip(flux2, flux1, combination) ===");
		Flux.zip(flux2, flux1,
				(itemFlux2, itemFlux1) -> "-[" + itemFlux2 + itemFlux1 + "]-")
				.subscribe(System.out::print);
		
		
		
		
		//Flux.zip(fluxLoop, QueueSupplier.XS_BUFFER_SIZE, (Object[] arg)->{}) ;
    		
		
		
		
		System.out.println("\n=== flux1 values zip with flux2 values ===");
		flux1.zipWith(flux2, 
				(itemFlux1, itemFlux2) -> "-[" + itemFlux1 + itemFlux2 + "]-")
				.subscribe(System.out::print);
		
		List<Integer> elements = new ArrayList<>();
		
		Flux.just(1, 2, 3, 4)
		  .log()
		  .map(i -> i * 2)
		  .subscribeOn(Schedulers.parallel())
		  .subscribe(elements::add);
		
		
		
		
		
		
		
		return employeeDtos;
	}
	
	public static  List<QueryModel> buildQueryModels() {
		List<QueryModel> queryModels = new ArrayList<QueryModel>();
		QueryModel queryModel = new QueryModel();

		queryModel.setQuery("select ename,job,DEPNO from Employee where empno = 1");
		queryModel.setTableName("Employee");
		// queryModel.setFilterModel();
		queryModel.setLogicalRealFieldMap(fieldMap);
		queryModels.add(queryModel);


		
		QueryModel queryModel1 = new QueryModel();
		queryModel1.setQuery("select deploc,depno from Department where depno = 1");
		queryModel1.setTableName("Department");
		// queryModel.setFilterModel();
		queryModel1.setLogicalRealFieldMap(fieldMap1);
		
		queryModels.add(queryModel1);

		QueryModel queryModel2 = new QueryModel();
		queryModel2.setQuery("select deploc,depno from Department where depno = 1");
		queryModel2.setTableName("Department");
		// queryModel.setFilterModel();
		queryModel2.setLogicalRealFieldMap(fieldMap1);

		queryModels.add(queryModel2);
		
		QueryModel queryModel3 = new QueryModel();
		queryModel3.setQuery("select deploc,depno from Department where depno = 1");
		queryModel3.setTableName("Department");
		 //queryModel.setFilterModel();
		queryModel3.setLogicalRealFieldMap(fieldMap1);
		
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);
		queryModels.add(queryModel3);

		return queryModels;
	}
	

	public void addEmployee(String name, String job, String manager, double salary) {
		
		Department department = departmentRepository.findById(1l).orElse(new Department());
		
		Employee newEmployee = new Employee();
		newEmployee.setName(name);
		newEmployee.setDepartment(department);
		newEmployee.setJobName(job);
		newEmployee.setManagerName(manager);
		newEmployee.setSalary(salary);
		employeeRepository.save(newEmployee);
	}
	
	public void updateEmployee(Long deptNo, Long employeeNumber, Employee employee) {
		Employee currentEmployee = employeeRepository.findById(employeeNumber).orElse(new Employee());

		currentEmployee.setName(employee.getName());
		currentEmployee.setJobName(employee.getJobName());
		currentEmployee.setManagerName(employee.getManagerName());
		currentEmployee.setSalary(employee.getSalary());
		employeeRepository.save(currentEmployee);
	}
}
