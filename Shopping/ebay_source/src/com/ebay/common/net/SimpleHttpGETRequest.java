// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.net.URL;

public class SimpleHttpGETRequest extends FwNetLoader
{

    private final URL Url;

    public SimpleHttpGETRequest(EbayContext ebaycontext, URL url)
    {
        super(ebaycontext);
        Url = url;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        try
        {
            sendRequest(new DataRequest(Url));
            return;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            return;
        }
    }
}
