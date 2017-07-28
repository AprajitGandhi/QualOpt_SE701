import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { ResearcherComponent } from './researcher.component';
import { ResearcherDetailComponent } from './researcher-detail.component';
import { ResearcherPopupComponent } from './researcher-dialog.component';
import { ResearcherDeletePopupComponent } from './researcher-delete-dialog.component';

export const researcherRoute: Routes = [
    {
        path: 'researcher',
        component: ResearcherComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Researchers'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'researcher/:id',
        component: ResearcherDetailComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Researchers'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const researcherPopupRoute: Routes = [
    {
        path: 'researcher-new',
        component: ResearcherPopupComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Researchers'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'researcher/:id/edit',
        component: ResearcherPopupComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Researchers'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'researcher/:id/delete',
        component: ResearcherDeletePopupComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Researchers'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
