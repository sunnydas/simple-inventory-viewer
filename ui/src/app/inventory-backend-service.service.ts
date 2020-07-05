import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InventoryBackendServiceService {
	
	private INVENTORY_BACKEND_API_BASE_URL = environment.back_end_url_scheme.concat("://",environment.backend_host_name,":",environment.back_end_port_num,environment.backend_inv_resource) 

	constructor(private httpClient: HttpClient) { }
  
	public sendGetRequest(page,size){
		let httpParams = new HttpParams().set('page', String(page));
        httpParams = httpParams.set('size', String(size));
		var response = this.httpClient.get(this.INVENTORY_BACKEND_API_BASE_URL,{
          params: httpParams
        });
		console.log(" response " + response);
		return response;
	}
}
