// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;


// Referenced classes of package com.ebay.mobile.connection.myebay:
//            BuyingFragment

class ent extends com.ebay.mobile.common.ent.Refinement
{

    final BuyingFragment this$0;

    public String getStringIdentifier()
    {
        return "CurrentPrice";
    }

    public boolean isDefaultRefinement()
    {
        return false;
    }

    ent(String s)
    {
        this$0 = BuyingFragment.this;
        super(s);
    }
}
