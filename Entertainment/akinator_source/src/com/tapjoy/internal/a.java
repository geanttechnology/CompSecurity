// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tapjoy.internal:
//            b

public final class com.tapjoy.internal.a
{
    public static final class a
    {

        public int a;
        public CharSequence b;
        public PendingIntent c;
    }

    public static final class b extends l
    {

        Bitmap a;
        Bitmap b;
        boolean c;

        public b()
        {
        }
    }

    public static final class c extends l
    {

        public CharSequence a;

        public c()
        {
        }
    }

    public static final class d
    {

        Context a;
        public CharSequence b;
        public CharSequence c;
        public PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        Bitmap g;
        CharSequence h;
        int i;
        int j;
        boolean k;
        l l;
        CharSequence m;
        int n;
        int o;
        boolean p;
        ArrayList q;
        public Notification r;

        public final d a(l l1)
        {
            if (l != l1)
            {
                l = l1;
                if (l != null)
                {
                    l1 = l;
                    if (l1.d != this)
                    {
                        l1.d = this;
                        if (l1.d != null)
                        {
                            l1.d.a(l1);
                        }
                    }
                }
            }
            return this;
        }

        public d(Context context)
        {
            q = new ArrayList();
            r = new Notification();
            a = context;
            r.when = System.currentTimeMillis();
            r.audioStreamType = -1;
            j = 0;
        }
    }

    public static final class e extends l
    {

        ArrayList a;

        public e()
        {
            a = new ArrayList();
        }
    }

    public static interface f
    {

        public abstract Notification a(d d1);
    }

    static class g
        implements f
    {

        public Notification a(d d1)
        {
            Notification notification = d1.r;
            notification.setLatestEventInfo(d1.a, d1.b, d1.c, d1.d);
            if (d1.j > 0)
            {
                notification.flags = notification.flags | 0x80;
            }
            return notification;
        }

        g()
        {
        }
    }

    static final class h extends g
    {

        public final Notification a(d d1)
        {
            Notification notification = d1.r;
            notification.setLatestEventInfo(d1.a, d1.b, d1.c, d1.d);
            Context context = d1.a;
            CharSequence charsequence = d1.b;
            CharSequence charsequence1 = d1.c;
            PendingIntent pendingintent = d1.d;
            PendingIntent pendingintent1 = d1.e;
            notification.setLatestEventInfo(context, charsequence, charsequence1, pendingintent);
            notification.fullScreenIntent = pendingintent1;
            if (d1.j > 0)
            {
                notification.flags = notification.flags | 0x80;
            }
            return notification;
        }

        h()
        {
        }
    }

    static final class i
        implements f
    {

        public final Notification a(d d1)
        {
            Object obj1 = d1.a;
            Notification notification = d1.r;
            Object obj = d1.b;
            CharSequence charsequence = d1.c;
            CharSequence charsequence1 = d1.h;
            RemoteViews remoteviews = d1.f;
            int i1 = d1.i;
            PendingIntent pendingintent1 = d1.d;
            PendingIntent pendingintent = d1.e;
            d1 = d1.g;
            obj1 = (new android.app.Notification.Builder(((Context) (obj1)))).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteviews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            boolean flag;
            if ((notification.flags & 2) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = ((android.app.Notification.Builder) (obj1)).setOngoing(flag);
            if ((notification.flags & 8) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = ((android.app.Notification.Builder) (obj1)).setOnlyAlertOnce(flag);
            if ((notification.flags & 0x10) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = ((android.app.Notification.Builder) (obj1)).setAutoCancel(flag).setDefaults(notification.defaults).setContentTitle(((CharSequence) (obj))).setContentText(charsequence).setContentInfo(charsequence1).setContentIntent(pendingintent1).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return ((android.app.Notification.Builder) (obj)).setFullScreenIntent(pendingintent, flag).setLargeIcon(d1).setNumber(i1).getNotification();
        }

        i()
        {
        }
    }

    static final class j
        implements f
    {

        public final Notification a(d d1)
        {
            Context context = d1.a;
            Notification notification = d1.r;
            CharSequence charsequence = d1.b;
            CharSequence charsequence1 = d1.c;
            CharSequence charsequence2 = d1.h;
            RemoteViews remoteviews = d1.f;
            int i1 = d1.i;
            PendingIntent pendingintent1 = d1.d;
            PendingIntent pendingintent = d1.e;
            Bitmap bitmap = d1.g;
            int j1 = d1.n;
            int k1 = d1.o;
            boolean flag1 = d1.p;
            d1 = (new android.app.Notification.Builder(context)).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteviews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            boolean flag;
            if ((notification.flags & 2) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d1 = d1.setOngoing(flag);
            if ((notification.flags & 8) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d1 = d1.setOnlyAlertOnce(flag);
            if ((notification.flags & 0x10) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d1 = d1.setAutoCancel(flag).setDefaults(notification.defaults).setContentTitle(charsequence).setContentText(charsequence1).setContentInfo(charsequence2).setContentIntent(pendingintent1).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return d1.setFullScreenIntent(pendingintent, flag).setLargeIcon(bitmap).setNumber(i1).setProgress(j1, k1, flag1).getNotification();
        }

        j()
        {
        }
    }

    static final class k
        implements f
    {

        public final Notification a(d d1)
        {
            com.tapjoy.internal.b b1;
            b1 = new com.tapjoy.internal.b(d1.a, d1.r, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.n, d1.o, d1.p, d1.k, d1.j, d1.m);
            CharSequence charsequence;
            Object obj3;
            int i1;
            for (Iterator iterator = d1.q.iterator(); iterator.hasNext(); b1.a.addAction(i1, charsequence, ((PendingIntent) (obj3))))
            {
                obj3 = (a)iterator.next();
                i1 = ((a) (obj3)).a;
                charsequence = ((a) (obj3)).b;
                obj3 = ((a) (obj3)).c;
            }

            if (d1.l == null) goto _L2; else goto _L1
_L1:
            if (!(d1.l instanceof c)) goto _L4; else goto _L3
_L3:
            Object obj1 = (c)d1.l;
            Object obj = ((c) (obj1)).e;
            boolean flag = ((c) (obj1)).g;
            d1 = ((c) (obj1)).f;
            obj1 = ((c) (obj1)).a;
            obj = (new android.app.Notification.BigTextStyle(b1.a)).setBigContentTitle(((CharSequence) (obj))).bigText(((CharSequence) (obj1)));
            if (flag)
            {
                ((android.app.Notification.BigTextStyle) (obj)).setSummaryText(d1);
            }
_L2:
            return b1.a.build();
_L4:
            if (d1.l instanceof e)
            {
                d1 = (e)d1.l;
                b1.a(((e) (d1)).e, ((e) (d1)).g, ((e) (d1)).f, ((e) (d1)).a);
            } else
            if (d1.l instanceof b)
            {
                Object obj2 = (b)d1.l;
                CharSequence charsequence1 = ((b) (obj2)).e;
                boolean flag1 = ((b) (obj2)).g;
                d1 = ((b) (obj2)).f;
                Bitmap bitmap1 = ((b) (obj2)).a;
                Bitmap bitmap = ((b) (obj2)).b;
                boolean flag2 = ((b) (obj2)).c;
                obj2 = (new android.app.Notification.BigPictureStyle(b1.a)).setBigContentTitle(charsequence1).bigPicture(bitmap1);
                if (flag2)
                {
                    ((android.app.Notification.BigPictureStyle) (obj2)).bigLargeIcon(bitmap);
                }
                if (flag1)
                {
                    ((android.app.Notification.BigPictureStyle) (obj2)).setSummaryText(d1);
                }
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        k()
        {
        }
    }

    public static abstract class l
    {

        d d;
        public CharSequence e;
        CharSequence f;
        boolean g;

        public l()
        {
            g = false;
        }
    }


    private static final f a;

    public static f a()
    {
        return a;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new k();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new j();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new i();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            a = new h();
        } else
        {
            a = new g();
        }
    }
}
