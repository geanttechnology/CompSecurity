// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.view.MotionEvent;
import android.view.View;
import com.mopub.mobileads.ar;

// Referenced classes of package com.mopub.b:
//            a

final class 
    implements android.view..OnTouchListener
{

    final ar a;
    final a b;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        a.a(motionevent);
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 36
    //                   0 38
    //                   1 38;
           goto _L1 _L2 _L2
_L1:
        return false;
_L2:
        if (!view.hasFocus())
        {
            view.requestFocus();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    ads.ar(a a1, ar ar1)
    {
        b = a1;
        a = ar1;
        super();
    }
}
