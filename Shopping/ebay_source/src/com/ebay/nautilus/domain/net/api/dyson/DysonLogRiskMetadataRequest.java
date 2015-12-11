// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.dyson;

import android.util.Log;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.paypal.android.lib.riskcomponent.RiskComponent;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.net.api.dyson:
//            DysonLogRiskMetadataResponse

public class DysonLogRiskMetadataRequest extends EbayRequest
{

    private final RiskComponent module;

    public DysonLogRiskMetadataRequest(RiskComponent riskcomponent)
    {
        super("PayPalDysonService", "DysonLogRiskMetadata");
        if (riskcomponent == null)
        {
            throw new IllegalArgumentException("risk module cannot be null");
        } else
        {
            module = riskcomponent;
            return;
        }
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        byte abyte0[];
        try
        {
            abyte0 = module.getLogRiskMetadataRequestBody();
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException("Encoding of Dyson payload failed", unsupportedencodingexception);
        }
        return abyte0;
    }

    public String getHttpMethod()
    {
        return module.getLogRiskMetadataRequestMethod();
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = module.getLogRiskMetadataRequestUrl();
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), "failed encoding URL", malformedurlexception);
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public DysonLogRiskMetadataResponse getResponse()
    {
        return new DysonLogRiskMetadataResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        Map map = module.getLogRiskMetadataRequestHeaders();
        if (map != null)
        {
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); iheaders.setHeader(s, (String)map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
    }
}
