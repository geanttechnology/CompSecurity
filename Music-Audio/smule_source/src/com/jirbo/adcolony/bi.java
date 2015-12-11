// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            ak, m, ag

class bi extends View
{

    static double r;
    static String s = "";
    static String t = "";
    static boolean u = true;
    static Paint v = new Paint(1);
    static float w[] = new float[80];
    int A;
    int B;
    int C;
    int D;
    int E;
    String F;
    ag G;
    m c;
    m d;
    m e;
    m f;
    m g;
    m h;
    m i;
    m j;
    double k;
    double l;
    double m;
    double n;
    double o;
    boolean p;
    ArrayList q;
    long x;
    int y;
    int z;

    bi()
    {
        super(ak.b());
        k = 2.7999999999999998D;
        l = 2.0499999999999998D;
        m = 1.3D;
        n = 2.5D;
        o = 1.5D;
        q = new ArrayList();
        x = System.currentTimeMillis();
    }

    int a(String s1)
    {
        v.getTextWidths(s1, w);
        float f1 = 0.0F;
        int j1 = s1.length();
        for (int i1 = 0; i1 < j1; i1++)
        {
            f1 += w[i1];
        }

        return (int)f1;
    }

    void a()
    {
        double d1;
        double d2;
        double d3;
        Display display;
        int i1;
        int j1;
        if (p)
        {
            d1 = 12D;
        } else
        {
            d1 = 16D;
        }
        display = ak.b().getWindowManager().getDefaultDisplay();
        i1 = display.getWidth();
        j1 = display.getHeight();
        y = (i1 - c.f) / 2;
        z = (j1 - c.g) / 2 - 80;
        A = y + c.f / 2;
        B = z + c.g / 2;
        E = z + (int)((double)c.g - ((double)e.g + r * d1));
        C = y + (int)(r * d1);
        i1 = y;
        d2 = c.f;
        d3 = e.f;
        D = (int)(d2 - (d1 * r + d3)) + i1;
    }

    void a(String s1, int i1, int j1, Canvas canvas)
    {
        i1 -= a(s1) / 2;
        v.setColor(0xfff0f0f0);
        canvas.drawText(s1, i1 + 1, j1 + 1, v);
        v.setColor(0xff808080);
        canvas.drawText(s1, i1, j1, v);
    }

    void a(String s1, String s2)
    {
        int i1 = a(s1);
        s = "";
        t = "";
        if (i1 > c.f - a("WW") - a(s2))
        {
            u = false;
            int i2 = 0;
            String s3 = "";
            for (int j1 = 0; j1 < c.f - a("WW") - a(s2); j1 = a(s3))
            {
                s3 = (new StringBuilder()).append(s3).append(s1.charAt(i2)).toString();
                i2++;
            }

            int k1 = 0;
            int l1 = 0;
            while (k1 < i2) 
            {
                if (s3.charAt(k1) == ' ' && k1 >= 5)
                {
                    s = s1.substring(0, k1);
                    l1 = k1;
                } else
                {
                    if (l1 < 5)
                    {
                        s2 = s1.substring(0, i2);
                    } else
                    {
                        s2 = s;
                    }
                    s = s2;
                }
                k1++;
            }
            if (l1 < 5)
            {
                s1 = s1.substring(i2);
            } else
            {
                s1 = s1.substring(l1);
            }
            t = s1;
            return;
        } else
        {
            u = true;
            s = s1;
            t = "";
            return;
        }
    }

    boolean a(int i1, int j1, int k1, int l1)
    {
        while (i1 < k1 || j1 < l1 || i1 >= e.f + k1 || j1 >= e.g + l1) 
        {
            return false;
        }
        return true;
    }

    void b(String s1, int i1, int j1, Canvas canvas)
    {
        i1 -= a(s1) / 2;
        v.setColor(0xff808080);
        canvas.drawText(s1, i1 + 2, j1 + 2, v);
        v.setColor(-1);
        canvas.drawText(s1, i1, j1, v);
    }

    public boolean b()
    {
        double d3 = 2.5D;
        double d2 = 0.80000000000000004D;
        if (c != null)
        {
            return true;
        }
        c = new m(ak.g("pre_popup_bg"));
        d = new m(ak.g("v4vc_logo"));
        e = new m(ak.g("yes_button_normal"));
        f = new m(ak.g("yes_button_down"));
        g = new m(ak.g("no_button_normal"));
        h = new m(ak.g("no_button_down"));
        j = new m(ak.g("done_button_normal"));
        i = new m(ak.g("done_button_down"));
        q.add(c);
        q.add(d);
        q.add(e);
        q.add(f);
        q.add(g);
        q.add(h);
        q.add(j);
        q.add(i);
        Display display = ak.b().getWindowManager().getDefaultDisplay();
        int i1 = display.getWidth();
        int j1 = display.getHeight();
        double d1;
        if (j1 > i1)
        {
            d1 = (double)(j1 - i1) / 360D;
        } else
        {
            d1 = (double)(i1 - j1) / 360D;
        }
        if (d1 < 0.80000000000000004D && !ak.d)
        {
            p = true;
        }
        if (d1 > 2.5D)
        {
            d1 = d3;
        }
        if (d1 < 0.80000000000000004D)
        {
            if (ak.d)
            {
                d1 = d2;
            } else
            {
                d1 = 1.7D;
            }
        }
        r = d1;
        if (p)
        {
            k = 2.6000000000000001D;
            l = 1.8D;
            m = 1.0D;
            n = 2.2000000000000002D;
            o = 1.2D;
        }
        c.a(d1 / 1.8D);
        d.a(d1 / 1.8D);
        f.a(d1 / 1.8D);
        h.a(d1 / 1.8D);
        e.a(d1 / 1.8D);
        g.a(d1 / 1.8D);
        i.a(d1 / 1.8D);
        j.a(d1 / 1.8D);
        v.setTextSize((float)(18D * d1));
        if (p)
        {
            v.setTextSize((float)(d1 * 9D));
        }
        v.setFakeBoldText(true);
        return true;
    }

    int c()
    {
        return (int)v.getTextSize();
    }

    void c(String s1, int i1, int j1, Canvas canvas)
    {
        b(s1, e.f / 2 + i1, e.g / 2 + j1 + (c() * 4) / 10, canvas);
    }

}
