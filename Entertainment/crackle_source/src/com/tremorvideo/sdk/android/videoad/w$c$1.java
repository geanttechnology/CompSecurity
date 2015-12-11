// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            w

class a
    implements android.view.nTouchListener
{

    final w a;
    final b b;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
        {
            b.b = false;
        } else
        {
            b.b = true;
        }
        view.invalidate();
        return false;
    }

    ( , w w1)
    {
        b = ;
        a = w1;
        super();
    }
}
