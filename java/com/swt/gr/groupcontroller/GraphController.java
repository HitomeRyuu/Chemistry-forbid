package com.swt.gr.groupcontroller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.swt.gr.entity.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
@RestController
@RequestMapping(value="/graph")
public class GraphController {
    private  List<Tempchemy> tempchemyList =Lists.newArrayList();
    @PostMapping(value="")
    List<Type> home(@RequestBody JSONArray inputGroup){


        List<Forbid> changeEdge = new ArrayList<>();
        //储存结果

        for (Object o :inputGroup){
            JSONObject json = (JSONObject) JSON.toJSON(o);
            String innerName = json.getString("name");
            JSONArray innerArr = json.getJSONArray("类型数组");
            Tempchemy tempchemy = new Tempchemy();
            tempchemy.setInnerArr(innerArr);
            tempchemy.setInnerName(innerName);
            tempchemyList.add(tempchemy);
        }
        Map<String, List> m1 = new HashMap<>(100);
        //初始化可以存100个化学品的map

        for (Tempchemy tempchemy : tempchemyList) {
            String key = tempchemy.getInnerName();
            JSONArray value = tempchemy.getInnerArr();

            String js = JSONObject.toJSONString(value,SerializerFeature.WriteClassName);
            List<String> listValue = JSONObject.parseArray(js,String.class);
            //jsonarray转array
            m1.put(key, listValue);

        }



        List<Couple> temp2= new ArrayList<>();
        for (String key1 : m1.keySet()) {
            for (String key2 : m1.keySet()) {
                if (!key2.equals(key1)) {
                    temp2.add(Couple.builder().chemy1(m1.get(key1)).chemy2(m1.get(key2)).build());
                    //每个化学品所对应的化学品类的数组进行的两两分组
                }
            }
        }
        int count2=0;

        List<Type> c=new ArrayList<>();

        for (Couple a : temp2) {
            for (int j = 0; j < a.getChemy1().size(); j++) {
                String type3 = String.valueOf(a.getChemy1().get(j));
                for (int k = 0; k < a.getChemy2().size(); k++) {
                    String type4 = String.valueOf(a.getChemy2().get(k));
                    Type t = new Type();
                    t.setChangeEdge(changeEdge);
                    t.setType1(type3);
                    t.setType2(type4);
                    c.add(t);
                    //得到可以输入进引擎的list变量
                }
            }
        }
        System.out.println("反应前："+c);
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kSession = kieContainer.newKieSession("ksession-rules");
        for(Type o:c)
        {
            kSession.insert(o);
            int count1 = kSession.fireAllRules();
            count2+=count1;
            //循环输入，不可和赋值一起循环
        }

        kSession.dispose();
        System.out.println("反应后"+c);
        if (count2==0){
            System.out.println("无反应");
        }
        else {
            System.out.println("有反应"+count2+"次");
        }
        return c;
    }

}



/*String jsonStr = "[\n" +
                "  {\n" +
                "    \"id\": 123,\n" +
                "    \"name\": \"hgw\",\n" +
                "    \"类型数组\": [\n" +
                "      \"type1\",\n" +
                "      \"type2\",\n" +
                "      \"ddfd\"\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 123,\n" +
                "    \"name\": \"123\",\n" +
                "    \"类型数组\": [\n" +
                "      \"type1\",\n" +
                "      \"type2\",\n" +
                "      \"ddfd\"\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        JSONArray arr = JSON.parseArray(jsonStr);*/

