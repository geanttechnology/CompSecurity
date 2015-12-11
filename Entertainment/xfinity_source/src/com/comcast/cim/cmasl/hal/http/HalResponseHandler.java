// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.http;

import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import com.comcast.cim.cmasl.http.response.StrictHttpStatusCodeHandler;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.microdata.client.HypermediaClient;
import com.comcast.cim.microdata.exception.MicrodataConversionException;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.io.InputStream;

public class HalResponseHandler extends DelegatingResponseHandler
{

    private String baseUrl;
    private HypermediaClient hypermediaClient;
    private MicrodataItem microdataResource;

    public HalResponseHandler(HypermediaClient hypermediaclient, String s)
    {
        hypermediaClient = hypermediaclient;
        baseUrl = s;
        addDelegateHeadersHandler(new StrictHttpStatusCodeHandler());
    }

    public MicrodataItem getMicrodataResource()
    {
        return microdataResource;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        try
        {
            microdataResource = hypermediaClient.parseResource(baseUrl, inputstream, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CimException(inputstream);
        }
    }
}
