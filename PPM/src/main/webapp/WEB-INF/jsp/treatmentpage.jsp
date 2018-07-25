<%-- <th>Treatmentid</th>
				<th>history</th>
				<th>prescription</th>
				<th>medicineused</th>
				<th>medicaltestresult</th>
				<th>patientid</th>
				<th>doctorid</th>
				<!-- <th>medicineid</th> -->
                </tr>
              </thead>
              <tfoot>
                <tr>
				<th>Treatmentid</th>
				<th>history</th>
				<th>prescription</th>
				<th>medicineused</th>
				<th>medicaltestresult</th>
				<th>patientid</th>
				<th>doctorid</th>
			<!-- 	<th>medicineid</th> -->
                </tr>
              </tfoot>
              <tbody>
               <c:forEach var="treatment" items="${list}">
				<tr>
					<td>${treatment.treatmentid}</td>
					<td>${treatment.historyofdiseases}</td>
					<td>${treatment.prescription}</td>
					<td>${treatment.medicineused}</td>
					<td>${treatment.medicaltestresult}</td>
					<td>${treatment.patient.patientid}</td>
					<td>${treatment.user.userid}</td>
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<jsp:include page="header.jsp"/>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.js"></script>
<script>
    $(function () {
        $('#dataTable ${"#edit"}').click(function (e) {
            e.preventDefault();
            $('#id').val($(this).closest('tr').find('td:first').text()); 
            $('#historyofdiseases').val($(this).closest('tr').find('td:nth-child(2)').text()); 
            $('#prescription').val($(this).closest('tr').find('td:nth-child(3)').text());           
            $('#medicineused').val($(this).closest('tr').find('td:nth-child(4)').text());
            $('#medicaltestresult').val($(this).closest('tr').find('td:nth-child(5)').text());
            $('#patientid').val($(this).closest('tr').find('td:nth-child(6)').text());
            $('#userid').val($(this).closest('tr').find('td:nth-child(7)').text());
/*             $('#medicineid').val($(this).closest('tr').find('td:nth-child(8)').text()); */
        });
    });
    
    function myFunction() {
        var x = document.getElementById("id");
        var x1 = document.getElementById("historyofdiseases");
        var x2 = document.getElementById("prescription");
        var x3= document.getElementById("medicineused");
        var x4 = document.getElementById("medicaltestresult");
        var x5 = document.getElementById("patientid");
        var x6 = document.getElementById("userid");
   /*      var x7 = document.getElementById("medicineid"); */
        x.value=0;
        x1.value="";
        x2.value="";
        x3.value=1;
        x4.value="";
        x5.value="";
        x6.value="";
/*         x7.value=""; */
    }
</script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="Account">UserName</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Account">
          <a class="nav-link" href="Account">
            <i class="fa fa-fw fa-child"></i>
            <span class="nav-link-text">Accounts</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Patient">
          <a class="nav-link" href="Patient">
            <i class="fa fa-fw fa-vcard"></i>
            <span class="nav-link-text">Patients</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Medicine">
          <a class="nav-link" href="Medicine">
            <i class="fa fa-fw fa-window-maximize"></i>
            <span class="nav-link-text">Medicines</span>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">New Alerts:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all alerts</a>
          </div>
        </li>

        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Account Data Table</li>
      </ol>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myUpdate" 
          id="myBtn" onclick="myFunction()">
          Add New Treatment</button>
          <button type="button" class="btn btn-info btn-lg">PrintPDF</a>
          </button>
          <!-- Trigger the modal with a button -->

 
  
  <!-- ModalUpdate -->
  <div class="modal fade" id="myUpdate" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Information Form</h4>
        </div>
        <div class="modal-body">
          <form:form action="addorupdateTreatment" method="POST" commandName="userForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Spring MVC Form Demo -
							Registration</h2></td>
				</tr>
				<tr>
					<td>Treatment id:</td>
					<td><form:input path="treatmentid"  id="id" name="id" required="required"/></td>
				</tr>
				<tr>
					<td>History:</td>
					<td><form:input path="historyofdiseases"  id="historyofdiseases" name="historyofdiseases" required="required"/></td>
				</tr>
				<tr>
					<td>Prescription:</td>
					<td><form:input path="prescription" id="prescription" name="prescription" required="required"/></td>
				</tr>
				<tr>
					<td>Medicine used:</td>
					<td><form:input path="medicineused"   id="medicineused" name="medicineused" required="required"/></td>
				</tr>
				<tr>
					<td>Medical Testresult:</td>
					<td><form:input path="medicaltestresult"  id="medicaltestresult" name="medicaltestresult" required="required"/></td>
				</tr>
				<tr>
					<td>Patient id:</td>
					<td><form:input path="patient.patientid" id="patientid" name="patientid"  required="required"/></td>
				</tr>
				<tr>
					<td>User id:</td>
					<td><form:input path="user.userid"  id="userid" name="userid" required="required"/></td>
				</tr>
<%-- 				<tr>
					<td>medicine id:</td>
					<td><form:select  path="medicines">
    					<form:option value="NONE"> --SELECT--</form:option>
    					<form:options items="${medicines}"></form:options>
    				</form:select></td>
				</tr>  --%>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>
			</form:form> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  
  
          </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="50%" cellspacing="0">
              <thead>
                <tr>
     		    <th>Treatmentid</th>
				<th>history</th>
				<th>prescription</th>
				<th>medicineused</th>
				<th>medicaltestresult</th>
				<th>patientid</th>
				<th>doctorid</th>
				<th >Test result</th>
				<th >Function</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
              	<th>Treatmentid</th>
				<th>history</th>
				<th>prescription</th>
				<th>medicineused</th>
				<th>medicaltestresult</th>
				<th>patientid</th>
				<th>doctorid</th>
				<th>Test result</th>
				<th>Function</th>
                </tr>
              </tfoot>
              <tbody>
               <c:forEach var="treatment" items="${list}">
				<tr>
					<td>${treatment.treatmentid}</td>
					<td>${treatment.historyofdiseases}</td>
					<td>${treatment.prescription}</td>
					<td>${treatment.medicineused}</td>
					<td>${treatment.medicaltestresult}</td>
					<td>${treatment.patient.patientid}</td>
					<td>${treatment.user.userid}</td>
					<td ><a href='<c:url value="/download/${treatment.patient.patientid}"></c:url>'>Test result</a></td>
					<td ><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myUpdate" id="edit">Update</button>
                  <button type="button" class="btn btn-info btn-lg" style="background-color:red; color:white"><a style="color:white" href="<c:url value='/deleteTreatment?treamentid=${treatment.treatmentid}'></c:url>">Delete</a></button></td>
				</tr>
			</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login">Logout</a>
          </div>
        </div>
      </div>
    </div>
<jsp:include page="footer.jsp"/>
  </div>
</body>

</html>