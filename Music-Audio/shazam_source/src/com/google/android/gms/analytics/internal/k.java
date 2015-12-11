// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;

final class k
{

    long a;
    private final ii b;

    public k(ii ii1)
    {
        w.a(ii1);
        b = ii1;
    }

    public k(ii ii1, long l)
    {
        w.a(ii1);
        b = ii1;
        a = l;
    }

    public final void a()
    {
        a = b.b();
    }

    public final boolean a(long l)
    {
        while (a == 0L || b.b() - a > l) 
        {
            return true;
        }
        return false;
    }
}
