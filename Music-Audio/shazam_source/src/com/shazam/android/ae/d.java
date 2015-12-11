// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import android.content.res.Resources;
import com.shazam.b.a.a;

public final class d
    implements a
{

    private final String a;

    public d(Resources resources)
    {
        a = resources.getString(0x7f090289);
    }

    public final Object a(Object obj)
    {
        obj = (a.a.a.a.a)obj;
        com.shazam.android.j.q.a.a a1 = new com.shazam.android.j.q.a.a();
        a1.d = ((a.a.a.a.a) (obj)).c;
        a1.e = ((a.a.a.a.a) (obj)).b;
        a1.b = ((a.a.a.a.a) (obj)).d;
        a1.f = a;
        return a1.a();
    }
}
