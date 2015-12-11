// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;


public class FormattedError
{

    private final String description;
    private final boolean failedOperationRetryable;
    private final String moreInfo;
    private final String title;

    public FormattedError(String s, String s1, String s2, boolean flag)
    {
        title = s;
        description = s1;
        moreInfo = s2;
        failedOperationRetryable = flag;
    }

    public String getDescription()
    {
        return description;
    }

    public String getMoreInfo()
    {
        return moreInfo;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isFailedOperationRetryable()
    {
        return failedOperationRetryable;
    }
}
