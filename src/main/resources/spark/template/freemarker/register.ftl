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

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
            <div class="panel panel-primary">
                <div class="panel-heading text-center">
                    <h2>Rejestracja</h2>
                </div>
                <div class="panel-body">
                    <form action="/register" method="post" class="form-horizontal">
                        <fieldset>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Imie:</label>
                                <div class="col-lg-8">
                                    <input type="text" name="firstname" class="form-control" />
                                </div>
                                <#if firstNameInvalid??>
                                    <span class="text-danger">
                                        ${firstNameInvalid}
                                    </span>
                                </#if>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Nazwisko:</label>
                                <div class="col-lg-8">
                                    <input type="password" name="lastname" class="form-control" />
                                </div>
                                <#if lastNameInvalid??>
                                    <span class="text-danger">
                                        ${lastNameInvalid}
                                    </span>
                                </#if>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Login:</label>
                                <div class="col-lg-8">
                                    <input type="password" name="login" class="form-control" />
                                </div>
                                <#if loginInvalid??>
                                    <span class="text-danger">
                                        ${loginInvalid}
                                    </span>
                                </#if>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Haslo:</label>
                                <div class="col-lg-8">
                                    <input type="password" name="password" class="form-control" />
                                </div>
                                <#if passwordInvalid??>
                                    <span class="text-danger">
                                        ${passwordInvalid}
                                    </span>
                                </#if>
                            </div>
                            <div class="row">
                                <div class="col-lg-2">
                                    <input type="submit" class="btn btn-success" value="Zarejestruj sie" />
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>