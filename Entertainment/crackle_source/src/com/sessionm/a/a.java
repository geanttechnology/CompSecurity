// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.a;

import android.content.Context;
import android.util.Log;
import com.sessionm.core.f;
import java.lang.reflect.Method;
import java.security.MessageDigest;

public class a
{

    public static final String TAG = "SessionM.CPI";
    private static final String ed = "getAdvertisingIdInfo";
    private static final String ee = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static final String ef = "SHA-1";
    private static final String eg = "iso-8859-1";

    public a()
    {
    }

    public static String a(byte abyte0[])
    {
        StringBuffer stringbuffer;
        int i;
        int l;
        stringbuffer = new StringBuffer();
        l = abyte0.length;
        i = 0;
_L2:
        int j;
        int k;
        byte byte0;
        if (i >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = abyte0[i];
        k = byte0 >>> 4 & 0xf;
        j = 0;
_L3:
        if (k >= 0 && k <= 9)
        {
            stringbuffer.append((char)(k + 48));
        } else
        {
            stringbuffer.append((char)((k - 10) + 97));
        }
        if (j < 1)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return stringbuffer.toString();
        j++;
        k = byte0 & 0xf;
          goto _L3
    }

    public static String b(String s, String s1)
    {
        String s2;
        String s4;
        s4 = "";
        s2 = "";
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        if (Log.isLoggable("SessionM.CPI", 6))
        {
            Log.e("SessionM.CPI", "type was not provided for getSystemIdentifiers call!");
        }
        s4 = "";
_L5:
        return s4;
_L2:
        String s3;
        Context context;
label0:
        {
            if (s1 != null)
            {
                s3 = s1;
                if (s1.length() != 0)
                {
                    break label0;
                }
            }
            s3 = "none";
        }
        context = f.E().getApplicationContext();
        if (!s.equalsIgnoreCase("gpadvertiserid")) goto _L4; else goto _L3
_L3:
        s1 = q(context);
_L6:
        if (!s1.equals(""))
        {
            s2 = c(s1, s3);
        }
        s4 = s2;
        if (Log.isLoggable("SessionM.CPI", 3))
        {
            if (!s2.equals(""))
            {
                Log.d("SessionM.CPI", String.format("Retreived id with type: %s algorithm: %s id: %s", new Object[] {
                    s, s3, s1
                }));
                return s2;
            } else
            {
                Log.d("SessionM.CPI", String.format("Failed to retreived id! Type: %s Algorithm: %s Id: %s", new Object[] {
                    s, s3, s1
                }));
                return s2;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
        s1 = s4;
        if (s.equalsIgnoreCase("androiddeviceid"))
        {
            s1 = s4;
            if (q(context).equals(""))
            {
                s1 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
        }
          goto _L6
    }

    public static String c(String s, String s1)
    {
        Object obj = s;
        try
        {
            if (!s1.equalsIgnoreCase("none"))
            {
                s1 = MessageDigest.getInstance(s1);
                obj = new byte[s1.getDigestLength()];
                s1.update(s.getBytes("iso-8859-1"), 0, s.length());
                obj = a(s1.digest());
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            obj = s;
            if (Log.isLoggable("SessionM.CPI", 5))
            {
                Log.w("SessionM.CPI", (new StringBuilder()).append("error hashing id ").append(s1).toString());
                return s;
            }
        }
        return ((String) (obj));
    }

    private static String q(Context context)
    {
        try
        {
            Class class1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            context = ((Context) (class1.getMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            }).invoke(class1.getClass(), new Object[] {
                context
            })));
            context = (String)context.getClass().getMethod("getId", new Class[0]).invoke(context, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (Log.isLoggable("SessionM.CPI", 3))
            {
                Log.d("SessionM.CPI", "Error retreiving advertiser id: ", context);
            }
            return "";
        }
        return context;
    }

    public static boolean r(Context context)
    {
        boolean flag;
        try
        {
            Class class1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            context = ((Context) (class1.getMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            }).invoke(class1.getClass(), new Object[] {
                context
            })));
            flag = ((Boolean)context.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(context, new Object[0])).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (Log.isLoggable("SessionM.CPI", 3))
            {
                Log.d("SessionM.CPI", "Error retreiving ad tracking limited: ", context);
            }
            return false;
        }
        return flag;
    }
}
