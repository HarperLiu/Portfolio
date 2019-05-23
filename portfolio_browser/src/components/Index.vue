<template>
  <el-container>
    <el-aside width="300px">
      <div style="background-color: #ffd04b; width: fit-content; padding: 0px 5px">
        <h3 style="text-align: left">市场概况</h3>
      </div>
      <div v-for="index in indexList" :key="index">
        <div>
          <h5 style="display: inline">{{index.code+index.name}}</h5>
          <el-tag :type="index.change<0?'success':'danger'">{{index.change}}</el-tag>
          <div>{{'开盘价 '+index.open}}</div>
        </div>
        <span>{{'收盘价 '+index.close}}</span>
      </div>
    </el-aside>
    <el-main>
      <div style="background-color: #ffd04b; width: fit-content; padding: 0px 5px">
        <h3 style="text-align: left">财经新闻</h3>
      </div>
      <div v-for="news in newsList" :key="news">
        <el-card class="box-card" shadow="hover">
          <div slot="header" class="clearfix">
            <h4 style="display: inline">{{news.title}}</h4>
          </div>
          <div slot="header" class="annotation">
            <span>{{news.ptime}}</span>
            <i class="el-icon-view"></i>
            <span>{{news.rcounts}}</span>
          </div>
          <div class="text item">
            {{news.content}}
          </div>
        </el-card>
      </div>
    </el-main>
  </el-container>
</template>

<script>


  export default {
    components: {},
    name: "index",
    created(){
      this.searchNews();
      this.searchIndex();
    },
    data(){
      return{
        newsList:[{
          title:'南京大学庆祝116岁生日',
          content:'略略略略略略',
          ptime:'5月22日',
          rcounts:100323
        }
        ],
        indexList:[],
      }
    },
    methods:{
      searchNews:function () {
        var xmlhttp = new XMLHttpRequest();
        var _this = this;
        xmlhttp.onreadystatechange = function () {
          if(xmlhttp.readyState===4&&xmlhttp.status===200){
            _this.newsList = JSON.parse(xmlhttp.responseText);
          }
        }
        xmlhttp.open('GET','http://localhost:8082/news/searchNews',false);
        xmlhttp.setRequestHeader("Content-type", "application/json; charset=utf-8");
        xmlhttp.send();
      },
      searchIndex:function () {
        var xmlhttp = new XMLHttpRequest();
        var _this = this;
        xmlhttp.onreadystatechange = function () {
          if(xmlhttp.readyState===4&&xmlhttp.status===200){
            _this.indexList = JSON.parse(xmlhttp.responseText);
          }
        }
        xmlhttp.open('GET','http://localhost:8082/news/searchIndex',false);
        xmlhttp.setRequestHeader("Content-type", "application/json; charset=utf-8");
        xmlhttp.send();
      }
    }
  }
</script>

<style scoped>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
    text-align: center;
    padding-left: 20px;
    padding-top: 20px;

  }

  .el-main {
    border-left: 1px solid #c8c8c9;
    color: #333;
    text-align: center;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .text {
    font-size: 14px;
    text-align: justify;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both;
  }

  .box-card {
    width: available;
    max-height: 200px;
    overflow-y: scroll;
    margin-bottom: 5px;
  }
  .annotation{
    font-size: 10px;
    text-align: right;
    font-weight: lighter;
  }
</style>
