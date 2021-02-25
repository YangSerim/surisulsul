package study.spring.surisulsul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import study.spring.surisulsul.helper.WebHelper;
import study.spring.surisulsul.model.Product;
import study.spring.surisulsul.service.CscenterService;

@Slf4j
@Controller
public class ManageCscenterController {
	
	/** Service 패턴 구현체 주입 */
	
	/** WebHelper 주입 */
	@Autowired
	WebHelper webHelper;
	
	@Autowired
	CscenterService cscenterService;
	
	
	/** 프로젝트 이름에 해당하는 ContextPath 변수 주입 */
	@Value("#{servletContext.contextPath}")
	String contextPath;
	
	/** manage_cscenter 페이지 처리 */
	@RequestMapping(value = "/manage_cscenter.do", method = RequestMethod.GET)
	public ModelAndView manage_cscenter(Model model) throws Exception {
		
		return new ModelAndView("manage/manage_cscenter");
	}
	
	/** 알립니다 & FAQ insert  */
	@RequestMapping(value="/manage_cscenter_add.do", method=RequestMethod.GET)
	public ModelAndView cecenter_add(Model model,
			@RequestParam(value="id", defaultValue="0") int id,
			@RequestParam(value="type", required = false) String type,
			@RequestParam(value="title", required = false) String title,
			@RequestParam(value="content", required = false) String content,
			@RequestParam(value="reg_date", required = false) String reg_date,
			@RequestParam(value="edit_date", required = false) String edit_date)  
	
	{
		
		
		
		
		return new ModelAndView("/manage/manage_cscenter_add");
	}
	
	/** 알립니다 & FAQ 수정 */
	@RequestMapping(value="/manage_cscenter_edit.do", method=RequestMethod.GET)
	public ModelAndView cscenter_edit(Model model)  throws Exception {
		
		return new ModelAndView("/manage/manage_cscenter_edit");
	}
	
	/** 알립니다 & FAQ 삭제 */
	@RequestMapping(value="/manage_cscenter_delete.do", method=RequestMethod.POST)
	public ModelAndView cscenter_delete(Model model)  throws Exception {
		
		return new ModelAndView("redirect:/manage_cscenter.do");
	}
	
	
}
