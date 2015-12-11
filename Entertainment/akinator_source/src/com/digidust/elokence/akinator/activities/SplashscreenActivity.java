// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.digidust.elokence.akinator.activities.externalprocessing.SplashScreenProcessing;
import com.digidust.elokence.akinator.backup.AkBackupManager;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.exceptions.AkException;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkPushFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundMusicBinder;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.AnalyticsCenter;
import com.elokence.analytics.AnalyticsInitCallback;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import io.presage.Presage;
import io.presage.utils.IADHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, SelectLanguageActivity, HomeActivity

public class SplashscreenActivity extends AkActivity
    implements com.digidust.elokence.akinator.factories.AkPushFactory.AkPushFactoryListener, AnalyticsInitCallback
{

    private static final int NB_STEPS = 7;
    private static final String TAG = "SplashscreenActivity";
    static final Object sync = new Object();
    private boolean displayLangageSelection;
    private boolean doNoCheckGoToHome;
    private boolean externalProcessCompleted;
    private boolean firstPath;
    private boolean firstResume;
    private boolean getCentralWs;
    private int mCurrentStepPc;
    private boolean mDataBerriesInit;
    private ProgressBar mProgressBar;
    private boolean mStepFinished[] = {
        0, 0, 0, 0, 0, 0, 0
    };
    private TextView mTextOkExternalProcess;
    private TextView mTextOkMinimalDelay;
    private TextView mTextOkNewVersionChecked;
    private TextView mTextOkPresage;
    private TextView mTextOkPurchasesRestored;
    private TextView mTextOkTraduction;
    private TextView mTextOkWsCentral;
    private boolean minimalDelayDone;
    private boolean newVersionChecked;
    private boolean oguryReturned;
    private SplashScreenProcessing processing;
    private boolean purchasesRestored;
    private boolean pushInfoUpdated;
    private boolean traductionsLoaded;
    private ProgressBar uiLoadingBarGen;

    public SplashscreenActivity()
    {
        traductionsLoaded = false;
        getCentralWs = false;
        minimalDelayDone = false;
        newVersionChecked = true;
        externalProcessCompleted = false;
        purchasesRestored = false;
        pushInfoUpdated = false;
        oguryReturned = false;
        doNoCheckGoToHome = false;
        firstPath = true;
        displayLangageSelection = false;
        firstResume = true;
        mCurrentStepPc = 0;
        mDataBerriesInit = false;
        processing = new SplashScreenProcessing(this);
    }

    private void goToHomeScreen()
    {
        synchronized (sync)
        {
            AkLog.i("SplashscreenActivity", "goToHomeScreen");
            AkLog.d("SplashscreenActivity", (new StringBuilder()).append("traductionsLoaded: ").append(traductionsLoaded).toString());
            AkLog.d("SplashscreenActivity", (new StringBuilder()).append("centralWs: ").append(getCentralWs).toString());
            AkLog.d("SplashscreenActivity", (new StringBuilder()).append("minimalDelayDone : ").append(minimalDelayDone).toString());
            AkLog.d("SplashscreenActivity", (new StringBuilder()).append("purchasesRestored : ").append(purchasesRestored).toString());
            AkLog.d("SplashscreenActivity", (new StringBuilder()).append("newVersionChecked: ").append(newVersionChecked).toString());
            AkLog.d("SplashscreenActivity", (new StringBuilder()).append("pushInfoUpdated  : ").append(externalProcessCompleted).toString());
            AkLog.d("SplashscreenActivity", (new StringBuilder()).append("PresageOK  : ").append(oguryReturned).toString());
            runOnUiThread(new Runnable() {

                final SplashscreenActivity this$0;

                public void run()
                {
                    if (!doNoCheckGoToHome) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    if (traductionsLoaded || displayLangageSelection)
                    {
                        mTextOkTraduction.setVisibility(0);
                    }
                    if (minimalDelayDone)
                    {
                        mTextOkMinimalDelay.setVisibility(0);
                    }
                    if (newVersionChecked)
                    {
                        mTextOkNewVersionChecked.setVisibility(0);
                    }
                    if (externalProcessCompleted)
                    {
                        mTextOkExternalProcess.setVisibility(0);
                    }
                    if (purchasesRestored)
                    {
                        mTextOkPurchasesRestored.setVisibility(0);
                    }
                    if (getCentralWs)
                    {
                        mTextOkWsCentral.setVisibility(0);
                    }
                    if (oguryReturned)
                    {
                        mTextOkPresage.setVisibility(0);
                    }
                    if (!mStepFinished[0] && (traductionsLoaded || displayLangageSelection))
                    {
                        mStepFinished[0] = true;
                        mProgressBar.setProgress(int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }

                /* block-local class not found */
                class _cls1 {}

            });
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void showAlertNewVersion()
    {
        (new AsyncTask() {

            final SplashscreenActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                while (!traductionsLoaded) 
                {
                    try
                    {
                        Thread.sleep(10L);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[]) { }
                }
                return null;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                void1 = new Builder(SplashscreenActivity.this);
                void1.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("UNE_NOUVELLE_VERSION_EST_DISPONIBLE"));
            /* block-local class not found */
            class _cls1 {}

                void1.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"), new _cls1());
            /* block-local class not found */
            class _cls2 {}

                void1.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON_MERCI"), new _cls2());
                void1.create().show();
            }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }

    protected void initAnalytics()
    {
        AkLog.d("SplashscreenActivity", "InitAnalytics");
        byte byte0;
        if (AkConfigFactory.sharedInstance().isPaid())
        {
            byte0 = 2;
        } else
        if (AkGameFactory.sharedInstance().isUnlocked())
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        AnalyticsCenter.getInstance().addCampaign("MWcredits", "11,5;12,15;13,25;14,50");
        AnalyticsCenter.getInstance().addCampaign("MWtry", "10");
        AnalyticsCenter.getInstance().boot(AkApplication.getAppContext(), AkConfigFactory.sharedInstance().getApplication(), TraductionFactory.sharedInstance().getApplicationLanguage(), AkPushFactory.getInstance().getRegistrationId(getApplicationContext()), byte0, this);
    }

    public void itemPurchased(String s)
    {
    }

    public void logOuvertureAvecConditions()
    {
        String s = AkConfigFactory.sharedInstance().getVersionName();
        if (!AkConfigFactory.sharedInstance().isFirstLaunch()) goto _L2; else goto _L1
_L1:
        AkAnalyticsFactory.sharedInstance().logOuvertureApp(false);
_L4:
        AkConfigFactory.sharedInstance().setLastVersionPLayed(s);
        return;
_L2:
        String s1 = AkConfigFactory.sharedInstance().getLastVersionPLayed();
        AkLog.d("SplashscreenActivity", (new StringBuilder()).append("Compver : cur ").append(s).toString());
        AkLog.d("SplashscreenActivity", (new StringBuilder()).append("Compver : lst ").append(s1).toString());
        if (!s.equals(s1))
        {
            AkAnalyticsFactory.sharedInstance().logOuvertureApp(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onAllPurchasesRestored()
    {
        onAllPurchasesRestored();
        purchasesRestored = true;
        goToHomeScreen();
    }

    public void onAnalyticsInitError()
    {
        AkLog.d("SplashscreenActivity", "OnAnalyticsInitError");
        pushInfoUpdated = true;
        logOuvertureAvecConditions();
        AkAnalyticsFactory.sharedInstance().onAnalyticsInitError();
        onProcessCompleted();
    }

    public void onAnalyticsInitResponse()
    {
        AkLog.d("SplashscreenActivity", "OnAnalyticsInitResponse");
        pushInfoUpdated = true;
        logOuvertureAvecConditions();
        AkAnalyticsFactory.sharedInstance().onAnalyticsInitResponse();
        onProcessCompleted();
    }

    public void onBackPressed()
    {
    }

    public void onCreate(Bundle bundle)
    {
        onCreate(bundle);
        if (!isTaskRoot())
        {
            bundle = getIntent();
            if (bundle.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(bundle.getAction()))
            {
                AkLog.w("SplashscreenActivity", "Main Activity is not the root.  Finishing Main Activity instead of launching.");
                finish();
                return;
            }
        }
        if (getIntent().getBooleanExtra("closeApp", false))
        {
            finish();
            return;
        }
        AkConfigFactory.sharedInstance().setCanCheckFull(false);
        setContentView(0x7f030039);
        (new Thread(new Runnable() {

            final SplashscreenActivity this$0;

            public void run()
            {
                ActivityManager activitymanager = (ActivityManager)getSystemService("activity");
                AkSceneryFactory.sharedInstance().updateMaxMemory(activitymanager.getMemoryClass());
                AkLog.d("HomeActivity", (new StringBuilder()).append("Memory class : ").append(activitymanager.getMemoryClass()).toString());
                AkSceneryFactory.sharedInstance().initDefault(getScreenWidth());
            }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
        })).start();
        AkConfigFactory.sharedInstance().setIsTablet(isTablet());
        AkConfigFactory.sharedInstance();
        AkInappManager.getInstance().addListener(this);
        mProgressBar = (ProgressBar)findViewById(0x7f0d01c2);
        mProgressBar.setMax(7);
        mProgressBar.setProgress(0);
        AkPlayerBelongingsFactory.sharedInstance().setItemBought("hat", "turban");
        AkPlayerBelongingsFactory.sharedInstance().setItemBought("cloth", "orient");
        AkPlayerBelongingsFactory.sharedInstance().setItemBought("cloth", "yukata");
        AkPlayerBelongingsFactory.sharedInstance().setItemBought("bg", "orient");
        AkPlayerBelongingsFactory.sharedInstance().setItemBought("bg", "japon");
        mTextOkMinimalDelay = (TextView)findViewById(0x7f0d01bb);
        mTextOkNewVersionChecked = (TextView)findViewById(0x7f0d01bc);
        mTextOkPurchasesRestored = (TextView)findViewById(0x7f0d01bd);
        mTextOkWsCentral = (TextView)findViewById(0x7f0d01be);
        mTextOkTraduction = (TextView)findViewById(0x7f0d01bf);
        mTextOkExternalProcess = (TextView)findViewById(0x7f0d01c0);
        mTextOkPresage = (TextView)findViewById(0x7f0d01c1);
        uiLoadingBarGen = (ProgressBar)findViewById(0x7f0d01b9);
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.FULL_MUSIC;
        AkLog.w("SplashscreenActivity", "Lancement du Splashscreen");
        String s;
        boolean flag;
        try
        {
            AkConfigFactory.sharedInstance().setVersionName(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            AkLog.d("SplashscreenActivity", "Version name not found. Hardcoding.");
            AkConfigFactory.sharedInstance().setVersionName("4.0");
        }
        bundle = TraductionFactory.sharedInstance().getApplicationLanguage();
        s = AkConfigFactory.sharedInstance().getPhoneLang();
        if (bundle == null || !s.equals(AkConfigFactory.transFormLang(Locale.getDefault().getLanguage())) && !AkConfigFactory.sharedInstance().hasAlreadyChangeLangManually())
        {
            AkConfigFactory.sharedInstance().setFirstLaunch(true);
            AkConfigFactory.sharedInstance().setPhoneLang(AkConfigFactory.transFormLang(Locale.getDefault().getLanguage()));
        }
        if (bundle == null || AkConfigFactory.sharedInstance().isFirstLaunch())
        {
            AkBackupManager.getInstance().restoreBackup();
        }
        MinibaseFactory.sharedInstance().unload();
        if (AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked() && AkGameFactory.sharedInstance().areAdsEnabled() && AkConfigFactory.sharedInstance().isOguryEnabled())
        {
            AkLog.d("AkinatorOgury", "Presage init");
            Presage.getInstance().setContext(getBaseContext());
            Presage.getInstance().start();
        } else
        {
            oguryReturned = true;
        }
        if (AkConfigFactory.sharedInstance().isFirstLaunch())
        {
            (new Thread(new Runnable() {

                final SplashscreenActivity this$0;

                public void run()
                {
                    int i;
label0:
                    {
                        Object obj = new ArrayList();
                        if (TraductionFactory.sharedInstance().createTraductionFactory(((ArrayList) (obj))) == 0)
                        {
                            boolean flag2 = false;
                            obj = ((ArrayList) (obj)).iterator();
                            boolean flag1;
                            do
                            {
                                flag1 = flag2;
                                if (!((Iterator) (obj)).hasNext())
                                {
                                    break;
                                }
                                com.elokence.limuleapi.TraductionFactory.Language language = (com.elokence.limuleapi.TraductionFactory.Language)((Iterator) (obj)).next();
                                if (!language.getCode().equals(Locale.getDefault().getLanguage()))
                                {
                                    continue;
                                }
                                TraductionFactory.sharedInstance().setApplicationLanguage(language.getCode());
                                flag1 = true;
                                AkApplication.setCoeffFont(Float.parseFloat(language.getFontCoeffAndroid()));
                                break;
                            } while (true);
                            traductionsLoaded = flag1;
                            if (!traductionsLoaded)
                            {
                                displayLangageSelection = true;
                            }
                            i = getScreenWidth() / 2;
                            flag1 = AkConfigFactory.sharedInstance().isPrio();
                            SessionFactory sessionfactory = SessionFactory.sharedInstance();
                            flag2 = AkConfigFactory.sharedInstance().isChildProtectEnabled();
                            int j = AkConfigFactory.sharedInstance().getPartnerId(isTablet());
                            int k = Integer.parseInt(AkConfigFactory.sharedInstance().getMediaId());
                            String s1 = AkConfigFactory.sharedInstance().getMediaFootprint();
                            if (traductionsLoaded)
                            {
                                obj = TraductionFactory.sharedInstance().getApplicationLanguage();
                            } else
                            {
                                obj = "en";
                            }
                            i = sessionfactory.createSessionFactory(flag2, j, k, s1, ((String) (obj)), 1, flag1, flag1, flag1, (i * 16) / 9, i);
                            if (i != 0)
                            {
                                break label0;
                            }
                            if (AkConfigFactory.sharedInstance().getMaxRanking() < 3)
                            {
                                AkConfigFactory.sharedInstance().setMaxRanking(50000);
                            }
                            AkConfigFactory.sharedInstance().setOriginalMaxRanking(0x7a120);
                            traductionsLoaded = true;
                            getCentralWs = true;
                            goToHomeScreen();
                        }
                        return;
                    }
                    if (i == 500 || i == 510)
                    {
                        if (i == 500)
                        {
                            AkConfigFactory.sharedInstance().setCanPlay(-1);
                        } else
                        {
                            AkConfigFactory.sharedInstance().setCanPlay(0);
                        }
                        traductionsLoaded = true;
                        getCentralWs = true;
                        goToHomeScreen();
                        return;
                    } else
                    {
                /* block-local class not found */
                class _cls1 {}

                        runOnUiThread(new _cls1());
                        return;
                    }
                }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
            })).start();
        } else
        {
            traductionsLoaded = true;
            (new Thread(new Runnable() {

                final SplashscreenActivity this$0;

                public void run()
                {
label0:
                    {
                        Object obj = new ArrayList();
                        if (TraductionFactory.sharedInstance().createTraductionFactory(((ArrayList) (obj))) != 0)
                        {
                            break label0;
                        }
                        obj = ((ArrayList) (obj)).iterator();
                        com.elokence.limuleapi.TraductionFactory.Language language;
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break label0;
                            }
                            language = (com.elokence.limuleapi.TraductionFactory.Language)((Iterator) (obj)).next();
                        } while (!language.getCode().equals(TraductionFactory.sharedInstance().getApplicationLanguage()));
                        TraductionFactory.sharedInstance().setApplicationLanguage(language.getCode());
                        AkApplication.setCoeffFont(Float.parseFloat(language.getFontCoeffAndroid()));
                    }
                }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
            })).start();
            (new Thread(new Runnable() {

                final SplashscreenActivity this$0;

                public void run()
                {
                    int i = getScreenWidth() / 2;
                    boolean flag1 = AkConfigFactory.sharedInstance().isPrio();
                    i = SessionFactory.sharedInstance().createSessionFactory(AkConfigFactory.sharedInstance().isChildProtectEnabled(), AkConfigFactory.sharedInstance().getPartnerId(isTablet()), Integer.parseInt(AkConfigFactory.sharedInstance().getMediaId()), AkConfigFactory.sharedInstance().getMediaFootprint(), TraductionFactory.sharedInstance().getApplicationLanguage(), 1, flag1, flag1, flag1, (i * 16) / 9, i);
                    if (i == 0)
                    {
                        int j = SessionFactory.sharedInstance().getRankingLimit();
                        i = j;
                        if (j < 500)
                        {
                            i = 500;
                        }
                        j = i;
                        if (i > 10000)
                        {
                            j = 10000;
                        }
                        if (AkConfigFactory.sharedInstance().getMaxRanking() < 3)
                        {
                            AkConfigFactory.sharedInstance().setMaxRanking(j * 10);
                        }
                        AkConfigFactory.sharedInstance().setOriginalMaxRanking(j * 100);
                        getCentralWs = true;
                        goToHomeScreen();
                        return;
                    }
                    if (i == 500 || i == 510)
                    {
                        if (i == 500)
                        {
                            AkConfigFactory.sharedInstance().setCanPlay(-1);
                        } else
                        {
                            AkConfigFactory.sharedInstance().setCanPlay(0);
                        }
                        getCentralWs = true;
                        goToHomeScreen();
                        return;
                    } else
                    {
                /* block-local class not found */
                class _cls1 {}

                        runOnUiThread(new _cls1());
                        return;
                    }
                }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
            })).start();
        }
        try
        {
            AkPushFactory.getInstance().setListener(this);
            flag = AkPushFactory.getInstance().checkGCMStatus();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            flag = true;
        }
        if (flag)
        {
            initAnalytics();
            pushInfoUpdated = true;
        }
        BackgroundMusicBinder.sharedInstance();
        BackgroundSoundsBinder.sharedInstance();
        AkLog.w("SplashscreenActivity", "Splashscreen lanc\351");
        (new Thread(new Runnable() {

            final SplashscreenActivity this$0;

            public void run()
            {
                AkInappManager.getInstance().init();
            }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
        })).start();
        if (AkConfigFactory.sharedInstance().isFreemium())
        {
            mDataBerriesInit = processing.initDataBerries();
        } else
        {
            mDataBerriesInit = true;
        }
        (new Timer()).schedule(new TimerTask() {

            final SplashscreenActivity this$0;

            public void run()
            {
                minimalDelayDone = true;
                goToHomeScreen();
            }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
        }, 2000L);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void onInitialization(final boolean initOK)
    {
        if (!purchasesRestored)
        {
            (new Thread(new Runnable() {

                final SplashscreenActivity this$0;
                final boolean val$initOK;

                public void run()
                {
                    if (initOK)
                    {
                        AkInappManager.getInstance().requestInappDetailsUpdate();
                        AkInappManager.getInstance().requestAllPurchases();
                        return;
                    } else
                    {
                /* block-local class not found */
                class _cls1 {}

                        runOnUiThread(new _cls1());
                        return;
                    }
                }

            
            {
                this$0 = SplashscreenActivity.this;
                initOK = flag;
                super();
            }
            })).start();
        }
    }

    protected void onPause()
    {
        super.onPause();
        doNoCheckGoToHome = true;
    }

    public void onProcessCompleted()
    {
        externalProcessCompleted = true;
        goToHomeScreen();
    }

    public void onPushRegistrationComplete()
    {
        initAnalytics();
    }

    public void onPushRegistrationFailed()
    {
        initAnalytics();
    }

    public void onRequestPermissionsResult(int i, String as[], int ai[])
    {
        processing.initDataBerriesPermissions(i, as, ai);
        mDataBerriesInit = true;
        goToHomeScreen();
    }

    public void onResume()
    {
        super.onResume();
        doNoCheckGoToHome = false;
        if (firstResume && AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked() && AkGameFactory.sharedInstance().areAdsEnabled() && AkConfigFactory.sharedInstance().isOguryEnabled())
        {
            AkLog.d("AkinatorOgury", "Presage launch");
            Presage.getInstance().adToServe("interstitial", new IADHandler() {

                final SplashscreenActivity this$0;

                public void onAdClosed()
                {
                    oguryReturned = true;
                /* block-local class not found */
                class _cls2 {}

                    runOnUiThread(new _cls2());
                    Log.i("PRESAGE", "ad closed");
                }

                public void onAdFound()
                {
                    Log.i("PRESAGE", "ad found");
                }

                public void onAdNotFound()
                {
                    Log.i("PRESAGE", "ad not found");
                    oguryReturned = true;
                /* block-local class not found */
                class _cls1 {}

                    runOnUiThread(new _cls1());
                }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
            });
        } else
        {
            oguryReturned = true;
        }
        firstResume = false;
        if (AkInappManager.getInstance().isInit() && !purchasesRestored)
        {
            (new Thread(new Runnable() {

                final SplashscreenActivity this$0;

                public void run()
                {
                    AkInappManager.getInstance().requestInappDetailsUpdate();
                    AkInappManager.getInstance().requestAllPurchases();
                }

            
            {
                this$0 = SplashscreenActivity.this;
                super();
            }
            })).start();
        }
        goToHomeScreen();
    }

    public void skuDetailsUpdated()
    {
    }




/*
    static boolean access$002(SplashscreenActivity splashscreenactivity, boolean flag)
    {
        splashscreenactivity.traductionsLoaded = flag;
        return flag;
    }

*/




/*
    static boolean access$102(SplashscreenActivity splashscreenactivity, boolean flag)
    {
        splashscreenactivity.displayLangageSelection = flag;
        return flag;
    }

*/




/*
    static boolean access$1202(SplashscreenActivity splashscreenactivity, boolean flag)
    {
        splashscreenactivity.purchasesRestored = flag;
        return flag;
    }

*/





/*
    static boolean access$1502(SplashscreenActivity splashscreenactivity, boolean flag)
    {
        splashscreenactivity.oguryReturned = flag;
        return flag;
    }

*/




/*
    static int access$1804(SplashscreenActivity splashscreenactivity)
    {
        int i = splashscreenactivity.mCurrentStepPc + 1;
        splashscreenactivity.mCurrentStepPc = i;
        return i;
    }

*/





/*
    static boolean access$202(SplashscreenActivity splashscreenactivity, boolean flag)
    {
        splashscreenactivity.getCentralWs = flag;
        return flag;
    }

*/




/*
    static boolean access$402(SplashscreenActivity splashscreenactivity, boolean flag)
    {
        splashscreenactivity.minimalDelayDone = flag;
        return flag;
    }

*/



/*
    static boolean access$502(SplashscreenActivity splashscreenactivity, boolean flag)
    {
        splashscreenactivity.doNoCheckGoToHome = flag;
        return flag;
    }

*/





/*
    static boolean access$802(SplashscreenActivity splashscreenactivity, boolean flag)
    {
        splashscreenactivity.newVersionChecked = flag;
        return flag;
    }

*/

}
