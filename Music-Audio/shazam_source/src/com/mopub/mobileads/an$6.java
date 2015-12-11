// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import com.mopub.c.p;
import com.mopub.common.m;

// Referenced classes of package com.mopub.mobileads:
//            an, i, ah, am

final class a
    implements android.view.OnTouchListener
{

    final an a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        int j;
        if (a.s)
        {
            j = a.w;
        } else
        {
            j = a.e.getCurrentPosition();
        }
        if (motionevent.getAction() == 1)
        {
            a.x = true;
            view = a.d;
            motionevent = ((i) (a)).a;
            m.a(motionevent, "context cannot be null");
            p.a(((ah) (view)).e, null, Integer.valueOf(j), ((ah) (view)).j, motionevent);
            p.a(((ah) (view)).f, null, Integer.valueOf(j), ((ah) (view)).j, motionevent);
            ((i) (a)).c.();
        }
        return true;
    }

    Listener(an an1)
    {
        a = an1;
        super();
    }
}
