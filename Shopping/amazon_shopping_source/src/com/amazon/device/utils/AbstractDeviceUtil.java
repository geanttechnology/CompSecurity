// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.util.Log;
import java.security.SecureRandom;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.device.utils:
//            DeviceUtil, BackgroundThreadFactory

public abstract class AbstractDeviceUtil extends ContentObserver
    implements DeviceUtil
{

    protected final ThreadFactory mBackgroundThreadFactory;
    private String mCustomerID;
    private final ThreadPoolExecutor mFetchCustomerIDThreadPool;
    private final ThreadPoolExecutor mFetchSessionIDThreadPool;
    private String mRemoteIP;
    private String mSessionID;
    protected final SharedPreferences mSharedPrefs;
    private String mUserAgent;

    public AbstractDeviceUtil(Context context)
    {
        super(null);
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null");
        } else
        {
            mSharedPrefs = context.getSharedPreferences("com.amazon.device.utils", 0);
            mBackgroundThreadFactory = new BackgroundThreadFactory();
            mFetchSessionIDThreadPool = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), mBackgroundThreadFactory);
            mFetchCustomerIDThreadPool = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), mBackgroundThreadFactory);
            return;
        }
    }

    private void createCustomerID()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mCustomerID;
        if (s == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mFetchCustomerIDThreadPool.execute(new Runnable() {

            final AbstractDeviceUtil this$0;

            public void run()
            {
                String s1 = mSharedPrefs.getString("clickstreamCustomerID", null);
                Object obj = s1;
                if (s1 == null)
                {
                    obj = new SecureRandom();
                    obj = getRandomDigits(9, ((SecureRandom) (obj)));
                    android.content.SharedPreferences.Editor editor = mSharedPrefs.edit();
                    editor.putString("clickstreamCustomerID", ((String) (obj)));
                    editor.commit();
                    Log.d("AbstractDeviceUtil", (new StringBuilder()).append("Generated a new CustomerId ").append(((String) (obj))).toString());
                }
                mCustomerID = ((String) (obj));
            }

            
            {
                this$0 = AbstractDeviceUtil.this;
                super();
            }
        });
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void createRemoteIp()
    {
        mRemoteIP = "10.0.0.1";
    }

    private void createSessionID()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mSessionID;
        if (s == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mFetchSessionIDThreadPool.execute(new Runnable() {

            final AbstractDeviceUtil this$0;

            public void run()
            {
                String s1 = mSharedPrefs.getString("clickstreamSessionID", null);
                Object obj = s1;
                if (s1 == null)
                {
                    obj = new SecureRandom();
                    obj = String.format("%s-%s-%s", new Object[] {
                        getRandomDigits(3, ((SecureRandom) (obj))), getRandomDigits(7, ((SecureRandom) (obj))), getRandomDigits(7, ((SecureRandom) (obj)))
                    });
                    android.content.SharedPreferences.Editor editor = mSharedPrefs.edit();
                    editor.putString("clickstreamSessionID", ((String) (obj)));
                    editor.commit();
                    Log.d("AbstractDeviceUtil", (new StringBuilder()).append("Generated a new SessionID").append(((String) (obj))).toString());
                }
                mSessionID = ((String) (obj));
            }

            
            {
                this$0 = AbstractDeviceUtil.this;
                super();
            }
        });
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void createUserAgent()
    {
        if (fetchDeviceType() != null)
        {
            mUserAgent = String.format("%s:::%s:::%s:::%s", new Object[] {
                "", "", fetchDeviceType(), android.os.Build.VERSION.INCREMENTAL
            });
        }
    }

    private String getRandomDigits(int i, SecureRandom securerandom)
    {
        return String.format((new StringBuilder()).append("%0").append(String.format("%dd", new Object[] {
            Integer.valueOf(i)
        })).toString(), new Object[] {
            Integer.valueOf(securerandom.nextInt((int)Math.pow(10D, i) - 1))
        });
    }

    public String fetchCustomerID()
    {
        if (mCustomerID == null)
        {
            createCustomerID();
        }
        return mCustomerID;
    }

    public String fetchRemoteIP()
    {
        if (mRemoteIP == null)
        {
            createRemoteIp();
        }
        return mRemoteIP;
    }

    public String fetchSessionID()
    {
        if (mSessionID == null)
        {
            createSessionID();
        }
        return mSessionID;
    }

    public String fetchUserAgent()
    {
        if (mUserAgent == null)
        {
            createUserAgent();
        }
        return mUserAgent;
    }



/*
    static String access$102(AbstractDeviceUtil abstractdeviceutil, String s)
    {
        abstractdeviceutil.mCustomerID = s;
        return s;
    }

*/


/*
    static String access$202(AbstractDeviceUtil abstractdeviceutil, String s)
    {
        abstractdeviceutil.mSessionID = s;
        return s;
    }

*/
}
