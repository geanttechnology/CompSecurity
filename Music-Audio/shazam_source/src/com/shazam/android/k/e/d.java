// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.e;

import android.content.Context;
import com.shazam.android.k.b;
import com.shazam.android.k.j;
import com.shazam.android.k.k;
import com.shazam.b.a.a;

public final class d extends k
{

    private final k f;
    private final a g;

    public d(k k1, a a1)
    {
        super(k1.a);
        f = k1;
        g = a1;
    }

    public final b a(Context context)
    {
        context = f.a(context);
        Object obj = ((b) (context)).a;
        obj = g.a(obj);
        com.shazam.android.k.b.a a1 = new com.shazam.android.k.b.a();
        a1.a = obj;
        a1.b = ((b) (context)).b;
        return a1.a();
    }

    public final void a(j j)
    {
        super.a(j);
        f.a(j);
    }

    public final boolean a()
    {
        return f.a();
    }
}
