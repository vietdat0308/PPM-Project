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
            $('#fullname').val($(this).closest('tr').find('td:nth-child(2)').text()); 
            $('#address').val($(this).closest('tr').find('td:nth-child(3)').text());           
            $('#sex').val($(this).closest('tr').find('td:nth-child(4)').text());
            $('#dateofbirth').val($(this).closest('tr').find('td:nth-child(5)').text());
            $('#placeofbirth').val($(this).closest('tr').find('td:nth-child(6)').text());
            $('#treatmentid').val($(this).closest('tr').find('td:nth-child(7)').text());
            $('#allergic').val($(this).closest('tr').find('td:nth-child(8)').text());
        });
    });
    
    function myFunction() {
        var x = document.getElementById("id");
        var x1 = document.getElementById("fullname");
        var x2 = document.getElementById("address");
        var x4 = document.getElementById("sex");
        var x5 = document.getElementById("dateofbirth");
        var x6 = document.getElementById("placeofbirth");
        var x7 = document.getElementById("treatmentid");
        var x8 = document.getElementById("allergic");
        x.value=0;
        x1.value="";
        x2.value="";
        x3.value="";
        x4.value="";
        x5.value="";
        x6.value="";
        x7.value=0;
        x8.value="";
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
          Add New Account</button>
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
          <form:form action="addorupdatePatient" method="POST" commandName="userForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Spring MVC Form Demo -
							Registration</h2></td>
				</tr>
				<tr>
					<td>PatientID:</td>
					<td><form:input path="patientid"  id="id" name="id" required="required"/></td>
				</tr>
				<tr>
					<td>Full name:</td>
					<td><form:input path="fullname"  id="fullname" name="fullname" required="required"/></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" id="address" name="address" required="required"/></td>
				</tr>
				<tr>
					<td>Sex:</td>
					<td><form:input path="sex"  id="sex" name="sex" required="required"/></td>
				</tr>
				<tr>
					<td>Date of birth:</td>
					<td><form:input path="dateofbirth" id="dateofbirth" name="dateofbirth"  required="required"/></td>
				</tr>
				<tr>
					<td>Place of birth:</td>
					<td><form:input path="placeofbirth"  id="placeofbirth" name="placeofbirth" required="required"/></td>
				</tr>
				<tr>
					<td>treatmentid:</td>
					<td><form:input path="treatmentid"  id="treatmentid" name="treatmentid" require="required"/></td>
				</tr>
				<tr>
					<td>Allergic:</td>
					<td><form:password path="allergic"  id="allergic" name="allergic" require="required"/></td>
				</tr>
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
                <th>PatientID</th>
				<th>Full name</th>
				<th>Address</th>
				<th>Sex</th>
				<th>Date of birth</th>
				<th>Place of birth</th>
				<th>treamentid</th>
				<th>Allergic</th>
				<th>Function</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
               <th>PatientID</th>
				<th>Full name</th>
				<th>Address</th>
				<th>Sex</th>
				<th>Date of birth</th>
				<th>Place of birth</th>
				<th>treamentid</th>
				<th>Allergic</th>
				<th>Function</th>
                </tr>
              </tfoot>
              <tbody>
 			<c:forEach var="patient" items="${list}">
				<tr>
					<td>${patient.patientid}</td>
					<td>${patient.fullname}</td>
					<td>${patient.address}</td>
					<td>${patient.sex}</td>
					<td>${patient.dateofbirth}</td>
					<td>${patient.placeofbirth}</td>
					<td>${patient.treatmentid}</td>
					<td>${patient.allergic}</td>
					<td ><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myUpdate" id="edit">Update</button></td>
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
          <small>Copyright � Your Website 2018</small>
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
              <span aria-hidden="true">�</span>
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