// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

class yk extends yj
{

    private final ScaleGestureDetector f;
    private final android.view.ScaleGestureDetector.OnScaleGestureListener g = new yl(this);

    public yk(Context context)
    {
        super(context);
        f = new ScaleGestureDetector(context, g);
    }

    public boolean a()
    {
        return f.isInProgress();
    }

    public boolean a(MotionEvent motionevent)
    {
        f.onTouchEvent(motionevent);
        return super.a(motionevent);
    }
}
