// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.cyberlink.you.database.b;
import com.cyberlink.you.database.c;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.h;
import com.cyberlink.you.database.j;
import com.cyberlink.you.database.l;
import com.cyberlink.you.database.m;
import com.cyberlink.you.database.o;
import java.io.File;
import java.util.Locale;

// Referenced classes of package com.cyberlink.you:
//            g, f

public class e
{

    public static final Uri a;
    public static final Uri b;
    public static final String c;
    public static final String d[];
    public static final String e[];
    private static b f;
    private static SQLiteDatabase g;
    private static SQLiteDatabase h;
    private static f i;
    private static c j;
    private static d k;
    private static o l;
    private static l m;
    private static m n;
    private static j o;
    private static h p;
    private static com.cyberlink.you.database.e q;

    public static SQLiteDatabase a()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (g == null)
        {
            g = m().getReadableDatabase();
        }
        sqlitedatabase = g;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public static SQLiteDatabase b()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (h == null)
        {
            h = m().getWritableDatabase();
        }
        sqlitedatabase = h;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public static void c()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        if (f != null)
        {
            f.close();
            f = null;
        }
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static f d()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        f f1;
        if (i == null)
        {
            i = new f();
        }
        f1 = i;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    public static c e()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        c c1;
        if (j == null)
        {
            j = new c();
        }
        c1 = j;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    public static d f()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        d d1;
        if (k == null)
        {
            k = new d();
        }
        d1 = k;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public static o g()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        o o1;
        if (l == null)
        {
            l = new o();
        }
        o1 = l;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return o1;
        Exception exception;
        exception;
        throw exception;
    }

    public static l h()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        l l1;
        if (m == null)
        {
            m = new l();
        }
        l1 = m;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public static m i()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        m m1;
        if (n == null)
        {
            n = new m();
        }
        m1 = n;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return m1;
        Exception exception;
        exception;
        throw exception;
    }

    public static j j()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        j j1;
        if (o == null)
        {
            o = new j();
        }
        j1 = o;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return j1;
        Exception exception;
        exception;
        throw exception;
    }

    public static h k()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        h h1;
        if (p == null)
        {
            p = new h();
        }
        h1 = p;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return h1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.you.database.e l()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        com.cyberlink.you.database.e e1;
        if (q == null)
        {
            q = new com.cyberlink.you.database.e();
        }
        e1 = q;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return e1;
        Exception exception;
        exception;
        throw exception;
    }

    private static b m()
    {
        com/cyberlink/you/e;
        JVM INSTR monitorenter ;
        b b1;
        if (f == null)
        {
            com.cyberlink.you.g.a();
            f = new b(com.cyberlink.you.g.I(), new com.cyberlink.you.f());
        }
        b1 = f;
        com/cyberlink/you/e;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
label0:
        {
            a = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            b = android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
            c = String.valueOf(1);
            d = (new String[] {
                ".jpg", ".jpeg"
            });
            com.cyberlink.you.g.a();
            if (com.cyberlink.you.g.I().getExternalCacheDir() != null)
            {
                com.cyberlink.you.g.a();
                if (com.cyberlink.you.g.I().getExternalCacheDir().getPath() != null && Locale.getDefault() != null)
                {
                    com.cyberlink.you.g.a();
                    e = (new String[] {
                        com.cyberlink.you.g.I().getExternalCacheDir().getPath().toLowerCase(Locale.getDefault())
                    });
                    break label0;
                }
            }
            e = new String[0];
        }
    }
}
