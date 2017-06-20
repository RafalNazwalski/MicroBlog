<!DOCTYPE html>
<html lang="pl">

<head>
	<title>MicroBlog</title>
	<link href="/css/validation.css" rel="stylesheet" type="text/css"/>
	<style type="text/css">
			.textInvalidFields{
		color: red;
	}
	</style>
</head>



<body>
<h1>Rejestracja</h1>
<form action="/register" method="post">
<label>Imie: </label></br>
<input type="text" name="firstname" placeholder="Imie">
<#if firstNameInvalid??>
        <span class="textInvalidFields">
            ${firstNameInvalid}
        </span>
 </#if>
</br><br>

<label>Nazwisko: </label></br>
<input type="text" name="lastname" placeholder="Nazwisko">
<#if lastNameInvalid??>
        <span class="textInvalidFields">
            ${lastNameInvalid}
        </span>
 </#if>
</br><br>

<label>Login: </label></br>
<input type="text" name="login" placeholder="login">
<#if loginInvalid??>
        <span class="textInvalidFields">
            ${loginInvalid}
        </span>
 </#if>
</br><br>
<label>Hasło: </label></br>
<input type="password" name="password" placeholder="Hasło">
<#if passwordInvalid??>
        <span class="textInvalidFields">
            ${passwordInvalid}
        </span>
 </#if>
</br><br>
<input type="submit" value="Zarejestruj"> 
</form>
</body>
</html>