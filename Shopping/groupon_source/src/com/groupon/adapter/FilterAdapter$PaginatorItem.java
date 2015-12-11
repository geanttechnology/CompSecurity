// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import com.groupon.models.search.domain.FilterSheetListItemType;
import java.util.UUID;

// Referenced classes of package com.groupon.adapter:
//            FilterAdapter

static class ItemType
    implements FilterSheetListItemType
{

    public static final int PAGINATOR_ITEM_TYPE = 4;
    public final String id = UUID.randomUUID().toString();

    public int getFilterSheetListItemType()
    {
        return 4;
    }

    public ItemType()
    {
    }
}
