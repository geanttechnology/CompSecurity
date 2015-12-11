// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink;

import roboguice.util.Strings;

// Referenced classes of package com.groupon.deeplink:
//            DeepLinkValidator, DeepLinkUtil, InvalidDeepLinkException, DeepLinkData, 
//            Endpoint

public abstract class CardSearchDeepLinkValidator
    implements DeepLinkValidator
{

    protected final DeepLinkUtil deepLinkUtil = new DeepLinkUtil();

    public CardSearchDeepLinkValidator()
    {
    }

    public final boolean validateDeepLink(String s)
        throws InvalidDeepLinkException
    {
        if (Strings.isEmpty(s))
        {
            throw new InvalidDeepLinkException("DeepLink is empty");
        }
        if (!deepLinkUtil.isDeepLink(s))
        {
            throw new InvalidDeepLinkException((new StringBuilder()).append(s).append(" is not a deepLink").toString());
        }
        if (!s.startsWith(deepLinkUtil.defaultLocalDeeplink("*")))
        {
            throw new InvalidDeepLinkException((new StringBuilder()).append(s).append(" is not an internal deepLink").toString());
        }
        s = deepLinkUtil.getDeepLink(s);
        if (!deepLinkUtil.hasWildCardCountryCode(s))
        {
            throw new InvalidDeepLinkException((new StringBuilder()).append("Expecting wild card country code, but found ").append(s.getCountryCode()).toString());
        }
        if (!Endpoint.CARDSEARCH.equals(s.getEndpoint()))
        {
            throw new InvalidDeepLinkException((new StringBuilder()).append("Unsupported endpoint ").append(s.getEndpoint()).toString());
        } else
        {
            return validateDeepLinkData(s);
        }
    }

    protected abstract boolean validateDeepLinkData(DeepLinkData deeplinkdata)
        throws InvalidDeepLinkException;
}
