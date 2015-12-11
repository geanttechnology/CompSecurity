// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

// Referenced classes of package com.jirbo.adcolony:
//            bl, ak, ap, bg, 
//            bk, q, be

public class n
{

    be a;
    String b;
    String c;
    String d;
    File e;
    File f;

    n(be be)
    {
        a = be;
    }

    double a(String s)
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

    void a()
    {
        bl.a.b("Configuring storage");
        boolean flag1 = true;
        boolean flag = flag1;
        if (d() != null)
        {
            flag = flag1;
            if (a(d()) > a(c()) + 1048576D)
            {
                flag = flag1;
                if (a(c()) < 31457280D)
                {
                    flag = false;
                }
            }
        }
        if (flag)
        {
            bl.b.b("Using internal storage:");
            b = (new StringBuilder()).append(c()).append("/adc/").toString();
        } else
        {
            b = (new StringBuilder()).append(d()).append("/.adc2/").append(ap.e()).append("/").toString();
            bl.b.b("Using external storage:");
        }
        c = (new StringBuilder()).append(b).append("media/").toString();
        bl.a.b(c);
        e = new File(c);
        if (!e.isDirectory())
        {
            e.delete();
            e.mkdirs();
        }
        if (!e.isDirectory())
        {
            ak.a("Cannot create media folder.");
            return;
        }
        if (a(c) < 20971520D)
        {
            ak.a((new StringBuilder()).append("Not enough space to store temporary files (").append(a(c)).append(" bytes available).").toString());
            return;
        }
        d = (new StringBuilder()).append(c()).append("/adc/data/").toString();
        if (ak.e == 0)
        {
            d = (new StringBuilder()).append(b).append("data/").toString();
        }
        bl.a.a("Internal data path: ").b(d);
        f = new File(d);
        if (!f.isDirectory())
        {
            f.delete();
        }
        f.mkdirs();
        bg bg1 = new bg("iap_cache.txt");
        bg1.c();
        bk.a(bg1, ak.Q);
    }

    void b()
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

    String c()
    {
        return q.d().getFilesDir().getAbsolutePath();
    }

    String d()
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        } else
        {
            return null;
        }
    }
}
