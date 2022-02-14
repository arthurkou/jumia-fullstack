import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/common/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-state',
  templateUrl: './state.component.html',
  styleUrls: ['./state.component.css']
})
export class StateComponent implements OnInit {

  customers: Customer[] = [];
  searchMode: boolean = false;

  constructor(private customerService: CustomerService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listCustomer();
    })
  }

  listCustomer() {

    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    
    if (this.searchMode) {
      this.handleStateCustomers();
    }
    else {
      this.handleListCustomers();
    }
  }

  handleStateCustomers() {
    const theKeyword = this.route.snapshot.paramMap.get('keyword') as string;
    this.customerService.searchStateCustomers(theKeyword).subscribe(
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
