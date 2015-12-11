// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.os.Bundle;
import com.amazon.client.metrics.transport.OAuthHelper;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.TokenKeys;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil

public class MShopOAuthHelper
    implements OAuthHelper
{

    public MShopOAuthHelper()
    {
    }

    public String getAccessToken()
        throws Exception
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        String s = SSOUtil.getCurrentAccount(context);
        if (Util.isEmpty(s))
        {
            throw new IllegalStateException("no MAP account");
        } else
        {
            return ((Bundle)(new TokenManagement(context)).getToken(s, TokenKeys.getAccessTokenKeyForPackage(context.getPackageName()), null, null).get()).getString("value_key");
        }
    }
}
