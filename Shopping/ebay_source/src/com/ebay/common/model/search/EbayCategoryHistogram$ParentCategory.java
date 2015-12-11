// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;

import java.util.ArrayList;

// Referenced classes of package com.ebay.common.model.search:
//            EbayCategoryHistogram

public static final class children extends children
{

    public final ArrayList children;

    public ()
    {
        children = new ArrayList();
    }

    public children(children children1)
    {
        super(children1);
        children = new ArrayList();
    }

    children(ArrayList arraylist)
    {
        children = arraylist;
    }
}
