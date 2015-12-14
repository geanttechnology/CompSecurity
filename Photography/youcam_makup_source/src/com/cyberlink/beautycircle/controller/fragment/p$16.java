// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements android.view.OnTouchListener
{

    final p a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
        {
            p.s(a);
        } else
        {
            p.w(a);
        }
        return false;
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}
