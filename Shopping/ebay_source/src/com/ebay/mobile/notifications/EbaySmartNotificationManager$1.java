// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;


// Referenced classes of package com.ebay.mobile.notifications:
//            EbaySmartNotificationManager

static class tificationType
{

    static final int $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType = new int[tificationType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[tificationType.C2DM.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[tificationType.GCM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[tificationType.POLL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
