<template>
  <div id="app">
    <el-header>
      <el-menu
        :default-active=1
        class="el-menu-demo"
        mode="horizontal"
        @select="handleRoute"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        style="width: available; margin: 0 -20px; ">
        <el-menu-item index="0">
          <template>
            <img src="./assets/logo.png" style="width: 50px;height: 50px">
          </template>
        </el-menu-item>
        <el-menu-item index="1">首页</el-menu-item>
        <el-menu-item index="2">资产管理</el-menu-item>
        <el-menu-item index="3">风险评估</el-menu-item>
        <el-menu-item index="4">关于我们</el-menu-item>
        <el-menu-item style="margin-left: 660px;">
          <span style="font-size: 15px; font-weight: bold">{{setUser}}</span>
        </el-menu-item>
        <el-menu-item>
          <template>
            <el-dropdown @command="handleCommand">
              <i class="el-icon-setting"></i>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="refresh"><i class="el-icon-refresh"></i>刷新数据</el-dropdown-item>
                <el-dropdown-item command="logout"><i class="el-icon-back"></i>退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </template>
        </el-menu-item>
      </el-menu>
    </el-header>
    <router-view/>
  </div>
</template>

<script>
  import Workspace from './components/Workspace.vue'
  import Login from './components/Login.vue'
  import ElImage from "element-ui/packages/image/src/main";
export default {
  name: 'App',
  data(){
    return{
    }
  },
  computed:{
    setUser:function () {
      console.log(localStorage.getItem('username'))
      if(localStorage.getItem('username')===null||localStorage.getItem('username')==='undefined'){
        return '未登录'
      }
      else{
        return localStorage.getItem('username')
      }
    }
  },
  components:{
    ElImage,
    Workspace,
    Login
  },
  methods:{
    handleRoute:function (index) {
      console.log(localStorage.getItem('username'))
      if(localStorage.getItem('username')===null||localStorage.getItem('username')==='undefined'){
        this.$notify({
          title:'请先登录',
          message:'登录后使用更多功能',
          type:'warning',
          duration:2000,
          position: 'top-left'
        })
      }
      else{
        var path = '';
        switch (index){
          case '0':{
            path = '/index';
            break;
          }
          case '1':{
            path = '/index';
            break;
          }
          case '2':{
            path = localStorage.getItem('username')+'/Workspace';
            break;
          }
          case '3':{
            path = '/assess';
            break;
          }
          case '4':{
            path = '/aboutUs';
          }
        }
        this.$router.push(path,path);
      }

    },
    handleCommand:function (command) {
      if(command==='refresh'){
        this.drawRateChart();
        this.drawPropertyChart();
      }
      if(command==='logout'){
        localStorage.setItem('username',undefined);
        localStorage.setItem('userId',undefined);
        var path = '/';
        this.$router.push({path,path});
        window.location.reload()
      }
    },

  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
