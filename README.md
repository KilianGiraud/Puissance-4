# Puissance 4 / Connect Four 🎮

## 🇫🇷 Version Française

### 📌 Présentation

Je me nomme **Kilian Giraud**, étudiant en **BUT Sciences des Données (option Visualisation / Conception d'Outils Décisionnels)**.  
Ce projet a été réalisé lors de ma 2ᵉ année, et consiste à recréer le jeu **Puissance 4** avec une interface graphique en Java Swing, en suivant les principes de séparation de la logique et de la vue.

---

### 💻 Structure du projet

Le projet est divisé en plusieurs fichiers Java pour plus de clarté :

- `Menu.java` : le menu principal stylisé
- `RuleWindow.java` : fenêtre affichant les règles
- `Puissance4.java` : point d'entrée du jeu
- `P4Modele.java` : la logique métier (modèle)
- `P4Vue.java` : la vue du plateau avec jetons ronds
- `VictoryDialog.java` : fenêtre stylisée pour les messages (victoire, égalité, erreur)

---

### 🎨 Nouveautés & Améliorations

- 🟦 Plateau modernisé avec fond coloré
- 🔴🟡 Jetons parfaitement ronds avec rendu graphique propre
- 🪟 Boîtes de dialogue stylisées pour :
  - Victoire
  - Égalité
  - Colonne pleine
- 🧱 Structure MVC plus propre (séparation modèle/vue/contrôleur)
- ❌ Crédits supprimés

---

### 🚀 Prérequis

- ✅ Java **JDK** (obligatoire), **JRE seul ne suffit pas**
- ✅ Compatible Java **8**
- ✅ Un IDE comme **Visual Studio Code** avec *Java Extension Pack*
- 📁 Le dossier `img` contenant `img.png` doit être présent dans le même répertoire que les `.java`

---

### ⚠️ Problème connu

Si vous voyez cette erreur :

```
UnsupportedClassVersionError: class file version 65.0
```

➡️ Vous avez compilé avec **Java 21** mais vous exécutez avec **Java 8**.  
**Solution :**
- Soit vous installez un JDK plus récent,
- Soit vous recompilez avec Java 8 :

```bash
javac --release 8 *.java
```

---

### 🔧 Installation du JDK

#### Option 1 – Oracle (officiel)
👉 https://www.oracle.com/java/technologies/downloads/

#### Option 2 – Adoptium (open source recommandé)
👉 https://adoptium.net/

Pendant l’installation, cochez :
- ✅ "Set JAVA_HOME"
- ✅ "Add to PATH"

Vérifiez ensuite :
```bash
java -version
javac -version
```

---

### ▶️ Compilation et Exécution

#### 📦 Compilation

```bash
del *.class
javac -Xlint:-options --release 8 *.java
```

#### 🕹️ Exécution

```bash
java Menu
```

---

### 🧠 Fonctionnement du jeu

Vous verrez un **menu principal** avec deux options :

- 🎮 **Jouer** : Lancer une partie
- 📘 **Règles** : Affiche les règles du jeu

Le jeu affiche des messages stylisés en cas de victoire, d'égalité ou d'erreur (colonne pleine).

---

## 🇬🇧 English Version

### 📌 Introduction

My name is **Kilian Giraud**, and during my second year of a Bachelor’s Degree in Data Science, I developed a graphical **Connect Four game** using Java Swing and a clean MVC structure.

---

### 💻 Project Structure

This project is organized across several Java files:

- `Menu.java`: the main stylish menu
- `RuleWindow.java`: rules display window
- `Puissance4.java`: game entry point
- `P4Modele.java`: the game logic
- `P4Vue.java`: board rendering with circular tokens
- `VictoryDialog.java`: custom popup dialog for messages

---

### 🎨 Features & Improvements

- 🟦 Modern game board with styled background
- 🔴🟡 Round tokens with smooth rendering
- 🪟 Custom dialogs for:
  - Victory
  - Tie
  - Full column
- 🧱 Clean MVC separation
- ❌ Removed credits

---

### 🚀 Requirements

- ✅ Java **JDK** (required), JRE is **not** enough
- ✅ Compatible with **Java 8**
- ✅ IDE: Visual Studio Code + Java Extension Pack
- 📁 An `img` folder with `img.png` must be in the same directory as `.java` files

---

### ⚠️ Common Error

If you see this:

```
UnsupportedClassVersionError: class file version 65.0
```

➡️ You compiled with **Java 21**, but are trying to run with **Java 8**.  
**Fix:**
- Either install Java 21, or
- Recompile using Java 8:

```bash
javac --release 8 *.java
```

---

### 🔧 Install JDK

#### Option 1 – Oracle (official)
👉 https://www.oracle.com/java/technologies/downloads/

#### Option 2 – Adoptium (recommended)
👉 https://adoptium.net/

During install:
- ✅ Enable "Set JAVA_HOME"
- ✅ Enable "Add to PATH"

Check with:

```bash
java -version
javac -version
```

---

### ▶️ Compile & Run

#### 📦 Compile

```bash
del *.class
javac -Xlint:-options --release 8 *.java
```

#### 🕹️ Run

```bash
java Menu
```

---

### 🧠 Game Flow

From the main menu, you can:

- 🎮 **Play** a game
- 📘 **View rules**

Stylish dialogs appear when a player wins, there's a tie, or a column is full.