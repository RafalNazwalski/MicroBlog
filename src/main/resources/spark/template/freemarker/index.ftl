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
                                                <h3>Logowanie</h3>
                                        </div>
                                        <div class="panel-body">
                                                <form action="/" method="post" class="form-horizontal">
                                                        <div class="form-group">
                                                                <label class="col-lg-2 control-label">Login:</label>
                                                                <div class="col-lg-8">
                                                                        <input type="text" name="login" class="control-label" placeholder="Login..." />
                                                                </div>
                                                        </div>
                                                        <div class="form-group">
                                                                <label class="col-lg-2 control-label">Hasło:</label>
                                                                <div class="col-lg-8">
                                                                        <input type="password" name="password" placeholder="Hasło..." class="control-label" />
                                                                </div>
                                                        </div>
                                                        <div class="row">
                                                                <div class="col-lg-2 col-lg-offset-8">
                                                                        <input type="submit" class="btn btn-success" value="Zaloguj" />
                                                                </div>
                                                        </div>
                                                </form>
                                        </div>
                                </div>
                                Nie masz konta? <a href="register">Zarejestruj się</a>
                        </div>
                </div>
        </div>
</body>
</html>