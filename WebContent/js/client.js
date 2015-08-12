$(".jsonbutton").click(function() {
	var jsondata =1;
//	{
//		"clubs" : {
//			"id" : "1",
//			"name" : "外面",
//			"members" : [ {
//				"name" : "王",
//				"password" : 1234567
//			}, {
//				"name" : "12",
//				"password" : 123456
//			} ]
//		}
//
//	};
	$.ajax({
		url : "ChatServlet",// 设置请求地址
		type : "POST",// 设置请求方式
		data : jsondata,// 设置传递的数据，要求为Object或String类型的参数
		dateType : "json",// 设置服务器返回数据的类型
		// 设置请求成功时执行的回调函数
		success : function(data) {
			alert(data);
			console.log(data);
			alert("发送成功！");

		},
		error : function() {
			alert("请求失败！");
		}
	});
});
