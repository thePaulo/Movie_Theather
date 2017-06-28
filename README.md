# Movie_Theather
project that allow to create movie sessions based on imdb grades



This project is made for a project in a Web Development II class of University Of Rio Grande do Norte ( UFRN )

it's made mostly in java web containing JPA,JSF,EJB and other java concepts as Beans and Servlets.

the project also uses the programming tool called Node_Red to call for external web services in the IMDB web page to search for a
movie name,year,rating and the picture so that it allows the user of this system to search freely for movies.


Assuming that everyone that looks for this project is able to configurate a java web project with the components that i mentioned, the programmer to start running this project will after initiate the server ( i used wildfly ) go to the page "http://localhost:8080/Cinema/page.jsf" to go to the first page of the project.

NOTE: to register new movies and stuff the programmer must have started the Node-RED tool in the page "http://localhost:1880" and run the script that is listed on this project.

Then, there will be a couple itens displaying on the screen for login, and one for register.

from the login page ( page.jsf ) the user will be able to go to the user page and then will be able to set another movie in the search tab link or to see the movies already registered in the theather.

NOTE: the theather alocated movies page will only be displayed if you have been through the whole steps to get there ( passing by lista.jsf ) and must have AT LEAST 7 movies registered ( why? becouse the movie theather that i was based on had 7 movies on it , lol).

by clicking on movie splasharts that are on the movie theater display page, the user will be able to "buy" those sessions, and will be showing on the userpage the sessions that have been "bought" ( NOTE: i haven't stablished a payment system, so even that the user have the field "money" i still havent discounted anything when they "buy" the movie ticket).

That's it, might look like it's simple but joining all these stuff togheter it's tough! See Ya!

Dev: Paulo Victor.

