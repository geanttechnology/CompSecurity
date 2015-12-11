// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Notification;
import android.os.Bundle;

class bd extends bc
{

    bd()
    {
    }

    public Notification a(au au1)
    {
        bl bl1 = new bl(au1.a, au1.i, null, null, null, null, 0, au1.b, null, null, 0, 0, false, au1.d, false, 0, null, false, au1.j, null, null, false, null);
        aq.a(bl1, au1.e);
        aq.a(bl1, null);
        au1 = bj.a(bl1.c);
        if (au1 != null)
        {
            bl1.b.putSparseParcelableArray("android.support.actionExtras", au1);
        }
        bl1.a.setExtras(bl1.b);
        return bl1.a.build();
    }
}
