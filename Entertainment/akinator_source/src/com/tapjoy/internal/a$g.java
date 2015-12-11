// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Notification;

// Referenced classes of package com.tapjoy.internal:
//            a

static class 
    implements 
{

    public Notification a( )
    {
        Notification notification = .r;
        notification.setLatestEventInfo(.a, .b, .c, .d);
        if (.j > 0)
        {
            notification.flags = notification.flags | 0x80;
        }
        return notification;
    }

    ()
    {
    }
}
