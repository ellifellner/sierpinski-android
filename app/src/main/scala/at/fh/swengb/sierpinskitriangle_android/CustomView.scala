package at.fh.swengb.sierpinskitriangle_android

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class CustomView(val context: Context) extends View(context) {
  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    val blackColor: Paint = new Paint
    blackColor.setColor(Color.BLACK)
    blackColor.setStyle(Paint.Style.STROKE)
    val a: Float = canvas.getWidth
    val h: Float = (a / 2 * Math.sqrt(3)).toFloat
    val ax: Float = 0
    val ay: Float = 0
    val bx: Float = a
    val by: Float = ay
    val cx: Float = a / 2
    val cy: Float = h
    drawTriangle(ax, ay, bx, by, cx, cy, blackColor, canvas)
    doSierpinski(ax, ay, bx, by, cx, cy, blackColor, canvas, 7)
  }

  private def doSierpinski(ax: Float, ay: Float, bx: Float, by: Float, cx: Float, cy: Float, blackColor: Paint, canvas: Canvas, depth: Int) {
    if (depth > 0) {
      val axNew: Float = (ax + cx) / 2
      val ayNew: Float = (ay + cy) / 2
      val bxNew: Float = (bx + cx) / 2
      val byNew: Float = ayNew
      val cxNew: Float = (ax + bx) / 2
      val cyNew: Float = ay
      drawTriangle(axNew, ayNew, bxNew, byNew, cxNew, cyNew, blackColor, canvas)
      doSierpinski(axNew, ayNew, bxNew, byNew, cx, cy, blackColor, canvas, depth - 1)
      doSierpinski(ax, ay, cxNew, cyNew, axNew, ayNew, blackColor, canvas, depth - 1)
      doSierpinski(cxNew, cyNew, bx, by, bxNew, byNew, blackColor, canvas, depth - 1)
    }
  }

  private def drawTriangle(ax: Float, ay: Float, bx: Float, by: Float, cx: Float, cy: Float, paintBlack: Paint, canvas: Canvas) {
    val path: Path = new Path
    path.moveTo(ax, ay)
    path.lineTo(bx, by)
    path.lineTo(cx, cy)
    path.lineTo(ax, ay)
    canvas.drawPath(path, paintBlack)
  }
}

