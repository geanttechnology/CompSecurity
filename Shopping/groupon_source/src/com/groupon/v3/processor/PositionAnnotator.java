// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import com.groupon.adapter.widget.WidgetPart;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class PositionAnnotator extends BackgroundDataProcessor
{

    public PositionAnnotator()
    {
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        int i = 0;
        dealsubsetattribute = list.iterator();
        do
        {
            if (!dealsubsetattribute.hasNext())
            {
                break;
            }
            pagination = ((Pagination) (dealsubsetattribute.next()));
            processingcontext = pagination.getClass();
            if (processingcontext == com/groupon/db/models/DealSummary)
            {
                ((DealSummary)pagination).putAttr("ns:DealOffset", Integer.valueOf(i));
                i++;
            } else
            if (processingcontext == com/groupon/adapter/widget/WidgetPart)
            {
                pagination = ((WidgetPart)pagination).getDealSummary();
                if (pagination != null)
                {
                    pagination.putAttr("ns:DealOffset", Integer.valueOf(i));
                    i++;
                }
            }
        } while (true);
        return list;
    }
}
