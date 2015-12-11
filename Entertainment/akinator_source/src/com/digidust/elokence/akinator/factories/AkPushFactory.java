// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.digidust.elokence.akinator.activities.SplashscreenActivity;
import com.digidust.elokence.akinator.exceptions.AkException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplication, AkLog

public class AkPushFactory
{
    public static interface AkPushFactoryListener
    {

        public abstract void onPushRegistrationComplete();

        public abstract void onPushRegistrationFailed();
    }


    private static final String PROPERTY_APP_VERSION = "appVersion";
    public static final String PROPERTY_REG_ID = "registration_id";
    protected static final String TAG = "AkinatorPush";
    private static AkPushFactory instance;
    Context context;
    GoogleCloudMessaging gcm;
    AkPushFactoryListener lstn;
    AtomicInteger msgId;
    String regId;

    public AkPushFactory()
    {
        msgId = new AtomicInteger();
        context = AkApplication.getAppContext();
        lstn = null;
    }

    private boolean checkPlayServices(Context context1)
    {
        return GooglePlayServicesUtil.isGooglePlayServicesAvailable(context1) == 0;
    }

    private static int getAppVersion(Context context1)
    {
        int i;
        try
        {
            i = context1.getPackageManager().getPackageInfo(context1.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            throw new RuntimeException((new StringBuilder()).append("Could not get package name: ").append(context1).toString());
        }
        return i;
    }

    private SharedPreferences getGCMPreferences(Context context1)
    {
        return context1.getSharedPreferences(com/digidust/elokence/akinator/activities/SplashscreenActivity.getSimpleName(), 0);
    }

    public static AkPushFactory getInstance()
    {
        if (instance == null)
        {
            instance = new AkPushFactory();
        }
        return instance;
    }

    private void registerInBackground()
    {
        (new _cls1()).execute(new String[] {
            null, null, null
        });
    }

    private void storeRegistrationId(Context context1, String s)
    {
        SharedPreferences sharedpreferences = getGCMPreferences(context1);
        int i = getAppVersion(context1);
        Log.i("AkinatorPush", (new StringBuilder()).append("Saving regId on app version ").append(i).toString());
        context1 = sharedpreferences.edit();
        context1.putString("registration_id", s);
        context1.putInt("appVersion", i);
        context1.commit();
    }

    public boolean checkGCMStatus()
        throws AkException
    {
        AkLog.d("AkinatorPush", "checkGCMStatus");
        if (!checkPlayServices(context))
        {
            throw new AkException("GCM not available");
        }
        gcm = GoogleCloudMessaging.getInstance(context);
        regId = getRegistrationId(context);
        if (regId.isEmpty())
        {
            registerInBackground();
            return false;
        } else
        {
            return true;
        }
    }

    public String getRegistrationId(Context context1)
    {
        SharedPreferences sharedpreferences = getGCMPreferences(context1);
        String s = sharedpreferences.getString("registration_id", "");
        if (s.isEmpty())
        {
            Log.i("AkinatorPush", "Registration not found.");
            s = "";
        } else
        if (sharedpreferences.getInt("appVersion", 0x80000000) != getAppVersion(context1))
        {
            Log.i("AkinatorPush", "App version changed.");
            return "";
        }
        return s;
    }

    public void setListener(AkPushFactoryListener akpushfactorylistener)
    {
        AkLog.d("AkinatorPush", "SetListener");
        lstn = akpushfactorylistener;
    }


    /* member class not found */
    class _cls1 {}

}
