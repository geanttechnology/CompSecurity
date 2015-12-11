// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            t, ac, u, ae, 
//            z, aa

public class v
{
    public static class a extends y.a
    {

        public static final y.a.a d = new y.a.a() {

        };
        public int a;
        public CharSequence b;
        public PendingIntent c;
        private final Bundle e;
        private final ae f[];

        public int a()
        {
            return a;
        }

        public CharSequence b()
        {
            return b;
        }

        public PendingIntent c()
        {
            return c;
        }

        public Bundle d()
        {
            return e;
        }

        public ae[] e()
        {
            return f;
        }

        public ag.a[] f()
        {
            return e();
        }

    }

    public static class b extends p
    {

        Bitmap a;
        Bitmap b;
        boolean c;

        public b()
        {
        }
    }

    public static class c extends p
    {

        CharSequence a;

        public c a(CharSequence charsequence)
        {
            a = d.d(charsequence);
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
        PendingIntent d;
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
        int y;
        int z;

        private void a(int i1, boolean flag)
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

        protected static CharSequence d(CharSequence charsequence)
        {
            while (charsequence == null || charsequence.length() <= 5120) 
            {
                return charsequence;
            }
            return charsequence.subSequence(0, 5120);
        }

        public Notification a()
        {
            return v.a().a(this, b());
        }

        public d a(int i1)
        {
            B.icon = i1;
            return this;
        }

        public d a(int i1, int j1, int k1)
        {
            boolean flag = true;
            B.ledARGB = i1;
            B.ledOnMS = j1;
            B.ledOffMS = k1;
            Notification notification;
            if (B.ledOnMS != 0 && B.ledOffMS != 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            notification = B;
            j1 = B.flags;
            if (i1 != 0)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            notification.flags = j1 & -2 | i1;
            return this;
        }

        public d a(int i1, int j1, boolean flag)
        {
            o = i1;
            p = j1;
            q = flag;
            return this;
        }

        public d a(PendingIntent pendingintent)
        {
            d = pendingintent;
            return this;
        }

        public d a(Uri uri)
        {
            B.sound = uri;
            B.audioStreamType = -1;
            return this;
        }

        public d a(p p1)
        {
            if (m != p1)
            {
                m = p1;
                if (m != null)
                {
                    m.a(this);
                }
            }
            return this;
        }

        public d a(CharSequence charsequence)
        {
            b = d(charsequence);
            return this;
        }

        public d a(boolean flag)
        {
            a(16, flag);
            return this;
        }

        public d a(long al[])
        {
            B.vibrate = al;
            return this;
        }

        public d b(int i1)
        {
            B.defaults = i1;
            if ((i1 & 4) != 0)
            {
                Notification notification = B;
                notification.flags = notification.flags | 1;
            }
            return this;
        }

        public d b(CharSequence charsequence)
        {
            c = d(charsequence);
            return this;
        }

        protected e b()
        {
            return new e();
        }

        public d c(CharSequence charsequence)
        {
            B.tickerText = d(charsequence);
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

        public Notification a(d d1, u u1)
        {
            return u1.b();
        }

        protected e()
        {
        }
    }

    public static class f extends p
    {

        ArrayList a;

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
            w.a a1 = new w.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q, d1.k, d1.l, d1.j, d1.n, d1.v, d1.C, d1.x, d1.r, d1.s, d1.t);
            v.a(a1, d1.u);
            v.a(a1, d1.m);
            return e1.a(d1, a1);
        }

        h()
        {
        }
    }

    static class i extends h
    {

        public Notification a(d d1, e e1)
        {
            x.a a1 = new x.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q, d1.k, d1.l, d1.j, d1.n, d1.v, d1.w, d1.C, d1.x, d1.y, d1.z, d1.A, d1.r, d1.s, d1.t);
            v.a(a1, d1.u);
            v.a(a1, d1.m);
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

    static class k extends j
    {

        public Notification a(d d1, e e1)
        {
            e1 = d1.B;
            e1.setLatestEventInfo(d1.a, d1.b, d1.c, d1.d);
            e1 = z.a(e1, d1.a, d1.b, d1.c, d1.d, d1.e);
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

    static class l extends j
    {

        public Notification a(d d1, e e1)
        {
            return aa.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g);
        }

        l()
        {
        }
    }

    static class m extends j
    {

        public Notification a(d d1, e e1)
        {
            return e1.a(d1, new ab.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q));
        }

        m()
        {
        }
    }

    static class n extends j
    {

        public Notification a(d d1, e e1)
        {
            ac.a a1 = new ac.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q, d1.l, d1.j, d1.n, d1.v, d1.x, d1.r, d1.s, d1.t);
            v.a(a1, d1.u);
            v.a(a1, d1.m);
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
            ad.a a1 = new ad.a(d1.a, d1.B, d1.b, d1.c, d1.h, d1.f, d1.i, d1.d, d1.e, d1.g, d1.o, d1.p, d1.q, d1.k, d1.l, d1.j, d1.n, d1.v, d1.C, d1.x, d1.r, d1.s, d1.t);
            v.a(a1, d1.u);
            v.a(a1, d1.m);
            return e1.a(d1, a1);
        }

        o()
        {
        }
    }

    public static abstract class p
    {

        d d;
        CharSequence e;
        CharSequence f;
        boolean g;

        public void a(d d1)
        {
            if (d != d1)
            {
                d = d1;
                if (d != null)
                {
                    d.a(this);
                }
            }
        }

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

    static void a(t t1, ArrayList arraylist)
    {
        b(t1, arraylist);
    }

    static void a(u u, p p1)
    {
        b(u, p1);
    }

    private static void b(t t1, ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); t1.a((a)arraylist.next())) { }
    }

    private static void b(u u, p p1)
    {
        if (p1 != null)
        {
            if (p1 instanceof c)
            {
                p1 = (c)p1;
                ac.a(u, ((c) (p1)).e, ((c) (p1)).g, ((c) (p1)).f, ((c) (p1)).a);
            } else
            {
                if (p1 instanceof f)
                {
                    p1 = (f)p1;
                    ac.a(u, ((f) (p1)).e, ((f) (p1)).g, ((f) (p1)).f, ((f) (p1)).a);
                    return;
                }
                if (p1 instanceof b)
                {
                    p1 = (b)p1;
                    ac.a(u, ((b) (p1)).e, ((b) (p1)).g, ((b) (p1)).f, ((b) (p1)).a, ((b) (p1)).b, ((b) (p1)).c);
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
