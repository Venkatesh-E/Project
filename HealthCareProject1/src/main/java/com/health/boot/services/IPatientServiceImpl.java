package com.health.boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.boot.entities.Patient;
import com.health.boot.entities.TestResult;
import com.health.boot.exceptions.PatientExistException;
import com.health.boot.exceptions.PatientNotFoundException;
import com.health.boot.repository.PatientRepository;

@Service
public class  IPatientServiceImpl implements IPatientService{
	
	@Autowired
	PatientRepository pr;

	@Override
	public Patient registerPatient(Patient patient) throws RuntimeException {
		if(pr.findById(patient.getPatientId()).isPresent())
			throw new PatientExistException("Patient is already exist with the same Id");
		return pr.save(patient);
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		if(!pr.findById(patient.getPatientId()).isPresent())
			throw new PatientNotFoundException("Patient is Not Found to Update");
		return pr.save(patient);
	}

	@Override
	public Patient viewPatient(String patientUserName) {
		
		Patient p = pr.findPatientByName(patientUserName);
		if(p==null)
			throw new PatientNotFoundException("Patient is Not Found TO View it.");
		return p;
	}

	@Override
	public List<TestResult> getAllTestResult(String patientUserName) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestResult viewTestResult(int testResultId) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
