// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.MetaItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NWTOptionsMetaData
{

    public static final String NOT_NWT = "not_nwt";
    public static final String NWT = "nwt";
    public static final String RETAIL = "ret";
    public static List nwtFilterOptions;
    public static List nwtListingOptions;

    public NWTOptionsMetaData()
    {
    }

    public static MetaItem getConditionMetaItemForFilters(String s)
    {
        for (Iterator iterator = nwtFilterOptions.iterator(); iterator.hasNext();)
        {
            MetaItem metaitem = (MetaItem)iterator.next();
            if (metaitem.getId().equals(s))
            {
                return metaitem;
            }
        }

        return null;
    }

    public static MetaItem getConditionMetaItemForListingFlow(String s)
    {
        for (Iterator iterator = nwtListingOptions.iterator(); iterator.hasNext();)
        {
            MetaItem metaitem = (MetaItem)iterator.next();
            if (metaitem.getId().equals(s))
            {
                return metaitem;
            }
        }

        return null;
    }

    public static List getConditionMetaItemsForFilters()
    {
        return nwtFilterOptions;
    }

    public static List getConditionMetaItemsForListingFlow()
    {
        return nwtFilterOptions;
    }

    public MetaItem getAllConditionMetaItemForFilters()
    {
        return new MetaItem("not_nwt", PMApplication.getContext().getString(0x7f060040));
    }

    public MetaItem getAllConditionMetaItemForListingFlow()
    {
        return new MetaItem("not_nwt", PMApplication.getContext().getString(0x7f0601ce));
    }

    static 
    {
        nwtFilterOptions = new ArrayList();
        nwtListingOptions = new ArrayList();
        nwtFilterOptions.add(new MetaItem("not_nwt", PMApplication.getContext().getString(0x7f060040)));
        nwtFilterOptions.add(new MetaItem("nwt", PMApplication.getContext().getString(0x7f06026b)));
        nwtFilterOptions.add(new MetaItem("ret", PMApplication.getContext().getString(0x7f06026a)));
        nwtListingOptions.add(new MetaItem("not_nwt", PMApplication.getContext().getString(0x7f0601ce)));
        nwtListingOptions.add(new MetaItem("nwt", PMApplication.getContext().getString(0x7f0602cd)));
        nwtListingOptions.add(new MetaItem("ret", PMApplication.getContext().getString(0x7f0602ce)));
    }
}
