// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import com.amazon.gallery.framework.data.dao.MediaItemSortType;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorActionBar

static class pe
{

    static final int $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType = new int[MediaItemSortType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_TAKEN_DESC.ordinal()] = 1;
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
            $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.TIME_STAMP_ASC.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$data$dao$MediaItemSortType[MediaItemSortType.DATE_ADDED_DESC.ordinal()] = 5;
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
