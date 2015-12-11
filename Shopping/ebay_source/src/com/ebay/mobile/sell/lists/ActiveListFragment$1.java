// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;


// Referenced classes of package com.ebay.mobile.sell.lists:
//            ActiveListFragment

class nement extends com.ebay.mobile.common.Refinement
{

    final ActiveListFragment this$0;
    final String val$filterId;

    public String getStringIdentifier()
    {
        return val$filterId;
    }

    public boolean isDefaultRefinement()
    {
        return "activeAll".equals(val$filterId);
    }

    nement(String s1)
    {
        this$0 = final_activelistfragment;
        val$filterId = s1;
        super(String.this);
    }
}
