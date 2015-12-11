// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.fis;

import android.net.Uri;
import android.util.Log;
import com.ebay.nautilus.domain.data.DirectDebit;
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

public final class AddDirectDebitRequest extends EbayCosRequest
{

    public static final String OPERATION_NAME = "tempdirectdebit";
    private static Gson mapper;
    public final DirectDebit bankAccount;

    public AddDirectDebitRequest(String s, DirectDebit directdebit)
    {
        super("fiappsvc", "tempdirectdebit");
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        iafToken = s;
        bankAccount = directdebit;
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

    public URL getRequestUrl()
    {
        android.net.Uri.Builder builder = Uri.parse(ApiSettings.get(ApiSettings.fundingInstrumentServiceUrl)).buildUpon().appendPath("tempdirectdebit").appendPath("v1");
        URL url;
        try
        {
            url = new URL(builder.toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getName(), (new StringBuilder()).append("AddDirectDebitRequest bad URL: ").append(builder.toString()).toString());
            return null;
        }
        return url;
    }

    public FundingInstrumentServiceResponse getResponse()
    {
        return new FundingInstrumentServiceResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    static 
    {
        mapper = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
            8, 128, 64
        }).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }
}
