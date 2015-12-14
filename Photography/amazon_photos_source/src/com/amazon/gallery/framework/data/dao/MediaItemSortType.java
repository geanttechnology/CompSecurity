// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            SortOrder, SortClause

public final class MediaItemSortType extends Enum
{

    private static final MediaItemSortType $VALUES[];
    public static final MediaItemSortType DATE_ADDED_ASC;
    public static final MediaItemSortType DATE_ADDED_DESC;
    public static final MediaItemSortType DATE_TAKEN_ASC;
    public static final MediaItemSortType DATE_TAKEN_DESC;
    public static final MediaItemSortType NAME_ASC;
    public static final MediaItemSortType TIME_STAMP_ASC;
    public static final MediaItemSortType TIME_STAMP_DESC;
    private final String filingType;
    private final SortOrder sortOrder;

    private MediaItemSortType(String s, int i, SortOrder sortorder, String s1)
    {
        super(s, i);
        sortOrder = sortorder;
        filingType = s1;
        if (s1 == null)
        {
            throw new IllegalArgumentException("FilingType shouldn't be null");
        } else
        {
            return;
        }
    }

    public static MediaItemSortType toEnum(String s)
    {
        try
        {
            s = valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return TIME_STAMP_DESC;
        }
        return s;
    }

    public static MediaItemSortType valueOf(String s)
    {
        return (MediaItemSortType)Enum.valueOf(com/amazon/gallery/framework/data/dao/MediaItemSortType, s);
    }

    public static MediaItemSortType[] values()
    {
        return (MediaItemSortType[])$VALUES.clone();
    }

    public String getFilingType()
    {
        return filingType;
    }

    public SortOrder getSortOrder()
    {
        return sortOrder;
    }

    public long getSortingDate(MediaItem mediaitem)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType = new int[MediaItemSortType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.TIME_STAMP_ASC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.TIME_STAMP_DESC.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_TAKEN_ASC.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_TAKEN_DESC.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.NAME_ASC.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_ADDED_ASC.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.data.dao.MediaItemSortType[ordinal()])
        {
        default:
            return mediaitem.getDateAddedMs();

        case 1: // '\001'
        case 2: // '\002'
            return mediaitem.getTimestampMs();

        case 3: // '\003'
        case 4: // '\004'
            return mediaitem.getDateCreatedMs();
        }
    }

    public boolean isDescending()
    {
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.data.dao.MediaItemSortType[ordinal()])
        {
        case 2: // '\002'
        case 4: // '\004'
        default:
            return true;

        case 1: // '\001'
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
            return false;
        }
    }

    static 
    {
        TIME_STAMP_ASC = new MediaItemSortType("TIME_STAMP_ASC", 0, new SortOrder(new SortClause[] {
            new SortClause("has_time_stamp", SortOrder.Order.DESC), new SortClause("time_stamp", SortOrder.Order.ASC), new SortClause("date_added", SortOrder.Order.ASC)
        }), "timeline_time_stamp");
        TIME_STAMP_DESC = new MediaItemSortType("TIME_STAMP_DESC", 1, new SortOrder(new SortClause[] {
            new SortClause("has_time_stamp", SortOrder.Order.DESC), new SortClause("time_stamp", SortOrder.Order.DESC), new SortClause("date_added", SortOrder.Order.DESC)
        }), "timeline_time_stamp");
        DATE_TAKEN_ASC = new MediaItemSortType("DATE_TAKEN_ASC", 2, new SortOrder(new SortClause[] {
            new SortClause("has_date", SortOrder.Order.DESC), new SortClause("date_created", SortOrder.Order.ASC), new SortClause("object_id_low", SortOrder.Order.DESC)
        }), "date_created");
        DATE_TAKEN_DESC = new MediaItemSortType("DATE_TAKEN_DESC", 3, new SortOrder(new SortClause[] {
            new SortClause("has_date", SortOrder.Order.DESC), new SortClause("date_created", SortOrder.Order.DESC), new SortClause("date_added", SortOrder.Order.DESC), new SortClause("object_id_low", SortOrder.Order.DESC)
        }), "date_created");
        DATE_ADDED_ASC = new MediaItemSortType("DATE_ADDED_ASC", 4, new SortOrder(new SortClause[] {
            new SortClause("date_added", SortOrder.Order.ASC), new SortClause("object_id_low", SortOrder.Order.DESC)
        }), "timeline_date_added");
        DATE_ADDED_DESC = new MediaItemSortType("DATE_ADDED_DESC", 5, new SortOrder(new SortClause[] {
            new SortClause("date_added", SortOrder.Order.DESC), new SortClause("object_id_low", SortOrder.Order.DESC)
        }), "timeline_date_added");
        NAME_ASC = new MediaItemSortType("NAME_ASC", 6, new SortOrder("name", SortOrder.Order.ASC), "date_created");
        $VALUES = (new MediaItemSortType[] {
            TIME_STAMP_ASC, TIME_STAMP_DESC, DATE_TAKEN_ASC, DATE_TAKEN_DESC, DATE_ADDED_ASC, DATE_ADDED_DESC, NAME_ASC
        });
    }
}
