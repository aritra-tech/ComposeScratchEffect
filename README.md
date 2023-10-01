<h1 align="center">ComposeScratchEffect</h1></br>

</h1>
<p align="center">
 <img alt="material" src="https://custom-icon-badges.demolab.com/badge/material%20you-palegreen?style=for-the-badge&logoColor=black&logo=material-you"/></a>
  <img alt="API" src="https://img.shields.io/badge/Api%2021+-50f270?logo=android&logoColor=black&style=for-the-badge"/></a>
  <img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-a503fc?logo=kotlin&logoColor=white&style=for-the-badge"/></a>
  <img alt="Jetpack Compose" src="https://img.shields.io/static/v1?style=for-the-badge&message=Jetpack+Compose&color=4285F4&logo=Jetpack+Compose&logoColor=FFFFFF&label="/></a>
    <a href="https://github.com/aritra-tech/ComposeScratchEffect/stargazers"><img src="https://img.shields.io/github/stars/aritra-tech/ComposeScratchEffect?color=ffff00&style=for-the-badge"/>
  <a href="https://hits.sh/github.com/aritra-tech/ComposeScratchEffect/"><img alt="Hits" src="https://hits.sh/github.com/aritra-tech/ComposeScratchEffect.svg?style=for-the-badge&label=Views&extraCount=10&color=54856b"/></a>
  <a href="https://github.com/aritra-tech/ComposeScratchEffect/releases/latest"><img src="https://img.shields.io/github/v/release/aritra-tech/ComposeScratchEffect?color=purple&include_prereleases&logo=github&style=for-the-badge"/>
</p>
	  
<p align="center"> ✨ComposeScratchEffect is a library to understand scratching gift & coupons like effect. Made using Koltin & Jetpack Compose 🚀 with the use of Canvas. </p>

<br>

<p align="center">
<img src="assets/scratchcardeffect.gif" width="280"/>
</p>

## Adding the library to your project✨
[![](https://jitpack.io/v/aritra-tech/ComposeScratchEffect.svg)](https://jitpack.io/#aritra-tech/ComposeScratchEffect)

Add the following to your **root** `build.gradle` file:
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```

Lastly, add the following dependency to your app's `build.gradle.kts` (Kotlin) or `build.gradle` (Groovy) file:

<details>
<summary>Kotlin (KTS)</summary>
<br>
  
```kotlin
dependencies {
    implementation("com.github.aritra-tech:ComposeScratchEffect:$currentVersion")
}
```
</details>

<details>
<summary>Groovy</summary>
<br>

```kotlin
dependencies {
    implementation 'com.github.aritra-tech:ComposeScratchEffect:$currentVersion'
}
```
</details>

## Usage📓
You can use the `ScratchCard()` by simply passing this to the screen you want to use. For example:
```Kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeScratchEffectTheme {
                ScratchCard()
            }
        }
    }
}
```
## Reporting Issues and Requesting Features✨
If you encounter any issues or have feature requests, please create a new [issue](https://github.com/aritra-tech/ComposeScratchEffect/issues) in this repository.

## Supporting ComposeCards :heart:
Support it by joining __[stargazers](https://github.com/aritra-tech/ComposeScratchEffect/stargazers)__ for this repository. :star: <br>
Also __[follow](https://github.com/aritra-tech)__ me for my next creations! 🤩

## License

```
Copyright 2023 aritra-tech

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
