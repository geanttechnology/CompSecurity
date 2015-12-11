// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.PaginationElement;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

private static final class <init> extends EbayResponse
{

    private EbayAspectHistogram aspects;
    private EbayCategoryHistogram categories;
    Map fillCategories;
    private ArrayList itemIds;
    private ArrayList items;
    private String savedSearchQuery;
    private int totalCount;

    private final <init> parseResponse(InputStream inputstream)
        throws SAXException, IOException
    {
        <init> <init>1 = new (this);
        SaxHandler.parseXml(inputstream, <init>1);
        return <init>1;
    }

    public final void fill(ArrayList arraylist)
    {
        if (items != null)
        {
            for (Iterator iterator = items.iterator(); iterator.hasNext(); arraylist.add((EbaySearchListItem)iterator.next())) { }
        } else
        {
            arraylist.add(new EbaySearchListItem());
        }
    }

    public final EbayAspectHistogram getAspects()
    {
        return aspects;
    }

    public final EbayCategoryHistogram getCategories()
    {
        return categories;
    }

    public ArrayList getItemIds()
    {
        return itemIds;
    }

    public final ArrayList getPage()
    {
        return items;
    }

    public final String getSavedSearchQuery()
    {
        return savedSearchQuery;
    }

    public final int getTotalCount()
    {
        return totalCount;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.e
    {
        try
        {
            inputstream = parseResponse(inputstream);
            if (((parseResponse) (inputstream)).tionOutput != null)
            {
                totalCount = ((totalCount) (inputstream)).tionOutput.totalEntries;
            }
            if (((tionOutput) (inputstream)).Result != null && !((Result) (inputstream)).Result.items.isEmpty())
            {
                items = ((items) (inputstream)).Result.items;
                if (totalCount == 0)
                {
                    totalCount = items.size();
                }
                itemIds = ((itemIds) (inputstream)).Result.itemIds;
            }
            if (((Result.itemIds) (inputstream)).ries != null && !((ries) (inputstream)).ries.categories.isEmpty())
            {
                categories = ((categories) (inputstream)).ries;
            }
            if (((ries) (inputstream)).s != null && !((s) (inputstream)).s.isEmpty())
            {
                aspects = ((aspects) (inputstream)).s;
            }
            savedSearchQuery = ((savedSearchQuery) (inputstream)).earchQuery;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.te(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.te(inputstream);
        }
    }

    private Result()
    {
        items = null;
        itemIds = new ArrayList();
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
