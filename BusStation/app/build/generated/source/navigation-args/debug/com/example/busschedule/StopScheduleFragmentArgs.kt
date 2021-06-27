package com.example.busschedule

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class StopScheduleFragmentArgs(
  public val stopName: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("stopName", this.stopName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): StopScheduleFragmentArgs {
      bundle.setClassLoader(StopScheduleFragmentArgs::class.java.classLoader)
      val __stopName : String?
      if (bundle.containsKey("stopName")) {
        __stopName = bundle.getString("stopName")
        if (__stopName == null) {
          throw IllegalArgumentException("Argument \"stopName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"stopName\" is missing and does not have an android:defaultValue")
      }
      return StopScheduleFragmentArgs(__stopName)
    }
  }
}
