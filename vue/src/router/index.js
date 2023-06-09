import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/login',
    name: 'login',
    hidden: true,
    meta: {
      title: '登录',
    },
    component: () => import('@/view/login/index'),
  },
  {
    /*企业端主页路由*/ path: '/',
    name: '企业端首页',
    component: () => import('@/view/components/CHomeView'),
    redirect: '/login',
    children: [
      { path: 'chomefirst', name: 'CHomeFirst', component: () => import('../companyviews/CHomeFirst') },
      { path: 'companyabout', name: 'CompanyAbout', component: () => import('../companyviews/CompanyAbout') },
      { path: 'certifyview', name: 'CertifyView', component: () => import('../companyviews/CertifyView') },
      // {path: 'companycontact', name: 'CompanyContact', component: () => import('../companyviews/CompanyContact')},
      { path: 'recruitinfo', name: 'RecruitInfo', component: () => import('../companyviews/RecruitInfo') },
      { path: 'resumesearch', name: 'ResumeSearch', component: () => import('../companyviews/ResumeSearch') },
      { path: 'myrecruitment', name: 'MyRecruitment', component: () => import('../companyviews/MyRecruitment') },
      { path: 'personnelmarket', name: 'PersonnelMarket', component: () => import('../companyviews/PersonnelMarket') },
      { path: 'companyinfo', name: 'CompanyInfo', component: () => import('../companyviews/CompanyInfo') },
      { path: 'cmanage', name: 'CManage', component: () => import('../companyviews/CManage.vue') },
      { path: 'cstatistics', name: 'CStatistics', component: () => import('../companyviews/CStatistics.vue') },
      // 新
      { path: 'company-add', name: 'company-add', component: () => import('@/view/company/add.vue') },
      { path: 'company-complain', name: 'company-complain', component: () => import('@/view/company/complain.vue') },
      { path: 'company-index', name: 'company-index', component: () => import('@/view/company/index.vue') },
      { path: 'company-edit', name: 'company-edit', component: () => import('@/view/company/edit.vue') },
      { path: 'recruitment-index', name: 'recruitment-index', component: () => import('@/view/recruitment/index.vue') },
      { path: 'resume-index', name: 'resume-index', component: () => import('@/view/resume/index.vue') },
      { path: 'talent-index', name: 'talent-index', component: () => import('@/view/talent/index.vue') },
    ],
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
