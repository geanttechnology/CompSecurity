// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            EbnOrderDetailsActivity

static class ndled
{

    static final int $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[];
    static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

    static 
    {
        $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState = new int[com.ebay.mobile.util.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[com.ebay.mobile.util.PENDING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[com.ebay.mobile.util.IN_TRANSIT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[com.ebay.mobile.util.DELIVERED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[com.ebay.mobile.util.CANCELLED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[com.ebay.mobile.viewitem.Handled.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.Handled.INITIAL_LOAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
