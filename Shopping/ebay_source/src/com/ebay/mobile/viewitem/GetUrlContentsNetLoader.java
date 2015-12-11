// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.domain.net.DataResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetUrlContentsNetLoader extends FwNetLoader
{

    public String contents;
    private boolean serviceError;
    private final String url;

    public GetUrlContentsNetLoader(EbayContext ebaycontext, String s)
    {
        super(ebaycontext);
        serviceError = false;
        url = s;
    }

    protected void doInBackgroundInternal()
        throws IOException, InterruptedException, com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        try
        {
            contents = ((DataResponse)sendRequest(new DataRequest(new URL(url)))).getText();
            return;
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(malformedurlexception.getMessage());
        }
    }

    public boolean isServiceError()
    {
        return serviceError;
    }
}
