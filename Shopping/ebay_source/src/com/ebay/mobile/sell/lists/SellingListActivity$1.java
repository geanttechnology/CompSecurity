// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;


// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellingListActivity

static class stType
{

    static final int $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType = new int[stType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[stType.DRAFT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[stType.ACTIVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[stType.SOLD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[stType.UNSOLD.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[stType.SCHEDULED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
