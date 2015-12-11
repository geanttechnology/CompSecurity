// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzcv

public class zzax
{

    private static String zzaXk;
    static Map zzaXl = new HashMap();

    public zzax()
    {
    }

    public static String zzM(String s, String s1)
    {
        if (s1 == null)
        {
            if (s.length() > 0)
            {
                return s;
            } else
            {
                return null;
            }
        } else
        {
            return Uri.parse((new StringBuilder("http://hostname/?")).append(s).toString()).getQueryParameter(s1);
        }
    }

    public static void zzeS(String s)
    {
        com/google/android/gms/tagmanager/zzax;
        JVM INSTR monitorenter ;
        zzaXk = s;
        com/google/android/gms/tagmanager/zzax;
        JVM INSTR monitorexit ;
        return;
        s;
        com/google/android/gms/tagmanager/zzax;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static String zzf(Context context, String s, String s1)
    {
        String s2 = (String)zzaXl.get(s);
        Object obj = s2;
        if (s2 == null)
        {
            context = context.getSharedPreferences("gtm_click_referrers", 0);
            if (context != null)
            {
                context = context.getString(s, "");
            } else
            {
                context = "";
            }
            zzaXl.put(s, context);
            obj = context;
        }
        return zzM(((String) (obj)), s1);
    }

    public static String zzn(Context context, String s)
    {
        if (zzaXk != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/tagmanager/zzax;
        JVM INSTR monitorenter ;
        if (zzaXk != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        context = context.getSharedPreferences("gtm_install_referrer", 0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        zzaXk = context.getString("referrer", "");
_L3:
        com/google/android/gms/tagmanager/zzax;
        JVM INSTR monitorexit ;
_L2:
        return zzM(zzaXk, s);
        zzaXk = "";
          goto _L3
        context;
        com/google/android/gms/tagmanager/zzax;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static void zzo(Context context, String s)
    {
        String s1 = zzM(s, "conv");
        if (s1 != null && s1.length() > 0)
        {
            zzaXl.put(s1, s);
            zzcv.zzb(context, "gtm_click_referrers", s1, s);
        }
    }

}
