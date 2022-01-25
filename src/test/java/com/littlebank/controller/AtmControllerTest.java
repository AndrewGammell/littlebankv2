package com.littlebank.controller;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(AtmController.class)
public class AtmControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AtmController atmController = new AtmController();



	
}
