// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.android.aq.q;
import com.shazam.android.h.b;
import com.shazam.android.k.f.p;
import com.shazam.android.l.g.a;
import com.shazam.i.b.ah.f.e;
import com.shazam.i.b.c;
import com.shazam.i.d.d;
import com.shazam.k.s;
import java.util.List;
import java.util.concurrent.Executors;

public class UnsubmittedTagMatchedNotificationReceiver extends BroadcastReceiver
{

    private final NotificationManager a;
    private final s b;
    private final com.shazam.android.h.a c;

    public UnsubmittedTagMatchedNotificationReceiver()
    {
        this(com.shazam.i.b.c.b(), e.a(), ((com.shazam.android.h.a) (new b(new a(com.shazam.i.b.c.a(), new q(), new p(), d.f(), Executors.newSingleThreadExecutor(com.shazam.i.q.a.b("BigPictureStyleNotificationConverter-%d").b()), new com.shazam.android.z.a()), new com.shazam.android.l.g.d(com.shazam.i.b.c.a(), new q(), new p())))));
    }

    public UnsubmittedTagMatchedNotificationReceiver(NotificationManager notificationmanager, s s1, com.shazam.android.h.a a1)
    {
        a = notificationmanager;
        b = s1;
        c = a1;
    }

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            context = b.c();
            context = (Notification)((com.shazam.b.a.a)c.a(Integer.valueOf(context.size()))).a(context);
            a.notify("com.shazam.android.service.unsubmitted.MatchedUnsubmittedTagNotifier.tag", 0xf7277, context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a.cancel(0xf7277);
        }
    }
}
