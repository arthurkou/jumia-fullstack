import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/common/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];
  searchMode: boolean = false;

  constructor(private customerService: CustomerService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listCustomer();
    })
  }

  listCustomer() {

    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    if (this.searchMode) {
      this.handleSearchCustomers();
    }
    else {
      this.handleListCustomers();
    }
  }

  handleSearchCustomers() {
    const theKeyword = this.route.snapshot.paramMap.get('keyword') as string;
    this.customerService.searchCustomers(theKeyword).subscribe(
      data => this.customers = data      
    )
  }

  handleListCustomers() {
    this.customerService.getCustomerList().subscribe(
      data =>{
          this.customers = data;
    }
   )
  }
}


