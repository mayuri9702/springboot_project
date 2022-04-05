import { Component, OnInit } from '@angular/core';
import { Person } from '../person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent implements OnInit {

person : Person = new Person();

//DI
  constructor(private personService: PersonService) { }

  ngOnInit(): void {
  }

  submitPerson(){
    console.log('form submitted');
    console.log(JSON.stringify(this.person));
    this.personService.addPerson(this.person).subscribe((res) => {
      console.log('user added successfully');
    });
  }
  }


