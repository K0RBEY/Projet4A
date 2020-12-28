<h1>Login</h1>
<p>Lorsque vous êtes sur cette page de connexion, vous avez deux champs:
	<ul>
		<li>Un champ réservé à l'adresse email de l'utilisateur</li>
		<li>Un champ réservé au mot de passe de l'utilisateur</li>
	</ul>
	Pour se connecter, les deux champs doivent être rempli. Une fois les champs remplis, l'utilisateur n'a plus qu'à appuyer sur le bouton "se connecter"
	Pour autoriser la connexion, l'application vérifie si l'utilisateur existe et s'il existe, elle vérifie que le mot de passe renseigné correspond bien à celui du compte (requête GET sur la base de données ROOM).
</p>
<h1>Inscription</h1>
<p>Il se peut que l'utilisateur n'ai pas de compte créé, c'est pourquoi un bouton "créer un compte" se situe en dessous de "se connecter".
	En arrivant sur le formulaire d'inscription, l'utilisateur doit renseigner 3 champs:<br>
	<ul>
		<li>Son adresse email</li>
		<li>Un mot de passe</li>
		<li>La validation du mot de passe</li>
	</ul>
	Après avoir renseigné ces champs, l'utilisateur n'a plus qu'à cliquer sur le bouton "créer" pour finaliser la création de son compte.
	Si il y a une erreur lors de la création du compte, l'application distingue 4 cas possibles :<br>
	<ul>
		<li>Le formulaire non-rempli ou partiellement rempli : dans ce cas l'application spécifie à l'uilisateur qu'il est nécéssaire de remplir le formulaire entièrement</li>
		<li>L'adresse email est déjà associée à un compte existant : dans ce cas nous spécifions à l'utilisateur que l'adresse email renseignée est déjà utilisée pour cette application</li>
		<li>Les mots de passe renseignés ne correspondent pas : Dans ce cas l'application informe l'utilisateur que le mot de passe et la validation du mot de passe ne correspondent pas, il doit les faire correspondre pour s'inscrire</li>
		<li>Une erreur dîte "générique" : Dans le cas où il s'agit d'une autre erreur que nous ne pouvons pas identifier, l'application spécifie tout de même à l'utilisateur qu'il y a un problème dans le processus d'inscription et qu'il doit rééssayer</li>
	</ul>
	S'il n'y a pas d'erreur lors de l'inscription, l'application créer son compte (requête INSERT sur la base de données ROOM)
</p>
<h1>Page d'accueil</h1>
<p>Une fois que l'utilisateur s'est connecté ou s'est créé un compte, l'application le renvoit sur la page d'accueil.
	En arrivant sur cette page d'accueil, l'application fait des requêtes sur l'API "http://api.openweathermap.org/data/2.5/" pour connaitre la météo dans les 10 plus grandes villes de France.
	Le temps de chaque ville est affiché grâce à un RecyclerView.
  L'application utilise Picasso, qui permet d'afficher une image au temps décrit.
</p>
<h1>Lancement de l'application</h1>
<p>Lorsque vous lancez l'application, il est possible que l'on vous demande d'attacher un débugger à l'application. Dans ce cas de figure, vous avez deux possibilités:<br>
<ul>
	<li>Lancer l'application en mode "Debug"</li>
	<li>Redémarrer l'appareil et lancer l'application à nouveau</li>
</ul>
</p>
