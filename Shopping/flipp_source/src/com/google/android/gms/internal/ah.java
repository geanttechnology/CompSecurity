// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, er, et, ew, 
//            cd, cj, ez

public final class ah
    implements af
{

    public ah()
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
                j = er.a(displaymetrics, Integer.parseInt(map));
            }
            // Misplaced declaration of an exception variable
            catch (DisplayMetrics displaymetrics)
            {
                et.d((new StringBuilder("Could not parse ")).append(s).append(" in a video GMSG: ").append(map).toString());
                return i;
            }
        }
        return j;
    }

    public final void a(ew ew1, Map map)
    {
        String s = (String)map.get("action");
        if (s != null) goto _L2; else goto _L1
_L1:
        et.d("Action missing from video GMSG.");
_L4:
        return;
_L2:
        Object obj;
        int i;
        int l;
        int j1;
        int k1;
        obj = ew1.b();
        if (obj == null)
        {
            et.d("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean flag = "new".equalsIgnoreCase(s);
        boolean flag1 = "position".equalsIgnoreCase(s);
        if (!flag && !flag1)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        ew1 = ew1.getContext().getResources().getDisplayMetrics();
        i = a(((DisplayMetrics) (ew1)), map, "x", 0);
        l = a(((DisplayMetrics) (ew1)), map, "y", 0);
        j1 = a(((DisplayMetrics) (ew1)), map, "w", -1);
        k1 = a(((DisplayMetrics) (ew1)), map, "h", -1);
        if (!flag || ((cd) (obj)).b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((cd) (obj)).b != null) goto _L4; else goto _L3
_L3:
        obj.b = new cj(((cd) (obj)).a, ((cd) (obj)).c);
        ((cd) (obj)).g.addView(((cd) (obj)).b, 0, cd.a(i, l, j1, k1));
        ((cd) (obj)).c.a.h = false;
        return;
        if (((cd) (obj)).b == null) goto _L4; else goto _L5
_L5:
        ((cd) (obj)).b.setLayoutParams(cd.a(i, l, j1, k1));
        return;
        obj = ((cd) (obj)).b;
        if (obj == null)
        {
            cj.a(ew1, "no_video_view", null);
            return;
        }
        if ("click".equalsIgnoreCase(s))
        {
            ew1 = ew1.getContext().getResources().getDisplayMetrics();
            int j = a(((DisplayMetrics) (ew1)), map, "x", 0);
            int i1 = a(((DisplayMetrics) (ew1)), map, "y", 0);
            long l1 = SystemClock.uptimeMillis();
            ew1 = MotionEvent.obtain(l1, l1, 0, j, i1, 0);
            ((cj) (obj)).d.dispatchTouchEvent(ew1);
            ew1.recycle();
            return;
        }
        if ("controls".equalsIgnoreCase(s))
        {
            ew1 = (String)map.get("enabled");
            if (ew1 == null)
            {
                et.d("Enabled parameter missing from controls video GMSG.");
                return;
            }
            if (Boolean.parseBoolean(ew1))
            {
                ((cj) (obj)).d.setMediaController(((cj) (obj)).b);
                return;
            } else
            {
                ((cj) (obj)).b.hide();
                ((cj) (obj)).d.setMediaController(null);
                return;
            }
        }
        if ("currentTime".equalsIgnoreCase(s))
        {
            ew1 = (String)map.get("time");
            if (ew1 == null)
            {
                et.d("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try
            {
                int k = (int)(Float.parseFloat(ew1) * 1000F);
                ((cj) (obj)).d.seekTo(k);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                et.d((new StringBuilder("Could not parse time parameter from currentTime video GMSG: ")).append(ew1).toString());
            }
            return;
        }
        if ("hide".equalsIgnoreCase(s))
        {
            ((cj) (obj)).setVisibility(4);
            return;
        }
        if ("load".equalsIgnoreCase(s))
        {
            if (!TextUtils.isEmpty(((cj) (obj)).f))
            {
                ((cj) (obj)).d.setVideoPath(((cj) (obj)).f);
                return;
            } else
            {
                cj.a(((cj) (obj)).a, "no_src", null);
                return;
            }
        }
        if ("pause".equalsIgnoreCase(s))
        {
            ((cj) (obj)).d.pause();
            return;
        }
        if ("play".equalsIgnoreCase(s))
        {
            ((cj) (obj)).d.start();
            return;
        }
        if ("show".equalsIgnoreCase(s))
        {
            ((cj) (obj)).setVisibility(0);
            return;
        }
        if ("src".equalsIgnoreCase(s))
        {
            obj.f = (String)map.get("src");
            return;
        } else
        {
            et.d((new StringBuilder("Unknown video action: ")).append(s).toString());
            return;
        }
    }
}
