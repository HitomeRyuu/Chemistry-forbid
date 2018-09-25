# Chemistry-forbid   

The EXCEL file must be like the sample picture:  

![image](https://github.com/HitomeRyuu/Chemistry-forbid/blob/master/images/sample.png)

Use step  

first, use the py file to extract the chemistery forbid rules,  

second, put the rules in JAVA project  

that is:  

new a fold named resource, put the rule in.

API：http://localhost:8080/graph  
input data must be like this：  

 [{"id":1,
	"name":"化学品a",
	"类型数组":[
		"卤代烯烃",
		"金属氨基化物"]
	},
{"id":2,
	"name":"化学品b",
	"类型数组":[
		"炔烃",
		"氧化剂"]
	},
{"id":3,
	"name":"化学品c",
	"类型数组":[
		"炔烃",
		"氨"]
	}
]  
out put should be:  
 {
        "changeEdge": [
            {
                "a": "卤代烯烃",
                "b": "炔烃",
                "c": 1
            }
        ],
        "type1": "炔烃",
        "type2": "卤代烯烃"
    },  
    

