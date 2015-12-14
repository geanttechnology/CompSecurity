// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.MotionEvent;
import com.wantu.piprender.Opengles2GLSurfaceView;

public class ble
    implements android.view.GestureDetector.OnGestureListener
{

    private Opengles2GLSurfaceView a;
    private final String b = "Gestrue";

    public ble(Opengles2GLSurfaceView opengles2glsurfaceview)
    {
        a = opengles2glsurfaceview;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        Log.v("Gestrue", "onDown");
        return true;
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
        Log.v("Gestrue", (new StringBuilder()).append("distanceX:").append(f).append("distanceY:").append(f1).toString());
        a.onMove(-f, f1);
        return true;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }
}
