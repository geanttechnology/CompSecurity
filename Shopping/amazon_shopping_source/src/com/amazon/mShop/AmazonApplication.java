// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import amazon.android.dexload.SupplementalDexLoader;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.webkit.WebView;
import com.amazon.client.metrics.NullMetricsFactory;
import com.amazon.device.crashmanager.CrashDetectionHelper;
import com.amazon.device.crashmanager.rtla.RtlaCrashDetailsCollectable;
import com.amazon.identity.auth.device.api.MAPInit;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.clouddrive.CloudDriveAvailability;
import com.amazon.mShop.clouddrive.CloudDriveManageStorageActivity;
import com.amazon.mShop.clouddrive.CloudDriveUploadActivity;
import com.amazon.mShop.crash.AmazonCrashHandler;
import com.amazon.mShop.crash.CrashDetailsCollector;
import com.amazon.mShop.crash.EmptyOAuthHelper;
import com.amazon.mShop.crash.ProdDomainChooser;
import com.amazon.mShop.crash.RtlaCrashDetailsProvider;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.debug.UncaughtExceptionHandler;
import com.amazon.mShop.gno.GNOMenuItemController;
import com.amazon.mShop.mash.MShopMASHApplication;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.FeatureUtil;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mShop.voice.VoiceSearchInitializer;
import com.amazon.mShop.wearable.WearableCrashDetails;
import com.amazon.mobile.mash.MASHApplicationFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.mShop:
//            DCMInitializer, AppExtensionsInitializer

public class AmazonApplication extends Application
{
    private static class AIVUserListener
        implements UserListener
    {

        private void forceRefreshAccount()
        {
            AmazonInstantVideoProxy.getInstance().forceRefreshAccount();
        }

        public void userSignedIn(User user)
        {
            forceRefreshAccount();
        }

        public void userSignedOut()
        {
            forceRefreshAccount();
        }

        public void userUpdated(User user)
        {
        }

        private AIVUserListener()
        {
        }

    }

    private static class CloudDriveInitializationRunnable
        implements Runnable
    {

        private final Context mContext;

        public void run()
        {
            boolean flag = false;
            Class class1 = Class.forName("com.amazon.clouddrive.library.CloudDriveLibrary", true, SecondDexEntry.getInstance().getClassLoader());
            Object obj = class1.getDeclaredMethod("getInstance", (Class[])null).invoke(null, (Object[])null);
            class1.getDeclaredMethod("initialize", new Class[] {
                android/content/Context, java/lang/Class, java/lang/Class
            }).invoke(obj, new Object[] {
                mContext, com/amazon/mShop/clouddrive/CloudDriveUploadActivity, com/amazon/mShop/clouddrive/CloudDriveManageStorageActivity
            });
            User.addUserListener(AmazonApplication.mCloudDriveListener);
            flag = true;
_L2:
            CloudDriveAvailability.getInstance().setCloudDriveInitialized(flag);
            return;
            Exception exception;
            exception;
            Log.e("AmazonApplication", "Cloud Drive Photos initialization failed.", exception);
            if (true) goto _L2; else goto _L1
_L1:
        }

        private CloudDriveInitializationRunnable(Context context)
        {
            mContext = context;
        }

    }

    private static class DexLoadJob
        implements Runnable
    {

        private CountDownLatch mAppStoreLoadingLatch;
        private Context mContext;
        private List mCriticalJars;

        public void run()
        {
            SupplementalDexLoader supplementaldexloader = SupplementalDexLoader.getInstance();
            supplementaldexloader.updateClassLoader(mContext, amazon.android.dexload.SupplementalDexLoader.MultiThreaded.YES, mCriticalJars);
            mAppStoreLoadingLatch.countDown();
_L1:
            Exception exception;
            Exception exception2;
            try
            {
                supplementaldexloader.updateClassLoader(mContext, amazon.android.dexload.SupplementalDexLoader.MultiThreaded.YES);
                return;
            }
            catch (Exception exception1)
            {
                Log.e("AmazonApplication", "Dex loading fails, restart app and skip loading ", exception1);
            }
            break MISSING_BLOCK_LABEL_78;
            exception2;
            Log.e("AmazonApplication", "Dex loading fails, restart app and skip loading ", exception2);
            mAppStoreLoadingLatch.countDown();
              goto _L1
            exception;
            mAppStoreLoadingLatch.countDown();
            throw exception;
        }

        public DexLoadJob(Context context, List list, CountDownLatch countdownlatch)
        {
            mContext = context;
            mCriticalJars = list;
            mAppStoreLoadingLatch = countdownlatch;
        }
    }


    private static final UserListener AIV_USER_LISTENER = new AIVUserListener();
    private static UserListener mCloudDriveListener = new UserListener() {

        public void userSignedIn(User user)
        {
            AmazonApplication.updateCloudDriveSignInStatus(true);
        }

        public void userSignedOut()
        {
            AmazonApplication.updateCloudDriveSignInStatus(false);
        }

        public void userUpdated(User user)
        {
        }

    };
    private static Locale sDeviceLocaleOnAppCreate = Locale.getDefault();
    private static boolean sWebViewCacheEmpty = false;
    private final List mCriticalJarList = new LinkedList(Arrays.asList(new String[] {
        "appstore.jar"
    }));
    private final SupplementalDexLoader mSupplementalDexLoader = SupplementalDexLoader.getInstance();

    public AmazonApplication()
    {
    }

    public static Locale getDeviceLocaleOnAppCreate()
    {
        return sDeviceLocaleOnAppCreate;
    }

    private void initializeAppStore(CountDownLatch countdownlatch, CrashDetectionHelper crashdetectionhelper)
    {
        try
        {
            countdownlatch.await();
            initializeApplication(new String[] {
                "com.amazon.venezia.Application"
            });
            AppstoreUtils.setAppstoreInitialized();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CountDownLatch countdownlatch)
        {
            com.amazon.mShop.util.DebugUtil.Log.e("AmazonApplication", "The appstore initialization failed", countdownlatch);
        }
    }

    private transient void initializeApplication(String as[])
        throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            Application application = (Application)mSupplementalDexLoader.loadClass(s, false).getConstructor(new Class[0]).newInstance(new Object[0]);
            Method method = android/app/Application.getDeclaredMethod("attach", new Class[] {
                android/content/Context
            });
            method.setAccessible(true);
            method.invoke(application, new Object[] {
                getBaseContext()
            });
            application.onCreate();
            Log.i("AmazonApplication", (new StringBuilder()).append("Created Application object: ").append(s).toString());
        }

    }

    private void initializeCloudDrive()
    {
        (new Thread(new CloudDriveInitializationRunnable(getApplicationContext()))).start();
    }

    private void initializeDex(List list, CountDownLatch countdownlatch)
    {
        (new Thread(new DexLoadJob(this, list, countdownlatch), "DexLoading")).start();
    }

    public static boolean isWebViewCacheEmpty()
    {
        return sWebViewCacheEmpty;
    }

    private void setConfigCallbackForViewRoot()
    {
        Class class1;
        try
        {
            class1 = Class.forName("android.view.ViewRoot");
        }
        catch (Exception exception)
        {
            Log.v("AmazonApplication", (new StringBuilder()).append("Unable to execute setConfigCallbackForViewRoot on Android Platform").append(android.os.Build.VERSION.RELEASE).toString());
            return;
        }
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        class1.getMethod("addConfigCallback", new Class[] {
            android/content/ComponentCallbacks
        }).invoke(null, new Object[] {
            new ComponentCallbacks() {

                final AmazonApplication this$0;

                public void onConfigurationChanged(Configuration configuration)
                {
                    LocaleUtils.ensureConfigLocale(configuration);
                    LocaleUtils.ensureAppLocale(AmazonApplication.this);
                }

                public void onLowMemory()
                {
                }

            
            {
                this$0 = AmazonApplication.this;
                super();
            }
            }
        });
    }

    public static void setUp(Context context)
    {
        DebugSettings.setDebugEnabled(context);
        setWebviewDebugging(DebugSettings.isDebugEnabled());
        AndroidPlatform.setUp(context, "Amazon.com");
        CookieBridge.init(context.getApplicationContext());
    }

    private void setWebViewCacheEmptyFlag(Context context)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 16)
        {
            sWebViewCacheEmpty = false;
            return;
        }
        context = context.getApplicationContext().openOrCreateDatabase("webviewCache.db", 0, null);
        if (context != null)
        {
            try
            {
                sWebViewCacheEmpty = false;
                context.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.v("AmazonApplication", (new StringBuilder()).append("WebView is probably corrupted: ").append(context.getMessage()).toString());
            }
        }
        sWebViewCacheEmpty = true;
        return;
    }

    private static void setWebviewDebugging(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19 && flag)
        {
            WebView.setWebContentsDebuggingEnabled(true);
            Log.i("AmazonApplication", "Enabled webview debugging");
        }
    }

    private static void updateCloudDriveSignInStatus(boolean flag)
    {
        Class class1;
        Object obj;
        class1 = SecondDexEntry.getInstance().getClassLoader().loadClass("com.amazon.clouddrive.library.CloudDriveLibrary");
        obj = class1.getDeclaredMethod("getInstance", (Class[])null).invoke(null, (Object[])null);
        String s;
        if (flag)
        {
            s = "signIn";
        } else
        {
            s = "signOut";
        }
        try
        {
            class1.getDeclaredMethod(s, (Class[])null).invoke(obj, (Object[])null);
            return;
        }
        catch (Exception exception)
        {
            Log.e("AmazonApplication", "Cloud Drive sign in failed.", exception);
        }
        return;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        LocaleUtils.ensureConfigLocale(configuration);
        super.onConfigurationChanged(configuration);
        LocaleUtils.ensureAppLocale(this);
    }

    public void onCreate()
    {
        setUp(this);
        CountDownLatch countdownlatch = new CountDownLatch(1);
        initializeDex(mCriticalJarList, countdownlatch);
        MASHApplicationFactory.setInstance(new MShopMASHApplication());
        FeatureUtil.loadFromRawFile(this);
        if (DebugSettings.isDebugEnabled())
        {
            Thread.setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler.getInstance());
        }
        DCMInitializer.initialize(this, "A1MPSLFC7L5AFK");
        MAPInit.getInstance(this).initialize();
        setConfigCallbackForViewRoot();
        super.onCreate();
        CrashDetectionHelper.setUpCrashDetection("A1MPSLFC7L5AFK", AndroidPlatform.getInstance().getDeviceId(), new EmptyOAuthHelper(), new NullMetricsFactory(), new ProdDomainChooser(), getApplicationContext(), true);
        CrashDetectionHelper crashdetectionhelper = CrashDetectionHelper.getInstance();
        if (crashdetectionhelper != null)
        {
            crashdetectionhelper.appendCrashDetailsCollector(WearableCrashDetails.getInstance());
            crashdetectionhelper.appendCrashDetailsCollector(new RtlaCrashDetailsCollectable(new RtlaCrashDetailsProvider()));
            crashdetectionhelper.appendCrashDetailsCollector(new CrashDetailsCollector(getApplicationContext()));
        }
        ConfigUtils.injectDefaultDebugSettings(this);
        AmazonCrashHandler.getInstance().setupCrashHandler();
        setWebViewCacheEmptyFlag(this);
        LocaleUtils.ensureAppLocale(this);
        GNOMenuItemController.init(this);
        SecondDexEntry.getInstance().init(this);
        initializeCloudDrive();
        VoiceSearchInitializer.getInstance().initialize(this);
        initializeAppStore(countdownlatch, crashdetectionhelper);
        if (AIVAvailabilityUtils.isAIVSupportedByDevice())
        {
            AmazonInstantVideoProxy.getInstance().initializeAIV(this);
            User.addUserListener(AIV_USER_LISTENER);
        }
        AppExtensionsInitializer.initializeSearch(this);
    }

    public void onLowMemory()
    {
        LRUCache.onLowMemory();
    }



}
