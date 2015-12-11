// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;


// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory

static class .AfterSalesType
{

    static final int $SwitchMap$com$ebay$mobile$Item$PaymentReminderState[];
    static final int $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$Item$PaymentReminderState = new int[com.ebay.mobile.derState.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$Item$PaymentReminderState[com.ebay.mobile.derState.STATE_SENT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$ebay$mobile$Item$PaymentReminderState[com.ebay.mobile.derState.STATE_ENABLED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$mobile$Item$PaymentReminderState[com.ebay.mobile.derState.STATE_DISABLED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType = new int[com.ebay.mobile.activities.Activity.AfterSalesType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.Activity.AfterSalesType.NOT_APPLICABLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.Activity.AfterSalesType.CANCEL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.Activity.AfterSalesType.CASE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.Activity.AfterSalesType.INQUIRY.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$activities$AfterSalesWebViewActivity$AfterSalesType[com.ebay.mobile.activities.Activity.AfterSalesType.RETURN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
