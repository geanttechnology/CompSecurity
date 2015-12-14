// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import android.app.Activity;
import android.text.TextUtils;
import com.millennialmedia.clientmediation.MediationAdapter;
import com.millennialmedia.internal.ActivityListenerManager;
import com.millennialmedia.internal.AdPlacementReporter;
import com.millennialmedia.internal.Handshake;
import com.millennialmedia.internal.adadapters.AdAdapter;
import com.millennialmedia.internal.adcontrollers.AdController;
import com.millennialmedia.internal.playlistserver.PlayListServer;
import com.millennialmedia.internal.playlistserver.PlayListServerAdapter;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.millennialmedia:
//            MMLog, AppInfo, TestInfo, UserData

public class MMSDK
{

    private static final String TAG = com/millennialmedia/MMSDK.getSimpleName();
    public static final String VERSION = "6.1.0-5323db4";
    private static AppInfo appInfo;
    public static boolean initialized = false;
    public static boolean locationEnabled = true;
    public static Map registeredPlugins = new HashMap();
    private static TestInfo testInfo;
    private static UserData userData;

    public MMSDK()
    {
    }

    public static AppInfo getAppInfo()
    {
        if (!initialized)
        {
            throw new IllegalStateException("Unable to get app info, SDK must be initialized first");
        } else
        {
            return appInfo;
        }
    }

    public static TestInfo getTestInfo()
    {
        if (!initialized)
        {
            throw new IllegalStateException("Unable to get test info, SDK must be initialized first");
        } else
        {
            return testInfo;
        }
    }

    public static UserData getUserData()
    {
        if (!initialized)
        {
            throw new IllegalStateException("Unable to get user data, SDK must be initialized first");
        } else
        {
            return userData;
        }
    }

    public static void initialize(Activity activity)
    {
        if (initialized)
        {
            MMLog.i(TAG, "Millennial Media SDK already initialized");
            return;
        }
        if (activity == null)
        {
            throw new IllegalArgumentException("Unable to initialize SDK, specified activity is null");
        } else
        {
            ThreadUtils.initialize();
            EnvironmentUtils.init(activity);
            Handshake.initialize();
            ActivityListenerManager.init();
            PlayListServerAdapter.registerPackagedAdapters();
            AdAdapter.registerPackagedAdapters();
            AdController.registerPackagedControllers();
            registerMediationAdapter("com.millennialmedia.clientmediation.AdMobMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.ConversentMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.InMobiMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.AdColonyMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.ChartboostMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.FacebookMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.MoPubMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.VungleMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.YahooMediationAdapter");
            registerMediationAdapter("com.millennialmedia.clientmediation.TapjoyMediationAdapter");
            Handshake.request(true);
            AdPlacementReporter.init();
            initialized = true;
            return;
        }
    }

    public static boolean isInitialized()
    {
        return initialized;
    }

    public static void registerAdAdapter(Class class1, Class class2, Class class3)
    {
        AdAdapter.registerAdapter(class1, class2, class3);
    }

    public static void registerAdController(AdController adcontroller)
    {
        AdController.registerController(adcontroller);
    }

    public static void registerMediatedAdAdapter(String s, Class class1, Class class2)
    {
        AdAdapter.registerMediatedAdapter(s, class1, class2);
    }

    private static void registerMediationAdapter(String s)
    {
        Class class1;
        class1 = Class.forName(s);
        if (!com/millennialmedia/clientmediation/MediationAdapter.isAssignableFrom(class1))
        {
            MMLog.e(TAG, "Unable to register mediation adapter, specified class is not an instance of MediationAdapter");
            return;
        }
        try
        {
            ((MediationAdapter)class1.newInstance()).register();
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Registering client mediation adapter: ").append(class1.getName()).toString());
                return;
            }
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("No class found for mediation adapter <").append(s).append(">").toString());
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Unable to create new instance of mediation adapter", s);
            }
        }
        return;
    }

    public static void registerPlayListServerAdapter(PlayListServerAdapter playlistserveradapter)
    {
        PlayListServerAdapter.registerAdapter(playlistserveradapter);
    }

    public static boolean registerPlugin(String s, String s1)
    {
        if (!initialized)
        {
            throw new IllegalStateException("Unable to register plugin, SDK must be initialized first");
        }
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            MMLog.e(TAG, "Unable to register plugin, neither id or version can be null or empty");
            return false;
        }
        registeredPlugins.put(s, s1);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Registered plugin with ID <").append(s).append("> and version <").append(s1).append(">").toString());
        }
        return true;
    }

    public static void setActiveAdServerAdapter(Class class1)
    {
        PlayListServer.setActivePlayListServerAdapter(class1);
    }

    public static void setAppInfo(AppInfo appinfo)
    {
        if (!initialized)
        {
            throw new IllegalStateException("Unable to set app info, SDK must be initialized first");
        } else
        {
            appInfo = appinfo;
            return;
        }
    }

    public static void setLocationEnabled(boolean flag)
    {
        if (!initialized)
        {
            throw new IllegalStateException("Unable to set location state, SDK must be initialized first");
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Setting location enabled: ").append(flag).toString());
        }
        locationEnabled = flag;
    }

    public static void setTestInfo(TestInfo testinfo)
    {
        if (!initialized)
        {
            throw new IllegalStateException("Unable to set test info, SDK must be initialized first");
        } else
        {
            testInfo = testinfo;
            return;
        }
    }

    public static void setUserData(UserData userdata)
    {
        if (!initialized)
        {
            throw new IllegalStateException("Unable to set user data, SDK must be initialized first");
        } else
        {
            userData = userdata;
            return;
        }
    }

}
