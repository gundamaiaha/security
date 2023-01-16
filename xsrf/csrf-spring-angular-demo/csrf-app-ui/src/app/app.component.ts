import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Greeting } from './greeting.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'csrf-app-ui';
  // greeting = { id: 'XXX', content: 'Hello World' };
  // greeting = {};
  greeting!: Greeting;
  constructor(private http: HttpClient) {
    http
      .get<Greeting>('http://localhost:8081/resource')
      .subscribe((data) => (this.greeting = data));
  }
}
