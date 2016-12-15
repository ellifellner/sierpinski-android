package at.fh.swengb.sierpinskitriangle_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity extends AppCompatActivity {
  private[sierpinskitriangle_android] var myView: CustomView = null

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    myView = new CustomView(this)
    setContentView(myView)
  }
}
