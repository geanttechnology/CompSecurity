// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            bl, bm, bh

class bp
{

    bp()
    {
    }

    public Notification a(bl bl1, bm bm)
    {
        bm = bl1.q;
        bm.setLatestEventInfo(bl1.a, bl1.b, bl1.c, bl1.d);
        if (bl1.f > 0)
        {
            bm.flags = ((Notification) (bm)).flags | 0x80;
        }
        return bm;
    }

    public Bundle a(Notification notification)
    {
        return null;
    }

    public ArrayList a(bh abh[])
    {
        return null;
    }
}
