import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-dashboard',
  imports: [SharedModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  tests =[];

  constructor(private notification: NzNotificationService,
              private testService: AdminService
  ){}

  ngOnInit(){
    this.getAllTests();
  }

  getAllTests(){
    this.testService.getAllTest().subscribe(res =>{
      this.tests = res;
    },error =>{
      this.notification
      .error(
        'ERROR',
        `something went wrong. Try Again`,
        {nzDuration: 5000}
      )
    })
  }

  getFormattedTime(time):string{
    const minutes = Math.floor(time/60);
    const seconds = time %60;
    return `${minutes} minutes ${seconds} seconds`;

  }
}
