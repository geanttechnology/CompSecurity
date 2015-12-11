// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.coupon;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.coupon:
//            IssueIncentiveResponse

public final class IssueIncentiveRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final String androidDeviceId;
    private final Uri couponUrl;
    private final boolean isServiceV1;
    private final URL url;

    public IssueIncentiveRequest(EbaySite ebaysite, boolean flag, String s, String s1, Uri uri)
    {
        super("CommonMobileAppService", false, "issueIncentive");
        if (ebaysite == null)
        {
            throw new NullPointerException("site");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new NullPointerException("iafToken");
        } else
        {
            isServiceV1 = flag;
            iafToken = s;
            androidDeviceId = s1;
            couponUrl = uri;
            soaAppIdHeaderName = "x-ebay-soa-security-appname";
            soaGlobalId = ebaysite.idString;
            useSoaLocaleList = true;
            url = ApiSettings.getUrl(EbaySettings.commonMobileAppSvcUrl);
            return;
        }
    }

    private void addMetadata(XmlSerializer xmlserializer, String s, String s1, Uri uri)
        throws IllegalArgumentException, IllegalStateException, IOException
    {
        xmlserializer.startTag(s, "appMetaList");
        addMetadata(xmlserializer, s, "deviceId", s1);
        s1 = uri.getEncodedQuery();
        String as[];
        int i;
        int j;
        int k;
        if (!TextUtils.isEmpty(s1))
        {
            as = s1.split("&");
        } else
        {
            as = null;
        }
        if (as == null) goto _L2; else goto _L1
_L1:
        j = as.length;
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = as[i];
        k = s1.indexOf('=');
        if (k != -1)
        {
            String s2 = s1.substring(0, k);
            if (!"rlutype".equals(s2))
            {
                if ("mppid".equals(s2))
                {
                    s1 = "carrierId";
                } else
                if ("campid".equals(s2))
                {
                    s1 = "useCaseId";
                } else
                if ("couponid".equals(s2))
                {
                    s1 = "placementId";
                } else
                {
                    s1 = s2;
                }
                s2 = uri.getQueryParameter(s2);
                if (!TextUtils.isEmpty(s2))
                {
                    addMetadata(xmlserializer, s, s1, s2);
                }
            }
        }
_L4:
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        xmlserializer.endTag(s, "appMetaList");
        return;
          goto _L4
    }

    private void addMetadata(XmlSerializer xmlserializer, String s, String s1, String s2)
        throws IllegalArgumentException, IllegalStateException, IOException
    {
        xmlserializer.startTag(s, "appMeta");
        XmlSerializerHelper.writeSimple(xmlserializer, s, "name", s1);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "value", s2);
        xmlserializer.endTag(s, "appMeta");
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s;
        if (isServiceV1)
        {
            s = "http://www.ebay.com/marketplace/mobileor/v1/commonservices";
        } else
        {
            s = "http://www.ebay.com/marketplace/mobileor/v2/commonservices";
        }
        xmlserializer.setPrefix("", s);
        xmlserializer.startTag(s, "issueIncentiveRequest");
        addMetadata(xmlserializer, s, androidDeviceId, couponUrl);
        xmlserializer.endTag(s, "issueIncentiveRequest");
    }

    public URL getRequestUrl()
    {
        return url;
    }

    public IssueIncentiveResponse getResponse()
    {
        return new IssueIncentiveResponse(isServiceV1);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
