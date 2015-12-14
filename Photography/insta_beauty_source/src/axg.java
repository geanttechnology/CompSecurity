// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import com.fotoable.sketch.view.TTieZhiComposeView;

public class axg
    implements android.view.GestureDetector.OnGestureListener
{

    final TTieZhiComposeView a;

    public axg(TTieZhiComposeView ttiezhicomposeview)
    {
        a = ttiezhicomposeview;
        super();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return true;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return true;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        TTieZhiComposeView.access$100(a, motionevent);
        return false;
    }
}
