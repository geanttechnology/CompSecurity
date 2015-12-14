// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.RequestValidationHelper;

public class Cookie
{

    private String mUrl;
    private String mValue;

    public Cookie()
    {
    }

    public String getUrl()
    {
        return mUrl;
    }

    public String getValue()
    {
        return mValue;
    }

    public boolean setUrl(String s)
    {
        boolean flag;
        if (!RequestValidationHelper.isNullOrEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return false;
        } else
        {
            mUrl = s;
            return true;
        }
    }

    public boolean setValue(String s)
    {
        boolean flag;
        if (!RequestValidationHelper.isNullOrEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return false;
        } else
        {
            mValue = s;
            return true;
        }
    }
}
