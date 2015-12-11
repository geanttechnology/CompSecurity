// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.BuildUtil;
import com.edisonwang.android.slog.SLog;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.service:
//            GCMNotificationService

public class GCMRegistrationService extends Service
{
    private class GCMRegisterTask extends AsyncTask
    {

        private long mUserId;
        final GCMRegistrationService this$0;

        private Context getContext()
        {
            return GCMRegistrationService.this;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (mGcm == null)
            {
                mGcm = GoogleCloudMessaging.getInstance(getContext());
            }
            try
            {
                SLog.dWithTag("GCMRegService", (new StringBuilder()).append("Registering with senderId=").append(mSenderId).toString());
                avoid = mGcm.register(new String[] {
                    mSenderId
                });
                SLog.d("GCM: Registration complete with regId={}", avoid);
                setRegistrationId(avoid);
                mAppController.sendGcmRegId(avoid, mUserId);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                SLog.dWithTag("GCMRegService", "Failed to register with GCM service.");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            stopService();
        }

        public GCMRegisterTask(long l)
        {
            this$0 = GCMRegistrationService.this;
            super();
            mUserId = l;
        }
    }

    private class GCMRegistrationListener extends AppSessionListener
    {

        final GCMRegistrationService this$0;

        public void onGcmRegistrationComplete(String s, int i, String s1, long l)
        {
            if (i == 200 && l > 0L)
            {
                SLog.dWithTag("GCMRegService", "GCM registration completed successfully; saving regId and stopping service now.");
                s = GCMRegistrationService.getGCMPreferences(GCMRegistrationService.this).edit();
                s.putBoolean("registrationIdSent", true);
                s.commit();
            }
            stopService();
        }

        private GCMRegistrationListener()
        {
            this$0 = GCMRegistrationService.this;
            super();
        }

    }

    private class GCMUnregisterTask extends AsyncTask
    {

        private String mRegId;
        private String mSessionKey;
        private long mUserId;
        final GCMRegistrationService this$0;

        private Context getContext()
        {
            return GCMRegistrationService.this;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (mGcm == null)
            {
                mGcm = GoogleCloudMessaging.getInstance(getContext());
            }
            SLog.dWithTag("GCMRegService", "Unregistering...");
            mAppController.clearGcmRegId(mRegId, mUserId, mSessionKey);
            GCMRegistrationService.getGCMPreferences(getContext()).edit().clear().commit();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            startService(GCMNotificationService.getClearNotificationIntent(getContext(), 1));
            startService(GCMNotificationService.getClearNotificationIntent(getContext(), 2));
            stopService();
        }

        public GCMUnregisterTask(String s, long l, String s1)
        {
            this$0 = GCMRegistrationService.this;
            super();
            mRegId = s;
            mUserId = l;
            mSessionKey = s1;
        }
    }


    public static final String ACTION_REGISTER = "co.vine.android.gcm.REGISTER";
    public static final String ACTION_UNREGISTER = "co.vine.android.gcm.UNREGISTER";
    public static final String PREFS = "gcmPrefs";
    public static final String PREF_APP_VERSION = "registrationVersion";
    public static final String PREF_REG_EXPIRY_TIME = "registrationExpiryTime";
    public static final String PREF_REG_ID = "registrationId";
    public static final String PREF_REG_ID_SENT = "registrationIdSent";
    public static final long REGISTRATION_EXPIRY_TIME_MS = 0x240c8400L;
    private static final String TAG = "GCMRegService";
    private static SharedPreferences sPrefs;
    private AppController mAppController;
    private GoogleCloudMessaging mGcm;
    private AppSessionListener mGcmRegistrationListener;
    private String mSenderId;
    private ArrayList mStartIds;

    public GCMRegistrationService()
    {
    }

    private int getAppVersion()
    {
        int i;
        try
        {
            i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return -1;
        }
        return i;
    }

    public static SharedPreferences getGCMPreferences(Context context)
    {
        if (sPrefs == null)
        {
            sPrefs = context.getSharedPreferences("gcmPrefs", 0);
        }
        return sPrefs;
    }

    public static Intent getRegisterIntent(Context context, long l)
    {
        context = new Intent(context, co/vine/android/service/GCMRegistrationService);
        context.setAction("co.vine.android.gcm.REGISTER");
        context.putExtra("user_id", l);
        return context;
    }

    private String getRegistrationId()
    {
        SharedPreferences sharedpreferences = getGCMPreferences(this);
        String s = sharedpreferences.getString("registrationId", null);
        if (s == null)
        {
            SLog.dWithTag("GCMRegService", "Registration not found.");
            s = null;
        } else
        if (sharedpreferences.getInt("registrationVersion", 0x80000000) != getAppVersion() || isRegistrationExpired())
        {
            SLog.dWithTag("GCMRegService", "App version changed or registration expired.");
            return null;
        }
        return s;
    }

    public static Intent getUnregisterIntent(Context context, long l, String s)
    {
        context = new Intent(context, co/vine/android/service/GCMRegistrationService);
        context.setAction("co.vine.android.gcm.UNREGISTER");
        context.putExtra("user_id", l);
        context.putExtra("s_key", s);
        return context;
    }

    private boolean isRegistrationExpired()
    {
        long l = getGCMPreferences(this).getLong("registrationExpiryTime", -1L);
        return System.currentTimeMillis() > l;
    }

    private void setRegistrationId(String s)
    {
        Object obj = getGCMPreferences(this);
        int i = getAppVersion();
        long l = System.currentTimeMillis();
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("registrationIdSent", false);
        ((android.content.SharedPreferences.Editor) (obj)).putInt("registrationVersion", i);
        ((android.content.SharedPreferences.Editor) (obj)).putLong("registrationExpiryTime", l + 0x240c8400L);
        ((android.content.SharedPreferences.Editor) (obj)).putString("registrationId", s);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
    }

    private void stopService()
    {
        int i;
        for (Iterator iterator = mStartIds.iterator(); iterator.hasNext(); stopSelf(i))
        {
            i = ((Integer)iterator.next()).intValue();
            SLog.dWithTag("GCMRegService", (new StringBuilder()).append("Stopping service for startId=").append(i).toString());
        }

    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        mGcm = GoogleCloudMessaging.getInstance(this);
        mAppController = AppController.getInstance(this);
        mGcmRegistrationListener = new GCMRegistrationListener();
        if (mGcmRegistrationListener != null)
        {
            mAppController.addListener(mGcmRegistrationListener);
        }
        mSenderId = BuildUtil.getSenderId(this);
        mStartIds = new ArrayList();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mGcmRegistrationListener != null)
        {
            mAppController.removeListener(mGcmRegistrationListener);
        }
        mGcm.close();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        SLog.dWithTag("GCMRegService", (new StringBuilder()).append("onStartCommand, startId=").append(j).append(", startIds=").append(mStartIds.toString()).toString());
        mStartIds.add(Integer.valueOf(j));
        if (intent == null)
        {
            return 2;
        }
        String s = getRegistrationId();
        SLog.dWithTag("GCMRegService", (new StringBuilder()).append("Starting GCM registration service with regId=").append(s).toString());
        long l = intent.getLongExtra("user_id", 0L);
        String s1 = intent.getAction();
        if ("co.vine.android.gcm.REGISTER".equals(s1))
        {
            if (s == null)
            {
                (new GCMRegisterTask(l)).execute(new Void[0]);
                return 2;
            }
            if (!getGCMPreferences(this).getBoolean("registrationIdSent", false))
            {
                mAppController.sendGcmRegId(s, l);
                return 2;
            } else
            {
                stopService();
                return 2;
            }
        }
        if ("co.vine.android.gcm.UNREGISTER".equals(s1))
        {
            (new GCMUnregisterTask(s, l, intent.getStringExtra("s_key"))).execute(new Void[0]);
            return 2;
        } else
        {
            stopService();
            return 2;
        }
    }



/*
    static GoogleCloudMessaging access$102(GCMRegistrationService gcmregistrationservice, GoogleCloudMessaging googlecloudmessaging)
    {
        gcmregistrationservice.mGcm = googlecloudmessaging;
        return googlecloudmessaging;
    }

*/




}
