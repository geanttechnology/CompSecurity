// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;


// Referenced classes of package com.ebay.mobile.sell:
//            ListingFragmentActivity

static class tDataManager.DispatchType
{

    static final int $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState[];
    static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState = new int[adingState.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState[adingState.LOADING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState[adingState.LOADED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState[adingState.ERROR.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType = new int[com.ebay.nautilus.domain.content.dm.spatchType.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.CREATE_COMPLETE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.CREATE_RELIST_COMPLETE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.BLOCKING_CHANGE_ACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.VALIDATE_ACK.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.PUBLISH_ACK.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.VALIDATE_COMPLETE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.PUBLISH_COMPLETE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.BLOCKING_CHANGE_COMPLETE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.COMPLETE.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.spatchType.ACK.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
