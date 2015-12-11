// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            af

class a
    implements android.view.OnTouchListener
{

    final af a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
        {
            a.a = false;
        } else
        {
            a.a = true;
        }
        af.a(a);
        view.invalidate();
        return false;
    }

    (af af1)
    {
        a = af1;
        super();
    }
}
