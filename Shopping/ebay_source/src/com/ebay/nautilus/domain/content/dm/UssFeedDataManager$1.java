// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssFeedDataManager

static class um
{

    static final int $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum = new int[ContentTypeEnum.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.DEALS_CATEGORY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.LISTING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.RTM_CAMPAIGN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.COLLECTION.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.RPP_EVENT_GROUP.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
