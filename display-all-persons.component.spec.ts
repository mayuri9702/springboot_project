import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayAllPersonsComponent } from './display-all-persons.component';

describe('DisplayAllPersonsComponent', () => {
  let component: DisplayAllPersonsComponent;
  let fixture: ComponentFixture<DisplayAllPersonsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayAllPersonsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayAllPersonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
