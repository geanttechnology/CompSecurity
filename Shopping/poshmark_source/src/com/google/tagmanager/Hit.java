// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.text.TextUtils;

class Hit
{

    private final long mHitFirstDispatchTime;
    private final long mHitId;
    private final long mHitTime;
    private String mHitUrl;

    Hit(long l, long l1)
    {
        mHitId = l;
        mHitTime = l1;
        mHitFirstDispatchTime = 0L;
    }

    Hit(long l, long l1, long l2)
    {
        mHitId = l;
        mHitTime = l1;
        mHitFirstDispatchTime = l2;
    }

    long getHitFirstDispatchTime()
    {
        return mHitFirstDispatchTime;
    }

    long getHitId()
    {
        return mHitId;
    }

    long getHitTime()
    {
        return mHitTime;
    }

    String getHitUrl()
    {
        return mHitUrl;
    }

    void setHitUrl(String s)
    {
        if (s == null || TextUtils.isEmpty(s.trim()))
        {
            return;
        } else
        {
            mHitUrl = s;
            return;
        }
    }
}
