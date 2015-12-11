// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.t;
import android.support.v4.app.u;
import android.support.v7.internal.a.b;
import android.widget.RemoteViews;
import java.util.List;

public final class n extends u
{
    public static final class a extends android.support.v4.app.u.d
    {

        protected final android.support.v4.app.u.e c()
        {
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                return new d((byte)0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                return new c((byte)0);
            }
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                return new b((byte)0);
            } else
            {
                return super.c();
            }
        }

        public a(Context context)
        {
            super(context);
        }
    }

    private static final class b extends android.support.v4.app.u.e
    {

        public final Notification a(android.support.v4.app.u.d d1, t t1)
        {
            n.a(t1, d1);
            return t1.b();
        }

        private b()
        {
        }

        b(byte byte0)
        {
            this();
        }
    }

    private static final class c extends android.support.v4.app.u.e
    {

        public final Notification a(android.support.v4.app.u.d d1, t t1)
        {
            n.a(t1, d1);
            t1 = t1.b();
            n.a(t1, d1);
            return t1;
        }

        private c()
        {
        }

        c(byte byte0)
        {
            this();
        }
    }

    private static final class d extends android.support.v4.app.u.e
    {

        public final Notification a(android.support.v4.app.u.d d1, t t1)
        {
            android.support.v7.a.n.b(t1, d1.m);
            return t1.b();
        }

        private d()
        {
        }

        d(byte byte0)
        {
            this();
        }
    }

    public static final class e extends android.support.v4.app.u.p
    {

        public int a[];
        public android.support.v4.media.session.MediaSessionCompat.Token b;
        boolean c;
        PendingIntent h;

        public e()
        {
            a = null;
        }
    }


    static void a(Notification notification, android.support.v4.app.u.d d1)
    {
        if (d1.m instanceof e)
        {
            Object obj1 = (e)d1.m;
            Context context = d1.a;
            Object obj = d1.b;
            CharSequence charsequence = d1.c;
            CharSequence charsequence1 = d1.h;
            int k = d1.i;
            android.graphics.Bitmap bitmap = d1.g;
            CharSequence charsequence2 = d1.n;
            boolean flag = d1.l;
            long l = d1.B.when;
            d1 = d1.u;
            boolean flag1 = ((e) (obj1)).c;
            obj1 = ((e) (obj1)).h;
            int j = Math.min(d1.size(), 5);
            int i;
            if (j <= 3)
            {
                i = android.support.v7.b.a.h.notification_template_big_media_narrow;
            } else
            {
                i = android.support.v7.b.a.h.notification_template_big_media;
            }
            obj = android.support.v7.internal.a.b.a(context, ((CharSequence) (obj)), charsequence, charsequence1, k, bitmap, charsequence2, flag, l, i, false);
            ((RemoteViews) (obj)).removeAllViews(android.support.v7.b.a.f.media_actions);
            if (j > 0)
            {
                for (i = 0; i < j; i++)
                {
                    RemoteViews remoteviews = android.support.v7.internal.a.b.a(context, (android.support.v4.app.x.a)d1.get(i));
                    ((RemoteViews) (obj)).addView(android.support.v7.b.a.f.media_actions, remoteviews);
                }

            }
            if (flag1)
            {
                ((RemoteViews) (obj)).setViewVisibility(android.support.v7.b.a.f.cancel_action, 0);
                ((RemoteViews) (obj)).setInt(android.support.v7.b.a.f.cancel_action, "setAlpha", context.getResources().getInteger(android.support.v7.b.a.g.cancel_button_image_alpha));
                ((RemoteViews) (obj)).setOnClickPendingIntent(android.support.v7.b.a.f.cancel_action, ((PendingIntent) (obj1)));
            } else
            {
                ((RemoteViews) (obj)).setViewVisibility(android.support.v7.b.a.f.cancel_action, 8);
            }
            notification.bigContentView = ((RemoteViews) (obj));
            if (flag1)
            {
                notification.flags = notification.flags | 2;
            }
        }
    }

    static void a(t t1, android.support.v4.app.u.d d1)
    {
        if (d1.m instanceof e)
        {
            Object obj1 = (e)d1.m;
            Context context = d1.a;
            Object obj = d1.b;
            CharSequence charsequence = d1.c;
            CharSequence charsequence1 = d1.h;
            int i = d1.i;
            android.graphics.Bitmap bitmap = d1.g;
            CharSequence charsequence2 = d1.n;
            boolean flag = d1.l;
            long l = d1.B.when;
            d1 = d1.u;
            int ai[] = ((e) (obj1)).a;
            boolean flag1 = ((e) (obj1)).c;
            obj1 = ((e) (obj1)).h;
            obj = android.support.v7.internal.a.b.a(context, ((CharSequence) (obj)), charsequence, charsequence1, i, bitmap, charsequence2, flag, l, android.support.v7.b.a.h.notification_template_media, true);
            int k = d1.size();
            if (ai == null)
            {
                i = 0;
            } else
            {
                i = Math.min(ai.length, 3);
            }
            ((RemoteViews) (obj)).removeAllViews(android.support.v7.b.a.f.media_actions);
            if (i > 0)
            {
                for (int j = 0; j < i; j++)
                {
                    if (j >= k)
                    {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[] {
                            Integer.valueOf(j), Integer.valueOf(k - 1)
                        }));
                    }
                    RemoteViews remoteviews = android.support.v7.internal.a.b.a(context, (android.support.v4.app.x.a)d1.get(ai[j]));
                    ((RemoteViews) (obj)).addView(android.support.v7.b.a.f.media_actions, remoteviews);
                }

            }
            if (flag1)
            {
                ((RemoteViews) (obj)).setViewVisibility(android.support.v7.b.a.f.end_padder, 8);
                ((RemoteViews) (obj)).setViewVisibility(android.support.v7.b.a.f.cancel_action, 0);
                ((RemoteViews) (obj)).setOnClickPendingIntent(android.support.v7.b.a.f.cancel_action, ((PendingIntent) (obj1)));
                ((RemoteViews) (obj)).setInt(android.support.v7.b.a.f.cancel_action, "setAlpha", context.getResources().getInteger(android.support.v7.b.a.g.cancel_button_image_alpha));
            } else
            {
                ((RemoteViews) (obj)).setViewVisibility(android.support.v7.b.a.f.end_padder, 0);
                ((RemoteViews) (obj)).setViewVisibility(android.support.v7.b.a.f.cancel_action, 8);
            }
            t1.a().setContent(((RemoteViews) (obj)));
            if (flag1)
            {
                t1.a().setOngoing(true);
            }
        }
    }

    static void b(t t1, android.support.v4.app.u.p p)
    {
        if (p instanceof e)
        {
            p = (e)p;
            int ai[] = ((e) (p)).a;
            if (((e) (p)).b != null)
            {
                p = ((android.support.v4.app.u.p) (((e) (p)).b.a));
            } else
            {
                p = null;
            }
            t1 = new android.app.Notification.MediaStyle(t1.a());
            if (ai != null)
            {
                t1.setShowActionsInCompactView(ai);
            }
            if (p != null)
            {
                t1.setMediaSession((android.media.session.MediaSession.Token)p);
            }
        }
    }
}
