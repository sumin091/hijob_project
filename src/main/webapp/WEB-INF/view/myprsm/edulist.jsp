<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<c:if test="${totalcnt eq 0 }">
			<div class="resume_linklist_none">데이터가 존재하지 않습니다.</div>
	</c:if>

							
<c:if test="${totalcnt > 0 }">
	<c:forEach items="${resumeFormedulist}" var="list">
			
			<div id="list_set">
				<div id="resume_smallname"><a href="javascript:fn_eduselectone('${list.degree_code}')">${list.degree_school}</a></div>
				<div id="resume_address">${list.degree_major}</div>
			</div>
	</c:forEach>
</c:if>

<input type="hidden" id="totalcnt3" name="totalcnt" value="${totalcnt}">
