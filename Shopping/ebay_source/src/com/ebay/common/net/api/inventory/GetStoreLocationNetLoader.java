// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import android.content.Context;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.IOException;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            GetLocationDetailsRequest, GetLocationDetailsResponse

public class GetStoreLocationNetLoader extends FwLoader
{

    private final EbayContext context;
    private boolean error;
    private final String locationId;
    private GetLocationDetailsResponse response;
    private final String sellerUserId;

    public GetStoreLocationNetLoader(EbayContext ebaycontext, String s, String s1)
    {
        super((Context)ebaycontext.getExtension(android/content/Context));
        error = false;
        locationId = s1;
        sellerUserId = s;
        context = ebaycontext;
    }

    protected void doInBackground()
    {
        GetLocationDetailsRequest getlocationdetailsrequest = new GetLocationDetailsRequest(sellerUserId, locationId);
        try
        {
            response = (GetLocationDetailsResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, getlocationdetailsrequest);
            return;
        }
        catch (com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException buildrequestdataexception)
        {
            error = true;
            buildrequestdataexception.printStackTrace();
            return;
        }
        catch (com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException parseresponsedataexception)
        {
            error = true;
            parseresponsedataexception.printStackTrace();
            return;
        }
        catch (IOException ioexception)
        {
            error = true;
            ioexception.printStackTrace();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            error = true;
            interruptedexception.printStackTrace();
            return;
        }
    }

    public GetLocationDetailsResponse getResponse()
    {
        return response;
    }

    public boolean isError()
    {
        return error;
    }
}
