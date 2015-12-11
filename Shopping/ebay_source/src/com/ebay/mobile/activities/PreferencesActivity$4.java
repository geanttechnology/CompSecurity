// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

static class onManager.NotificationType
{

    static final int $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType = new int[com.ebay.mobile.notifications.anager.NotificationType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[com.ebay.mobile.notifications.anager.NotificationType.GCM.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[com.ebay.mobile.notifications.anager.NotificationType.C2DM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
