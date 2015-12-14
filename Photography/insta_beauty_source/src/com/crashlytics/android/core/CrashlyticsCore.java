// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import bso;
import bsy;
import btb;
import btr;
import btv;
import btw;
import btz;
import bvb;
import bvh;
import bwd;
import bwl;
import bwr;
import bws;
import bwt;
import bwy;
import bxg;
import bxi;
import bxj;
import bxk;
import bxp;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
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

public class CrashlyticsCore extends bsy
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
    private bwl httpRequestFactory;
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
        this(f, crashlyticslistener, pinninginfoprovider, flag, btz.a("Crashlytics Exception Handler"));
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
            bso.h().e("CrashlyticsCore", (new StringBuilder()).append("Crashlytics must be initialized by calling Fabric.with(Context) ").append(s).toString(), null);
            return false;
        } else
        {
            return true;
        }
    }

    private void finishInitSynchronously()
    {
        Object obj = new _cls1();
        for (Iterator iterator = getDependencies().iterator(); iterator.hasNext(); ((bvb) (obj)).addDependency((bvh)iterator.next())) { }
        obj = getFabric().f().submit(((java.util.concurrent.Callable) (obj)));
        bso.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try
        {
            ((Future) (obj)).get(4L, TimeUnit.SECONDS);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            bso.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            bso.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", executionexception);
            return;
        }
        catch (TimeoutException timeoutexception)
        {
            bso.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", timeoutexception);
        }
    }

    private static String formatLogMessage(int i, String s, String s1)
    {
        return (new StringBuilder()).append(CommonUtils.b(i)).append("/").append(s).append(" ").append(s1).toString();
    }

    public static CrashlyticsCore getInstance()
    {
        return (CrashlyticsCore)bso.a(com/crashlytics/android/core/CrashlyticsCore);
    }

    private boolean getSendDecisionFromUser(final Activity activity, final bxi promptData)
    {
        final DialogStringResolver stringResolver = new DialogStringResolver(activity, promptData);
        final OptInLatch latch = new OptInLatch(null);
        activity.runOnUiThread(new _cls7());
        bso.h().a("CrashlyticsCore", "Waiting for user opt-in.");
        latch.await();
        return latch.getOptIn();
    }

    private boolean isRequiringBuildId(Context context)
    {
        return CommonUtils.a(context, "com.crashlytics.RequireBuildId", true);
    }

    static void recordFatalExceptionEvent(String s)
    {
        Answers answers = (Answers)bso.a(com/crashlytics/android/answers/Answers);
        if (answers != null)
        {
            answers.onException(new btv(s));
        }
    }

    static void recordLoggedExceptionEvent(String s)
    {
        Answers answers = (Answers)bso.a(com/crashlytics/android/answers/Answers);
        if (answers != null)
        {
            answers.onException(new btw(s));
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
        httpRequestFactory = new bwd(bso.h());
        httpRequestFactory.a(((bwn) (obj)));
        packageName = context.getPackageName();
        installerPackageName = getIdManager().h();
        bso.h().a("CrashlyticsCore", (new StringBuilder()).append("Installer package name is: ").append(installerPackageName).toString());
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
            buildId = CommonUtils.m(context);
        }
        catch (Exception exception)
        {
            bso.h().e("CrashlyticsCore", "Error setting up app properties", exception);
        }
        getIdManager().o();
        getBuildIdValidator(buildId, isRequiringBuildId(context)).validate(s, packageName);
        return;
        obj = ((PackageInfo) (obj)).versionName;
          goto _L1
    }

    boolean canSendWithUserApproval()
    {
        return ((Boolean)bxk.a().a(new _cls6(), Boolean.valueOf(true))).booleanValue();
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
        Object obj = bxk.a().b();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        flag = flag2;
        bso.h().d("CrashlyticsCore", "Received null settings, skipping initialization!");
        markInitializationComplete();
        return null;
        flag = flag2;
        if (!((bxp) (obj)).d.c) goto _L2; else goto _L1
_L1:
        flag2 = false;
        flag1 = false;
        flag = flag2;
        handler.finalizeSessions();
        flag = flag2;
        obj = getCreateReportSpiCall(((bxp) (obj)));
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        (new ReportUploader(((CreateReportSpiCall) (obj)))).uploadReports(delay);
_L2:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        bso.h().a("CrashlyticsCore", "Crash reporting disabled.");
        markInitializationComplete();
        return null;
_L4:
        flag = flag2;
        bso.h().d("CrashlyticsCore", "Unable to create a call to upload reports.");
          goto _L2
        Object obj1;
        obj1;
        bso.h().e("CrashlyticsCore", "Error dealing with settings", ((Throwable) (obj1)));
        flag1 = flag;
          goto _L2
        obj1;
        bso.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", ((Throwable) (obj1)));
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

    CreateReportSpiCall getCreateReportSpiCall(bxp bxp1)
    {
        if (bxp1 != null)
        {
            return new DefaultCreateReportSpiCall(this, getOverridenSpiEndpoint(), bxp1.a.d, httpRequestFactory);
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
        return CommonUtils.b(getContext(), "com.crashlytics.ApiEndpoint");
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
            sdkDir = (new bwr(this)).a();
        }
        return sdkDir;
    }

    bxj getSessionSettingsData()
    {
        bxp bxp1 = bxk.a().b();
        if (bxp1 == null)
        {
            return null;
        } else
        {
            return bxp1.b;
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
            url = httpRequestFactory.a(HttpMethod.GET, url.toString());
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
        bso.h().a(i, (new StringBuilder()).append("").append(s).toString(), (new StringBuilder()).append("").append(s1).toString(), true);
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
            bso.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
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
        obj = (new btr()).a(context);
        if (obj == null)
        {
            return false;
        }
        bso.h().c("CrashlyticsCore", (new StringBuilder()).append("Initializing Crashlytics ").append(getVersion()).toString());
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
            bso.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", context);
            return false;
        }
        obj = new SessionDataWriter(getContext(), buildId, getPackageName());
        bso.h().a("CrashlyticsCore", "Installing exception handler...");
        handler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), listener, executorServiceWrapper, getIdManager(), ((SessionDataWriter) (obj)), this);
        flag = didPreviousInitializationComplete();
        handler.openSession();
        Thread.setDefaultUncaughtExceptionHandler(handler);
        bso.h().a("CrashlyticsCore", "Successfully installed exception handler.");
_L2:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!CommonUtils.n(context))
        {
            break; /* Loop/switch isn't completed */
        }
        finishInitSynchronously();
        return false;
_L3:
        bso.h().e("CrashlyticsCore", "There was a problem installing the exception handler.", exception);
        if (true) goto _L2; else goto _L1
        context;
        throw new UnmetDependencyException(context);
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
        bso.h().d("CrashlyticsCore", "Use of setListener is deprecated.");
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
        bwt bwt1 = new bwt(this);
        bwt1.a(bwt1.b().putBoolean("always_send_reports_opt_in", flag));
    }

    public void setString(String s, String s1)
    {
        if (disabled)
        {
            return;
        }
        if (s == null)
        {
            if (getContext() != null && CommonUtils.i(getContext()))
            {
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            } else
            {
                bso.h().e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
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
            bso.h().a("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
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
        return ((Boolean)bxk.a().a(new _cls5(), Boolean.valueOf(false))).booleanValue();
    }

    boolean shouldSendReportsWithoutPrompting()
    {
        return (new bwt(this)).a().getBoolean("always_send_reports_opt_in", false);
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
            bso.h().e("CrashlyticsCore", "Could not verify SSL pinning", url);
            return false;
        }
        return flag;
    }




    private class _cls1 extends bvb
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

        public Priority getPriority()
        {
            return Priority.IMMEDIATE;
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
        final bxi val$promptData;
        final DialogStringResolver val$stringResolver;

        public void run()
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
            class _cls1
                implements android.content.DialogInterface.OnClickListener
            {

                final _cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int j)
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

                    public void onClick(DialogInterface dialoginterface, int j)
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

                    public void onClick(DialogInterface dialoginterface, int j)
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
            promptData = bxi1;
            super();
        }
    }


    private class _cls6
        implements bxn
    {

        final CrashlyticsCore this$0;

        public Boolean usingSettings(bxp bxp1)
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
                        flag = getSendDecisionFromUser(activity, bxp1.c);
                    }
                }
            }
            return Boolean.valueOf(flag);
        }

        public volatile Object usingSettings(bxp bxp1)
        {
            return usingSettings(bxp1);
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
                bso.h().a("CrashlyticsCore", (new StringBuilder()).append("Initialization marker file removed: ").append(flag).toString());
            }
            catch (Exception exception)
            {
                bso.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", exception);
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
            bso.h().a("CrashlyticsCore", "Initialization marker file created.");
            return null;
        }

        _cls2()
        {
            this$0 = CrashlyticsCore.this;
            super();
        }
    }


    private class _cls5
        implements bxn
    {

        final CrashlyticsCore this$0;

        public Boolean usingSettings(bxp bxp1)
        {
            boolean flag = false;
            if (bxp1.d.a)
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

        public volatile Object usingSettings(bxp bxp1)
        {
            return usingSettings(bxp1);
        }

        _cls5()
        {
            this$0 = CrashlyticsCore.this;
            super();
        }
    }

}
