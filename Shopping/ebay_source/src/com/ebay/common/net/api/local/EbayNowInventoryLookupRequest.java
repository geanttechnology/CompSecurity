// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.util.Log;
import com.ebay.common.model.local.AvailabilityIdentifier;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowInventoryLookupResponse

public class EbayNowInventoryLookupRequest extends EbayRequest
{

    Set availabilities;

    public EbayNowInventoryLookupRequest(String s, String s1, String s2, String s3)
    {
        availabilities = new HashSet();
        availabilities.add(new AvailabilityIdentifier(s, s1, s2, s3));
    }

    public EbayNowInventoryLookupRequest(AvailabilityIdentifier aavailabilityidentifier[])
    {
        availabilities = new HashSet();
        Collections.addAll(availabilities, aavailabilityidentifier);
    }

    public final byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(Boolean.valueOf(false)).getBytes();
    }

    protected String getErrorLanguage()
    {
        return null;
    }

    public URL getRequestUrl()
    {
        String s = EbaySettings.get(EbaySettings.merchantInventoryLookupUrl);
        URL url;
        try
        {
            url = new URL(s);
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), (new StringBuilder()).append("failed encoding URL ").append(s).toString());
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public EbayNowInventoryLookupResponse getResponse()
    {
        return new EbayNowInventoryLookupResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("Content-Type", "application/json");
    }
}
