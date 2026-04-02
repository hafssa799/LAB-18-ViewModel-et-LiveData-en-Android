# LAB-18-ViewModel-et-LiveData-en-Android

Ce projet est une application Android pédagogique démontrant l'utilisation des composants d'architecture Android Jetpack. Il illustre comment gérer efficacement le cycle de vie, la persistance des données lors de la rotation d'écran et la séparation des responsabilités.

## Sommaire

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
        // ... calcul ...
        countLiveData.postValue(newValue); // Safe pour le thread UI
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

1.Dépendances Gradle (build.gradle.kts) :

implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.7")
implementation("androidx.lifecycle:lifecycle-livedata:2.8.7")

2.Structure du projet :

•MainActivity.java : Gère uniquement l'affichage et les clics.

•CounterViewModel.java : Gère la logique métier et le stockage des données.

•activity_main.xml : Mise en page avec LinearLayout et MaterialComponents.
