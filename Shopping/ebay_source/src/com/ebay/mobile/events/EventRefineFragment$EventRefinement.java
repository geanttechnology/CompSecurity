// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;


// Referenced classes of package com.ebay.mobile.events:
//            EventRefineFragment

public static class refinementType extends com.ebay.mobile.common.refinementType
{

    private String refineSelectedName;
    public refineSelectedName refinementType;

    public String getStringIdentifier()
    {
        return refineSelectedName;
    }

    public boolean isDefaultRefinement()
    {
        return false;
    }

    public boolean isTopLevelRefinement()
    {
        return refineSelectedName != null;
    }

    public (String s, String s1,  )
    {
        super(s);
        refineSelectedName = s1;
        refinementType = ;
    }
}
