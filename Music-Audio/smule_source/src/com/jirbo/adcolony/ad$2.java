// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.view.View;

// Referenced classes of package com.jirbo.adcolony:
//            ad, ac, m

class a
    implements android.view.OnClickListener
{

    final ad a;

    public void onClick(View view)
    {
        if (a.m)
        {
            if (a.E != null)
            {
                a.E.a(a, true);
            }
            a.a(true, true);
            a.r = true;
        } else
        if (a.L == a.H.a)
        {
            if (a.E != null)
            {
                a.E.a(a, false);
            }
            a.r = false;
            a.a(false, true);
            return;
        }
    }

    kListener(ad ad1)
    {
        a = ad1;
        super();
    }
}
