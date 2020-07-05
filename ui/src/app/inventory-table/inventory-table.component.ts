import { Component, OnInit } from '@angular/core';
import { InventoryBackendServiceService } from '../inventory-backend-service.service';
import { environment } from '../../environments/environment';
@Component({
  selector: 'app-inventory-table',
  templateUrl: './inventory-table.component.html',
  styleUrls: ['./inventory-table.component.scss']
})
export class InventoryTableComponent implements OnInit {
	
  tableColumns  :  string[] = ['sku', 'name', 'count']; 
  page : number = environment.page_index
  size : number = environment.page_size

  constructor(private inventoryService: InventoryBackendServiceService ) { }

  inventory = [] 
   
  ngOnInit(): void {
	  this.inventoryService.sendGetRequest(this.page.toString(),this.size.toString()).subscribe((data: any[])=>{
      console.log(data);
      this.inventory = data;
    })  
  }
  
  nextPage(){
	this.page += 1;	
	this.inventoryService.sendGetRequest(this.page.toString(),this.size.toString()).subscribe((data: any[])=>{
      console.log(data);
      this.inventory = data;
    })  
  }

  prevPage(){
	this.page = Math.max(this.page - 1,0);	
	this.inventoryService.sendGetRequest(this.page.toString(),this.size.toString()).subscribe((data: any[])=>{
      console.log(data);
      this.inventory = data;
    })  
  }  

}
