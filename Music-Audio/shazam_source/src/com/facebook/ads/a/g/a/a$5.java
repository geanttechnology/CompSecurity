// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g.a;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.facebook.ads.a.g.a:
//            a

final class a
    implements android.view..OnTouchListener
{

    final a a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            if (a(com.facebook.ads.a.g.a.a.b(a)))
            {
                a.b();
                return true;
            } else
            {
                a.c();
                return true;
            }
        } else
        {
            return false;
        }
    }

    stener(a a1)
    {
        a = a1;
        super();
    }
}
