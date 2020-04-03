# MAMN01-MyApp
Compass and Accelerometer
## Beskrivning av appens uppbyggnad och funktioner:
Appen består av tre olika delar: en huvudaktivitet, en kompassaktivitet och en accelerometeraktivitet. Nedan beskrivs uppbyggnaden av de olika delarna och vilka funktioner de har. 
### MainActivity:
Jag utgick från stegen från artikeln [Build your first app](https://developer.android.com/training/basics/firstapp/index.html) och gjorde sedan följande ändringar:
* Ändrade färg på knapparna som leder till de två andra aktiviteterna
* La till bakgrundsbild: [Create A Background Image In Android Application Using Android Studio](https://www.c-sharpcorner.com/blogs/create-a-background-image-in-android-application-using-android-studio)
### Accelerometer:
Jag utgick från klippet [Android Studio - Tutorial 6 - Accelerometer](https://www.youtube.com/watch?v=YrI2pCZC8cc) och tog även hjälp av dokumentationen för  [SensorEvent](https://developer.android.com/reference/android/hardware/SensorEvent.html) samt [SensorManager](https://developer.android.com/reference/android/hardware/SensorManager.html). Sedan gjordes sedan följande ändringar i koden:
* En textutskrift las till då telefon står i olika lägen: Liggande, högkant, upp och ner, vänster och höger sida. Detta gjorde med hjälp av ett lågpassfilter: [Applying Low Pass Filter to Android Sensor's Readings](https://www.built.io/blog/applying-low-pass-filter-to-android-sensor-s-readings)
* La till ljudeffekt då telefonen står upp och ner och på vänstersidan. [Add Sound Play on Android Button Click](https://www.stechies.com/add-sound-play-button-click/)
### Kompass: 
Jag utgick från handledningen i artikeln [How-to create a Compass App](https://www.wlsdevelop.com/index.php/en/blog?option=com_content&view=article&id=38) och gjorde sedan följande  modifieringar i koden:
* La till vibration då telefonen pekar mot norr: [How to Make Android Vibrate Programmatically](https://www.codingdemos.com/android-vibrate-programmatically/).
* La till att bakgrundsfärgen ändras beroende på om telefonen pekar mot norr, syd, öst eller väst. 
* La till en egen kompassbild.
