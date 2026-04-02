<<<<<<< HEAD
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
=======
# LAB-18-ViewModel-et-LiveData-en-Android

Ce projet est une application Android pédagogique démontrant l'utilisation des composants d'architecture Android Jetpack. Il illustre comment gérer efficacement le cycle de vie, la persistance des données lors de la rotation d'écran et la séparation des responsabilités.

# Sommaire

### 1.Introduction

### 2.Étape 1 : Le problème classique (Sans ViewModel)

### 3.Étape 2 : La Solution Jetpack (ViewModel + LiveData)

### 4.Étape 3 : Bonus Avancés (Multi-threading & SavedState)

### 5.Démonstration Vidéo

### 6.Installation


# Introduction

- Le défi majeur en développement Android est la destruction/récréation de l'activité lors d'un changement de configuration (ex: rotation). Ce projet montre comment passer d'une gestion manuelle fastidieuse à une architecture réactive et robuste.

# Étape 1 : Le problème classique

- Dans cette phase, nous utilisons une variable int count simple dans la MainActivity.

•Problème : En tournant l'écran, l'activité est détruite et le compteur revient à zéro.

•Solution temporaire : Utilisation de onSaveInstanceState, limitée aux données simples et synchrones.

# Étape 2 : La Solution Jetpack

- Implémentation du duo ViewModel et LiveData.

•CounterViewModel.java : Stocke la donnée en dehors du cycle de vie de l'Activity.

•LiveData : Permet à l'Activity d'observer les changements. L'UI se met à jour automatiquement via viewModel.getCount().observe(...).

# Étape 3 : Bonus Avancés

1. Thread Safety (postValue)

Ajout d'une méthode pour incrémenter le compteur depuis un thread d'arrière-plan sans bloquer l'interface utilisateur.



public void incrementFromBackground() {

    new Thread(() -> {
    
        Integer current = countLiveData.getValue();
        
        if (current == null) current = 0;
        
        int newValue = current + 1;
        
        countLiveData.postValue(newValue);
        
    }).start();
    
}



2. Persistance Ultime (SavedStateHandle)

- Grâce à SavedStateHandle, le compteur survit même si le système Android tue le processus de l'application (Process Death) pour libérer de la mémoire.

# Démonstration Vidéo


https://github.com/user-attachments/assets/bdc4ac55-5e47-477c-b3ca-00f8e9af874f


https://github.com/user-attachments/assets/bb0a9a24-3d26-4b78-b2d8-829a790ef1e4


1.Rotation d'écran : Le compteur reste à sa valeur (ex: 15) après avoir tourné l'émulateur.

2.Mode Sombre : Passage fluide du mode clair au mode sombre sans perte de données.

3.Réactivité : Mise à jour instantanée de l'UI grâce au LiveData.


# Installation

## 1. Dépendances Gradle (build.gradle.kts) :

dependencies {

    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.7")
    
    implementation("androidx.lifecycle:lifecycle-livedata:2.8.7")
    
}

## 2. Structure du projet :

•MainActivity.java : Gère uniquement l'affichage et les clics.

•CounterViewModel.java : Gère la logique métier et le stockage des données.

•activity_main.xml : Mise en page avec LinearLayout et MaterialComponents.
>>>>>>> 79d1b4243117d3a842b02f4bbb5920e58387729c
