// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.v7.alt;
import android.support.v7.alz;
import android.support.v7.amc;
import android.support.v7.amo;
import android.support.v7.amq;
import android.support.v7.amv;
import android.support.v7.amw;
import android.support.v7.ang;
import android.support.v7.ani;
import android.support.v7.ann;
import android.support.v7.ano;
import android.support.v7.aoi;
import android.support.v7.aoj;
import android.support.v7.aok;
import android.support.v7.aol;
import android.support.v7.aor;
import android.support.v7.aos;
import android.support.v7.aot;
import android.support.v7.aoy;
import android.support.v7.apg;
import android.support.v7.api;
import android.support.v7.apj;
import android.support.v7.apk;
import android.support.v7.apn;
import android.util.DisplayMetrics;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsExecutorServiceWrapper, CrashlyticsUncaughtExceptionHandler, DialogStringResolver, CrashlyticsPinningInfoProvider, 
//            BuildIdValidator, CrashTest, ReportUploader, DefaultCreateReportSpiCall, 
//            CrashlyticsMissingDependencyException, SessionDataWriter, CrashlyticsListener, PinningInfoProvider, 
//            CreateReportSpiCall

public class CrashlyticsCore extends alz
{
    public static class Builder
    {

        private float delay;
        private boolean disabled;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public CrashlyticsCore build()
        {
            if (delay < 0.0F)
            {
                delay = 1.0F;
            }
            return new CrashlyticsCore(delay, listener, pinningInfoProvider, disabled);
        }

        public Builder delay(float f)
        {
            if (f <= 0.0F)
            {
                throw new IllegalArgumentException("delay must be greater than 0");
            }
            if (delay > 0.0F)
            {
                throw new IllegalStateException("delay already set.");
            } else
            {
                delay = f;
                return this;
            }
        }

        public Builder disabled(boolean flag)
        {
            disabled = flag;
            return this;
        }

        public Builder listener(CrashlyticsListener crashlyticslistener)
        {
            if (crashlyticslistener == null)
            {
                throw new IllegalArgumentException("listener must not be null.");
            }
            if (listener != null)
            {
                throw new IllegalStateException("listener already set.");
            } else
            {
                listener = crashlyticslistener;
                return this;
            }
        }

        public Builder pinningInfo(PinningInfoProvider pinninginfoprovider)
        {
            if (pinninginfoprovider == null)
            {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            }
            if (pinningInfoProvider != null)
            {
                throw new IllegalStateException("pinningInfoProvider already set.");
            } else
            {
                pinningInfoProvider = pinninginfoprovider;
                return this;
            }
        }

        public Builder()
        {
            delay = -1F;
            disabled = false;
        }
    }

    private class OptInLatch
    {

        private final CountDownLatch latch;
        private boolean send;
        final CrashlyticsCore this$0;

        void await()
        {
            try
            {
                latch.await();
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
        }

        boolean getOptIn()
        {
            return send;
        }

        void setOptIn(boolean flag)
        {
            send = flag;
            latch.countDown();
        }

        private OptInLatch()
        {
            this$0 = CrashlyticsCore.this;
            super();
            send = false;
            latch = new CountDownLatch(1);
        }

    }


    static final float CLS_DEFAULT_PROCESS_DELAY = 1F;
    static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    public static final String TAG = "CrashlyticsCore";
    private final ConcurrentHashMap attributes;
    private String buildId;
    private float delay;
    private boolean disabled;
    private CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private CrashEventDataProvider externalCrashEventDataProvider;
    private CrashlyticsUncaughtExceptionHandler handler;
    private aol httpRequestFactory;
    private File initializationMarkerFile;
    private String installerPackageName;
    private CrashlyticsListener listener;
    private String packageName;
    private final PinningInfoProvider pinningInfo;
    private File sdkDir;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;
    private String versionCode;
    private String versionName;

    public CrashlyticsCore()
    {
        this(1.0F, null, null, false);
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticslistener, PinningInfoProvider pinninginfoprovider, boolean flag)
    {
        this(f, crashlyticslistener, pinninginfoprovider, flag, amv.a("Crashlytics Exception Handler"));
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticslistener, PinningInfoProvider pinninginfoprovider, boolean flag, ExecutorService executorservice)
    {
        userId = null;
        userEmail = null;
        userName = null;
        attributes = new ConcurrentHashMap();
        startTime = System.currentTimeMillis();
        delay = f;
        listener = crashlyticslistener;
        pinningInfo = pinninginfoprovider;
        disabled = flag;
        executorServiceWrapper = new CrashlyticsExecutorServiceWrapper(executorservice);
    }

    private int dipsToPixels(float f, int i)
    {
        return (int)((float)i * f);
    }

    private void doLog(int i, String s, String s1)
    {
        while (disabled || !ensureFabricWithCalled("prior to logging messages.")) 
        {
            return;
        }
        long l = System.currentTimeMillis();
        long l1 = startTime;
        handler.writeToLog(l - l1, formatLogMessage(i, s, s1));
    }

    private static boolean ensureFabricWithCalled(String s)
    {
        CrashlyticsCore crashlyticscore = getInstance();
        if (crashlyticscore == null || crashlyticscore.handler == null)
        {
            alt.h().e("CrashlyticsCore", (new StringBuilder()).append("Crashlytics must be initialized by calling Fabric.with(Context) ").append(s).toString(), null);
            return false;
        } else
        {
            return true;
        }
    }

    private void finishInitSynchronously()
    {
        Object obj = new ani() {

            final CrashlyticsCore this$0;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                return doInBackground();
            }

            public ang getPriority()
            {
                return ang.d;
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        };
        for (Iterator iterator = getDependencies().iterator(); iterator.hasNext(); ((ani) (obj)).addDependency((ann)iterator.next())) { }
        obj = getFabric().f().submit(((Callable) (obj)));
        alt.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try
        {
            ((Future) (obj)).get(4L, TimeUnit.SECONDS);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            alt.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            alt.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", executionexception);
            return;
        }
        catch (TimeoutException timeoutexception)
        {
            alt.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", timeoutexception);
        }
    }

    private static String formatLogMessage(int i, String s, String s1)
    {
        return (new StringBuilder()).append(amq.b(i)).append("/").append(s).append(" ").append(s1).toString();
    }

    public static CrashlyticsCore getInstance()
    {
        return (CrashlyticsCore)alt.a(com/crashlytics/android/core/CrashlyticsCore);
    }

    private boolean getSendDecisionFromUser(final Activity activity, final api promptData)
    {
        final DialogStringResolver stringResolver = new DialogStringResolver(activity, promptData);
        final OptInLatch latch = new OptInLatch();
        activity.runOnUiThread(new Runnable() {

            final CrashlyticsCore this$0;
            final Activity val$activity;
            final OptInLatch val$latch;
            final api val$promptData;
            final DialogStringResolver val$stringResolver;

            public void run()
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
                android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                    final _cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        latch.setOptIn(true);
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                };
                float f = activity.getResources().getDisplayMetrics().density;
                int i = dipsToPixels(f, 5);
                TextView textview = new TextView(activity);
                textview.setAutoLinkMask(15);
                textview.setText(stringResolver.getMessage());
                textview.setTextAppearance(activity, 0x1030044);
                textview.setPadding(i, i, i, i);
                textview.setFocusable(false);
                ScrollView scrollview = new ScrollView(activity);
                scrollview.setPadding(dipsToPixels(f, 14), dipsToPixels(f, 2), dipsToPixels(f, 10), dipsToPixels(f, 12));
                scrollview.addView(textview);
                builder.setView(scrollview).setTitle(stringResolver.getTitle()).setCancelable(false).setNeutralButton(stringResolver.getSendButtonTitle(), onclicklistener);
                if (promptData.d)
                {
                    android.content.DialogInterface.OnClickListener onclicklistener1 = new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            latch.setOptIn(false);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    };
                    builder.setNegativeButton(stringResolver.getCancelButtonTitle(), onclicklistener1);
                }
                if (promptData.f)
                {
                    android.content.DialogInterface.OnClickListener onclicklistener2 = new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            setShouldSendUserReportsWithoutPrompting(true);
                            latch.setOptIn(true);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    };
                    builder.setPositiveButton(stringResolver.getAlwaysSendButtonTitle(), onclicklistener2);
                }
                builder.show();
            }

            
            {
                this$0 = CrashlyticsCore.this;
                activity = activity1;
                latch = optinlatch;
                stringResolver = dialogstringresolver;
                promptData = api1;
                super();
            }
        });
        alt.h().a("CrashlyticsCore", "Waiting for user opt-in.");
        latch.await();
        return latch.getOptIn();
    }

    private boolean isRequiringBuildId(Context context)
    {
        return amq.a(context, "com.crashlytics.RequireBuildId", true);
    }

    static void recordFatalExceptionEvent(String s)
    {
        Answers answers = (Answers)alt.a(com/crashlytics/android/answers/Answers);
        if (answers != null)
        {
            answers.onException(new android.support.v7.amr.a(s));
        }
    }

    static void recordLoggedExceptionEvent(String s)
    {
        Answers answers = (Answers)alt.a(com/crashlytics/android/answers/Answers);
        if (answers != null)
        {
            answers.onException(new android.support.v7.amr.b(s));
        }
    }

    private static String sanitizeAttribute(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s = s.trim();
            s1 = s;
            if (s.length() > 1024)
            {
                s1 = s.substring(0, 1024);
            }
        }
        return s1;
    }

    private void setAndValidateKitProperties(Context context, String s)
    {
        Object obj;
        if (pinningInfo != null)
        {
            obj = new CrashlyticsPinningInfoProvider(pinningInfo);
        } else
        {
            obj = null;
        }
        httpRequestFactory = new aoi(alt.h());
        httpRequestFactory.a(((android.support.v7.aon) (obj)));
        packageName = context.getPackageName();
        installerPackageName = getIdManager().h();
        alt.h().a("CrashlyticsCore", (new StringBuilder()).append("Installer package name is: ").append(installerPackageName).toString());
        obj = context.getPackageManager().getPackageInfo(packageName, 0);
        versionCode = Integer.toString(((PackageInfo) (obj)).versionCode);
        if (((PackageInfo) (obj)).versionName != null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj = "0.0";
_L1:
        try
        {
            versionName = ((String) (obj));
            buildId = amq.m(context);
        }
        catch (Exception exception)
        {
            alt.h().e("CrashlyticsCore", "Error setting up app properties", exception);
        }
        getIdManager().o();
        getBuildIdValidator(buildId, isRequiringBuildId(context)).validate(s, packageName);
        return;
        obj = ((PackageInfo) (obj)).versionName;
          goto _L1
    }

    boolean canSendWithUserApproval()
    {
        return ((Boolean)apk.a().a(new android.support.v7.apk.b() {

            final CrashlyticsCore this$0;

            public Boolean usingSettings(apn apn1)
            {
                boolean flag1 = true;
                Activity activity = getFabric().b();
                boolean flag = flag1;
                if (activity != null)
                {
                    flag = flag1;
                    if (!activity.isFinishing())
                    {
                        flag = flag1;
                        if (shouldPromptUserBeforeSendingCrashReports())
                        {
                            flag = getSendDecisionFromUser(activity, apn1.c);
                        }
                    }
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object usingSettings(apn apn1)
            {
                return usingSettings(apn1);
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        }, Boolean.valueOf(true))).booleanValue();
    }

    public void crash()
    {
        (new CrashTest()).indexOutOfBounds();
    }

    boolean didPreviousInitializationComplete()
    {
        return ((Boolean)executorServiceWrapper.executeSyncLoggingException(new Callable() {

            final CrashlyticsCore this$0;

            public Boolean call()
                throws Exception
            {
                return Boolean.valueOf(initializationMarkerFile.exists());
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        })).booleanValue();
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    protected Void doInBackground()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        markInitializationStarted();
        handler.cleanInvalidTempFiles();
        flag2 = true;
        flag1 = true;
        flag = flag2;
        Object obj = apk.a().b();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        flag = flag2;
        alt.h().d("CrashlyticsCore", "Received null settings, skipping initialization!");
        markInitializationComplete();
        return null;
        flag = flag2;
        if (!((apn) (obj)).d.c) goto _L2; else goto _L1
_L1:
        flag2 = false;
        flag1 = false;
        flag = flag2;
        handler.finalizeSessions();
        flag = flag2;
        obj = getCreateReportSpiCall(((apn) (obj)));
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        (new ReportUploader(((CreateReportSpiCall) (obj)))).uploadReports(delay);
_L2:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        alt.h().a("CrashlyticsCore", "Crash reporting disabled.");
        markInitializationComplete();
        return null;
_L4:
        flag = flag2;
        alt.h().d("CrashlyticsCore", "Unable to create a call to upload reports.");
          goto _L2
        Object obj1;
        obj1;
        alt.h().e("CrashlyticsCore", "Error dealing with settings", ((Throwable) (obj1)));
        flag1 = flag;
          goto _L2
        obj1;
        alt.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", ((Throwable) (obj1)));
        markInitializationComplete();
        return null;
        obj1;
        markInitializationComplete();
        throw obj1;
    }

    Map getAttributes()
    {
        return Collections.unmodifiableMap(attributes);
    }

    String getBuildId()
    {
        return buildId;
    }

    BuildIdValidator getBuildIdValidator(String s, boolean flag)
    {
        return new BuildIdValidator(s, flag);
    }

    CreateReportSpiCall getCreateReportSpiCall(apn apn1)
    {
        if (apn1 != null)
        {
            return new DefaultCreateReportSpiCall(this, getOverridenSpiEndpoint(), apn1.a.d, httpRequestFactory);
        } else
        {
            return null;
        }
    }

    SessionEventData getExternalCrashEventData()
    {
        SessionEventData sessioneventdata = null;
        if (externalCrashEventDataProvider != null)
        {
            sessioneventdata = externalCrashEventDataProvider.getCrashEventData();
        }
        return sessioneventdata;
    }

    CrashlyticsUncaughtExceptionHandler getHandler()
    {
        return handler;
    }

    public String getIdentifier()
    {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    String getInstallerPackageName()
    {
        return installerPackageName;
    }

    String getOverridenSpiEndpoint()
    {
        return amq.b(getContext(), "com.crashlytics.ApiEndpoint");
    }

    String getPackageName()
    {
        return packageName;
    }

    public PinningInfoProvider getPinningInfoProvider()
    {
        if (!disabled)
        {
            return pinningInfo;
        } else
        {
            return null;
        }
    }

    File getSdkDirectory()
    {
        if (sdkDir == null)
        {
            sdkDir = (new aor(this)).a();
        }
        return sdkDir;
    }

    apj getSessionSettingsData()
    {
        apn apn1 = apk.a().b();
        if (apn1 == null)
        {
            return null;
        } else
        {
            return apn1.b;
        }
    }

    String getUserEmail()
    {
        if (getIdManager().a())
        {
            return userEmail;
        } else
        {
            return null;
        }
    }

    String getUserIdentifier()
    {
        if (getIdManager().a())
        {
            return userId;
        } else
        {
            return null;
        }
    }

    String getUserName()
    {
        if (getIdManager().a())
        {
            return userName;
        } else
        {
            return null;
        }
    }

    public String getVersion()
    {
        return "2.3.5.79";
    }

    String getVersionCode()
    {
        return versionCode;
    }

    String getVersionName()
    {
        return versionName;
    }

    boolean internalVerifyPinning(URL url)
    {
        if (getPinningInfoProvider() != null)
        {
            url = httpRequestFactory.a(aoj.a, url.toString());
            ((HttpsURLConnection)url.a()).setInstanceFollowRedirects(false);
            url.b();
            return true;
        } else
        {
            return false;
        }
    }

    public void log(int i, String s, String s1)
    {
        doLog(i, s, s1);
        alt.h().a(i, (new StringBuilder()).append("").append(s).toString(), (new StringBuilder()).append("").append(s1).toString(), true);
    }

    public void log(String s)
    {
        doLog(3, "CrashlyticsCore", s);
    }

    public void logException(Throwable throwable)
    {
        while (disabled || !ensureFabricWithCalled("prior to logging exceptions.")) 
        {
            return;
        }
        if (throwable == null)
        {
            alt.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
            return;
        } else
        {
            handler.writeNonFatalException(Thread.currentThread(), throwable);
            return;
        }
    }

    void markInitializationComplete()
    {
        executorServiceWrapper.executeAsync(new Callable() {

            final CrashlyticsCore this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                try
                {
                    flag = initializationMarkerFile.delete();
                    alt.h().a("CrashlyticsCore", (new StringBuilder()).append("Initialization marker file removed: ").append(flag).toString());
                }
                catch (Exception exception)
                {
                    alt.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", exception);
                    return Boolean.valueOf(false);
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        });
    }

    void markInitializationStarted()
    {
        executorServiceWrapper.executeSyncLoggingException(new Callable() {

            final CrashlyticsCore this$0;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                initializationMarkerFile.createNewFile();
                alt.h().a("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        });
    }

    protected boolean onPreExecute()
    {
        return onPreExecute(super.getContext());
    }

    boolean onPreExecute(Context context)
    {
        Object obj;
        if (disabled)
        {
            return false;
        }
        obj = (new amo()).a(context);
        if (obj == null)
        {
            return false;
        }
        alt.h().c("CrashlyticsCore", (new StringBuilder()).append("Initializing Crashlytics ").append(getVersion()).toString());
        initializationMarkerFile = new File(getSdkDirectory(), "initialization_marker");
        Exception exception;
        boolean flag;
        try
        {
            setAndValidateKitProperties(context, ((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            alt.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", context);
            return false;
        }
        obj = new SessionDataWriter(getContext(), buildId, getPackageName());
        alt.h().a("CrashlyticsCore", "Installing exception handler...");
        handler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), listener, executorServiceWrapper, getIdManager(), ((SessionDataWriter) (obj)), this);
        flag = didPreviousInitializationComplete();
        handler.openSession();
        Thread.setDefaultUncaughtExceptionHandler(handler);
        alt.h().a("CrashlyticsCore", "Successfully installed exception handler.");
_L2:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!amq.n(context))
        {
            break; /* Loop/switch isn't completed */
        }
        finishInitSynchronously();
        return false;
_L3:
        alt.h().e("CrashlyticsCore", "There was a problem installing the exception handler.", exception);
        if (true) goto _L2; else goto _L1
        context;
        throw new ano(context);
_L1:
        return true;
        exception;
          goto _L3
        exception;
        flag = false;
          goto _L3
    }

    public void setBool(String s, boolean flag)
    {
        setString(s, Boolean.toString(flag));
    }

    public void setDouble(String s, double d)
    {
        setString(s, Double.toString(d));
    }

    void setExternalCrashEventDataProvider(CrashEventDataProvider crasheventdataprovider)
    {
        externalCrashEventDataProvider = crasheventdataprovider;
    }

    public void setFloat(String s, float f)
    {
        setString(s, Float.toString(f));
    }

    public void setInt(String s, int i)
    {
        setString(s, Integer.toString(i));
    }

    public void setListener(CrashlyticsListener crashlyticslistener)
    {
        this;
        JVM INSTR monitorenter ;
        alt.h().d("CrashlyticsCore", "Use of setListener is deprecated.");
        if (crashlyticslistener != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        throw new IllegalArgumentException("listener must not be null.");
        crashlyticslistener;
        this;
        JVM INSTR monitorexit ;
        throw crashlyticslistener;
        listener = crashlyticslistener;
        this;
        JVM INSTR monitorexit ;
    }

    public void setLong(String s, long l)
    {
        setString(s, Long.toString(l));
    }

    void setShouldSendUserReportsWithoutPrompting(boolean flag)
    {
        aot aot1 = new aot(this);
        aot1.a(aot1.b().putBoolean("always_send_reports_opt_in", flag));
    }

    public void setString(String s, String s1)
    {
        if (disabled)
        {
            return;
        }
        if (s == null)
        {
            if (getContext() != null && amq.i(getContext()))
            {
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            } else
            {
                alt.h().e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
        }
        String s2 = sanitizeAttribute(s);
        if (attributes.size() < 64 || attributes.containsKey(s2))
        {
            if (s1 == null)
            {
                s = "";
            } else
            {
                s = sanitizeAttribute(s1);
            }
            attributes.put(s2, s);
            handler.cacheKeyData(attributes);
            return;
        } else
        {
            alt.h().a("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
            return;
        }
    }

    public void setUserEmail(String s)
    {
        if (disabled)
        {
            return;
        } else
        {
            userEmail = sanitizeAttribute(s);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    public void setUserIdentifier(String s)
    {
        if (disabled)
        {
            return;
        } else
        {
            userId = sanitizeAttribute(s);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    public void setUserName(String s)
    {
        if (disabled)
        {
            return;
        } else
        {
            userName = sanitizeAttribute(s);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    boolean shouldPromptUserBeforeSendingCrashReports()
    {
        return ((Boolean)apk.a().a(new android.support.v7.apk.b() {

            final CrashlyticsCore this$0;

            public Boolean usingSettings(apn apn1)
            {
                boolean flag = false;
                if (apn1.d.a)
                {
                    if (!shouldSendReportsWithoutPrompting())
                    {
                        flag = true;
                    }
                    return Boolean.valueOf(flag);
                } else
                {
                    return Boolean.valueOf(false);
                }
            }

            public volatile Object usingSettings(apn apn1)
            {
                return usingSettings(apn1);
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        }, Boolean.valueOf(false))).booleanValue();
    }

    boolean shouldSendReportsWithoutPrompting()
    {
        return (new aot(this)).a().getBoolean("always_send_reports_opt_in", false);
    }

    public boolean verifyPinning(URL url)
    {
        boolean flag;
        try
        {
            flag = internalVerifyPinning(url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            alt.h().e("CrashlyticsCore", "Could not verify SSL pinning", url);
            return false;
        }
        return flag;
    }



}
