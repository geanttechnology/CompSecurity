// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.SetupAccountRequest;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanKey;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.SetupAccountEvent;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.auth.mapr5.MapSharedPrefCookieUtils;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.framework.network.upload.UploadPreferences;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.service.WhisperCacheBeanService;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.gallery.thor.metrics.CrashDetectionManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            AospPreferences

public class AccountStateManager
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AccountRegistered;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/app/authentication/AccountStateManager$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            AccountRegistered = new MetricsEvent("AccountRegistered", 0);
            $VALUES = (new MetricsEvent[] {
                AccountRegistered
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Uri PHOTO_INTENT_URL = Uri.parse("amazon-ftue://com.amazon.kindle.tablet.ftue/photos");
    private static final String TAG = com/amazon/gallery/thor/app/authentication/AccountStateManager.getName();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public AccountStateManager()
    {
    }

    private Runnable getPostSetupAccountSyncRunnable(final Context context)
    {
        return new Runnable() {

            final AccountStateManager this$0;
            final Context val$context;

            public void run()
            {
                SharedPreferences sharedpreferences = context.getSharedPreferences("accountpref", 0);
                if (!sharedpreferences.getBoolean("accountsync", false))
                {
                    GLogger.i(AccountStateManager.TAG, "Pre-fetching Albums", new Object[0]);
                    ((SyncManager)ThorGalleryApplication.getBean(Keys.SYNC_MANAGER)).scheduleBackgroundSync();
                    context.startService(new Intent(context, com/amazon/gallery/thor/app/service/WhisperCacheBeanService));
                    Intent intent = new Intent("com.amazon.kindle.tablet.ftue_complete", AccountStateManager.PHOTO_INTENT_URL);
                    context.sendBroadcast(intent);
                    sharedpreferences.edit().putBoolean("accountsync", true).apply();
                    GLogger.i(AccountStateManager.TAG, "first time sync complete", new Object[0]);
                    return;
                } else
                {
                    GLogger.i(AccountStateManager.TAG, "Already did a first-time sync - ignoring this request", new Object[0]);
                    return;
                }
            }

            
            {
                this$0 = AccountStateManager.this;
                context = context1;
                super();
            }
        };
    }

    private void initialAccountSetup(Context context, Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        String s;
        boolean flag;
        obj = context.getSharedPreferences("accountpref", 0);
        s = ((SharedPreferences) (obj)).getString("accountID", null);
        flag = ((SharedPreferences) (obj)).getBoolean("accountsync", false);
        obj1 = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        if (((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount()) goto _L2; else goto _L1
_L1:
        GLogger.w(TAG, "No Account - stopping", new Object[0]);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        GLogger.e(TAG, "Already did a first-time sync - ignoring this request before it starts", new Object[0]);
          goto _L3
        context;
        throw context;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        GLogger.e(TAG, "Running the initial account setup. initalSetup=false", new Object[0]);
        GLogger.e(TAG, "Resetting the Network executor", new Object[0]);
        NetworkExecutor.getInstance().resetWithInterrupt();
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit();
        editor.putBoolean("com.amazon.photos.account_state_changed", true);
        editor.putLong("deregistrationTimestamp", System.currentTimeMillis());
        editor.putBoolean("show_albums_welcome_letter", false);
        editor.apply();
        ((SharedPreferences) (obj)).edit().putString("accountID", ((String) (obj1))).apply();
        UploadPreferences.initializeDefaultPreferences(context);
        context = ((List)ThorGalleryApplication.getBean(Keys.ACCOUNT_CHANGE_LISTENER)).iterator();
_L4:
        do
        {
            if (!context.hasNext())
            {
                break MISSING_BLOCK_LABEL_310;
            }
            obj = (BeanKey)context.next();
            obj1 = (AccountChangeListener)ThorGalleryApplication.getBean(((BeanKey) (obj)));
        } while (obj1 == null);
        GLogger.i(TAG, (new StringBuilder()).append("Notifying ").append(((BeanKey) (obj)).getKey()).toString(), new Object[0]);
        ((AccountChangeListener) (obj1)).onAccountRegistered();
          goto _L4
        ((AmazonInsightsHelper)ThorGalleryApplication.getBean(Keys.AMAZON_INSIGHTS_HELPER)).recordEvent(MetricsEvent.AccountRegistered);
        GLogger.i(TAG, "initialAccountSetupComplete complete", new Object[0]);
        CrashDetectionManager.uploadExistingCrashReportsAsync();
        setupAccount(runnable);
          goto _L3
    }

    private void removeAccount(Context context, String s)
    {
        AospPreferences aosppreferences = new AospPreferences(context);
        if (aosppreferences.signedIn() && aosppreferences.getSignedInAccount().equals(s))
        {
            removeAccount(context);
        }
    }

    private void setupAccount(final Runnable onComplete)
    {
        executor.execute(new Runnable() {

            final AccountStateManager this$0;
            final Runnable val$onComplete;

            public void run()
            {
                ((CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER)).getForegroundCdsClient().setupAccount(new SetupAccountRequest());
                GlobalMessagingBus.post(new SetupAccountEvent(true));
                if (onComplete != null)
                {
                    onComplete.run();
                }
                return;
                Object obj;
                obj;
_L2:
                GLogger.i(AccountStateManager.TAG, "Exception while setting up customer's account", new Object[] {
                    obj
                });
                GlobalMessagingBus.post(new SetupAccountEvent(false));
                return;
                obj;
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                this$0 = AccountStateManager.this;
                onComplete = runnable;
                super();
            }
        });
    }

    public void processIncomingIntent(final Context context, final Intent intent)
    {
        executor.submit(new Runnable() {

            final AccountStateManager this$0;
            final Context val$context;
            final Intent val$intent;

            public void run()
            {
                if ("com.amazon.dcp.sso.action.account.removed".equals(intent.getAction()))
                {
                    GLogger.i(AccountStateManager.TAG, "Received Primary Account Removed broadcast.", new Object[0]);
                    removeAccount(context);
                } else
                {
                    if ("com.amazon.dcp.sso.action.secondary.account.removed".equals(intent.getAction()))
                    {
                        GLogger.i(AccountStateManager.TAG, "Received Secondary Account Removed broadcast.", new Object[0]);
                        removeAccount(context, intent.getStringExtra("com.amazon.dcp.sso.property.account.acctId"));
                        return;
                    }
                    if ("com.amazon.kindle.tablet.do_ftue".equals(intent.getAction()) && AccountStateManager.PHOTO_INTENT_URL.equals(intent.getData()))
                    {
                        GLogger.i(AccountStateManager.TAG, "Received Do FTUE broadcast.", new Object[0]);
                        return;
                    }
                    if ("com.amazon.kindle.tablet.ftue_free_for_all".equals(intent.getAction()))
                    {
                        GLogger.i(AccountStateManager.TAG, "Received FTUE Free for All broadcast.", new Object[0]);
                        registerAccount(context);
                        return;
                    }
                    if ("com.amazon.clouddrive.photos.do_setup_account".equals(intent.getAction()))
                    {
                        GLogger.i(AccountStateManager.TAG, "Received AOSP setup account broadcast. Setting up account and starting first time sync", new Object[0]);
                        initialAccountSetup(context, getPostSetupAccountSyncRunnable(context.getApplicationContext()));
                        return;
                    }
                }
            }

            
            {
                this$0 = AccountStateManager.this;
                intent = intent1;
                context = context1;
                super();
            }
        });
    }

    public void registerAccount(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        initialAccountSetup(context, null);
        startFirstTimeSync(context);
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public void removeAccount(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        obj = context.getSharedPreferences("accountpref", 0);
        if (((SharedPreferences) (obj)).getString("accountID", null) == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        Log.e(TAG, "Cleared Prefs");
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().clear().apply();
        obj1 = PreferenceManager.getDefaultSharedPreferences(context);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        ((SharedPreferences) (obj1)).edit().clear().apply();
        Iterator iterator;
        if (BuildFlavors.isAosp())
        {
            (new AospPreferences(context)).clearPrefs();
        }
        (new MapSharedPrefCookieUtils(context)).removeAllCookies();
        obj1 = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putBoolean("com.amazon.photos.account_state_changed", true).apply();
        GLogger.i(TAG, "Resetting the Network executor", new Object[0]);
        NetworkExecutor.getInstance().reset();
        if (ThorGalleryApplication.getBean(Keys.ACCOUNT_CHANGE_LISTENER) == null)
        {
            GLogger.i(TAG, "Account Listener should not be empty", new Object[0]);
        }
        iterator = ((List)ThorGalleryApplication.getBean(Keys.ACCOUNT_CHANGE_LISTENER)).iterator();
_L2:
        BeanKey beankey;
        AccountChangeListener accountchangelistener;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_288;
            }
            beankey = (BeanKey)iterator.next();
            accountchangelistener = (AccountChangeListener)ThorGalleryApplication.getBean(beankey);
        } while (accountchangelistener == null);
        GLogger.i(TAG, (new StringBuilder()).append("Notifying ").append(beankey.getKey()).toString(), new Object[0]);
        accountchangelistener.onAccountDeregistered();
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("accountID", null).apply();
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("accountsync", false).apply();
        GLogger.i(TAG, "Complete deregistration", new Object[0]);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        registerAccount(context);
        this;
        JVM INSTR monitorexit ;
    }

    public void startFirstTimeSync(Context context)
    {
        if (!((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount())
        {
            GLogger.w(TAG, "No Account - stopping", new Object[0]);
            return;
        } else
        {
            initialAccountSetup(context, getPostSetupAccountSyncRunnable(context));
            return;
        }
    }






}
