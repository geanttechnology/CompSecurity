// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Locale;
import java.util.UUID;

// Referenced classes of package com.threatmetrix.TrustDefenderMobile:
//            StringUtils

class TDID
{

    private static final String TAG = com/threatmetrix/TrustDefenderMobile/TDID.getName();

    TDID()
    {
    }

    static String checkLength(String s)
    {
        if (s == null)
        {
            return null;
        }
        if (s.length() == 32)
        {
            return s;
        }
        if (s.length() < 32)
        {
            s = (new StringBuilder()).append(s).append(StringUtils.MD5(s).substring(0, 32 - s.length())).toString();
        } else
        {
            s = StringUtils.MD5(s);
        }
        return s;
    }

    static String getAndroidID(Context context)
    {
label0:
        {
            String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (s != null && !s.equals("9774d56d682e549c"))
            {
                context = s;
                if (s.length() >= 15)
                {
                    break label0;
                }
            }
            Log.d(TAG, "ANDROID_ID contains nothing useful");
            context = null;
        }
        return context;
    }

    static String getCookie(String s, boolean flag)
    {
        String s1 = s;
        String s2 = s1;
        if (s1 != null)
        {
            if (flag)
            {
                s1 = StringUtils.MD5(s);
            }
            Log.d(TAG, (new StringBuilder()).append("using ANDROID_ID for TPC:").append(s1).toString());
            s2 = s1;
        }
        return checkLength(s2);
    }

    static String getFlashCookie(Context context, String s, String s1, String s2, boolean flag)
    {
        s = getSerial(s, s1, s2);
        context = s;
        if (flag)
        {
            context = StringUtils.MD5(s);
        }
        return checkLength(StringUtils.MD5(context));
    }

    static String getHTML5Cookie(String s, boolean flag)
    {
        String s1 = s;
        if (flag)
        {
            s1 = StringUtils.MD5(s);
        }
        Log.d(TAG, (new StringBuilder()).append("using generated ID for LSC:").append(s1).toString());
        return checkLength(s1);
    }

    static String getIMEI(Context context)
    {
        try
        {
            context = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
            Log.d(TAG, (new StringBuilder()).append("imei: ").append(context).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.d(TAG, "imei failed", context);
            return "";
        }
        return context;
    }

    static String getPref(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("ThreatMetrixMobileSDK", 0);
        String s = sharedpreferences.getString("ThreatMetrixMobileSDK", null);
        context = s;
        if (s == null)
        {
            Log.d(TAG, "Found nothing in shared prefs, generating GUID");
            context = UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.US);
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("ThreatMetrixMobileSDK", context);
            editor.commit();
        }
        return context;
    }

    private static String getSerial(String s, String s1, String s2)
    {
        String s3;
        if (Build.SERIAL == null)
        {
            s3 = "";
        } else
        {
            s3 = Build.SERIAL;
        }
        if (s2 != null && !s2.isEmpty() && !s2.equals("000000000000000"))
        {
            return (new StringBuilder()).append(s3).append(s2).toString();
        }
        if (s != null)
        {
            return (new StringBuilder()).append(s3).append(s).toString();
        } else
        {
            return (new StringBuilder()).append(s3).append(s1).toString();
        }
    }

    static boolean isDodgySerial()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            String s = Build.SERIAL;
            flag = flag1;
            if (s == null)
            {
                break label0;
            }
            if (!s.equals("unknown"))
            {
                flag = flag1;
                if (!s.equals("1234567890ABCDEF"))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

}
