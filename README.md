# ViewModelLiveDataDemoEnrichi

## Description
Ce projet est une application Android de demonstration illustrant l'utilisation des composants de l'architecture Jetpack, specifiquement ViewModel et LiveData. L'objectif est de montrer comment gerer l'etat de l'interface utilisateur de maniere robuste, en evitant les pertes de donnees lors des changements de configuration comme la rotation de l'ecran.

## Fonctionnalites
L'application propose un compteur interactif avec les actions suivantes :
- Incrementation simple via un clic sur le bouton dedie.
- Incrementation asynchrone via un appui long sur le bouton d'incrementation, simulant un traitement en arriere-plan.
- Decrementation de la valeur.
- Reinitialisation complete du compteur.

## Architecture
Le projet suit le modele de conception MVVM (Model-View-ViewModel) :
- MainActivity : Gere l'affichage et les interactions de l'utilisateur. Elle observe les donnees du ViewModel pour mettre a jour l'interface automatiquement.
- CounterViewModel : Stocke et gere la logique metier. Il utilise LiveData pour notifier la vue des changements et SavedStateHandle pour assurer la persistance meme en cas de fermeture du processus par le systeme.

## Technologies utilisees
- Java : Langage de programmation principal.
- Android Jetpack Lifecycle : Pour la gestion du cycle de vie des composants.
- ViewModel : Pour la preservation des donnees.
- LiveData : Pour une communication reactive entre la logique et la vue.
- Material Design : Pour une interface utilisateur moderne avec un theme personnalise en tons roses.

## Installation
1. Cloner le depot sur votre machine locale.
2. Ouvrir le projet avec Android Studio.
3. Synchroniser le projet avec les fichiers Gradle.
4. Lancer l'application sur un emulateur ou un appareil physique disposant de l'API 24 ou superieure.

## Demonstration: Video
![Video](https://github.com/user-attachments/assets/6fc9e4c5-c03d-4935-8f29-955f00b1ba5d)
