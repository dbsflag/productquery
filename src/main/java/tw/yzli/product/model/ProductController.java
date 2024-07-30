package tw.yzli.product.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pService;
	
	@GetMapping("/productquerymainaction.controller")
	public String processQueryMainAction() {
		return"product/productQueryAll";
	}
	
	//根據ID查詢產品
	@GetMapping("/query/{pid}")
	@ResponseBody
	public Product processQueryByIdAction(@PathVariable("pid") Integer id) {
		return pService.findById(id);
	}
	
	//查全部的產品
	@GetMapping("queryall")
	@ResponseBody
	public List<Product> processQueryAll(){
		return pService.findAll();
	}
	
	//create or update，接受 HTTP GET 請求，根據傳入的參數來更新或創建產品，然後將其保存到資料庫中
	@GetMapping("/save")
	@ResponseBody
	public String save(Integer pid, String pName, String pPrice, String pDate, String note) {
		System.out.println("pid= "  + pid);
		System.out.println("pName= "  + pName);
		System.out.println("pPrice= "  + pPrice);
		System.out.println("pDate= "  + pDate);
		System.out.println("note= "  + note);
		
		Product product = pService.findById(pid);
		System.out.println("product= "  + product); //tostring (product.java那邊)

		if(product == null) {
			product = new Product();
			product.setPid(pid);
		}
		product.setNote(note);
		product.setPname(pName);
		product.setPrice(Integer.parseInt(pPrice));
		
		 // pDate 設置日期
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date parsedDate = dateFormat.parse(pDate);
	        product.setPdate(parsedDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return "Invalid date format. Please use yyyy-MM-dd.";
	    }
		pService.insert(product);
		

		return "OK";
	}

	//查詢按鈕 根據id查詢產品並顯示在欄位
	@GetMapping("/loadProduct")
	@ResponseBody
	public Product loadProduct(Integer pid) {
		return pService.findById(pid);
	}
	
	//根據id刪除
	@PostMapping("/deleteById")
	public void deleteById(int id) {
		Product p = pService.findById(id);
		pService.delete(p);
	}
	
	//分頁查詢
	@GetMapping("/queryByPage/{pageNo}")
	@ResponseBody //回傳json格式陣列
	public List<Product> processQueryByPageAction(@PathVariable("pageNo") int pageNo, String product,  Model m, HttpServletRequest request){
		System.out.println("product = " + product);
		HttpSession session=request.getSession();
		int pageSize=17; //每頁顯示的筆數
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); //設定顯示頁碼與每頁筆數
		Page<Product> page=pService.findByPnameLike(product, pageable);
		session.setAttribute("totalPages",page.getTotalPages()); //取得資料總頁數
		session.setAttribute("totalElements",page.getTotalElements()); //取得全部資料筆數
		return page.getContent(); //取得該頁資料內容
		
	}
	
	
	
	
}
