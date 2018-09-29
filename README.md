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
    
    Since I made github a personal blog, here I want to record the problems and solutions happend during coding this project.
    English version....tbc...XD
    既然当作个人博客了就写点私货吧！记录一下开发过程和其中的问题及解决办法。  
    1、【python提取禁配规则】  
    reference：https://www.jianshu.com/p/642456aa93e2  
    https://blog.csdn.net/cyjs1988/article/details/75041915  
    我是用了anaconda直接下载的openpyxl插件，没有装anaconda的话可能要再去另外下载。  
    一个问题是在表格中循环的时候，英文列名需要先数字化才能进行循环，也就是py文件的第15行内容。
    第二个问题是在一个print函数中，如果想输出字符串+int变量，中间用逗号隔开；如果是字符串+str变量，中间用+隔开。   
    
    2、【Drools循环】  
    由于之前做的demo都是简单的循环所以并没有发生这次的情况，这次由于直接赋值+insert到引擎一起放在了一个循环中，导致了drools无法匹配的问题。查问题时还找到了一个原因是没有用监听“https://developer.jboss.org/thread/194740”， 但是我没有用这个解决方法，我不知道这个listener应该放在哪里，如果有人知道还请赐教。最后的解决方法是把赋值和insert分开在两个循环做，也就是现在程序里的样子。在没有解决这个问题的版本里，是直接得到变量t之后就insert了，现在的版本由于多了一个循环，才引入了变量c。  
    
    3、【Drools程序打包】  
    按照常规方法打包后发现本来能匹配的规则突然就匹配不到了，找全公司的大佬查了2天bug，我自己也在研究drools的官方文档。最后的答案竟然是Drools不识别中文！！！  
    当然还是记录一下过程中大佬们的调试方法：  
    3.1远程调试jar包：在Run-Edit Configuration里面新建一个Remote，复制地址到CMD里面，输入JAVA -jar 地址，再到IDE里面点调试，就能调试jar包了  
    3.2手动移动jar中的文件地址（牛逼  
    3.3移动依赖包的前后顺序ProjectStructure-Modules-Dendencies 选中需要调整的，然后上下移动  
    4、【变量与端口】  
    每次端口调用时需要更新初始化的变量一定要放在端口内部，不能放在类里面但是在端口外面，不然会保存上一次的结果，导致结果越来越多  
    5、【接收与输出】  
    接收数据是Json的时候，会自动转变为对应格式的类，即，如果在POJO中自定义一个对应的输入类，就可以不用解析Json了。  
    输出用ResponseEntity代替，可以一并返回http状态等信息。  
    6、【map取值】  
    如果要get key的同时也get value，可以用entrySet方法，或者Map.foreach（需要用lambda写法）方法，避免使用getkey方法导致多余的循环。  
    7、【大于80行的代码】  
    数据预处理的代码放在Controller类里面，提供服务的代码放在Service类里面。还有多余的用抽象类抽象出去。
    
    
    
    
    

