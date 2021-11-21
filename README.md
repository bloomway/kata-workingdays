# Working Days

### Partie 1 : faire lors de la séance du workshop
Un groupe d’investisseurs de crypto monnaies souhaite connaitre les transactions effectuées sur son portefeuille pour le jour de travail précédent et actuel et sa prévision pour le jour de travail suivant. 
Le leader technique de ce projet divise la problématique en sous-fonctionnalités. Il te transfère ensuite les deux sous fonctionnalités suivantes :
1.	Calculer le jour de travail précédent à partir d’une date donnée
2.	Calculer le jour de travail suivant à partir d’une date donnée.
On considère le jour de travail comme un jour de la semaine, c’est-à-dire, de lundi à vendredi (hors weekend).
Construis les sous-fonctionnalités en utilisant l’approche TDD en partant de la classe de test « BusinessDaysTest » situé dans le projet.

**Note** : pour faciliter le travail avec les dates en Java, tu peux utiliser l’objet LocalDate de Java 9.

### Partie 2 : faire après la séance du workshop
Maintenant, le leader technique te transfère la tache de créer une autre sous fonctionnalité qui calcule le jour de travail précédent, actuel et suivant à partir d’une date donnée.
Si la date d’entrée est un jour du weekend, alors, le jour de travail actuel n’est pas calculé.
