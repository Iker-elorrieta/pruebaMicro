package com.microser;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Validated
@RestController
@RequestMapping("producto")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Operation(summary = "lista de productos")
	@ApiResponses(value =  {
			@ApiResponse(responseCode= "200", description="los productos ok"),
			@ApiResponse(responseCode= "204", description="No existen productos")
	})
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> listar()
	{
		List<Producto> pr = productoRepository.findAll();
		
		if(pr.isEmpty())
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.ok(pr);
			
	}
	
	@Operation(summary = "Crear un nuevo Producto y asignar un identificador")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Producto Creado"),
			@ApiResponse(responseCode = "400", description = "campos del producto no son correctos, el nombre min=3 max=250") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@Valid @RequestBody Producto p) {

		productoRepository.save(p);
		URI uri = URI.create(String.format("/producto/%s", p.getId()));
		return ResponseEntity.created(uri).build(); // 201

	}

}
