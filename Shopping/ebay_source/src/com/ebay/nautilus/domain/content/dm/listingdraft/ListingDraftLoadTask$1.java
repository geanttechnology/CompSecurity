// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;


// Referenced classes of package com.ebay.nautilus.domain.content.dm.listingdraft:
//            ListingDraftLoadTask, ListingDraftOperation

static class 
{

    static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation = new int[ListingDraftOperation.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.CREATE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.CREATE_RELIST.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.GET.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.PUBLISH.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
