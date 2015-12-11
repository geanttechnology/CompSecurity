// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import com.poshmark.data_model.models.MetaItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryMetaData
{
    class Categories
    {

        List categories;
        Map itemMap;
        final CategoryMetaData this$0;

        public List getAllCategories()
        {
            return categories;
        }

        MetaItem getMatchingItem(String s)
        {
            return (MetaItem)itemMap.get(s);
        }

        public void loadCategories()
        {
            categories.clear();
            MetaItem metaitem = new MetaItem("Accessories", "Accessories");
            categories.add(metaitem);
            itemMap.put("Accessories", metaitem);
            metaitem = new MetaItem("Boots", "Boots");
            categories.add(metaitem);
            itemMap.put("Boots", metaitem);
            metaitem = new MetaItem("Clutches & Wallets", "Clutches & Wallets");
            categories.add(metaitem);
            itemMap.put("Clutches & Wallets", metaitem);
            metaitem = new MetaItem("Denim", "Denim");
            categories.add(metaitem);
            itemMap.put("Denim", metaitem);
            metaitem = new MetaItem("Dresses & Skirts", "Dresses & Skirts");
            categories.add(metaitem);
            itemMap.put("Dresses & Skirts", metaitem);
            metaitem = new MetaItem("Handbags", "Handbags");
            categories.add(metaitem);
            itemMap.put("Handbags", metaitem);
            metaitem = new MetaItem("Jackets & Blazers", "Jackets & Blazers");
            categories.add(metaitem);
            itemMap.put("Jackets & Blazers", metaitem);
            metaitem = new MetaItem("Jewelry", "Jewelry");
            categories.add(metaitem);
            itemMap.put("Jewelry", metaitem);
            metaitem = new MetaItem("Outerwear", "Outerwear");
            categories.add(metaitem);
            itemMap.put("Outerwear", metaitem);
            metaitem = new MetaItem("Pants", "Pants");
            categories.add(metaitem);
            itemMap.put("Pants", metaitem);
            metaitem = new MetaItem("Shoes", "Shoes");
            categories.add(metaitem);
            itemMap.put("Shoes", metaitem);
            metaitem = new MetaItem("Sweaters", "Sweaters");
            categories.add(metaitem);
            itemMap.put("Sweaters", metaitem);
            metaitem = new MetaItem("Tops", "Tops");
            categories.add(metaitem);
            itemMap.put("Tops", metaitem);
            metaitem = new MetaItem("Other", "Other");
            categories.add(metaitem);
            itemMap.put("Other", metaitem);
        }

        Categories()
        {
            this$0 = CategoryMetaData.this;
            super();
            categories = new ArrayList();
            itemMap = new HashMap();
        }
    }


    public static final String sCategoryAccessories = "Accessories";
    public static final String sCategoryBoots = "Boots";
    public static final String sCategoryClutchesAndWallets = "Clutches & Wallets";
    public static final String sCategoryDenim = "Denim";
    public static final String sCategoryDressesAndSkirts = "Dresses & Skirts";
    public static final String sCategoryHandbags = "Handbags";
    public static final String sCategoryJacketsAndBlazers = "Jackets & Blazers";
    public static final String sCategoryJewelry = "Jewelry";
    public static final String sCategoryOther = "Other";
    public static final String sCategoryOuterwear = "Outerwear";
    public static final String sCategoryPants = "Pants";
    public static final String sCategoryShoes = "Shoes";
    public static final String sCategorySweaters = "Sweaters";
    public static final String sCategoryTops = "Tops";
    Categories categories;

    public CategoryMetaData()
    {
        if (categories == null)
        {
            categories = new Categories();
            categories.loadCategories();
        }
    }

    public List getAllCategories()
    {
        return categories.getAllCategories();
    }

    public MetaItem getCategory(String s)
    {
        return categories.getMatchingItem(s);
    }
}
