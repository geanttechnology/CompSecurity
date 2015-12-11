// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            ClientIdDefaultProvider, ScreenResolutionDefaultProvider, AppFieldsDefaultProvider, GAUsage, 
//            Utils, Log, TrackerHandler

public class Tracker
{

    static final long MAX_TOKENS = 0x1d4c0L;
    static final long NUM_TOKENS_PER_HIT = 2000L;
    private final AppFieldsDefaultProvider mAppFieldsDefaultProvider;
    private final ClientIdDefaultProvider mClientIdDefaultProvider;
    private final TrackerHandler mHandler;
    private long mLastTrackTime;
    private final String mName;
    private final Map mParams;
    private final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider;
    private long mTokens;

    Tracker(String s, String s1, TrackerHandler trackerhandler)
    {
        this(s, s1, trackerhandler, ClientIdDefaultProvider.getProvider(), ScreenResolutionDefaultProvider.getProvider(), AppFieldsDefaultProvider.getProvider());
    }

    Tracker(String s, String s1, TrackerHandler trackerhandler, ClientIdDefaultProvider clientiddefaultprovider, ScreenResolutionDefaultProvider screenresolutiondefaultprovider, AppFieldsDefaultProvider appfieldsdefaultprovider)
    {
        mParams = new HashMap();
        mTokens = 0x1d4c0L;
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        } else
        {
            mName = s;
            mHandler = trackerhandler;
            mParams.put("&tid", s1);
            mParams.put("useSecure", "1");
            mClientIdDefaultProvider = clientiddefaultprovider;
            mScreenResolutionDefaultProvider = screenresolutiondefaultprovider;
            mAppFieldsDefaultProvider = appfieldsdefaultprovider;
            return;
        }
    }

    public String get(String s)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET);
        if (!TextUtils.isEmpty(s))
        {
            if (mParams.containsKey(s))
            {
                return (String)mParams.get(s);
            }
            if (s.equals("&ul"))
            {
                return Utils.getLanguage(Locale.getDefault());
            }
            if (mClientIdDefaultProvider != null && mClientIdDefaultProvider.providesField(s))
            {
                return mClientIdDefaultProvider.getValue(s);
            }
            if (mScreenResolutionDefaultProvider != null && mScreenResolutionDefaultProvider.providesField(s))
            {
                return mScreenResolutionDefaultProvider.getValue(s);
            }
            if (mAppFieldsDefaultProvider != null && mAppFieldsDefaultProvider.providesField(s))
            {
                return mAppFieldsDefaultProvider.getValue(s);
            }
        }
        return null;
    }

    public String getName()
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER_NAME);
        return mName;
    }

    public void send(Map map)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
        HashMap hashmap = new HashMap();
        hashmap.putAll(mParams);
        if (map != null)
        {
            hashmap.putAll(map);
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("&tid")))
        {
            Log.w(String.format("Missing tracking id (%s) parameter.", new Object[] {
                "&tid"
            }));
        }
        String s = (String)hashmap.get("&t");
        map = s;
        if (TextUtils.isEmpty(s))
        {
            Log.w(String.format("Missing hit type (%s) parameter.", new Object[] {
                "&t"
            }));
            map = "";
        }
        if (!map.equals("transaction") && !map.equals("item") && !tokensAvailable())
        {
            Log.w("Too many hits sent too quickly, rate limiting invoked.");
            return;
        } else
        {
            mHandler.sendHit(hashmap);
            return;
        }
    }

    public void set(String s, String s1)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET);
        if (s1 == null)
        {
            mParams.remove(s);
            return;
        } else
        {
            mParams.put(s, s1);
            return;
        }
    }

    void setLastTrackTime(long l)
    {
        mLastTrackTime = l;
    }

    void setTokens(long l)
    {
        mTokens = l;
    }

    boolean tokensAvailable()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = System.currentTimeMillis();
        if (mTokens >= 0x1d4c0L)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        l1 = l - mLastTrackTime;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        mTokens = Math.min(0x1d4c0L, mTokens + l1);
        mLastTrackTime = l;
        if (mTokens < 2000L) goto _L2; else goto _L1
_L1:
        mTokens = mTokens - 2000L;
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        Log.w("Excessive tracking detected.  Tracking call ignored.");
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
