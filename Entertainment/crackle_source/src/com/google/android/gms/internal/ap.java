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
//            an, cs, ct, cw, 
//            bk, bo

public final class ap
    implements an
{

    public ap()
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
                j = cs.a(displaymetrics, Integer.parseInt(map));
            }
            // Misplaced declaration of an exception variable
            catch (DisplayMetrics displaymetrics)
            {
                ct.v((new StringBuilder()).append("Could not parse ").append(s).append(" in a video GMSG: ").append(map).toString());
                return i;
            }
        }
        return j;
    }

    public void a(cw cw1, Map map)
    {
        String s = (String)map.get("action");
        if (s == null)
        {
            ct.v("Action missing from video GMSG.");
            return;
        }
        Object obj = cw1.aB();
        if (obj == null)
        {
            ct.v("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean flag = "new".equalsIgnoreCase(s);
        boolean flag1 = "position".equalsIgnoreCase(s);
        if (flag || flag1)
        {
            cw1 = cw1.getContext().getResources().getDisplayMetrics();
            int i = a(((DisplayMetrics) (cw1)), map, "x", 0);
            int k = a(((DisplayMetrics) (cw1)), map, "y", 0);
            int i1 = a(((DisplayMetrics) (cw1)), map, "w", -1);
            int j1 = a(((DisplayMetrics) (cw1)), map, "h", -1);
            if (flag && ((bk) (obj)).W() == null)
            {
                ((bk) (obj)).c(i, k, i1, j1);
                return;
            } else
            {
                ((bk) (obj)).b(i, k, i1, j1);
                return;
            }
        }
        obj = ((bk) (obj)).W();
        if (obj == null)
        {
            bo.a(cw1, "no_video_view", null);
            return;
        }
        if ("click".equalsIgnoreCase(s))
        {
            cw1 = cw1.getContext().getResources().getDisplayMetrics();
            int j = a(((DisplayMetrics) (cw1)), map, "x", 0);
            int l = a(((DisplayMetrics) (cw1)), map, "y", 0);
            long l1 = SystemClock.uptimeMillis();
            cw1 = MotionEvent.obtain(l1, l1, 0, j, l, 0);
            ((bo) (obj)).b(cw1);
            cw1.recycle();
            return;
        }
        if ("controls".equalsIgnoreCase(s))
        {
            cw1 = (String)map.get("enabled");
            if (cw1 == null)
            {
                ct.v("Enabled parameter missing from controls video GMSG.");
                return;
            } else
            {
                ((bo) (obj)).i(Boolean.parseBoolean(cw1));
                return;
            }
        }
        if ("currentTime".equalsIgnoreCase(s))
        {
            cw1 = (String)map.get("time");
            if (cw1 == null)
            {
                ct.v("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try
            {
                ((bo) (obj)).seekTo((int)(Float.parseFloat(cw1) * 1000F));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                ct.v((new StringBuilder()).append("Could not parse time parameter from currentTime video GMSG: ").append(cw1).toString());
            }
            return;
        }
        if ("hide".equalsIgnoreCase(s))
        {
            ((bo) (obj)).setVisibility(4);
            return;
        }
        if ("load".equalsIgnoreCase(s))
        {
            ((bo) (obj)).af();
            return;
        }
        if ("pause".equalsIgnoreCase(s))
        {
            ((bo) (obj)).pause();
            return;
        }
        if ("play".equalsIgnoreCase(s))
        {
            ((bo) (obj)).play();
            return;
        }
        if ("show".equalsIgnoreCase(s))
        {
            ((bo) (obj)).setVisibility(0);
            return;
        }
        if ("src".equalsIgnoreCase(s))
        {
            ((bo) (obj)).n((String)map.get("src"));
            return;
        } else
        {
            ct.v((new StringBuilder()).append("Unknown video action: ").append(s).toString());
            return;
        }
    }
}
