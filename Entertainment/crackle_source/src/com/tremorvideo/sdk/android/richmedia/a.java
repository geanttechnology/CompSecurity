// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Bitmap;
import com.tremorvideo.sdk.android.richmedia.a.e;
import com.tremorvideo.sdk.android.richmedia.a.i;
import com.tremorvideo.sdk.android.richmedia.b.b;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.ax;
import com.tremorvideo.sdk.android.videoad.bv;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            c, e, i, o, 
//            y, ae, ad

public class a
{

    public com.tremorvideo.sdk.android.videoad.s.b a;
    public boolean b;
    private c c;
    private List d;
    private List e;
    private y f;
    private int g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private String l;
    private int m;
    private Bitmap n;
    private com.tremorvideo.sdk.android.richmedia.ad o[];
    private GregorianCalendar p;
    private String q;
    private ax r;
    private String s;
    private String t;
    private String u;
    private boolean v;
    private boolean w;
    private b x;
    private e y;

    public a()
    {
        c = new c();
        v = false;
        b = true;
        w = true;
    }

    public String a()
    {
        return t;
    }

    public String a(int i1)
    {
        return (String)e.get(i1);
    }

    public void a(float f1)
    {
        if (x != null)
        {
            x.a(f1);
        }
    }

    public void a(float f1, int i1)
    {
        if (y != null)
        {
            y.a(f1, i1);
        }
    }

    public void a(android.widget.RelativeLayout.LayoutParams layoutparams)
    {
        this;
        JVM INSTR monitorenter ;
        if (x != null)
        {
            x.a(layoutparams);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        layoutparams;
        throw layoutparams;
    }

    public void a(android.widget.RelativeLayout.LayoutParams layoutparams, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (y != null)
        {
            y.a(layoutparams, i1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        layoutparams;
        throw layoutparams;
    }

    public void a(e e1)
    {
        y = e1;
    }

    public void a(b b1)
    {
        x = b1;
    }

    public void a(ax ax)
    {
        r = ax;
    }

    public void a(String s1)
    {
        s = s1;
    }

    public void a(String s1, String s2)
    {
        if (x != null)
        {
            x.a(s1, s2);
        }
    }

    public void a(String s1, String s2, int i1)
    {
        if (y != null)
        {
            y.a(s1, s2, i1);
        }
    }

    public void a(GregorianCalendar gregoriancalendar)
    {
        p = gregoriancalendar;
    }

    public void a(ZipFile zipfile, com.tremorvideo.sdk.android.richmedia.i i1, com.tremorvideo.sdk.android.videoad.s.b b1, boolean flag)
        throws Exception
    {
        boolean flag1 = true;
        java.util.zip.ZipEntry zipentry = zipfile.getEntry("data");
        java.util.zip.ZipEntry zipentry1 = zipfile.getEntry("code-android.js");
        if (zipfile.getEntry("compatibility") != null)
        {
            w = false;
        }
        com.tremorvideo.sdk.android.richmedia.e e1;
        if (zipentry1 == null)
        {
            l = "";
        } else
        {
            l = ad.a(zipfile.getInputStream(zipentry1));
        }
        e1 = new com.tremorvideo.sdk.android.richmedia.e(zipfile.getInputStream(zipentry));
        m = e1.a();
        if (m != 5 && m != 4 && m != 3 && m != 2 && m != 1)
        {
            throw new Exception("Incompatible Version.");
        }
        if (e1.b() == 0)
        {
            flag1 = false;
        }
        i = flag1;
        e1.b();
        j = e1.b();
        k = e1.b();
        g = e1.a();
        h = e1.a();
        b = flag;
        int l1 = e1.b();
        e = new ArrayList(l1);
        int j1 = 0;
        while (j1 < l1) 
        {
            String s2 = e1.c();
            String s1 = s2;
            if (!b)
            {
                if (s2.contains("Ads by Tremor Video:"))
                {
                    s1 = s2.replace("Ads by Tremor Video:", "");
                } else
                {
                    s1 = s2;
                    if (s2.contains("Ads by Tremor Video"))
                    {
                        s1 = s2.replace("Ads by Tremor Video", "");
                    }
                }
            }
            e.add(s1);
            j1++;
        }
        j1 = i1.a(g, h);
        c.a(zipfile, i1, j1, e1);
        l1 = e1.b();
        d = new ArrayList(l1);
        for (int k1 = 0; k1 < l1; k1++)
        {
            i1 = new o(this);
            i1.a(e1, zipfile);
            d.add(i1);
        }

        f = new y((o)d.get(0));
        n = bv.a(com.tremorvideo.sdk.android.d.a.a);
        a = b1;
        if (s != null)
        {
            t = ae.a(zipfile, s);
        }
        u = ae.a(zipfile, "comps");
    }

    public void a(com.tremorvideo.sdk.android.richmedia.ad aad[])
    {
        o = aad;
    }

    public o b(int i1)
    {
        return (o)d.get(i1);
    }

    public String b()
    {
        return u;
    }

    public void b(String s1)
    {
        q = s1;
    }

    public ax c()
    {
        return r;
    }

    public void c(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (y != null)
        {
            y.a(i1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Bitmap d()
    {
        return n;
    }

    public boolean e()
    {
        return w;
    }

    public void f()
    {
        c.b();
    }

    public int g()
    {
        return m;
    }

    public String h()
    {
        return l;
    }

    public boolean i()
    {
        return i;
    }

    public o j()
    {
        if (j == 255)
        {
            return null;
        } else
        {
            return (o)d.get(j);
        }
    }

    public o k()
    {
        if (k == 255)
        {
            return null;
        } else
        {
            return (o)d.get(k);
        }
    }

    public int l()
    {
        return g;
    }

    public int m()
    {
        return h;
    }

    public y n()
    {
        return f;
    }

    public com.tremorvideo.sdk.android.richmedia.ad[] o()
    {
        return o;
    }

    public String p()
    {
        return q;
    }

    public GregorianCalendar q()
    {
        return p;
    }

    public c r()
    {
        return c;
    }

    public void s()
    {
        v = true;
    }

    public boolean t()
    {
        return v;
    }

    public void u()
    {
        this;
        JVM INSTR monitorenter ;
        if (x != null)
        {
            x.b();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void v()
    {
        if (x != null)
        {
            x.a();
        }
    }

    public void w()
    {
        if (y != null)
        {
            y.a();
        }
    }

    public void x()
    {
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.tremorvideo.sdk.android.richmedia.b.a a1 = ((o)iterator.next()).i();
            if (a1 != null)
            {
                a1.d();
            }
        } while (true);
    }

    public void y()
    {
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            i i1 = ((o)iterator.next()).k();
            if (i1 != null)
            {
                i1.d();
            }
        } while (true);
    }
}
