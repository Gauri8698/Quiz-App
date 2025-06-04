import { Component } from '@angular/core';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { UserStorageService } from './modules/auth/services/user-storage.service';
import { CommonModule } from '@angular/common';
import { SharedModule } from './modules/shared/shared.module';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SharedModule,CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'quizWeb';

  isUserLoggedIn: boolean = UserStorageService.isUserLoggedIn();
  isAdminLoggedIn: boolean = UserStorageService.isAdminLoggedIn();

  constructor(private router: Router){}
  
  ngOnInit(){
    this.router.events.subscribe(event =>{
        this.isUserLoggedIn=UserStorageService.isUserLoggedIn();
        this.isAdminLoggedIn=UserStorageService.isAdminLoggedIn();
      
    })
  }

  logout(){
    UserStorageService.signOut();
    this.router.navigateByUrl('login');
  }
}



