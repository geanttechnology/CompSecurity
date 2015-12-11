// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk;

import com.supersonic.mediationsdk.config.AbstractAdapterConfig;
import com.supersonic.mediationsdk.config.ConfigValidationResult;
import com.supersonic.mediationsdk.logger.LogListener;
import com.supersonic.mediationsdk.logger.LoggingApi;
import com.supersonic.mediationsdk.logger.SupersonicError;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.sdk.BaseApi;
import com.supersonic.mediationsdk.sdk.GeneralProperties;
import com.supersonic.mediationsdk.sdk.RewardedVideoManagerListener;
import com.supersonic.mediationsdk.sdk.SupersonicFactory;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.supersonic.mediationsdk:
//            SupersonicObject

public abstract class AbstractAdapter
    implements BaseApi, LoggingApi, Comparable
{

    private final String ADAPTER_CORE_SDK_VERSION_KEY = "SdkVersion";
    private final String ADAPTER_VERSION_KEY = "AdapterVersion";
    private Object mInitFlagsLocker;
    private boolean mIsInterstitialSupported;
    private boolean mIsOfferwallSupported;
    private boolean mIsRewardedVideoSupported;
    private SupersonicLoggerManager mLoggerManager;
    private String mProviderName;
    private String mProviderUrl;
    private Boolean mRVInitFlag;
    private int mRVPriority;
    private int mRewardedVideoTimeout;
    private TimerTask timerTask;

    public AbstractAdapter(String s, String s1)
    {
        mIsRewardedVideoSupported = false;
        mIsInterstitialSupported = false;
        mIsOfferwallSupported = false;
        mRVPriority = -1;
        mLoggerManager = SupersonicLoggerManager.getLogger();
        String s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        mProviderName = s2;
        mProviderUrl = s;
        mRVInitFlag = null;
        mInitFlagsLocker = new Object();
        setRewardedVideoSupport(true);
        setCustomParams();
    }

    private void setCustomParams()
    {
        Object obj;
        try
        {
            obj = ((SupersonicObject)SupersonicFactory.getInstance()).getAge();
        }
        catch (Exception exception)
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.INTERNAL, (new StringBuilder()).append(getProviderName()).append(":setCustomParams():").append(exception.getStackTrace()).toString(), 3);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        setAge(((Integer) (obj)).intValue());
        obj = ((SupersonicObject)SupersonicFactory.getInstance()).getGender();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        setGender(((String) (obj)));
    }

    protected void cancelTimer()
    {
        try
        {
            if (timerTask != null)
            {
                timerTask.cancel();
                timerTask = null;
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public int compareTo(AbstractAdapter abstractadapter)
    {
        if (mRVPriority < abstractadapter.getRewardedVideoPriority())
        {
            return -1;
        }
        return mRVPriority <= abstractadapter.getRewardedVideoPriority() ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((AbstractAdapter)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof AbstractAdapter))
        {
            obj = (AbstractAdapter)obj;
            return mProviderName.equals(((AbstractAdapter) (obj)).mProviderName);
        } else
        {
            return false;
        }
    }

    public String getProviderName()
    {
        return mProviderName;
    }

    public int getRewardedVideoPriority()
    {
        return mRVPriority;
    }

    protected String getUrl()
    {
        return mProviderUrl;
    }

    public abstract String getVersion();

    protected boolean isInterstitialSupported()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsInterstitialSupported;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    protected boolean isOfferwallSupported()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsOfferwallSupported;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    protected boolean isRVInitFinished()
    {
        Object obj = mInitFlagsLocker;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (mRVInitFlag != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean isRVInitSucceed()
    {
        Object obj = mInitFlagsLocker;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (mRVInitFlag != null && mRVInitFlag.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean isRewardedVideoSupported()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsRewardedVideoSupported;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public SupersonicError isVersionSupported(String s, Map map)
    {
        String s1 = getVersion();
        GeneralProperties.getProperties().putKey((new StringBuilder()).append(getProviderName()).append("AdapterVersion").toString(), s1);
        GeneralProperties.getProperties().putKey((new StringBuilder()).append(getProviderName()).append("SdkVersion").toString(), s);
        if (s1 == null)
        {
            return ErrorBuilder.buildUnsupportedSdkVersion(s, getProviderName());
        }
        if (map == null || !map.containsKey(s1))
        {
            map = new ArrayList();
        } else
        {
            map = (List)map.get(s1);
        }
        if (map != null && map.contains(s))
        {
            return null;
        } else
        {
            return ErrorBuilder.buildUnsupportedSdkVersion(s, getProviderName());
        }
    }

    protected void log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag supersonictag, String s, int i)
    {
        mLoggerManager.onLog(supersonictag, s, i);
    }

    protected void setInterstitialSupport(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mIsInterstitialSupported = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setLogListener(LogListener loglistener)
    {
    }

    protected void setOfferwallSupport(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mIsOfferwallSupported = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void setRVInitStatus(boolean flag)
    {
        synchronized (mInitFlagsLocker)
        {
            mRVInitFlag = Boolean.valueOf(flag);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setRewardedVideoPriority(int i)
    {
        mRVPriority = i;
    }

    protected void setRewardedVideoSupport(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mIsRewardedVideoSupported = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setRewardedVideoTimeout(int i)
    {
        mRewardedVideoTimeout = i;
    }

    protected void startTimer(final RewardedVideoManagerListener listener)
    {
        timerTask = new TimerTask() {

            final AbstractAdapter this$0;
            final RewardedVideoManagerListener val$listener;

            public void run()
            {
                listener.onVideoAvailabilityChanged(false, AbstractAdapter.this);
            }

            
            {
                this$0 = AbstractAdapter.this;
                listener = rewardedvideomanagerlistener;
                super();
            }
        };
        (new Timer()).schedule(timerTask, mRewardedVideoTimeout * 1000);
    }

    protected ConfigValidationResult validateConfigBeforeInit(AbstractAdapterConfig abstractadapterconfig, RewardedVideoManagerListener rewardedvideomanagerlistener)
    {
        abstractadapterconfig = abstractadapterconfig.isConfigValid();
        if (!abstractadapterconfig.isValid())
        {
            SupersonicError supersonicerror = abstractadapterconfig.getSupersonicError();
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(supersonicerror.getErrorMessage()).toString(), 2);
            if (rewardedvideomanagerlistener != null)
            {
                rewardedvideomanagerlistener.onRewardedVideoInitFail(supersonicerror, this);
            }
        }
        return abstractadapterconfig;
    }
}
