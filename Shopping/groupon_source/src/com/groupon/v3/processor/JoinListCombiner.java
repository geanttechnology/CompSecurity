// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.v3.processor:
//            ListCombiner, BackgroundDataProcessor

public class JoinListCombiner extends ListCombiner
{

    public transient JoinListCombiner(BackgroundDataProcessor abackgrounddataprocessor[][])
    {
        super(abackgrounddataprocessor);
    }

    public List combine(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.addAll((List)list.next())) { }
        return arraylist;
    }
}
