// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import com.amazon.mShop.util.ImageUtil;

// Referenced classes of package com.amazon.mShop.net:
//            BitmapFetcher, ServiceCallIdentifier

public static class mBaseUrl extends mBaseUrl
{

    private static final ServiceCallIdentifier sServiceCallIdentifier = new ServiceCallIdentifier("images", "getImages");
    private String mBaseUrl;
    private int mMaxDimension;
    protected rity mResidencePriority;
    protected boolean mUseDiskCache;

    public String getBaseUrl()
    {
        return mBaseUrl;
    }

    public int getMaxDimension()
    {
        return mMaxDimension;
    }

    public rity getResidencePriority()
    {
        return mResidencePriority;
    }

    public ServiceCallIdentifier getServiceCallIdentifier()
    {
        return sServiceCallIdentifier;
    }

    public String getUrl()
    {
        if (mUrl == null)
        {
            mUrl = ImageUtil.getImageUrl(mBaseUrl, mMaxDimension);
        }
        return mUrl;
    }

    public boolean useDiskCache()
    {
        return mUseDiskCache;
    }


    public rity(String s, rity rity)
    {
        super(s, rity);
    }

    public rity(String s, rity rity, int i, Object obj)
    {
        this(s, rity, i, obj, false, null);
    }

    public rity(String s, rity rity, int i, Object obj, boolean flag, rity rity1)
    {
        super(null, rity, obj);
        mMaxDimension = i;
        mBaseUrl = s;
        mUseDiskCache = flag;
        mResidencePriority = rity1;
    }

    public mResidencePriority(String s, String s1, mResidencePriority mresidencepriority)
    {
        this(s, mresidencepriority);
        mBaseUrl = s1;
    }
}
