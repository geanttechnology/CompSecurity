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
    final a b;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 && a.getVideoURI() != null)
        {
            com.facebook.ads.a.g.a.a.a(b);
            return true;
        } else
        {
            return false;
        }
    }

    stener(a a1, a a2)
    {
        b = a1;
        a = a2;
        super();
    }
}
