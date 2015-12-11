// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.content.Context;
import android.util.Log;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.communication.authentication.RequestSigner;
import com.amazon.device.utils.DetUtil;
import com.amazon.device.utils.NetworkManager;
import com.amazon.device.utils.NullStatusNotifier;
import com.amazon.device.utils.OAuthHelper;
import com.amazon.device.utils.StatusNotifier;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.device.crashmanager:
//            OAuthRequestSigner, CrashDetailsAggregator, CrashDetailsCollector, AppFileArtifactSource, 
//            AmazonPackageLookup, CrashDescriptorStorageUtil, MetricsHeaderProcessorFactory, JavaCrashArtifactProcessor, 
//            ArtifactUploader, DomainChooser, DetEndpointConfig, CrashDetailsCollectable

public final class CrashDetectionHelper
    implements Thread.UncaughtExceptionHandler
{

    private static final int ANDROID_API_VERSION;
    private static final ExecutorService SINGLE_THREADED_EXECUTOR = Executors.newSingleThreadExecutor();
    private static final String TAG = com/amazon/device/crashmanager/CrashDetectionHelper.getName();
    private static CrashDetectionHelper sCrashDetectionHelper = null;
    private final AmazonPackageLookup mAmazonPackageLookup;
    private final AppFileArtifactSource mAppFileArtifactSource;
    private CrashDescriptorStorageUtil mCrashDescUtil;
    private final CrashDetailsAggregator mCrashDetailAggregator;
    private final String mDeviceId;
    private final String mDeviceType;
    private final DomainChooser mDomainChooser;
    private final MetricsFactory mMetricsFactory;
    private final NetworkManager mNetworkManager;
    private final Thread.UncaughtExceptionHandler mPreviousHandler = Thread.getDefaultUncaughtExceptionHandler();
    private RequestSigner mRequestSigner;
    private final StatusNotifier mStatusNotifier = new NullStatusNotifier();

    CrashDetectionHelper(String s, String s1, OAuthHelper oauthhelper, MetricsFactory metricsfactory, AppFileArtifactSource appfileartifactsource, AmazonPackageLookup amazonpackagelookup, DomainChooser domainchooser, 
            NetworkManager networkmanager, CrashDescriptorStorageUtil crashdescriptorstorageutil, CrashDetailsAggregator crashdetailsaggregator)
    {
        mAppFileArtifactSource = appfileartifactsource;
        mAmazonPackageLookup = amazonpackagelookup;
        mMetricsFactory = metricsfactory;
        mRequestSigner = new OAuthRequestSigner(oauthhelper);
        mDomainChooser = domainchooser;
        mDeviceType = s;
        mDeviceId = s1;
        mNetworkManager = networkmanager;
        mCrashDescUtil = crashdescriptorstorageutil;
        mCrashDetailAggregator = crashdetailsaggregator;
    }

    public static CrashDetectionHelper getInstance()
    {
        if (ANDROID_API_VERSION < 9)
        {
            Log.e(TAG, "Could not set up crash detection, android versions before Gingerbread <9 are known to crash.");
            return null;
        }
        if (sCrashDetectionHelper == null)
        {
            Log.w(TAG, "CrashDetectionHelper.getInstance() called before CrashDetectionHelper.setUpCrashDetection().");
        }
        return sCrashDetectionHelper;
    }

    public static CrashDetectionHelper setUpCrashDetection(String s, String s1, OAuthHelper oauthhelper, MetricsFactory metricsfactory, DomainChooser domainchooser, Context context, boolean flag)
    {
        if (ANDROID_API_VERSION < 9)
        {
            Log.e(TAG, "Could not set up crash detection, android versions before Gingerbread <9 are known to crash.");
            return null;
        }
        if (s == null)
        {
            Log.e(TAG, "Could not set up crash detection, device type is null.");
            return null;
        }
        if (s1 == null)
        {
            Log.e(TAG, "Could not set up crash detection, device id is null.");
            return null;
        }
        if (oauthhelper == null)
        {
            Log.e(TAG, "Could not set up crash detection, oauth helper is null.");
            return null;
        }
        if (metricsfactory == null)
        {
            Log.e(TAG, "Could not set up crash detection, metrics factory is null.");
            return null;
        }
        if (context == null)
        {
            Log.e(TAG, "Could not set up crash detection, context is null.");
            return null;
        }
        if (domainchooser == null)
        {
            Log.e(TAG, "Could not set up crash detection, domainChooser is null.");
        }
        com/amazon/device/crashmanager/CrashDetectionHelper;
        JVM INSTR monitorenter ;
        if (sCrashDetectionHelper == null)
        {
            CrashDetailsAggregator crashdetailsaggregator = new CrashDetailsAggregator();
            crashdetailsaggregator.appendCollector(new CrashDetailsCollector(context));
            sCrashDetectionHelper = new CrashDetectionHelper(s, s1, oauthhelper, metricsfactory, new AppFileArtifactSource(context, crashdetailsaggregator), new AmazonPackageLookup(context), domainchooser, NetworkManager.instance(context), new CrashDescriptorStorageUtil(context.getSharedPreferences("CrashDetectionHelper.crashManager", 0), 50, 0x5265c00L), crashdetailsaggregator);
            sCrashDetectionHelper.uploadCrashReportAsync();
        }
        com/amazon/device/crashmanager/CrashDetectionHelper;
        JVM INSTR monitorexit ;
        if (flag)
        {
            if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof CrashDetectionHelper))
            {
                Log.i(TAG, "Installing crash detector as default exception handler.");
                Thread.setDefaultUncaughtExceptionHandler(sCrashDetectionHelper);
            } else
            {
                Log.i(TAG, "Crash detector already set up.");
            }
        } else
        {
            Log.i(TAG, "Caller opted out of installing uncaught exception handler.");
        }
        return sCrashDetectionHelper;
        s;
        com/amazon/device/crashmanager/CrashDetectionHelper;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void appendCrashDetailsCollector(CrashDetailsCollectable crashdetailscollectable)
    {
        if (mCrashDetailAggregator == null)
        {
            Log.e(TAG, "Could not set up additional crash detail collector. Initialize CrashDetectionHelper first.");
            return;
        } else
        {
            mCrashDetailAggregator.appendCollector(crashdetailscollectable);
            return;
        }
    }

    public void reportCrash(Throwable throwable)
    {
        mAppFileArtifactSource.saveCrash(throwable);
        uploadCrashReportAsync();
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        mAppFileArtifactSource.saveCrash(throwable);
        if (mPreviousHandler != null)
        {
            mPreviousHandler.uncaughtException(thread, throwable);
        }
        return;
        Exception exception;
        exception;
        if (mPreviousHandler != null)
        {
            mPreviousHandler.uncaughtException(thread, throwable);
        }
        throw exception;
    }

    void uploadCrashReport()
    {
        com.amazon.client.metrics.MetricEvent metricevent;
        if (!mNetworkManager.isWifiConnected())
        {
            Log.i(TAG, "Skipping crash report upload. WiFi is not connected.");
            return;
        }
        metricevent = mMetricsFactory.createMetricEvent("CrashManager", "uploadCrashEntries");
        DetUtil detutil = new DetUtil();
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(mAppFileArtifactSource);
        MetricsHeaderProcessorFactory metricsheaderprocessorfactory = new MetricsHeaderProcessorFactory(mAmazonPackageLookup, metricevent);
        LinkedList linkedlist1 = new LinkedList();
        linkedlist1.add(new JavaCrashArtifactProcessor(detutil, mDeviceType, mDeviceId, null, metricsheaderprocessorfactory, mCrashDescUtil));
        (new ArtifactUploader(DetEndpointConfig.getServiceEndpoint(mDomainChooser.chooseDomain()), mDeviceType, mDeviceId, linkedlist, linkedlist1, mCrashDescUtil, mStatusNotifier, mRequestSigner, mNetworkManager)).uploadArtifacts(metricevent);
        mMetricsFactory.record(metricevent);
        return;
        Object obj;
        obj;
        Log.v(TAG, "Exception thrown while uploading crash entries", ((Throwable) (obj)));
        mMetricsFactory.record(metricevent);
        return;
        obj;
        mMetricsFactory.record(metricevent);
        throw obj;
    }

    public void uploadCrashReportAsync()
    {
        SINGLE_THREADED_EXECUTOR.execute(new Runnable() {

            final CrashDetectionHelper this$0;

            public void run()
            {
                try
                {
                    uploadCrashReport();
                    return;
                }
                catch (Exception exception)
                {
                    Log.e(CrashDetectionHelper.TAG, "Failed to upload crash.", exception);
                }
            }

            
            {
                this$0 = CrashDetectionHelper.this;
                super();
            }
        });
    }

    static 
    {
        ANDROID_API_VERSION = android.os.Build.VERSION.SDK_INT;
    }

}
