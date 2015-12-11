// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;

// Referenced classes of package com.flurry.sdk:
//            eq, dg

public class ep
    implements eq
{

    private final eq a;

    public ep(eq eq1)
    {
        a = eq1;
    }

    public void a(dg dg)
    {
        if (a != null)
        {
            a.a(dg);
        }
    }

    public void a(dg dg, Context context)
    {
        if (a != null)
        {
            a.a(dg, context);
        }
    }

    public void b(dg dg, Context context)
    {
        if (a != null)
        {
            a.b(dg, context);
        }
    }

    public void c(dg dg, Context context)
    {
        if (a != null)
        {
            a.c(dg, context);
        }
    }
}
