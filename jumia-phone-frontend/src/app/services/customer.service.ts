import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../common/customer';
import { catchError, map, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) { }

  getCustomerList() : Observable<Customer[]> {

    const baseUrl = "http://localhost:8000/jumia/customers";
    return this.httpClient.get<Customer[]>(baseUrl);
  }

  searchCustomers(theKeyword: string): Observable<Customer[]>  {
    const searchCountryUrl = `http://localhost:8000/jumia/customers?country=${theKeyword}`;
    return this.httpClient.get<Customer[]>(searchCountryUrl);
  }

  searchStateCustomers(theKeyword: string): Observable<Customer[]> {
    const searchStateUrl = `http://localhost:8000/jumia/customers?state=${theKeyword}`;
    return this.httpClient.get<Customer[]>(searchStateUrl);
  }
}