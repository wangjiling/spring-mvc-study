var common = {
    success : "success",
    error : "error"
};

//得到项目根路径
common.getRootPath = function(){
	var localhostPath;
    var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    if("/" == pathName){
    	localhostPath = curWwwPath.substring(0,curWwwPath.length-1);
    }else{
	    var pos=curWwwPath.indexOf(pathName);
	    localhostPath=curWwwPath.substring(0,pos);
    }
    return localhostPath;
};

//拼装URL
common.getUrl = function(url) {
	var rootPath = common.getRootPath();
	return (rootPath + url);
};

/****数字验证****/
function isNum(str){
    var reg = /\D/;
    return reg.exec(str);
}