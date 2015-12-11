// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import android.content.res.Resources;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import com.groupon.v3.trigger.NextPageTrigger;
import java.util.List;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class PaginationInserter extends BackgroundDataProcessor
{

    protected static final int START_LOADING_WHEN_WITHIN_N_OF_END = 3;
    protected boolean requiresPagination;
    protected boolean syncErrorCancellation;

    public PaginationInserter()
    {
        this(true);
    }

    public PaginationInserter(boolean flag)
    {
        syncErrorCancellation = false;
        requiresPagination = flag;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        boolean flag;
        flag = true;
        dealsubsetattribute = (Context)processingcontext.getAttr("context");
        if (!requiresPagination) goto _L2; else goto _L1
_L1:
        if (list.size() != 0) goto _L4; else goto _L3
_L3:
        return list;
_L4:
        int j = 0;
        int i = j;
        if (pagination != null)
        {
            i = j;
            if (pagination.hasMorePages())
            {
                i = pagination.getCount();
            }
        }
        j = list.size();
        boolean flag1 = dealsubsetattribute.getResources().getBoolean(0x7f090007);
        if (j > 1 && j < i)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if ((pagination == null || i != 0) && !syncErrorCancellation)
        {
            if (pagination == null)
            {
                pagination = new Pagination();
            }
            list.add(pagination);
            i = Math.max(0, list.size() - 3);
            if (flag1)
            {
                list.add(i, new NextPageTrigger());
                return list;
            } else
            {
                list.add(new NextPageTrigger());
                return list;
            }
        } else
        {
            syncErrorCancellation = false;
            return list;
        }
_L2:
        if (list.size() == 0 && !syncErrorCancellation)
        {
            list.add(new Pagination());
            return list;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void setSyncErrorCancellation(boolean flag)
    {
        syncErrorCancellation = flag;
    }
}
