// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;

// Referenced classes of package com.mopub.mobileads:
//            AdRequestStatusMapping

private static class mClickUrl
{

    private String mClickUrl;
    private String mFailUrl;
    private String mImpressionUrl;
    private mClickUrl mLoadingStatus;

    private String getClickUrl()
    {
        return mClickUrl;
    }

    private String getFailurl()
    {
        return mFailUrl;
    }

    private String getImpressionUrl()
    {
        return mImpressionUrl;
    }

    private mImpressionUrl getStatus()
    {
        return mLoadingStatus;
    }

    private void setClickUrl(String s)
    {
        mClickUrl = s;
    }

    private void setImpressionUrl(String s)
    {
        mImpressionUrl = s;
    }

    private void setStatus(mImpressionUrl mimpressionurl)
    {
        mLoadingStatus = mimpressionurl;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj instanceof mLoadingStatus)
            {
                obj = (mLoadingStatus)obj;
                if (!mLoadingStatus.uals(((uals) (obj)).mLoadingStatus) || !TextUtils.equals(mFailUrl, ((mFailUrl) (obj)).mFailUrl) || !TextUtils.equals(mImpressionUrl, ((mImpressionUrl) (obj)).mImpressionUrl) || !TextUtils.equals(mClickUrl, ((mClickUrl) (obj)).mClickUrl))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int k = 0;
        int l = mLoadingStatus.dinal();
        int i;
        int j;
        if (mFailUrl != null)
        {
            i = mFailUrl.hashCode();
        } else
        {
            i = 0;
        }
        if (mImpressionUrl != null)
        {
            j = mImpressionUrl.hashCode();
        } else
        {
            j = 0;
        }
        if (mClickUrl != null)
        {
            k = mClickUrl.hashCode();
        }
        return (((l + 899) * 31 + i) * 31 + j) * 31 + k;
    }








    public ( )
    {
        this(, null, null, null);
    }

    public <init>(<init> <init>1, String s, String s1, String s2)
    {
        Preconditions.checkNotNull(<init>1);
        mLoadingStatus = <init>1;
        mFailUrl = s;
        mImpressionUrl = s1;
        mClickUrl = s2;
    }
}
