// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

// Referenced classes of package com.aio.downloader.views:
//            TouchImageView

private class <init>
    implements android.view.uchListener
{

    private PointF last;
    final TouchImageView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        PointF pointf;
        TouchImageView.access$8(TouchImageView.this).onTouchEvent(motionevent);
        TouchImageView.access$9(TouchImageView.this).onTouchEvent(motionevent);
        pointf = new PointF(motionevent.getX(), motionevent.getY());
        if (TouchImageView.access$4(TouchImageView.this) != this._fld0 && TouchImageView.access$4(TouchImageView.this) != this._fld0 && TouchImageView.access$4(TouchImageView.this) != this._fld0) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 128
    //                   0 191
    //                   1 374
    //                   2 233
    //                   3 128
    //                   4 128
    //                   5 128
    //                   6 374;
           goto _L2 _L3 _L4 _L5 _L2 _L2 _L2 _L4
_L2:
        setImageMatrix(TouchImageView.access$16(TouchImageView.this));
        if (TouchImageView.access$18(TouchImageView.this) != null)
        {
            TouchImageView.access$18(TouchImageView.this)._mth0(view, motionevent);
        }
        if (TouchImageView.access$19(TouchImageView.this) != null)
        {
            TouchImageView.access$19(TouchImageView.this).onMove();
        }
        return true;
_L3:
        last.set(pointf);
        if (TouchImageView.access$1(TouchImageView.this) != null)
        {
            TouchImageView.access$1(TouchImageView.this)._mth0();
        }
        TouchImageView.access$10(TouchImageView.this, this._fld0);
        continue; /* Loop/switch isn't completed */
_L5:
        if (TouchImageView.access$4(TouchImageView.this) == this._fld0)
        {
            float f2 = pointf.x;
            float f3 = last.x;
            float f = pointf.y;
            float f1 = last.y;
            f2 = TouchImageView.access$13(TouchImageView.this, f2 - f3, TouchImageView.access$11(TouchImageView.this), TouchImageView.access$12(TouchImageView.this));
            f = TouchImageView.access$13(TouchImageView.this, f - f1, TouchImageView.access$14(TouchImageView.this), TouchImageView.access$15(TouchImageView.this));
            TouchImageView.access$16(TouchImageView.this).postTranslate(f2, f);
            TouchImageView.access$17(TouchImageView.this);
            last.set(pointf.x, pointf.y);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        TouchImageView.access$10(TouchImageView.this, this._fld0);
        if (true) goto _L2; else goto _L6
_L6:
    }

    private r()
    {
        this$0 = TouchImageView.this;
        super();
        last = new PointF();
    }

    last(last last1)
    {
        this();
    }
}
