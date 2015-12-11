// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;

// Referenced classes of package com.ebay.common:
//            SsoRequest, SsoScopeLoader

private static final class  extends SsoRequest
{

    public static  create(EbayContext ebaycontext, String s, String s1, String s2)
    {
        String s3 = s1;
        if (TextUtils.isEmpty(s1))
        {
            s3 = "//EBAYSSO/EBAYCLASSIC";
        }
        ebaycontext = EbayAppCredentials.get(ebaycontext);
        return new <init>(Uri.parse((new StringBuilder()).append(ApiSettings.get(EbaySettings.ssoApiBase)).append("?OAuthAuthorize2").toString()).buildUpon().r("grant_type", "client_credentials").r("client_id", ((EbayAppCredentials) (ebaycontext)).appId).r("client_secret", s).r("scope", (new StringBuilder()).append("scope:").append(s3).append(":").append(s2).toString()).r());
    }

    public  getResponse()
    {
        return new (null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    private (String s)
    {
        super(s, "ssoScope");
        if (SsoScopeLoader.log.)
        {
            SsoScopeLoader.log._01_((new StringBuilder()).append("SSO request: ").append(s).toString());
        }
    }
}
