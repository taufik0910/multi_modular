plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "com.example.multimodular"
	compileSdk = 33
	
	defaultConfig {
		applicationId = "com.example.multimodular"
		minSdk = 24
		targetSdk = 33
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}
	
	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt") ,
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.4.3"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	
	implementation(Deps.core)
	implementation(CoroutinesLifecycleScope.lifeCycleRuntime)
	implementation(JetpackCompose.composeActivity)
	implementation(JetpackCompose.composeUi)
	implementation(JetpackCompose.composeUiToolingPreview)
	implementation(JetpackCompose.composeMaterial)
	
	testImplementation(TestImplementation.junit)
	androidTestImplementation(AndroidTestImplementation.junit)
	androidTestImplementation(AndroidTestImplementation.espresso)
	
	androidTestImplementation(ComposeAndroidTestImplementation.composeUiTest)
	debugImplementation(ComposeDebugImplementation.toolingUi)
	debugImplementation(ComposeDebugImplementation.manifestTest)
}