package tw.yzli.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.yzli.model.DataBaseProperties;

@RestController
public class DataBasePropertiesController {
	@Autowired
	private DataBaseProperties dbProps;
	@GetMapping("/dbproperties.controller")
	public DataBaseProperties processAction() {
		return dbProps;
	}
}
