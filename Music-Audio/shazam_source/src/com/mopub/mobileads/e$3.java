// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.View;

// Referenced classes of package com.mopub.mobileads:
//            e, u

final class a
    implements Runnable
{

    final View a;
    final e b;

    public final void run()
    {
        u u1 = b.c;
        if (u1 == null)
        {
            return;
        } else
        {
            u1.removeAllViews();
            u1.addView(a, e.a(b, a));
            return;
        }
    }

    (e e1, View view)
    {
        b = e1;
        a = view;
        super();
    }
}
