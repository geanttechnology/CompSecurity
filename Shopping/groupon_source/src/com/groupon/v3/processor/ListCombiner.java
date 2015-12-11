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

public abstract class ListCombiner extends BackgroundDataProcessor
{

    protected BackgroundDataProcessor backgroundDataProcessorChains[][];

    public transient ListCombiner(BackgroundDataProcessor abackgrounddataprocessor[][])
    {
        backgroundDataProcessorChains = abackgrounddataprocessor;
    }

    public abstract List combine(List list);

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        ArrayList arraylist = new ArrayList();
        if (backgroundDataProcessorChains != null)
        {
            BackgroundDataProcessor abackgrounddataprocessor[][] = backgroundDataProcessorChains;
            int k = abackgrounddataprocessor.length;
            for (int i = 0; i < k; i++)
            {
                BackgroundDataProcessor abackgrounddataprocessor1[] = abackgrounddataprocessor[i];
                list = new ArrayList();
                List list1 = list;
                if (abackgrounddataprocessor1 != null)
                {
                    int l = abackgrounddataprocessor1.length;
                    int j = 0;
                    do
                    {
                        list1 = list;
                        if (j >= l)
                        {
                            break;
                        }
                        list = abackgrounddataprocessor1[j].process(list, dealsubsetattribute, pagination, processingcontext);
                        j++;
                    } while (true);
                }
                arraylist.add(list1);
            }

            list = combine(arraylist);
        }
        return list;
    }
}
