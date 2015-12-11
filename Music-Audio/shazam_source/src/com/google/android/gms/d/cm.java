// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.overlay.i;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            ce, he, be, hf

public final class cm
    implements ce
{

    private final Map a = new WeakHashMap();

    public cm()
    {
    }

    private static int a(Context context, Map map, String s, int j)
    {
        map = (String)map.get(s);
        int l = j;
        if (map != null)
        {
            try
            {
                m.a();
                l = com.google.android.gms.ads.internal.util.client.a.a(context, Integer.parseInt(map));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                (new StringBuilder("Could not parse ")).append(s).append(" in a video GMSG: ").append(map);
                b.a(5);
                return j;
            }
        }
        return l;
    }

    public final void a(he he1, Map map)
    {
        Object obj1 = (String)map.get("action");
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        b.a(5);
_L4:
        return;
_L2:
        if (b.a(3))
        {
            JSONObject jsonobject = new JSONObject(map);
            jsonobject.remove("google.afma.Notify_dt");
            (new StringBuilder("Video GMSG: ")).append(((String) (obj1))).append(" ").append(jsonobject.toString());
            b.a(3);
        }
        if (!"background".equals(obj1))
        {
            break MISSING_BLOCK_LABEL_174;
        }
        map = (String)map.get("color");
        if (TextUtils.isEmpty(map))
        {
            b.a(5);
            return;
        }
        int j;
        j = Color.parseColor(map);
        map = he1.f();
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        map = ((d) (map)).f;
        if (map != null)
        {
            try
            {
                map.setBackgroundColor(j);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (he he1)
            {
                b.a(5);
            }
            return;
        }
        a.put(he1, Integer.valueOf(j));
        return;
        Object obj = he1.f();
        if (obj == null)
        {
            b.a(5);
            return;
        }
        boolean flag = "new".equals(obj1);
        boolean flag1 = "position".equals(obj1);
        if (!flag && !flag1)
        {
            break MISSING_BLOCK_LABEL_489;
        }
        obj1 = he1.getContext();
        int l = a(((Context) (obj1)), map, "x", 0);
        int i1 = a(((Context) (obj1)), map, "y", 0);
        int j1 = a(((Context) (obj1)), map, "w", -1);
        int k1 = a(((Context) (obj1)), map, "h", -1);
        float f;
        long l1;
        try
        {
            Integer.parseInt((String)map.get("player"));
        }
        // Misplaced declaration of an exception variable
        catch (Map map) { }
        if (!flag || ((d) (obj)).f != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((d) (obj)).c.a(((d) (obj)).d, new String[] {
            "vpr"
        });
        map = ((d) (obj)).c.a();
        if (((d) (obj)).f == null)
        {
            obj.f = new k(((d) (obj)).b, ((d) (obj)).g, ((d) (obj)).c, map);
            ((d) (obj)).o.addView(((d) (obj)).f, 0, new android.view.ViewGroup.LayoutParams(-1, -1));
            ((d) (obj)).f.a(l, i1, j1, k1);
            ((d) (obj)).g.i().f = false;
        }
        if (!a.containsKey(he1)) goto _L4; else goto _L3
_L3:
        l = ((Integer)a.get(he1)).intValue();
        ((d) (obj)).f.setBackgroundColor(l);
        return;
        if (((d) (obj)).f == null) goto _L4; else goto _L5
_L5:
        ((d) (obj)).f.a(l, i1, j1, k1);
        return;
        obj = ((d) (obj)).f;
        if (obj == null)
        {
            k.a(he1);
            return;
        }
        if ("click".equals(obj1))
        {
            he1 = he1.getContext();
            l = a(((Context) (he1)), map, "x", 0);
            i1 = a(((Context) (he1)), map, "y", 0);
            l1 = SystemClock.uptimeMillis();
            he1 = MotionEvent.obtain(l1, l1, 0, l, i1, 0);
            ((k) (obj)).c.dispatchTouchEvent(he1);
            he1.recycle();
            return;
        }
        if ("currentTime".equals(obj1))
        {
            he1 = (String)map.get("time");
            if (he1 == null)
            {
                b.a(5);
                return;
            }
            try
            {
                l = (int)(Float.parseFloat(he1) * 1000F);
                ((k) (obj)).c.a(l);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (he he1)
            {
                b.a(5);
            }
            return;
        }
        if ("hide".equals(obj1))
        {
            ((k) (obj)).setVisibility(4);
            return;
        }
        if ("load".equals(obj1))
        {
            ((k) (obj)).f();
            return;
        }
        if ("mimetype".equals(obj1))
        {
            ((k) (obj)).setMimeType((String)map.get("mimetype"));
            return;
        }
        if ("muted".equals(obj1))
        {
            if (Boolean.parseBoolean((String)map.get("muted")))
            {
                ((k) (obj)).c.e();
                return;
            } else
            {
                ((k) (obj)).c.f();
                return;
            }
        }
        if ("pause".equals(obj1))
        {
            ((k) (obj)).c.d();
            return;
        }
        if ("play".equals(obj1))
        {
            ((k) (obj)).c.c();
            return;
        }
        if ("show".equals(obj1))
        {
            ((k) (obj)).setVisibility(0);
            return;
        }
        if ("src".equals(obj1))
        {
            obj.f = (String)map.get("src");
            return;
        }
        if ("volume".equals(obj1))
        {
            he1 = (String)map.get("volume");
            if (he1 == null)
            {
                b.a(5);
                return;
            }
            try
            {
                f = Float.parseFloat(he1);
                ((k) (obj)).c.a(f);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (he he1)
            {
                b.a(5);
            }
            return;
        }
        if ("watermark".equals(obj1))
        {
            he1 = new TextView(((k) (obj)).c.getContext());
            he1.setText((new StringBuilder("AdMob - ")).append(((k) (obj)).c.a()).toString());
            he1.setTextColor(0xffff0000);
            he1.setBackgroundColor(-256);
            ((k) (obj)).a.addView(he1, new android.widget.FrameLayout.LayoutParams(-2, -2, 17));
            ((k) (obj)).a.bringChildToFront(he1);
            return;
        } else
        {
            b.a(5);
            return;
        }
    }
}
