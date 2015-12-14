// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            u

class a
    implements android.view..OnTouchListener
{

    final u a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 1 3: default 32
    //                   1 41
    //                   2 32
    //                   3 56;
           goto _L1 _L2 _L1 _L3
_L1:
        u.h(a);
_L5:
        return false;
_L2:
        view.performClick();
        u.g(a);
        continue; /* Loop/switch isn't completed */
_L3:
        u.g(a);
        if (true) goto _L5; else goto _L4
_L4:
    }

    (u u1)
    {
        a = u1;
        super();
    }
}
