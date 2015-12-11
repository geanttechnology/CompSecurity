// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink;

import roboguice.util.Strings;

// Referenced classes of package com.groupon.deeplink:
//            DeepLinkValidator, DeepLinkUtil, InvalidDeepLinkException, Endpoint, 
//            DeepLinkData

public class GenericDeepLinkValidator
    implements DeepLinkValidator
{

    protected final DeepLinkUtil deepLinkUtil = new DeepLinkUtil();

    public GenericDeepLinkValidator()
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
        return !Endpoint.SIKR3TADMIN.equals(deepLinkUtil.getDeepLink(s).getEndpoint());
    }
}
