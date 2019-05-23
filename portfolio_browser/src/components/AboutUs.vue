<template>
  <el-main>
    <div style="width: 80%; margin-left: 10%">
    <h3>关于我们</h3>
    <h4>项目背景</h4>
    <span>投资组合一直以来都被认为是金融领域最重要的话题之一，而随着金融科技的发展和进步，智能投顾越来越受到广泛的关注与重视，如何借助并利用智能算法管理投资组合以实现高收益低风险的投资配置逐渐成为业界探讨的核心问题之一。</span>
    <h4>项目意义</h4>
    <span>此项目根据投资者的风险承受水平、预期收益目标以及投资风格偏好等要求，运用深度强化学习算法和投资组合优化等理论模型，为用户提供投资参考，并监测市场动态，对资产配置进行自动再平衡，提高资产回报率，从让投资者实现“零基础、零成本、专家级”动态资产投资配置。</span>
    <h4>系统架构</h4>
    <span>采用前后端分离的开发模式。前端采用mvvm架构，引入vue；后台采用jpa和springboot。系统通过搭建node.js运行环境，采用Webstorm、idea、Chrome等开发工具，运用python、html、css、js、java编程语言实现。</span>
    <h4>功能简介</h4>
    <span>主要分为三大功能模块：资产管理、财经资讯、教育园地。资产管理功能主要分为国内市场和海外市场资产管理，通过风险评估推荐个性化资产持有比例，同时使用深度强化学习算法推荐最合适的投资组合。财经资讯功能为用户提供实时的海内外财经资讯，帮助用户及时获取海量财经讯息。教育园地为用户提供全面前沿的金融投资知识，帮助用户掌握更专业的资产管理技巧。</span>
    <h4>小组成员</h4>
    <span>小组成员包括17级计算机与金融工程实验班谢紫漪、何天舒、施沐凡。更多功能敬请期待</span>
    </div>
  </el-main>
</template>

<script>
  export default {
    name: "about-us"
  }
</script>

<style scoped>
  .el-main {
    background-color: #E9EEF3;
    color: #333;
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
  span{
    text-align: left;
  }
  h4{
    text-align: left;
  }
</style>
