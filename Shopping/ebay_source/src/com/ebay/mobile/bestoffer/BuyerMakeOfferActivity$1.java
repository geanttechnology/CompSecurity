// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;


// Referenced classes of package com.ebay.mobile.bestoffer:
//            BuyerMakeOfferActivity

static class yerOfferStage
{

    static final int $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[];
    static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

    static 
    {
        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[com.ebay.mobile.viewitem.nHandled.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.nHandled.INITIAL_LOAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.nHandled.SHIPPING_COSTS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage = new int[yerOfferStage.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[yerOfferStage.REVIEW.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[yerOfferStage.COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[yerOfferStage.COMPLETE_ERROR_RETRY_AVAILABLE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[yerOfferStage.INPUT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[yerOfferStage.COMPLETE_SENT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[yerOfferStage.COMPLETE_AUTO_ACCEPTED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[yerOfferStage.COMPLETE_AUTO_DECLINED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[yerOfferStage.COMPLETE_ERROR.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
