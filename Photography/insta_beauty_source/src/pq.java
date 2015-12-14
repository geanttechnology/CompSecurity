// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;

class pq
    implements Runnable
{

    final Bitmap a;
    final pp b;

    pq(pp pp1, Bitmap bitmap)
    {
        b = pp1;
        a = bitmap;
        super();
    }

    public void run()
    {
        if (pn.a(b.f) != null)
        {
            pn.a(b.f).a(a, b.e);
        }
    }
}
