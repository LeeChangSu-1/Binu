<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function numberOnly(event){
		if(event.keyCode >= 48 && event.keyCode <= 57){
			return true;
		}else{
			event.returnValue=false;
		}
		
	}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>아이템 등록하기 [관리자]</h1>

<fieldset>
	<form action="ItemInsert.ite" method="post" enctype="multipart/form-data">
		상품이름 <input type="text" name="item_name"><br>
		상품가격 <input type="text" name="item_price" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" placeholder="숫자만입력"><br>
		상품분류 
			<select name="item_category">
				<option value="얼굴비누">얼굴비누</option>
				<option value="몸비누">몸비누</option>
				<option value="머리비누">머리비누</option>
				<option value="발비누">발비누</option>
			</select><br>
		상품 수량<input type="text" name="item_amount" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" placeholder="숫자만입력"><br> // 입력제어
		상품 색상<input type="text" name="item_color" placeholder="(/)슬래쉬 로 구분"><br>
		상품 사이즈 <input type="text" name="item_size" placeholder="(/)슬래쉬 로 구분"><br>
		상품 할인가격<input type="text" name="item_saleprice" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" placeholder="숫자만입력"><br> // 숫자 입력제어
		상품 썸네일 <input type="file" name="item_thumbnail"><br>
		상품 상세설명 이미지 <input type="file" name="item_contentimage">
		
		<input type="submit" value="등록">
		<input type="reset" value="취소">
		
	
	</form>
</fieldset>
</body>
</html>