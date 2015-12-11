// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.google.tagmanager:
//            HitSender, HitSendingThreadImpl, SendHitRateLimiter, RateLimiter, 
//            Log, HitSendingThread

class DelayedHitSender
    implements HitSender
{

    private static DelayedHitSender sInstance;
    private static final Object sInstanceLock = new Object();
    private RateLimiter mRateLimiter;
    private HitSendingThread mSendingThread;
    private String mWrapperQueryParameter;
    private String mWrapperUrl;

    private DelayedHitSender(Context context)
    {
        this(((HitSendingThread) (HitSendingThreadImpl.getInstance(context))), ((RateLimiter) (new SendHitRateLimiter())));
    }

    DelayedHitSender(HitSendingThread hitsendingthread, RateLimiter ratelimiter)
    {
        mSendingThread = hitsendingthread;
        mRateLimiter = ratelimiter;
    }

    public static HitSender getInstance(Context context)
    {
        synchronized (sInstanceLock)
        {
            if (sInstance == null)
            {
                sInstance = new DelayedHitSender(context);
            }
            context = sInstance;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public boolean sendHit(String s)
    {
        if (!mRateLimiter.tokenAvailable())
        {
            Log.w("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        String s1 = s;
        if (mWrapperUrl != null)
        {
            s1 = s;
            if (mWrapperQueryParameter != null)
            {
                try
                {
                    s1 = (new StringBuilder()).append(mWrapperUrl).append("?").append(mWrapperQueryParameter).append("=").append(URLEncoder.encode(s, "UTF-8")).toString();
                    Log.v((new StringBuilder()).append("Sending wrapped url hit: ").append(s1).toString());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Log.w("Error wrapping URL for testing.", s);
                    return false;
                }
            }
        }
        mSendingThread.sendHit(s1);
        return true;
    }

    public void setUrlWrapModeForTesting(String s, String s1)
    {
        mWrapperUrl = s;
        mWrapperQueryParameter = s1;
    }

}
