// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import com.comcast.cim.analytics.JacksonConverter;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.AlternateInterfaceUtil;
import com.comcast.cim.android.accessibility.TalkDelegateFactory;
import com.comcast.cim.android.application.AppUpgradeHelper;
import com.comcast.cim.android.authentication.AuthenticationClient;
import com.comcast.cim.android.authentication.AuthenticationStrategy;
import com.comcast.cim.android.authentication.SignInListener;
import com.comcast.cim.android.concurrent.UIThreadExecutor;
import com.comcast.cim.android.view.common.BaseActivityDelegate;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.android.view.common.OrientationStrategyProvider;
import com.comcast.cim.android.view.common.errorformatter.AmsErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.ChainedErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.CimHttpErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.DownloadServiceErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.GenericErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.XipErrorFormatter;
import com.comcast.cim.android.view.launch.AuthenticatingActivityDelegate;
import com.comcast.cim.android.view.launch.AuthenticatingFragmentDelegate;
import com.comcast.cim.android.view.launch.LaunchIntentInterceptor;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.cmasl.analytics.AnalyticsRequestProvider;
import com.comcast.cim.cmasl.analytics.AnalyticsSenderFactory;
import com.comcast.cim.cmasl.analytics.AnalyticsTask;
import com.comcast.cim.cmasl.analytics.AnalyticsTaskInjector;
import com.comcast.cim.cmasl.analytics.AnalyticsTaskQueue;
import com.comcast.cim.cmasl.analytics.AnalyticsTaskQueueLogger;
import com.comcast.cim.cmasl.analytics.DefaultAnalyticsRequestProvider;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.system.SoftKeyboard;
import com.comcast.cim.cmasl.apachehttp.LogAllRequestsInterceptor;
import com.comcast.cim.cmasl.apachehttp.client.DecompressingHttpClient;
import com.comcast.cim.cmasl.apachehttp.client.HttpClientProvider;
import com.comcast.cim.cmasl.apachehttp.request.BasicHTTPRequestProvider;
import com.comcast.cim.cmasl.apachehttp.service.DefaultHttpService;
import com.comcast.cim.cmasl.cachelib.PermanentFileCache;
import com.comcast.cim.cmasl.customtypefacelib.TypefaceManager;
import com.comcast.cim.cmasl.hls.HlsDownloadClient;
import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.policy.MinimumIntervalRevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.utils.executor.SingleThreadedExecutorFactory;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import com.comcast.cim.cmasl.xip.XipServer;
import com.comcast.cim.config.CALConfiguration;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeader;
import com.comcast.cim.model.GracefullyDegradingMinVersionCheckCache;
import com.comcast.cim.model.MinVersionTask;
import com.comcast.cim.model.user.CurrentUser;
import com.comcast.cim.model.user.UserManager;
import com.comcast.cim.tracking.TrackingService;
import com.comcast.cim.utils.AddNetworkTypeHeaderInterceptor;
import com.comcast.cim.utils.AppLauncher;
import com.comcast.cim.utils.EitherJacksonMixIn;
import com.comcast.cim.utils.JsonSerializer;
import com.comcast.cim.utils.UIUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.squareup.tape.FileObjectQueue;
import com.squareup.tape.InMemoryObjectQueue;
import com.squareup.tape.ObjectQueue;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CALContainer
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/container/CALContainer);
    private static CALContainer instance;
    private AccessibilityManager accessibilityManager;
    private AccessibilityUtil accessibilityUtil;
    private AlternateInterfaceUtil alternateInterfaceUtil;
    private com.squareup.tape.FileObjectQueue.Converter analyticsTaskConverter;
    private AnalyticsTaskQueue analyticsTaskQueue;
    private File analyticsTaskQueueFile;
    private AppLauncher appLauncher;
    private AuthenticationClient authenticationClient;
    private CurrentUser currentUser;
    private MinimumIntervalRevalidationPolicy defaultRevalidationPolicy;
    private BasicHeader downloadUserAgent;
    private ErrorDialogFactory errorDialogFactory;
    private ErrorFormatter errorFormatter;
    private PermanentFileCache fileCache;
    protected AnalyticsLogger foxAnalyticsLogger;
    private Task gracefullyDegradingMinVersionCheckCache;
    private HlsDownloadClient hlsDownloadClient;
    private HttpClient httpClient;
    private InternetConnection internetConnection;
    private JsonSerializer jsonSerializer;
    private Task minVersionCheckCache;
    private ObjectMapper objectMapper;
    private RequestProviderFactory requestProviderFactory;
    private SignInListener signInListener;
    private SoftKeyboard softKeyboard;
    protected AnalyticsLogger splunkLogger;
    private TalkDelegateFactory talkDelegateFactory;
    private TaskExecutorFactory taskExecutorFactory;
    private UIThreadExecutor uiThreadExecutor;
    private UIUtil uiUtil;
    private BasicHeader userAgent;
    private Integer versionCode;
    private XipRequestProviderFactory xipRequestProviderFactory;

    public CALContainer()
    {
    }

    private com.squareup.tape.FileObjectQueue.Converter getAnalyticsTaskConverter()
    {
        this;
        JVM INSTR monitorenter ;
        com.squareup.tape.FileObjectQueue.Converter converter;
        if (analyticsTaskConverter == null)
        {
            analyticsTaskConverter = new JacksonConverter(getObjectMapper(), com/comcast/cim/cmasl/analytics/AnalyticsTask);
        }
        converter = analyticsTaskConverter;
        this;
        JVM INSTR monitorexit ;
        return converter;
        Exception exception;
        exception;
        throw exception;
    }

    private ObjectQueue getAnalyticsTaskQueueDelegate()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        int i;
        i = 0;
        obj = null;
_L2:
        if (obj != null || i > 1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        FileObjectQueue fileobjectqueue = new FileObjectQueue(getAnalyticsTaskQueueFile(), getAnalyticsTaskConverter());
        obj = fileobjectqueue;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        LOG.error("Failed to load the analytics queue! Wipe it and try again!");
        File file = getAnalyticsTaskQueueFile();
        if (file.exists())
        {
            file.delete();
        }
        break MISSING_BLOCK_LABEL_101;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        LOG.error("Falling back to an in-memory object queue.  some analytics may be lost on crashes and restarts");
        obj = new InMemoryObjectQueue();
        this;
        JVM INSTR monitorexit ;
        return ((ObjectQueue) (obj));
        Exception exception;
        exception;
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static CALContainer getInstance()
    {
        com/comcast/cim/container/CALContainer;
        JVM INSTR monitorenter ;
        CALContainer calcontainer = instance;
        com/comcast/cim/container/CALContainer;
        JVM INSTR monitorexit ;
        return calcontainer;
        Exception exception;
        exception;
        throw exception;
    }

    protected static void setInstance(CALContainer calcontainer)
    {
        com/comcast/cim/container/CALContainer;
        JVM INSTR monitorenter ;
        instance = calcontainer;
        com/comcast/cim/container/CALContainer;
        JVM INSTR monitorexit ;
        return;
        calcontainer;
        throw calcontainer;
    }

    public AccessibilityManager getAccessibilityManager()
    {
        this;
        JVM INSTR monitorenter ;
        AccessibilityManager accessibilitymanager;
        if (accessibilityManager == null)
        {
            accessibilityManager = (AccessibilityManager)getApplication().getSystemService("accessibility");
        }
        accessibilitymanager = accessibilityManager;
        this;
        JVM INSTR monitorexit ;
        return accessibilitymanager;
        Exception exception;
        exception;
        throw exception;
    }

    public AccessibilityUtil getAccessibilityUtil()
    {
        this;
        JVM INSTR monitorenter ;
        AccessibilityUtil accessibilityutil;
        if (accessibilityUtil == null)
        {
            accessibilityUtil = new AccessibilityUtil(getAccessibilityManager());
        }
        accessibilityutil = accessibilityUtil;
        this;
        JVM INSTR monitorexit ;
        return accessibilityutil;
        Exception exception;
        exception;
        throw exception;
    }

    public AlternateInterfaceUtil getAlternateInterfaceUtil()
    {
        this;
        JVM INSTR monitorenter ;
        AlternateInterfaceUtil alternateinterfaceutil;
        if (alternateInterfaceUtil == null)
        {
            alternateInterfaceUtil = new AlternateInterfaceUtil();
        }
        alternateinterfaceutil = alternateInterfaceUtil;
        this;
        JVM INSTR monitorexit ;
        return alternateinterfaceutil;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract Class getAnalyticsServiceClass();

    public AnalyticsTaskQueue getAnalyticsTaskQueue()
    {
        this;
        JVM INSTR monitorenter ;
        AnalyticsTaskQueue analyticstaskqueue;
        if (analyticsTaskQueue == null)
        {
            AnalyticsTaskInjector analyticstaskinjector = new AnalyticsTaskInjector(new AnalyticsSenderFactory(new DefaultHttpService(getHttpClient()), new RequestProviderFactory() {

                final CALContainer this$0;

                public AnalyticsRequestProvider create(String s)
                {
                    return new DefaultAnalyticsRequestProvider(getHttpRequestProviderFactory().create(s));
                }

                public AnalyticsRequestProvider create(String s, String s1)
                {
                    return new DefaultAnalyticsRequestProvider(getHttpRequestProviderFactory().create(s, s1));
                }

                public volatile RequestProvider create(String s)
                {
                    return create(s);
                }

                public volatile RequestProvider create(String s, String s1)
                {
                    return create(s, s1);
                }

            
            {
                this$0 = CALContainer.this;
                super();
            }
            }), getTaskExecutorFactory());
            analyticsTaskQueue = new AnalyticsTaskQueue(getAnalyticsTaskQueueDelegate(), analyticstaskinjector, getApplication(), getAnalyticsServiceClass());
        }
        analyticstaskqueue = analyticsTaskQueue;
        this;
        JVM INSTR monitorexit ;
        return analyticstaskqueue;
        Exception exception;
        exception;
        throw exception;
    }

    public File getAnalyticsTaskQueueFile()
    {
        this;
        JVM INSTR monitorenter ;
        File file;
        if (analyticsTaskQueueFile == null)
        {
            analyticsTaskQueueFile = new File(getApplication().getFilesDir(), "analyticsqueue");
        }
        file = analyticsTaskQueueFile;
        this;
        JVM INSTR monitorexit ;
        return file;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract AndroidDevice getAndroidDevice();

    public AppLauncher getAppLauncher()
    {
        this;
        JVM INSTR monitorenter ;
        AppLauncher applauncher;
        if (appLauncher == null)
        {
            appLauncher = new AppLauncher(getAndroidDevice());
        }
        applauncher = appLauncher;
        this;
        JVM INSTR monitorexit ;
        return applauncher;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract AppUpgradeHelper getAppUpgradeHelper();

    public abstract Application getApplication();

    public AuthenticatingActivityDelegate getAuthenticatingActivityDelegate(Activity activity, com.comcast.cim.android.view.launch.AuthenticatingActivityDelegate.InternalLifecycleRunner internallifecyclerunner)
    {
        return new AuthenticatingActivityDelegate(activity, internallifecyclerunner, getUserManager(), getLaunchStrategy(), getAuthenticationStrategy(), getAppUpgradeHelper(), getUiThreadExecutor(), getGracefullyDegradingMinVersionCheckCache(), getTaskExecutorFactory(), getVersionCode().intValue());
    }

    public AuthenticatingFragmentDelegate getAuthenticatingFragmentDelegate(com.comcast.cim.android.view.launch.AuthenticatingFragmentDelegate.InternalLifecycleRunner internallifecyclerunner)
    {
        return new AuthenticatingFragmentDelegate(internallifecyclerunner, getAuthenticationStrategy());
    }

    public AuthenticationClient getAuthenticationClient()
    {
        this;
        JVM INSTR monitorenter ;
        AuthenticationClient authenticationclient;
        if (authenticationClient == null)
        {
            DefaultHttpService defaulthttpservice = new DefaultHttpService(getHttpClient());
            authenticationClient = new AuthenticationClient(getAndroidDevice(), defaulthttpservice, getXipRequestProviderFactory(), getObjectMapper());
        }
        authenticationclient = authenticationClient;
        this;
        JVM INSTR monitorexit ;
        return authenticationclient;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract AuthenticationStrategy getAuthenticationStrategy();

    public BaseActivityDelegate getBaseActivityDelegate(Activity activity, OrientationStrategyProvider orientationstrategyprovider)
    {
        return new BaseActivityDelegate(activity, orientationstrategyprovider, getAndroidDevice(), getAccessibilityUtil(), getInputMethodManager(), getTalkDelegateFactory());
    }

    public abstract CALConfiguration getConfiguration();

    public ConnectivityManager getConnectivityManager()
    {
        this;
        JVM INSTR monitorenter ;
        ConnectivityManager connectivitymanager = (ConnectivityManager)getApplication().getSystemService("connectivity");
        this;
        JVM INSTR monitorexit ;
        return connectivitymanager;
        Exception exception;
        exception;
        throw exception;
    }

    public CurrentUser getCurrentUser()
    {
        this;
        JVM INSTR monitorenter ;
        CurrentUser currentuser;
        if (currentUser == null)
        {
            currentUser = new CurrentUser(getSharedPreferences());
        }
        currentuser = currentUser;
        this;
        JVM INSTR monitorexit ;
        return currentuser;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract OrientationStrategy getDefaultOrientationStrategy();

    public MinimumIntervalRevalidationPolicy getDefaultRevalidationPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        MinimumIntervalRevalidationPolicy minimumintervalrevalidationpolicy;
        if (defaultRevalidationPolicy == null)
        {
            defaultRevalidationPolicy = new MinimumIntervalRevalidationPolicy(getConfiguration().getDataRevalidationIntervalInMillis());
        }
        minimumintervalrevalidationpolicy = defaultRevalidationPolicy;
        this;
        JVM INSTR monitorexit ;
        return minimumintervalrevalidationpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public BasicHeader getDownloadUserAgent()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = downloadUserAgent;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = getApplication().getPackageManager().getPackageInfo(getApplication().getPackageName(), 0);
        downloadUserAgent = new BasicHeader("User-Agent", String.format("%1$s/%2$s (ANDROID %3$s; di=%4$s) DL2G", new Object[] {
            getConfiguration().getUserAgentPrefix(), ((PackageInfo) (obj)).versionName, android.os.Build.VERSION.RELEASE, getAndroidDevice().getDeviceId()
        }));
        obj = downloadUserAgent;
        this;
        JVM INSTR monitorexit ;
        return ((BasicHeader) (obj));
        Object obj1;
        obj1;
        throw new CimException(((Throwable) (obj1)));
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public ErrorDialogFactory getErrorDialogFactory()
    {
        if (errorDialogFactory == null)
        {
            errorDialogFactory = new ErrorDialogFactory(getErrorFormatter(), getInternetConnection(), getResources());
        }
        return errorDialogFactory;
    }

    public ErrorFormatter getErrorFormatter()
    {
        this;
        JVM INSTR monitorenter ;
        ErrorFormatter errorformatter;
        if (errorFormatter == null)
        {
            Resources resources = getResources();
            java.util.ArrayList arraylist = Lists.newArrayList();
            arraylist.add(new XipErrorFormatter(resources));
            arraylist.add(new AmsErrorFormatter(resources));
            arraylist.add(new CimHttpErrorFormatter(resources));
            arraylist.add(new DownloadServiceErrorFormatter(resources));
            arraylist.add(new GenericErrorFormatter(resources));
            errorFormatter = new ChainedErrorFormatter(arraylist);
        }
        errorformatter = errorFormatter;
        this;
        JVM INSTR monitorexit ;
        return errorformatter;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getGracefullyDegradingMinVersionCheckCache()
    {
        if (gracefullyDegradingMinVersionCheckCache == null)
        {
            gracefullyDegradingMinVersionCheckCache = new GracefullyDegradingMinVersionCheckCache(getMinVersionCheckCache());
        }
        return gracefullyDegradingMinVersionCheckCache;
    }

    public HlsDownloadClient getHlsDownloadClient()
    {
        this;
        JVM INSTR monitorenter ;
        HlsDownloadClient hlsdownloadclient;
        if (hlsDownloadClient == null)
        {
            hlsDownloadClient = new HlsDownloadClient(new DefaultHttpService(getHttpClient()), getHttpRequestProviderFactory());
        }
        hlsdownloadclient = hlsDownloadClient;
        this;
        JVM INSTR monitorexit ;
        return hlsdownloadclient;
        Exception exception;
        exception;
        throw exception;
    }

    public HttpClient getHttpClient()
    {
        this;
        JVM INSTR monitorenter ;
        HttpClient httpclient;
        if (httpClient == null)
        {
            httpClient = new DecompressingHttpClient((new HttpClientProvider(shouldDisableSSLVerification(), getUserAgent(), getOptionalProxy(), getOptionalHttpRequestInterceptors())).get());
        }
        httpclient = httpClient;
        this;
        JVM INSTR monitorexit ;
        return httpclient;
        Exception exception;
        exception;
        throw exception;
    }

    public RequestProviderFactory getHttpRequestProviderFactory()
    {
        this;
        JVM INSTR monitorenter ;
        RequestProviderFactory requestproviderfactory;
        if (requestProviderFactory == null)
        {
            requestProviderFactory = new RequestProviderFactory() {

                final CALContainer this$0;

                public RequestProvider create(String s)
                {
                    return new BasicHTTPRequestProvider(s);
                }

                public RequestProvider create(String s, String s1)
                {
                    return new BasicHTTPRequestProvider(s, s1);
                }

            
            {
                this$0 = CALContainer.this;
                super();
            }
            };
        }
        requestproviderfactory = requestProviderFactory;
        this;
        JVM INSTR monitorexit ;
        return requestproviderfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public InputMethodManager getInputMethodManager()
    {
        this;
        JVM INSTR monitorenter ;
        InputMethodManager inputmethodmanager = (InputMethodManager)getApplication().getSystemService("input_method");
        this;
        JVM INSTR monitorexit ;
        return inputmethodmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public InternetConnection getInternetConnection()
    {
        this;
        JVM INSTR monitorenter ;
        InternetConnection internetconnection;
        if (internetConnection == null)
        {
            internetConnection = new InternetConnection(getConnectivityManager(), getTelephonyManager());
        }
        internetconnection = internetConnection;
        this;
        JVM INSTR monitorexit ;
        return internetconnection;
        Exception exception;
        exception;
        throw exception;
    }

    public JsonSerializer getJsonSerializer()
    {
        this;
        JVM INSTR monitorenter ;
        JsonSerializer jsonserializer;
        if (jsonSerializer == null)
        {
            jsonSerializer = new JsonSerializer(getObjectMapper());
        }
        jsonserializer = jsonSerializer;
        this;
        JVM INSTR monitorexit ;
        return jsonserializer;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract LaunchIntentInterceptor getLaunchIntentInterceptor();

    public abstract LaunchStrategy getLaunchStrategy();

    public android.view.LayoutInflater.Factory getLayoutInflatorFactory()
    {
        return new android.view.LayoutInflater.Factory() {

            final CALContainer this$0;

            public View onCreateView(String s, Context context, AttributeSet attributeset)
            {
                return null;
            }

            
            {
                this$0 = CALContainer.this;
                super();
            }
        };
    }

    public Task getMinVersionCheckCache()
    {
        if (minVersionCheckCache == null)
        {
            PackageInfo packageinfo;
            try
            {
                packageinfo = getApplication().getPackageManager().getPackageInfo(getApplication().getPackageName(), 0);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                throw new CimException(namenotfoundexception);
            }
            minVersionCheckCache = new MinVersionTask(new DefaultHttpService(getHttpClient()), new MinimumIntervalRevalidationPolicy(getConfiguration().getMinVersionCheckRevalidationIntervalInMillis()), (new StringBuilder()).append(getConfiguration().getUserAgentPrefix()).append("-").append(packageinfo.versionName).toString(), getXipRequestProviderFactory());
        }
        return minVersionCheckCache;
    }

    public ObjectMapper getObjectMapper()
    {
        this;
        JVM INSTR monitorenter ;
        ObjectMapper objectmapper;
        if (objectMapper == null)
        {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.setMixInAnnotations(EitherJacksonMixIn.MIX_IN_CONFIG);
        }
        objectmapper = objectMapper;
        this;
        JVM INSTR monitorexit ;
        return objectmapper;
        Exception exception;
        exception;
        throw exception;
    }

    protected List getOptionalHttpRequestInterceptors()
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        arraylist.add(new AddNetworkTypeHeaderInterceptor(getInternetConnection()));
        arraylist.add(new LogAllRequestsInterceptor());
        return arraylist;
    }

    protected HttpHost getOptionalProxy()
    {
        this;
        JVM INSTR monitorenter ;
        return null;
    }

    public PermanentFileCache getPermanentFileCache()
    {
        this;
        JVM INSTR monitorenter ;
        PermanentFileCache permanentfilecache;
        if (fileCache == null)
        {
            fileCache = new PermanentFileCache(getApplication());
        }
        permanentfilecache = fileCache;
        this;
        JVM INSTR monitorexit ;
        return permanentfilecache;
        Exception exception;
        exception;
        throw exception;
    }

    public Resources getResources()
    {
        this;
        JVM INSTR monitorenter ;
        Resources resources = getApplication().getResources();
        this;
        JVM INSTR monitorexit ;
        return resources;
        Exception exception;
        exception;
        throw exception;
    }

    public SharedPreferences getSharedPreferences()
    {
        this;
        JVM INSTR monitorenter ;
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
        this;
        JVM INSTR monitorexit ;
        return sharedpreferences;
        Exception exception;
        exception;
        throw exception;
    }

    public SignInListener getSignInListener()
    {
        this;
        JVM INSTR monitorenter ;
        SignInListener signinlistener;
        if (signInListener == null)
        {
            signInListener = new SignInListener(getAuthenticationClient(), getSoftKeyboard(), getInternetConnection(), getErrorDialogFactory());
        }
        signinlistener = signInListener;
        this;
        JVM INSTR monitorexit ;
        return signinlistener;
        Exception exception;
        exception;
        throw exception;
    }

    public SoftKeyboard getSoftKeyboard()
    {
        this;
        JVM INSTR monitorenter ;
        SoftKeyboard softkeyboard;
        if (softKeyboard == null)
        {
            softKeyboard = new SoftKeyboard();
        }
        softkeyboard = softKeyboard;
        this;
        JVM INSTR monitorexit ;
        return softkeyboard;
        Exception exception;
        exception;
        throw exception;
    }

    public AnalyticsLogger getSplunkLogger()
    {
        if (splunkLogger == null)
        {
            splunkLogger = new AnalyticsTaskQueueLogger(getAnalyticsTaskQueue(), getConfiguration().getSplunkAppName(), "http://xfinitytv.comcast.net/xtv/authkey/event/store/?");
        }
        return splunkLogger;
    }

    public TalkDelegateFactory getTalkDelegateFactory()
    {
        this;
        JVM INSTR monitorenter ;
        TalkDelegateFactory talkdelegatefactory;
        if (talkDelegateFactory == null)
        {
            talkDelegateFactory = new TalkDelegateFactory(getAccessibilityUtil());
        }
        talkdelegatefactory = talkDelegateFactory;
        this;
        JVM INSTR monitorexit ;
        return talkdelegatefactory;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutorFactory getTaskExecutorFactory()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutorFactory taskexecutorfactory;
        if (taskExecutorFactory == null)
        {
            taskExecutorFactory = new TaskExecutorFactory(new SingleThreadedExecutorFactory(), getUiThreadExecutor());
        }
        taskexecutorfactory = taskExecutorFactory;
        this;
        JVM INSTR monitorexit ;
        return taskexecutorfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public TelephonyManager getTelephonyManager()
    {
        this;
        JVM INSTR monitorenter ;
        TelephonyManager telephonymanager = (TelephonyManager)getApplication().getSystemService("phone");
        this;
        JVM INSTR monitorexit ;
        return telephonymanager;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract TrackingService getTrackingService();

    public TypefaceManager getTypefaceManager()
    {
        this;
        JVM INSTR monitorenter ;
        return null;
    }

    public UIUtil getUIUtil()
    {
        this;
        JVM INSTR monitorenter ;
        UIUtil uiutil;
        if (uiUtil == null)
        {
            uiUtil = new UIUtil(getInternetConnection());
        }
        uiutil = uiUtil;
        this;
        JVM INSTR monitorexit ;
        return uiutil;
        Exception exception;
        exception;
        throw exception;
    }

    public UIThreadExecutor getUiThreadExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        UIThreadExecutor uithreadexecutor;
        if (uiThreadExecutor == null)
        {
            uiThreadExecutor = new UIThreadExecutor(new Handler(Looper.getMainLooper()));
        }
        uithreadexecutor = uiThreadExecutor;
        this;
        JVM INSTR monitorexit ;
        return uithreadexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    protected BasicHeader getUserAgent()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = userAgent;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = getApplication().getPackageManager().getPackageInfo(getApplication().getPackageName(), 0);
        String s;
        String s1;
        String s2;
        s = getConfiguration().getUserAgentPrefix();
        s1 = ((PackageInfo) (obj)).versionName;
        s2 = Build.MANUFACTURER;
        if (Build.MODEL == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        obj = Build.MODEL.replaceAll(" ", "_");
_L3:
        userAgent = new BasicHeader("User-Agent", String.format("%s %s / %s; %s %d / Android %s / %s / %s", new Object[] {
            s, s1, s2, obj, Integer.valueOf(getAndroidDevice().getScreenWidth()), android.os.Build.VERSION.RELEASE, Build.BRAND, getAndroidDevice().getDeviceId()
        }));
_L2:
        obj = userAgent;
        this;
        JVM INSTR monitorexit ;
        return ((BasicHeader) (obj));
        obj;
        throw new CimException(((Throwable) (obj)));
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj = "null";
          goto _L3
    }

    public abstract UserManager getUserManager();

    public Integer getVersionCode()
    {
        if (versionCode == null)
        {
            PackageInfo packageinfo;
            try
            {
                packageinfo = getApplication().getPackageManager().getPackageInfo(getApplication().getPackageName(), 0);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                throw new CimException(namenotfoundexception);
            }
            versionCode = Integer.valueOf(packageinfo.versionCode);
        }
        return versionCode;
    }

    public XipRequestProviderFactory getXipRequestProviderFactory()
    {
        this;
        JVM INSTR monitorenter ;
        XipRequestProviderFactory xiprequestproviderfactory;
        if (xipRequestProviderFactory == null)
        {
            xipRequestProviderFactory = new XipRequestProviderFactory(getHttpRequestProviderFactory(), getXipServer());
        }
        xiprequestproviderfactory = xipRequestProviderFactory;
        this;
        JVM INSTR monitorexit ;
        return xiprequestproviderfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public XipServer getXipServer()
    {
        this;
        JVM INSTR monitorenter ;
        XipServer xipserver = new XipServer(getConfiguration().getXipUri());
        this;
        JVM INSTR monitorexit ;
        return xipserver;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract boolean shouldDisableSSLVerification();

}
