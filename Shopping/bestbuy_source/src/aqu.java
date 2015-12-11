// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class aqu
{

    static Map a = new HashMap();
    private static String b;

    aqu()
    {
    }

    static String a(String s, String s1)
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

    public static void a(Context context, String s)
    {
        arw.a(context, "gtm_install_referrer", "referrer", s);
        b(context, s);
    }

    public static void a(String s)
    {
        aqu;
        JVM INSTR monitorenter ;
        b = s;
        aqu;
        JVM INSTR monitorexit ;
        return;
        s;
        aqu;
        JVM INSTR monitorexit ;
        throw s;
    }

    static void b(Context context, String s)
    {
        String s1 = a(s, "conv");
        if (s1 != null && s1.length() > 0)
        {
            a.put(s1, s);
            arw.a(context, "gtm_click_referrers", s1, s);
        }
    }

}
