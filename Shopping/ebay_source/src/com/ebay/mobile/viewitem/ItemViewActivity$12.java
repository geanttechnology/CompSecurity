// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

static class rAction
{

    static final int $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType[];
    static final int $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[];
    static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

    static 
    {
        $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType = new int[com.ebay.common.content.dm.equestType.values().length];
        try
        {
            $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType[com.ebay.common.content.dm.equestType.DISPLAY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror49) { }
        try
        {
            $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType[com.ebay.common.content.dm.equestType.PLA.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror48) { }
        try
        {
            $SwitchMap$com$ebay$common$content$dm$AdRtmDataManager$AdRequestType[com.ebay.common.content.dm.equestType.NONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror47) { }
        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ActionHandled.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.ITEM_ADDED_TO_CART.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror46) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.CART_UPDATED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror45) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.INITIAL_LOAD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror44) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.WATCH_CHANGED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror43) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.ITEM_ENDED_BY_SELLER.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror42) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.SHIPMENT_TRACKING.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror41) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.MARK_PAID_OR_UNPAID.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror40) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.GET_ITEM_FLAGS_REFRESHED.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror39) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.BOPIS_AVAILABILITY.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror38) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.MARK_SHIPPED_OR_UNSHIPPED.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror37) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.CURRENCY_RATE_UPDATED.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror36) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.BIDDING_HISTORY.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror35) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.BID_CHANGE.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror34) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ActionHandled.PAYMENT_REMINDER_SENT.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror33) { }
        $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction = new int[rAction.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.SELL_LIKE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror32) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.END_ITEM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror31) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.MARK_SHIPPED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror30) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.MARK_NOT_SHIPPED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror29) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.TRACK_PACKAGE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror28) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.EDIT_PACKAGE_TRACKING.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror27) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.ENTER_PACKAGE_TRACKING.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.LEAVE_FEEDBACK.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.MARK_AS_PAID.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.MARK_AS_UNPAID.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.RELIST.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.REVISE.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.SHARE.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.BUYING_OPTIONS.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.BIDDING_ACTIVITY.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.PLACE_BID.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.PLACE_BID_AMOUNT.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.BUY_IT_NOW.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.BUY_ANOTHER.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.WATCH.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.UNWATCH.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.BUYER_REVIEW_OFFER.ordinal()] = 22;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.ADD_TO_CART.ordinal()] = 23;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.VIEW_CART.ordinal()] = 24;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.PAY_NOW.ordinal()] = 25;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.PAYMENT_OPTIONS.ordinal()] = 26;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.VIEW_RELISTED_ITEM.ordinal()] = 27;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.EBN_ORDER_DETAILS.ordinal()] = 28;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.NONE.ordinal()] = 29;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.SPR.ordinal()] = 30;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.CHANGE_ADDRESS.ordinal()] = 31;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.MAKE_OFFER.ordinal()] = 32;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ItemViewActivity$UserAction[rAction.PLUS_SIGNUP.ordinal()] = 33;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
