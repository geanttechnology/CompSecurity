// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.UUID;

// Referenced classes of package com.paypal.android.sdk:
//            dd, gf

public class a
{

    private final Context a;
    private final String b;
    private final gf c;

    public a(Context context, String s)
    {
        if (context == null)
        {
            throw new NullPointerException("context == null");
        } else
        {
            a = context;
            b = s;
            context = dd.a(e());
            s = c();
            c = new gf((new StringBuilder()).append(context).append(s).toString());
            return;
        }
    }

    public final String a(String s)
    {
        return c.b(a.getSharedPreferences(b, 0).getString(s, null));
    }

    public final void a(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = a.getSharedPreferences(b, 0).edit();
        editor.putString(s, c.a(s1));
        editor.commit();
    }

    public final boolean a()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)a.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            Log.w("paypal.sdk", "Unable to retrieve Context.CONNECTIVITY_SERVICE. Ignoring.");
            return true;
        }
        if (connectivitymanager.getAllNetworkInfo() == null)
        {
            Log.w("paypal.sdk", "ConnectivityManager.getAllNetworkInfo() returned null. Ignoring.");
            return true;
        }
        NetworkInfo anetworkinfo[] = connectivitymanager.getAllNetworkInfo();
        int l = anetworkinfo.length;
        int i = 0;
        int j;
        int k;
        for (j = 0; i < l; j = k)
        {
            k = j;
            if (anetworkinfo[i].isConnectedOrConnecting())
            {
                k = j + 1;
            }
            i++;
        }

        return j > 0;
    }

    public final int b()
    {
        return ((TelephonyManager)a.getSystemService("phone")).getPhoneType();
    }

    public final String b(String s)
    {
        return c.a(s);
    }

    public final String c()
    {
        Object obj;
        try
        {
            obj = a.getPackageManager();
            obj = ((PackageManager) (obj)).getPackageInfo(a.getPackageName(), 0).applicationInfo.loadLabel(((PackageManager) (obj))).toString();
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        return ((String) (obj));
    }

    public final String c(String s)
    {
        return c.b(s);
    }

    public final String d()
    {
        String s;
        try
        {
            s = ((TelephonyManager)a.getSystemService("phone")).getSimOperatorName();
        }
        catch (SecurityException securityexception)
        {
            securityexception.toString();
            return null;
        }
        return s;
    }

    public final String e()
    {
        String s = a.getSharedPreferences(b, 0).getString("InstallationGUID", null);
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = UUID.randomUUID().toString();
            android.content.SharedPreferences.Editor editor = a.getSharedPreferences(b, 0).edit();
            editor.putString("InstallationGUID", s1);
            editor.commit();
            return s1;
        }
    }

    public final Context f()
    {
        return a;
    }

    static 
    {
        com/paypal/android/sdk/a.getSimpleName();
    }
}
