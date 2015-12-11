// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

public class Features
{
    public static class CategoryIntent
    {

        public String categoryIntent;
        public String hierarchy;
        public String seoName;

        public CategoryIntent()
        {
            categoryIntent = "";
            hierarchy = "";
            seoName = "";
        }
    }

    public static class Metadata
    {

        public List categoryIntent;

        public Metadata()
        {
            categoryIntent = new ArrayList();
        }
    }

    public static final class SearchIntentCategory extends Enum
    {

        private static final SearchIntentCategory $VALUES[];
        public static final SearchIntentCategory FOOD_AND_DRINK;
        public static final SearchIntentCategory HEALTH_BEAUTY_WELLNESS;
        public static final SearchIntentCategory UNKNOWN;
        private String val;

        public static SearchIntentCategory valueOf(String s)
        {
            return (SearchIntentCategory)Enum.valueOf(com/groupon/db/models/Features$SearchIntentCategory, s);
        }

        public static SearchIntentCategory[] values()
        {
            return (SearchIntentCategory[])$VALUES.clone();
        }

        public String toString()
        {
            return val;
        }

        public String toTrackingString()
        {
            static class _cls1
            {

                static final int $SwitchMap$com$groupon$db$models$Features$SearchIntentCategory[];

                static 
                {
                    $SwitchMap$com$groupon$db$models$Features$SearchIntentCategory = new int[SearchIntentCategory.values().length];
                    try
                    {
                        $SwitchMap$com$groupon$db$models$Features$SearchIntentCategory[SearchIntentCategory.FOOD_AND_DRINK.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$groupon$db$models$Features$SearchIntentCategory[SearchIntentCategory.HEALTH_BEAUTY_WELLNESS.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.groupon.db.models.Features.SearchIntentCategory[ordinal()])
            {
            default:
                return toString();

            case 1: // '\001'
                return "F&D";

            case 2: // '\002'
                return "HBW";
            }
        }

        static 
        {
            UNKNOWN = new SearchIntentCategory("UNKNOWN", 0, "Unknown");
            FOOD_AND_DRINK = new SearchIntentCategory("FOOD_AND_DRINK", 1, "Food & Drink");
            HEALTH_BEAUTY_WELLNESS = new SearchIntentCategory("HEALTH_BEAUTY_WELLNESS", 2, "Beauty & Spas");
            $VALUES = (new SearchIntentCategory[] {
                UNKNOWN, FOOD_AND_DRINK, HEALTH_BEAUTY_WELLNESS
            });
        }

        private SearchIntentCategory(String s, int i, String s1)
        {
            super(s, i);
            val = s1;
        }
    }


    public Metadata metadata;

    public Features()
    {
        metadata = new Metadata();
    }

    public SearchIntentCategory getCategoryIntent()
    {
label0:
        {
            if (metadata == null || metadata.categoryIntent == null)
            {
                break label0;
            }
            Iterator iterator = metadata.categoryIntent.iterator();
            CategoryIntent categoryintent;
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    categoryintent = (CategoryIntent)iterator.next();
                } while (!Strings.notEmpty(categoryintent.hierarchy));
                if (categoryintent.hierarchy.contains(SearchIntentCategory.FOOD_AND_DRINK.toString()))
                {
                    return SearchIntentCategory.FOOD_AND_DRINK;
                }
            } while (!categoryintent.hierarchy.contains(SearchIntentCategory.HEALTH_BEAUTY_WELLNESS.toString()));
            return SearchIntentCategory.HEALTH_BEAUTY_WELLNESS;
        }
        return SearchIntentCategory.UNKNOWN;
    }
}
