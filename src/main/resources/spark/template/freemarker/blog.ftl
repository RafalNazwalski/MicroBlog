<!DOCTYPE html>
<html lang="pl">

<head>
    <title>MicroBlog</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <style>
		input[type=checkbox].form-control {
			width: 25px;
			height: 25px;
			display: inline-block;
			vertical-align: -8px;
		}
	</style>
</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">MicroBlog</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="logout">Wyloguj</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-4">
            <div class="panel panel-primary">
                <div class="panel-heading text-center">
                    Uzytkownicy
                </div>
                <div class="panel-body">
                    <div class="row col-lg-12">
                        <div class="form-horizontal">

                            <!--
                                powtarzac dla kazdego uzytkownika
                            -->
                            <#if users??>
                                <#list users as user>
                            <div class="form-group">
                                <div class="col-lg-10">
                                    <h4>${user}</h4>

                                </div>
                                <div>
                                    <input name="IdUzytkownika" class="form-control" type="checkbox">
                                </div>
                            </div>
                                </#list>
                            </#if>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="panel panel-primary">
                <div class="panel-heading text-center">
                    Posty
                </div>
                <div class="panel-body">

                    <div class="row">
                        <div class="col-lg-12">
                            <form action="/blog/addmessage" method="post">
                                <textarea placeholder="Wpisz swoj post..." name="postText" rows="5" class="form-control"></textarea>
                                <br />
                                <input type="submit" value="Wyslij" class="btn btn-success">
                            </form>
                        </div>
                    </div>
                    <div class="row text-center">
                        <hr />
                        <span class="text-info"><b>Posty uzytkownikow</b></span>
                        <hr />

                        <!-- POWTARZAC DLA KAZDEGO POSTA -->
                        <#if messages??>
                        <#list messages as message>
                        <div class="row">

                            <div class="col-lg-12">
                                <span class="text-success"><b>Twój post:</b></span>
                                <textarea name="post" rows="3" class="form-control" disabled>${message}
                                    </textarea>
                            </div>

                        </div>
                        <button class="btn btn-danger" name="ID_POSTU">Usun post</button>
                        <br /><br />
                        </#list>
                        </#if>

                        <!-- POWTARZAC DLA KAZDEGO POSTA -->

                        <!-- POWTARZAC DLA KAZDEGO POSTA -->

               <#--         <div class="row">
                            <div class="col-lg-12">
                                <span class="text-success"><b>Nazwa Autora postu</b></span>
                                <textarea name="post" rows="3" class="form-control" disabled>TRESC POSTU</textarea>
                            </div>
                        </div>
                        <button class="btn btn-danger" name="ID_POSTU">Usun post</button>
                        <br /><br />-->

                        <!-- POWTARZAC DLA KAZDEGO POSTA -->
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>