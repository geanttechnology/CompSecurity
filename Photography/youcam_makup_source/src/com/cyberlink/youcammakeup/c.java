// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.cyberlink.youcammakeup.database.a;
import com.cyberlink.youcammakeup.database.h;
import com.cyberlink.youcammakeup.database.i;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import java.io.File;
import java.util.Locale;

// Referenced classes of package com.cyberlink.youcammakeup:
//            Globals

public class c
{

    public static final Uri a;
    public static final Uri b;
    public static final String c = String.valueOf(1);
    public static final String d[] = {
        ".jpg", ".jpeg", ".png"
    };
    public static final String e[];
    private static h f;
    private static SQLiteDatabase g;
    private static SQLiteDatabase h;
    private static a i;
    private static com.cyberlink.youcammakeup.database.c j;
    private static n k;
    private static p l;
    private static i m;
    private static String n;

    public static SQLiteDatabase a()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (g == null)
        {
            g = i().getReadableDatabase();
        }
        sqlitedatabase = g;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public static SQLiteDatabase b()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (h == null)
        {
            h = i().getWritableDatabase();
        }
        sqlitedatabase = h;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public static a c()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        a a1;
        if (i == null)
        {
            i = new a();
        }
        a1 = i;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.cyberlink.youcammakeup.database.c d()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.database.c c1;
        if (j == null)
        {
            j = new com.cyberlink.youcammakeup.database.c();
        }
        c1 = j;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    public static n e()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        n n1;
        if (k == null)
        {
            k = new n();
        }
        n1 = k;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return n1;
        Exception exception;
        exception;
        throw exception;
    }

    public static p f()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        p p1;
        if (l == null)
        {
            l = new p();
        }
        p1 = l;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return p1;
        Exception exception;
        exception;
        throw exception;
    }

    public static i g()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        i i1;
        if (m == null)
        {
            m = new i();
        }
        i1 = m;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public static String h()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        String s;
        if (n == null)
        {
            n = DevelopSetting.a().c();
        }
        s = n;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    private static h i()
    {
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorenter ;
        h h1;
        if (f == null)
        {
            f = new h(Globals.d());
        }
        h1 = f;
        com/cyberlink/youcammakeup/c;
        JVM INSTR monitorexit ;
        return h1;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        a = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        b = android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
        if (Globals.d().getExternalCacheDir() != null && Globals.d().getExternalCacheDir().getPath() != null && Locale.getDefault() != null)
        {
            e = (new String[] {
                Globals.d().getExternalCacheDir().getPath().toLowerCase(Locale.getDefault())
            });
        } else
        {
            e = new String[0];
        }
    }
}
