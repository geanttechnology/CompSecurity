// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.threatmatrix;

import android.util.Log;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.threatmetrix.TrustDefenderMobile.riskmodule.RiskModule;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.Header;

// Referenced classes of package com.ebay.nautilus.domain.net.api.threatmatrix:
//            GetThreatMatrixConfigResponse

public class GetThreatMatrixConfigRequest extends EbayRequest
{

    private final RiskModule module;

    public GetThreatMatrixConfigRequest(RiskModule riskmodule)
    {
        module = riskmodule;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return module.getConfigurationBody();
    }

    public String getHttpMethod()
    {
        return module.getConfigurationHttpMethod();
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = module.getConfigurationURL();
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), "failed encoding URL", malformedurlexception);
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public GetThreatMatrixConfigResponse getResponse()
    {
        return new GetThreatMatrixConfigResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        Header aheader[] = module.getConfigurationHTTPHeaders(getUserAgent());
        if (aheader != null && aheader.length > 0)
        {
            int j = aheader.length;
            for (int i = 0; i < j; i++)
            {
                Header header = aheader[i];
                iheaders.setHeader(header.getName(), header.getValue());
            }

        }
    }
}
