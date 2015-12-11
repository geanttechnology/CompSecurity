// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class DynamicHeaderInserter extends BackgroundDataProcessor
{

    public DynamicHeaderInserter()
    {
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        pagination = new ArrayList();
        pagination.addAll(list);
        if (dealsubsetattribute != null)
        {
            pagination.add(0, dealsubsetattribute);
        }
        return pagination;
    }
}
