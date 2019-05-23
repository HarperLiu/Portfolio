import Vue from 'vue'
import Router from 'vue-router'
import Workspace from '@/components/Workspace'
import Login from '@/components/Login'
import Index from '@/components/Index'
import Assess from '@/components/Assess'
import AboutUs from '@/components/AboutUs'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/:username/Workspace',
      name: 'Workspace',
      component: Workspace
    },
    {
      path: '/Index',
      name: 'Index',
      component: Index
    },
    {
      path: '/Assess',
      name: 'Assess',
      component: Assess
    },
    {
      path: '/AboutUs',
      name: 'AboutUs',
      component: AboutUs
    },
  ]
})
