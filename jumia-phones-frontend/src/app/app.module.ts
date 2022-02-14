import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerService } from './services/customer.service';
import { SearchComponent } from './components/search/search.component';
import { StateComponent } from './components/state/state.component';

const routes: Routes = [
  {path: '', component: CustomerListComponent},
  {path: 'search/country/:keyword', component: CustomerListComponent},
  {path: 'search/state/:keyword', component: StateComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    SearchComponent,
    StateComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
