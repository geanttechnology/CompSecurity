// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

class hv
    implements Runnable
{

    final Context a;
    final hu b;

    hv(hu hu1, Context context)
    {
        b = hu1;
        a = context;
        super();
    }

    public void run()
    {
        hu.a(b, a);
        hu.a(b, ib.a(a));
        hu.a(b);
        String s = b.a();
        hu.a(b, s);
    }
}
