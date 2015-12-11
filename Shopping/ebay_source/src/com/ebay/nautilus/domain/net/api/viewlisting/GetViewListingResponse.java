// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.ErrorMessageDetails;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.datamapping.gson.SortedListDeserializer;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.IHeader;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.IResponseHeaderHandler;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            ListingDetails

public class GetViewListingResponse extends EbayCosResponse
    implements IResponseHeaderHandler
{

    public ListingDetails details;
    private String trackingCorrelationId;
    private String trackingData;

    public GetViewListingResponse()
    {
        super(true);
    }

    protected void addGsonBuilderProperties(GsonBuilder gsonbuilder)
    {
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/net/api/viewlisting/ListingBuyingContext$ListingHotnessEnum, new ListingBuyingContext.ListingHotnessEnum.Deserializer()).registerTypeAdapter(com/ebay/nautilus/domain/net/api/viewlisting/Listing$LogisticsStepExtension, new Listing.LogisticsStepExtension.Deserializer()).registerTypeAdapter((new TypeToken() {

            final GetViewListingResponse this$0;

            
            {
                this$0 = GetViewListingResponse.this;
                super();
            }
        }).getType(), new SortedListDeserializer()).registerTypeAdapter((new TypeToken() {

            final GetViewListingResponse this$0;

            
            {
                this$0 = GetViewListingResponse.this;
                super();
            }
        }).getType(), new SortedListDeserializer()).registerTypeAdapter((new TypeToken() {

            final GetViewListingResponse this$0;

            
            {
                this$0 = GetViewListingResponse.this;
                super();
            }
        }).getType(), new SortedListDeserializer()).registerTypeAdapter((new TypeToken() {

            final GetViewListingResponse this$0;

            
            {
                this$0 = GetViewListingResponse.this;
                super();
            }
        }).getType(), new SortedListDeserializer()).registerTypeAdapter((new TypeToken() {

            final GetViewListingResponse this$0;

            
            {
                this$0 = GetViewListingResponse.this;
                super();
            }
        }).getType(), new SortedListDeserializer()).registerTypeAdapter((new TypeToken() {

            final GetViewListingResponse this$0;

            
            {
                this$0 = GetViewListingResponse.this;
                super();
            }
        }).getType(), new SortedListDeserializer()).registerTypeAdapter((new TypeToken() {

            final GetViewListingResponse this$0;

            
            {
                this$0 = GetViewListingResponse.this;
                super();
            }
        }).getType(), new SortedListDeserializer()).registerTypeAdapter(com/ebay/nautilus/domain/net/api/viewlisting/Listing$SellerOfferTypeEnum, new Listing.SellerOfferTypeEnum.Deserializer()).registerTypeAdapter(java/util/Date, new EbayDateAdapter());
    }

    public IResponseHeaderHandler getHeaderHandler()
    {
        return this;
    }

    public boolean hasSuccessResponseCode()
    {
        return super.hasSuccessResponseCode() || NetworkUtil.isHttpClass4xx(responseCode);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        details = (ListingDetails)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/viewlisting/ListingDetails);
        if (details != null && !TextUtils.isEmpty(details.errorCode))
        {
            inputstream = new ErrorMessageDetails();
            inputstream.code = "21916984";
            inputstream.shortMessage = details.errorCode;
            details.getErrors().add(inputstream);
        }
        if (details.listing == null && !getResultStatus().hasError())
        {
            addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                new ErrorMessageDetails()
            });
        }
        details.trackingData = trackingData;
        details.trackingCorrelationId = trackingCorrelationId;
    }

    public void readHeaders(IHeaders iheaders)
    {
        Iterator iterator = iheaders.iterator();
label0:
        do
        {
            if (iterator.hasNext())
            {
                IHeader iheader = (IHeader)iterator.next();
                if (TextUtils.isEmpty(iheader.getName()))
                {
                    iheaders = null;
                } else
                {
                    iheaders = iheader.getName().toLowerCase(Locale.US);
                }
                if (TextUtils.equals(iheaders, "x-ebay-svc-tracking-data"))
                {
                    trackingData = iheader.getValue();
                    continue;
                }
                if (!TextUtils.equals(iheaders, "x-ebay-c-request-id"))
                {
                    continue;
                }
                iheaders = iheader.getValue();
                if (TextUtils.isEmpty(iheaders))
                {
                    continue;
                }
                iheaders = iheaders.split(",");
                int i = 0;
                do
                {
                    if (i >= iheaders.length)
                    {
                        continue label0;
                    }
                    if (iheaders[i].startsWith("rci=") && iheaders[i].length() > 4)
                    {
                        trackingCorrelationId = iheaders[i].substring(4);
                        continue label0;
                    }
                    i++;
                } while (true);
            }
            return;
        } while (true);
    }

    public void setErrors(List list)
    {
        if (list != null)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ErrorMessageDetails errormessagedetails = (ErrorMessageDetails)iterator.next();
                if (errormessagedetails != null && 2 == errormessagedetails.getSeverityCode())
                {
                    iterator.remove();
                }
            } while (true);
        }
        super.setErrors(list);
    }
}
