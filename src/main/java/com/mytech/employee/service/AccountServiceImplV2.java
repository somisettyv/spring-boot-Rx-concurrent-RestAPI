package com.mytech.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytech.employee.dao.EmployeeDAO;
import com.mytech.employee.service.model.FieldModel;
import com.mytech.employee.service.model.ResponseData;
import com.mytech.employee.service.model.SuperResponse;

import rx.Observable;
import rx.schedulers.Schedulers;

@Component
public class AccountServiceImplV2 {

	private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImplV2.class);

	@Autowired
	EmployeeDAO employeeDAO;

	public Observable<SuperResponse> getSummary(String accountNumber) {

		System.out.println("getSummary -------- ");
		List<Observable<?>> backendObservables = new ArrayList<Observable<?>>();
		SuperResponse accountResponse = new SuperResponse();
		EmplomentServiceImpl.buildQueryModels().stream().forEach(
				e -> backendObservables.add(Observable.just(employeeDAO.fetchData(e)).subscribeOn(Schedulers.io())));

		return Observable.zip(backendObservables, (Object... args) -> {
			for (Object backendResponse : args) {
				Map<String, List<FieldModel>> tags = ((ResponseData) backendResponse).getTags();

				for (Map.Entry<String, List<FieldModel>> entry : tags.entrySet()) {
					String key = entry.getKey();
					List<FieldModel> fieldModelList = entry.getValue();

					for (FieldModel fieldModel : fieldModelList) {
						accountResponse.addFieldModel(key, fieldModel);
					}
				}
			}
			return accountResponse;
		});
	}
}
