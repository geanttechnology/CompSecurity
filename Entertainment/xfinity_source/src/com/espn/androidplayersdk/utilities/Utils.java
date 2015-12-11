// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.utilities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.espn.androidplayersdk.datamanager.EPSDKPrefs;
import com.espn.androidplayersdk.datamanager.ESPNPlayerSdk;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils
{

    private static final String DATE_TIME_FORMAT = "MM/dd/yyyy hh:mm:ss a";

    public Utils()
    {
    }

    public static String DateTimeFormatter(Date date)
    {
        String s;
        try
        {
            s = (new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a")).format(date);
        }
        catch (Exception exception)
        {
            Log.e(ESPNPlayerSdk.SDKTAG, (new StringBuilder("String format failed")).append(date.toString()).toString());
            return null;
        }
        return s;
    }

    public static String getConnectionType()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)ESPNPlayerSdk.mCtx.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        int i;
        if (!networkinfo.isConnected())
        {
            break MISSING_BLOCK_LABEL_38;
        }
        i = networkinfo.getType();
        if (i == 0)
        {
            return "MOBILE";
        }
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (!networkinfo.isConnected())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        i = networkinfo.getType();
        if (i == 1)
        {
            return "WiFi";
        }
        break MISSING_BLOCK_LABEL_70;
        Exception exception;
        exception;
        sdkLog("unable to determin network state", 3, exception);
        return "";
    }

    public static String getExpiryTime(int i)
    {
        return (new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a")).format(new Date(System.currentTimeMillis() + (long)(i * 1000)));
    }

    public static boolean isEmpty(String s)
    {
        return s.isEmpty();
    }

    public static boolean isExpired(String s)
    {
        boolean flag;
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            Date date = new Date();
            flag = simpledateformat.parse(s).before(date);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(ESPNPlayerSdk.SDKTAG, (new StringBuilder("Date comparison failed ")).append(s.getMessage()).toString());
            return true;
        }
        return flag;
    }

    public static Boolean isTablet(Context context)
    {
        Object obj = ESPNPlayerSdk.mCtx.getResources().getConfiguration();
        if (context.getPackageManager().hasSystemFeature("com.google.android.tv"))
        {
            return Boolean.valueOf(true);
        }
        if (((((Configuration) (obj)).screenLayout & 0xf) == 4 || (((Configuration) (obj)).screenLayout & 0xf) == 3) && ((Configuration) (obj)).touchscreen == 1)
        {
            return Boolean.valueOf(true);
        }
        context = (WindowManager)context.getSystemService("window");
        obj = new DisplayMetrics();
        context.getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        if (Math.sqrt(Math.pow((float)((DisplayMetrics) (obj)).widthPixels / ((DisplayMetrics) (obj)).xdpi, 2D) + Math.pow((float)((DisplayMetrics) (obj)).heightPixels / ((DisplayMetrics) (obj)).ydpi, 2D)) < 6D)
        {
            return null;
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public static boolean isTablet()
    {
label0:
        {
label1:
            {
                int i;
                try
                {
                    Configuration configuration = ESPNPlayerSdk.mCtx.getResources().getConfiguration();
                    if ((configuration.screenLayout & 0xf) == 3)
                    {
                        break label1;
                    }
                    i = configuration.screenLayout;
                }
                catch (Exception exception)
                {
                    String s;
                    if ((new StringBuilder("Utils.isTablet(); Error: ")).append(exception.getMessage()).toString() != null)
                    {
                        s = exception.getMessage();
                    } else
                    {
                        s = "";
                    }
                    sdkLog(s, 5, exception);
                    return true;
                }
                if ((i & 0xf) != 4)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    public static void sdkLog(String s, int i, Exception exception)
    {
        int j = EPSDKPrefs.getLoggingLevel();
        if (i == 1 && i >= j)
        {
            Log.v(ESPNPlayerSdk.SDKTAG, s, exception);
        } else
        {
            if (i == 2 && i >= j)
            {
                Log.d(ESPNPlayerSdk.SDKTAG, s, exception);
                return;
            }
            if (i == 3 && i >= j)
            {
                Log.i(ESPNPlayerSdk.SDKTAG, s, exception);
                return;
            }
            if (i == 4 && i >= j)
            {
                Log.w(ESPNPlayerSdk.SDKTAG, s, exception);
                return;
            }
            if (i == 5 && i >= j)
            {
                Log.e(ESPNPlayerSdk.SDKTAG, s, exception);
                return;
            }
        }
    }

    public static String toBase64fromString(String s)
        throws UnsupportedEncodingException
    {
        return URLEncoder.encode(Base64.encodeToString(s.getBytes(), 2), "UTF-8");
    }

    public static String url(String s)
        throws UnsupportedEncodingException
    {
        return URLEncoder.encode(Base64.encodeToString(s.getBytes(), 2), "UTF-8");
    }
}
