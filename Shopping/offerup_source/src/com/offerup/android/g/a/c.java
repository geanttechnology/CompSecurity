// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.view.View;

// Referenced classes of package com.offerup.android.g.a:
//            a, g

final class c
    implements android.view.View.OnClickListener
{

    private a a;

    c(a a1)
    {
        a = a1;
        super();
    }

    public final void onClick(View view)
    {
        if (com.offerup.android.g.a.a.b(a) != null)
        {
            com.offerup.android.g.a.a.b(a).a("itemactions");
        }
    }
}
