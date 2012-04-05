<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://informatics.mayo.edu/cts2/framework#beans"
	prefix="beans"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<c:if test="${map != null}">
	
		<c:forEach var="i" items="${map}">

			<c:if test="${i.key != null and i.value != null and i.key != '_anyObject' and i.key != '_choiceValue' }">
		
				<c:if test="${fn:endsWith(i.key, 'List')}">
					<c:if test="${i.value.size() > 0}">
						<ul class="collapsibleList">
							<li><span class="name"><c:out value="${ beans:capitalize( fn:substring(i.key, 1, -1) ) }"></c:out> ( <c:out value="${ i.value.size() }"/>
							<c:if test="${ i.value.size() == 1 }">
							entry
							</c:if>
							<c:if test="${ i.value.size() > 1 }">
							entries
							</c:if>
							)
							</span>
							<ul>
								<c:forEach var="j" items="${i.value}">
									<li>
										<span class="name"><c:out value="${ beans:capitalize( fn:substring( fn:substringBefore(i.key, 'List') , 1, -1) ) }"></c:out>:</span>
										<c:if test="${beans:shouldRecurse( j )}">
											<c:set var="map" value="${beans:inspect( j ) }"
												scope="request" />
											<jsp:include page="node.jsp" />
										</c:if> 
										<c:if test="${ not beans:shouldRecurse( j )}">
											<c:out value="${j}"></c:out>
										</c:if>
									</li>
								</c:forEach>
							</ul>
							</li>
						</ul>
					</c:if>
				</c:if>
				<c:if test="${not fn:endsWith(i.key, 'List')}">
					<ul>
						<li><span class="name"><c:out value="${ beans:capitalize( fn:substring(i.key, 1, -1) ) }"></c:out>:</span>
					
						<c:if test="${beans:shouldRecurse(i.value)}">
								<c:set var="map" value="${beans:inspect( i.value) }"
									scope="request" />
								<jsp:include page="node.jsp" />
						</c:if> 
						<c:if test="${ not beans:shouldRecurse(i.value)}">					
							<c:if test="${ i.key eq '_href' }" >
								<a href="${i.value}">
								<c:out value="${i.value}"></c:out>
								</a>
							</c:if>
							<c:if test="${ i.key ne '_href' }" >
								<c:out value="${i.value}"></c:out>
							</c:if>		
						</c:if>
						</li>
					</ul>
				</c:if>
		
			</c:if>
		</c:forEach>
	
</c:if>