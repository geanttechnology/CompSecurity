// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.fis;

import android.net.Uri;
import com.ebay.nautilus.domain.data.CreditCard;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.fis:
//            FundingInstrumentServiceResponse

public final class UpdateCreditCardRequest extends EbayCosRequest
{

    public static final String OPERATION_NAME = "creditcard";
    private static final Gson mapper;
    public final CreditCard creditCard;
    private final String fundingInstrumentId;

    public UpdateCreditCardRequest(String s, String s1, CreditCard creditcard)
    {
        super("fiappsvc", "creditcard");
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        iafToken = s;
        fundingInstrumentId = s1;
        creditCard = creditcard;
    }

    public final byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return mapper.toJson(this).getBytes();
    }

    protected String getErrorLanguage()
    {
        return null;
    }

    public String getHttpMethod()
    {
        return "PUT";
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.get(ApiSettings.fundingInstrumentServiceUrl)).buildUpon().appendPath("creditcard").appendPath("v1").appendPath(fundingInstrumentId);
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

    static 
    {
        mapper = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
            8, 128, 64, 2, 4
        }).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }
}
