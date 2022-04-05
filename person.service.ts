import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Person } from './person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  // DI @autowired just by declaring the ref in arg list.
  constructor(private http: HttpClient) { }

  addPerson(person: Person) : Observable<any> {
    return this.http.post("http://localhost:8080/api/person/add",person);
  }

  getAllPersons() : Observable<any>{
    return this.http.get<any>("http://localhost:8080/api/person");
  }

}
