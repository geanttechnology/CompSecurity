// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            add

public class abg
{

    static Map a = new HashMap();
    private static String b;

    public abg()
    {
    }

    public static String a(Context context, String s)
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        android/support/v7/abg;
        JVM INSTR monitorenter ;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        context = context.getSharedPreferences("gtm_install_referrer", 0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        b = context.getString("referrer", "");
_L3:
        android/support/v7/abg;
        JVM INSTR monitorexit ;
_L2:
        return a(b, s);
        b = "";
          goto _L3
        context;
        android/support/v7/abg;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static String a(Context context, String s, String s1)
    {
        String s2 = (String)a.get(s);
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
            a.put(s, context);
            obj = context;
        }
        return a(((String) (obj)), s1);
    }

    public static String a(String s, String s1)
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
            return Uri.parse((new StringBuilder()).append("http://hostname/?").append(s).toString()).getQueryParameter(s1);
        }
    }

    public static void b(Context context, String s)
    {
        String s1 = a(s, "conv");
        if (s1 != null && s1.length() > 0)
        {
            a.put(s1, s);
            add.a(context, "gtm_click_referrers", s1, s);
        }
    }

}
