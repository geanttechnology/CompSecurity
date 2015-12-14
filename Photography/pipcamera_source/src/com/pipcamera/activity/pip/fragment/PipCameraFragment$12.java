// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.util.Log;
import android.view.MotionEvent;
import java.io.PrintStream;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements android.view.tureListener
{

    final PipCameraFragment a;

    public boolean onDown(MotionEvent motionevent)
    {
        System.out.println("onDown");
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        System.out.println("onFling");
        MotionEvent motionevent2 = motionevent;
        if (motionevent == null)
        {
            motionevent2 = motionevent1;
        }
        Log.i("PipCameraFragment", (new StringBuilder()).append("onFling,e1,x:").append(motionevent1.getX() - motionevent2.getX()).append("  y:").append(motionevent1.getY() - motionevent2.getY()).append("  distanceX").append(f).append("  distanceY").append(f1).toString());
        if (motionevent1.getY() - motionevent2.getY() > 50F && Math.abs(f1) > 100F && PipCameraFragment.a(a))
        {
            a.b = false;
            a.a(false);
        }
        return false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
        System.out.println("onLongPress");
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
        System.out.println("onShowPress");
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        System.out.println("onSingleTapUp");
        return false;
    }

    (PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
