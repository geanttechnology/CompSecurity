// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.helpshift.g.b.a;
import com.helpshift.m;
import com.helpshift.s;
import com.helpshift.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift.i:
//            a, s, h

public final class u
{

    private static m a;

    public static String a(Context context)
    {
        try
        {
            String s1 = context.getPackageName();
            context = context.getPackageManager().getPackageInfo(s1, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.d("HelpShiftDebug", "Package not found exception", context);
            return null;
        }
        return context;
    }

    private static String a(Intent intent)
    {
        int i = intent.getIntExtra("level", -1);
        int j = intent.getIntExtra("scale", -1);
        i = (int)(((float)i / (float)j) * 100F);
        return (new StringBuilder()).append(i).append("%").toString();
    }

    private static JSONArray a(ArrayList arraylist)
    {
        JSONArray jsonarray = new JSONArray();
        for (int i = 0; i < arraylist.size(); i++)
        {
            jsonarray.put(a((HashMap)arraylist.get(i)));
        }

        return jsonarray;
    }

    public static JSONObject a()
        throws JSONException
    {
        if (a != null)
        {
            HashMap hashmap = a.a();
            if (hashmap != null)
            {
                return new JSONObject(c(b(hashmap)));
            }
        }
        return null;
    }

    public static JSONObject a(Context context, Boolean boolean1, String s1)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        try
        {
            jsonobject.put("breadcrumbs", b(context));
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "Error while getting device info", jsonexception);
        }
        if (!boolean1.booleanValue()) goto _L2; else goto _L1
_L1:
        jsonobject.put("device_info", c(context));
_L5:
        try
        {
            jsonobject.put("extra", a(s1));
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            Log.d("HelpShiftDebug", "Error while getting extra info", boolean1);
        }
        try
        {
            jsonobject.put("logs", a(x.a(((Integer)a.b.get("dbgl")).intValue())));
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            Log.d("HelpShiftDebug", "Error while getting debug logs", boolean1);
        }
        try
        {
            jsonobject.put("device_token", (new s(context)).j());
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            Log.d("HelpShiftDebug", "Error while getting device token", boolean1);
        }
        context = new s(context);
        if (a == null) goto _L4; else goto _L3
_L3:
        try
        {
            boolean1 = a();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.d("HelpShiftDebug", "Error while getting extra meta", context);
            return jsonobject;
        }
        if (boolean1 == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        jsonobject.put("custom_meta", boolean1);
        context.c(boolean1);
_L7:
        return jsonobject;
_L2:
        try
        {
            jsonobject.put("device_info", new JSONObject());
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            Log.d("HelpShiftDebug", "Error while getting device info", boolean1);
        }
          goto _L5
_L4:
        try
        {
            context = context.M();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.d("HelpShiftDebug", "Exception in getting meta from storage ", context);
            return jsonobject;
        }
        if (context == null) goto _L7; else goto _L6
_L6:
        jsonobject.put("custom_meta", context);
        return jsonobject;
    }

    private static JSONObject a(String s1)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("api-version", "2");
        jsonobject.put("library-version", "3.9.1");
        if (s1 != null)
        {
            jsonobject.put("user-id", s1);
        }
        return jsonobject;
    }

    private static JSONObject a(HashMap hashmap)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("message", hashmap.get("message"));
            jsonobject.put("level", hashmap.get("level"));
            jsonobject.put("tag", hashmap.get("tag"));
            jsonobject.put("exception", hashmap.get("exception"));
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Log.d("HelpShiftDebug", "Format debug lgos", hashmap);
            return jsonobject;
        }
        return jsonobject;
    }

    public static void a(m m1)
    {
        a = m1;
    }

    private static String[] a(String as[])
    {
        int i = as.length;
        int k = i;
        int j = i;
        do
        {
            if (j <= 0)
            {
                break;
            }
            int l = j - 1;
            String s1 = as[l];
            j = l;
            if (s1 != null)
            {
                j = l;
                if (!TextUtils.isEmpty(s1.trim()))
                {
                    k--;
                    as[k] = s1.trim();
                    j = l;
                }
            }
        } while (true);
        return (String[])(new HashSet(Arrays.asList(com.helpshift.i.a.a(as, k, i)))).toArray(new String[0]);
    }

    private static String b(Intent intent)
    {
        int i = intent.getIntExtra("status", -1);
        boolean flag;
        if (i == 2 || i == 5)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return "Charging";
        } else
        {
            return "Not charging";
        }
    }

    private static HashMap b(HashMap hashmap)
    {
        HashMap hashmap1 = (HashMap)hashmap.clone();
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            Object obj1 = hashmap.get(obj);
            if ((obj instanceof String) && ((String)obj).trim().equalsIgnoreCase(""))
            {
                hashmap1.remove(obj);
            }
            if ((obj1 instanceof String) && ((String)obj1).trim().equalsIgnoreCase(""))
            {
                hashmap1.remove(obj);
            }
        } while (true);
        return hashmap1;
    }

    private static JSONArray b(Context context)
        throws JSONException
    {
        return (new s(context)).o();
    }

    private static HashMap c(HashMap hashmap)
    {
        Object obj = hashmap.get("hs-tags");
        hashmap.remove("hs-tags");
        if (obj instanceof String[])
        {
            hashmap.put("hs-tags", new JSONArray(Arrays.asList(a((String[])(String[])obj))));
        }
        return hashmap;
    }

    private static JSONObject c(Context context)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("platform", "android");
        jsonobject.put("library-version", "3.9.1");
        jsonobject.put("device-model", Build.MODEL);
        jsonobject.put("os-version", android.os.Build.VERSION.RELEASE);
        TelephonyManager telephonymanager;
        try
        {
            jsonobject.put("language-code", com.helpshift.i.s.a());
        }
        catch (MissingResourceException missingresourceexception)
        {
            Log.d("HelpShiftDebug", "Device Info - MissingResourceException", missingresourceexception);
        }
        jsonobject.put("timestamp", h.c.format(new Date()));
        jsonobject.put("application-identifier", context.getPackageName());
        jsonobject.put("application-name", d(context));
        jsonobject.put("application-version", a(context));
        jsonobject.put("disk-space", e(context));
        telephonymanager = (TelephonyManager)context.getSystemService("phone");
        jsonobject.put("country-code", telephonymanager.getSimCountryIso());
        jsonobject.put("carrier-name", telephonymanager.getNetworkOperatorName());
        try
        {
            jsonobject.put("network-type", f(context));
        }
        catch (SecurityException securityexception)
        {
            Log.d("HelpShiftDebug", "No permission for Network Access", securityexception);
        }
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        jsonobject.put("battery-level", a(context));
        jsonobject.put("battery-status", b(context));
        return jsonobject;
    }

    private static String d(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getApplicationInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = null;
        }
        if (context != null)
        {
            context = packagemanager.getApplicationLabel(context);
        } else
        {
            context = "(unknown)";
        }
        return (String)(String)context;
    }

    private static JSONObject e(Context context)
    {
        context = new JSONObject();
        StatFs statfs = new StatFs(Environment.getDataDirectory().getPath());
        StatFs statfs1 = new StatFs(Environment.getExternalStorageDirectory().getPath());
        double d1 = (double)Math.round((((double)statfs.getAvailableBlocks() * (double)statfs.getBlockSize()) / 1073741824D) * 100D) / 100D;
        double d2 = (double)Math.round((((double)statfs.getBlockCount() * (double)statfs.getBlockSize()) / 1073741824D) * 100D) / 100D;
        double d3 = (double)Math.round((((double)statfs1.getAvailableBlocks() * (double)statfs1.getBlockSize()) / 1073741824D) * 100D) / 100D;
        double d4 = statfs1.getBlockCount();
        d4 = (double)Math.round((((double)statfs1.getBlockSize() * d4) / 1073741824D) * 100D) / 100D;
        try
        {
            context.put("free-space-phone", (new StringBuilder()).append(d1).append(" GB").toString());
            context.put("total-space-phone", (new StringBuilder()).append(d2).append(" GB").toString());
            context.put("free-space-sd", (new StringBuilder()).append(d3).append(" GB").toString());
            context.put("total-space-sd", (new StringBuilder()).append(d4).append(" GB").toString());
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", jsonexception.toString(), jsonexception);
            return context;
        }
        return context;
    }

    private static String f(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        context = "Unknown";
        if (networkinfo != null)
        {
            context = networkinfo.getTypeName();
        }
        return context;
    }
}
