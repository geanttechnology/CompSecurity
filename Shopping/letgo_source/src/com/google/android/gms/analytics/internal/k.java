// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.support.v7.vn;
import com.google.android.gms.common.internal.x;

class k
{

    private final vn a;
    private long b;

    public k(vn vn1)
    {
        x.a(vn1);
        a = vn1;
    }

    public k(vn vn1, long l)
    {
        x.a(vn1);
        a = vn1;
        b = l;
    }

    public void a()
    {
        b = a.b();
    }

    public boolean a(long l)
    {
        while (b == 0L || a.b() - b > l) 
        {
            return true;
        }
        return false;
    }

    public void b()
    {
        b = 0L;
    }
}
