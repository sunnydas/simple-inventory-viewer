import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InventoryTableComponent } from './inventory-table/inventory-table.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule} from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';  
import { MatCardModule } from '@angular/material/card';  
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';  
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';  
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    InventoryTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatProgressSpinnerModule,
	HttpClientModule,
	MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
