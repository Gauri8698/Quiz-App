import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { AdminService } from '../../../admin/services/admin.service';

@Component({
  selector: 'app-view-test-result',
  imports: [SharedModule],
  templateUrl: './view-test-result.component.html',
  styleUrl: './view-test-result.component.css'
})
export class ViewTestResultComponent {

  resultsData:any;

  constructor(private testService: AdminService){}

  ngOnInit(){
    this.getTestResult();
  }

  getTestResult(){
    this.testService.getTestResults().subscribe(res=>{
      this.resultsData = res;
      console.log(this.resultsData);
    })
  }
}
