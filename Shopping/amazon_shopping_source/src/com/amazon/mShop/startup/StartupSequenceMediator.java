// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import amazon.android.dexload.SupplementalDexLoader;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.amazon.android.dagger.DaggerAndroid;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.clouddrive.CloudDriveAvailability;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.smile.SmileController;
import com.amazon.mShop.feature.FeatureStateSubscriber;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.primeupsell.PrimeFlagChecker;
import com.amazon.mShop.primeupsell.PrimeUpsellHelper;
import com.amazon.mShop.publicurl.PublicURLActivity;
import com.amazon.mShop.smile.SmileHelper;
import com.amazon.mShop.smile.SmileUserListener;
import com.amazon.mShop.social.SocialConnectHelper;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOSplashScreenActivity;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.BuildUtils;
import com.amazon.mShop.util.ThirdPartyActivityUtils;
import com.amazon.mShop.util.UpgradeUtil;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.mediator.Mediator;
import com.amazon.mShop.util.mediator.MediatorImpl;
import com.amazon.mShop.util.mediator.Task;
import com.amazon.mShop.voice.MShopVoicePackageProxy;
import com.amazon.mas.client.device.software.opengl.OpenGlActivityInterrogator;
import com.amazon.retailsearch.android.api.init.RetailSearchInitializer;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.DeviceEvent;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.PostEventsRequest;
import com.amazon.rio.j2me.client.services.mShop.PostEventsResponse;
import com.amazon.rio.j2me.client.services.mShop.PostEventsResponseListener;
import dagger.ObjectGraph;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, UserAgreementActivity

public class StartupSequenceMediator extends MediatorImpl
{
    private static class AppExtensionInitializationTask extends AsyncTask
    {

        private StartupTask mTask;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            AIVAvailabilityUtils.waitForAIVInitialize();
            CloudDriveAvailability.getInstance().waitForInitialization();
            MShopVoicePackageProxy.getInstance().waitForInitialization();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            mTask.end("taskResultSucceed");
        }

        public AppExtensionInitializationTask(StartupTask startuptask)
        {
            mTask = startuptask;
        }
    }


    private static final Executor sExecutor = Executors.newFixedThreadPool(1);
    private final FeatureStateSubscriber mFeatureStateubscriber = new FeatureStateSubscriber() {

        final StartupSequenceMediator this$0;

        public void onCancel()
        {
            endTask("taskGetFeatureState", "taskResultSucceed");
        }

        public void onError(Exception exception)
        {
            endTask("taskGetFeatureState", "taskResultFail");
        }

        public void onFeatureStateReceived(List list)
        {
            endTask("taskGetFeatureState", "taskResultSucceed");
        }

            
            {
                this$0 = StartupSequenceMediator.this;
                super();
            }
    };
    private PrimeFlagChecker mPrimeFlagChecker;
    final StartupActivity mStartupActivity;

    public StartupSequenceMediator(StartupActivity startupactivity)
    {
        mPrimeFlagChecker = null;
        mStartupActivity = startupactivity;
        StartupTask startuptask = new StartupTask("taskUserAgreement", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                if (UserAgreementActivity.shouldShowUserAgreement())
                {
                    UserAgreementActivity.startActivity(activity, getId());
                    return;
                } else
                {
                    end("taskResultSucceed");
                    return;
                }
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        };
        startuptask.addInputDependency("initial");
        startuptask.addOutputDependency("agreement");
        startuptask.addOutputDependency("network");
        startuptask = new StartupTask("taskSetCountry", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                if (!ActivityUtils.startLocaleSwitchActivityWhenNecessary(activity, getId()))
                {
                    end("taskResultSucceed");
                }
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        };
        startuptask.addInputDependency("agreement");
        startuptask.addOutputDependency("locale");
        startuptask = new StartupTask("taskGetCookiesAndAccount", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                StartupSequenceMediator.sExecutor.execute(new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        handleCookiesAndAccount(activity);
                        com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                endTask("taskGetCookiesAndAccount", "taskResultSucceed");
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        };
        startuptask.addInputDependency("network");
        startuptask.addInputDependency("locale");
        startuptask.addOutputDependency("cookiesAccounts");
        startuptask = new StartupTask("taskAppstoreCookie", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void start()
            {
                if (AppstoreUtils.isAppstoreAvailable())
                {
                    SupplementalDexLoader.getInstance().waitForLoad();
                    AppstoreUtils.setAppstoreDeviceInfoCookie(activity.getApplicationContext());
                    AppstoreUtils.setUpAppstoreDeviceInfoCookieListener();
                }
                end("taskResultSucceed");
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        };
        startuptask.addInputDependency("cookiesAccounts");
        startuptask.addOutputDependency("appstore_device_info_cookie");
        (new StartupTask(this, "taskRequestCoinBalance") {

            final StartupSequenceMediator this$0;

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                AppUtils.sendRequestCoinBalanceBroadcast(mStartupActivity);
                end("taskResultSucceed");
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                super(mediator, s);
            }
        }).addInputDependency("cookiesAccounts");
        startuptask = new StartupTask(this, "taskGetFeatureState") {

            final StartupSequenceMediator this$0;

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                requestFeatureStates(this);
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                super(mediator, s);
            }
        };
        startuptask.addInputDependency("appstore_device_info_cookie");
        startuptask.addOutputDependency("feature_state");
        (new StartupTask("taskPostFacebookEvent", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                postFaceBookAdvertisedInstallationEvent(activity);
                end("taskResultSucceed");
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        }).addInputDependency("feature_state");
        startuptask = new StartupTask("taskPrimeUpsell", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                if (!com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("ignoreOptOutFirstLaunch", SSOUtil.getAuthPoolForCurrentLocale()) && IdentityType.NON_SSO_TYPE != SSOUtil.getCurrentIdentityType())
                {
                    end("taskResultSucceed");
                } else
                {
                    if (PrimeUpsellHelper.shouldCheckPrimeFlagStatus())
                    {
                        checkPrimeFlag(activity, this);
                        return;
                    }
                    if (!PrimeUpsellHelper.showPrimeUpsell(activity, null, "prime_start", "taskPrimeUpsell"))
                    {
                        end("taskResultSucceed");
                        return;
                    }
                }
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        };
        startuptask.addInputDependency("feature_state");
        startuptask.addOutputDependency("prime_upsell");
        startuptask = new StartupTask("taskSocialConnect", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start").append(getId()).toString());
                boolean flag;
                if (SocialConnectHelper.passesPreLaunchCheck() && SocialConnectHelper.launchSocialConnect(activity, "msc_start", "taskSocialConnect"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    end("taskResultSucceed");
                }
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        };
        startuptask.addInputDependency("feature_state");
        startuptask.addInputDependency("prime_upsell");
        startuptask.addOutputDependency("social_connect");
        startuptask = new StartupTask(this, "taskAppExtensionsIntialization") {

            final StartupSequenceMediator this$0;

            public void start()
            {
                RetailSearchInitializer.getInstance().onStartup();
                (new AppExtensionInitializationTask(this)).execute(new Void[] {
                    (Void)null
                });
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                super(mediator, s);
            }
        };
        startuptask.addInputDependency("prime_upsell");
        startuptask.addOutputDependency("app_extensions_initailization");
        startuptask.addInputDependency("social_connect");
        startuptask = new StartupTask("taskGateWay", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            private void startRequestedEntry()
            {
                String s = activity.getIntent().getComponent().getClassName();
                if (s.endsWith(activity.getString(com.amazon.mShop.android.lib.R.string.manifest_aiv_launcher_name)))
                {
                    ActivityUtils.startAIVGatewayActivity(activity, null, -1);
                    return;
                }
                if (s.endsWith("PublicUrlActivity"))
                {
                    Intent intent = ActivityUtils.getStartActivityIntent(activity, com/amazon/mShop/publicurl/PublicURLActivity, -1);
                    intent.setData(activity.getIntent().getData());
                    activity.startActivity(intent);
                    return;
                } else
                {
                    ActivityUtils.startHomeActivity(activity);
                    return;
                }
            }

            public void start()
            {
                Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                Features.getInstance().removeFeatureStateSubscriber(mFeatureStateubscriber);
                if (mPrimeFlagChecker != null)
                {
                    mPrimeFlagChecker.setSubscriber(null);
                }
                end("taskResultSucceed");
                if (android.os.Build.VERSION.SDK_INT == 18)
                {
                    startRequestedEntry();
                    activity.finish();
                    return;
                } else
                {
                    activity.finish();
                    startRequestedEntry();
                    return;
                }
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        };
        startuptask.addInputDependency("app_extensions_initailization");
        startuptask.addInputDependency("social_connect");
        (new StartupTask(this, "taskSSOWelcome") {

            final StartupSequenceMediator this$0;

            public void start()
            {
                com.amazon.mShop.util.DebugUtil.Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                Object obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
                if (isAppFirstStart() && SSOUtil.hasAmazonAccount())
                {
                    RefMarkerObserver.logRefMarker("fs_with_account");
                }
                String s = SSOUtil.getAuthPoolForCurrentLocale();
                if (!((DataStore) (obj)).getBoolean("ignoreOptOutFirstLaunch", s) && IdentityType.NON_SSO_TYPE != SSOUtil.getCurrentIdentityType() && !Util.isEmpty(SSOUtil.selectMatchedAccount()))
                {
                    ((DataStore) (obj)).putBoolean("ignoreOptOutFirstLaunch", true, s);
                    obj = new Intent();
                    ((Intent) (obj)).setClass(mStartupActivity, com/amazon/mShop/sso/SSOSplashScreenActivity);
                    mStartupActivity.startActivity(((Intent) (obj)));
                }
                end("taskResultSucceed");
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                super(mediator, s);
            }
        }).addInputDependency("app_extensions_initailization");
        (new StartupTask(this, "taskSyncSmileInfo") {

            final StartupSequenceMediator this$0;

            public void start()
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls13 this$1;

                    public void run()
                    {
                        SmileUserListener.registerUserListener();
                        SmileUserListener.registerFeatureStateListener();
                        if (SmileHelper.shouldSyncSmileInfo())
                        {
                            SmileController.getInstance().syncSmileInfo();
                        }
                    }

            
            {
                this$1 = _cls13.this;
                super();
            }
                });
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                super(mediator, s);
            }
        }).addInputDependency("feature_state");
        (new StartupTask("taskDeviceRegister", startupactivity) {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void start()
            {
                DataStore datastore;
                Context context;
                datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
                context = activity.getApplicationContext();
                if (!Util.isEmpty(datastore.getString("applicationInstallId"))) goto _L2; else goto _L1
_L1:
                KiangController.getInstance().kiangRegister(context);
_L4:
                end("taskResultSucceed");
                return;
_L2:
                if (BuildUtils.isKiangUpdateActivated(context))
                {
                    KiangController.getInstance().kiangUpdate(context);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super(final_mediator, s);
            }
        }).addInputDependency("feature_state");
    }

    private void checkPrimeFlag(final StartupActivity activity, StartupTask startuptask)
    {
        mPrimeFlagChecker = new PrimeFlagChecker(new com.amazon.mShop.primeupsell.PrimeFlagChecker.Subscriber() {

            final StartupSequenceMediator this$0;
            final StartupActivity val$activity;

            public void onCancelled()
            {
                endTask("taskPrimeUpsell", "taskResultFail");
            }

            public void onComplete()
            {
                if (!PrimeUpsellHelper.showPrimeUpsell(activity, null, "prime_start", "taskPrimeUpsell"))
                {
                    endTask("taskPrimeUpsell", "taskResultSucceed");
                }
            }

            public void onError()
            {
                endTask("taskPrimeUpsell", "taskResultFail");
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                activity = startupactivity;
                super();
            }
        });
        mPrimeFlagChecker.checkFlag();
    }

    private void gatherOpenGlExtentions()
    {
        try
        {
            if (AppstoreUtils.isAppstoreAvailable())
            {
                ((OpenGlActivityInterrogator)DaggerAndroid.getGraph().get(com/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator)).interrogate(mStartupActivity);
            }
            return;
        }
        catch (Exception exception)
        {
            com.amazon.mShop.util.DebugUtil.Log.d("StartupSequenceMediator", "AppStore initialize might time out", exception);
        }
    }

    private void handleCookiesAndAccount(Context context)
    {
        SSOUtil.getCurrentIdentityType().handleSSOInit(context);
    }

    private boolean isAppFirstStart()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getAppStartCountForAllLocales() == 0;
    }

    private boolean isFirstStartOnCurrentMarketplace()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getInt("applicationStartCount") == 0;
    }

    private void postFaceBookAdvertisedInstallationEvent(Context context)
    {
        if (isAppFirstStart())
        {
            Object obj = ThirdPartyActivityUtils.getFaceBookAttributionId(context);
            if (!Util.isEmpty(((String) (obj))))
            {
                context = new PostEventsRequest();
                DeviceEvent deviceevent = new DeviceEvent();
                obj = (new StringBuilder()).append("{\"attribution_id\":\"").append(((String) (obj))).append("\"}").toString();
                deviceevent.setName("mobile_app_install");
                deviceevent.setValue(((String) (obj)));
                obj = new ArrayList();
                ((List) (obj)).add(deviceevent);
                context.setEvents(((List) (obj)));
                ServiceController.getMShopService().postEvents(context, new PostEventsResponseListener() {

                    final StartupSequenceMediator this$0;

                    public void cancelled(ServiceCall servicecall)
                    {
                    }

                    public void completed(PostEventsResponse posteventsresponse, ServiceCall servicecall)
                    {
                    }

                    public void error(Exception exception, ServiceCall servicecall)
                    {
                    }

            
            {
                this$0 = StartupSequenceMediator.this;
                super();
            }
                });
            }
        }
    }

    private void requestFeatureStates(final StartupTask task)
    {
        if (BuildUtils.isVersionUpdate(mStartupActivity) || isFirstStartOnCurrentMarketplace() || !Features.getInstance().areFeaturesCached(new String[0]))
        {
            Features.getInstance().addFeatureStateSubscriber(mFeatureStateubscriber);
            Features.getInstance().fetchFeatureStates(true);
            (new Handler()).postDelayed(new Runnable() {

                final StartupSequenceMediator this$0;
                final StartupTask val$task;

                public void run()
                {
                    endTask(task.getId(), "taskResultFail");
                }

            
            {
                this$0 = StartupSequenceMediator.this;
                task = startuptask;
                super();
            }
            }, 10000L);
            if (UpgradeUtil.shouldCheckUpgrade())
            {
                UpgradeUtil.checkForUpgrade();
            }
        } else
        {
            endTask(task.getId(), "taskResultSucceed");
            if (UpgradeUtil.shouldCheckUpgrade())
            {
                UpgradeUtil.checkForUpgradeLater();
                return;
            }
        }
    }

    public void endTask(String s, String s1)
    {
        if (!Util.isEmpty(s))
        {
            if ((s = (Task)mTasks.get(s)) != null)
            {
                s.end(s1);
                return;
            }
        }
    }

    public void onFailed(String s)
    {
        if ("agreement".equals(s))
        {
            mStartupActivity.finish();
            return;
        } else
        {
            super.onReady(s);
            return;
        }
    }

    public void start()
    {
        gatherOpenGlExtentions();
        StartupTask startuptask = new StartupTask(this, "taskInit") {

            final StartupSequenceMediator this$0;

            public void start()
            {
                com.amazon.mShop.util.DebugUtil.Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
                end("taskResultSucceed");
            }

            
            {
                this$0 = StartupSequenceMediator.this;
                super(mediator, s);
            }
        };
        startuptask.addOutputDependency("initial");
        startuptask.start();
    }









}
