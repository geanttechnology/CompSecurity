// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content;

import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class EbaySimpleNetLoader extends FwNetLoader
{

    protected volatile EbayResponse response;

    public EbaySimpleNetLoader(EbayContext ebaycontext)
    {
        super(ebaycontext);
        response = null;
    }

    protected abstract EbayRequest createRequest();

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        response = (EbayResponse)sendRequest(createRequest());
        if (response != null && !response.hasSuccessResponseCode())
        {
            throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(response.responseCode, response.responseMessage);
        }
        if (response != null)
        {
            setResultStatus(response.getResultStatus());
        }
    }

    public final EbayResponse getResponse()
    {
        return response;
    }

    public final List getServiceErrorsAndWarnings()
    {
        ArrayList arraylist1 = null;
        ArrayList arraylist = null;
        List list = getResultStatus().getMessages();
        if (list != null)
        {
            Iterator iterator = list.iterator();
            do
            {
                arraylist1 = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)iterator.next();
                if (message instanceof EbayResponseError)
                {
                    arraylist1 = arraylist;
                    if (arraylist == null)
                    {
                        arraylist1 = new ArrayList(list.size());
                    }
                    arraylist1.add((EbayResponseError)message);
                    arraylist = arraylist1;
                }
            } while (true);
        }
        return arraylist1;
    }

    public boolean isServiceError()
    {
        return response != null && !response.isSuccessful();
    }

    public final boolean isWarning()
    {
        return !isError() && response != null && response.ackCode == 2;
    }
}
