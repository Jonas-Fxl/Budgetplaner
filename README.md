# Budgetplaner

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/Jonas-Fxl/Budgetplaner)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.7+-blue.svg)](https://kotlinlang.org)

**Budgetplaner** ist eine in Kotlin entwickelte Finanzapplikation, die dir hilft, Einnahmen und Ausgaben zu erfassen, Budgets zu planen und so stets den Überblick über deine finanzielle Situation zu behalten. Alle wesentlichen Funktionen sind im Ordner `FinanzApp` implementiert. Das Projekt verwendet eine lokale SQLite-Datenbank, um Finanzdaten sicher und schnell zu persistieren.

---

## Inhaltsverzeichnis

- [Über das Projekt](#über-das-projekt)
- [Features](#features)
- [Abhängigkeiten und Versionsinformationen](#abhängigkeiten-und-versionsinformationen)
- [Installation und Build](#installation-und-build)
- [Testanweisungen](#testanweisungen)
- [Konfiguration](#konfiguration)
- [Verwendung](#verwendung)
- [Projektstruktur und Dateianalyse](#projektstruktur-und-dateianalyse)
- [Datenbank](#datenbank)
- [Roadmap und zukünftige Features](#roadmap-und-zukünftige-features)
- [Bekannte Probleme und Troubleshooting](#bekannte-probleme-und-troubleshooting)
- [Beitrag leisten](#beitrag-leisten)
- [Danksagungen und Credits](#danksagungen-und-credits)
- [Lizenz](#lizenz)
- [Kontakt](#kontakt)

---

## Über das Projekt

**Budgetplaner** bietet eine einfache Möglichkeit, persönliche Finanzen zu verwalten. Die App unterstützt dich dabei, deine Einnahmen und Ausgaben zu erfassen, Budgets zu definieren und dir durch übersichtliche Berichte einen schnellen Überblick über deine finanzielle Situation zu verschaffen. Da alle Daten lokal in einer SQLite-Datenbank gespeichert werden, profitierst du von schnellen Zugriffen und erhöhter Datensicherheit.

---

## Features

- **Finanzübersicht:** Erfassung und Anzeige von Einnahmen und Ausgaben.
- **Budgetierung:** Erstellung und Verwaltung von Budgets für verschiedene Ausgabenkategorien.
- **Lokale Persistenz:** Speicherung aller Finanzdaten in einer SQLite-Datenbank.
- **Modularer Aufbau:** Gut strukturierter Kotlin-Code, der einfache Erweiterungen und Anpassungen ermöglicht.
- **Intuitive Bedienung:** Klare und benutzerfreundliche Oberfläche (sowohl als Konsolenanwendung als auch in zukünftigen GUI-Versionen).

---

## Abhängigkeiten und Versionsinformationen

- **Kotlin:** Version 1.7 oder höher
- **SQLite:** Für die lokale Datenpersistenz (bei Android-Projekten häufig in Kombination mit der [Room Persistence Library](https://developer.android.com/training/data-storage/room))
- Weitere Bibliotheken und Frameworks können bei Bedarf ergänzt werden.

---

## Installation und Build

1. **Repository klonen:**

   ```bash
   git clone https://github.com/Jonas-Fxl/Budgetplaner.git
   ```

2. **In das Projektverzeichnis wechseln:**

   ```bash
   cd Budgetplaner
   ```

3. **Projekt in der IDE öffnen:**

   Wir empfehlen [IntelliJ IDEA](https://www.jetbrains.com/idea/), da diese IDE hervorragende Unterstützung für Kotlin bietet. Öffne das Projekt und stelle sicher, dass alle Abhängigkeiten korrekt geladen werden.

4. **Build:**

   Baue das Projekt in der IDE oder über ein Kommandozeilen-Build-Tool. Der Einstiegspunkt (z. B. in einer Datei wie `Main.kt`) befindet sich im Ordner `FinanzApp`.

---

## Testanweisungen

Aktuell sind noch keine automatisierten Tests implementiert. Zukünftig sollen Unit-Tests (z. B. mit JUnit) hinzugefügt werden, um die wichtigsten Funktionen abzusichern. Falls du Tests hinzufügen möchtest, erstelle bitte einen neuen Ordner (z. B. `tests/`) und integriere deine Testfälle in den Build-Prozess.

---

## Konfiguration

Für die lokale Persistenz der Finanzdaten wird eine SQLite-Datenbank verwendet. Falls weitere Konfigurationsoptionen benötigt werden, beispielsweise für:

- **Datenbankpfad oder -name:**  
  Die Standardkonfiguration verwendet einen lokalen Speicherort im Projektverzeichnis.
- **Debug- und Logging-Einstellungen:**  
  Konfigurationsparameter können in einer Properties-Datei (z. B. `config.properties`) definiert werden.

Diese Dateien können bei Bedarf erweitert oder angepasst werden.

---

## Verwendung

Nach dem erfolgreichen Build der Anwendung kannst du diese starten. Je nach Implementierung kannst du:

- Neue Einnahmen und Ausgaben erfassen,
- Budgetgrenzen für verschiedene Kategorien festlegen und anpassen,
- Übersichten und Berichte über deine finanzielle Situation einsehen.

Die Bedienung erfolgt über die Benutzeroberfläche der App oder, falls als Konsolenanwendung implementiert, über entsprechende Konsolenbefehle. Ausführliche Hinweise zur Bedienung findest du direkt im Quellcode oder in zukünftigen Erweiterungen dieser Dokumentation.

---

## Projektstruktur und Dateianalyse

Das Repository gliedert sich derzeit in folgende Hauptbereiche:

- **FinanzApp/**  
  Enthält den gesamten Quellcode der Anwendung:
  - **Einstiegspunkt:**  
    Eine Datei wie `Main.kt` (oder ähnlich benannt) dient als Startpunkt der Applikation.
  - **Modelle:**  
    Klassen wie `Transaction.kt`, `Category.kt` und `Budget.kt` repräsentieren die grundlegenden Datenmodelle.
  - **Logik und Datenzugriff:**  
    Klassen wie `BudgetManager.kt` und DAO-Klassen, die den Zugriff auf die SQLite-Datenbank kapseln.
  - **Utilities:**  
    Hilfsklassen für Formatierung, Berechnungen und weitere wiederkehrende Funktionen.

- **LICENSE**  
  Enthält die MIT-Lizenz, unter der dieses Projekt veröffentlicht wird.

Weitere Unterordner und Dateien können im Laufe der Projektentwicklung hinzugefügt werden.

---

## Datenbank

Die **Budgetplaner**-App nutzt eine lokale SQLite-Datenbank, um alle Finanzdaten sicher und performant zu speichern. Wichtige Aspekte:

- **Technologie:**  
  Lokale SQLite-Datenbank. Bei Android-Projekten wird häufig die [Room Persistence Library](https://developer.android.com/training/data-storage/room) verwendet, um eine deklarative Schnittstelle zur Datenbank zu erhalten.

- **Tabellen:**  
  - **Transaktionen:** Speicherung von Einnahmen und Ausgaben.
  - **Kategorien:** Verwaltung der Ausgabenkategorien.
  - **Budgets:** Definition und Kontrolle von Budgetgrenzen für verschiedene Kategorien.

- **DAO-Schicht:**  
  Die Datenbankzugriffe erfolgen über Data Access Objects (DAOs), welche CRUD-Operationen (Create, Read, Update, Delete) kapseln. Die zentrale Datenbankklasse (z. B. `AppDatabase.kt`) stellt die Singleton-Instanz bereit.

- **Vorteile:**  
  Durch die lokale Speicherung sind schnelle Datenzugriffe möglich, und der Datenschutz wird erhöht, da keine Daten an externe Server übertragen werden.

---

## Roadmap und zukünftige Features

Folgende Erweiterungen und Verbesserungen sind in Planung:

- **Erweiterte Benutzeroberfläche:**  
  Entwicklung einer grafischen Benutzeroberfläche (GUI) für eine intuitivere Bedienung.
- **Mobile Version:**  
  Anpassung der App als Android‑Anwendung unter Verwendung von Room und modernen UI-Frameworks.
- **Erweiterte Berichte:**  
  Detaillierte Analyse- und Reporting-Funktionen, inklusive Diagrammen und Exportmöglichkeiten.
- **Cloud-Synchronisation:**  
  Möglichkeit, Daten sicher in der Cloud zu speichern und geräteübergreifend zu synchronisieren.
- **Automatisierte Tests:**  
  Integration von Unit- und Integrationstests zur Sicherstellung der Codequalität.

---

## Bekannte Probleme und Troubleshooting

- **Aktueller Entwicklungsstand:**  
  Das Projekt befindet sich noch in einem frühen Stadium. Es kann zu unvollständigen Funktionen oder unerwartetem Verhalten kommen.
- **Datenbankinitialisierung:**  
  Sollte es Probleme bei der Initialisierung der SQLite-Datenbank geben, überprüfe bitte die Konfiguration in der entsprechenden Datei.
- **IDE-Konfiguration:**  
  Stelle sicher, dass deine IDE korrekt für Kotlin konfiguriert ist und alle benötigten Abhängigkeiten geladen werden.

Bei Problemen erstelle bitte ein Issue im Repository, damit diese zeitnah behoben werden können.

---

## Beitrag leisten

Beiträge sind herzlich willkommen! So kannst du helfen:

1. **Forke** das Repository.
2. Erstelle einen neuen Branch für deine Änderungen (z. B. `feature/neues-feature`).
3. Committe deine Änderungen mit aussagekräftigen Nachrichten.
4. Sende einen **Pull Request** an das Hauptrepository.

Bitte beachte dabei die bestehenden Code-Richtlinien und Dokumentationsstandards.

---

## Danksagungen und Credits

- **Projektinitiator:**  
  Jonas-Fxl – für die ursprüngliche Idee und Entwicklung.
- **Community und Mitwirkende:**  
  Vielen Dank an alle, die durch Feedback, Issues und Beiträge zur Verbesserung des Projekts beigetragen haben.
- **Inspiration:**  
  Diverse Open-Source-Projekte und Tutorials, die den Weg zu einer modularen und datengesteuerten Finanzanwendung geebnet haben.

---

## Lizenz

Dieses Projekt wird unter der [MIT License](LICENSE) veröffentlicht.

---

## Kontakt

Bei Fragen, Anregungen oder Problemen erstelle bitte ein Issue im Repository oder kontaktiere das Entwicklerteam über die GitHub-Community.

---

*Diese Dokumentation wird NICHT erweitert, da das Projekt als abgeschlossen gilt.*
