// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.utils;

import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mdotm.android.listener.InterstitialActionListener;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.mdotm.android.utils:
//            MdotMAdInfo, MdotMLogger

public class MdotMUtils
{

    public static int AD_ICON_WITH_TEXT_MESSAGE = 2;
    public static int AD_RECEVIED = 1;
    public static int AD_WITH_BANNER_OR_XHTML_OR_VIDEO = 1;
    private static MdotMUtils _mdotmUtilsInstance;
    private HashMap interstitialActionListeners;

    public MdotMUtils()
    {
        interstitialActionListeners = new HashMap();
    }

    private com.google.android.gms.ads.identifier.AdvertisingIdClient.Info getAdInfo(Context context)
    {
        try
        {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MdotMLogger.i("this", "GPS not found ");
            context.printStackTrace();
            return null;
        }
        return MdotMAdInfo.getAdInfo(context);
    }

    private String getUserAgentManually()
    {
        StringBuffer stringbuffer = new StringBuffer();
        Object obj = android.os.Build.VERSION.RELEASE;
        String s;
        if (((String) (obj)).length() > 0)
        {
            stringbuffer.append(((String) (obj)));
        } else
        {
            stringbuffer.append("1.0");
        }
        stringbuffer.append("; ");
        obj = Locale.getDefault();
        s = ((Locale) (obj)).getLanguage();
        if (s != null)
        {
            stringbuffer.append(s.toLowerCase());
            obj = ((Locale) (obj)).getCountry();
            if (obj != null)
            {
                stringbuffer.append("-");
                stringbuffer.append(((String) (obj)).toLowerCase());
            }
        } else
        {
            stringbuffer.append("en");
        }
        obj = Build.MODEL;
        if (((String) (obj)).length() > 0)
        {
            stringbuffer.append("; ");
            stringbuffer.append(((String) (obj)));
        }
        obj = Build.ID;
        if (((String) (obj)).length() > 0)
        {
            stringbuffer.append(" Build/");
            stringbuffer.append(((String) (obj)));
        }
        return String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", new Object[] {
            stringbuffer
        });
    }

    public static MdotMUtils getUtilsInstance()
    {
        if (_mdotmUtilsInstance == null)
        {
            _mdotmUtilsInstance = new MdotMUtils();
        }
        return _mdotmUtilsInstance;
    }

    private boolean isNetworkAvailable(Context context)
    {
        context = ((ConnectivityManager)context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public String getAdId(Context context)
    {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = getAdInfo(context);
        context = null;
        if (info != null)
        {
            context = info.getId();
            MdotMLogger.i(this, (new StringBuilder("Ad Id is ")).append(context).toString());
        }
        return context;
    }

    public String getBandWidth(Context context)
    {
        String s;
        Object obj;
        NetworkInfo networkinfo;
        obj = null;
        networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        s = obj;
        if (networkinfo == null) goto _L2; else goto _L1
_L1:
        s = obj;
        if (!networkinfo.isConnected()) goto _L2; else goto _L3
_L3:
        int i;
        int j;
        i = networkinfo.getType();
        j = networkinfo.getSubtype();
        if (i != 1) goto _L5; else goto _L4
_L4:
        try
        {
            context = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        s = obj;
        if (context == null) goto _L2; else goto _L6
_L6:
        context = Integer.valueOf(context.getLinkSpeed());
        MdotMLogger.i(this, (new StringBuilder("Wifi bandwidth ")).append(context).toString());
        s = (new StringBuilder(String.valueOf(String.valueOf(context)))).append("000").toString();
_L2:
        return s;
_L5:
        s = obj;
        if (i != 0) goto _L2; else goto _L7
_L7:
        s = obj;
        switch (j)
        {
        default:
            return null;

        case 1: // '\001'
            return "100";

        case 7: // '\007'
            return "50";

        case 4: // '\004'
            return "14";

        case 2: // '\002'
            return "50";

        case 5: // '\005'
            return "400";

        case 6: // '\006'
            return "600";

        case 8: // '\b'
            return "2000";

        case 10: // '\n'
            return "700";

        case 9: // '\t'
            return "1024";

        case 3: // '\003'
            return "400";

        case 14: // '\016'
            return "1024";

        case 12: // '\f'
            return "5120";

        case 15: // '\017'
            return "10240";

        case 11: // '\013'
            return "25600";

        case 13: // '\r'
            return "10240";

        case 0: // '\0'
            break;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public String getDisplaySize(Context context)
    {
        Point point;
        point = new Point();
        context = (WindowManager)context.getSystemService("window");
        if (android.os.Build.VERSION.SDK_INT < 13) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        MdotMLogger.i(this, "Getting conditional display size");
        context.getDefaultDisplay().getSize(point);
        j = point.x;
        i = point.y;
_L4:
        context = (new StringBuilder(String.valueOf(j))).append(",").append(i).toString();
        MdotMLogger.i(this, (new StringBuilder("SCREEN DISPLAY SIZE ")).append(context).toString());
        return context;
_L2:
        try
        {
            MdotMLogger.i(this, "Default display");
            Display display = context.getDefaultDisplay();
            j = display.getWidth();
            i = display.getHeight();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            MdotMLogger.i(this, "Default display");
            context = context.getDefaultDisplay();
            j = context.getWidth();
            i = context.getHeight();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public InterstitialActionListener getInterstitialActionListener(long l)
    {
        return (InterstitialActionListener)interstitialActionListeners.get(Long.valueOf(l));
    }

    public boolean getLAT(Context context)
    {
        context = getAdInfo(context);
        boolean flag1 = false;
        boolean flag = flag1;
        if (context != null)
        {
            flag = flag1;
            if (context.getId() != null)
            {
                flag = context.isLimitAdTrackingEnabled();
                MdotMLogger.i(this, (new StringBuilder("isLAT ")).append(flag).toString());
            }
        }
        return flag;
    }

    public String getUserAgent(Context context)
    {
        try
        {
            context = (new WebView(context)).getSettings().getUserAgentString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MdotMLogger.e(this, context.getMessage());
            return getUserAgentManually();
        }
        return context;
    }

    public void removeInterstitialActionListener(long l)
    {
        interstitialActionListeners.remove(Long.valueOf(l));
    }

    public void reportImpression(String s, Context context)
    {
        MdotMLogger.d(this, (new StringBuilder("initiated ")).append(s).toString());
    /* block-local class not found */
    class MyAsynchTask {}

        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new MyAsynchTask(context)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] {
                s
            });
            return;
        } else
        {
            (new MyAsynchTask(context)).execute(new String[] {
                s
            });
            return;
        }
    }

    public void setInterstitialActionListener(long l, InterstitialActionListener interstitialactionlistener)
    {
        interstitialActionListeners.put(Long.valueOf(l), interstitialactionlistener);
    }


}
