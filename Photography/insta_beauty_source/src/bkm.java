// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;

class bkm
    implements android.view.GestureDetector.OnGestureListener
{

    final bkl a;

    bkm(bkl bkl1)
    {
        a = bkl1;
        super();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        motionevent = a.a(motionevent.getX(), motionevent.getY());
        if (motionevent != null)
        {
            a.b(motionevent);
            a.a(motionevent);
        }
        return true;
    }
}
