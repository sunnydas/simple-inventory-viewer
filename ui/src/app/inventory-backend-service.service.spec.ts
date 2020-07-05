import { TestBed } from '@angular/core/testing';

import { InventoryBackendServiceService } from './inventory-backend-service.service';

describe('InventoryBackendServiceService', () => {
  let service: InventoryBackendServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InventoryBackendServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
