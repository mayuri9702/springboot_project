import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonFormComponent } from './person-form/person-form.component';
import {HttpClientModule} from '@angular/common/http';
import { DisplayAllPersonsComponent } from './display-all-persons/display-all-persons.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonFormComponent,
    DisplayAllPersonsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
