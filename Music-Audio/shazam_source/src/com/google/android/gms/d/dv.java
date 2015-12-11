// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            eb, he, gm, ec

public final class dv extends eb
{

    static final Set a = new HashSet(Arrays.asList(new String[] {
        "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"
    }));
    String b;
    boolean c;
    public int d;
    public int e;
    int f;
    int g;
    int h;
    int i;
    public final Object j = new Object();
    final he k;
    public final Activity l;
    AdSizeParcel m;
    ImageView n;
    LinearLayout o;
    ec p;
    public PopupWindow q;
    RelativeLayout r;
    ViewGroup s;

    public dv(he he1, ec ec1)
    {
        super(he1, "resize");
        b = "top-right";
        c = true;
        d = 0;
        e = 0;
        f = -1;
        g = 0;
        h = 0;
        i = -1;
        k = he1;
        l = he1.c();
        p = ec1;
    }

    public final void a(int i1, int j1)
    {
        com.google.android.gms.ads.internal.p.e();
        int k1 = gm.c(l)[0];
        int l1 = i;
        int i2 = f;
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("x", i1).put("y", j1 - k1).put("width", l1).put("height", i2);
            super.t.a("onSizeChanged", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Error occured while dispatching size change.", jsonexception);
        }
    }

    public final void a(boolean flag)
    {
        Object obj = j;
        obj;
        JVM INSTR monitorenter ;
        if (q == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        q.dismiss();
        r.removeView(k.getWebView());
        if (s != null)
        {
            s.removeView(n);
            s.addView(k.getWebView());
            k.a(m);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        b("default");
        if (p != null)
        {
            p.z();
        }
        q = null;
        r = null;
        s = null;
        o = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int[] a()
    {
        int ai[];
        int i1;
        int i2;
        com.google.android.gms.ads.internal.p.e();
        int ai2[] = com.google.android.gms.d.gm.b(l);
        com.google.android.gms.ads.internal.p.e();
        ai = gm.c(l);
        i2 = ai2[0];
        i1 = ai2[1];
        if (i >= 50 && i <= i2) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.util.client.b.a(5);
        i1 = 0;
_L21:
        if (i1 == 0)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (f < 50 || f > i1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            i1 = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (f == i1 && i == i2)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            i1 = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (!c) goto _L4; else goto _L3
_L3:
        String s1;
        s1 = b;
        i1 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 6: default 196
    //                   -1364013995: 330
    //                   -1012429441: 302
    //                   -655373719: 344
    //                   1163912186: 372
    //                   1288627767: 358
    //                   1755462605: 316;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L5:
        i1;
        JVM INSTR tableswitch 0 5: default 236
    //                   0 386
    //                   1 410
    //                   2 444
    //                   3 488
    //                   4 520
    //                   5 562;
           goto _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L12:
        int k1;
        i1 = (d + g + i) - 50;
        k1 = e + h;
_L19:
        if (i1 < 0 || i1 + 50 > i2 || k1 < ai[0] || k1 + 50 > ai[1])
        {
            i1 = 0;
            continue; /* Loop/switch isn't completed */
        }
          goto _L4
_L7:
        if (s1.equals("top-left"))
        {
            i1 = 0;
        }
          goto _L5
_L11:
        if (s1.equals("top-center"))
        {
            i1 = 1;
        }
          goto _L5
_L6:
        if (s1.equals("center"))
        {
            i1 = 2;
        }
          goto _L5
_L8:
        if (s1.equals("bottom-left"))
        {
            i1 = 3;
        }
          goto _L5
_L10:
        if (s1.equals("bottom-center"))
        {
            i1 = 4;
        }
          goto _L5
_L9:
        if (s1.equals("bottom-right"))
        {
            i1 = 5;
        }
          goto _L5
_L13:
        i1 = d + g;
        k1 = e + h;
          goto _L19
_L14:
        i1 = (d + g + i / 2) - 25;
        k1 = e + h;
          goto _L19
_L15:
        i1 = (d + g + i / 2) - 25;
        k1 = (e + h + f / 2) - 25;
          goto _L19
_L16:
        i1 = d + g;
        k1 = (e + h + f) - 50;
          goto _L19
_L17:
        i1 = (d + g + i / 2) - 25;
        k1 = (e + h + f) - 50;
          goto _L19
_L18:
        i1 = (d + g + i) - 50;
        k1 = (e + h + f) - 50;
          goto _L19
_L4:
        i1 = 1;
        if (true) goto _L21; else goto _L20
_L20:
        if (c)
        {
            return (new int[] {
                d + g, e + h
            });
        }
        com.google.android.gms.ads.internal.p.e();
        int ai1[] = com.google.android.gms.d.gm.b(l);
        com.google.android.gms.ads.internal.p.e();
        int ai3[] = gm.c(l);
        int k2 = ai1[0];
        int l1 = d + g;
        int j2 = e + h;
        int j1;
        if (l1 < 0)
        {
            j1 = 0;
        } else
        {
            j1 = l1;
            if (i + l1 > k2)
            {
                j1 = k2 - i;
            }
        }
        if (j2 < ai3[0])
        {
            l1 = ai3[0];
        } else
        {
            l1 = j2;
            if (f + j2 > ai3[1])
            {
                l1 = ai3[1] - f;
            }
        }
        return (new int[] {
            j1, l1
        });
    }

    public final boolean b()
    {
        Object obj = j;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (q != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }


    // Unreferenced inner class com/google/android/gms/d/dv$1

/* anonymous class */
    final class _cls1
        implements android.view.View.OnClickListener
    {

        final dv a;

        public final void onClick(View view)
        {
            a.a(true);
        }

            
            {
                a = dv.this;
                super();
            }
    }

}
