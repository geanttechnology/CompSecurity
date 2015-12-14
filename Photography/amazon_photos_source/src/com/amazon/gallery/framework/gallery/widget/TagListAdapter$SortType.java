// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import com.amazon.gallery.framework.data.dao.SortClause;
import com.amazon.gallery.framework.data.dao.SortOrder;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            TagListAdapter

public static final class sortOrder extends Enum
{

    private static final DATE_DESC $VALUES[];
    public static final DATE_DESC DATE_ASC;
    public static final DATE_DESC DATE_DESC;
    public static final DATE_DESC NAME_ASC;
    public static final DATE_DESC NAME_DESC;
    private final SortOrder sortOrder;

    public static sortOrder valueOf(String s)
    {
        return (sortOrder)Enum.valueOf(com/amazon/gallery/framework/gallery/widget/TagListAdapter$SortType, s);
    }

    public static sortOrder[] values()
    {
        return (sortOrder[])$VALUES.clone();
    }

    public SortOrder getSortOrder()
    {
        return sortOrder;
    }

    static 
    {
        NAME_ASC = new <init>("NAME_ASC", 0, new SortOrder("label", com.amazon.gallery.framework.data.dao.SC));
        NAME_DESC = new <init>("NAME_DESC", 1, new SortOrder("label", com.amazon.gallery.framework.data.dao.ESC));
        DATE_ASC = new <init>("DATE_ASC", 2, new SortOrder(new SortClause[] {
            new SortClause("has_sort_date", com.amazon.gallery.framework.data.dao.tType), new SortClause("sort_date", com.amazon.gallery.framework.data.dao.tType), new SortClause("date_created", com.amazon.gallery.framework.data.dao.tType)
        }));
        DATE_DESC = new <init>("DATE_DESC", 3, new SortOrder(new SortClause[] {
            new SortClause("has_sort_date", com.amazon.gallery.framework.data.dao.tType), new SortClause("sort_date", com.amazon.gallery.framework.data.dao.tType), new SortClause("date_created", com.amazon.gallery.framework.data.dao.tType)
        }));
        $VALUES = (new .VALUES[] {
            NAME_ASC, NAME_DESC, DATE_ASC, DATE_DESC
        });
    }

    private I(String s, int i, SortOrder sortorder)
    {
        super(s, i);
        sortOrder = sortorder;
    }
}
