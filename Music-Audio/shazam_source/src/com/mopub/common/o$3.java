// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;

// Referenced classes of package com.mopub.common:
//            o

final class t>
    implements t>
{

    final Context a;
    final boolean b;
    final Iterable c;
    final String d;
    final o e;

    public final void a(String s)
    {
        o.a(e);
        e.b(a, s, b, c);
    }

    public final void a(String s, Throwable throwable)
    {
        o.a(e);
        o.a(s, throwable);
    }

    xt(o o1, Context context, boolean flag, Iterable iterable, String s)
    {
        e = o1;
        a = context;
        b = flag;
        c = iterable;
        d = s;
        super();
    }
}
