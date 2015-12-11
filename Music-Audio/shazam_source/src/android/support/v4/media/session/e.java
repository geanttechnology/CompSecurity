// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioManager;

// Referenced classes of package android.support.v4.media.session:
//            d

public final class e
{

    static int a(long l)
    {
        int j = d.a(l);
        int i = j;
        if ((256L & l) != 0L)
        {
            i = j | 0x100;
        }
        return i;
    }

    public static void a(Context context, PendingIntent pendingintent)
    {
        ((AudioManager)context.getSystemService("audio")).unregisterMediaButtonEventReceiver(pendingintent);
    }
}
