// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.effects.colorsplash:
//            b, f, GradientView, e

public final class c
{

    public f a;
    public e b;
    public int c;
    public int d;
    public LinearLayout e;
    public int f;
    public float g;
    float h[] = {
        -1F, -1F, -1F
    };
    float i[] = {
        240F, 240F, 240F
    };
    float j[] = {
        -1F, -1F, -1F
    };
    float k[] = {
        -1F, -1F, -1F
    };
    int l;
    final b m;
    private int n;
    private float o;
    private float p;

    public c(b b1)
    {
        m = b1;
        super();
        a = null;
        b = null;
        c = 0x7f07005a;
        d = 0x7f070059;
        e = null;
        f = 0;
        o = 30F;
        p = 30F;
        g = -1F;
        l = 0;
    }

    public final void a()
    {
        m.f = false;
        h = (new float[] {
            -1F, -1F, -1F
        });
        j = (new float[] {
            -1F, -1F, -1F
        });
        k = (new float[] {
            -1F, -1F, -1F
        });
        i = (new float[] {
            240F, 240F, 240F
        });
        l = 0;
        if (a != null)
        {
            a.a("minHue1", Float.valueOf(-1F));
            a.a("maxHue1", Float.valueOf(-1F));
            a.a("minHue2", Float.valueOf(-1F));
            a.a("maxHue2", Float.valueOf(-1F));
            a.a("minHue3", Float.valueOf(-1F));
            a.a("maxHue3", Float.valueOf(-1F));
            if (m.d == 0)
            {
                a.a("replaceHue", Float.valueOf(240F));
                a.a("replaceHue1", Float.valueOf(240F));
                a.a("replaceHue2", Float.valueOf(240F));
                a.a("replaceHue3", Float.valueOf(240F));
                a.a("selectedColorHue1", Float.valueOf(-1F));
                a.a("selectedColorHue2", Float.valueOf(-1F));
                a.a("selectedColorHue3", Float.valueOf(-1F));
                if (e != null)
                {
                    ((SeekBar)e.findViewById(0x7f1002c8)).setProgress(240);
                    android.view.View view = e.findViewById(0x7f1002c6);
                    if (view != null)
                    {
                        ((TextView)view).setText((new StringBuilder()).append(m.a.getString(0x7f0801e4)).append(" : 240").toString());
                    }
                }
            }
        }
    }

    final void a(float f1)
    {
        float f2;
        GradientView gradientview;
        gradientview = (GradientView)e.findViewById(0x7f1002ca);
        f2 = f1 - 30F;
        if (f2 >= 0.0F) goto _L2; else goto _L1
_L1:
        f1 = f2 + 360F;
_L4:
        gradientview.setMinMaxHue(f1, f1 - 80F);
        ((GradientView)e.findViewById(0x7f1002cd)).setMinMaxHue(f1, f1 + 80F);
        return;
_L2:
        f1 = f2;
        if (f2 > 360F)
        {
            f1 = f2 - 360F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(int i1)
    {
        f = i1;
        f f1 = a;
        i1 = f;
        f1.c.put("splashMode", Integer.valueOf(i1));
    }

    public final int b()
    {
        for (int i1 = 0; i1 < h.length; i1++)
        {
            if (h[i1] > 0.0F)
            {
                return i1;
            }
        }

        return -1;
    }

    public final void b(float f1)
    {
        p = h[l] + f1;
        k[l] = f1;
        if (p > 360F)
        {
            p = p - 360F;
        }
        a.a((new StringBuilder("maxHue")).append(l + 1).toString(), Float.valueOf(p));
        ((TextView)e.findViewById(0x7f1002cc)).setText((new StringBuilder()).append(m.a.getString(0x7f0801d6)).append(" : ").append((int)f1).toString());
    }

    public final void b(int i1)
    {
        l = i1;
        if (e != null)
        {
            c(j[l]);
            b(k[l]);
            if (e != null)
            {
                ((SeekBar)e.findViewById(0x7f1002cb)).setProgress((int)j[l]);
                ((SeekBar)e.findViewById(0x7f1002ce)).setProgress((int)k[l]);
                a(h[l]);
                if (m.d == 0)
                {
                    d(i[l]);
                    ((SeekBar)e.findViewById(0x7f1002c8)).setProgress((int)i[l]);
                }
                ((Button)e.findViewById(0x7f1002c4)).setText((new StringBuilder()).append(m.a.getResources().getString(0x7f08007c)).append(l + 1).toString());
            }
        }
    }

    public final JSONArray c()
    {
        JSONArray jsonarray = new JSONArray();
        m.d;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 170
    //                   1 38;
           goto _L1 _L2 _L3
_L1:
        return jsonarray;
_L3:
        jsonarray.put((new JSONObject()).put("maxHue", p));
        jsonarray.put((new JSONObject()).put("minHue", o));
        if (!m.e) goto _L5; else goto _L4
_L4:
        JSONObject jsonobject = new JSONObject();
        Object obj = "GrayScale";
        boolean flag = m.e;
_L6:
        jsonarray.put(jsonobject.put(((String) (obj)), flag));
        return jsonarray;
_L5:
        try
        {
            jsonobject = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
            return jsonarray;
        }
        obj = "Sepia";
        flag = m.e;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L6
_L2:
        try
        {
            jsonarray.put((new JSONObject()).put("maxHue", p));
            jsonarray.put((new JSONObject()).put("minHue", o));
            jsonarray.put((new JSONObject()).put("replaceHue", n));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonarray;
        }
        return jsonarray;
    }

    public final void c(float f1)
    {
        o = h[l] - f1;
        j[l] = f1;
        if (o < 0.0F)
        {
            o = o + 360F;
        }
        a.a((new StringBuilder("minHue")).append(l + 1).toString(), Float.valueOf(o));
        ((TextView)e.findViewById(0x7f1002c9)).setText((new StringBuilder()).append(m.a.getString(0x7f0801d8)).append(" : ").append((int)f1).toString());
    }

    public final void d(float f1)
    {
        i[l] = f1;
        n = (int)f1;
        a.a((new StringBuilder("replaceHue")).append(l + 1).toString(), Float.valueOf(f1));
        android.view.View view = e.findViewById(0x7f1002c6);
        if (view != null)
        {
            ((TextView)view).setText((new StringBuilder()).append(m.a.getString(0x7f0801e4)).append(" : ").append((int)f1).toString());
        }
    }
}
