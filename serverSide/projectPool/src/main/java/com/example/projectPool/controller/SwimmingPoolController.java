package com.example.projectPool.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectPool.dto.SwimmingPoolBasicSearchDTO;
import com.example.projectPool.entity.SwimmingPool;
import com.example.projectPool.service.SwimmingPoolService;

@RestController
@RequestMapping("swimmingPool")
@CrossOrigin
public class SwimmingPoolController {

	@Autowired
	private SwimmingPoolService swimmingPoolService ;
	
	//saving
	@PostMapping("save")
	public ResponseEntity<SwimmingPool> save(@RequestBody SwimmingPool swimmingPool)
	{
		return ResponseEntity.ok(swimmingPoolService.save(swimmingPool)) ;
	}
	
	// list by owner
	@GetMapping("list/{username}")
	public ResponseEntity<Iterable<SwimmingPool>> load(@PathVariable String username)
	{
		return ResponseEntity.ok(swimmingPoolService.load(username)) ;
	}	
	
	//find to patch 
	@GetMapping("findPool/{id}")
	public ResponseEntity<Optional<SwimmingPool>> find(@PathVariable Integer id)
	{
		return ResponseEntity.ok(swimmingPoolService.findPool(id)) ;
	}
	
	//update swimming pool details
	@PostMapping("update")
	public ResponseEntity<SwimmingPool> update(@RequestBody SwimmingPool swimmingPool)
	{
		return ResponseEntity.ok(swimmingPoolService.save(swimmingPool));
	}
	
	//basic search by name
	@GetMapping("findPoolByName/{name}")
	public ResponseEntity<SwimmingPoolBasicSearchDTO>findPoolByName(@PathVariable String name)
	{
		return ResponseEntity.ok(swimmingPoolService.findByTitle(name)) ;
	}
}
