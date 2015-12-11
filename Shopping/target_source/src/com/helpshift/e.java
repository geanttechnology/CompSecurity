// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Environment;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            d, c, s, l, 
//            v, x, f

public class e
    implements d.a
{

    private static c w;
    Thread a;
    private URL b;
    private URL c;
    private String d;
    private String e;
    private String f;
    private int g;
    private double h;
    private int i;
    private String j;
    private String k;
    private int l;
    private int m;
    private String n;
    private f o;
    private l p;
    private s q;
    private Runnable r;
    private final int s = 0;
    private final int t = 1;
    private File u;
    private File v;

    e()
    {
        r = new d(this);
        w = com.helpshift.c.a();
    }

    private File d(int i1)
    {
        File file;
        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (!file.exists())
        {
            file.mkdirs();
        }
        if (!file.canWrite()) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 50
    //                   1 87;
           goto _L2 _L3 _L4
_L2:
        return null;
_L3:
        return new File(file, (new StringBuilder()).append("Support_Temp_").append(System.currentTimeMillis()).append(d).toString());
_L4:
        return new File(file, (new StringBuilder()).append("Support_").append(System.currentTimeMillis()).append(d).toString());
    }

    public int a()
    {
        return m;
    }

    public void a(double d1)
    {
        h = d1;
    }

    public void a(int i1)
    {
        int j1;
        boolean flag;
        flag = true;
        j1 = ((flag) ? 1 : 0);
        i1;
        JVM INSTR tableswitch -1 4: default 44
    //                   -1 197
    //                   0 47
    //                   1 218
    //                   2 213
    //                   3 53
    //                   4 223;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        j1 = ((flag) ? 1 : 0);
_L13:
        c(j1);
        return;
_L6:
        q.H(j);
        l;
        JVM INSTR tableswitch 6 8: default 96
    //                   6 101
    //                   7 137
    //                   8 119;
           goto _L8 _L9 _L10 _L11
_L8:
        j1 = 4;
        continue; /* Loop/switch isn't completed */
_L9:
        q.l(j, n);
        continue; /* Loop/switch isn't completed */
_L11:
        q.m(j, n);
        continue; /* Loop/switch isn't completed */
_L10:
        q.n(j, n);
        File file = new File(q.E(j));
        if (file.exists())
        {
            file.delete();
        }
        q.D(j);
        if (true) goto _L8; else goto _L2
_L2:
        q.H(j);
        j1 = -1;
        continue; /* Loop/switch isn't completed */
_L5:
        j1 = 3;
        continue; /* Loop/switch isn't completed */
_L4:
        j1 = 2;
        continue; /* Loop/switch isn't completed */
_L7:
        j1 = 5;
        if (true) goto _L13; else goto _L12
_L12:
    }

    void a(c c1, JSONObject jsonobject, int i1, String s1, String s2, int j1)
    {
        try
        {
            w = c1;
            o = com.helpshift.c.c();
            p = new l(com.helpshift.v.a());
            q = p.a;
            l = j1;
            b = new URL(jsonobject.optString("url", ""));
            d = jsonobject.optString("file-name", "");
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            x.b("HelpShiftDebug", "Exception Malformed URL", c1);
            return;
        }
        if (j1 != 8)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        c = new URL(jsonobject.optString("thumbnail", ""));
        b = c;
        e = jsonobject.optString("content-type", "");
        c1 = e.split("\\/");
        f = c1[c1.length - 1];
        g = jsonobject.optInt("size", 0);
        m = 0;
        u = d(0);
        v = d(1);
        i = i1;
        j = s1;
        k = s2;
        return;
    }

    public void a(File file)
    {
        u = file;
    }

    public void a(String s1)
    {
        n = s1;
    }

    public void a(Thread thread)
    {
        b(thread);
    }

    public URL b()
    {
        return b;
    }

    public void b(int i1)
    {
        m = i1;
    }

    void b(Thread thread)
    {
        synchronized (w)
        {
            a = thread;
        }
        return;
        thread;
        c1;
        JVM INSTR monitorexit ;
        throw thread;
    }

    public int c()
    {
        return g;
    }

    void c(int i1)
    {
        w.a(this, i1, i);
    }

    public File d()
    {
        return u;
    }

    public File e()
    {
        return v;
    }

    public double f()
    {
        return h;
    }

    public String g()
    {
        return n;
    }

    public String h()
    {
        return j;
    }

    public String i()
    {
        return k;
    }

    public int j()
    {
        return l;
    }

    Runnable k()
    {
        return r;
    }

    protected void l()
    {
        n = null;
        u = null;
        v = null;
    }
}
