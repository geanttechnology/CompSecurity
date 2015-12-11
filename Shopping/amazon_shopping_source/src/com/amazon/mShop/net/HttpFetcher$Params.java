// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            HttpFetcher, ServiceCallIdentifier

public static abstract class mTag
{

    protected boolean mCached;
    private final ber mSubscriber;
    protected Object mTag;
    protected String mUrl;

    public String getCacheKey()
    {
        return getUrl();
    }

    public abstract ServiceCallIdentifier getServiceCallIdentifier();

    public ber getSubscriber()
    {
        return mSubscriber;
    }

    public Object getTag()
    {
        return mTag;
    }

    public String getUrl()
    {
        return mUrl;
    }

    public void setCached(boolean flag)
    {
        mCached = flag;
    }

    public ber(String s, ber ber)
    {
        mUrl = s;
        mSubscriber = ber;
        mTag = null;
    }

    public ber(String s, ber ber, Object obj)
    {
        mUrl = s;
        mSubscriber = ber;
        mTag = obj;
    }
}
