// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.dyson;

import android.util.Log;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.paypal.android.lib.riskcomponent.RiskComponent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.net.api.dyson:
//            DysonBeaconResponse

public class DysonBeaconRequest extends EbayRequest
{

    private final RiskComponent module;

    public DysonBeaconRequest(RiskComponent riskcomponent)
    {
        super("PayPalDysonService", "DysonGetConfig");
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
        return module.getBeaconRequestBody();
    }

    public String getHttpMethod()
    {
        return module.getBeaconRequestMethod();
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = module.getBeaconRequestUrl();
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), "failed encoding URL", malformedurlexception);
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public DysonBeaconResponse getResponse()
    {
        return new DysonBeaconResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public String getUserAgent()
    {
        return module.getBeaconRequestUserAgent(getContext());
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        Map map = module.getBeaconRequestHeaders();
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
