// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.g.c.u;
import com.g.c.y;
import com.shazam.android.aq.l;
import com.shazam.android.k.f.j;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.l.g.e;
import com.shazam.android.l.g.f;
import com.shazam.i.b.c;
import com.shazam.i.m.b;
import com.shazam.model.Tag;
import com.shazam.model.Track;

public class LastShazamReminderReceiver extends BroadcastReceiver
    implements e
{

    private final NotificationManager a;
    private final f b;
    private final com.shazam.android.persistence.n.b c;
    private final Resources d;

    public LastShazamReminderReceiver()
    {
        this(com.shazam.i.b.c.b(), new f(com.shazam.i.b.c.a(), new p(), com.shazam.i.m.b.a(), com.shazam.i.b.c.a().getResources(), new j()), com.shazam.i.b.ah.f.a(), com.shazam.i.b.c.a().getResources());
    }

    public LastShazamReminderReceiver(NotificationManager notificationmanager, f f1, com.shazam.android.persistence.n.b b1, Resources resources)
    {
        a = notificationmanager;
        b = f1;
        c = b1;
        d = resources;
    }

    public static PendingIntent a(Tag tag)
    {
        Track track = tag.track;
        Intent intent = new Intent("com.shazam.android.receiver.LastShazamReminderReciever");
        intent.putExtra("title", track.title);
        intent.putExtra("artist", track.artistName);
        intent.putExtra("url", tag.b());
        return PendingIntent.getBroadcast(com.shazam.i.b.c.a(), 0x1e240, intent, 0x10000000);
    }

    public final void a(Notification notification)
    {
        String s = d.getString(0x7f090235);
        if (c.a(s, true))
        {
            a.notify("LastShazamReminderReciever", 0xf1206, notification);
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj = intent.getStringExtra("title");
        String s = intent.getStringExtra("artist");
        context = intent.getStringExtra("url");
        intent = b;
        intent.f = this;
        Object obj1 = new Intent("android.intent.action.VIEW", ((f) (intent)).c.b());
        ((Intent) (obj1)).addFlags(0x10000000);
        Object obj2 = new com.shazam.android.k.f.i.a();
        com.shazam.android.al.c.a a1 = new com.shazam.android.al.c.a();
        a1.a = true;
        a1.c = "lasttag";
        obj2.c = a1.a();
        j.a(((com.shazam.android.k.f.i.a) (obj2)).a(), ((Intent) (obj1)));
        obj1 = PendingIntent.getActivity(((f) (intent)).b, 0, ((Intent) (obj1)), 0x8000000);
        obj2 = ((f) (intent)).a.getString(0x7f090117);
        obj = ((f) (intent)).a.getString(0x7f090116, new Object[] {
            obj, s
        });
        intent.g = (new android.support.v4.app.u.b()).a(((CharSequence) (obj)));
        obj = (new android.support.v4.app.u.d(((f) (intent)).b)).a(((CharSequence) (obj2))).b(((CharSequence) (obj))).e(((CharSequence) (obj2))).a(((Integer)((f) (intent)).e.a()).intValue()).a(((f) (intent)).g);
        obj.d = ((PendingIntent) (obj1));
        ((android.support.v4.app.u.d) (obj)).a();
        ((f) (intent)).d.a(context).a(intent);
    }
}
