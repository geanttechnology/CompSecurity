// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import c.a.a.a.a.b.c;
import c.a.a.a.a.b.l;
import c.a.a.a.a.b.p;
import c.a.a.a.a.b.x;
import c.a.a.a.a.c.s;
import c.a.a.a.a.c.y;
import c.a.a.a.a.c.z;
import c.a.a.a.a.e.a;
import c.a.a.a.a.e.d;
import c.a.a.a.a.f.b;
import c.a.a.a.a.g.j;
import c.a.a.a.a.g.m;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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

public class CrashlyticsCore extends n
{

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
    private a httpRequestFactory$6bbea658;
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
        this(f, crashlyticslistener, pinninginfoprovider, flag, c.a("Crashlytics Exception Handler"));
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

    private void doLog(int i, String s1, String s2)
    {
        while (disabled || !ensureFabricWithCalled("prior to logging messages.")) 
        {
            return;
        }
        long l1 = System.currentTimeMillis();
        long l2 = startTime;
        handler.writeToLog(l1 - l2, formatLogMessage(i, s1, s2));
    }

    private static boolean ensureFabricWithCalled(String s1)
    {
        CrashlyticsCore crashlyticscore = getInstance();
        if (crashlyticscore == null || crashlyticscore.handler == null)
        {
            e.d().c("CrashlyticsCore", (new StringBuilder("Crashlytics must be initialized by calling Fabric.with(Context) ")).append(s1).toString(), null);
            return false;
        } else
        {
            return true;
        }
    }

    private void finishInitSynchronously()
    {
        Object obj = new _cls1();
        for (Iterator iterator = getDependencies().iterator(); iterator.hasNext(); ((s) (obj)).addDependency((y)iterator.next())) { }
        obj = getFabric().c().submit(((java.util.concurrent.Callable) (obj)));
        e.d().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try
        {
            ((Future) (obj)).get(4L, TimeUnit.SECONDS);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            e.d().c("CrashlyticsCore", "Crashlytics was interrupted during initialization.", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            e.d().c("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", executionexception);
            return;
        }
        catch (TimeoutException timeoutexception)
        {
            e.d().c("CrashlyticsCore", "Crashlytics timed out during initialization.", timeoutexception);
        }
    }

    private static String formatLogMessage(int i, String s1, String s2)
    {
        return (new StringBuilder()).append(l.b(i)).append("/").append(s1).append(" ").append(s2).toString();
    }

    public static CrashlyticsCore getInstance()
    {
        return (CrashlyticsCore)e.a(com/crashlytics/android/core/CrashlyticsCore);
    }

    private boolean getSendDecisionFromUser(final Activity activity, final c.a.a.a.a.g.l promptData)
    {
        final DialogStringResolver stringResolver = new DialogStringResolver(activity, promptData);
        final OptInLatch latch = new OptInLatch(null);
        activity.runOnUiThread(new _cls7());
        e.d().a("CrashlyticsCore", "Waiting for user opt-in.");
        latch.await();
        return latch.getOptIn();
    }

    private boolean isRequiringBuildId(Context context)
    {
        return l.a(context, "com.crashlytics.RequireBuildId", true);
    }

    static void recordFatalExceptionEvent(String s1)
    {
        Answers answers = (Answers)e.a(com/crashlytics/android/answers/Answers);
        if (answers != null)
        {
            answers.onException(new p(s1));
        }
    }

    static void recordLoggedExceptionEvent(String s1)
    {
        Answers answers = (Answers)e.a(com/crashlytics/android/answers/Answers);
        if (answers != null)
        {
            answers.onException(new c.a.a.a.a.b.q(s1));
        }
    }

    private static String sanitizeAttribute(String s1)
    {
        String s2 = s1;
        if (s1 != null)
        {
            s1 = s1.trim();
            s2 = s1;
            if (s1.length() > 1024)
            {
                s2 = s1.substring(0, 1024);
            }
        }
        return s2;
    }

    private void setAndValidateKitProperties(Context context, String s1)
    {
        Object obj;
        if (pinningInfo != null)
        {
            obj = new CrashlyticsPinningInfoProvider(pinningInfo);
        } else
        {
            obj = null;
        }
        httpRequestFactory$6bbea658 = new a(e.d());
        httpRequestFactory$6bbea658.a(((c.a.a.a.a.e.l) (obj)));
        packageName = context.getPackageName();
        installerPackageName = getIdManager().h();
        e.d().a("CrashlyticsCore", (new StringBuilder("Installer package name is: ")).append(installerPackageName).toString());
        obj = context.getPackageManager().getPackageInfo(packageName, 0);
        versionCode = Integer.toString(((PackageInfo) (obj)).versionCode);
        if (((PackageInfo) (obj)).versionName != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = "0.0";
_L1:
        try
        {
            versionName = ((String) (obj));
            buildId = l.k(context);
        }
        catch (Exception exception)
        {
            e.d().c("CrashlyticsCore", "Error setting up app properties", exception);
        }
        getIdManager().j();
        getBuildIdValidator(buildId, isRequiringBuildId(context)).validate(s1, packageName);
        return;
        obj = ((PackageInfo) (obj)).versionName;
          goto _L1
    }

    boolean canSendWithUserApproval()
    {
        return ((Boolean)c.a.a.a.a.g.n.a().a(new _cls6(), Boolean.valueOf(true))).booleanValue();
    }

    public void crash()
    {
        (new CrashTest()).indexOutOfBounds();
    }

    boolean didPreviousInitializationComplete()
    {
        return ((Boolean)executorServiceWrapper.executeSyncLoggingException(new _cls4())).booleanValue();
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
        Object obj = c.a.a.a.a.g.n.a().b();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        flag = flag2;
        e.d().d("CrashlyticsCore", "Received null settings, skipping initialization!");
        markInitializationComplete();
        return null;
        flag = flag2;
        if (!((c.a.a.a.a.g.s) (obj)).d.b) goto _L2; else goto _L1
_L1:
        flag2 = false;
        flag1 = false;
        flag = flag2;
        handler.finalizeSessions();
        flag = flag2;
        obj = getCreateReportSpiCall(((c.a.a.a.a.g.s) (obj)));
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        (new ReportUploader(((CreateReportSpiCall) (obj)))).uploadReports(delay);
_L2:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        e.d().a("CrashlyticsCore", "Crash reporting disabled.");
        markInitializationComplete();
        return null;
_L4:
        flag = flag2;
        e.d().d("CrashlyticsCore", "Unable to create a call to upload reports.");
          goto _L2
        Object obj1;
        obj1;
        e.d().c("CrashlyticsCore", "Error dealing with settings", ((Throwable) (obj1)));
        flag1 = flag;
          goto _L2
        obj1;
        e.d().c("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", ((Throwable) (obj1)));
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

    BuildIdValidator getBuildIdValidator(String s1, boolean flag)
    {
        return new BuildIdValidator(s1, flag);
    }

    CreateReportSpiCall getCreateReportSpiCall(c.a.a.a.a.g.s s1)
    {
        if (s1 != null)
        {
            return new DefaultCreateReportSpiCall(this, getOverridenSpiEndpoint(), s1.a.c, httpRequestFactory$6bbea658);
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
        return l.c(getContext(), "com.crashlytics.ApiEndpoint");
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
            sdkDir = (new b(this)).a();
        }
        return sdkDir;
    }

    m getSessionSettingsData()
    {
        c.a.a.a.a.g.s s1 = c.a.a.a.a.g.n.a().b();
        if (s1 == null)
        {
            return null;
        } else
        {
            return s1.b;
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
            url = httpRequestFactory$6bbea658.a(c.a.a.a.a.e.c.a, url.toString());
            ((HttpsURLConnection)url.a()).setInstanceFollowRedirects(false);
            url.b();
            return true;
        } else
        {
            return false;
        }
    }

    public void log(int i, String s1, String s2)
    {
        doLog(i, s1, s2);
        e.d().a(i, (new StringBuilder()).append(s1).toString(), (new StringBuilder()).append(s2).toString(), true);
    }

    public void log(String s1)
    {
        doLog(3, "CrashlyticsCore", s1);
    }

    public void logException(Throwable throwable)
    {
        while (disabled || !ensureFabricWithCalled("prior to logging exceptions.")) 
        {
            return;
        }
        if (throwable == null)
        {
            e.d().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
            return;
        } else
        {
            handler.writeNonFatalException(Thread.currentThread(), throwable);
            return;
        }
    }

    void markInitializationComplete()
    {
        executorServiceWrapper.executeAsync(new _cls3());
    }

    void markInitializationStarted()
    {
        executorServiceWrapper.executeSyncLoggingException(new _cls2());
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
        obj = (new c.a.a.a.a.b.j()).a(context);
        if (obj == null)
        {
            return false;
        }
        e.d().c("CrashlyticsCore", (new StringBuilder("Initializing Crashlytics ")).append(getVersion()).toString());
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
            e.d().c("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", context);
            return false;
        }
        obj = new SessionDataWriter(getContext(), buildId, getPackageName());
        e.d().a("CrashlyticsCore", "Installing exception handler...");
        handler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), listener, executorServiceWrapper, getIdManager(), ((SessionDataWriter) (obj)), this);
        flag = didPreviousInitializationComplete();
        handler.openSession();
        Thread.setDefaultUncaughtExceptionHandler(handler);
        e.d().a("CrashlyticsCore", "Successfully installed exception handler.");
_L2:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!l.l(context))
        {
            break; /* Loop/switch isn't completed */
        }
        finishInitSynchronously();
        return false;
_L3:
        e.d().c("CrashlyticsCore", "There was a problem installing the exception handler.", exception);
        if (true) goto _L2; else goto _L1
        context;
        throw new z(context);
_L1:
        return true;
        exception;
          goto _L3
        exception;
        flag = false;
          goto _L3
    }

    public void setBool(String s1, boolean flag)
    {
        setString(s1, Boolean.toString(flag));
    }

    public void setDouble(String s1, double d1)
    {
        setString(s1, Double.toString(d1));
    }

    void setExternalCrashEventDataProvider(CrashEventDataProvider crasheventdataprovider)
    {
        externalCrashEventDataProvider = crasheventdataprovider;
    }

    public void setFloat(String s1, float f)
    {
        setString(s1, Float.toString(f));
    }

    public void setInt(String s1, int i)
    {
        setString(s1, Integer.toString(i));
    }

    public void setListener(CrashlyticsListener crashlyticslistener)
    {
        this;
        JVM INSTR monitorenter ;
        e.d().d("CrashlyticsCore", "Use of setListener is deprecated.");
        if (crashlyticslistener != null)
        {
            break MISSING_BLOCK_LABEL_33;
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

    public void setLong(String s1, long l1)
    {
        setString(s1, Long.toString(l1));
    }

    void setShouldSendUserReportsWithoutPrompting(boolean flag)
    {
        c.a.a.a.a.f.c c1 = new c.a.a.a.a.f.c(this);
        c1.a(c1.b().putBoolean("always_send_reports_opt_in", flag));
    }

    public void setString(String s1, String s2)
    {
        if (disabled)
        {
            return;
        }
        if (s1 == null)
        {
            if (getContext() != null && l.h(getContext()))
            {
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            } else
            {
                e.d().c("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
        }
        String s3 = sanitizeAttribute(s1);
        if (attributes.size() < 64 || attributes.containsKey(s3))
        {
            if (s2 == null)
            {
                s1 = "";
            } else
            {
                s1 = sanitizeAttribute(s2);
            }
            attributes.put(s3, s1);
            handler.cacheKeyData(attributes);
            return;
        } else
        {
            e.d().a("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
            return;
        }
    }

    public void setUserEmail(String s1)
    {
        if (disabled)
        {
            return;
        } else
        {
            userEmail = sanitizeAttribute(s1);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    public void setUserIdentifier(String s1)
    {
        if (disabled)
        {
            return;
        } else
        {
            userId = sanitizeAttribute(s1);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    public void setUserName(String s1)
    {
        if (disabled)
        {
            return;
        } else
        {
            userName = sanitizeAttribute(s1);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    boolean shouldPromptUserBeforeSendingCrashReports()
    {
        return ((Boolean)c.a.a.a.a.g.n.a().a(new _cls5(), Boolean.valueOf(false))).booleanValue();
    }

    boolean shouldSendReportsWithoutPrompting()
    {
        return (new c.a.a.a.a.f.c(this)).a().getBoolean("always_send_reports_opt_in", false);
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
            e.d().c("CrashlyticsCore", "Could not verify SSL pinning", url);
            return false;
        }
        return flag;
    }




    private class _cls1 extends s
    {

        final CrashlyticsCore this$0;

        public volatile Object call()
        {
            return call();
        }

        public Void call()
        {
            return doInBackground();
        }

        public int getPriority$16699175()
        {
            return o.c;
        }

        _cls1()
        {
            this$0 = CrashlyticsCore.this;
            super();
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

        OptInLatch(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls7
        implements Runnable
    {

        final CrashlyticsCore this$0;
        final Activity val$activity;
        final OptInLatch val$latch;
        final c.a.a.a.a.g.l val$promptData;
        final DialogStringResolver val$stringResolver;

        public void run()
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
            class _cls1
                implements android.content.DialogInterface.OnClickListener
            {

                final _cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int k)
                {
                    latch.setOptIn(true);
                    dialoginterface.dismiss();
                }

                _cls1()
                {
                    this$1 = _cls7.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
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
            builder.setView(scrollview).setTitle(stringResolver.getTitle()).setCancelable(false).setNeutralButton(stringResolver.getSendButtonTitle(), _lcls1);
            if (promptData.d)
            {
                class _cls2
                    implements android.content.DialogInterface.OnClickListener
                {

                    final _cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        latch.setOptIn(false);
                        dialoginterface.dismiss();
                    }

                _cls2()
                {
                    this$1 = _cls7.this;
                    super();
                }
                }

                _cls2 _lcls2 = new _cls2();
                builder.setNegativeButton(stringResolver.getCancelButtonTitle(), _lcls2);
            }
            if (promptData.f)
            {
                class _cls3
                    implements android.content.DialogInterface.OnClickListener
                {

                    final _cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        setShouldSendUserReportsWithoutPrompting(true);
                        latch.setOptIn(true);
                        dialoginterface.dismiss();
                    }

                _cls3()
                {
                    this$1 = _cls7.this;
                    super();
                }
                }

                _cls3 _lcls3 = new _cls3();
                builder.setPositiveButton(stringResolver.getAlwaysSendButtonTitle(), _lcls3);
            }
            builder.show();
        }

        _cls7()
        {
            this$0 = CrashlyticsCore.this;
            activity = activity1;
            latch = optinlatch;
            stringResolver = dialogstringresolver;
            promptData = l1;
            super();
        }
    }


    private class _cls6
        implements c.a.a.a.a.g.p
    {

        final CrashlyticsCore this$0;

        public Boolean usingSettings(c.a.a.a.a.g.s s1)
        {
            boolean flag1 = true;
            Activity activity = getFabric().a();
            boolean flag = flag1;
            if (activity != null)
            {
                flag = flag1;
                if (!activity.isFinishing())
                {
                    flag = flag1;
                    if (shouldPromptUserBeforeSendingCrashReports())
                    {
                        flag = getSendDecisionFromUser(activity, s1.c);
                    }
                }
            }
            return Boolean.valueOf(flag);
        }

        public volatile Object usingSettings(c.a.a.a.a.g.s s1)
        {
            return usingSettings(s1);
        }

        _cls6()
        {
            this$0 = CrashlyticsCore.this;
            super();
        }
    }


    private class _cls4
        implements Callable
    {

        final CrashlyticsCore this$0;

        public Boolean call()
        {
            return Boolean.valueOf(initializationMarkerFile.exists());
        }

        public volatile Object call()
        {
            return call();
        }

        _cls4()
        {
            this$0 = CrashlyticsCore.this;
            super();
        }
    }


    private class _cls3
        implements Callable
    {

        final CrashlyticsCore this$0;

        public Boolean call()
        {
            boolean flag;
            try
            {
                flag = initializationMarkerFile.delete();
                e.d().a("CrashlyticsCore", (new StringBuilder("Initialization marker file removed: ")).append(flag).toString());
            }
            catch (Exception exception)
            {
                e.d().c("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", exception);
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(flag);
        }

        public volatile Object call()
        {
            return call();
        }

        _cls3()
        {
            this$0 = CrashlyticsCore.this;
            super();
        }
    }


    private class _cls2
        implements Callable
    {

        final CrashlyticsCore this$0;

        public volatile Object call()
        {
            return call();
        }

        public Void call()
        {
            initializationMarkerFile.createNewFile();
            e.d().a("CrashlyticsCore", "Initialization marker file created.");
            return null;
        }

        _cls2()
        {
            this$0 = CrashlyticsCore.this;
            super();
        }
    }


    private class _cls5
        implements c.a.a.a.a.g.p
    {

        final CrashlyticsCore this$0;

        public Boolean usingSettings(c.a.a.a.a.g.s s1)
        {
            boolean flag = false;
            if (s1.d.a)
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

        public volatile Object usingSettings(c.a.a.a.a.g.s s1)
        {
            return usingSettings(s1);
        }

        _cls5()
        {
            this$0 = CrashlyticsCore.this;
            super();
        }
    }

}
