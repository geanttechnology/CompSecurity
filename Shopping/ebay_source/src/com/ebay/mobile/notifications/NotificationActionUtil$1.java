// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;


// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationActionUtil

static class temListingType
{

    static final int $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType[];

    static 
    {
        $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType = new int[com.ebay.common.model.mdns.t.ItemListingType.values().length];
        try
        {
            $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType[com.ebay.common.model.mdns.t.ItemListingType.BINONLY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType[com.ebay.common.model.mdns.t.ItemListingType.BIDONLY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType[com.ebay.common.model.mdns.t.ItemListingType.BIDWITHBIN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
