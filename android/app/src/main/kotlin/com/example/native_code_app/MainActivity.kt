package com.example.flutter_native_sample

import io.flutter.embedding.android.FlutterActivity

import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "android_method_channel_experiment.example.com//native_feature"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
            if(call.method == "initializeNativeSetup"){
                val isInitialized = initializeNativeSetup()
                result.success(isInitialized)
            }else{
                result.notImplemented()
            }
        }
    }

    private fun initializeNativeSetup(): Boolean {
        // Do some operation
        return true;
    }
}