// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.view.View;
import com.intentsoftware.addapptr.module.ServerLogger;

// Referenced classes of package com.intentsoftware.addapptr:
//            AdController, PlacementSize, AdNetwork

public class AATKit
{
    public static interface Delegate
    {

        public abstract void aatkitHaveAd(int i);

        public abstract void aatkitNoAd(int i);

        public abstract void aatkitObtainedAdRules(boolean flag);

        public abstract void aatkitPauseForAd(int i);

        public abstract void aatkitResumeAfterAd(int i);

        public abstract void aatkitShowingEmpty(int i);

        public abstract void aatkitUnknownBundleId();

        public abstract void aatkitUserEarnedIncentive(int i);
    }


    public static final long BANNER_DEFAULT_RELOAD_INTERVAL_IN_SECONDS = 30L;
    public static final long BANNER_MAX_RELOAD_INTERVAL_IN_SECONDS = 600L;
    public static final long BANNER_MIN_RELOAD_INTERVAL_IN_SECONDS = 30L;
    private static AdController adController;

    public AATKit()
    {
    }

    public static int createPlacement(String s, PlacementSize placementsize)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: createPlacement(").append(s).append(",").append(placementsize).append(")").toString());
        }
        return adController.createPlacement(s, placementsize);
    }

    public static void disableDebugScreen()
    {
        adController.disableDebugScreen();
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log("CMD: disableDebugScreen()");
        }
    }

    public static void disablePromo()
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log("CMD: disablePromo()");
        }
        adController.disablePromo();
    }

    public static void enableDebugScreen()
    {
        adController.enableDebugScreen();
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log("CMD: enableDebugScreen()");
        }
    }

    public static void enablePromo()
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log("CMD: enablePromo()");
        }
        adController.enablePromo(false);
    }

    public static void enablePromo(boolean flag)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: enablePromo(").append(flag).append(")").toString());
        }
        adController.enablePromo(flag);
    }

    public static void enableTestMode(int i)
    {
        adController.setTestAppId(i);
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: enableTestMode(").append(i).append(")").toString());
        }
    }

    public static String getFullVersion()
    {
        if (adController != null && adController.shouldLogAATKitCalls())
        {
            ServerLogger.log("CMD: getFullVersion()");
        }
        return AdController.getFullVersion();
    }

    public static String getOption(String s)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: getOption(").append(s).append(")").toString());
        }
        return AdController.getOption(s);
    }

    public static View getPlacementView(int i)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: getPlacementView(").append(i).append(")").toString());
        }
        return adController.getPlacementView(i);
    }

    public static String getVersion()
    {
        if (adController != null && adController.shouldLogAATKitCalls())
        {
            ServerLogger.log("CMD: getVersion()");
        }
        return AdController.getVersion();
    }

    public static boolean hasAdForPlacement(int i)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: hasAdForPlacement(").append(i).append(")").toString());
        }
        return adController.hasAdForPlacement(i);
    }

    public static void init(Application application, Delegate delegate1)
    {
        if (adController == null)
        {
            adController = new AdController(application, delegate1, true);
            if (adController.shouldLogAATKitCalls())
            {
                ServerLogger.log((new StringBuilder()).append("CMD: init(").append(application).append(",").append(delegate1).append(")").toString());
            }
            return;
        } else
        {
            throw new RuntimeException("AdController is already initialized");
        }
    }

    public static void initWithoutDebugScreen(Application application, Delegate delegate1)
    {
        if (adController == null)
        {
            adController = new AdController(application, delegate1, false);
            if (adController.shouldLogAATKitCalls())
            {
                ServerLogger.log((new StringBuilder()).append("CMD: initWithoutDebugScreen(").append(application).append(",").append(delegate1).append(")").toString());
            }
            return;
        } else
        {
            throw new RuntimeException("AdController is already initialized");
        }
    }

    public static boolean isNetworkEnabled(AdNetwork adnetwork)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: isNetworkEnabled(").append(adnetwork).append(")").toString());
        }
        return adController.isNetworkEnabled(adnetwork);
    }

    public static boolean isOptionEnabled(String s)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: isOptionEnabled(").append(s).append(")").toString());
        }
        return AdController.isOptionEnabled(s);
    }

    public static void onActivityPause(Activity activity)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: onActivityPause(").append(activity).append(")").toString());
        }
        adController.onActivityPause(activity);
    }

    public static void onActivityResume(Activity activity)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: onActivityResume(").append(activity).append(")").toString());
        }
        adController.onActivityResume(activity);
    }

    public static void preparePromo()
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log("CMD: preparePromo()");
        }
        adController.preparePromo();
    }

    public static void reloadPlacement(int i)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: reloadPlacement(").append(i).append(")").toString());
        }
        adController.reloadPlacement(i);
    }

    public static void setInitialRules(String s)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setInitialRules(").append(s).append(")").toString());
        }
        adController.setInitialRules(s);
    }

    public static void setNetworkEnabled(AdNetwork adnetwork, boolean flag)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setNetworkEnabled(").append(adnetwork).append(",").append(flag).append(")").toString());
        }
        adController.setNetworkEnabled(adnetwork, flag);
    }

    public static void setOption(String s, String s1)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setOption(").append(s).append(",").append(s).append(")").toString());
        }
        adController.setOption(s, s1);
    }

    public static void setPlacementAutoreloadInterval(int i, int j)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setPlacementAutoreloadInterval(").append(i).append(",").append(j).append(")").toString());
        }
        adController.setPlacementAutoreloadInterval(i, j);
    }

    public static void setPlacementContentGravity(int i, int j)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setPlacementContentGravity(").append(i).append(",").append(j).append(")").toString());
        }
        adController.setPlacementContentGravity(i, j);
    }

    public static void setPlacementDefaultImageBitmap(int i, Bitmap bitmap)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setPlacementDefaultImageBitmap(").append(i).append(",").append(bitmap).append(")").toString());
        }
        adController.setPlacementDefaultImage(i, bitmap);
    }

    public static void setPlacementDefaultImageResource(int i, int j)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setPlacementDefaultImageResource(").append(i).append(",").append(j).append(")").toString());
        }
        adController.setPlacementDefaultImageResource(i, j);
    }

    public static void setPlacementSubID(int i, int j)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setPlacementSubID(").append(i).append(",").append(j).append(")").toString());
        }
        adController.setPlacementSubID(i, j);
    }

    public static void setRuleCachingEnabled(boolean flag)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: setRuleCachingEnabled(").append(flag).append(")").toString());
        }
        adController.setRuleCachingEnabled(flag);
    }

    public static boolean showPlacement(int i)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: showPlacement(").append(i).append(")").toString());
        }
        return adController.showPlacement(i);
    }

    public static boolean showPromo()
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log("CMD:showPromo()");
        }
        return adController.showPromo(true);
    }

    public static boolean showPromo(boolean flag)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD:showPromo(").append(flag).append(")").toString());
        }
        return adController.showPromo(flag);
    }

    public static void startPlacementAutoReload(int i)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: startPlacementAutoReload(").append(i).append(")").toString());
        }
        adController.startPlacementAutoReload(i);
    }

    public static void startPlacementAutoReload(int i, int j)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: startPlacementAutoReload(").append(i).append(",").append(j).append(")").toString());
        }
        adController.startPlacementAutoReload(i, j);
    }

    public static void stopPlacementAutoReload(int i)
    {
        if (adController.shouldLogAATKitCalls())
        {
            ServerLogger.log((new StringBuilder()).append("CMD: stopPlacementAutoReload(").append(i).append(")").toString());
        }
        adController.stopPlacementAutoReload(i);
    }
}
