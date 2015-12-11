// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.PaginationElement;
import com.ebay.common.net.api.search.idealmodel.RegularSrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.common.util.IncrementingInt;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            ISearchTracking, EbayFindingApi

private static final class <init> extends EbayResponse
    implements ISearchTracking
{

    private EbayAspectHistogram aspects;
    private Integer auctionItemCount;
    private EbayCategoryHistogram categories;
    Map fillCategories;
    private Integer fixedPriceItemCount;
    private ArrayList itemIds;
    private ArrayList items;
    private ArrayList rawItems;
    private String savedSearchQuery;
    private int totalCount;

    private final <init> parseResponse(InputStream inputstream)
        throws SAXException, IOException
    {
        <init> <init>1 = new init>(this);
        SaxHandler.parseXml(inputstream, <init>1);
        return <init>1;
    }

    private void translateWireModelToIdealModel()
    {
        if (items == null)
        {
            items = new ArrayList();
        }
        int i = 0;
        for (Iterator iterator = rawItems.iterator(); iterator.hasNext();)
        {
            EbaySearchListItem ebaysearchlistitem = (EbaySearchListItem)iterator.next();
            items.add((new RegularSrpListItem(ebaysearchlistitem)).withTrackableRank(i));
            i++;
        }

    }

    public boolean areExpansionsSurfaced()
    {
        return false;
    }

    public final void fill(ArrayList arraylist)
    {
        if (items != null)
        {
            for (Iterator iterator = items.iterator(); iterator.hasNext(); arraylist.add((SrpListItem)iterator.next())) { }
        }
    }

    public final EbayAspectHistogram getAspects()
    {
        return aspects;
    }

    public Integer getAuctionItemCount()
    {
        return auctionItemCount;
    }

    public final EbayCategoryHistogram getCategories()
    {
        return categories;
    }

    public Integer getFixedPriceItemCount()
    {
        return fixedPriceItemCount;
    }

    public ArrayList getItemIds()
    {
        return itemIds;
    }

    public volatile List getItemIds()
    {
        return getItemIds();
    }

    public final ArrayList getPage()
    {
        return items;
    }

    public volatile List getPage()
    {
        return getPage();
    }

    public String getRequestCorrelationId()
    {
        return null;
    }

    public final String getSavedSearchQuery()
    {
        return savedSearchQuery;
    }

    public final int getTotalCount()
    {
        return totalCount;
    }

    public String getTrackingResponseHeader()
    {
        return null;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.on
    {
        try
        {
            inputstream = parseResponse(inputstream);
            if (((parseResponse) (inputstream)).aginationOutput != null)
            {
                totalCount = ((totalCount) (inputstream)).aginationOutput.totalEntries;
            }
            if (((aginationOutput) (inputstream)).earchResult != null && !((earchResult) (inputstream)).earchResult.items.isEmpty())
            {
                rawItems = ((rawItems) (inputstream)).earchResult.items;
                if (totalCount == 0)
                {
                    totalCount = rawItems.size();
                }
                itemIds = ((itemIds) (inputstream)).earchResult.itemIds;
                auctionItemCount = Integer.valueOf(((auctionItemCount) (inputstream)).uctionItemCount.intValue());
                fixedPriceItemCount = Integer.valueOf(((fixedPriceItemCount) (inputstream)).ixedPriceItemCount.intValue());
                if (ackCode != -1)
                {
                    translateWireModelToIdealModel();
                }
            }
            if (((translateWireModelToIdealModel) (inputstream)).ategories != null && !((ategories) (inputstream)).ategories.categories.isEmpty())
            {
                categories = ((categories) (inputstream)).ategories;
            }
            if (((ategories) (inputstream)).spects != null && !((spects) (inputstream)).spects.isEmpty())
            {
                aspects = ((aspects) (inputstream)).spects;
            }
            savedSearchQuery = ((savedSearchQuery) (inputstream)).avedSearchQuery;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.on.create(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.on.create(inputstream);
        }
    }

    private ()
    {
        rawItems = null;
        items = null;
        itemIds = new ArrayList();
        auctionItemCount = null;
        fixedPriceItemCount = null;
        totalCount = 0;
        categories = null;
        aspects = null;
        savedSearchQuery = null;
        fillCategories = null;
    }

    fillCategories(fillCategories fillcategories)
    {
        this();
    }
}
