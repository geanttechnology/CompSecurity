// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.AsyncTask;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.intentsoftware.addapptr.config.Config;
import com.intentsoftware.addapptr.config.ConfigDownloader;
import com.intentsoftware.addapptr.config.ConfigDownloaderListener;
import com.intentsoftware.addapptr.http.AdRequestParams;
import com.intentsoftware.addapptr.module.AppIDManager;
import com.intentsoftware.addapptr.module.GlobalPreferences;
import com.intentsoftware.addapptr.module.LocationUtils;
import com.intentsoftware.addapptr.module.Logger;
import com.intentsoftware.addapptr.module.NetworkUtils;
import com.intentsoftware.addapptr.module.ServerLogger;
import com.intentsoftware.addapptr.module.ShakeDetector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

// Referenced classes of package com.intentsoftware.addapptr:
//            PlacementListener, AdNetwork, SupportedNetworks, Session, 
//            SessionController, SessionReporter, StatisticsReporter, PromoController, 
//            ReporterAPI14, Reporter, Placement, AdConfig, 
//            PlacementConfig, PlacementSize, AdProvider, FullscreenPlacement, 
//            BannerPlacement

public class AdController
    implements PlacementListener
{

    private static final int MIN_ACCELEROMETER_RANGE = 19;
    private static String googleAdvertisingIdString;
    private static boolean limitAdTracking;
    private static Map options;
    private Sensor accelerometer;
    private Activity activity;
    private Application application;
    private ConfigDownloader configDownloader;
    private AlertDialog debugDialog;
    private boolean debugScreenEnabled;
    private AATKit.Delegate _flddelegate;
    private int indexOfPlacementPausedForAd;
    private boolean initialized;
    private Config lastDownloadedConfig;
    private List placements;
    private PromoController promoController;
    private Reporter reporter;
    private SensorManager sensorManager;
    private Session session;
    private ShakeDetector shakeDetector;
    private boolean shouldNotifyResume;
    private boolean showingDebugDialog;
    private int testId;

    AdController(Application application1, AATKit.Delegate delegate1, boolean flag)
    {
        shouldNotifyResume = false;
        debugScreenEnabled = false;
        application = application1;
        Logger.d("Init", getFullVersion());
        LocationUtils.init(application1);
        NetworkUtils.init(application1);
        GlobalPreferences.init(application1);
        ServerLogger.init(application1);
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(application1) != 0 || android.os.Build.VERSION.SDK_INT < 9)
        {
            SupportedNetworks.remove(AdNetwork.ADMOB);
            SupportedNetworks.remove(AdNetwork.ADX);
            SupportedNetworks.remove(AdNetwork.DFP);
            SupportedNetworks.remove(AdNetwork.PLAYHAVEN);
            SupportedNetworks.remove(AdNetwork.FACEBOOK);
        }
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            SupportedNetworks.remove(AdNetwork.LOOPME);
        }
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            SupportedNetworks.remove(AdNetwork.MILLENNIAL);
        }
        placements = new ArrayList();
        options = new HashMap();
        setOption("LOGCMD", "Yes");
        AdRequestParams.init(application1);
        AdRequestParams.setAppIds(AppIDManager.getAppIDs());
        session = new Session();
        SessionController sessioncontroller = new SessionController(session);
        SessionReporter sessionreporter = new SessionReporter();
        StatisticsReporter statisticsreporter = new StatisticsReporter();
        promoController = new PromoController(this);
        configDownloader = new ConfigDownloader(createConfigDownloaderListener());
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            reporter = new ReporterAPI14(application1, sessionreporter, statisticsreporter, sessioncontroller, session, placements);
        } else
        {
            reporter = new Reporter(sessionreporter, statisticsreporter, sessioncontroller, session, placements);
        }
        _flddelegate = delegate1;
        obtainEncryptedAdvertisingId(application1);
        if (flag)
        {
            enableDebugScreen();
        }
    }

    private void addConfigToAllPlacements(AdConfig adconfig)
    {
        Iterator iterator = placements.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Placement placement = (Placement)iterator.next();
            if (!placement.getName().equals("promo") && placement.acceptsGeneralRules && adconfig.getSupportedPlacementSizes().contains(placement.getSize()))
            {
                placement.addConfig(adconfig);
            }
        } while (true);
    }

    private ConfigDownloaderListener createConfigDownloaderListener()
    {
        return new _cls6();
    }

    private void distributeAdConfigWithSize(Config config)
    {
        config = config.getAdConfigs().iterator();
        do
        {
            if (!config.hasNext())
            {
                break;
            }
            AdConfig adconfig = (AdConfig)config.next();
            if (adconfig.getPlacementName() != null)
            {
                ArrayList arraylist = adconfig.getSupportedPlacementSizes();
                int i = findPlacementIdByName(adconfig.getPlacementName());
                if (i != -1)
                {
                    Placement placement = (Placement)placements.get(i);
                    if (arraylist.contains(placement.getSize()))
                    {
                        placement.addConfig(adconfig);
                    }
                }
            } else
            {
                addConfigToAllPlacements(adconfig);
            }
        } while (true);
    }

    private void distributePlacementConfig(Config config)
    {
        config = config.getPlacementConfigs().iterator();
        do
        {
            if (!config.hasNext())
            {
                break;
            }
            PlacementConfig placementconfig = (PlacementConfig)config.next();
            int i = findPlacementIdByName(placementconfig.getPlacementName());
            if (i != -1)
            {
                ((Placement)placements.get(i)).onConfigDownloaded(placementconfig);
            }
        } while (true);
    }

    public static String getFullVersion()
    {
        return "AATKitAnd_v2.15.8";
    }

    public static String getGoogleAdvertisingIdString()
    {
        return googleAdvertisingIdString;
    }

    public static Location getLocation()
    {
        return LocationUtils.getLocation();
    }

    public static String getOption(String s)
    {
        if (options == null)
        {
            return null;
        } else
        {
            return (String)options.get(s);
        }
    }

    public static String getVersion()
    {
        String as[] = "2.15.8".split("\\.");
        if (as[0].length() <= 1)
        {
            as[0] = (new StringBuilder()).append("0").append(as[0]).toString();
        }
        if (as[1].length() <= 1)
        {
            as[1] = (new StringBuilder()).append("0").append(as[1]).toString();
        }
        return (new StringBuilder()).append(as[0]).append(as[1]).toString();
    }

    private void handleActivityPause()
    {
        reporter.onPause(false);
        promoController.onActivityPause();
        configDownloader.stop();
        for (Iterator iterator = placements.iterator(); iterator.hasNext(); ((Placement)iterator.next()).onPause()) { }
        if (debugScreenEnabled && sensorManager != null)
        {
            sensorManager.unregisterListener(shakeDetector);
        }
        if (isOptionEnabled("TRIGSHUTDOWN"))
        {
            ServerLogger.writeLog("Shutdown");
        }
        if (debugDialog != null)
        {
            debugDialog.dismiss();
            debugDialog = null;
        }
    }

    private void handleActivityResume(Activity activity1)
    {
        promoController.onActivityResume();
        configDownloader.start();
        reporter.onResume(false);
        boolean flag1 = false;
        boolean flag = false;
        if (activity1 != null)
        {
            Iterator iterator = placements.iterator();
            do
            {
                flag1 = flag;
                if (!iterator.hasNext())
                {
                    break;
                }
                Placement placement = (Placement)iterator.next();
                if (shouldNotifyResume && placements.indexOf(placement) == indexOfPlacementPausedForAd && placement.getSize() == PlacementSize.Fullscreen && placement.getLoadedAdConfig() != null && placement.getLoadedAdConfig().getNetwork() == AdNetwork.OPENX)
                {
                    flag = true;
                } else
                {
                    placement.onResume(activity1);
                }
            } while (true);
        }
        if (_flddelegate != null && shouldNotifyResume && !flag1)
        {
            _flddelegate.aatkitResumeAfterAd(indexOfPlacementPausedForAd);
            shouldNotifyResume = false;
        }
        if (debugScreenEnabled && sensorManager != null)
        {
            sensorManager.registerListener(shakeDetector, accelerometer, 2);
        }
    }

    private void handleConfigDownload(Config config)
    {
        if (config.isGotAppId())
        {
            AppIDManager.setAppID(config.getAppID());
        }
        if (config.isGotIP())
        {
            AdRequestParams.setIP(config.getIPaddr());
        }
        options.putAll(config.getOptions());
        distributePlacementConfig(config);
        removeAllConfigsForAllPlacements();
        distributeAdConfigWithSize(config);
        for (config = placements.iterator(); config.hasNext(); ((Placement)config.next()).configsFinishedDownloading()) { }
        promoController.onConfigDownloaded();
    }

    public static boolean isLimitAdTracking()
    {
        return limitAdTracking;
    }

    public static boolean isOptionEnabled(String s)
    {
        s = getOption(s);
        return s != null && s.equals("Yes");
    }

    private void obtainEncryptedAdvertisingId(Context context)
    {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0)
        {
            (new _cls1(context)).execute(new Void[0]);
        } else
        {
            initialized = true;
            if (activity != null)
            {
                handleActivityResume(activity);
                return;
            }
        }
    }

    private boolean placementIdIsValid(int i)
    {
        boolean flag;
        if (i >= 0 && i <= placements.size())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && Logger.isLoggable(5))
        {
            Logger.w(this, (new StringBuilder()).append("Invalid placement id: ").append(i).toString());
        }
        return flag;
    }

    private void removeAllConfigsForAllPlacements()
    {
        for (Iterator iterator = placements.iterator(); iterator.hasNext(); ((Placement)iterator.next()).removeAllConfigs()) { }
    }

    private void showDebugDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        String s = "";
        if (testId != 0)
        {
            s = (new StringBuilder()).append("").append("Using test ID:").append(testId).append("\n\n").toString();
        }
        s = (new StringBuilder()).append(s).append("Currently loaded ads: \n").toString();
        Iterator iterator = placements.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Placement placement = (Placement)iterator.next();
            String s1;
            String s2;
            if (placement.getLoadedAdConfig() != null)
            {
                s1 = placement.getLoadedAdConfig().getNetwork().toString();
            } else
            {
                s1 = "None";
            }
            s2 = s1;
            if (placement.loader != null)
            {
                s2 = s1;
                if (placement.loader.isLoading())
                {
                    s2 = (new StringBuilder()).append(s1).append(", Loading new ad.").toString();
                }
            }
            s1 = (new StringBuilder()).append(s).append(placement.getName()).append(": ").append(s2).append("\n").toString();
            s = s1;
            if (placement.getSize() == PlacementSize.Fullscreen)
            {
                if (placement.getLastShownAdName() != null)
                {
                    s = placement.getLastShownAdName();
                } else
                {
                    s = "None";
                }
                s = (new StringBuilder()).append(s1).append("\t\t Last shown: ").append(s).append("\n").toString();
            }
        } while (true);
        builder.setMessage(s).setTitle(getFullVersion());
        builder.setNeutralButton("Close", new _cls3());
        debugDialog = builder.create();
        debugDialog.setCancelable(true);
        debugDialog.setOnCancelListener(new _cls4());
        showingDebugDialog = true;
        debugDialog.show();
    }

    public int createPlacement(String s, PlacementSize placementsize)
    {
        if (Logger.isLoggable(4))
        {
            Logger.i(this, (new StringBuilder()).append("Creating new placement with name: ").append(s).append(" and size: ").append(placementsize).toString());
        }
        for (Iterator iterator = placements.iterator(); iterator.hasNext();)
        {
            if (((Placement)iterator.next()).getName().equals(s))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Placement with name ").append(s).append(" already exists!").toString());
            }
        }

        if (placementsize == PlacementSize.Fullscreen)
        {
            placementsize = new FullscreenPlacement(s, placementsize, application);
        } else
        {
            placementsize = new BannerPlacement(s, placementsize, application);
        }
        placements.add(placementsize);
        placementsize.addListener(this);
        if (lastDownloadedConfig != null)
        {
            Iterator iterator1 = lastDownloadedConfig.getAdConfigs().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                AdConfig adconfig = (AdConfig)iterator1.next();
                ArrayList arraylist = adconfig.getSupportedPlacementSizes();
                if (adconfig.getPlacementName() != null && adconfig.getPlacementName().equals(s))
                {
                    if (arraylist.contains(placementsize.getSize()))
                    {
                        placementsize.addConfig(adconfig);
                    }
                } else
                if (arraylist.contains(placementsize.getSize()) && !placementsize.getName().equals("promo") && ((Placement) (placementsize)).acceptsGeneralRules)
                {
                    placementsize.addConfig(adconfig);
                }
            } while (true);
        }
        if (activity != null)
        {
            placementsize.onResume(activity);
        }
        return placements.size() - 1;
    }

    public void disableDebugScreen()
    {
        if (debugScreenEnabled)
        {
            sensorManager.unregisterListener(shakeDetector);
            debugScreenEnabled = false;
        }
    }

    public void disablePromo()
    {
        promoController.disablePromo();
    }

    public void enableDebugScreen()
    {
label0:
        {
            if (!debugScreenEnabled)
            {
                debugScreenEnabled = true;
                sensorManager = (SensorManager)application.getSystemService("sensor");
                accelerometer = sensorManager.getDefaultSensor(1);
                if (accelerometer != null && accelerometer.getMaximumRange() >= 19F)
                {
                    break label0;
                }
            }
            return;
        }
        shakeDetector = new ShakeDetector(accelerometer.getMaximumRange());
        shakeDetector.setOnShakeListener(new _cls2());
        sensorManager.registerListener(shakeDetector, accelerometer, 2);
    }

    public void enablePromo(boolean flag)
    {
        promoController.enablePromo(flag);
    }

    public void fallbackOnResumeFromAd(Placement placement)
    {
        if (activity != null)
        {
            placement.onResume(activity);
        }
        if (placement.isAutoreloaderActive())
        {
            placement.reloadInternal();
        }
        promoController.onActivityResume();
        if (_flddelegate != null && shouldNotifyResume)
        {
            _flddelegate.aatkitResumeAfterAd(indexOfPlacementPausedForAd);
            shouldNotifyResume = false;
        }
    }

    int findPlacementIdByName(String s)
    {
        byte byte0 = -1;
        ListIterator listiterator = placements.listIterator();
        int i;
        do
        {
            i = byte0;
            if (!listiterator.hasNext())
            {
                break;
            }
            i = listiterator.nextIndex();
        } while (!((Placement)listiterator.next()).getName().equals(s));
        return i;
    }

    public Activity getActivity()
    {
        return activity;
    }

    public ConfigDownloader getConfigDownloader()
    {
        return configDownloader;
    }

    public View getPlacementView(int i)
    {
        View view = null;
        if (placementIdIsValid(i))
        {
            view = ((Placement)placements.get(i)).getPlacementView();
        }
        return view;
    }

    List getPlacements()
    {
        return placements;
    }

    public Session getSession()
    {
        return session;
    }

    public int getTestAppId()
    {
        return AdRequestParams.getTestAppId();
    }

    public boolean hasAdForPlacement(int i)
    {
label0:
        {
            boolean flag = false;
            if (placementIdIsValid(i))
            {
                if (((Placement)placements.get(i)).getAd() == null)
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        return false;
    }

    public boolean isNetworkEnabled(AdNetwork adnetwork)
    {
        return SupportedNetworks.isNetworkEnabled(adnetwork);
    }

    public void onActivityPause(Activity activity1)
    {
        activity = null;
        if (initialized)
        {
            handleActivityPause();
        }
    }

    public void onActivityResume(Activity activity1)
    {
        activity = activity1;
        if (initialized)
        {
            handleActivityResume(activity1);
        }
        if (showingDebugDialog && activity1 != null && !activity1.isFinishing())
        {
            activity1.runOnUiThread(new _cls5());
        }
    }

    public void onEmptyAdShown(Placement placement)
    {
        if (Logger.isLoggable(4))
        {
            Logger.i(this, (new StringBuilder()).append("showing empty ad on placement: ").append(placement.getName()).toString());
        }
        if (_flddelegate != null)
        {
            _flddelegate.aatkitShowingEmpty(placements.indexOf(placement));
        }
    }

    public void onPauseForAd(Placement placement)
    {
        promoController.onAdShown();
        if (_flddelegate != null)
        {
            _flddelegate.aatkitPauseForAd(placements.indexOf(placement));
            indexOfPlacementPausedForAd = placements.indexOf(placement);
            shouldNotifyResume = true;
        }
    }

    public void onPlacementAdLoad(Placement placement)
    {
        if (_flddelegate != null)
        {
            _flddelegate.aatkitHaveAd(placements.indexOf(placement));
        }
        if (placement.getName().equals("promo"))
        {
            promoController.onAdLoaded();
        }
    }

    public void onPlacementAdLoadFail(Placement placement)
    {
        if (_flddelegate != null)
        {
            _flddelegate.aatkitNoAd(placements.indexOf(placement));
        }
    }

    public void onUserEarnedIncentive(Placement placement)
    {
        if (Logger.isLoggable(4))
        {
            Logger.i(this, (new StringBuilder()).append("Incentive earned for placement: ").append(placement.getName()).toString());
        }
        if (_flddelegate != null)
        {
            _flddelegate.aatkitUserEarnedIncentive(placements.indexOf(placement));
        }
    }

    public void preparePromo()
    {
        promoController.preparePromo();
    }

    public void reloadPlacement(int i)
    {
        if (Logger.isLoggable(4))
        {
            Logger.i(this, (new StringBuilder()).append("Reload placement id: ").append(i).toString());
        }
        if (placementIdIsValid(i))
        {
            ((Placement)placements.get(i)).reload();
        }
    }

    void setFakeAdResponse(String s)
    {
        configDownloader.setFakeAdResponse(s);
    }

    void setFakePackageName(String s)
    {
        AdRequestParams.setApp(s);
        AdRequestParams.setAppID(s);
    }

    public void setInitialRules(String s)
    {
        configDownloader.setInitialRules(s);
    }

    public void setNetworkEnabled(AdNetwork adnetwork, boolean flag)
    {
        SupportedNetworks.setNetworkEnabled(adnetwork, flag);
    }

    public void setOption(String s, String s1)
    {
        options.put(s, s1);
    }

    public void setPlacementAutoreloadInterval(int i, int j)
    {
        if (placementIdIsValid(i))
        {
            ((Placement)placements.get(i)).setPlacementAutoreloadInterval(j);
        }
    }

    public void setPlacementContentGravity(int i, int j)
    {
        if (placementIdIsValid(i))
        {
            ((Placement)placements.get(i)).setGravity(j);
        }
    }

    public void setPlacementDefaultImage(int i, Bitmap bitmap)
    {
        if (placementIdIsValid(i))
        {
            ((Placement)placements.get(i)).setDefaultImage(bitmap);
        }
    }

    public void setPlacementDefaultImageResource(int i, int j)
    {
        if (placementIdIsValid(i))
        {
            ((Placement)placements.get(i)).setDefaultImageResource(j);
        }
    }

    public void setPlacementSubID(int i, int j)
    {
        if (placementIdIsValid(i))
        {
            ((Placement)placements.get(i)).setSubID(j);
        }
    }

    public void setRuleCachingEnabled(boolean flag)
    {
        configDownloader.setRuleCachingEnabled(flag);
    }

    public void setTestAppId(int i)
    {
        testId = i;
        AdRequestParams.setTestAppId(i);
    }

    public boolean shouldLogAATKitCalls()
    {
        return isOptionEnabled("LOGCMD");
    }

    public boolean showPlacement(int i)
    {
        boolean flag;
        if (Logger.isLoggable(4))
        {
            Logger.i(this, (new StringBuilder()).append("Show placement id: ").append(i).toString());
        }
        if (!placementIdIsValid(i))
        {
            break MISSING_BLOCK_LABEL_159;
        }
        Placement placement = (Placement)placements.get(i);
        flag = placement.show();
        if (isOptionEnabled("LOGSHOW"))
        {
            ServerLogger.log((new StringBuilder()).append("Show called on placement:").append(placement.getName()).append(", size:").append(placement.getSize()).append(", success:").append(flag).toString());
        }
        if (flag || !isOptionEnabled("TRIGDISPLAYFAILED")) goto _L2; else goto _L1
_L1:
        ServerLogger.writeLog("displayFailed");
_L4:
        return flag;
_L2:
        if (!flag || !isOptionEnabled("TRIGSOMETHINGTOSHOW")) goto _L4; else goto _L3
_L3:
        ServerLogger.writeLog("successful call of \"show\"");
        return flag;
        return false;
    }

    public boolean showPromo(boolean flag)
    {
        return promoController.showPromo(flag);
    }

    public void startPlacementAutoReload(int i)
    {
        if (Logger.isLoggable(4))
        {
            Logger.i(this, (new StringBuilder()).append("Start placement id: ").append(i).append(" auto reload").toString());
        }
        if (placementIdIsValid(i))
        {
            ((Placement)placements.get(i)).startPlacementAutoReload();
        }
    }

    public void startPlacementAutoReload(int i, int j)
    {
        if (Logger.isLoggable(4))
        {
            Logger.i(this, (new StringBuilder()).append("Start placement id: ").append(i).append(" auto reload").toString());
        }
        if (placementIdIsValid(i))
        {
            Placement placement = (Placement)placements.get(i);
            placement.setPlacementAutoreloadInterval(j);
            placement.startPlacementAutoReload();
        }
    }

    public void stopPlacementAutoReload(int i)
    {
        if (Logger.isLoggable(4))
        {
            Logger.i(this, (new StringBuilder()).append("Stop placement id: ").append(i).append(" auto reload").toString());
        }
        if (placementIdIsValid(i))
        {
            ((Placement)placements.get(i)).stopPlacementAutoReload();
        }
    }



/*
    static String access$002(String s)
    {
        googleAdvertisingIdString = s;
        return s;
    }

*/



/*
    static boolean access$102(boolean flag)
    {
        limitAdTracking = flag;
        return flag;
    }

*/


/*
    static boolean access$202(AdController adcontroller, boolean flag)
    {
        adcontroller.initialized = flag;
        return flag;
    }

*/





/*
    static boolean access$502(AdController adcontroller, boolean flag)
    {
        adcontroller.showingDebugDialog = flag;
        return flag;
    }

*/



/*
    static AlertDialog access$702(AdController adcontroller, AlertDialog alertdialog)
    {
        adcontroller.debugDialog = alertdialog;
        return alertdialog;
    }

*/



/*
    static Config access$902(AdController adcontroller, Config config)
    {
        adcontroller.lastDownloadedConfig = config;
        return config;
    }

*/

    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls5 {}

}
