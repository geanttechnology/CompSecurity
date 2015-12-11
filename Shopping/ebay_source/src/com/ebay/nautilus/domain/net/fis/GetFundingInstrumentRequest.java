// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.fis;

import android.net.Uri;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.fis:
//            FundingInstrumentServiceResponse

public final class GetFundingInstrumentRequest extends EbayCosRequest
{

    public static final String OPERATION_NAME = "paymentinstrument";
    private final String fundingInstrumentId;

    public GetFundingInstrumentRequest(String s, String s1)
    {
        super("fiappsvc", "paymentinstrument");
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        iafToken = s;
        fundingInstrumentId = s1;
    }

    protected String getErrorLanguage()
    {
        return null;
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.get(ApiSettings.fundingInstrumentServiceUrl)).buildUpon().appendPath("paymentinstrument").appendPath("v1").appendPath(fundingInstrumentId);
        try
        {
            obj = new URL(((android.net.Uri.Builder) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            return null;
        }
        return ((URL) (obj));
    }

    public FundingInstrumentServiceResponse getResponse()
    {
        return new FundingInstrumentServiceResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
