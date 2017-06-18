var userList = {};

$(function(){

});

userList.skipPage = function(){
    var num = $('#pageNum').val();
    if('' == num){
        alert("请输入正确的页码！");
        return false;
    }
    document.location.href=common.getUrl('/user/list?pageNum=' + num);
}