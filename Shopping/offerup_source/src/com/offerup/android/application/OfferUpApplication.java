// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.application;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.a.d;
import android.util.Log;
import c.a.a.a.e;
import c.a.a.a.n;
import com.apptentive.android.sdk.Apptentive;
import com.b.a.a.g;
import com.b.a.a.j;
import com.crashlytics.android.Crashlytics;
import com.facebook.FacebookSdk;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumPushService;
import com.leanplum.annotations.Parser;
import com.offerup.android.c.a;
import com.offerup.android.network.o;
import com.offerup.android.utils.as;
import com.offerup.android.utils.az;
import com.offerup.android.utils.b;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;

// Referenced classes of package com.offerup.android.application:
//            b, a

public class OfferUpApplication extends d
{

    private static final o b = new o();
    private j a;

    public OfferUpApplication()
    {
    }

    static void a(OfferUpApplication offerupapplication)
    {
        offerupapplication.a.H(a.itemDetailsLayout);
        offerupapplication.a.v(a.itemDetailUseNewScreen);
    }

    public void onCreate()
    {
        try
        {
            a = j.a(getApplicationContext());
            getApplicationContext();
            (new as(j.a(), getApplicationContext())).a();
            a.V();
        }
        catch (Exception exception)
        {
            g.a("OfferUpApplication", exception);
        }
        try
        {
            Leanplum.setApplicationContext(this);
            LeanplumActivityHelper.enableLifecycleCallbacks(this);
            Leanplum.setAppIdForProductionMode("app_nTWlpNo2XTrp326fb7zJXlQuGvlnAaGVHfEs66EKQb0", "prod_9lGavA94sd2blocOh8asmGjgaQRzvuuPapLZhEesDQs");
            LeanplumPushService.setGcmSenderId("195464008723");
            Leanplum.setDeviceId(com.offerup.android.utils.b.a(getApplicationContext()));
            LeanplumPushService.setCustomizer(new com.offerup.android.notifications.a(getApplicationContext()));
            Leanplum.addVariablesChangedHandler(new com.offerup.android.application.b(this));
            Parser.parseVariablesForClasses(new Class[] {
                com/offerup/android/c/a
            });
            Leanplum.start(this);
        }
        catch (Exception exception1)
        {
            g.a(this, exception1);
        }
        super.onCreate();
        try
        {
            android.support.v4.e.a.a(this);
        }
        catch (Exception exception2)
        {
            g.c("OfferUpApplication", Log.getStackTraceString(exception2));
        }
        try
        {
            e.a(this, new n[] {
                new Crashlytics()
            });
        }
        catch (Throwable throwable)
        {
            g.c("OfferUpApplication", Log.getStackTraceString(throwable));
        }
        try
        {
            PackageInfo packageinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            a.l(packageinfo.versionCode);
        }
        catch (Exception exception3)
        {
            g.a("OfferUpApplication", exception3);
        }
        try
        {
            o.a(getApplicationContext());
            o.a((new StringBuilder("https://offerupnow.com/")).append("api/v2").toString());
        }
        catch (Exception exception4)
        {
            g.a("OfferUpApplication", exception4);
        }
        try
        {
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        catch (Exception exception5)
        {
            g.a("OfferUpApplication", exception5);
        }
        try
        {
            az.a(getApplicationContext());
        }
        catch (Exception exception6)
        {
            g.a("OfferUpApplication", exception6);
        }
        try
        {
            AirshipConfigOptions airshipconfigoptions = AirshipConfigOptions.loadDefaultOptions(this);
            airshipconfigoptions.developmentAppKey = "Uwf2lngfQCWCSuxiSoV0jQ";
            airshipconfigoptions.developmentAppSecret = "PJy3A4whT-qgDYwxms6yzA";
            airshipconfigoptions.allowedTransports = (new String[] {
                "GCM"
            });
            airshipconfigoptions.gcmSender = "195464008723";
            airshipconfigoptions.minSdkVersion = 8;
            airshipconfigoptions.inProduction = true;
            airshipconfigoptions.analyticsEnabled = true;
            airshipconfigoptions.productionAppKey = "F7Enxke7RB6HkJ3ZxDj_eg";
            airshipconfigoptions.productionAppSecret = "15QNu0tMQZi6l2y29OK2VQ";
            UAirship.takeOff(this, airshipconfigoptions, new com.offerup.android.application.a(this));
        }
        catch (Throwable throwable1)
        {
            g.c("OfferUpApplication", Log.getStackTraceString(throwable1));
        }
        Apptentive.addCustomDeviceData(this, "device-token", com.offerup.android.utils.b.a(this));
    }

}
