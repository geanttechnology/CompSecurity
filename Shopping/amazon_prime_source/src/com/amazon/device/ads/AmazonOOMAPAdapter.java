// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.api.AuthenticationType;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPFuture;
import java.util.EnumSet;

// Referenced classes of package com.amazon.device.ads:
//            AuthenticationPlatformAdapter, MobileAdsLoggerFactory, MobileAdsLogger, MobileAdsInfoStore, 
//            AmazonOOAuthenticatedWebRequest, WebRequest

class AmazonOOMAPAdapter
    implements AuthenticationPlatformAdapter
{

    private static final String LOGTAG = com/amazon/device/ads/AmazonOOMAPAdapter.getSimpleName();
    private Context context;
    private final MobileAdsLogger logger;

    AmazonOOMAPAdapter()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
    }

    public String getAccountName()
    {
        String s = null;
        String s1 = (new MAPAccountManager(context)).getAccount();
        s = s1;
_L2:
        if (s == null)
        {
            logger.e("No Amazon account found");
        }
        return s;
        Exception exception;
        exception;
        logger.d("Exception caught when trying to retrieve the user's account: %s", new Object[] {
            exception.getMessage()
        });
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getPreferredMarketplace()
    {
        Object obj = getAccountName();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((obj = (Bundle)CustomerAttributeStore.getInstance(MobileAdsInfoStore.getInstance().getApplicationContext()).getAttribute(((String) (obj)), "PFM", null, EnumSet.noneOf(com/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions)).get()) == null) goto _L1; else goto _L3
_L3:
        try
        {
            obj = CustomerAttributeStore.getValueOrAttributeDefault(((Bundle) (obj)));
        }
        catch (Exception exception)
        {
            logger.d("Exception caught when trying to retrieve the user's preferred marketplace. Most issues can be remedied by upgrading to MAP R5. Exception message: %s", new Object[] {
                exception.getMessage()
            });
            return null;
        }
        return ((String) (obj));
    }

    public WebRequest makeAuthenticatedWebRequest(String s)
    {
        return new AmazonOOAuthenticatedWebRequest((new AuthenticationMethodFactory(MobileAdsInfoStore.getInstance().getApplicationContext(), s)).newAuthenticationMethod(AuthenticationType.OAuth));
    }

    public AmazonOOMAPAdapter setContext(Context context1)
    {
        context = context1;
        return this;
    }

    public volatile AuthenticationPlatformAdapter setContext(Context context1)
    {
        return setContext(context1);
    }

}
