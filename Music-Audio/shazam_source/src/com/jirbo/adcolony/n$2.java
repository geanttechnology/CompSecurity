// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.view.View;

// Referenced classes of package com.jirbo.adcolony:
//            n, c

final class 
    implements android.view..OnClickListener
{

    final n a;

    public final void onClick(View view)
    {
        if (a.m)
        {
            a.a(true, true);
            a.r = true;
        } else
        if (a.K == a.G.a)
        {
            a.r = false;
            a.a(false, true);
            return;
        }
    }

    ckListener(n n1)
    {
        a = n1;
        super();
    }
}
