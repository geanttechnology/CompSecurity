// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.h;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.b:
//            ai, cj

public final class ao
    implements ai
{

    private final Map a = new WeakHashMap();

    public ao()
    {
    }

    private static int a(Context context, Map map, String s, int i)
    {
        map = (String)map.get(s);
        int j = i;
        if (map != null)
        {
            try
            {
                j = h.a().a(context, Integer.parseInt(map));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                b.e((new StringBuilder()).append("Could not parse ").append(s).append(" in a video GMSG: ").append(map).toString());
                return i;
            }
        }
        return j;
    }

    public void a(cj cj1, Map map)
    {
        Object obj2 = (String)map.get("action");
        if (obj2 != null) goto _L2; else goto _L1
_L1:
        b.e("Action missing from video GMSG.");
_L4:
        return;
_L2:
        if (b.a(3))
        {
            Object obj = new JSONObject(map);
            ((JSONObject) (obj)).remove("google.afma.Notify_dt");
            StringBuilder stringbuilder = (new StringBuilder()).append("Video GMSG: ").append(((String) (obj2))).append(" ");
            if (!(obj instanceof JSONObject))
            {
                obj = ((JSONObject) (obj)).toString();
            } else
            {
                obj = JSONObjectInstrumentation.toString((JSONObject)obj);
            }
            b.a(stringbuilder.append(((String) (obj))).toString());
        }
        if (!"background".equals(obj2))
        {
            break MISSING_BLOCK_LABEL_198;
        }
        map = (String)map.get("color");
        if (TextUtils.isEmpty(map))
        {
            b.e("Color parameter missing from color video GMSG.");
            return;
        }
        int i;
        i = Color.parseColor(map);
        map = cj1.e();
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        map = map.b();
        if (map != null)
        {
            try
            {
                map.setBackgroundColor(i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (cj cj1)
            {
                b.e("Invalid color parameter in video GMSG.");
            }
            return;
        }
        a.put(cj1, Integer.valueOf(i));
        return;
        Object obj1 = cj1.e();
        if (obj1 == null)
        {
            b.e("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean flag = "new".equals(obj2);
        boolean flag1 = "position".equals(obj2);
        if (flag || flag1)
        {
            obj2 = cj1.getContext();
            int j = a(((Context) (obj2)), map, "x", 0);
            int l = a(((Context) (obj2)), map, "y", 0);
            int j1 = a(((Context) (obj2)), map, "w", -1);
            int k1 = a(((Context) (obj2)), map, "h", -1);
            if (flag && ((c) (obj1)).b() == null)
            {
                ((c) (obj1)).b(j, l, j1, k1);
                if (a.containsKey(cj1))
                {
                    j = ((Integer)a.get(cj1)).intValue();
                    ((c) (obj1)).b().setBackgroundColor(j);
                    return;
                }
            } else
            {
                ((c) (obj1)).a(j, l, j1, k1);
                return;
            }
        } else
        {
            obj1 = ((c) (obj1)).b();
            if (obj1 == null)
            {
                com.google.android.gms.ads.internal.overlay.h.a(cj1);
                return;
            }
            if ("click".equals(obj2))
            {
                cj1 = cj1.getContext();
                int k = a(((Context) (cj1)), map, "x", 0);
                int i1 = a(((Context) (cj1)), map, "y", 0);
                long l1 = SystemClock.uptimeMillis();
                cj1 = MotionEvent.obtain(l1, l1, 0, k, i1, 0);
                ((com.google.android.gms.ads.internal.overlay.h) (obj1)).a(cj1);
                cj1.recycle();
                return;
            }
            if ("currentTime".equals(obj2))
            {
                cj1 = (String)map.get("time");
                if (cj1 == null)
                {
                    b.e("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try
                {
                    ((com.google.android.gms.ads.internal.overlay.h) (obj1)).a((int)(Float.parseFloat(cj1) * 1000F));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    b.e((new StringBuilder()).append("Could not parse time parameter from currentTime video GMSG: ").append(cj1).toString());
                }
                return;
            }
            if ("hide".equals(obj2))
            {
                ((com.google.android.gms.ads.internal.overlay.h) (obj1)).setVisibility(4);
                return;
            }
            if ("load".equals(obj2))
            {
                ((com.google.android.gms.ads.internal.overlay.h) (obj1)).f();
                return;
            }
            if ("muted".equals(obj2))
            {
                if (Boolean.parseBoolean((String)map.get("muted")))
                {
                    ((com.google.android.gms.ads.internal.overlay.h) (obj1)).i();
                    return;
                } else
                {
                    ((com.google.android.gms.ads.internal.overlay.h) (obj1)).j();
                    return;
                }
            }
            if ("pause".equals(obj2))
            {
                ((com.google.android.gms.ads.internal.overlay.h) (obj1)).g();
                return;
            }
            if ("play".equals(obj2))
            {
                ((com.google.android.gms.ads.internal.overlay.h) (obj1)).h();
                return;
            }
            if ("show".equals(obj2))
            {
                ((com.google.android.gms.ads.internal.overlay.h) (obj1)).setVisibility(0);
                return;
            }
            if ("src".equals(obj2))
            {
                ((com.google.android.gms.ads.internal.overlay.h) (obj1)).a((String)map.get("src"));
                return;
            }
            if ("volume".equals(obj2))
            {
                cj1 = (String)map.get("volume");
                if (cj1 == null)
                {
                    b.e("Level parameter missing from volume video GMSG.");
                    return;
                }
                try
                {
                    ((com.google.android.gms.ads.internal.overlay.h) (obj1)).a(Float.parseFloat(cj1));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    b.e((new StringBuilder()).append("Could not parse volume parameter from volume video GMSG: ").append(cj1).toString());
                }
                return;
            }
            if ("watermark".equals(obj2))
            {
                ((com.google.android.gms.ads.internal.overlay.h) (obj1)).k();
                return;
            } else
            {
                b.e((new StringBuilder()).append("Unknown video action: ").append(((String) (obj2))).toString());
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
