package com.example.projectPool.dto;

import java.util.ArrayList;

import com.example.projectPool.entity.SwimmingPool;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwimmingPoolBasicSearchDTO {
	
	private boolean status ;
	private String message ;
	private Iterable<SwimmingPool> pools ;	
}
