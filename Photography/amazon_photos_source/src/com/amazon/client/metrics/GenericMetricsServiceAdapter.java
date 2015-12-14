// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import com.amazon.client.metrics.configuration.MetricsConfiguration;
import com.amazon.client.metrics.configuration.MetricsConfigurationException;
import com.amazon.client.metrics.transport.OAuthHelper;
import com.amazon.device.utils.CustomDeviceUtil;
import com.amazon.dp.logger.DPLogger;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            BaseMetricsServiceFactory, MetricEntry, Priority, MetricsService, 
//            IMetricsService, DataPointEnvelope

public class GenericMetricsServiceAdapter
{

    private static final DPLogger log = new DPLogger("MetricsServiceAdapter");
    private static GenericMetricsServiceAdapter sGenericMetricsServiceAdapter;
    private static MetricsConfiguration sMetricsConfiguration;
    private final IMetricsService mBinder = new IMetricsService.Stub() {

        final GenericMetricsServiceAdapter this$0;

        public boolean getRecordMetricsSetting()
        {
            return true;
        }

        public void record(int i, String s, String s1, long l, List list)
            throws RemoteException
        {
            GenericMetricsServiceAdapter.log.verbose("record", (new StringBuilder()).append("[ ").append(s).append(" , ").append(s1).append(" ]").toString(), new Object[0]);
            Handler handler = getHandler();
            Message message = handler.obtainMessage();
            message.arg1 = i;
            message.obj = new MetricEntry(l, s, s1, DataPointEnvelope.convertFromEnvelopes(list));
            handler.sendMessage(message);
        }

            
            {
                this$0 = GenericMetricsServiceAdapter.this;
                super();
            }
    };
    private final Context mContext;
    private final CustomDeviceUtil mDeviceUtil;
    private final Handler mHandler;
    private final HandlerThread mMainThread = new HandlerThread("MetricsService");
    private final MetricsService mMetricsService;
    private final BaseMetricsServiceFactory mMetricsServiceFactory;

    private GenericMetricsServiceAdapter(Context context)
    {
        log.debug("initialize", "initialize(context) - Metrics service", new Object[0]);
        mContext = context;
        mMainThread.start();
        mHandler = new Handler(mMainThread.getLooper(), new android.os.Handler.Callback() {

            final GenericMetricsServiceAdapter this$0;

            public boolean handleMessage(Message message)
            {
                return handleMessageForService(message);
            }

            
            {
                this$0 = GenericMetricsServiceAdapter.this;
                super();
            }
        });
        try
        {
            mDeviceUtil = new CustomDeviceUtil(context);
            mMetricsServiceFactory = new BaseMetricsServiceFactory(context, mDeviceUtil, sMetricsConfiguration);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        mMetricsService = mMetricsServiceFactory.createMetricsService();
    }

    public static GenericMetricsServiceAdapter getInstance(Context context)
    {
        if (sGenericMetricsServiceAdapter == null)
        {
            sGenericMetricsServiceAdapter = new GenericMetricsServiceAdapter(context);
        }
        return sGenericMetricsServiceAdapter;
    }

    public Handler getHandler()
    {
        return mHandler;
    }

    public IMetricsService getMetricsService()
    {
        return sGenericMetricsServiceAdapter.mBinder;
    }

    protected boolean handleMessageForService(Message message)
    {
        if (message.obj != null && (message.obj instanceof MetricEntry) && mMetricsService != null)
        {
            Priority priority = Priority.fromInt(message.arg1);
            message = (MetricEntry)message.obj;
            mMetricsService.record(priority, message);
            return true;
        } else
        {
            log.error("handleMessageForService", (new StringBuilder()).append("Received unknown android.os.Message ").append(message).toString(), new Object[0]);
            return false;
        }
    }

    public void setDeviceSerialNumber(String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("deviceId must not be null or empty");
        } else
        {
            mDeviceUtil.setDeviceSerialNumber(s);
            return;
        }
    }

    public void setDeviceType(String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("deviceType must not be null or empty");
        } else
        {
            mDeviceUtil.setDeviceType(s);
            return;
        }
    }

    public void setOAuthHelper(OAuthHelper oauthhelper)
    {
        mMetricsServiceFactory.setOAuthHelper(oauthhelper);
    }


}
