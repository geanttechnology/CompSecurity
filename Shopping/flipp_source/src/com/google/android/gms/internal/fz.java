// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.c;

public final class fz
    implements b
{

    private final c a;

    public fz(c c1)
    {
        a = c1;
    }

    public final void a()
    {
        a.a_();
    }

    public final void b()
    {
        a.b();
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof fz)
        {
            return a.equals(((fz)obj).a);
        } else
        {
            return a.equals(obj);
        }
    }
}
