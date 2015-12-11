// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;


// Referenced classes of package com.ebay.mobile.connection.myebay:
//            WatchingFragment

class t extends com.ebay.mobile.common.t.Refinement
{

    final WatchingFragment this$0;

    public String getStringIdentifier()
    {
        return com.ebay.nautilus.domain.content.dm.anager.Sort.CurrentPriceDescending.toString();
    }

    public boolean isDefaultRefinement()
    {
        return false;
    }

    aManager.Sort(String s)
    {
        this$0 = WatchingFragment.this;
        super(s);
    }
}
