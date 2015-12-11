// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.FontsOverride;
import com.mixerbox.mixerbox3b.classes.MyFbLoginButton;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import com.newrelic.agent.android.NewRelic;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MixerBox extends SherlockActivity
{

    private static final int Msg_What_Animation_finish = 1;
    static Bundle bundle;
    static int count;
    static Context ctx;
    static boolean loginFlag;
    static ArrayList mp3Artist;
    static ArrayList mp3ArtistId;
    String SENDER_ID;
    private com.facebook.Session.StatusCallback callback;
    GoogleCloudMessaging gcm;
    boolean internetConnectedShouldResume;
    public MyFbLoginButton loginButton;
    AtomicInteger msgId;
    String regid;
    private UiLifecycleHelper uiHelper;

    public MixerBox()
    {
        msgId = new AtomicInteger();
        SENDER_ID = "625063868019";
        callback = new _cls1();
    }

    private boolean checkPlayServices()
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (i != 0)
        {
            if (GooglePlayServicesUtil.isUserRecoverableError(i))
            {
                GooglePlayServicesUtil.getErrorDialog(i, this, 9000).show();
            } else
            {
                MixerBoxUtils.logMsg("This device is not supported.");
                finish();
            }
            return false;
        } else
        {
            return true;
        }
    }

    private static void getAllArtistsFromSDCard()
    {
        Cursor cursor1 = ctx.getContentResolver().query(android.provider.MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, new String[] {
            "artist"
        }, "artist != 0", null, null);
        Cursor cursor = cursor1;
        int j = cursor1.getCount();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        cursor = cursor1;
        cursor1.moveToFirst();
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        String s = cursor1.getString(0);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        cursor = cursor1;
        if (mp3Artist.contains(s.toLowerCase(Locale.ENGLISH)))
        {
            break MISSING_BLOCK_LABEL_115;
        }
        cursor = cursor1;
        if (s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        cursor = cursor1;
        mp3Artist.add(s.toLowerCase(Locale.ENGLISH));
        cursor = cursor1;
        cursor1.moveToNext();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        if (cursor1 != null)
        {
            cursor1.close();
        }
_L5:
        return;
        Exception exception1;
        exception1;
        cursor1 = null;
_L8:
        cursor = cursor1;
        MixerBoxUtils.logMsg(exception1.toString());
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        return;
        Exception exception;
        exception;
        cursor = null;
_L7:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L7; else goto _L6
_L6:
        exception1;
          goto _L8
    }

    private static int getAppVersion(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException((new StringBuilder()).append("Could not get package name: ").append(context).toString());
        }
        return i;
    }

    private String getRegistrationId(Context context)
    {
        String s = MixerBoxSharedPreferences.getGCMId(context);
        if (s.isEmpty())
        {
            MixerBoxUtils.logMsg("Registration not found.");
            s = "";
        } else
        if (MixerBoxSharedPreferences.getPreVersion(context) != getAppVersion(context))
        {
            MixerBoxUtils.logMsg("App version changed.");
            return "";
        }
        return s;
    }

    private void onSessionStateChange(Session session, SessionState sessionstate, Exception exception)
    {
        if (sessionstate.isOpened())
        {
            loginFlag = true;
        } else
        if (sessionstate.isClosed())
        {
            loginFlag = false;
            return;
        }
    }

    private void registerGCM()
    {
        if (checkPlayServices())
        {
            gcm = GoogleCloudMessaging.getInstance(this);
            regid = getRegistrationId(ctx);
            if (regid.isEmpty() || regid.equals("null"))
            {
                registerInBackground();
            }
            MixerBoxUtils.logMsg((new StringBuilder()).append("REGISTRATION ID = ").append(regid).toString());
            return;
        } else
        {
            MixerBoxUtils.logMsg("No valid Google Play Services APK found.");
            return;
        }
    }

    private void registerInBackground()
    {
        (new _cls3()).execute(new Void[] {
            null, null, null
        });
    }

    private boolean saveOldDB()
    {
        Object obj;
        Object obj1;
        obj = Environment.getExternalStorageDirectory();
        if (!((File) (obj)).canWrite())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj1 = getDatabasePath("mixerboxdb.db");
        if (!loginFlag) goto _L2; else goto _L1
_L1:
        obj = new File(((File) (obj)), "//Download/mixerbox3b1db.db");
_L4:
        if (((File) (obj1)).exists())
        {
            obj1 = (new FileInputStream(((File) (obj1)))).getChannel();
            obj = (new FileOutputStream(((File) (obj)))).getChannel();
            ((FileChannel) (obj)).transferFrom(((java.nio.channels.ReadableByteChannel) (obj1)), 0L, ((FileChannel) (obj1)).size());
            ((FileChannel) (obj1)).close();
            ((FileChannel) (obj)).close();
        }
        break MISSING_BLOCK_LABEL_115;
_L2:
        try
        {
            obj = new File(((File) (obj)), "//Download/mixerbox3b0db.db");
        }
        catch (Exception exception)
        {
            MixerBoxUtils.logMsg(exception.toString());
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return true;
    }

    public void cancelUpdate()
    {
        (new IndexHandler()).sendEmptyMessageDelayed(1, 1500L);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        uiHelper.onActivityResult(i, j, intent);
        Session.getActiveSession().onActivityResult(this, i, j, intent);
    }

    public void onCreate(Bundle bundle1)
    {
        int i;
        super.onCreate(bundle1);
        onNewIntent(getIntent());
        NewRelic.withApplicationToken("AA463c18e8944e0e51392d903bbca65776e17a2065").start(getApplication());
        setContentView(0x7f030041);
        getSupportActionBar().hide();
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(bundle1);
        loginButton = (MyFbLoginButton)findViewById(0x7f070090);
        loginButton.setReadPermissions(Arrays.asList(new String[] {
            "user_likes", "email", "read_stream"
        }));
        ctx = this;
        internetConnectedShouldResume = false;
        loginFlag = false;
        mp3Artist = new ArrayList();
        bundle1 = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f020071).showImageForEmptyUri(0x7f020071).showImageOnFail(0x7f020071).cacheOnDisc(true).build();
        bundle1 = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(getApplicationContext())).defaultDisplayImageOptions(bundle1).build();
        ImageLoader.getInstance().init(bundle1);
        registerGCM();
        FontsOverride.setDefaultFont(this, "DEFAULT", "font/Roboto-Light.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "font/Roboto-Light.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "font/Roboto-Light.ttf");
        i = MixerBoxSharedPreferences.getOpenTimeCount(this);
        count = i;
        if (i != -1) goto _L2; else goto _L1
_L1:
        bundle1 = getPackageManager().getInstalledApplications(128).iterator();
_L4:
        ApplicationInfo applicationinfo;
        int j;
        if (bundle1.hasNext())
        {
            applicationinfo = (ApplicationInfo)bundle1.next();
            if (applicationinfo.packageName.equals("com.mixerbox.mixerbox2"))
            {
                i = 1;
            } else
            {
                if (!applicationinfo.packageName.equals("com.mixerbox.mixerbox2b"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                i = 1;
            }
        } else
        {
            i = 0;
        }
_L5:
        if (i == 0)
        {
            i = (new Random()).nextInt(4) + 1;
            if (i == 1)
            {
                MixerBoxSharedPreferences.putShouldSendServerNotification(this, false);
            } else
            if (i == 2)
            {
                MixerBoxSharedPreferences.putShouldSendLocalNotification(this, false);
            } else
            if (i != 3 && i == 4)
            {
                MixerBoxSharedPreferences.putShouldSendLocalNotification(this, false);
                MixerBoxSharedPreferences.putShouldSendServerNotification(this, false);
            }
            MixerBoxSharedPreferences.putUserType(this, i);
        }
        MixerBoxSharedPreferences.putHasDayOne(this, false);
        MixerBoxSharedPreferences.putFirstLaunchTime(this, Calendar.getInstance().getTimeInMillis());
        if (MixerBoxClient.isConnectingToInternet(this))
        {
            MixerBoxClient.get("http://bit.ly/MB3bAndroidInstall", null, new AsyncHttpResponseHandler());
            MixerBoxClient.get("http://bit.ly/MBAndroidV307Launch", null, new AsyncHttpResponseHandler());
        }
        MixerBoxSharedPreferences.putOpenTimeCount(this, 1);
_L6:
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            MixerBoxSharedPreferences.putEnableBackgroundPlay(this, true);
        }
        i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        j = i;
        if (MixerBoxClient.MIXERBOX_URL_PARAMETER.contains("&appVer="))
        {
            break MISSING_BLOCK_LABEL_454;
        }
        MixerBoxClient.MIXERBOX_URL_PARAMETER = (new StringBuilder()).append(MixerBoxClient.MIXERBOX_URL_PARAMETER).append("&appVer=").append(i).toString();
        j = i;
_L7:
        bundle1 = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        MixerBoxSharedPreferences.putLocale(ctx, bundle1);
        MixerBoxClient.get(MixerBoxClient.getSysInfoUrl(Long.valueOf(MixerBoxSharedPreferences.getFirstLaunchTime(ctx)), bundle1), null, new _cls2(j));
        return;
        if (!applicationinfo.packageName.equals("com.mixerbox.mixerbox")) goto _L4; else goto _L3
_L3:
        i = 1;
          goto _L5
_L2:
        if (!MixerBoxSharedPreferences.getHasDayOne(this))
        {
            bundle1 = Long.valueOf(Calendar.getInstance().getTimeInMillis());
            Long long1 = Long.valueOf(MixerBoxSharedPreferences.getFirstLaunchTime(this));
            if (bundle1.longValue() - long1.longValue() >= 0x5265c00L && bundle1.longValue() - long1.longValue() <= 0xa4cb800L && MixerBoxClient.isConnectingToInternet(this))
            {
                MixerBoxSharedPreferences.putHasDayOne(this, true);
                MixerBoxClient.get("http://bit.ly/MBAndroidV307DayOne", null, new AsyncHttpResponseHandler());
                i = MixerBoxSharedPreferences.getUserType(this);
                if (i == 1)
                {
                    MixerBoxClient.get("http://bit.ly/androidv307_push_local", null, new AsyncHttpResponseHandler());
                } else
                if (i == 2)
                {
                    MixerBoxClient.get("http://bit.ly/androidv307_push_server", null, new AsyncHttpResponseHandler());
                } else
                if (i == 3)
                {
                    MixerBoxClient.get("http://bit.ly/androidv307_push_local_and_server", null, new AsyncHttpResponseHandler());
                } else
                if (i == 4)
                {
                    MixerBoxClient.get("http://bit.ly/androidv307_push_neither", null, new AsyncHttpResponseHandler());
                }
            }
        }
        MixerBoxSharedPreferences.putOpenTimeCount(this, count + 1);
          goto _L6
        bundle1;
        i = 999;
_L8:
        bundle1.printStackTrace();
        j = i;
          goto _L7
        bundle1;
          goto _L8
    }

    public void onDestroy()
    {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Bundle bundle1 = intent.getExtras();
        bundle = bundle1;
        if (bundle1 == null)
        {
            bundle = new Bundle();
        }
        if (intent.getData() != null)
        {
            bundle.putString("data", intent.getData().toString());
        }
    }

    public void onPause()
    {
        super.onPause();
        uiHelper.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Session session = Session.getActiveSession();
        if (session != null && (session.isOpened() || session.isClosed()))
        {
            onSessionStateChange(session, session.getState(), null);
        }
        uiHelper.onResume();
        checkPlayServices();
    }

    public void onSaveInstanceState(Bundle bundle1)
    {
        super.onSaveInstanceState(bundle1);
        uiHelper.onSaveInstanceState(bundle1);
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "Z8QPYZT3PBG8R6ZNSDXQ");
    }

    protected void onStop()
    {
        FlurryAgent.onEndSession(this);
        super.onStop();
    }




    private class _cls1
        implements com.facebook.Session.StatusCallback
    {

        final MixerBox this$0;

        public void call(Session session, SessionState sessionstate, Exception exception)
        {
            onSessionStateChange(session, sessionstate, exception);
        }

        _cls1()
        {
            this$0 = MixerBox.this;
            super();
        }
    }


    private class _cls3 extends AsyncTask
    {

        final MixerBox this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            try
            {
                if (gcm == null)
                {
                    gcm = GoogleCloudMessaging.getInstance(MixerBox.ctx);
                }
                regid = gcm.register(new String[] {
                    SENDER_ID
                });
                avoid = (new StringBuilder()).append("Device registered, registration ID=").append(regid).toString();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return (new StringBuilder()).append("Error :").append(avoid.getMessage()).toString();
            }
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
        }

        _cls3()
        {
            this$0 = MixerBox.this;
            super();
        }
    }


    private class IndexHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                break;
            }
            if (MixerBox.count < 0)
            {
                MixerBox.getAllArtistsFromSDCard();
                MixerBox.mp3ArtistId = new ArrayList();
                message = MixerBoxUtils.loadJSONFromAsset(MixerBox.ctx, "artists.json").toLowerCase(Locale.ENGLISH);
                for (int i = 0; i < MixerBox.mp3Artist.size(); i++)
                {
                    if (message.contains((CharSequence)MixerBox.mp3Artist.get(i)))
                    {
                        MixerBox.mp3ArtistId.add(MixerBox.mp3Artist.get(i));
                    }
                }

                if (MixerBox.bundle == null)
                {
                    MixerBox.bundle = new Bundle();
                }
                MixerBox.bundle.putStringArrayList("fav_artists", MixerBox.mp3ArtistId);
                message = new Intent(MixerBox.ctx, com/mixerbox/mixerbox3b/Onboarding);
                message.putExtras(MixerBox.bundle);
                MixerBox.ctx.startActivity(message);
                ((Activity)MixerBox.ctx).finish();
                return;
            }
            if (MixerBox.loginFlag)
            {
                if (MixerBox.bundle == null)
                {
                    MixerBox.bundle = new Bundle();
                }
                MixerBoxSharedPreferences.putFacebookToken(MixerBox.ctx, Session.getActiveSession().getAccessToken());
                MixerBoxUtils.toastMsg(MixerBox.ctx, MixerBox.ctx.getResources().getString(0x7f080074), 1);
                MixerBoxUtils.laterLoginInit(MixerBox.ctx, Session.getActiveSession(), MixerBox.bundle);
                return;
            }
            MixerBoxConstants.shouldOnCreate = true;
            if (MixerBox.bundle == null)
            {
                MixerBox.bundle = new Bundle();
            }
            MixerBox.bundle.putBoolean("isLogIn", false);
            message = new Intent();
            message.putExtras(MixerBox.bundle);
            message.setClass(MixerBox.ctx, com/mixerbox/mixerbox3b/MainPage);
            MixerBox.ctx.startActivity(message);
            ((Activity)MixerBox.ctx).finish();
        }

        IndexHandler()
        {
        }
    }


    private class _cls2 extends MixerBoxAsyncHttpResponseHandler
    {

        final MixerBox this$0;
        final int val$v;

        public void onFailure(Throwable throwable, String s)
        {
            (new IndexHandler()).sendEmptyMessageDelayed(1, 1500L);
        }

        public void onSuccess(String s)
        {
            if (s == null) goto _L2; else goto _L1
_L1:
            s = new JSONObject(s);
            if (s.isNull("sysinfo")) goto _L4; else goto _L3
_L3:
            JSONObject jsonobject;
            jsonobject = s.getJSONObject("sysinfo");
            if (jsonobject.has("packageName") && !jsonobject.isNull("packageName"))
            {
                MixerBoxSharedPreferences.putPackageName(MixerBox.this, jsonobject.getString("packageName"));
            }
            if (!jsonobject.has("lastVer") || jsonobject.isNull("lastVer")) goto _L6; else goto _L5
_L5:
            s = jsonobject.getString("lastVer");
_L13:
            String s1;
            String s2;
            s2 = "0";
            s1 = s2;
            if (!jsonobject.has("forceVer"))
            {
                break MISSING_BLOCK_LABEL_127;
            }
            s1 = s2;
            if (!jsonobject.isNull("forceVer"))
            {
                s1 = jsonobject.getString("forceVer");
            }
            if (!jsonobject.has("lastAd") || jsonobject.isNull("lastAd")) goto _L8; else goto _L7
_L7:
            String s3 = jsonobject.getJSONObject("lastAd").toString();
            MixerBoxSharedPreferences.putLastAd(MixerBox.this, s3);
_L11:
            if (jsonobject.isNull("faqUrl")) goto _L10; else goto _L9
_L9:
            MixerBoxSharedPreferences.putFAQUrl(MixerBox.this, jsonobject.getString("faqUrl"));
_L12:
            if (!jsonobject.isNull("showAd"))
            {
                MixerBoxSharedPreferences.putShouldShowAd(MixerBox.this, jsonobject.getBoolean("showAd"));
            }
            if (!jsonobject.isNull("soundcloudClientId"))
            {
                MixerBoxConstants.SOUNDCLOUD_ID = jsonobject.getString("soundcloudClientId");
            }
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_354;
            }
            if (v >= Integer.valueOf(s1).intValue())
            {
                break MISSING_BLOCK_LABEL_354;
            }
            if (!getPackageName().equals(MixerBoxSharedPreferences.getPackageName(MixerBox.this)) && !saveOldDB())
            {
                (new IndexHandler()).sendEmptyMessageDelayed(1, 1000L);
                return;
            }
            break MISSING_BLOCK_LABEL_343;
_L8:
            try
            {
                MixerBoxSharedPreferences.putLastAd(MixerBox.this, "");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                (new IndexHandler()).sendEmptyMessageDelayed(1, 1500L);
                return;
            }
              goto _L11
_L10:
            MixerBoxSharedPreferences.putFAQUrl(MixerBox.this, "");
              goto _L12
            AlertDialogFactory.ForceUpdateAlertDialog(MixerBox.this).show();
            return;
              goto _L11
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_383;
            }
            if (v < Integer.valueOf(s).intValue())
            {
                AlertDialogFactory.AskUpdateAlertDialog(MixerBox.this).show();
                return;
            }
            s = new IndexHandler();
            if (MixerBox.count < 0)
            {
                s.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            s.sendEmptyMessageDelayed(1, 1500L);
            return;
_L2:
            (new IndexHandler()).sendEmptyMessageDelayed(1, 1500L);
            return;
_L6:
            s = "0";
            if (true) goto _L13; else goto _L4
_L4:
        }

        _cls2(int i)
        {
            this$0 = MixerBox.this;
            v = i;
            super(final_context);
        }
    }

}
