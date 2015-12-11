// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import java.util.ArrayList;
import roboguice.util.Strings;

public class FilterCategory
{
    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode EVERYTHING;
        public static final Mode FAVORITES;
        public static final Mode SELECTION;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/groupon/models/FilterCategory$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            EVERYTHING = new Mode("EVERYTHING", 0);
            FAVORITES = new Mode("FAVORITES", 1);
            SELECTION = new Mode("SELECTION", 2);
            $VALUES = (new Mode[] {
                EVERYTHING, FAVORITES, SELECTION
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }


    private String categoryId;
    private String categoryName;
    private String facetGroupFiltersForCategory;
    private Mode mode;

    public FilterCategory()
    {
        this(Mode.EVERYTHING);
    }

    public FilterCategory(Mode mode1)
    {
        mode = mode1;
        categoryName = null;
        categoryId = null;
    }

    public FilterCategory(String s, String s1)
    {
        mode = Mode.SELECTION;
        categoryName = s;
        categoryId = s1;
    }

    public FilterCategory(String s, String s1, String s2)
    {
        mode = Mode.SELECTION;
        categoryName = s;
        categoryId = s1;
        facetGroupFiltersForCategory = s2;
    }

    public static FilterCategory createFilterCategory(Bundle bundle)
    {
        if (!bundle.containsKey("category"))
        {
            return null;
        }
        FilterCategory filtercategory;
        String as[];
        as = bundle.getStringArray("category");
        filtercategory = new FilterCategory(Mode.valueOf(as[0]));
        int i = 0 + 1;
        if (!Strings.equals(as[i], "null"))
        {
            filtercategory.categoryName = as[i];
        }
        i++;
        bundle = filtercategory;
        if (Strings.equals(as[i], "null"))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        filtercategory.categoryId = as[i];
        return filtercategory;
        bundle;
        bundle = null;
        return bundle;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public String getDisplayText(Context context)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$models$FilterCategory$Mode[];

            static 
            {
                $SwitchMap$com$groupon$models$FilterCategory$Mode = new int[Mode.values().length];
                try
                {
                    $SwitchMap$com$groupon$models$FilterCategory$Mode[Mode.EVERYTHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$models$FilterCategory$Mode[Mode.FAVORITES.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$models$FilterCategory$Mode[Mode.SELECTION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.groupon.models.FilterCategory.Mode[mode.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return context.getResources().getString(0x7f080356);

        case 2: // '\002'
            return context.getResources().getString(0x7f0801b1);

        case 3: // '\003'
            break;
        }
        if (Strings.notEmpty(categoryName))
        {
            return categoryName;
        } else
        {
            return "";
        }
    }

    public Bundle getExtras()
    {
        Bundle bundle = new Bundle();
        ArrayList arraylist = new ArrayList();
        arraylist.add(mode.toString());
        String s;
        if (categoryName != null)
        {
            s = categoryName;
        } else
        {
            s = "null";
        }
        arraylist.add(s);
        if (categoryId != null)
        {
            s = categoryId;
        } else
        {
            s = "null";
        }
        arraylist.add(s);
        bundle.putStringArray("category", (String[])arraylist.toArray(new String[arraylist.size()]));
        return bundle;
    }

    public String getFacetGroupFiltersForCategory()
    {
        return facetGroupFiltersForCategory;
    }

    public Mode getMode()
    {
        return mode;
    }

    public void setCategoryId(String s)
    {
        categoryId = s;
    }

    public void setCategoryName(String s)
    {
        categoryName = s;
    }

    public void setFacetGroupFiltersForCategory(String s)
    {
        facetGroupFiltersForCategory = s;
    }

    public void setMode(Mode mode1)
    {
        mode = mode1;
    }

    public String toString()
    {
        if (categoryName != null)
        {
            return Strings.join(",", new String[] {
                mode.toString(), categoryName
            });
        } else
        {
            return mode.toString();
        }
    }
}
