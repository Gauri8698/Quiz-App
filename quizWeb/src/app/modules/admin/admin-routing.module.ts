import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CreateTestComponent } from './components/dashboard/create-test/create-test.component';
import { AddQuestionInTestComponent } from './components/add-question-in-test/add-question-in-test.component';
import { ViewTestComponent } from './components/view-test/view-test.component';
import { ViewTestResultComponent } from '../user/components/view-test-result/view-test-result.component';

const routes: Routes = [
  {path:'dashboard', component:DashboardComponent},
  {path:'create-test', component:CreateTestComponent},
  {path:'add-question/:id', component:AddQuestionInTestComponent},
  {path:'view-test/:id', component:ViewTestComponent},
  {path:'view-test-results', component:ViewTestResultComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
