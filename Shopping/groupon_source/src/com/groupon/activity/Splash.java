// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.groupon.GrouponApplication;
import com.groupon.db.GrouponOrmLiteHelper;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.manager.ExceptionManager;
import com.groupon.models.StartupContext;
import com.groupon.models.country.Country;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.provider.KochavaProvider;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.GCMNotificationService;
import com.groupon.service.LoginService;
import com.groupon.service.OnBoardingService;
import com.groupon.service.core.CollectionsService;
import com.groupon.service.core.CoreService;
import com.groupon.service.core.CoreServiceException;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.core.listener.CoreServiceInitializerListener;
import com.groupon.service.countryanddivision.CountryAndDivisionInitializer;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.service.countryanddivision.listener.CountryAndDivisionInitializerListener;
import com.groupon.service.startup.StartupDirector;
import com.groupon.service.upgrade.listener.UpgradeManagerListener;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function0;
import com.groupon.util.WobbleSpaceshipCatAnimationListener;
import com.groupon.view.WobbleSpaceshipCatView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, DontRestartOnConfigurationChange, OnboardingMultiStep, IntentFactory, 
//            FacebookAppUtils

public class Splash extends GrouponActivity
    implements DontRestartOnConfigurationChange
{
    private class FBDeferredDeepLinkFetcher
        implements com.facebook.applinks.AppLinkData.CompletionHandler
    {

        final Splash this$0;

        public void fetchDeepLinkIntoIntentAndStartNextActivity()
        {
            AppLinkData.fetchDeferredAppLinkData(Splash.this, facebookAppUtils.getFacebookAppId(), this);
        }

        public void onDeferredAppLinkDataFetched(AppLinkData applinkdata)
        {
            if (applinkdata != null && applinkdata.getTargetUri() != null)
            {
                Uri uri = applinkdata.getTargetUri();
                if (deepLinkUtil.isDeepLink(uri.toString()))
                {
                    getIntent().setData(uri);
                    String s;
                    if (uri.getQueryParameter("cid") == null)
                    {
                        applinkdata = "";
                    } else
                    {
                        applinkdata = uri.getQueryParameter("cid");
                    }
                    if (uri.getQueryParameter("grpn_l") == null)
                    {
                        s = "";
                    } else
                    {
                        s = uri.getQueryParameter("grpn_l");
                    }
                    logger.logDeepLinking("", uri.toString(), applinkdata, s, "FB_Deferred_Deep_Link", "");
                }
            }
            startNextActivity();
        }

        private FBDeferredDeepLinkFetcher()
        {
            this$0 = Splash.this;
            super();
        }

    }

    private class SplashCoreServiceInitializerListenerImpl
        implements CoreServiceInitializerListener
    {

        final Splash this$0;

        public void onAllServicesRefreshCompletedSuccessfully()
        {
            onServicesRefreshComplete();
        }

        public void onAllServicesRefreshCompletedWithError(Collection collection)
        {
            Ln.d("onAllServicesRefreshCompletedWithError", new Object[0]);
            CoreServiceException coreserviceexception = (CoreServiceException)collection.iterator().next();
            if (collection.size() == 1 && coreserviceexception.getCoreServiceClass() == com/groupon/service/core/CollectionsService)
            {
                Ln.d("The only core service that failed was the collection service. Passing through as it is optional for app startup.", new Object[0]);
                onServicesRefreshComplete();
                return;
            } else
            {
                ((ExceptionManager)RoboGuice.getInjector(Splash.this).getInstance(com/groupon/manager/ExceptionManager)).handleException(coreserviceexception.getCause(), new Function0() {

                    final SplashCoreServiceInitializerListenerImpl this$1;

                    public void execute()
                    {
                        startupDirector.addCoreServicesInitializerListener(splashServiceInitializerListener);
                        startupDirector.startupCoreServices();
                    }

            
            {
                this$1 = SplashCoreServiceInitializerListenerImpl.this;
                super();
            }
                }, new Function0() {

                    final SplashCoreServiceInitializerListenerImpl this$1;

                    public void execute()
                    {
                        finish();
                    }

            
            {
                this$1 = SplashCoreServiceInitializerListenerImpl.this;
                super();
            }
                });
                return;
            }
        }

        public void onServiceRefreshStarted(CoreService coreservice)
        {
            if (!isViewLoaded.get() && coreservice.isDownloadingDataFromNetwork())
            {
                ((Handler)handler.get()).post(new Runnable() {

                    final SplashCoreServiceInitializerListenerImpl this$1;

                    public void run()
                    {
                        setupViews();
                    }

            
            {
                this$1 = SplashCoreServiceInitializerListenerImpl.this;
                super();
            }
                });
            }
        }

        private SplashCoreServiceInitializerListenerImpl()
        {
            this$0 = Splash.this;
            super();
        }

    }

    private class SplashCountryAndDivisionInitializerListenerImpl
        implements CountryAndDivisionInitializerListener
    {

        final Splash this$0;

        public void onCountryAndDivisionSet()
        {
            Ln.d("onCountryAndDivisionSet", new Object[0]);
        }

        public void onException(Exception exception)
        {
            ((ExceptionManager)RoboGuice.getInjector(Splash.this).getInstance(com/groupon/manager/ExceptionManager)).handleException(exception, new Function0() {

                final SplashCountryAndDivisionInitializerListenerImpl this$1;

                public void execute()
                    throws RuntimeException
                {
                    startupDirector.addCountryAndDivisionInitializerListener(splashCountryAndDivisionInitializerListener);
                    startupDirector.addCoreServicesInitializerListener(splashServiceInitializerListener);
                    startupDirector.startupCountryAndDivisionInitializer();
                }

            
            {
                this$1 = SplashCountryAndDivisionInitializerListenerImpl.this;
                super();
            }
            }, new Function0() {

                final SplashCountryAndDivisionInitializerListenerImpl this$1;

                public void execute()
                {
                    finish();
                }

            
            {
                this$1 = SplashCountryAndDivisionInitializerListenerImpl.this;
                super();
            }
            });
        }

        public void onManualCountrySelectionNeeded()
        {
            Ln.d("onManualCountrySelectionNeeded", new Object[0]);
            ((Handler)handler.get()).post(new Runnable() {

                final SplashCountryAndDivisionInitializerListenerImpl this$1;

                public void run()
                {
                    setupViews();
                    if (getIntent().getData() != null && deepLinkUtil.isDeepLink(getIntent().getData().toString()))
                    {
                        setDefaultCountry();
                        return;
                    } else
                    {
                        startupDirector.addCountryAndDivisionInitializerListener(splashCountryAndDivisionInitializerListener);
                        refreshDivisionChooser();
                        return;
                    }
                }

            
            {
                this$1 = SplashCountryAndDivisionInitializerListenerImpl.this;
                super();
            }
            });
        }

        public void onManualDivisionSelectionNeeded()
        {
            Ln.d("onManualDivisionSelectionNeeded", new Object[0]);
            ((Handler)handler.get()).post(new Runnable() {

                final SplashCountryAndDivisionInitializerListenerImpl this$1;

                public void run()
                {
                    setupViews();
                    if (getIntent().getData() != null && deepLinkUtil.isDeepLink(getIntent().getData().toString()))
                    {
                        setDefaultCountry();
                        return;
                    }
                    startupDirector.addCountryAndDivisionInitializerListener(splashCountryAndDivisionInitializerListener);
                    if (shouldShowCitiesSelector)
                    {
                        shouldShowCitiesSelector = false;
                        startActivity(intentFactory.newCountryOrDivisionSelector());
                        return;
                    } else
                    {
                        refreshDivisionChooser();
                        return;
                    }
                }

            
            {
                this$1 = SplashCountryAndDivisionInitializerListenerImpl.this;
                super();
            }
            });
        }

        private SplashCountryAndDivisionInitializerListenerImpl()
        {
            this$0 = Splash.this;
            super();
        }

    }

    private class SplashUpgradeManagerListenerImpl
        implements UpgradeManagerListener
    {

        private Bundle savedInstanceState;
        final Splash this$0;

        public void onUpgradeSuccess()
        {
            runOnUiThread(new Runnable() {

                final SplashUpgradeManagerListenerImpl this$1;

                public void run()
                {
                    onUpgradeFinished(savedInstanceState);
                }

            
            {
                this$1 = SplashUpgradeManagerListenerImpl.this;
                super();
            }
            });
        }


        private SplashUpgradeManagerListenerImpl(Bundle bundle)
        {
            this$0 = Splash.this;
            super();
            savedInstanceState = bundle;
        }

    }

    private class SplashWobbleSpaceshipCatAnimationListener
        implements WobbleSpaceshipCatAnimationListener
    {

        final Splash this$0;

        public void onExitRightAnimationEnd()
        {
            wobbleSpaceshipCatView.setVisibility(8);
            startActivity(newOnBoardingIntent());
            overridePendingTransition(0, 0);
            finish();
        }

        private SplashWobbleSpaceshipCatAnimationListener()
        {
            this$0 = Splash.this;
            super();
        }

    }

    private class UpdateCurrentCountryTask extends AbstractRetryAsyncTask
    {

        private final String countryCode;
        final Splash this$0;

        public Country call()
            throws Exception
        {
            Object obj = (CurrentCountryService)RoboGuice.getInjector(Splash.this).getInstance(com/groupon/service/countryanddivision/CurrentCountryService);
            Country country = new Country();
            String s = countryCode;
            country.isoName = s;
            country.shortName = s;
            obj = ((CurrentCountryService) (obj)).getCountryFromServer(country);
            currentCountryManager.setCurrentCountryAndRemoveDivision(((Country) (obj)));
            return ((Country) (obj));
        }

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        protected void onException(Exception exception)
        {
            super.onException(exception);
            setupViews();
        }

        protected void onSuccess(Country country)
            throws Exception
        {
            super.onSuccess(country);
            setDefaultDivision();
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((Country)obj);
        }

        public void onUserCancelRetry()
        {
            finish();
        }

        public UpdateCurrentCountryTask(String s)
        {
            this$0 = Splash.this;
            super(Splash.this);
            countryCode = s;
        }
    }

    private class UpdateCurrentDivisionInfoTask extends AbstractRetryAsyncTask
    {

        private final String defaultDivisionId;
        final Splash this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            ((CountryAndDivisionInitializer)RoboGuice.getInjector(Splash.this).getInstance(com/groupon/service/countryanddivision/CountryAndDivisionInitializer)).setCurrentDivision(defaultDivisionId);
            return null;
        }

        protected void onException(Exception exception)
        {
            super.onException(exception);
            setupViews();
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((Void)obj);
        }

        protected void onSuccess(Void void1)
            throws Exception
        {
            super.onSuccess(void1);
            onNewIntent(getIntent());
            startupDirector.addCountryAndDivisionInitializerListener(splashCountryAndDivisionInitializerListener);
            startupDirector.addCoreServicesInitializerListener(splashServiceInitializerListener);
            startupDirector.startupCountryAndDivisionInitializer();
        }

        public void onUserCancelRetry()
        {
            finish();
        }

        public UpdateCurrentDivisionInfoTask(String s)
        {
            this$0 = Splash.this;
            super(Splash.this);
            defaultDivisionId = s;
        }
    }


    private static final String FACEBOOK_DEEP_LINK_PATTERN = "^.*www.groupon.com/deals/(.+)$";
    private static final String FACEBOOK_FETCH_DEFERRED_DEEP_LINK = "facebook_fetch_deferred_deep_link";
    private static final String FB_DEFERRED_DEEP_LINK = "FB_Deferred_Deep_Link";
    public static final int GCM_SERVICE_ALARM_CODE = 800;
    private static final String PROPERTY_ALPHA = "alpha";
    private static final String PROPERTY_SCALE_X = "scaleX";
    private static final String PROPERTY_SCALE_Y = "scaleY";
    private static final String PROPERTY_Y = "y";
    static final int REQUEST_CODE_RECOVER_PLAY_SERVICES = 1001;
    public static final int SPACESHIP_LIGHTS_FADE_DURATION = 100;
    public static final String STARTUP_PREFERENCES = "default";
    private static final String WEAR_NOTIFICATION = "wear_notification";
    View bottomContainer;
    View cityImage;
    View continueButtonContainer;
    private CurrentCountryManager currentCountryManager;
    private Lazy deepLinkManager;
    private DeepLinkUtil deepLinkUtil;
    private DeviceInfoUtil deviceInfoUtil;
    View divisionChooser;
    private boolean divisionChooserAnimationDisplayed;
    private DogfoodHelper dogfoodHelper;
    private FacebookAppUtils facebookAppUtils;
    TextView firstTimeChoosePlease;
    View grouponLogo;
    private float grouponLogoInitialY;
    private GrouponOrmLiteHelper grouponOrmLiteHelper;
    private Lazy handler;
    private IntentFactory intentFactory;
    private AtomicBoolean isDestroyed;
    private boolean isPlayServiceAvailable;
    private AtomicBoolean isViewLoaded;
    private KochavaProvider kochavaProvider;
    private Logger logger;
    private SharedPreferences prefs;
    private boolean shouldLogStartupTime;
    private boolean shouldShowCitiesSelector;
    private CountryAndDivisionInitializerListener splashCountryAndDivisionInitializerListener;
    private CoreServiceInitializerListener splashServiceInitializerListener;
    private long splashStartTime;
    private UpgradeManagerListener splashUpgradeManagerListener;
    private StartupDirector startupDirector;
    private Lazy staticSupportInfoService;
    Button tryAnotherCity;
    View welcomeText;
    private float welcomeTextIntialY;
    WobbleSpaceshipCatView wobbleSpaceshipCatView;

    public Splash()
    {
        deepLinkManager = new Lazy(this) {

            final Splash this$0;

            
            {
                this$0 = Splash.this;
                super(context);
            }
        };
        handler = new Lazy(this) {

            final Splash this$0;

            
            {
                this$0 = Splash.this;
                super(context);
            }
        };
        staticSupportInfoService = new Lazy(this) {

            final Splash this$0;

            
            {
                this$0 = Splash.this;
                super(context);
            }
        };
        shouldShowCitiesSelector = true;
        isViewLoaded = new AtomicBoolean(false);
        isDestroyed = new AtomicBoolean(false);
        splashServiceInitializerListener = new SplashCoreServiceInitializerListenerImpl();
        splashCountryAndDivisionInitializerListener = new SplashCountryAndDivisionInitializerListenerImpl();
    }

    private void checkIfColdStartDidAlreadyHappen()
    {
        if (GrouponApplication.startupContext.shouldLogGrp24)
        {
            splashStartTime = SystemClock.elapsedRealtime();
            shouldLogStartupTime = true;
        }
    }

    private boolean checkPlayServices()
    {
        boolean flag = true;
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        Object obj = GooglePlayServicesUtil.getErrorString(i);
        if (i != 0)
        {
            if (GooglePlayServicesUtil.isUserRecoverableError(i))
            {
                logGooglePlayServiceError(i, ((String) (obj)));
                obj = GooglePlayServicesUtil.getErrorDialog(i, this, 1001);
                ((Dialog) (obj)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    final Splash this$0;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        finish();
                    }

            
            {
                this$0 = Splash.this;
                super();
            }
                });
                ((Dialog) (obj)).show();
            } else
            {
                Toast.makeText(this, 0x7f08015c, 1).show();
                finish();
            }
            flag = false;
        }
        return flag;
    }

    private void doStartNextActivity()
    {
        if (prefs.getBoolean("facebook_fetch_deferred_deep_link", true))
        {
            prefs.edit().putBoolean("facebook_fetch_deferred_deep_link", false).apply();
            GrouponApplication.startupContext.shouldLogGrp24 = false;
            Uri uri = getIntent().getData();
            if (uri == null || uri.getPath() == null)
            {
                (new FBDeferredDeepLinkFetcher()).fetchDeepLinkIntoIntentAndStartNextActivity();
                return;
            } else
            {
                startNextActivity();
                return;
            }
        } else
        {
            startNextActivity();
            return;
        }
    }

    private String getCountryCode()
    {
        Object obj;
        Object obj3;
        Uri uri;
        obj3 = null;
        Object obj1 = null;
        uri = getIntent().getData();
        obj = obj1;
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj = obj1;
        if (!deepLinkUtil.isDeepLink(uri.toString()))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        boolean flag;
        obj = deepLinkUtil.getDeepLink(uri.toString());
        flag = deepLinkUtil.hasWildCardCountryCode(((DeepLinkData) (obj)));
        Object obj2;
        if (flag)
        {
            obj = null;
        } else
        {
            try
            {
                obj = ((DeepLinkData) (obj)).getCountryCode();
            }
            catch (InvalidDeepLinkException invaliddeeplinkexception)
            {
                invaliddeeplinkexception = null;
            }
        }
        obj2 = obj;
        if (Strings.isEmpty(obj))
        {
            obj2 = deviceInfoUtil.getDeviceLocale().getCountry();
        }
        obj = obj3;
        if (obj2 != null)
        {
            obj = ((String) (obj2)).toLowerCase(Locale.ENGLISH);
        }
        return ((String) (obj));
    }

    private String getDefaultDivisionId()
    {
        StaticSupportInfo staticsupportinfo = ((StaticSupportInfoService)staticSupportInfoService.get()).getSupportInfo(currentCountryManager.getCurrentCountry());
        if (staticsupportinfo == null)
        {
            return null;
        } else
        {
            return staticsupportinfo.defaultDivisionID;
        }
    }

    private void hideDivisionChooserButton()
    {
        bottomContainer.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final Splash this$0;

            public void onGlobalLayout()
            {
                bottomContainer.setY(cityImage.getHeight() + divisionChooser.getHeight() + continueButtonContainer.getHeight());
                grouponLogo.setY(grouponLogoInitialY);
                welcomeText.setY(welcomeTextIntialY);
                grouponLogo.setScaleX(1.0F);
                grouponLogo.setScaleY(1.0F);
                bottomContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

            
            {
                this$0 = Splash.this;
                super();
            }
        });
        showGrouponLogoCentered();
    }

    private void logGooglePlayServiceError(int i, String s)
    {
        logger.logGeneralEvent("play_service_check", String.format("%s:%s", new Object[] {
            "play_service_error", "startup"
        }), s, i, Logger.NULL_NST_FIELD);
    }

    private Intent newOnBoardingIntent()
    {
        GrouponApplication.startupContext.shouldLogGrp24 = false;
        return (new Intent(this, com/groupon/activity/OnboardingMultiStep)).putExtra("includeEmail", true);
    }

    private void onServicesRefreshComplete()
    {
        Ln.d("onAllServicesRefreshCompleted", new Object[0]);
        if (!isPlayServiceAvailable)
        {
            Ln.d("Google Play Services unavailable, exiting before launching Carousel and GCM Service", new Object[0]);
        } else
        {
            Object obj = new Intent(getApplicationContext(), com/groupon/service/GCMNotificationService);
            ((Intent) (obj)).setAction("com.groupon.REGISTER");
            Ln.d("GCM_Notification: Starting GCM service from Splash", new Object[0]);
            AlarmManager alarmmanager = (AlarmManager)getSystemService("alarm");
            obj = PendingIntent.getService(this, 800, ((Intent) (obj)), 0x8000000);
            if (android.os.Build.VERSION.SDK_INT < 19)
            {
                setAlarmBelowKitKat(alarmmanager, ((PendingIntent) (obj)));
            } else
            {
                setAlarmKitKatAndMore(alarmmanager, ((PendingIntent) (obj)));
            }
            doStartNextActivity();
            if (shouldLogStartupTime)
            {
                logger.logGeneralEvent("startup", "splash", "activityDuration", (int)(SystemClock.elapsedRealtime() - splashStartTime), Logger.NULL_NST_FIELD);
                return;
            }
        }
    }

    private void onUpgradeFinished(Bundle bundle)
    {
        super.onCustomPostCreate(bundle);
    }

    private void refreshDivisionChooser()
    {
        boolean flag;
        if (!startupDirector.areCountryAndDivisionReady())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shouldShowDivisionChooser(flag);
    }

    private void refreshDivisionChooserOnLayout(boolean flag)
    {
label0:
        {
            if (!divisionChooserAnimationDisplayed)
            {
                divisionChooserAnimationDisplayed = true;
                if (grouponLogoInitialY == 0.0F)
                {
                    grouponLogoInitialY = grouponLogo.getY();
                }
                if (welcomeTextIntialY == 0.0F)
                {
                    welcomeTextIntialY = welcomeText.getY();
                }
                if (!flag)
                {
                    break label0;
                }
                showDivisionChooserButton();
            }
            return;
        }
        hideDivisionChooserButton();
    }

    private void setAlarmBelowKitKat(AlarmManager alarmmanager, PendingIntent pendingintent)
    {
        alarmmanager.set(2, SystemClock.elapsedRealtime() + 3000L, pendingintent);
    }

    private void setAlarmKitKatAndMore(AlarmManager alarmmanager, PendingIntent pendingintent)
    {
        alarmmanager.setExact(2, SystemClock.elapsedRealtime() + 3000L, pendingintent);
    }

    private void setDefaultCountry()
    {
        if (((StaticSupportInfoService)staticSupportInfoService.get()).getSupportInfo(currentCountryManager.getCurrentCountry()) == null)
        {
            String s = getCountryCode();
            if (Strings.isEmpty(s))
            {
                refreshDivisionChooser();
                return;
            } else
            {
                (new UpdateCurrentCountryTask(s)).execute();
                return;
            }
        } else
        {
            setDefaultDivision();
            return;
        }
    }

    private void setDefaultDivision()
    {
        String s = getDefaultDivisionId();
        if (Strings.isEmpty(s))
        {
            refreshDivisionChooser();
            return;
        } else
        {
            (new UpdateCurrentDivisionInfoTask(s)).execute();
            return;
        }
    }

    private void shouldShowDivisionChooser(final boolean show)
    {
        divisionChooserAnimationDisplayed = false;
        if (bottomContainer.getMeasuredHeight() == 0)
        {
            bottomContainer.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final Splash this$0;
                final boolean val$show;

                public void onGlobalLayout()
                {
                    refreshDivisionChooserOnLayout(show);
                }

            
            {
                this$0 = Splash.this;
                show = flag;
                super();
            }
            });
            return;
        } else
        {
            refreshDivisionChooserOnLayout(show);
            return;
        }
    }

    private void showDivisionChooserButton()
    {
        int i;
        int j;
        if (currentCountryManager.getCurrentCountry() == null)
        {
            j = 0x7f080161;
            i = 0x7f0803f0;
        } else
        {
            j = 0x7f080160;
            i = 0x7f0803ef;
        }
        firstTimeChoosePlease.setText(j);
        tryAnotherCity.setText(i);
        tryAnotherCity.setOnClickListener(new android.view.View.OnClickListener() {

            final Splash this$0;

            public void onClick(View view)
            {
                startActivity(intentFactory.newCountryOrDivisionSelector());
                shouldShowDivisionChooser(false);
            }

            
            {
                this$0 = Splash.this;
                super();
            }
        });
        wobbleSpaceshipCatView.stopProgressAnimation();
        wobbleSpaceshipCatView.setVisibility(8);
        continueButtonContainer.setVisibility(8);
        divisionChooser.setVisibility(0);
        getEnterDivisionChooserAnimator().start();
    }

    private void showGrouponLogoCentered()
    {
        int i = deviceInfoUtil.getStatusBarHeight() / 2;
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)grouponLogo.getLayoutParams();
        layoutparams.setMargins(0, -i, 0, 0);
        grouponLogo.setLayoutParams(layoutparams);
    }

    private void startExitToOnboardingAnimation()
    {
        wobbleSpaceshipCatView.stopProgressAnimation();
        divisionChooser.setVisibility(8);
        ObjectAnimator.ofFloat(welcomeText, "alpha", new float[] {
            1.0F, 0.0F
        }).setDuration(300L).start();
        float f1 = getResources().getDimension(0x7f0b0010);
        float f = grouponLogo.getWidth();
        float f3 = getResources().getDisplayMetrics().density;
        float f5 = getResources().getDimension(0x7f0b0027);
        Object obj;
        if (f5 / f3 != -2F)
        {
            f = f5 / f;
        } else
        {
            f = 1.0F;
        }
        obj = new AnimatorSet();
        ((AnimatorSet) (obj)).playTogether(new Animator[] {
            ObjectAnimator.ofFloat(grouponLogo, "y", new float[] {
                grouponLogo.getY(), f1
            }).setDuration(500L), ObjectAnimator.ofFloat(grouponLogo, "scaleX", new float[] {
                f
            }).setDuration(500L), ObjectAnimator.ofFloat(grouponLogo, "scaleY", new float[] {
                f
            }).setDuration(500L)
        });
        ((AnimatorSet) (obj)).setInterpolator(new AccelerateDecelerateInterpolator());
        ((AnimatorSet) (obj)).start();
        wobbleSpaceshipCatView.tiltLeftRight();
        wobbleSpaceshipCatView.curveUp();
        wobbleSpaceshipCatView.wobbleSpaceshipCatAnimationListener = new SplashWobbleSpaceshipCatAnimationListener();
        wobbleSpaceshipCatView.exitRight();
        f = bottomContainer.getY();
        obj = ObjectAnimator.ofFloat(bottomContainer, "y", new float[] {
            f, 0.0F
        });
        ((ObjectAnimator) (obj)).setDuration(500L);
        ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
        ((ObjectAnimator) (obj)).start();
        if (cityImage != null)
        {
            f = cityImage.getY();
            float f2 = continueButtonContainer.getHeight();
            float f4 = cityImage.getY();
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(cityImage, "y", new float[] {
                f + f2, f4
            });
            objectanimator.setDuration(500L);
            objectanimator.setInterpolator(new DecelerateInterpolator());
            objectanimator.start();
        }
    }

    private void startNextActivity()
    {
        if (isFinishing() || isDestroyed.get())
        {
            return;
        }
        Object obj = getIntent();
        Bundle bundle = ((Intent) (obj)).getExtras();
        Object obj1 = ((Intent) (obj)).getData();
        if (bundle != null && bundle.containsKey("next"))
        {
            try
            {
                obj1 = (Intent)bundle.get("next");
                ((Intent) (obj1)).setExtrasClassLoader(getClassLoader());
                startActivity(((Intent) (obj1)));
                bundle.remove("next");
                ((Intent) (obj)).replaceExtras(bundle);
                setIntent(((Intent) (obj)));
                finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                startActivity(newOnBoardingIntent());
            }
            finish();
            return;
        }
        if (obj1 != null && ((Uri) (obj1)).getPath() != null)
        {
            String s = ((Intent) (obj)).getAction();
            obj = obj1;
            if (s != null)
            {
                obj = obj1;
                if (s.toLowerCase().startsWith("com.facebook"))
                {
                    if (Pattern.matches("^.*www.groupon.com/deals/(.+)$", ((Uri) (obj1)).toString()))
                    {
                        obj = (new android.net.Uri.Builder()).scheme(((Uri) (obj1)).getScheme()).authority(((Uri) (obj1)).getAuthority()).path((new StringBuilder()).append("/dispatch").append(((Uri) (obj1)).getPath().replace("/deals/", "/deal/")).toString()).query(((Uri) (obj1)).getQuery()).fragment(((Uri) (obj1)).getFragment()).build();
                        Ln.d("Rewriting facebook uri from %s to %s", new Object[] {
                            obj1, obj
                        });
                    } else
                    {
                        try
                        {
                            startActivity(new Intent("android.intent.action.VIEW", ((Uri) (obj1))));
                            finish();
                            return;
                        }
                        catch (Exception exception)
                        {
                            Ln.w(exception);
                        }
                        exception = ((Exception) (obj1));
                    }
                }
            }
            if (obj != null && deepLinkUtil.isDeepLink(((Uri) (obj)).toString()))
            {
                try
                {
                    ((DeepLinkManager)deepLinkManager.get()).followDeepLink(this, buildDeepLink(((Uri) (obj))));
                }
                catch (InvalidDeepLinkException invaliddeeplinkexception)
                {
                    startActivity(intentFactory.newCarouselIntent());
                }
                finish();
                return;
            } else
            {
                startActivity(intentFactory.newCarouselIntent());
                finish();
                return;
            }
        }
        invaliddeeplinkexception = (OnBoardingService)RoboGuice.getInjector(this).getInstance(com/groupon/service/OnBoardingService);
        if (((LoginService)RoboGuice.getInjector(this).getInstance(com/groupon/service/LoginService)).isLoggedIn() || !invaliddeeplinkexception.shouldShowOnBoarding())
        {
            startActivity(intentFactory.newCarouselIntent());
            finish();
            return;
        } else
        {
            ((Handler)handler.get()).post(new Runnable() {

                final Splash this$0;

                public void run()
                {
                    setupViews();
                    startExitToOnboardingAnimation();
                }

            
            {
                this$0 = Splash.this;
                super();
            }
            });
            return;
        }
    }

    protected DeepLinkData buildDeepLink(Uri uri)
        throws InvalidDeepLinkException
    {
        DeepLinkUtil deeplinkutil = deepLinkUtil;
        if (uri == null)
        {
            uri = "";
        } else
        {
            uri = uri.toString();
        }
        uri = deeplinkutil.getDeepLink(uri);
        if (Strings.notEmpty(uri.getParam("showDealDetail")))
        {
            uri.setAttributionType("wear_notification");
        }
        return uri;
    }

    protected Animator getEnterDivisionChooserAnimator()
    {
        float f = deviceInfoUtil.getDensity();
        float f1 = getResources().getDimension(0x7f0b0003);
        float f2 = getResources().getDimension(0x7f0b0004);
        float f3 = grouponLogo.getWidth();
        float f4 = getResources().getDimension(0x7f0b0027);
        Object obj;
        if (f4 / f != -2F)
        {
            f = f4 / f3;
        } else
        {
            f = 1.0F;
        }
        welcomeText.setAlpha(0.0F);
        welcomeText.setY(f2);
        obj = new AnimatorSet();
        ((AnimatorSet) (obj)).playTogether(new Animator[] {
            ObjectAnimator.ofFloat(grouponLogo, "y", new float[] {
                grouponLogo.getY(), f1
            }).setDuration(500L), ObjectAnimator.ofFloat(grouponLogo, "scaleX", new float[] {
                f
            }).setDuration(500L), ObjectAnimator.ofFloat(grouponLogo, "scaleY", new float[] {
                f
            }).setDuration(500L)
        });
        ((AnimatorSet) (obj)).setInterpolator(new AccelerateDecelerateInterpolator());
        ((AnimatorSet) (obj)).addListener(new AnimatorListenerAdapter() {

            final Splash this$0;

            public void onAnimationEnd(Animator animator)
            {
                ObjectAnimator.ofFloat(welcomeText, "alpha", new float[] {
                    0.0F, 1.0F
                }).setDuration(300L).start();
            }

            
            {
                this$0 = Splash.this;
                super();
            }
        });
        ((AnimatorSet) (obj)).start();
        f = bottomContainer.getY();
        obj = ObjectAnimator.ofFloat(bottomContainer, "y", new float[] {
            f, 0.0F
        });
        ((ObjectAnimator) (obj)).setDuration(600L);
        ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
        return ((Animator) (obj));
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1001 1001: default 20
    //                   1001 28;
           goto _L1 _L2
_L1:
        super.onActivityResult(i, j, intent);
_L4:
        return;
_L2:
        if (j == 0 && GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0)
        {
            Toast.makeText(this, 0x7f080199, 0).show();
            finish();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        checkIfColdStartDidAlreadyHappen();
        long l = System.currentTimeMillis();
        long l2 = SystemClock.elapsedRealtime();
        super.onCreate(bundle);
        long l3 = SystemClock.elapsedRealtime();
        kochavaProvider.initInstance();
        logger.logAppStartupAttempt("", l, Logger.NULL_NST_FIELD);
        dogfoodHelper.logStartupInformation();
        Ln.d("SplashOnCreateCall %d", new Object[] {
            Long.valueOf(l3 - l2)
        });
        if (prefs.getBoolean("shouldLogUpgrade", false))
        {
            GrouponApplication.startupContext.shouldLogUpgrade = true;
            prefs.edit().putBoolean("shouldLogUpgrade", false).apply();
        }
        Intent intent = getIntent();
        Object obj = intent.getData();
        if (obj != null && deepLinkUtil.isDeepLink(((Uri) (obj)).toString()))
        {
            String s;
            String s1;
            long l1;
            if (((Uri) (obj)).getQueryParameter("cid") == null)
            {
                bundle = "";
            } else
            {
                bundle = ((Uri) (obj)).getQueryParameter("cid");
            }
            if (((Uri) (obj)).getQueryParameter("grpn_l") == null)
            {
                s = "";
            } else
            {
                s = ((Uri) (obj)).getQueryParameter("grpn_l");
            }
            if (((Uri) (obj)).getQueryParameter("utm_medium") == null)
            {
                s1 = "";
            } else
            {
                s1 = ((Uri) (obj)).getQueryParameter("utm_medium");
            }
            obj = ((Uri) (obj)).toString();
            logger.logDeepLinking("", ((String) (obj)), bundle, s, s1, ((DeepLinkManager)deepLinkManager.get()).constructDeepLinkNSTExtraString(((String) (obj)), intent));
        }
        if (Ln.isDebugEnabled())
        {
            grouponOrmLiteHelper.checkTableAdded();
        }
        if (intent.hasExtra("referrer") && Strings.equals(intent.getStringExtra("referrer"), "local_notification"))
        {
            logger.logClick("{\"pushType\" : \"pull\"}", "push_notification_alert", "view", "");
        }
        l1 = SystemClock.elapsedRealtime();
        isPlayServiceAvailable = checkPlayServices();
        if (shouldLogStartupTime)
        {
            logger.logGeneralEvent("startup", "splash", "playServiceCheck", (int)(SystemClock.elapsedRealtime() - l1), Logger.NULL_NST_FIELD);
        }
        if (isPlayServiceAvailable)
        {
            onNewIntent(getIntent());
        }
    }

    protected void onCustomPostCreate(Bundle bundle)
    {
        splashUpgradeManagerListener = new SplashUpgradeManagerListenerImpl(bundle);
        startupDirector.addUpgradeManagerListener(splashUpgradeManagerListener);
        startupDirector.addCountryAndDivisionInitializerListener(splashCountryAndDivisionInitializerListener);
        startupDirector.addCoreServicesInitializerListener(splashServiceInitializerListener);
        startupDirector.startup();
    }

    public void onDestroy()
    {
        startupDirector.removeUpgradeManagerListener(splashUpgradeManagerListener);
        startupDirector.removeCountryAndDivisionInitializerListener(splashCountryAndDivisionInitializerListener);
        startupDirector.removeCoreServicesInitializerListener(splashServiceInitializerListener);
        if (wobbleSpaceshipCatView != null)
        {
            wobbleSpaceshipCatView.stopProgressAnimation();
            wobbleSpaceshipCatView.setVisibility(8);
        }
        super.onDestroy();
        isDestroyed.set(true);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Bundle bundle;
        if (android.os.Build.VERSION.SDK_INT >= 17 && intent.getBooleanExtra("dismissKeyguard", false))
        {
            getWindow().addFlags(0x400000);
        } else
        {
            getWindow().clearFlags(0x400000);
        }
        if (intent != null)
        {
            bundle = intent.getExtras();
        } else
        {
            bundle = null;
        }
        if (intent != null)
        {
            Bundle bundle1 = getIntent().getExtras();
            if (bundle1 != null && bundle1.containsKey("next") && (bundle == null || !bundle.containsKey("next")))
            {
                intent.putExtra("next", (Intent)(Intent)bundle1.get("next"));
            }
            setIntent(intent);
        }
        shouldShowCitiesSelector = true;
    }

    protected void onResume()
    {
        if (!isPlayServiceAvailable)
        {
            boolean flag;
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isPlayServiceAvailable = flag;
            if (isPlayServiceAvailable)
            {
                onNewIntent(getIntent());
            }
        }
        super.onResume();
        if (isPlayServiceAvailable)
        {
            startupDirector.addCountryAndDivisionInitializerListener(splashCountryAndDivisionInitializerListener);
            startupDirector.addCoreServicesInitializerListener(splashServiceInitializerListener);
            startupDirector.startupCountryAndDivisionInitializer();
        }
    }

    protected void setupViews()
    {
        if (isViewLoaded.get())
        {
            return;
        } else
        {
            isViewLoaded.set(true);
            overridePendingTransition(0x7f04000b, 0x7f04000c);
            setContentView(0x7f03020c);
            showGrouponLogoCentered();
            bottomContainer.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final Splash this$0;

                public void onGlobalLayout()
                {
                    bottomContainer.setY(cityImage.getHeight() + divisionChooser.getHeight() + continueButtonContainer.getHeight());
                    wobbleSpaceshipCatView.setVisibility(0);
                    wobbleSpaceshipCatView.loopProgressAnimation(100);
                    bottomContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

            
            {
                this$0 = Splash.this;
                super();
            }
            });
            return;
        }
    }













/*
    static boolean access$2202(Splash splash, boolean flag)
    {
        splash.shouldShowCitiesSelector = flag;
        return flag;
    }

*/












}
