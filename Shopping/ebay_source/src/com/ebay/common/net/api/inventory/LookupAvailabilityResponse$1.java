// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;


// Referenced classes of package com.ebay.common.net.api.inventory:
//            LookupAvailabilityResponse

static class ype
{

    static final int $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[];

    static 
    {
        $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType = new int[com.ebay.common.model.inventory.yType.values().length];
        try
        {
            $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.yType.IN_STOCK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.yType.SHIP_TO_STORE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.yType.OUT_OF_STOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
