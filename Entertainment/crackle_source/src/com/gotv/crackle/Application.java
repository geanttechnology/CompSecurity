// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.adobe.adms.measurement.ADMS_Measurement;
import com.comscore.analytics.comScore;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.helpers.MyCrackleViewHelper;
import com.gotv.crackle.util.ComscoreTracker;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.OmnitureWrapper;
import com.mobileapptracker.MobileAppTracker;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Date;

// Referenced classes of package com.gotv.crackle:
//            LoadingActivity, MainActivity

public class Application extends android.app.Application
{
    private class ScreenReceiver extends BroadcastReceiver
    {

        final Application this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
            {
                pauseLocaleCheck();
            } else
            if (intent.getAction().equals("android.intent.action.SCREEN_ON"))
            {
                resumeLocaleCheckWithDelay();
                return;
            }
        }

        private ScreenReceiver()
        {
            this$0 = Application.this;
            super();
        }

    }


    public static int APP_VERSION_CODE = 0;
    public static String APP_VERSION_NAME;
    private static final int LOCALE_CHECK = 0x1e217;
    private static final int LOCALE_CHECK_INTERVAL = 0x1b7740;
    public static String PACKAGE_NAME;
    private static final int SHORT_LOCALE_CHECK_INTERVAL = 0x1d4c0;
    private static final String SONY_P = "Sony Tablet P";
    public static boolean isNielsenOptOutShowing = false;
    public static Context mAppContext;
    private static Handler sHandler = new Handler() {

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 123415 123415: default 24
        //                       123415 30;
               goto _L1 _L2
_L1:
            super.handleMessage(message);
            return;
_L2:
            Application.getInstance().getLocalization().updateCurrentLocationAsync();
            Application.sTimeOfLastLocaleCheck = new Date();
            Message message1 = Message.obtain();
            message1.what = 0x1e217;
            Application.sHandler.sendMessageDelayed(message1, 0x1b7740L);
            if (true) goto _L1; else goto _L3
_L3:
        }

    };
    private static Application sInstance;
    private static Date sTimeOfLastLocaleCheck = new Date();
    public static int selectedTab = -1;
    private WeakReference mCurretBaseActivity;
    private boolean mIsNewInstance;
    private Localization mLocalization;
    private MobileAppTracker mMobileAppTracker;
    public OmnitureWrapper mOmnitureTracker;
    private BroadcastReceiver mReceiver;
    private Dialog mSignInDialog;
    private Typeface mTypeFace;
    private Typeface mTypeFaceLight;
    private String mVersion;

    public Application()
    {
        mLocalization = new Localization();
        mIsNewInstance = true;
    }

    public static int dpToPx(int i)
    {
        return (int)((float)i * mAppContext.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static Context getAppContext()
    {
        return mAppContext;
    }

    public static int getDisplayIndependantPixelSize(int i)
    {
        return (int)TypedValue.applyDimension(1, i, getInstance().getResources().getDisplayMetrics());
    }

    public static int getHeightFromAspectRatio(int i)
    {
        return (i * 277) / 185;
    }

    public static String getInstalledVersion()
    {
        String s;
        try
        {
            s = getInstance().getPackageManager().getPackageInfo(getInstance().getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            return "";
        }
        return s;
    }

    public static Application getInstance()
    {
        return sInstance;
    }

    public static int getScreenHeight()
    {
        return ((WindowManager)getInstance().getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int getScreenWidth()
    {
        return ((WindowManager)getInstance().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    private void initMobileAppTracker()
    {
        MobileAppTracker.init(this, "8696", "12f35680326fede605db9084a28b0b56");
        mMobileAppTracker = MobileAppTracker.getInstance();
        mMobileAppTracker.setDebugMode(false);
        ADMS_Measurement adms_measurement = ADMS_Measurement.sharedInstance(this);
        mMobileAppTracker.setUserId(adms_measurement.getVisitorID());
        (new Thread(new Runnable() {

            final Application this$0;

            public void run()
            {
                try
                {
                    com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(Application.this);
                    mMobileAppTracker.setGoogleAdvertisingId(info.getId(), info.isLimitAdTrackingEnabled());
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
                catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
                {
                    mMobileAppTracker.setAndroidId(android.provider.Settings.Secure.getString(getContentResolver(), "android_id"));
                }
                catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
                {
                    return;
                }
            }

            
            {
                this$0 = Application.this;
                super();
            }
        })).start();
    }

    public static boolean isAmazonFireTV()
    {
        return getInstance().getResources().getBoolean(0x7f060006);
    }

    public static boolean isDualScreenDevice()
    {
        return Build.MODEL.equalsIgnoreCase("Sony Tablet P");
    }

    public static boolean isFanhattan()
    {
        return Build.BRAND.equalsIgnoreCase("Fanhattan") && Build.MODEL.equalsIgnoreCase("F1201");
    }

    public static boolean isKindle()
    {
        return Build.MANUFACTURER.contains("Amazon") || Build.MANUFACTURER.contains("amazon");
    }

    public static boolean isKindle7()
    {
        return (Build.MANUFACTURER.contains("Amazon") || Build.MANUFACTURER.contains("amazon")) && Build.MODEL.equalsIgnoreCase("KFTT");
    }

    public static boolean isLeanBack()
    {
        if (isFanhattan() || isAmazonFireTV() || isOuya())
        {
            return true;
        } else
        {
            android.provider.Settings.Secure.getString(getInstance().getContentResolver(), "android_id");
            return false;
        }
    }

    public static boolean isNookTablet()
    {
        return Build.MODEL.equals("BNRV200") | Build.MODEL.equals("BNTV250") | Build.MODEL.equals("BNTV250A") | Build.MODEL.equals("BNTV600") | Build.MODEL.equals("BNTV400");
    }

    public static boolean isOuya()
    {
        return Build.MODEL.contains("OUYA");
    }

    public static SpannableStringBuilder setStringColor(String s, String s1)
    {
        ForegroundColorSpan foregroundcolorspan = new ForegroundColorSpan(Color.parseColor(mAppContext.getResources().getString(0x7f070023)));
        s = (new StringBuilder()).append(s).append(s1).toString();
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        spannablestringbuilder.setSpan(foregroundcolorspan, s.indexOf(s1), s.indexOf(s1) + s1.length(), 18);
        return spannablestringbuilder;
    }

    public void dismissSignIn()
    {
        if (mSignInDialog != null)
        {
            mSignInDialog.dismiss();
        }
    }

    public WeakReference getCurrentActivity()
    {
        return mCurretBaseActivity;
    }

    public MobileAppTracker getHasOffersTracking()
    {
        return mMobileAppTracker;
    }

    public Localization getLocalization()
    {
        return mLocalization;
    }

    public OmnitureWrapper getOmnitureTracker()
    {
        if (mOmnitureTracker == null)
        {
            if (getLocalization().isLatinAmericaUI())
            {
                mOmnitureTracker = new OmnitureWrapper("crackleprodlatam");
            } else
            {
                mOmnitureTracker = new OmnitureWrapper("crackleprod");
            }
        }
        return mOmnitureTracker;
    }

    public Typeface getTypeFace()
    {
        return mTypeFace;
    }

    public Typeface getTypeFaceLight()
    {
        return mTypeFaceLight;
    }

    public String getVersion()
    {
        return mVersion;
    }

    public boolean isLandscape()
    {
        return mAppContext.getResources().getConfiguration().orientation == 2;
    }

    public boolean isNewInstance()
    {
        boolean flag = mIsNewInstance;
        mIsNewInstance = false;
        return flag;
    }

    public boolean isTablet()
    {
        return (getResources().getConfiguration().screenLayout & 0xf) >= 3;
    }

    public boolean isTabletSizedScreen()
    {
        return (getResources().getConfiguration().screenLayout & 0xf) > 2;
    }

    public void onCreate()
    {
        super.onCreate();
        sInstance = this;
        mAppContext = getApplicationContext();
        Object obj;
        try
        {
            mVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            mVersion = "0.0.0";
        }
        mTypeFace = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Light.ttf");
        mTypeFaceLight = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Light.ttf");
        obj = StorageUtils.getCacheDirectory(this);
        obj = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(this)).threadPoolSize(5).threadPriority(4).denyCacheImageMultipleSizesInMemory().memoryCache(new UsingFreqLimitedMemoryCache(0x1e8480)).discCache(new UnlimitedDiscCache(((java.io.File) (obj)))).defaultDisplayImageOptions(DisplayImageOptions.createSimple()).build();
        ImageLoader.getInstance().init(((com.nostra13.universalimageloader.core.ImageLoaderConfiguration) (obj)));
        obj = Message.obtain();
        obj.what = 0x1e217;
        sHandler.sendMessageDelayed(((Message) (obj)), 0x1b7740L);
        obj = new IntentFilter("android.intent.action.SCREEN_ON");
        ((IntentFilter) (obj)).addAction("android.intent.action.SCREEN_OFF");
        mReceiver = new ScreenReceiver();
        registerReceiver(mReceiver, ((IntentFilter) (obj)));
        PACKAGE_NAME = getPackageName();
        obj = getPackageManager();
        try
        {
            obj = ((PackageManager) (obj)).getPackageInfo(PACKAGE_NAME, 0);
            APP_VERSION_NAME = ((PackageInfo) (obj)).versionName;
            APP_VERSION_CODE = ((PackageInfo) (obj)).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1) { }
        comScore.setAppContext(getApplicationContext());
        comScore.setCustomerC2("3000012");
        comScore.setPublisherSecret("d968fa0713453bb3551ca9544354c1dc");
        ComscoreTracker.initialize();
        initMobileAppTracker();
    }

    public void onLowMemory()
    {
        Log.d("ONLOWMEMORY!!", "ONLOWMEMORY!!!");
        super.onLowMemory();
    }

    public void pauseLocaleCheck()
    {
        sHandler.removeMessages(0x1e217);
    }

    public void restartApplication()
    {
        Intent intent = new Intent(this, com/gotv/crackle/LoadingActivity);
        intent.addFlags(0x4000000);
        intent.addFlags(0x10000000);
        startActivity(intent);
    }

    public void resumeLocaleCheckWithDelay()
    {
        Date date = new Date();
        Date date1 = new Date(sTimeOfLastLocaleCheck.getTime() + 0x1b7740L);
        if (date.after(date1))
        {
            Message message = Message.obtain();
            message.what = 0x1e217;
            sHandler.sendMessageDelayed(message, 0x1d4c0L);
            return;
        } else
        {
            long l = date1.getTime();
            long l1 = sTimeOfLastLocaleCheck.getTime();
            Message message1 = Message.obtain();
            message1.what = 0x1e217;
            sHandler.sendMessageDelayed(message1, l - l1);
            return;
        }
    }

    public void setCurrentActivity(WeakReference weakreference)
    {
        mCurretBaseActivity = weakreference;
    }

    public void showSignIn(BaseActivity baseactivity)
    {
        mSignInDialog = (new MyCrackleViewHelper()).showSignInDialog(baseactivity);
    }

    public void startHomeActivity(Context context)
    {
        context.startActivity(new Intent(context, com/gotv/crackle/MainActivity));
    }



/*
    static Date access$002(Date date)
    {
        sTimeOfLastLocaleCheck = date;
        return date;
    }

*/


}
