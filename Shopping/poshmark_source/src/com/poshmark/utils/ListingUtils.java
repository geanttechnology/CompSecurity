// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.StaticCategoryLookup;

public class ListingUtils
{

    public ListingUtils()
    {
    }

    public static int getDrawableIconForCategory(String s)
    {
        if (s != null)
        {
            if (s.equals(StaticCategoryLookup.ACCESSORIES_ID))
            {
                return 0x7f0200d9;
            }
            if (s.equals(StaticCategoryLookup.SHOES_ID))
            {
                return 0x7f0200e9;
            }
            if (s.equals(StaticCategoryLookup.BAGS_ID))
            {
                return 0x7f0200da;
            }
            if (s.equals(StaticCategoryLookup.JEANS_ID))
            {
                return 0x7f0200e2;
            }
            if (!s.equals(StaticCategoryLookup.DRESSES_ID))
            {
                if (s.equals(StaticCategoryLookup.JACKETS_COATS_ID))
                {
                    return 0x7f0200e1;
                }
                if (s.equals(StaticCategoryLookup.JEWELRY_ID))
                {
                    return 0x7f0200e3;
                }
                if (s.equals(StaticCategoryLookup.PANTS_ID))
                {
                    return 0x7f0200e7;
                }
                if (s.equals(StaticCategoryLookup.MAKEUP_ID))
                {
                    return 0x7f0200e5;
                }
                if (s.equals(StaticCategoryLookup.SKIRTS_ID))
                {
                    return 0x7f0200ea;
                }
                if (s.equals(StaticCategoryLookup.TOPS_ID))
                {
                    return 0x7f0200ee;
                }
                if (s.equals(StaticCategoryLookup.SWIM_ID))
                {
                    return 0x7f0200ed;
                }
                if (s.equals(StaticCategoryLookup.SWEATERS_ID))
                {
                    return 0x7f0200ec;
                }
                return !s.equals(StaticCategoryLookup.SLEEPWEAR_ID) ? 0x7f0200db : 0x7f0200eb;
            }
        }
        return 0x7f0200de;
    }
}
