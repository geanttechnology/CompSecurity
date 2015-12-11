// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

// Referenced classes of package com.jirbo.adcolony:
//            q, ac

public final class d
{

    ac a;
    String b;
    String c;
    String d;
    File e;
    File f;

    d(ac ac)
    {
        a = ac;
    }

    static double a(String s)
    {
        int i;
        long l;
        try
        {
            s = new StatFs(s);
            l = s.getBlockSize();
            i = s.getAvailableBlocks();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0.0D;
        }
        return (double)((long)i * l);
    }

    static String b()
    {
        if (q.x == null)
        {
            return "";
        } else
        {
            return q.b().getFilesDir().getAbsolutePath();
        }
    }

    static String c()
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        } else
        {
            return null;
        }
    }

    final void a()
    {
        if (e == null || f == null)
        {
            return;
        }
        if (!e.isDirectory())
        {
            e.delete();
        }
        if (!f.isDirectory())
        {
            f.delete();
        }
        e.mkdirs();
        f.mkdirs();
    }
}
