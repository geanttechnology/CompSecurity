// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.target.mothership.model.common.a.c;

public class k
{

    private String mAlternateErrorMessage;
    private String mErrorCode;
    private String mErrorKey;
    private String mErrorMessage;
    private Object mErrorParameters;

    public k()
    {
    }

    public c a()
    {
        return com.target.mothership.model.common.a.c.a(mErrorKey);
    }

    public String b()
    {
        return mAlternateErrorMessage;
    }

    public String c()
    {
        if (mErrorParameters == null)
        {
            return "";
        } else
        {
            return mErrorParameters.toString();
        }
    }
}
