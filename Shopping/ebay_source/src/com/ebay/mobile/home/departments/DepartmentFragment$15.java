// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

static class Enum
{

    static final int $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[];
    static final int $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum = new int[ChannelEnum.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[ChannelEnum.ACTIVITY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[ChannelEnum.SHOP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[ChannelEnum.SELL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum = new int[ContentTypeEnum.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.DEPARTMENT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.CATEGORY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
