// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Vibrator;
import android.text.TextUtils;
import android.widget.Toast;
import com.millennialmedia.MMException;
import com.millennialmedia.MMLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.utils:
//            EnvironmentUtils, ThreadUtils

public class Utils
{
    public static interface VibrateListener
    {

        public abstract void onError();

        public abstract void onFinished();

        public abstract void onStarted();
    }


    private static final String TAG = com/millennialmedia/internal/utils/Utils.getName();

    public Utils()
    {
    }

    static String byteArrayToHex(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(String.format("%02X", new Object[] {
                Byte.valueOf(abyte0[i])
            }));
        }

        return stringbuilder.toString();
    }

    public static void injectIfNotNull(Map map, String s, Object obj)
    {
        if (s == null)
        {
            MMLog.e(TAG, "Unable to inject value, specified key is null");
        } else
        if (obj != null)
        {
            map.put(s, obj);
            return;
        }
    }

    public static boolean isEmpty(String s)
    {
        if (s == null)
        {
            return true;
        } else
        {
            return s.trim().isEmpty();
        }
    }

    public static boolean isPackageAvailable(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        PackageManager packagemanager = EnvironmentUtils.getApplicationContext().getPackageManager();
        try
        {
            packagemanager.getPackageInfo(s, 128);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static boolean isSchemeAvailable(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            String s1 = s;
            if (!s.contains(":"))
            {
                s1 = (new StringBuilder()).append(s).append(":").toString();
            }
            s = EnvironmentUtils.getApplicationContext().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(s1)), 0x10000);
            if (s != null && s.size() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public static void logAndFireMMException(String s, String s1)
        throws MMException
    {
        MMLog.e(s, s1);
        throw new MMException(s1);
    }

    public static void showToast(Context context, String s)
    {
        ThreadUtils.runOnUiThread(new Runnable(context, s) {

            final Context val$context;
            final String val$message;

            public void run()
            {
                Toast.makeText(context, message, 0).show();
            }

            
            {
                context = context1;
                message = s;
                super();
            }
        });
    }

    public static List splitCommaSeparateString(String s)
    {
        if (s != null)
        {
            ArrayList arraylist = new ArrayList();
            s = s.split(",");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                String s1 = s[i].trim();
                if (!arraylist.contains(s1))
                {
                    arraylist.add(s1);
                }
            }

            s = arraylist;
            if (arraylist.size() == 0)
            {
                s = null;
            }
            return s;
        } else
        {
            return null;
        }
    }

    public static boolean startActivity(Context context, Intent intent)
    {
        if (!(context instanceof Activity))
        {
            intent.addFlags(0x10000000);
        }
        try
        {
            context.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to start activity for intent: ").append(intent).toString());
            return false;
        }
        return true;
    }

    public static boolean startActivityFromUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            MMLog.e(TAG, "Unable to start activity for null url");
            return false;
        } else
        {
            s = new Intent("android.intent.action.VIEW", Uri.parse(s));
            return startActivity(EnvironmentUtils.getApplicationContext(), s);
        }
    }

    public static void vibrate(long al[], int i, VibrateListener vibratelistener)
    {
        if (vibratelistener == null)
        {
            MMLog.e(TAG, "Unable to call vibrate, provided listener cannot be null");
            return;
        }
        if (!EnvironmentUtils.hasVibratePermission())
        {
            MMLog.e(TAG, "Unable to call vibrate, permission is not available");
            vibratelistener.onError();
            return;
        }
        ((Vibrator)EnvironmentUtils.getApplicationContext().getSystemService("vibrator")).vibrate(al, -1);
        vibratelistener.onStarted();
        long l = 0L;
        for (i = 0; i < al.length; i++)
        {
            l += al[i];
        }

        ThreadUtils.runOnWorkerThreadDelayed(new Runnable(vibratelistener) {

            final VibrateListener val$vibrateListener;

            public void run()
            {
                vibrateListener.onFinished();
            }

            
            {
                vibrateListener = vibratelistener;
                super();
            }
        }, l);
    }

}
