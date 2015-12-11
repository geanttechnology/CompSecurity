// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics.impressions;

import android.text.TextUtils;

public class AsinImpression
{

    String asin;
    String requestId;

    public AsinImpression(String s, String s1)
    {
        requestId = s;
        asin = s1;
    }

    public String getAsin()
    {
        return asin;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setRequestId(String s)
    {
        requestId = s;
    }

    public String toLoggingFormat()
    {
        if (TextUtils.isEmpty(requestId) || TextUtils.isEmpty(asin))
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(requestId).append("|").append(asin).toString();
        }
    }
}
