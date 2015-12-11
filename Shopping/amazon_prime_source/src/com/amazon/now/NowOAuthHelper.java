// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.client.metrics.transport.OAuthHelper;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.TokenKeys;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.now.account.SSO;
import com.amazon.now.platform.AndroidPlatform;

public class NowOAuthHelper
    implements OAuthHelper, com.amazon.device.utils.OAuthHelper
{

    public NowOAuthHelper()
    {
    }

    public String getAccessToken()
        throws Exception
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        String s = SSO.getMAPAccountManager().getAccount();
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalStateException("no MAP account");
        } else
        {
            return ((Bundle)(new TokenManagement(context)).getToken(s, TokenKeys.getAccessTokenKeyForPackage(context.getPackageName()), null, null).get()).getString("value_key");
        }
    }
}
