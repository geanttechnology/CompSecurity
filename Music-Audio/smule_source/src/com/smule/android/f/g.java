// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.smule.android.c.aa;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

// Referenced classes of package com.smule.android.f:
//            p

public class g
{

    private static final String a = com/smule/android/f/g.getName();
    private static String b = "ed6153fa-df85-401b-aa48-2855714d6987";
    private static String c = null;
    private static String d = null;
    private static String e = null;

    public g()
    {
    }

    public static String a(Context context)
    {
        com/smule/android/f/g;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            c(context);
        }
        context = c;
        com/smule/android/f/g;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static String a(Context context, boolean flag)
    {
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        context = AdvertisingIdClient.getAdvertisingIdInfo(context);
        if (context == null)
        {
            try
            {
                aa.b(a, "Error obtaining advertising id: client info returned was NULL");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                aa.b(a, "Error obtaining advertising id ", context);
                return null;
            }
            return null;
        }
        e = context.getId();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        return (new StringBuilder()).append("a:").append(e).toString();
        context = e;
        return context;
    }

    public static String b(Context context)
    {
        com/smule/android/f/g;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            c(context);
        }
        context = d;
        com/smule/android/f/g;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private static void c(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("MAGIC_DEVICE", 0);
        c = sharedpreferences.getString("DEVICE_ID_KEY", null);
        if (c == null)
        {
            c = d(context);
            context = sharedpreferences.edit();
            context.putString("DEVICE_ID_KEY", c);
            context.putString("ANDROID_ID", d);
            p.a(context);
            return;
        } else
        {
            d = sharedpreferences.getString("ANDROID_ID", null);
            return;
        }
    }

    private static String d(Context context)
    {
        d = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        try
        {
            if (d == null || "".equals(d) || "9774d56d682e549c".equals(d))
            {
                d = UUID.randomUUID().toString();
            }
            context = UUID.nameUUIDFromBytes((new String((new StringBuilder()).append(d).append(b).toString())).getBytes("utf8"));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        return context.toString();
    }

}
