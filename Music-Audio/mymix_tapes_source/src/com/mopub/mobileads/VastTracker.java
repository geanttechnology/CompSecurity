// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;

public class VastTracker
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private boolean mCalled;
    private boolean mIsRepeatable;
    protected final String mTrackingUrl;

    public VastTracker(String s)
    {
        Preconditions.checkNotNull(s);
        mTrackingUrl = s;
    }

    public VastTracker(String s, boolean flag)
    {
        this(s);
        mIsRepeatable = flag;
    }

    public String getTrackingUrl()
    {
        return mTrackingUrl;
    }

    public boolean isRepeatable()
    {
        return mIsRepeatable;
    }

    public boolean isTracked()
    {
        return mCalled;
    }

    public void setTracked()
    {
        mCalled = true;
    }
}
