// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.content.Context;

// Referenced classes of package cn.jpush.android.service:
//            g

final class h
    implements Runnable
{

    final Context a;
    final g b;

    h(g g1, Context context)
    {
        b = g1;
        a = context;
        super();
    }

    public final void run()
    {
        g.a(b, a);
        b.c(a);
    }
}
