// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.gu;
import java.util.Map;

public final class vj
    implements vd
{

    public vj()
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
                j = aca.a(displaymetrics, Integer.parseInt(map));
            }
            // Misplaced declaration of an exception variable
            catch (DisplayMetrics displaymetrics)
            {
                acb.e((new StringBuilder()).append("Could not parse ").append(s).append(" in a video GMSG: ").append(map).toString());
                return i;
            }
        }
        return j;
    }

    public void a(gu gu1, Map map)
    {
        String s = (String)map.get("action");
        if (s == null)
        {
            acb.e("Action missing from video GMSG.");
            return;
        }
        Object obj = gu1.d();
        if (obj == null)
        {
            acb.e("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean flag = "new".equalsIgnoreCase(s);
        boolean flag1 = "position".equalsIgnoreCase(s);
        if (flag || flag1)
        {
            gu1 = gu1.getContext().getResources().getDisplayMetrics();
            int i = a(((DisplayMetrics) (gu1)), map, "x", 0);
            int k = a(((DisplayMetrics) (gu1)), map, "y", 0);
            int i1 = a(((DisplayMetrics) (gu1)), map, "w", -1);
            int j1 = a(((DisplayMetrics) (gu1)), map, "h", -1);
            if (flag && ((xc) (obj)).b() == null)
            {
                ((xc) (obj)).b(i, k, i1, j1);
                return;
            } else
            {
                ((xc) (obj)).a(i, k, i1, j1);
                return;
            }
        }
        obj = ((xc) (obj)).b();
        if (obj == null)
        {
            dt.a(gu1, "no_video_view", null);
            return;
        }
        if ("click".equalsIgnoreCase(s))
        {
            gu1 = gu1.getContext().getResources().getDisplayMetrics();
            int j = a(((DisplayMetrics) (gu1)), map, "x", 0);
            int l = a(((DisplayMetrics) (gu1)), map, "y", 0);
            long l1 = SystemClock.uptimeMillis();
            gu1 = MotionEvent.obtain(l1, l1, 0, j, l, 0);
            ((dt) (obj)).a(gu1);
            gu1.recycle();
            return;
        }
        if ("controls".equalsIgnoreCase(s))
        {
            gu1 = (String)map.get("enabled");
            if (gu1 == null)
            {
                acb.e("Enabled parameter missing from controls video GMSG.");
                return;
            } else
            {
                ((dt) (obj)).a(Boolean.parseBoolean(gu1));
                return;
            }
        }
        if ("currentTime".equalsIgnoreCase(s))
        {
            gu1 = (String)map.get("time");
            if (gu1 == null)
            {
                acb.e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try
            {
                ((dt) (obj)).a((int)(Float.parseFloat(gu1) * 1000F));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                acb.e((new StringBuilder()).append("Could not parse time parameter from currentTime video GMSG: ").append(gu1).toString());
            }
            return;
        }
        if ("hide".equalsIgnoreCase(s))
        {
            ((dt) (obj)).setVisibility(4);
            return;
        }
        if ("load".equalsIgnoreCase(s))
        {
            ((dt) (obj)).b();
            return;
        }
        if ("pause".equalsIgnoreCase(s))
        {
            ((dt) (obj)).c();
            return;
        }
        if ("play".equalsIgnoreCase(s))
        {
            ((dt) (obj)).d();
            return;
        }
        if ("show".equalsIgnoreCase(s))
        {
            ((dt) (obj)).setVisibility(0);
            return;
        }
        if ("src".equalsIgnoreCase(s))
        {
            ((dt) (obj)).a((String)map.get("src"));
            return;
        } else
        {
            acb.e((new StringBuilder()).append("Unknown video action: ").append(s).toString());
            return;
        }
    }
}
