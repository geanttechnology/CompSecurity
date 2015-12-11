// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.recommendation;

import com.ebay.nautilus.domain.data.CompactListing;
import com.ebay.nautilus.domain.data.Placement;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.recommendation:
//            Placements

public class GetPlacementResponse extends EbayCosResponse
{

    public Map placementToListingMap;
    public Placements placements;

    public GetPlacementResponse()
    {
        super(true);
    }

    private void mapRecommendationToListing()
    {
        if (placements != null && placements.members != null)
        {
            Iterator iterator = placements.members.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Placements.RecoPlacement recoplacement = (Placements.RecoPlacement)iterator.next();
                ArrayList arraylist1 = null;
                ArrayList arraylist = null;
                if (recoplacement.listings != null)
                {
                    Iterator iterator1 = recoplacement.listings.iterator();
                    do
                    {
                        arraylist1 = arraylist;
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        CompactListing compactlisting = mapWireModelToDataModel((Placements.CompactListing_v2_1)iterator1.next());
                        if (compactlisting != null)
                        {
                            arraylist1 = arraylist;
                            if (arraylist == null)
                            {
                                arraylist1 = new ArrayList();
                            }
                            arraylist1.add(compactlisting);
                            arraylist = arraylist1;
                        }
                    } while (true);
                }
                if (arraylist1 != null)
                {
                    if (placementToListingMap == null)
                    {
                        placementToListingMap = new HashMap();
                    }
                    placementToListingMap.put(new Placement(recoplacement.placementId.longValue(), recoplacement.placementHeader), arraylist1);
                }
            } while (true);
        }
    }

    private CompactListing mapWireModelToDataModel(Placements.CompactListing_v2_1 compactlisting_v2_1)
    {
        CompactListing compactlisting;
label0:
        {
            Object obj = null;
            compactlisting = obj;
            if (compactlisting_v2_1 == null)
            {
                break label0;
            }
            compactlisting = obj;
            if (compactlisting_v2_1.listingId == null)
            {
                break label0;
            }
            if (!com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION.equals(compactlisting_v2_1.format))
            {
                compactlisting = obj;
                if (!com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.FIXED_PRICE.equals(compactlisting_v2_1.format))
                {
                    break label0;
                }
            }
            compactlisting = new CompactListing();
            compactlisting.listingId = compactlisting_v2_1.listingId;
            compactlisting.title = compactlisting_v2_1.title;
            compactlisting.format = compactlisting_v2_1.format;
            compactlisting.status = compactlisting_v2_1.status;
            compactlisting.freeShippingAvailable = compactlisting_v2_1.freeshippingAvailable;
            compactlisting.bidCount = compactlisting_v2_1.bidCount;
            compactlisting.currentBidPrice = compactlisting_v2_1.currentBidPrice;
            compactlisting.lowestFixedPrice = compactlisting_v2_1.fixedPrice;
            if (compactlisting_v2_1.imageURL != null && !compactlisting_v2_1.imageURL.isEmpty())
            {
                com.ebay.nautilus.domain.data.CompactListing.ImageSummary imagesummary = new com.ebay.nautilus.domain.data.CompactListing.ImageSummary();
                imagesummary.imageURL = compactlisting_v2_1.imageURL;
                compactlisting.images = new ArrayList();
                compactlisting.images.add(imagesummary);
            }
            compactlisting.serverSideTrackingInfo = compactlisting_v2_1.clickTracking;
        }
        return compactlisting;
    }

    public boolean hasSuccessResponseCode()
    {
        return super.hasSuccessResponseCode() || NetworkUtil.isHttpClass4xx(responseCode);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        placements = (Placements)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/recommendation/Placements);
        mapRecommendationToListing();
    }
}
