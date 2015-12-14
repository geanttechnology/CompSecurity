// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import wantu.sephiroth.android.library.imagezoom.RotateZoomMoveImageViewTouch;

public class cgi
    implements android.view.View.OnTouchListener
{

    final cgj a;
    final RotateZoomMoveImageViewTouch b;

    public cgi(RotateZoomMoveImageViewTouch rotatezoommoveimageviewtouch, cgj cgj1)
    {
        b = rotatezoommoveimageviewtouch;
        a = cgj1;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        b.mScaleDetector.onTouchEvent(motionevent);
        a.a(motionevent);
        view = new PointF(motionevent.getX(), motionevent.getY());
        motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 84
    //                   0 93
    //                   1 247
    //                   2 132
    //                   3 84
    //                   4 84
    //                   5 84
    //                   6 320;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5
_L1:
        b.invalidate();
        return true;
_L2:
        b.last.set(view);
        b.start.set(b.last);
        b.mode = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        if (b.mode == 1)
        {
            float f = ((PointF) (view)).x;
            float f1 = b.last.x;
            float f2 = ((PointF) (view)).y;
            float f3 = b.last.y;
            b.last.set(((PointF) (view)).x, ((PointF) (view)).y);
            view = (android.widget.FrameLayout.LayoutParams)b.getLayoutParams();
            view.setMargins((int)((f - f1) + (float)((android.widget.FrameLayout.LayoutParams) (view)).leftMargin), (int)((f2 - f3) + (float)((android.widget.FrameLayout.LayoutParams) (view)).topMargin), 0, 0);
            b.setLayoutParams(view);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        b.mode = 0;
        int i = (int)Math.abs(((PointF) (view)).x - b.start.x);
        int j = (int)Math.abs(((PointF) (view)).y - b.start.y);
        if (i < 3 && j < 3)
        {
            b.performClick();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        b.mode = 0;
        if (true) goto _L1; else goto _L6
_L6:
    }
}
