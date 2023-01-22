# SimpleWeather

 
<img src="https://github.com/hall9zeha/SimpleWeather/blob/main/InKotlin/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png" align="left"
width="20%" hspace="10" vspace="10">
SimpleWeather aplicación de pronóstico del clima, escrita en Kotlin utilizando el patrón de arquitectura MVVM y la Api  en su versión gratuita de [OpenWeatherMap](https://openweathermap.org/api).

</br>
</br>
</br>
</br>
</br>
</br>
</br>

# Objetivo

Profundizar en el manejo de data binding que permite vincular los componentes de la IU con los diseños a las fuentes de datos de la aplicación usando un formato declarativo en lugar de la programación.

# Se utilizó :gear:
* [OpenWeatherMap](https://openweathermap.org/api)
* [Arquitectura MVVM](https://developer.android.com/jetpack/guide)
* [Corrutinas](https://developer.android.com/kotlin/coroutines) 
* [Data Binding](https://developer.android.com/topic/libraries/data-binding)
* [Lyfecycle view model](https://developer.android.com/jetpack/androidx/releases/lifecycle)
* [Material components and Material Design](https://material.io/components)
* [Material 3](https://m3.material.io/)
* [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

# Importante

Agregar la ``API KEY`` de  su cuenta de OpenWeatherMap, en los recursos ``strings`` de la app. 

También se puede usar la siguiente forma que es mucho más segura (Opcional):

* Crear un archivo dentro del directorio raíz del proyecto con la siguiente sintaxis ``apiKey.properties``, o usar el archivo dentro de Gradle Scripts ``local.properties`` con el siguiente contenido.

```
MY_API_KEY ="your key string"
```
* Dentro del archivo Gradle a nivel de aplicación:

```gradle
  plugins{...}
  
  def apikeyPropertiesFile =  rootProject.file("local.properties")
  def apikeyProperties =  new Properties()
  apikeyProperties.load(new FileInputStream(apikeyPropertiesFile))
  
  android{...
  
  //dentro de default config
  defaultConfig{
      buildConfigField "String", "MY_API_KEY", apikeyProperties['MY_API_KEY']
     }
  }
```
* Construimos el proyecto una primera vez para que el archivo se genere y ya podremos acceder a nuestra llave:

```gradle
   String apiKey = BuildConfig.MY_API_KEY
   
```
# Screenshots :framed_picture:
<img src="https://github.com/hall9zeha/SimpleWeather/blob/main/screenshots/screen1.jpg" alt="drawing" width="35%" height="35%"/> <img src="https://github.com/hall9zeha/SimpleWeather/blob/main/screenshots/screen2.jpg" alt="drawing" width="35%" height="35%"/>
