// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper;
import com.cyberlink.youcammakeup.database.more.a.c;
import com.cyberlink.youcammakeup.database.more.a.e;
import com.cyberlink.youcammakeup.database.more.d.f;
import com.cyberlink.youcammakeup.database.more.f.a;
import com.cyberlink.youcammakeup.database.more.l.b;
import com.cyberlink.youcammakeup.database.more.l.d;

// Referenced classes of package com.cyberlink.youcammakeup:
//            Globals

public class h
{

    private static DatabaseOpenHelper a;
    private static SQLiteDatabase b;
    private static SQLiteDatabase c;
    private static b d;
    private static d e;
    private static a f;
    private static com.cyberlink.youcammakeup.database.more.h.d g;
    private static com.cyberlink.youcammakeup.database.more.e.b h;
    private static com.cyberlink.youcammakeup.database.more.k.b i;
    private static com.cyberlink.youcammakeup.database.more.b.b j;
    private static com.cyberlink.youcammakeup.database.more.g.b k;
    private static f l;
    private static com.cyberlink.youcammakeup.database.more.d.d m;
    private static com.cyberlink.youcammakeup.database.more.d.b n;
    private static com.cyberlink.youcammakeup.database.more.h.f o;
    private static com.cyberlink.youcammakeup.database.more.h.b p;
    private static com.cyberlink.youcammakeup.database.more.c.b q;
    private static com.cyberlink.youcammakeup.database.more.j.b r;
    private static com.cyberlink.youcammakeup.database.more.g.d s;
    private static e t;
    private static c u;
    private static com.cyberlink.youcammakeup.database.more.makeup.d v;
    private static com.cyberlink.youcammakeup.database.more.makeup.e w;
    private static com.cyberlink.youcammakeup.database.more.i.c x;
    private static com.cyberlink.youcammakeup.database.more.i.b y;

    public static SQLiteDatabase a()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (b == null)
        {
            b = y().getReadableDatabase();
        }
        sqlitedatabase = b;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public static SQLiteDatabase b()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (c == null)
        {
            c = y().getWritableDatabase();
        }
        sqlitedatabase = c;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public static b c()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        b b1;
        if (d == null)
        {
            d = new b();
        }
        b1 = d;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static d d()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        d d1;
        if (e == null)
        {
            e = new d();
        }
        d1 = e;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public static a e()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        a a1;
        if (f == null)
        {
            f = new a();
        }
        a1 = f;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.h.d f()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.h.d d1;
        if (g == null)
        {
            g = new com.cyberlink.youcammakeup.database.more.h.d();
        }
        d1 = g;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.e.b g()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.e.b b1;
        if (h == null)
        {
            h = new com.cyberlink.youcammakeup.database.more.e.b();
        }
        b1 = h;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.k.b h()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.k.b b1;
        if (i == null)
        {
            i = new com.cyberlink.youcammakeup.database.more.k.b();
        }
        b1 = i;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.b.b i()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.b.b b1;
        if (j == null)
        {
            j = new com.cyberlink.youcammakeup.database.more.b.b();
        }
        b1 = j;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.g.b j()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.g.b b1;
        if (k == null)
        {
            k = new com.cyberlink.youcammakeup.database.more.g.b();
        }
        b1 = k;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static f k()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        f f1;
        if (l == null)
        {
            l = new f();
        }
        f1 = l;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.d.d l()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.d.d d1;
        if (m == null)
        {
            m = new com.cyberlink.youcammakeup.database.more.d.d();
        }
        d1 = m;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.d.b m()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.d.b b1;
        if (n == null)
        {
            n = new com.cyberlink.youcammakeup.database.more.d.b();
        }
        b1 = n;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.h.f n()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.h.f f1;
        if (o == null)
        {
            o = new com.cyberlink.youcammakeup.database.more.h.f();
        }
        f1 = o;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.h.b o()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.h.b b1;
        if (p == null)
        {
            p = new com.cyberlink.youcammakeup.database.more.h.b();
        }
        b1 = p;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.c.b p()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.c.b b1;
        if (q == null)
        {
            q = new com.cyberlink.youcammakeup.database.more.c.b();
        }
        b1 = q;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.j.b q()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.j.b b1;
        if (r == null)
        {
            r = new com.cyberlink.youcammakeup.database.more.j.b();
        }
        b1 = r;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.g.d r()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.g.d d1;
        if (s == null)
        {
            s = new com.cyberlink.youcammakeup.database.more.g.d();
        }
        d1 = s;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public static e s()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        e e1;
        if (t == null)
        {
            t = new e();
        }
        e1 = t;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return e1;
        Exception exception;
        exception;
        throw exception;
    }

    public static c t()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        c c1;
        if (u == null)
        {
            u = new c();
        }
        c1 = u;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.makeup.d u()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.makeup.d d1;
        if (v == null)
        {
            v = new com.cyberlink.youcammakeup.database.more.makeup.d();
        }
        d1 = v;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.makeup.e v()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.makeup.e e1;
        if (w == null)
        {
            w = new com.cyberlink.youcammakeup.database.more.makeup.e();
        }
        e1 = w;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return e1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.i.c w()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.i.c c1;
        if (x == null)
        {
            x = new com.cyberlink.youcammakeup.database.more.i.c();
        }
        c1 = x;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.more.i.b x()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.more.i.b b1;
        if (y == null)
        {
            y = new com.cyberlink.youcammakeup.database.more.i.b();
        }
        b1 = y;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    private static DatabaseOpenHelper y()
    {
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorenter ;
        DatabaseOpenHelper databaseopenhelper;
        if (a == null)
        {
            a = new DatabaseOpenHelper(com.cyberlink.youcammakeup.Globals.d());
        }
        databaseopenhelper = a;
        com/cyberlink/youcammakeup/h;
        JVM INSTR monitorexit ;
        return databaseopenhelper;
        Exception exception;
        exception;
        throw exception;
    }
}
