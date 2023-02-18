import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Forgotpasswordway1Component } from './forgotpasswordway1.component';

describe('Forgotpasswordway1Component', () => {
  let component: Forgotpasswordway1Component;
  let fixture: ComponentFixture<Forgotpasswordway1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Forgotpasswordway1Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Forgotpasswordway1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
