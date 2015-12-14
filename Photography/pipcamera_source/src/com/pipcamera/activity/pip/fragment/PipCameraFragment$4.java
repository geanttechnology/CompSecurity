// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements android.view.
{

    final PipCameraFragment a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        PipCameraFragment.m(a).onTouchEvent(motionevent);
        return false;
    }

    (PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
