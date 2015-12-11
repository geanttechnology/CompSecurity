// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, GetInterestsLoadTask

public static class interestIds extends BaseFollowInterestRequest
{

    public static final String OPERATION_NAME = "getInterests";
    public static final String SERVICE_NAME = "InterestService";
    private final List interestIds;

    public URL getRequestUrl()
    {
        Object obj;
        try
        {
            obj = new StringBuilder(ApiSettings.get(EbaySettings.interestBaseUrl));
            ((StringBuilder) (obj)).append("metadata?interestIds=");
            if (!interestIds.isEmpty())
            {
                ((StringBuilder) (obj)).append(TextUtils.join(",", interestIds));
            }
            obj = new URL(((StringBuilder) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            return null;
        }
        return ((URL) (obj));
    }

    public interestIds getResponse()
    {
        return new <init>();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }

    public (List list, String s, String s1)
    {
        super("InterestService", "getInterests", s, s1);
        interestIds = list;
    }
}
