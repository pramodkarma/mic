package server.inspiratti.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.inspiratti.auth.model.Gender;
import server.inspiratti.auth.repository.GenderRepository;



@Service("genderService")
public class GenderServiceImpl implements GenderService{

	@Autowired
	private GenderRepository genderRepository;
	@Override
	public void saveUser(Gender gender) {
		genderRepository.save(gender);
	}

}
