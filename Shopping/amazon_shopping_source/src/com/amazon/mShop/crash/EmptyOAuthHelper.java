// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.crash;

import com.amazon.device.utils.OAuthHelper;

public class EmptyOAuthHelper
    implements OAuthHelper
{

    public EmptyOAuthHelper()
    {
    }

    public String getAccessToken()
        throws Exception
    {
        return "";
    }
}
