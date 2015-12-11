// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PriceInfo;
import com.poshmark.utils.meta_data.AvailabilityMetaData;
import com.poshmark.utils.meta_data.NWTOptionsMetaData;
import java.util.ArrayList;
import java.util.List;

public class DbApi
{

    public static String DRESSES_ID = "00108975d97b4e80ef00a955";
    public static String JEANS_ID = "001a8975d97b4e80ef00a955";
    public static String OTHER_ID = "002e8975d97b4e80ef00a955";
    public static String PANTS_ID = "001c8975d97b4e80ef00a955";
    public static String SHOES_ID = "00268975d97b4e80ef00a955";
    public static String SWEATERS_ID = "00168975d97b4e80ef00a955";
    public static AvailabilityMetaData availabilityMetaData = new AvailabilityMetaData();
    public static List cannedList;
    public static NWTOptionsMetaData nwtOptionsMetaData = new NWTOptionsMetaData();

    public DbApi()
    {
    }

    public static List getAllBrands()
    {
        return GlobalDbController.getGlobalDbController().getAllBrands();
    }

    public static List getAllCategories()
    {
        return GlobalDbController.getGlobalDbController().getAllCategories();
    }

    public static List getAllColors()
    {
        return GlobalDbController.getGlobalDbController().getAllColors();
    }

    public static List getAllConditions()
    {
        NWTOptionsMetaData nwtoptionsmetadata = nwtOptionsMetaData;
        return NWTOptionsMetaData.getConditionMetaItemsForFilters();
    }

    public static List getAvailabilityList()
    {
        return availabilityMetaData.getAvailabilityList();
    }

    public static MetaItem getBrandItemFromLabel(String s)
    {
        MetaItem metaitem = new MetaItem();
        String s1 = GlobalDbController.getGlobalDbController().getBrandCanonicalName(s);
        if (s1 != null)
        {
            metaitem.setDisplay(s1);
            metaitem.setId(s1);
            return metaitem;
        } else
        {
            metaitem.setDisplay(s);
            metaitem.setId(s);
            return metaitem;
        }
    }

    public static List getBrandsForAllCategories()
    {
        return GlobalDbController.getGlobalDbController().getAllBrands();
    }

    public static List getBrandsForCategory(String s)
    {
        return getBrandsForAllCategories();
    }

    public static List getCannedPriceRanges()
    {
        return cannedList;
    }

    public static MetaItem getCurrentCategoryFromId(String s)
    {
        return GlobalDbController.getGlobalDbController().getCategoryFromId(s);
    }

    public static MetaItem getCurrentCategoryFromLabel(String s)
    {
        return GlobalDbController.getGlobalDbController().getCategoryFromLabel(s);
    }

    public static List getDressSizes()
    {
        return GlobalDbController.getGlobalDbController().getAllSizesForCategory(DRESSES_ID);
    }

    public static List getNFSListingOptions()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new MetaItem("available", PMApplication.getContext().getString(0x7f060135)));
        arraylist.add(new MetaItem("not_for_sale", PMApplication.getContext().getString(0x7f0601d4)));
        return arraylist;
    }

    public static List getNWTFilterOptions()
    {
        NWTOptionsMetaData nwtoptionsmetadata = nwtOptionsMetaData;
        return NWTOptionsMetaData.getConditionMetaItemsForFilters();
    }

    public static List getShoeSizes()
    {
        return GlobalDbController.getGlobalDbController().getAllSizesForCategory(SHOES_ID);
    }

    public static MetaItem getSizeForCategoryFromLabel(String s, String s1)
    {
        return GlobalDbController.getGlobalDbController().getSizeForCategoryFromLabel(s, s1);
    }

    public static List getSizesForCategory(String s)
    {
        return GlobalDbController.getGlobalDbController().getAllSizesForCategory(s);
    }

    public static List getSubCategoriesForCategory(String s)
    {
        return GlobalDbController.getGlobalDbController().getAllSubCategoriesForCategory(s);
    }

    public static MetaItem getSubCategoryFromId(String s)
    {
        return GlobalDbController.getGlobalDbController().getSubCategoryFromId(s);
    }

    public static MetaItem getSubCategoryFromLabel(String s)
    {
        return GlobalDbController.getGlobalDbController().getSubCategoryFromLabel(s);
    }

    static 
    {
        cannedList = new ArrayList();
        PriceInfo priceinfo = new PriceInfo(null, "25");
        cannedList.add(priceinfo);
        priceinfo = new PriceInfo("25", "50");
        cannedList.add(priceinfo);
        priceinfo = new PriceInfo("50", "100");
        cannedList.add(priceinfo);
        priceinfo = new PriceInfo("100", "250");
        cannedList.add(priceinfo);
        priceinfo = new PriceInfo("250", "500");
        cannedList.add(priceinfo);
        priceinfo = new PriceInfo("500", null);
        cannedList.add(priceinfo);
    }
}
