// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import com.shazam.b.a.a;

public final class d
    implements a
{

    private final a a[];

    public transient d(a aa[])
    {
        a = aa;
    }

    public final Object a(Object obj)
    {
        a aa[] = a;
        int j = aa.length;
        for (int i = 0; i < j; i++)
        {
            obj = aa[i].a(obj);
        }

        return obj;
    }
}
