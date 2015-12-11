// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.net.Uri;
import com.ebay.common.net.util.RequestSigningUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.ebay.common.content.dm:
//            RlProductInfoDataManager

private static final class url extends EbayRequest
{

    private static final com.ebay.nautilus.kernel.util.Response logRlProductInfo = new com.ebay.nautilus.kernel.util.Response(com/ebay/common/content/dm/RlProductInfoDataManager$GetRlProductInfoRequest.getSimpleName(), 3, "Log RlProductInfo");
    private final AtomicInteger sequenceNumber = new AtomicInteger();
    private URL url;

    public URL getRequestUrl()
    {
        return url;
    }

    public  getResponse()
    {
        return new (null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }


    public (EbaySite ebaysite, String s, String s1)
    {
        url = null;
        try
        {
            url = new URL(Uri.parse(ApiSettings.get(ApiSettings.rlForEbaySvcUrl)).buildUpon().url("prodinfo").url("barcode", s).url("btype", s1).url("key", "com.ebay.core").url("platform", "android").url("locale", (new StringBuilder()).append(ebaysite.localeLanguage).append("_").append(ebaysite.localeCountry).toString()).url("siteid", ebaysite.id).url("X-M", Integer.toString(sequenceNumber.getAndIncrement())).sequenceNumber("X-K", "2").sequenceNumber().toString());
            url = RequestSigningUtil.signUrl(getHttpMethod(), url, null, RlProductInfoDataManager.access$100());
            if (logRlProductInfo.RlProductInfo)
            {
                logRlProductInfo.RlProductInfo(url.toString());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EbaySite ebaysite)
        {
            ebaysite.printStackTrace();
        }
    }
}
