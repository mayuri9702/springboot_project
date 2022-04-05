import { Component, OnInit } from '@angular/core';
import { Person } from '../person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-display-all-persons',
  templateUrl: './display-all-persons.component.html',
  styleUrls: ['./display-all-persons.component.css']
})
export class DisplayAllPersonsComponent implements OnInit {

  persons:Person[]=[];
  constructor(private personService: PersonService) { }

  ngOnInit(): void {

    this.personService.getAllPersons().subscribe((res) => {
      this.persons = res;
      console.log(JSON.stringify(this.persons));
    });
  }

}
