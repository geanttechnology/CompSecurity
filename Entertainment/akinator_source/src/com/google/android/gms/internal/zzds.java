// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zziz, zziy

public final class zzds
    implements zzdk
{

    private final Map zzxX = new WeakHashMap();

    public zzds()
    {
    }

    private static int zza(Context context, Map map, String s, int i)
    {
        map = (String)map.get(s);
        int j = i;
        if (map != null)
        {
            try
            {
                j = zzl.zzcF().zzb(context, Integer.parseInt(map));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                zzb.zzaH((new StringBuilder()).append("Could not parse ").append(s).append(" in a video GMSG: ").append(map).toString());
                return i;
            }
        }
        return j;
    }

    public void zza(zziz zziz1, Map map)
    {
        Object obj1 = (String)map.get("action");
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        zzb.zzaH("Action missing from video GMSG.");
_L4:
        return;
_L2:
        if (zzb.zzN(3))
        {
            JSONObject jsonobject = new JSONObject(map);
            jsonobject.remove("google.afma.Notify_dt");
            zzb.zzaF((new StringBuilder()).append("Video GMSG: ").append(((String) (obj1))).append(" ").append(jsonobject.toString()).toString());
        }
        if (!"background".equals(obj1))
        {
            break MISSING_BLOCK_LABEL_174;
        }
        map = (String)map.get("color");
        if (TextUtils.isEmpty(map))
        {
            zzb.zzaH("Color parameter missing from color video GMSG.");
            return;
        }
        int i;
        i = Color.parseColor(map);
        map = zziz1.zzhl();
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        map = map.zzgX();
        if (map != null)
        {
            try
            {
                map.setBackgroundColor(i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (zziz zziz1)
            {
                zzb.zzaH("Invalid color parameter in video GMSG.");
            }
            return;
        }
        zzxX.put(zziz1, Integer.valueOf(i));
        return;
        Object obj = zziz1.zzhl();
        if (obj == null)
        {
            zzb.zzaH("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean flag = "new".equals(obj1);
        boolean flag1 = "position".equals(obj1);
        if (flag || flag1)
        {
            obj1 = zziz1.getContext();
            int l = zza(((Context) (obj1)), map, "x", 0);
            int j1 = zza(((Context) (obj1)), map, "y", 0);
            int k1 = zza(((Context) (obj1)), map, "w", -1);
            int l1 = zza(((Context) (obj1)), map, "h", -1);
            int j;
            try
            {
                j = Integer.parseInt((String)map.get("player"));
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                j = 0;
            }
            if (flag && ((zziy) (obj)).zzgX() == null)
            {
                ((zziy) (obj)).zza(l, j1, k1, l1, j);
                if (zzxX.containsKey(zziz1))
                {
                    j = ((Integer)zzxX.get(zziz1)).intValue();
                    zziz1 = ((zziy) (obj)).zzgX();
                    zziz1.setBackgroundColor(j);
                    zziz1.zzeW();
                    return;
                }
            } else
            {
                ((zziy) (obj)).zze(l, j1, k1, l1);
                return;
            }
        } else
        {
            obj = ((zziy) (obj)).zzgX();
            if (obj == null)
            {
                zzk.zzd(zziz1);
                return;
            }
            if ("click".equals(obj1))
            {
                zziz1 = zziz1.getContext();
                int k = zza(((Context) (zziz1)), map, "x", 0);
                int i1 = zza(((Context) (zziz1)), map, "y", 0);
                long l2 = SystemClock.uptimeMillis();
                zziz1 = MotionEvent.obtain(l2, l2, 0, k, i1, 0);
                ((zzk) (obj)).zzd(zziz1);
                zziz1.recycle();
                return;
            }
            if ("currentTime".equals(obj1))
            {
                zziz1 = (String)map.get("time");
                if (zziz1 == null)
                {
                    zzb.zzaH("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try
                {
                    ((zzk) (obj)).seekTo((int)(Float.parseFloat(zziz1) * 1000F));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    zzb.zzaH((new StringBuilder()).append("Could not parse time parameter from currentTime video GMSG: ").append(zziz1).toString());
                }
                return;
            }
            if ("hide".equals(obj1))
            {
                ((zzk) (obj)).setVisibility(4);
                return;
            }
            if ("load".equals(obj1))
            {
                ((zzk) (obj)).zzeV();
                return;
            }
            if ("mimetype".equals(obj1))
            {
                ((zzk) (obj)).setMimeType((String)map.get("mimetype"));
                return;
            }
            if ("muted".equals(obj1))
            {
                if (Boolean.parseBoolean((String)map.get("muted")))
                {
                    ((zzk) (obj)).zzex();
                    return;
                } else
                {
                    ((zzk) (obj)).zzey();
                    return;
                }
            }
            if ("pause".equals(obj1))
            {
                ((zzk) (obj)).pause();
                return;
            }
            if ("play".equals(obj1))
            {
                ((zzk) (obj)).play();
                return;
            }
            if ("show".equals(obj1))
            {
                ((zzk) (obj)).setVisibility(0);
                return;
            }
            if ("src".equals(obj1))
            {
                ((zzk) (obj)).zzan((String)map.get("src"));
                return;
            }
            if ("volume".equals(obj1))
            {
                zziz1 = (String)map.get("volume");
                if (zziz1 == null)
                {
                    zzb.zzaH("Level parameter missing from volume video GMSG.");
                    return;
                }
                try
                {
                    ((zzk) (obj)).zza(Float.parseFloat(zziz1));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    zzb.zzaH((new StringBuilder()).append("Could not parse volume parameter from volume video GMSG: ").append(zziz1).toString());
                }
                return;
            }
            if ("watermark".equals(obj1))
            {
                ((zzk) (obj)).zzeW();
                return;
            } else
            {
                zzb.zzaH((new StringBuilder()).append("Unknown video action: ").append(((String) (obj1))).toString());
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
