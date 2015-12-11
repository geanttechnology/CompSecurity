// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink.imp;

import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.InvalidDeepLinkException;

public class BusinessDeepLink extends DeepLinkData
{

    public BusinessDeepLink()
    {
    }

    public void validate()
        throws InvalidDeepLinkException
    {
        super.validate();
        if (getFields().length == 5)
        {
            throw new InvalidDeepLinkException("Special id is not provided");
        } else
        {
            return;
        }
    }
}
