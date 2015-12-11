// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import java.util.concurrent.TimeUnit;

public class LastAsinPlayHolder
{
    private static class SingletonHolder
    {

        private static final LastAsinPlayHolder INSTANCE = new LastAsinPlayHolder();



        private SingletonHolder()
        {
        }
    }


    private static final long VALID_DURATION;
    private volatile String mAsin;
    private volatile long mStartTime;

    private LastAsinPlayHolder()
    {
    }


    public static LastAsinPlayHolder getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public void reset()
    {
        mAsin = null;
        mStartTime = -1L;
    }

    public void setAsin(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("The ASIN has to be set explicitly.");
        } else
        {
            mAsin = s;
            mStartTime = System.currentTimeMillis();
            return;
        }
    }

    public String takeAsin()
    {
        String s;
        boolean flag;
        if (System.currentTimeMillis() - mStartTime <= VALID_DURATION)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            s = mAsin;
        } else
        {
            s = null;
        }
        reset();
        return s;
    }

    static 
    {
        VALID_DURATION = TimeUnit.MINUTES.toMillis(10L);
    }
}
