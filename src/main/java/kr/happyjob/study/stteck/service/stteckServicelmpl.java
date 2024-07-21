package kr.happyjob.study.stteck.service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.dashboard.model.MonthCompanyDTO;
import kr.happyjob.study.dashboard.model.MonthCompanyVO;
import kr.happyjob.study.dashboard.model.MonthProductDTO;
import kr.happyjob.study.dashboard.model.MonthProductVO;
import kr.happyjob.study.dashboard.model.MonthProfitDTO;
import kr.happyjob.study.dashboard.model.MonthProfitVO;
import kr.happyjob.study.mypqnal.dao.mypqnalDao;
import kr.happyjob.study.mypqnal.model.mypqnalModel;
import kr.happyjob.study.stteck.dao.stteckDao;
import kr.happyjob.study.stteck.model.CompanyPassuserDTO;
import kr.happyjob.study.stteck.model.CompanyPassuserVO;
import kr.happyjob.study.stteck.model.SessionApplyuserDTO;
import kr.happyjob.study.stteck.model.SessionApplyuserVO;
import kr.happyjob.study.stteck.model.SessionCompanyDTO;
import kr.happyjob.study.stteck.model.SessionCompanyVO;
import kr.happyjob.study.stteck.model.stteckModel;


@Transactional
@Service("stteckServiceImpl")
public class stteckServicelmpl implements stteckService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
    stteckDao stteckdao;
    
    
	@Value("${fileUpload.rootPath}")
	private String rootPath;    // W:\\FileRepository
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualrootPath;  // /serverfile
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;   // notice
		
	

	@Override
	public Map<String, Object> getMonthChartData() {
		
		Map<String, Object> map = new HashMap<>();
		
		List<SessionCompanyVO> companyVOList = stteckdao.selectSessionCompany();
		
		List<CompanyPassuserVO> productVOList = stteckdao.selectCompanyPassuser();
//		
		List<SessionApplyuserVO> profitVOList = stteckdao. selectSessionApplyuser();
		
		Iterator<SessionCompanyVO> companyIterator = companyVOList.iterator();
//		
		Iterator<CompanyPassuserVO> productIterator = productVOList.iterator();
//		
		Iterator<SessionApplyuserVO> profitIterator = profitVOList.iterator();
//		
		List<SessionCompanyDTO> companyDTOList = new LinkedList<>();

		List<CompanyPassuserDTO> productDTOList = new LinkedList<>();
//
		List<SessionApplyuserDTO> profitDTOList = new LinkedList<>();
		
		while(companyIterator.hasNext()) {
			SessionCompanyVO vo = companyIterator.next();
			SessionCompanyDTO dto = new SessionCompanyDTO(vo);
			
			companyDTOList.add(dto);
		}
		
		while(productIterator.hasNext()) {
			CompanyPassuserVO vo = productIterator.next();
			CompanyPassuserDTO dto = new CompanyPassuserDTO(vo);
			
			productDTOList.add(dto);
		}
		
		while(profitIterator.hasNext()) {
			SessionApplyuserVO vo = profitIterator.next();
			SessionApplyuserDTO dto = new SessionApplyuserDTO(vo);
			
			profitDTOList.add(dto);
		}
		
		map.put("companyDTOList", companyDTOList);
		map.put("productDTOList", productDTOList);
		map.put("profitDTOList", profitDTOList);
//		
		return map;
	}
	
//	
//	/** 목록 조회 */
//	public List<stteckModel> selectSttList(Map<String, Object> paramMap) throws Exception {
//		
//
//
//		
//		
//		return stteckdao.sttecksearchlist(paramMap);
//				
//	}
	
//		
//	/** 목록 카운트 조회 */
//	public int countquestionlist(Map<String, Object> paramMap) throws Exception {
//				
//		return mypqnaldao.countquestionlist(paramMap);
//	}
//	
//	
//	/** 한건 조회 */
//	public mypqnalModel questionselectone(Map<String, Object> paramMap) throws Exception {
//		
//		return mypqnaldao.questionselectone(paramMap);
//	}
	
//	/** 등록 */
//	public int noticeinsert(Map<String, Object> paramMap) throws Exception {
//		paramMap.put("fileprc", "N");
//		return mypdclDao.noticeinsert(paramMap);
//	}
//	
	
//	/** 수정 */
//	public int mypqnalupdate(Map<String, Object> paramMap) throws Exception {
//		paramMap.put("fileprc", "N");
//		return mypqnaldao.questionupdate(paramMap);
//	}
//	
//	/** 삭제 */
//	public int mypqnaldelete(Map<String, Object> paramMap) throws Exception {
//		return mypqnaldao.questiondelete(paramMap);
//	}
	
//	
//	/** 등록 파일 */
//	public int noticeinsertfile(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
//		
//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//		
		// private String rootPath;    // W:\\FileRepository
		// private String virtualrootPath;  // /serverfile
		// private String noticePath;   // notice
//		
//		String noticedir = File.separator + noticePath + File.separator;
//		FileUtilCho fileup = new FileUtilCho(multipartHttpServletRequest,rootPath, virtualrootPath, noticedir);
//		Map filereturn = fileup.uploadFiles();
//		
//		//map.put("file_nm", file_nm);
//        //map.put("file_size", file_Size);
//        //map.put("file_loc", file_loc);
//        //map.put("vrfile_loc", vrfile_loc);
//        //map.put("fileExtension", fileExtension);
//		
//		String upfile = (String) filereturn.get("file_nm");
//		paramMap.put("fileprc", "Y");
//		
//		if(upfile == "" || upfile == null) {
//			paramMap.put("fileexist", "N");
//		} else {
//			paramMap.put("filereturn", filereturn);
//			paramMap.put("fileexist", "Y");
//			
//			mngNotDao.fileinsert(paramMap);
//		}
//		
//		return mngNotDao.noticeinsert(paramMap);
//	}
//	
//	/** 수정 파일 */
//	public int noticeupdatefile(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
//		
//		NoticeModel selectone = mngNotDao.noticeselectone(paramMap);
//		
//		if(selectone.getFile_name() != "" && selectone.getFile_name() != null) {
//			File attfile = new File(selectone.getPhysic_path());     
//			attfile.delete();
//			
//			//notice_no			
//			// tb_file delete
//			mngNotDao.deletefileinfo(paramMap);
//		} 
//				
//				
//		
//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//				
//		String noticedir = File.separator + noticePath + File.separator;
//		FileUtilCho fileup = new FileUtilCho(multipartHttpServletRequest,rootPath, virtualrootPath, noticedir);
//		Map filereturn = fileup.uploadFiles();
//				
//		String upfile = (String) filereturn.get("file_nm");
//		paramMap.put("fileprc", "Y");
//		
//		if(upfile == "" || upfile == null) {
//			paramMap.put("fileexist", "N");
//		} else {
//			paramMap.put("filereturn", filereturn);
//			paramMap.put("fileexist", "Y");
//			
//			mngNotDao.fileinsert(paramMap);
//		}
//		
//		return mngNotDao.noticeupdatefile(paramMap);		
//		
//	}
//	
//	/** 삭제  파일*/
//	public int noticedeletefile(Map<String, Object> paramMap) throws Exception {
//		
//        NoticeModel selectone = mngNotDao.noticeselectone(paramMap);
//		
//		if(selectone.getFile_name() != "" && selectone.getFile_name() != null) {
//			File attfile = new File(selectone.getPhysic_path());     
//			attfile.delete();
//			
//			//notice_no			
//			// tb_file delete
//			mngNotDao.deletefileinfo(paramMap);
//		} 
//		
//		return mngNotDao.noticedeletefile(paramMap);
	   
	}

