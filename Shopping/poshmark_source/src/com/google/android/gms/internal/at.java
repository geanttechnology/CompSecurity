// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ar, cz, da, dd, 
//            bo, bs

public final class at
    implements ar
{

    public at()
    {
    }

    private static int a(DisplayMetrics displaymetrics, Map map, String s, int i)
    {
        map = (String)map.get(s);
        int j = i;
        if (map != null)
        {
            try
            {
                j = cz.a(displaymetrics, Integer.parseInt(map));
            }
            // Misplaced declaration of an exception variable
            catch (DisplayMetrics displaymetrics)
            {
                da.w((new StringBuilder()).append("Could not parse ").append(s).append(" in a video GMSG: ").append(map).toString());
                return i;
            }
        }
        return j;
    }

    public void a(dd dd1, Map map)
    {
        String s = (String)map.get("action");
        if (s == null)
        {
            da.w("Action missing from video GMSG.");
            return;
        }
        Object obj = dd1.ba();
        if (obj == null)
        {
            da.w("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean flag = "new".equalsIgnoreCase(s);
        boolean flag1 = "position".equalsIgnoreCase(s);
        if (flag || flag1)
        {
            dd1 = dd1.getContext().getResources().getDisplayMetrics();
            int i = a(((DisplayMetrics) (dd1)), map, "x", 0);
            int k = a(((DisplayMetrics) (dd1)), map, "y", 0);
            int i1 = a(((DisplayMetrics) (dd1)), map, "w", -1);
            int j1 = a(((DisplayMetrics) (dd1)), map, "h", -1);
            if (flag && ((bo) (obj)).ap() == null)
            {
                ((bo) (obj)).c(i, k, i1, j1);
                return;
            } else
            {
                ((bo) (obj)).b(i, k, i1, j1);
                return;
            }
        }
        obj = ((bo) (obj)).ap();
        if (obj == null)
        {
            bs.a(dd1, "no_video_view", null);
            return;
        }
        if ("click".equalsIgnoreCase(s))
        {
            dd1 = dd1.getContext().getResources().getDisplayMetrics();
            int j = a(((DisplayMetrics) (dd1)), map, "x", 0);
            int l = a(((DisplayMetrics) (dd1)), map, "y", 0);
            long l1 = SystemClock.uptimeMillis();
            dd1 = MotionEvent.obtain(l1, l1, 0, j, l, 0);
            ((bs) (obj)).b(dd1);
            dd1.recycle();
            return;
        }
        if ("controls".equalsIgnoreCase(s))
        {
            dd1 = (String)map.get("enabled");
            if (dd1 == null)
            {
                da.w("Enabled parameter missing from controls video GMSG.");
                return;
            } else
            {
                ((bs) (obj)).i(Boolean.parseBoolean(dd1));
                return;
            }
        }
        if ("currentTime".equalsIgnoreCase(s))
        {
            dd1 = (String)map.get("time");
            if (dd1 == null)
            {
                da.w("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try
            {
                ((bs) (obj)).seekTo((int)(Float.parseFloat(dd1) * 1000F));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                da.w((new StringBuilder()).append("Could not parse time parameter from currentTime video GMSG: ").append(dd1).toString());
            }
            return;
        }
        if ("hide".equalsIgnoreCase(s))
        {
            ((bs) (obj)).setVisibility(4);
            return;
        }
        if ("load".equalsIgnoreCase(s))
        {
            ((bs) (obj)).ay();
            return;
        }
        if ("pause".equalsIgnoreCase(s))
        {
            ((bs) (obj)).pause();
            return;
        }
        if ("play".equalsIgnoreCase(s))
        {
            ((bs) (obj)).play();
            return;
        }
        if ("show".equalsIgnoreCase(s))
        {
            ((bs) (obj)).setVisibility(0);
            return;
        }
        if ("src".equalsIgnoreCase(s))
        {
            ((bs) (obj)).o((String)map.get("src"));
            return;
        } else
        {
            da.w((new StringBuilder()).append("Unknown video action: ").append(s).toString());
            return;
        }
    }
}
