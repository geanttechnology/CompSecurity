// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.threatmatrix;

import android.net.Uri;
import android.util.Log;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.threatmatrix:
//            FingerprintPrepareResponse

public class FingerprintPrepareRequest extends EbayCosRequest
{

    public FingerprintPrepareRequest(EbaySite ebaysite, String s, String s1)
    {
        super("FingerprintService", "FingerprintPrepare", CosVersionType.V2);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        marketPlaceId = ebaysite.idString;
        trackingHeader = s;
        tmxSessionId = s1;
        tmxSessionId = s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return "{}".getBytes();
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.get(ApiSettings.fingerprintServiceUrl)).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendPath("prepare");
        obj = ((android.net.Uri.Builder) (obj)).build().toString();
        URL url;
        try
        {
            url = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), (new StringBuilder()).append("failed encoding URL ").append(((String) (obj))).toString());
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public FingerprintPrepareResponse getResponse()
    {
        return new FingerprintPrepareResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public boolean hasRecoverableError(Response response, IOException ioexception)
    {
        com.ebay.nautilus.kernel.content.ResultStatus.Message message;
        if (response != null)
        {
            message = response.getResultStatus().getFirstError();
        } else
        {
            message = null;
        }
        if (message != null && message.getId() == 0x14e6d38 && cosVersionType.minimumOf(CosVersionType.V2) && iafToken == null)
        {
            response = authHeaderValue.substring("Bearer ".length());
            EbayAppCredentials.get(getEbayContext()).invalidateBearerToken(response);
            return true;
        } else
        {
            return super.hasRecoverableError(response, ioexception);
        }
    }

    protected boolean isIdempotent()
    {
        return true;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay3pp-device-id", EbayIdentity.get3ppFingerprint(getContext()));
    }
}
