// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink;

import com.groupon.activity.UrlIntentFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.deeplink:
//            CardSearchDeepLinkValidator, InvalidDeepLinkException, DeepLinkData

public class CollectionCardDeepLinkValidator extends CardSearchDeepLinkValidator
{

    public CollectionCardDeepLinkValidator()
    {
    }

    protected boolean validateDeepLinkData(DeepLinkData deeplinkdata)
        throws InvalidDeepLinkException
    {
        String s = deeplinkdata.getParam("x_client_consumed_source");
        if (Strings.isEmpty(deeplinkdata.getParam("filter")))
        {
            throw new InvalidDeepLinkException("Missing RAPI filter");
        }
        if (!UrlIntentFactory.COLLECTION_CARD_SOURCE.matcher(s).matches())
        {
            throw new InvalidDeepLinkException("Not a Collection deepLink");
        } else
        {
            return true;
        }
    }
}
