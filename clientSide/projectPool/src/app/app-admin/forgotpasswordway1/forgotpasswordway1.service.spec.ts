import { TestBed } from '@angular/core/testing';

import { Forgotpasswordway1Service } from './forgotpasswordway1.service';

describe('Forgotpasswordway1Service', () => {
  let service: Forgotpasswordway1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Forgotpasswordway1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
