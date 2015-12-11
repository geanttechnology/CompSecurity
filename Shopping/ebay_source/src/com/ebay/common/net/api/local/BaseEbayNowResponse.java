// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowMappedException

public class BaseEbayNowResponse extends EbayResponse
{

    public static final Gson MAPPER = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).registerTypeAdapter(java/util/Date, new EbayDateAdapter()).enableComplexMapKeySerialization().create();
    private static final int SC_OK = 200;
    private static final int SC_UNPROCESSABLE_ENTITY = 422;
    private final Class clazz;
    private EbayNowMappedException mappedException;
    private Object result;

    protected BaseEbayNowResponse(Class class1)
    {
        clazz = class1;
    }

    public EbayNowMappedException getMappedException()
    {
        return mappedException;
    }

    public Object getResult()
    {
        return result;
    }

    public boolean hasSuccessResponseCode()
    {
        switch (responseCode)
        {
        default:
            return super.hasSuccessResponseCode();

        case 200: 
        case 422: 
            return true;
        }
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        switch (responseCode)
        {
        default:
            return;

        case 200: 
            result = readStream(MAPPER, inputstream, clazz);
            return;

        case 422: 
            mappedException = (EbayNowMappedException)readStream(MAPPER, inputstream, com/ebay/common/net/api/local/EbayNowMappedException);
            break;
        }
    }

}
