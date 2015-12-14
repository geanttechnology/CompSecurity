// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.silentupdate.SilentManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FrontiaApplication extends Application
{

    private static final String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYAFbG0oYmKgh6o7BhZIHf1njBpZXqyWBnYz2ip3Wp+s97OeA/pTe8xebuGJHwq4xbsGQrJWepIbUVrdjm6JRmdvuJhar7/hC/UNnUkJgYdYl10OZKlvcFFgK3V7XGBPplXldDnhbgscna3JG8U3025WSxZCP5vy/8cfxsEoVx5QIDAQAB";
    private static final String b = "f5de4bda49c00a19757289cd02a60f5d";
    private static final String c = "com.baidu.android.pushservice.PushService";

    public FrontiaApplication()
    {
    }

    private static boolean a(Context context)
    {
        try
        {
            Object obj = (ActivityManager)context.getSystemService("activity");
            int i = Process.myPid();
            obj = ((ActivityManager) (obj)).getRunningAppProcesses().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
                if (runningappprocessinfo.pid == i)
                {
                    String s = c(context);
                    if (runningappprocessinfo.processName.equalsIgnoreCase(s) && !b(context.getApplicationContext()))
                    {
                        Process.killProcess(i);
                    }
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean b(Context context)
    {
        boolean flag;
        try
        {
            SilentManager.setKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYAFbG0oYmKgh6o7BhZIHf1njBpZXqyWBnYz2ip3Wp+s97OeA/pTe8xebuGJHwq4xbsGQrJWepIbUVrdjm6JRmdvuJhar7/hC/UNnUkJgYdYl10OZKlvcFFgK3V7XGBPplXldDnhbgscna3JG8U3025WSxZCP5vy/8cfxsEoVx5QIDAQAB");
            SilentManager.enableRSA(true);
            flag = SilentManager.loadLib(context.getApplicationContext(), "frontia_plugin", "plugin-deploy.jar");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return flag;
    }

    private static String c(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getPackageInfo(context.getPackageName(), 4).services;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = null;
        }
        if (context == null)
        {
            return null;
        }
        for (int i = 0; i < context.length; i++)
        {
            if ("com.baidu.android.pushservice.PushService".equals(((ServiceInfo) (context[i])).name))
            {
                return ((ServiceInfo) (context[i])).processName;
            }
        }

        return null;
    }

    private static boolean d(Context context)
    {
        boolean flag = false;
        BufferedReader bufferedreader;
        String s;
        try
        {
            bufferedreader = new BufferedReader(new InputStreamReader(context.getAssets().open("frontia_plugin/plugin-deploy.key")));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        context = "";
        s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        context = (new StringBuilder()).append(context).append(s).append("\r\n").toString();
        break MISSING_BLOCK_LABEL_29;
        context = SilentManager.decrypt("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYAFbG0oYmKgh6o7BhZIHf1njBpZXqyWBnYz2ip3Wp+s97OeA/pTe8xebuGJHwq4xbsGQrJWepIbUVrdjm6JRmdvuJhar7/hC/UNnUkJgYdYl10OZKlvcFFgK3V7XGBPplXldDnhbgscna3JG8U3025WSxZCP5vy/8cfxsEoVx5QIDAQAB", context);
        if (!TextUtils.isEmpty(context))
        {
            flag = (new JSONObject(context)).optString("flag", "null").equals("f5de4bda49c00a19757289cd02a60f5d");
        }
        return flag;
    }

    public static void initFrontiaApplication(Context context)
    {
        if (d(context))
        {
            if (!a(context))
            {
                b(context);
            }
            return;
        } else
        {
            b(context);
            return;
        }
    }

    public void onCreate()
    {
        super.onCreate();
        initFrontiaApplication(getApplicationContext());
    }
}
