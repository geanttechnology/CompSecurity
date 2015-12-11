// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Notification;

final class az extends aw
{

    az()
    {
    }

    public final Notification a(au au1)
    {
        Notification notification = au1.i;
        notification.setLatestEventInfo(au1.a, null, null, au1.b);
        notification.setLatestEventInfo(au1.a, null, null, au1.b);
        notification.fullScreenIntent = null;
        return notification;
    }
}
