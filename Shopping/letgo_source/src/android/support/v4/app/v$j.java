// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

// Referenced classes of package android.support.v4.app:
//            v

static class 
    implements 
{

    public Notification a( ,  1)
    {
        1 = .B;
        1.setLatestEventInfo(.a, .b, .c, .d);
        if (.j > 0)
        {
            1.flags = ((Notification) (1)).flags | 0x80;
        }
        return 1;
    }

    ()
    {
    }
}
