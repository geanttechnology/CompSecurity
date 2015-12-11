// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.al;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import com.shazam.android.aq.l;

// Referenced classes of package com.shazam.android.al:
//            b

public final class a
    implements b
{

    private final NotificationManager a;
    private final Context b;
    private final l c;

    public a(Context context, l l1, NotificationManager notificationmanager)
    {
        b = context;
        c = l1;
        a = notificationmanager;
    }

    public final void a(String s, String s1, int i)
    {
        s1 = (new android.support.v4.app.u.d(b)).e(s).a(s1).a(((Integer)c.a()).intValue());
        android.content.Intent intent = com.shazam.android.activities.b.a.b(b, false);
        s1.d = PendingIntent.getActivity(b, 0, intent, 0x40000000);
        s1.i = i;
        s = s1.b(s).a((new android.support.v4.app.u.c()).b(s));
        s.y = b.getResources().getColor(0x7f0f007b);
        s = s.a().b();
        a.cancel(1230);
        a.notify(null, 1230, s);
    }
}
