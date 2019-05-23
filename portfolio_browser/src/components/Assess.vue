<template>
<el-container>
  <el-main>
    <h3>风险偏好评估</h3>
    <span>请您填写以下问卷，便于我们为您推荐更适合的投资组合，数据将被严格保密</span>
    <el-card style="margin-left: 20%;width: 60%; margin-top: 10px">
    <el-form ref="form" :model="form" style="text-align: left; ">
      <el-form-item label="1.(个人状况)您的年龄介于">
        <el-radio-group v-model="sheet.q1">
          <el-radio :label="0"><=18岁</el-radio>
          <el-radio :label="1">19-25岁</el-radio>
          <el-radio :label="2">26-40岁</el-radio>
          <el-radio :label="3">41-54岁</el-radio>
          <el-radio :label="4">55-64岁</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="2.(个人状况)您的最高学历是">
        <el-radio-group v-model="sheet.q2">
          <el-radio :label="0">初中</el-radio>
          <el-radio :label="1">高中及同等学历</el-radio>
          <el-radio :label="2">本科及以上</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="3.(财务状况）依据您目前的状况，以下哪项最符合您和您的家庭对未来自身5年的预期收入：">
        <el-radio-group v-model="sheet.q3">
          <el-radio :label="0">快速增长</el-radio>
          <el-radio :label="1">缓慢增长</el-radio>
          <el-radio :label="2">维持稳定</el-radio>
          <el-radio :label="3">不确定</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="4（财务状况）以人民币计算，您的家庭净资产总值（不包括自用住宅和私营企业等实业投资，但包括储蓄、现有投资组合、房地产投资、人寿保险、固定收入，同时扣除债务如房屋贷款、其他贷款、信用账单等）介于：">
        <el-radio-group v-model="sheet.q4">
          <el-radio :label="0">>=100万元</el-radio>
          <el-radio :label="1">70-99万元</el-radio>
          <el-radio :label="2">50-69万元</el-radio>
          <el-radio :label="3">16-49万元</el-radio>
          <el-radio :label="4"><=15万元</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="5.(财务状况）您是否有是否有尚未清偿的数额较大的债务（数额较大指余额超过资产净值30%以上），如有，其性质是：">
        <el-radio-group v-model="sheet.q5">
          <el-radio :label="0">无</el-radio>
          <el-radio :label="1">仅有银行发放的住房性抵押贷款</el-radio>
          <el-radio :label="2">以银行发放的信用贷款为主</el-radio>
          <el-radio :label="3">以银行机构提供的短期融资为主</el-radio>
          <el-radio :label="4">以亲友借款为主</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="6.(财务状况）您的净资产中，可用于金融投资（储蓄存款除外）的比例是多少？">
        <el-radio-group v-model="sheet.q6">
          <el-radio :label="0">>70%</el-radio>
          <el-radio :label="1">50%-70%</el-radio>
          <el-radio :label="2">30%-50%</el-radio>
          <el-radio :label="3">10%-30%</el-radio>
          <el-radio :label="4"><10%</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="7.(财务状况）您未来5年内需要扶养、抚养和赡养的，及无稳定收入（或有稳定收入，但收入无法满足日常生活开支）的人员数量：">
        <el-radio-group v-model="sheet.q7">
          <el-radio :label="0">1-2人</el-radio>
          <el-radio :label="1">3-4人</el-radio>
          <el-radio :label="2">5人及以上</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="8.(投资经验）以下哪项最符合对您投资经验的投资描述？">
        <el-radio-group v-model="sheet.q8">
          <el-radio :label="0">对金融产品及其风险有充分理解，大部分金融投资集中于权证、期货期权等产品的交易</el-radio>
          <el-radio :label="1">对金融产品及其风险有充分理解，大部分金融投资集中于股票、基金、贵金属等产品的交易</el-radio>
          <el-radio :label="2">对金融产品及其风险有基本理解，大部分金融投资集中于股票、基金、银行理财、信用债等产品</el-radio>
          <el-radio :label="3">对金融产品有基本理解，大部分投资集中于国债和存款</el-radio>
          <el-radio :label="4">除银行存款外，几乎没有其他投资</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="9.(投资经验）一位客户一个月内做了15笔交易（同一产品、同一品种买卖各一次算一笔），您认为交易频率：">
        <el-radio-group v-model="sheet.q9">
          <el-radio :label="0">偏低</el-radio>
          <el-radio :label="1">正常</el-radio>
          <el-radio :label="2">无所谓</el-radio>
          <el-radio :label="3">偏高</el-radio>
          <el-radio :label="4">太高</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="10.(投资经验）您在过去一年内购买金融产品的数量：">
        <el-radio-group v-model="sheet.q10">
          <el-radio :label="0">13个以上</el-radio>
          <el-radio :label="1">7-12个</el-radio>
          <el-radio :label="2">4-6个</el-radio>
          <el-radio :label="3">1-3个</el-radio>
          <el-radio :label="4">0个</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="11.(投资风格）对您而言，保本比追求高收益更为重要：">
        <el-radio-group v-model="sheet.q11">
          <el-radio :label="0">非常不同意</el-radio>
          <el-radio :label="1">不同意</el-radio>
          <el-radio :label="2">无所谓</el-radio>
          <el-radio :label="3">同意</el-radio>
          <el-radio :label="4">非常同意</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="12.(投资风格）您和您的家庭希望将金融产品投资及回报用于：">
        <el-radio-group v-model="sheet.q12">
          <el-radio :label="0">迅速获得高收益，大幅度改善生活</el-radio>
          <el-radio :label="1">在个人经营或证券投资之外，实现投资增值</el-radio>
          <el-radio :label="2">获得股息、分红等</el-radio>
          <el-radio :label="3">养老、医疗或育儿</el-radio>
          <el-radio :label="4">偿讨债务</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="13.(投资风格）您打算重点投资于哪种金融产品？">
        <el-radio-group v-model="sheet.q13">
          <el-radio :label="0">参与私募股权投资、创业投资等</el-radio>
          <el-radio :label="1">期货期权、融资融券等</el-radio>
          <el-radio :label="2">股票、基金、贵金属等收益率波动较大的资产岁</el-radio>
          <el-radio :label="3">中等风险一下的理财</el-radio>
          <el-radio :label="4">国债、货币市场基金等低风险资产</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="14.(投资风格）综合收益和风险，如果您有100万资金，您最愿意如何安排您的投资？投资A：较大可能获取5%收益，可能承担的本金损失较小，投资B：较小可能获取30%收益，可能承担的本金损失较大">
        <el-radio-group v-model="sheet.q14">
          <el-radio :label="0">全部投资于B</el-radio>
          <el-radio :label="1">大部分投资于B，小部分投资于A</el-radio>
          <el-radio :label="2">各投一半</el-radio>
          <el-radio :label="3">大部分投资于A，小部分投资于</el-radio>
          <el-radio :label="4">全部投资于A</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="15.(风险偏好）对于理财产品、股票、基金等金融产品，您可以接受的最长投资期限为：">
        <el-radio-group v-model="sheet.q15">
          <el-radio :label="0">>=5年</el-radio>
          <el-radio :label="1">3-4年</el-radio>
          <el-radio :label="2">1-2年</el-radio>
          <el-radio :label="3">1年以内</el-radio>
          <el-radio :label="4">无所谓</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="16.(风险偏好）对您而言，理财产股票、基金等投资出现哪种情况时您会焦虑？">
        <el-radio-group v-model="sheet.q16">
          <el-radio :label="0">本金损失50%以上</el-radio>
          <el-radio :label="1">本金损失30%-50%</el-radio>
          <el-radio :label="2">本金损失10%-30%</el-radio>
          <el-radio :label="3">本金损失10%以内</el-radio>
          <el-radio :label="4">本金无损失，但收益未达预期</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="17.（风险偏好）您对长期投资收益和风险所持的态度是：">
        <el-radio-group v-model="sheet.q17">
          <el-radio :label="0">我希望承担风险，愿意为获得较高收益而承受较大的负面波动，能够承担本金损失</el-radio>
          <el-radio :label="1">我能够承担风险，愿意接受一定范围内的负面波动以提高投资的潜在收益，能够承担部分本金损失</el-radio>
          <el-radio :label="2">我对风险的态度一般，愿意为较高潜在收益接受较小的负面波动</el-radio>
          <el-radio :label="3">我希望避免风险，愿意为较高潜在收益接受轻微的负面波动</el-radio>
          <el-radio :label="4">我不愿承担风险，也不能接受投资的价值下跌</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="18. 您认为您是有经验的投资者还是无经验的投资者：">
        <el-radio-group v-model="sheet.q18">
          <el-radio :label="0">有经验的投资者：曾投资于股票、股票型基金、外汇及其衍生品、贵金属及其衍生品、投资于股票/股指的非保本理财产品、或与利率、汇率、股票、股指、信用、商品等挂钩的非保本结构性理财产品，且累计投资期限在两年以上</el-radio>
          <el-radio :label="1">无经验的投资者：未投资于上述产品，或投资于上述产品不满两年</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitSheet">立即提交</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
    </el-card>
  </el-main>
</el-container>
</template>

<script>
    import ElContainer from "element-ui/packages/container/src/main";
    import ElHeader from "element-ui/packages/header/src/main";
    import ElCard from "element-ui/packages/card/src/main";

    export default {
      components: {
        ElCard,
        ElHeader,
        ElContainer},
      name: "assess",
      data(){
        return{
          sheet:{
            q1:'',
            q2:'',
            q3:'',
            q4:'',
            q5:'',
            q6:'',
            q7:'',
            q8:'',
            q9:'',
            q10:'',
            q11:'',
            q12:'',
            q13:'',
            q14:'',
            q15:'',
            q16:'',
            q17:'',
            q18:'',
          }
        }
      },
      methods:{
        submitSheet:function () {
          var xmlhttp = new XMLHttpRequest();
          var _this = this;
          xmlhttp.onreadystatechange = function () {
            if(xmlhttp.readyState===4&&xmlhttp.status===200){
              alert('已提交');
            }
          }
          xmlhttp.open('GET','http://localhost:8082/user/submitSheet',false);
          xmlhttp.setRequestHeader("Content-type", "application/json; charset=utf-8");
          xmlhttp.send();
        }
      }
    }
</script>

<style scoped>
  .el-main {
    background-color: #E9EEF3;
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
</style>
