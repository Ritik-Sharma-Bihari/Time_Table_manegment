<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome to Time-Table page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="index.css">
</head>
<body>

<div class="detailed-view-bg-container">

<!-- header part -->

<div class="container ">
       
            <nav class="navbar navbar-expand-lg navbar-blue bg-white ">
                <a class="navbar-brand" href="#">
                    <img class="banaer_image" src="https://www.effe.in/img/customer-logos/vignan.jpg"  />
                </a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    
                    <div class="navbar-nav m-auto">          
                       
                        <h1 class="HEADING" id="menuitem5" style="font-size:20px; color:red;" >VIGNAN INFORMATION MANAGMENT SYSTEM</h1>                     
                    </div>
                    
                    <div class="navbar-nav ml-auto">          
                        <a class="nav-link" id="menuitem5" href="login.jsp" value="login" name="login_type">LOGIN</a>                      
                    </div>
                   
                </div>
            </nav>
      
        </div>
<!-- end of header part -->

<!-- this is body part of home -->
        
        <div class=" d-flex flex-column justify-content-center ">       
           
           <div class="container">
            <div class="detailed-view-card-container ">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://vignan.ac.in/img/slides/image2.jpg" class="d-block w-100" alt="..." />
                        </div>
                        <div class="carousel-item">
                            <img  style="width:1206px; height:545px"  src="https://vignan.ac.in/alumni/images/alumni1.jpg" alt="..." />
                        </div>
                        <div class="carousel-item">
                            <img   style="width:1206px; height:545px"   src="https://www.orchidfoundation.info/sites/default/files/2021-01/vignan%20university.png" class="d-block w-100" alt="..." />
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            </div>
        </div>

<!-- end of body part -->



<!-- botoom part -->
<!--  this is footer section -->

        <div class="footer-section pt-5 pb-5">
            <div class="container-foot">
                <div class="row">
                    <div class="col-12 text-center">
                        <img src="https://www.effe.in/img/customer-logos/vignan.jpg" class="banaer_image" />
                        <h1 class="footer-section-mail-id">vignanguntur@gmail.com</h1>
                        <p class="footer-section-address">
                            pin-code:522213,guntur , vadlamundi
                        </p>
                    </div>
                </div>
            </div>
        </div>

<!-- end of butom part -->

</div>





<!-- javascript part -->
</body>
</html>