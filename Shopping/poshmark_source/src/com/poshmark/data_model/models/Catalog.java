// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.List;

public class Catalog
{
    public class Catalogue
    {

        List departments;
        final Catalog this$0;

        public Catalogue()
        {
            this$0 = Catalog.this;
            super();
        }
    }

    public class Entry
    {

        public List categories;
        public List category_features;
        public List child_entries;
        public String display;
        public String id;
        public boolean listing_flow_enabled;
        public List sizes;
        final Catalog this$0;
        public boolean use_sizes_for_my_size;

        public Entry()
        {
            this$0 = Catalog.this;
            super();
        }
    }

    public class GlobalFeatures
    {

        public List color;
        final Catalog this$0;

        public GlobalFeatures()
        {
            this$0 = Catalog.this;
            super();
        }
    }

    public class Size
    {

        public String longName;
        public String shortName;
        final Catalog this$0;

        public Size()
        {
            this$0 = Catalog.this;
            super();
        }
    }


    public static String DEPT_WOMEN = "Women";
    public Catalogue catalog;
    public List colors;
    public GlobalFeatures global_features;
    public String updated_at;

    public Catalog()
    {
    }

    public List getCategoryList()
    {
        if (catalog != null && catalog.departments != null)
        {
            for (int i = 0; i < catalog.departments.size(); i++)
            {
                Entry entry = (Entry)catalog.departments.get(i);
                if (entry != null && entry.display.equalsIgnoreCase(DEPT_WOMEN))
                {
                    return entry.categories;
                }
            }

        }
        return null;
    }

}
