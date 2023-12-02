<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
::selection {
	background-color: #3490dc;
	/* Change this color to your desired highlight color */
	color: white; /* Change this color to the text color you want */
}

/* Custom styles for alert-success */
.alert-success {
    color: #155724;
    background-color: #d4edda;
    border-color: #c3e6cb;
}

/* Custom styles for alert-danger */
.alert-danger {
    color: #721c24;
    background-color: #f8d7da;
    border-color: #f5c6cb;
}

/* Additional styling for both alert-success and alert-danger */
.alert-success, .alert-danger {
    border-radius: 5px;
    padding: 15px;
    margin-bottom: 20px;
}

/* Responsive styles */
@media (max-width: 575.98px) {
    /* Extra small devices (phones) */
    .alert-success, .alert-danger {
        padding: 10px;
        margin-bottom: 15px;
    }
}

@media (min-width: 576px) and (max-width: 767.98px) {
    /* Small devices (tablets) */
    .alert-success, .alert-danger {
        padding: 12px;
        margin-bottom: 17px;
    }
}

@media (min-width: 768px) and (max-width: 991.98px) {
    /* Medium devices (landscape tablets) */
    .alert-success, .alert-danger {
        padding: 14px;
        margin-bottom: 19px;
    }
}

@media (min-width: 992px) and (max-width: 1199.98px) {
    /* Large devices (desktops) */
    .alert-success, .alert-danger {
        padding: 16px;
        margin-bottom: 21px;
    }
}

@media (min-width: 1200px) {
    /* Extra large devices (large desktops) */
    .alert-success, .alert-danger {
        padding: 18px;
        margin-bottom: 23px;
    }
}

</style>