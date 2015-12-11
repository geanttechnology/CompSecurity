// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.common;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public final class BluefrontCredential
{

    private final String mAccessId;
    private final String mAccessKey;

    public BluefrontCredential(String s, String s1)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (!Strings.isNullOrEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Access ID cannot be null or empty.");
        if (!Strings.isNullOrEmpty(s1))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Access key cannot be null or empty.");
        mAccessId = s;
        mAccessKey = s1;
    }

    public String getAccessId()
    {
        return mAccessId;
    }

    public String getAccessKey()
    {
        return mAccessKey;
    }
}
