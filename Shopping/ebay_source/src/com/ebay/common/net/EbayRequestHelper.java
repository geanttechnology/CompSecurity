// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class EbayRequestHelper
{
    public static class EbayRequestErrorException extends IOException
    {

        private static final long serialVersionUID = 1L;
        private final ArrayList errors;

        public final ArrayList getErrors()
        {
            return errors;
        }

        public String getMessage()
        {
            StringBuilder stringbuilder = new StringBuilder(10);
            if (errors != null)
            {
                for (Iterator iterator = errors.iterator(); iterator.hasNext(); stringbuilder.append((EbayResponseError)iterator.next()).append('\n')) { }
            }
            return stringbuilder.toString();
        }

        public EbayRequestErrorException(ArrayList arraylist)
        {
            if (arraylist == null)
            {
                arraylist = new ArrayList();
            }
            errors = arraylist;
        }

        public EbayRequestErrorException(List list)
        {
            errors = new ArrayList();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)list.next();
                if (message instanceof EbayResponseError)
                {
                    errors.add((EbayResponseError)message);
                }
            } while (true);
        }
    }


    public EbayRequestHelper()
    {
    }

    public static EbayResponse sendRequest(EbayContext ebaycontext, Request request)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        ebaycontext = (EbayResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebaycontext, request);
        verify(ebaycontext);
        return ebaycontext;
    }

    public static void verify(EbayResponse ebayresponse)
        throws EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException
    {
        if (!ebayresponse.hasSuccessResponseCode())
        {
            throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(ebayresponse.responseCode, ebayresponse.responseMessage);
        }
        if (ebayresponse.ackCode == -1)
        {
            throw new EbayRequestErrorException(ebayresponse.getResultStatus().getMessages());
        } else
        {
            return;
        }
    }
}
