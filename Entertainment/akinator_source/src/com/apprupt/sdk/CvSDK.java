// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.apprupt.sdk:
//            CvRandomString, CvAnimationType, CvContentManager, CvConfig, 
//            CvMediation, CvValueExchange, CvInterstitialActivity, CvOverlayActivity, 
//            CvExpandActivity, CvContentOptions, CvAdColony, CvInterstitialManager, 
//            CvAudience, Logger, CvUrl, CvAppInfo, 
//            CvViewHelper

public class CvSDK
{
    public static interface CvInterstitialListener
    {

        public abstract void cvInterstitialDidAppear(int i);

        public abstract void cvInterstitialDidDisappear(int i);

        public abstract void cvInterstitialDidFail(int i, String s, int j);

        public abstract void cvInterstitialFirstTap();

        public abstract void cvInterstitialWillAppear(int i);

        public abstract void cvInterstitialWillDisappear(int i);
    }


    public static final String API_LEVEL = "6";
    public static final int LOG_ERRORS = 12;
    public static final int LOG_INFO = 14;
    public static final int LOG_LEVEL_ERROR = 8;
    public static final int LOG_LEVEL_INFO = 2;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 4;
    public static final int LOG_NONE = 0;
    public static final int LOG_VERBOSE = 15;
    private static final String PI_KEY_FORMAT = (new StringBuilder()).append("pi.").append(CvRandomString.generate(8)).append(".%d.%s").toString();
    public static final String VERSION = "android_4.0.4";
    private static boolean adColonyInitialized = false;
    private static CvAnimationType animation;
    static final CvConfig config = new CvConfig();
    static final CvContentManager contentManager = new CvContentManager();
    private static boolean initialized = false;
    static final CvMediation mediation = new CvMediation();
    private static String piKey;
    private static int refreshInterval = 0;
    public static final CvValueExchange valueExchange = new CvValueExchange();

    public CvSDK()
    {
    }

    static void checkActivitiesDeclaration(Context context)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(com/apprupt/sdk/CvInterstitialActivity);
        arraylist.add(com/apprupt/sdk/CvOverlayActivity);
        arraylist.add(com/apprupt/sdk/CvExpandActivity);
        checkActivitiesDeclaration(context, ((List) (arraylist)));
    }

    static void checkActivitiesDeclaration(Context context, List list)
    {
        Object obj = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Class class1 = (Class)list.next();
            if (!checkIsActivityDeclared(context, class1))
            {
                ((List) (obj)).add(class1.getName());
            }
        } while (true);
        if (((List) (obj)).size() > 0)
        {
            list = new StringBuilder();
            context = "";
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                String s = (String)((Iterator) (obj)).next();
                list.append((new StringBuilder()).append(context).append(s).toString());
                context = ", ";
            }

            throw new InternalError((new StringBuilder()).append("Activities declaration missing in AndroidManifest.xml: ").append(list.toString()).toString());
        } else
        {
            return;
        }
    }

    private static boolean checkIsActivityDeclared(Context context, Class class1)
    {
        class1 = new Intent(context, class1);
        class1.addFlags(0x10000000);
        return context.getPackageManager().queryIntentActivities(class1, 0x10000).size() > 0;
    }

    public static void checkIsContentAvailableForInterstitial(Context context, int i)
    {
        checkIsContentAvailableForInterstitial(context, i, null, null, null);
    }

    public static void checkIsContentAvailableForInterstitial(Context context, int i, CvContentManager.PreloaderListener preloaderlistener)
    {
        checkIsContentAvailableForInterstitial(context, i, preloaderlistener, null, null);
    }

    public static void checkIsContentAvailableForInterstitial(Context context, int i, CvContentManager.PreloaderListener preloaderlistener, String s)
    {
        checkIsContentAvailableForInterstitial(context, i, preloaderlistener, s, null);
    }

    public static void checkIsContentAvailableForInterstitial(Context context, int i, CvContentManager.PreloaderListener preloaderlistener, String s, String s1)
    {
        contentManager.checkAdsAvailable(context, new CvContentOptions(i, s, s1, true, CvAdColony.wrapper().isActiveForSpace(i, true), true), preloaderlistener);
    }

    public static void checkIsContentAvailableForInterstitial(Context context, int i, String s)
    {
        checkIsContentAvailableForInterstitial(context, i, null, s, null);
    }

    public static void checkIsContentAvailableForInterstitial(Context context, int i, String s, String s1)
    {
        checkIsContentAvailableForInterstitial(context, i, null, s, s1);
    }

    public static void clearInterstitial()
    {
        CvInterstitialManager.getInstance().killInterstitial();
    }

    public static CvAnimationType getAnimationType()
    {
        return animation;
    }

    public static CvAudience getAudience()
    {
        return CvAudience.getInstance();
    }

    public static int getLogLevel()
    {
        return Logger.getLevel();
    }

    static String getPiKey()
    {
        if (piKey == null)
        {
            regeneratePiKey();
        }
        return piKey;
    }

    public static int getRefreshInterval()
    {
        return refreshInterval;
    }

    public static boolean getUseSecureConnections()
    {
        return CvUrl.getUseSecureConnections();
    }

    public static void initialize(Activity activity)
    {
        initializeInternal(activity);
    }

    static void initializeInternal(Context context)
    {
        boolean flag = true;
        com/apprupt/sdk/CvSDK;
        JVM INSTR monitorenter ;
        if (!initialized) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        com/apprupt/sdk/CvSDK;
        JVM INSTR monitorexit ;
        if (flag)
        {
            checkActivitiesDeclaration(context);
            CvAppInfo.initialize(context.getApplicationContext());
            CvViewHelper.init(context);
        }
        valueExchange.setContext(context);
        if (context instanceof Activity)
        {
            mediation.initialize((Activity)context);
            config.initialize(context);
        }
        return;
_L2:
        initialized = true;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        com/apprupt/sdk/CvSDK;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static boolean isContentLoadedForAdSpace(int i)
    {
        return true;
    }

    public static void onPause()
    {
        CvAdColony.onPause();
    }

    public static void onResume(Activity activity)
    {
        CvAdColony.onResume(activity);
    }

    public static void prefetchInterstitial(Context context, int i)
    {
        prefetchInterstitial(context, i, null, null, null);
    }

    public static void prefetchInterstitial(Context context, int i, CvContentManager.PreloaderListener preloaderlistener)
    {
        prefetchInterstitial(context, i, preloaderlistener, null, null);
    }

    public static void prefetchInterstitial(Context context, int i, CvContentManager.PreloaderListener preloaderlistener, String s)
    {
        prefetchInterstitial(context, i, preloaderlistener, s, null);
    }

    public static void prefetchInterstitial(Context context, int i, CvContentManager.PreloaderListener preloaderlistener, String s, String s1)
    {
        CvInterstitialManager.getInstance().fetchInterstitial(context, i, preloaderlistener, s, s1);
    }

    public static void prefetchInterstitial(Context context, int i, String s)
    {
        prefetchInterstitial(context, i, null, s, null);
    }

    public static void prefetchInterstitial(Context context, int i, String s, String s1)
    {
        prefetchInterstitial(context, i, null, s, s1);
    }

    public static void regeneratePiKey()
    {
        piKey = String.format(PI_KEY_FORMAT, new Object[] {
            Long.valueOf(System.currentTimeMillis()), CvRandomString.generate(8)
        });
        Logger.get().i(new Object[] {
            (new StringBuilder()).append("NEW PI KEY: ").append(piKey).toString()
        });
    }

    public static void setAlwaysStartVideoMuted(boolean flag)
    {
        if (!initialized)
        {
            throw new InternalError("Cannot set property in non-initialized environment");
        } else
        {
            CvAdColony.wrapper().setAlwaysStartMuted(flag);
            return;
        }
    }

    public static void setAnimationType(CvAnimationType cvanimationtype)
    {
        animation = cvanimationtype;
    }

    public static void setLogLevel(int i)
    {
        Logger.setLevel(i);
    }

    public static void setRefreshInterval(int i)
    {
        if (i <= 0 || i >= 10) goto _L2; else goto _L1
_L1:
        int j = 10;
_L4:
        refreshInterval = j;
        return;
_L2:
        j = i;
        if (i <= 0)
        {
            j = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void setUseSecureConnections(boolean flag)
    {
        CvUrl.setUseSecureConnections(flag);
    }

    public static void startInterstitial(Context context, int i)
    {
        CvInterstitialManager.getInstance().startInterstitial(context, i, null, "", "");
    }

    public static void startInterstitial(Context context, int i, CvInterstitialListener cvinterstitiallistener)
    {
        CvInterstitialManager.getInstance().startInterstitial(context, i, cvinterstitiallistener, "", "");
    }

    public static void startInterstitial(Context context, int i, CvInterstitialListener cvinterstitiallistener, String s)
    {
        CvInterstitialManager.getInstance().startInterstitial(context, i, cvinterstitiallistener, s, "");
    }

    public static void startInterstitial(Context context, int i, CvInterstitialListener cvinterstitiallistener, String s, String s1)
    {
        CvInterstitialManager.getInstance().startInterstitial(context, i, cvinterstitiallistener, s, s1);
    }

    public static void startInterstitial(Context context, int i, String s)
    {
        CvInterstitialManager.getInstance().startInterstitial(context, i, null, s, "");
    }

    public static void startInterstitial(Context context, int i, String s, String s1)
    {
        CvInterstitialManager.getInstance().startInterstitial(context, i, null, s, s1);
    }

    static 
    {
        animation = CvAnimationType.NONE;
    }
}
