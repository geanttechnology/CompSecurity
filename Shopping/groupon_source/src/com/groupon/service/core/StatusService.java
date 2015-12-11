// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.cookies.CookieFactory;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.country.Country;
import com.groupon.models.status.Status;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.Dates;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.ObjectMapperWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service.core:
//            CoreService, AbTestService

public class StatusService extends CoreService
{

    private static final String ANDROID_CONSUMER = "android-consumer";
    private static final String ANDROID_CONSUMER_US = "android-consumer-us";
    private static final String EXPERIMENTS = "experiments";
    private static final String EXPERIMENT_APP = "experiment_app";
    private static final String PREF_KEY_STATUS_SERVICE = "StatusService";
    private static final String PREF_KEY_STATUS_SERVICE_TIMESTAMP = "StatusServiceTimestamp";
    private Lazy abTestService;
    private Application application;
    private Lazy cookieFactory;
    private Lazy currentCountryManager;
    private Lazy deviceInfoUtil;
    private DogfoodHelper dogfoodHelper;
    private Lazy loginService;
    private ObjectMapperWrapper objectMapper;
    protected SharedPreferences prefs;
    private Status status;
    ArraySharedPreferences statusServiceSharedPreferences;

    public StatusService()
    {
    }

    private void cacheToMemory()
    {
        String s;
        s = statusServiceSharedPreferences.getString("StatusService", null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        status = (Status)objectMapper.readValue(s, com/groupon/models/status/Status);
        return;
        Exception exception;
        exception;
        Ln.e(exception, (new StringBuilder()).append("Impossible to read status from preferences : ").append(s).toString(), new Object[0]);
        return;
    }

    private void init()
    {
        currentCountryManager = new Lazy(application) {

            final StatusService this$0;

            
            {
                this$0 = StatusService.this;
                super(context);
            }
        };
        loginService = new Lazy(application) {

            final StatusService this$0;

            
            {
                this$0 = StatusService.this;
                super(context);
            }
        };
        abTestService = new Lazy(application) {

            final StatusService this$0;

            
            {
                this$0 = StatusService.this;
                super(context);
            }
        };
        cookieFactory = new Lazy(application) {

            final StatusService this$0;

            
            {
                this$0 = StatusService.this;
                super(context);
            }
        };
        deviceInfoUtil = new Lazy(application) {

            final StatusService this$0;

            
            {
                this$0 = StatusService.this;
                super(context);
            }
        };
        cacheToMemory();
    }

    public Status getStatus()
    {
        return status;
    }

    public String getStatusUrl()
    {
        return (new StringBuilder()).append(prefs.getString("baseRapiUrl", application.getString(0x7f0804c6))).append("/status").toString();
    }

    public boolean isDownloadingDataFromNetwork()
    {
        return true;
    }

    public boolean isUpToDate()
    {
        return Dates.isToday(statusServiceSharedPreferences.getLong("StatusServiceTimestamp", 0L));
    }

    public void refresh()
        throws Exception
    {
        Object obj = (String)RoboGuice.getInjector(application).getInstance(Key.get(java/lang/String, Names.named("versionName")));
        String s = ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", s
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "experiments", Strings.toString(Boolean.valueOf(true))
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "version_number", obj
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "device_id", ((CookieFactory)cookieFactory.get()).getBrowserCookie()
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "experiment_app", String.format("%s-%s", new Object[] {
                "android-consumer", "15.9"
            })
        }));
        if (((LoginService)loginService.get()).isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "consumer_id", ((LoginService)loginService.get()).getConsumerId()
            }));
        }
        arraylist.addAll(Arrays.asList(new String[] {
            "client_version", "android-consumer-us"
        }));
        obj = new SyncHttp(application, com/groupon/models/status/Status, getStatusUrl(), arraylist.toArray());
        if (!((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible())
        {
            ((SyncHttp) (obj)).setAuthorizationRequired(false);
        }
        status = (Status)((SyncHttp) (obj)).call();
        obj = objectMapper.writeValueAsString(status);
        dogfoodHelper.logAbTests(((String) (obj)));
        statusServiceSharedPreferences.edit().putString("StatusService", ((String) (obj))).putLong("StatusServiceTimestamp", System.currentTimeMillis()).apply();
        obj = status.experiments;
        ((AbTestService)abTestService.get()).refresh(((java.util.List) (obj)));
    }

    public void resetToNotUpToDate()
    {
        statusServiceSharedPreferences.edit().remove("StatusServiceTimestamp").apply();
    }
}
