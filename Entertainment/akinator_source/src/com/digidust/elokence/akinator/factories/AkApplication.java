// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.support.multidex.MultiDex;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.FacebookSdk;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplicationProcessing, AkLog, AkConfigFactory

public class AkApplication extends Application
{

    public static GoogleAnalytics analytics;
    private static Context context;
    private static String mFontName = "cheboyga";
    private static float mPoliceCoeff = 1.0F;
    private static Typeface tf;
    public static Tracker tracker;

    public AkApplication()
    {
    }

    public static Context getAppContext()
    {
        return context;
    }

    public static float getCoeffFont()
    {
        return mPoliceCoeff;
    }

    public static Typeface getTypeFace()
    {
        return tf;
    }

    public static void setCoeffFont(float f)
    {
        mPoliceCoeff = f;
    }

    protected void attachBaseContext(Context context1)
    {
        super.attachBaseContext(context1);
        MultiDex.install(this);
    }

    public void onCreate()
    {
        super.onCreate();
        AkApplicationProcessing.getInstance().setApplication(this);
        AkLog.d("Akinator", "AkApplication Create");
        context = getApplicationContext();
        analytics = GoogleAnalytics.getInstance(this);
        analytics.setLocalDispatchPeriod(1800);
        analytics.getLogger().setLogLevel(0);
        tracker = analytics.newTracker(AkConfigFactory.sharedInstance().getGoogleAnalyticsId());
        tracker.enableExceptionReporting(false);
        tracker.enableAdvertisingIdCollection(true);
        tracker.enableAutoActivityTracking(true);
        tracker.setSampleRate(10D);
        SessionFactory.sharedInstance().init(getApplicationContext());
        TraductionFactory.sharedInstance().init(getApplicationContext());
        MinibaseFactory.sharedInstance().init(getApplicationContext());
        MetricsSetAdapter.sharedInstance().init(getApplicationContext());
        (new Thread() {

            final AkApplication this$0;

            public void run()
            {
                AkApplication.tf = Typeface.createFromAsset(getAssets(), (new StringBuilder()).append("fonts/").append(AkApplication.mFontName).append(".ttf").toString());
                try
                {
                    Class.forName("android.os.AsyncTask");
                }
                catch (ClassNotFoundException classnotfoundexception) { }
                FacebookSdk.sdkInitialize(getApplicationContext());
            }

            
            {
                this$0 = AkApplication.this;
                super();
            }
        }).start();
        AkApplicationProcessing.getInstance().processOnApplicationCreate();
    }



/*
    static Typeface access$002(Typeface typeface)
    {
        tf = typeface;
        return typeface;
    }

*/

}
