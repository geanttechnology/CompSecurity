// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.alt;
import android.support.v7.alz;
import android.support.v7.amc;
import android.support.v7.amf;
import android.support.v7.amq;
import android.support.v7.amu;
import android.support.v7.amw;
import android.support.v7.ana;
import android.support.v7.aoi;
import android.support.v7.aot;
import android.support.v7.aoz;
import android.support.v7.apk;
import android.support.v7.apn;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.crashlytics.android.beta:
//            DeviceTokenLoader, BuildProperties, ActivityLifecycleCheckForUpdatesController, ImmediateCheckForUpdatesController, 
//            UpdatesController

public class Beta extends alz
    implements amu
{

    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String CRASHLYTICS_BUILD_PROPERTIES = "crashlytics-build.properties";
    static final String NO_DEVICE_TOKEN = "";
    public static final String TAG = "Beta";
    private final amf deviceTokenCache = new amf();
    private final DeviceTokenLoader deviceTokenLoader = new DeviceTokenLoader();
    private UpdatesController updatesController;

    public Beta()
    {
    }

    private String getBetaDeviceToken(Context context, String s)
    {
        if (isAppPossiblyInstalledByBeta(s, android.os.Build.VERSION.SDK_INT))
        {
            alt.h().a("Beta", "App was possibly installed by Beta. Getting device token");
            boolean flag;
            try
            {
                context = (String)deviceTokenCache.a(context, deviceTokenLoader);
                flag = "".equals(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                alt.h().e("Beta", "Failed to load the Beta device token", context);
                return null;
            }
            if (flag)
            {
                context = null;
            }
            return context;
        } else
        {
            alt.h().a("Beta", "App was not installed by Beta. Skipping device token");
            return null;
        }
    }

    private aoz getBetaSettingsData()
    {
        apn apn1 = apk.a().b();
        if (apn1 != null)
        {
            return apn1.f;
        } else
        {
            return null;
        }
    }

    public static Beta getInstance()
    {
        return (Beta)alt.a(com/crashlytics/android/beta/Beta);
    }

    private BuildProperties loadBuildProperties(Context context)
    {
        Object obj = context.getAssets().open("crashlytics-build.properties");
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object obj1 = obj;
        context = BuildProperties.fromPropertiesStream(((InputStream) (obj)));
        obj1 = obj;
        alt.h().a("Beta", (new StringBuilder()).append(((BuildProperties) (context)).packageName).append(" build properties: ").append(((BuildProperties) (context)).versionName).append(" (").append(((BuildProperties) (context)).versionCode).append(")").append(" - ").append(((BuildProperties) (context)).buildId).toString());
_L9:
        obj1 = context;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                alt.h().e("Beta", "Error closing Beta build properties asset", ((Throwable) (obj)));
                return context;
            }
            obj1 = context;
        }
_L4:
        return ((BuildProperties) (obj1));
        Exception exception;
        exception;
        obj = null;
        context = null;
_L7:
        obj1 = obj;
        alt.h().e("Beta", "Error reading Beta build properties", exception);
        obj1 = context;
        if (obj == null) goto _L4; else goto _L3
_L3:
        try
        {
            ((InputStream) (obj)).close();
        }
        catch (IOException ioexception)
        {
            alt.h().e("Beta", "Error closing Beta build properties asset", ioexception);
            return context;
        }
        return context;
        context;
        obj1 = null;
_L6:
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            catch (IOException ioexception1)
            {
                alt.h().e("Beta", "Error closing Beta build properties asset", ioexception1);
            }
        }
        throw context;
        context;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        context = null;
          goto _L7
        exception;
          goto _L7
_L2:
        context = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    boolean canCheckForUpdates(aoz aoz1, BuildProperties buildproperties)
    {
        return aoz1 != null && !TextUtils.isEmpty(aoz1.a) && buildproperties != null;
    }

    UpdatesController createUpdatesController(int i, Application application)
    {
        if (i >= 14)
        {
            return new ActivityLifecycleCheckForUpdatesController(getFabric().e(), getFabric().f());
        } else
        {
            return new ImmediateCheckForUpdatesController();
        }
    }

    protected Boolean doInBackground()
    {
        alt.h().a("Beta", "Beta kit initializing...");
        Context context = getContext();
        amw amw1 = getIdManager();
        if (TextUtils.isEmpty(getBetaDeviceToken(context, amw1.h())))
        {
            alt.h().a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        alt.h().a("Beta", "Beta device token is present, checking for app updates.");
        aoz aoz1 = getBetaSettingsData();
        BuildProperties buildproperties = loadBuildProperties(context);
        if (canCheckForUpdates(aoz1, buildproperties))
        {
            updatesController.initialize(context, this, amw1, aoz1, buildproperties, new aot(this), new ana(), new aoi(alt.h()));
        }
        return Boolean.valueOf(true);
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    public Map getDeviceIdentifiers()
    {
        String s = getIdManager().h();
        s = getBetaDeviceToken(getContext(), s);
        HashMap hashmap = new HashMap();
        if (!TextUtils.isEmpty(s))
        {
            hashmap.put(android.support.v7.amw.a.c, s);
        }
        return hashmap;
    }

    public String getIdentifier()
    {
        return "com.crashlytics.sdk.android:beta";
    }

    String getOverridenSpiEndpoint()
    {
        return amq.b(getContext(), "com.crashlytics.ApiEndpoint");
    }

    public String getVersion()
    {
        return "1.1.3.61";
    }

    boolean isAppPossiblyInstalledByBeta(String s, int i)
    {
        if (i < 11)
        {
            return s == null;
        } else
        {
            return "io.crash.air".equals(s);
        }
    }

    protected boolean onPreExecute()
    {
        Application application = (Application)getContext().getApplicationContext();
        updatesController = createUpdatesController(android.os.Build.VERSION.SDK_INT, application);
        return true;
    }
}
