package item.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import item.db.ItemDAO;

public class ItemInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("ItemInsertAction_execute()--------------");
		
		HttpSession session = request.getSession();
		String id = (String)request.getAttribute("id");
		
		/*if(!id.equals("admin")){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println(	"history.back();");
			out.println("</script>");
		}*/
		
		String fileName="";
		String originalFileName="";
		
		
		String realPath = request.getRealPath("/upload");
		// 업로드할 파일의 크기지정
		int maxSize = 10*1024*1024;
		// MultipartRequest객체 생성
		MultipartRequest multi = new MultipartRequest(
				request,realPath,maxSize,"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		//파일 업로드한 이름을 가져오기
		Enumeration formNames = multi.getFileNames();
		String formName = (String)formNames.nextElement();
		//자료가 많을 겨우에는 반복문 사용 처리
		System.out.println(formName);
		//파일의 이름(서버에 올릴때 이름)
		fileName = multi.getFilesystemName(formName);
		
		int pos = fileName.lastIndexOf(".");
		String fileExt = fileName.substring(pos+1);
		
		
		if(!fileExt.equals("png") && !fileExt.equals("jpg") && !fileExt.equals("gif")){
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println(	"alert('이미지파일(png,jpg,gif) 형식의 파일만 업로드 가능합니다')");
			out.println(	"history.back();");
			out.println("</script>");
			
			File f = new File("/upload/"+fileName);
			//파일삭제
			f.delete();
		}
		
		
		
		String item_name = multi.getParameter("item_name");
		int item_price = Integer.parseInt(multi.getParameter("item_price"));
		String item_category = multi.getParameter("item_category");
		int item_amount = Integer.parseInt(multi.getParameter("item_amount"));
		String item_color = multi.getParameter("item_color");
		String item_size = multi.getParameter("item_size");
		int item_saleprice = Integer.parseInt(multi.getParameter("item_saleprice"));
		String item_thumbnail = multi.getParameter("item_thumbnail");
		String item_contentimage = multi.getParameter("item_contentimage");
		
		ItemDAO idao = new ItemDAO();
		idao.insertItem();
		
		
		return null;
	}

}
