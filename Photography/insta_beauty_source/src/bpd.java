// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;

class bpd
    implements Runnable
{

    final Drawable a;
    final bpc b;

    bpd(bpc bpc1, Drawable drawable)
    {
        b = bpc1;
        a = drawable;
        super();
    }

    public void run()
    {
        b.b.a(a);
    }
}
