import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  state:boolean = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  searchByCountry(value: string) {

    if (Object.keys(value).length === 0) {
      this.getAllCustomers();

    } else {
      this.router.navigateByUrl(`/search/country/${value}`);
    }
  }

  searchByState(value: string) {

    if (Object.keys(value).length === 0) {
      this.getAllCustomers();

    } else {
      this.router.navigateByUrl(`/search/state/${value}`);
    }
  }

  getAllCustomers() {
    this.router.navigateByUrl('/');
  }

}
