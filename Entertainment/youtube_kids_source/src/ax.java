// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Notification;

class ax extends bd
{

    ax()
    {
    }

    public Notification a(au au1)
    {
        bf bf1 = new bf(au1.a, au1.i, null, null, null, null, 0, au1.b, null, null, 0, 0, false, au1.d, false, 0, null, false, au1.j, null, null, false, null);
        aq.a(bf1, au1.e);
        aq.a(bf1, null);
        bf1.a.setExtras(bf1.b);
        return bf1.a.build();
    }
}
