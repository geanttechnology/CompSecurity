// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shippinglabel;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.data.ErrorMessageDetails;
import com.ebay.nautilus.domain.data.ShippingLabelPdfContainer;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;

// Referenced classes of package com.ebay.common.net.api.shippinglabel:
//            GetShippingLabelRequest, GetShippingLabelResponse

public class GetShippingLabelNetLoader extends EbaySimpleNetLoader
{

    private static final String TRACKING_FAILED_TO_LOAD = "FAILED_TO_LOAD";
    private final String iafToken;
    private final String workOrderID;

    public GetShippingLabelNetLoader(EbayContext ebaycontext, String s, String s1)
    {
        super(ebaycontext);
        workOrderID = s;
        iafToken = s1;
    }

    protected EbayRequest createRequest()
    {
        return new GetShippingLabelRequest(workOrderID, iafToken);
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        int i = 0;
_L4:
        if (i >= 120) goto _L2; else goto _L1
_L1:
        response = (EbayResponse)sendRequest(createRequest());
        if (((GetShippingLabelResponse)response).label != null && ((GetShippingLabelResponse)response).label.status != null && !((GetShippingLabelResponse)response).label.status.equals("INPROGRESS")) goto _L2; else goto _L3
_L3:
        ErrorMessageDetails errormessagedetails;
        try
        {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedexception) { }
        i++;
        if (true) goto _L4; else goto _L2
_L2:
        if (response != null && ((GetShippingLabelResponse)response).label.status.equals("COMPLETE"))
        {
            setResultStatus(((GetShippingLabelResponse)response).getResultStatus());
            return;
        }
        if (response != null && ((GetShippingLabelResponse)response).label != null)
        {
            errormessagedetails = ((GetShippingLabelResponse)response).label.getFirstError();
            if (errormessagedetails != null)
            {
                throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(((GetShippingLabelResponse)response).responseCode, errormessagedetails.errorName);
            }
        }
        if (response != null && ((GetShippingLabelResponse)response).label.status.equals("FAILURE"))
        {
            throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(((GetShippingLabelResponse)response).responseCode, ((GetShippingLabelResponse)response).label.status);
        }
        if (response != null && !((GetShippingLabelResponse)response).hasSuccessResponseCode())
        {
            throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(((GetShippingLabelResponse)response).responseCode, ((GetShippingLabelResponse)response).responseMessage);
        } else
        {
            throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(((GetShippingLabelResponse)response).responseCode, "FAILED_TO_LOAD");
        }
    }
}
