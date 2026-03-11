<%@ 
page contentType="text/html;charset=UTF-8" language = "java"
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Miniature</title>
</head>
<body>
    <h1>MINIATURE</h1>
    <section class="login-section">
        <button type="button" onclick="document.querySelector('dialog#login-modal').showModal()">Se connecter</button>
        <button type="button" onclick="document.querySelector('dialog#register-modal').showModal()">Créer un compte</button>
    </section>

    <dialog id="login-modal">
        <h2>Login</h2>
        <form method="dialog">
            <button>X</button>
        </form>
        <form action="/login" method="post">
            <input type="text" name="username" placeholder="Entrez votre nom d'utilisateur">
            <input type="password" name="password" placeholder="Entrez votre mot de passe">
            <input type="submit" value="Login">
        </form>
    </dialog>
    <dialog id="register-modal">
        <h2>Register</h2>
        <form method="dialog">
            <button>X</button>
        </form>
        <form action="/register" method="post">
            <input type="text" name="username" placeholder="Entrez votre nom d'utilisateur">
            <input type="email" name="email" placeholder="Entrez votre adresse mail">
            <input type="password" name="password" placeholder="Entrez votre mot de passe">
            <input type="password" name="password-confirm" placeholder="Confirmer votre mot de passe">
            <input type="submit" value="Login">
        </form>
    </dialog>
</body>
</html>