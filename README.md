# T-JAV-501-LIL-5-1-dashboard-david.bugnon

## Projet D'Hache Borde : 

### Ce projet utilise les technos suivantes: 

- [Java](https://fr.wikipedia.org/wiki/Java_\(technique\))
- [Spring boot](https://spring.io/projects/spring-boot)
- [HTML5](https://fr.wikipedia.org/wiki/Hypertext_Markup_Language)
- [CSS3](https://fr.wikipedia.org/wiki/Hypertext_Markup_Language)
-  [Gradle](https://gradle.org)
- [MySQL](https://dev.mysql.com) 
### avec des API externes : 
- [OpenWeather](https://openweathermap.org/api)
- [Youtube](https://developers.google.com/youtube/v3)
- [Deezer](https://developers.deezer.com)
- [NewsApi](https://newsapi.org/)

### Consignes pour l'installation du projet : 

Cloner le répertoire : 
```
git clone git@github.com:EpitechMscProPromo2024/T-JAV-501-LIL-5-1-dashboard-david.bugnon.git
```

Vu que Docker ne fonctionne pas(problème au niveau du dockerfile : voir la davidbranche.) : <br>
Créer une database sous Mysql:
```
CREATE DATABASE hachehorde;
```
Créer un user qui pourra gérer le CRUD dans la DB : 
```
CREATE USER 'dashadmin'@'localhost' IDENTIFIED BY 'hachehorde';
```

Lui donner les droits : 
```
GRANT ALL PRIVILEGES ON hachehorde.* TO 'dashadmin'@'localhost';
```
On oublie pas de Flush les privileges : 
```
FLUSH PRIVILEGES;

```
Executer gradle: 
``` 
./gradlew run 
```
### Listes des services et widgets présents sur l'appli : 

#### Youtube : 
- Affiche le top 10 en France ( non paramétrable) 
- Permet d'afficher le nombre d'abonnés à une chaine Y ( paramétrable) 
- recherche d'une vidéo ( paramétrable)

#### Météo:
- Affiche la température d'une ville donnée ( paramétrable : ville; et options supplémentaires.)

#### Musique ( via Deezer) :
- Joue une musique ( paramétrable par le nom de la recherche)

#### Actualités : 
- Affichage des nouveautés par mot clé ( paramétrable) 
- affichage des top nouveautés par catégorie ( paramétrable) .

### TOTAL : 4 services pour 6 widgets. ( 7 avec celui non paramétrable.) 

