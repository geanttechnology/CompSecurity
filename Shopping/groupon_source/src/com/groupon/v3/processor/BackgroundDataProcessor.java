// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import java.util.List;

public class BackgroundDataProcessor
{

    protected boolean mustBeFirst;

    public BackgroundDataProcessor()
    {
        this(false);
    }

    public BackgroundDataProcessor(boolean flag)
    {
        mustBeFirst = flag;
    }

    public List doProcess(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        if (mustBeFirst && list != null)
        {
            throw new RuntimeException(String.format("%s should be first processor in chain", new Object[] {
                getClass().getSimpleName()
            }));
        } else
        {
            return process(list, dealsubsetattribute, pagination, processingcontext);
        }
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        return null;
    }
}
