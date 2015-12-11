// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

// Referenced classes of package android.support.v4.app:
//            u

static final class  extends 
{

    public final Notification a( ,  1)
    {
        1 = .B;
        1.setLatestEventInfo(.a, .b, .c, .d);
        android.content.Context context = .a;
        CharSequence charsequence = .b;
        CharSequence charsequence1 = .c;
        android.app.PendingIntent pendingintent = .d;
        android.app.PendingIntent pendingintent1 = .e;
        1.setLatestEventInfo(context, charsequence, charsequence1, pendingintent);
        1.fullScreenIntent = pendingintent1;
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
