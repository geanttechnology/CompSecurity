// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            s, z, t, ab

public class u
{
    public static final class a extends x.a
    {

        public static final x.a.a d = new x.a.a() {

        };
        public int a;
        public CharSequence b;
        public PendingIntent c;
        private final Bundle e;
        private final ab f[];

        public final int a()
        {
            return a;
        }

        public final CharSequence b()
        {
            return b;
        }

        public final PendingIntent c()
        {
            return c;
        }

        public final Bundle d()
        {
            return e;
        }

        public final volatile ad.a[] e()
        {
            return f;
        }


        public a(int i1, CharSequence charsequence, PendingIntent pendingintent)
        {
            this(i1, charsequence, pendingintent, new Bundle());
        }

        private a(int i1, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle)
        {
            a = i1;
            b = d.f(charsequence);
            c = pendingintent;
            e = bundle;
            f = null;
        }
    }

    public static final class b extends p
    {

        public Bitmap a;
        Bitmap b;
        boolean c;

        public final b a(CharSequence charsequence)
        {
            f = d.f(charsequence);
            g = true;
            return this;
        }

        public b()
        {
        }
    }

    public static final class c extends p
    {

        CharSequence a;

        public final c a(CharSequence charsequence)
        {
            e = d.f(charsequence);
            return this;
        }

        public final c b(CharSequence charsequence)
        {
            a = d.f(charsequence);
            return this;
        }

        public c()
        {
        }
    }

    public static class d
    {

        Notification A;
        public Notification B;
        public ArrayList C;
        public Context a;
        public CharSequence b;
        public CharSequence c;
        public PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        int j;
        boolean k;
        public boolean l;
        public p m;
        public CharSequence n;
        int o;
        int p;
        boolean q;
        String r;
        boolean s;
        String t;
        public ArrayList u;
        boolean v;
        String w;
        Bundle x;
        public int y;
        int z;

        protected static CharSequence f(CharSequence charsequence)
        {
            while (charsequence == null || charsequence.length() <= 5120) 
            {
                return charsequence;
            }
            return charsequence.subSequence(0, 5120);
        }

        public final d a()
        {
            a(16, true);
            return this;
        }

        public final d a(int i1)
        {
            B.icon = i1;
            return this;
        }

        public final d a(int i1, CharSequence charsequence, PendingIntent pendingintent)
        {
            u.add(new a(i1, charsequence, pendingintent));
            return this;
        }

        public final d a(long l1)
        {
            B.when = l1;
            return this;
        }

        public final d a(p p1)
        {
            if (m != p1)
            {
                m = p1;
                if (m != null)
                {
                    p1 = m;
                    if (p1.d != this)
                    {
                        p1.d = this;
                        if (p1.d != null)
                        {
                            p1.d.a(p1);
                        }
                    }
                }
            }
            return this;
        }

        public final d a(CharSequence charsequence)
        {
            b = f(charsequence);
            return this;
        }

        public final void a(int i1, boolean flag)
        {
            if (flag)
            {
                Notification notification = B;
                notification.flags = notification.flags | i1;
                return;
            } else
            {
                Notification notification1 = B;
                notification1.flags = notification1.flags & ~i1;
                return;
            }
        }

        public final Notification b()
        {
            return u.a().a(this, c());
        }

        public final d b(CharSequence charsequence)
        {
            c = f(charsequence);
            return this;
        }

        public final d c(CharSequence charsequence)
        {
            n = f(charsequence);
            return this;
        }

        public e c()
        {
            return new e();
        }

        public final d d(CharSequence charsequence)
        {
            h = f(charsequence);
            return this;
        }

        public final d e(CharSequence charsequence)
        {
            B.tickerText = f(charsequence);
            return this;
        }

        public d(Context context)
        {
            k = true;
            u = new ArrayList();
            v = false;
            y = 0;
            z = 0;
            B = new Notification();
            a = context;
            B.when = System.currentTimeMillis();
            B.audioStreamType = -1;
            j = 0;
            C = new ArrayList();
        }
    }

    protected static class e
    {

        public Notification a(d d1, t t1)
        {
            return t1.b();
        }

        public e()
        {
        }
    }

    public static final class f extends p
    {

        ArrayList a;

        public final f a(CharSequence charsequence)
        {
            a.add(d.f(charsequence));
            return this;
        }

        public f()
        {
            a = new ArrayList();
        }
    }

    static interface g
    {

        public abstract Notification a(d d1, e e1);
    }

    static class h extends o
    {

        public Notification a(d d1, e e1)
        {
            v.a a1 = new v.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q, d1.k, d1.l, d1.j, d1.n, d1.v, d1.C, d1.x, d1.r, d1.s, d1.t);
            u.a(a1, d1.u);
            u.a(a1, d1.m);
            return e1.a(d1, a1);
        }

        h()
        {
        }
    }

    static final class i extends h
    {

        public final Notification a(d d1, e e1)
        {
            w.a a1 = new w.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q, d1.k, d1.l, d1.j, d1.n, d1.v, d1.w, d1.C, d1.x, d1.y, d1.z, d1.A, d1.r, d1.s, d1.t);
            u.a(a1, d1.u);
            u.a(a1, d1.m);
            return e1.a(d1, a1);
        }

        i()
        {
        }
    }

    static class j
        implements g
    {

        public Notification a(d d1, e e1)
        {
            e1 = d1.B;
            e1.setLatestEventInfo(d1.a, d1.b, d1.c, d1.d);
            if (d1.j > 0)
            {
                e1.flags = ((Notification) (e1)).flags | 0x80;
            }
            return e1;
        }

        j()
        {
        }
    }

    static final class k extends j
    {

        public final Notification a(d d1, e e1)
        {
            e1 = d1.B;
            e1.setLatestEventInfo(d1.a, d1.b, d1.c, d1.d);
            Context context = d1.a;
            CharSequence charsequence = d1.b;
            CharSequence charsequence1 = d1.c;
            PendingIntent pendingintent = d1.d;
            PendingIntent pendingintent1 = d1.e;
            e1.setLatestEventInfo(context, charsequence, charsequence1, pendingintent);
            e1.fullScreenIntent = pendingintent1;
            if (d1.j > 0)
            {
                e1.flags = ((Notification) (e1)).flags | 0x80;
            }
            return e1;
        }

        k()
        {
        }
    }

    static final class l extends j
    {

        public final Notification a(d d1, e e1)
        {
            Object obj1 = d1.a;
            e1 = d1.B;
            Object obj = d1.b;
            CharSequence charsequence = d1.c;
            CharSequence charsequence1 = d1.h;
            RemoteViews remoteviews = d1.f;
            int i1 = d1.i;
            PendingIntent pendingintent1 = d1.d;
            PendingIntent pendingintent = d1.e;
            d1 = d1.g;
            obj1 = (new android.app.Notification.Builder(((Context) (obj1)))).setWhen(((Notification) (e1)).when).setSmallIcon(((Notification) (e1)).icon, ((Notification) (e1)).iconLevel).setContent(((Notification) (e1)).contentView).setTicker(((Notification) (e1)).tickerText, remoteviews).setSound(((Notification) (e1)).sound, ((Notification) (e1)).audioStreamType).setVibrate(((Notification) (e1)).vibrate).setLights(((Notification) (e1)).ledARGB, ((Notification) (e1)).ledOnMS, ((Notification) (e1)).ledOffMS);
            boolean flag;
            if ((((Notification) (e1)).flags & 2) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = ((android.app.Notification.Builder) (obj1)).setOngoing(flag);
            if ((((Notification) (e1)).flags & 8) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = ((android.app.Notification.Builder) (obj1)).setOnlyAlertOnce(flag);
            if ((((Notification) (e1)).flags & 0x10) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = ((android.app.Notification.Builder) (obj1)).setAutoCancel(flag).setDefaults(((Notification) (e1)).defaults).setContentTitle(((CharSequence) (obj))).setContentText(charsequence).setContentInfo(charsequence1).setContentIntent(pendingintent1).setDeleteIntent(((Notification) (e1)).deleteIntent);
            if ((((Notification) (e1)).flags & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return ((android.app.Notification.Builder) (obj)).setFullScreenIntent(pendingintent, flag).setLargeIcon(d1).setNumber(i1).getNotification();
        }

        l()
        {
        }
    }

    static final class m extends j
    {

        public final Notification a(d d1, e e1)
        {
            return e1.a(d1, new y.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q));
        }

        m()
        {
        }
    }

    static class n extends j
    {

        public Notification a(d d1, e e1)
        {
            z.a a1 = new z.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q, d1.l, d1.j, d1.n, d1.v, d1.x, d1.r, d1.s, d1.t);
            u.a(a1, d1.u);
            u.a(a1, d1.m);
            return e1.a(d1, a1);
        }

        n()
        {
        }
    }

    static class o extends n
    {

        public Notification a(d d1, e e1)
        {
            aa.a a1 = new aa.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q, d1.k, d1.l, d1.j, d1.n, d1.v, d1.C, d1.x, d1.r, d1.s, d1.t);
            u.a(a1, d1.u);
            u.a(a1, d1.m);
            return e1.a(d1, a1);
        }

        o()
        {
        }
    }

    public static abstract class p
    {

        public d d;
        CharSequence e;
        CharSequence f;
        boolean g;

        public p()
        {
            g = false;
        }
    }


    private static final g a;

    static g a()
    {
        return a;
    }

    static void a(s s1, ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); s1.a((a)arraylist.next())) { }
    }

    static void a(t t, p p1)
    {
        if (p1 != null)
        {
            if (p1 instanceof c)
            {
                p1 = (c)p1;
                z.a(t, ((c) (p1)).e, ((c) (p1)).g, ((c) (p1)).f, ((c) (p1)).a);
            } else
            {
                if (p1 instanceof f)
                {
                    p1 = (f)p1;
                    z.a(t, ((f) (p1)).e, ((f) (p1)).g, ((f) (p1)).f, ((f) (p1)).a);
                    return;
                }
                if (p1 instanceof b)
                {
                    p1 = (b)p1;
                    z.a(t, ((b) (p1)).e, ((b) (p1)).g, ((b) (p1)).f, ((b) (p1)).a, ((b) (p1)).b, ((b) (p1)).c);
                    return;
                }
            }
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            a = new i();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            a = new h();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new o();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new n();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new m();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new l();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            a = new k();
        } else
        {
            a = new j();
        }
    }
}
