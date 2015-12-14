// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipStyleFragment

class a
    implements android.view.r
{

    final PipStyleFragment a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        PipStyleFragment.n(a).onTouchEvent(motionevent);
        return false;
    }

    (PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
