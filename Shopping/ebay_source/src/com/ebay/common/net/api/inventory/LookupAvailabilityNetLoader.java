// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import android.content.Context;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.IOException;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            LookupAvailabilityRequest, LookupAvailabilityResponse

public class LookupAvailabilityNetLoader extends FwLoader
{

    private final EbayContext context;
    private final String countryCode;
    private final Date estimatedDeliveryDate;
    private final LookupAvailabilityRequest.PhysicalLocation location;
    private final com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type logisticsPlanType;
    private final Integer radius;
    private LookupAvailabilityResponse response;
    private final String sellerId;
    private final String sku;
    private final LookupAvailabilityRequest.Unit unit;

    public LookupAvailabilityNetLoader(EbayContext ebaycontext, String s, String s1, LookupAvailabilityRequest.PhysicalLocation physicallocation, Integer integer, LookupAvailabilityRequest.Unit unit1, String s2, 
            com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type, Date date)
    {
        super((Context)ebaycontext.getExtension(android/content/Context));
        context = ebaycontext;
        sellerId = s;
        sku = s1;
        location = physicallocation;
        radius = integer;
        unit = unit1;
        countryCode = s2;
        logisticsPlanType = type;
        estimatedDeliveryDate = date;
    }

    protected void doInBackground()
    {
        LookupAvailabilityRequest lookupavailabilityrequest = new LookupAvailabilityRequest(sellerId, sku, location, radius, unit, countryCode, logisticsPlanType, estimatedDeliveryDate);
        try
        {
            response = (LookupAvailabilityResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, lookupavailabilityrequest);
            return;
        }
        catch (com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException buildrequestdataexception)
        {
            buildrequestdataexception.printStackTrace();
            return;
        }
        catch (com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException parseresponsedataexception)
        {
            parseresponsedataexception.printStackTrace();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }

    public LookupAvailabilityResponse getResponse()
    {
        return response;
    }
}
