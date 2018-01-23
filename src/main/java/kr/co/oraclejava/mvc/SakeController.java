package kr.co.oraclejava.mvc;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.oraclejava.spring.jpa.Impression;
import kr.co.oraclejava.spring.jpa.Sake;
import kr.co.oraclejava.spring.jpa.SakeRepository;

@Controller
@RequestMapping("sake")
public class SakeController {
	@Autowired
	private SakeRepository sakeRepository;

	@RequestMapping(value = { "", "list" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("sakelist", sakeRepository.findAll());
		return "sake/index";
	}
	
	@RequestMapping(value="detail/{sakeId}", method=RequestMethod.GET)
	public String detail(@PathVariable("sakeId") int sakeId, Model model) {
		model.addAttribute("sake", sakeRepository.findOne(sakeId));
		model.addAttribute("impression", new Impression());
		model.addAttribute("temperature", sakeRepository.findAllTemp());
		return "sake/detail";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("sake", new Sake());
		model.addAttribute("sakeTypes", sakeRepository.findAllType());
		return "sake/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	//@validated ¥ÎΩ≈ @Valid Ω·¡‡µµ µ 
	public String add(@Validated Sake sake, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("result", "error");
			return add(model);
		}
		sakeRepository.create(sake);
		return "redirect:/sake";
	}
	
	@RequestMapping(value = "writeimp", method = RequestMethod.POST)
	//@validated ¥ÎΩ≈ @Valid Ω·¡‡µµ µ 
	public String writeimp(@Validated Impression impression, BindingResult result, Model model, @RequestParam("sake_id") int sakeId) {
		if (result.hasErrors()) {
			model.addAttribute("result", "error");
			return add(model);
		}
		
		Sake sake = sakeRepository.findOne(sakeId);
		List<Impression> impList = sake.getImpressions();
		impList.add(impression);
		sakeRepository.update(sake);
		return "redirect:/sake" + sakeId;
	}

}
