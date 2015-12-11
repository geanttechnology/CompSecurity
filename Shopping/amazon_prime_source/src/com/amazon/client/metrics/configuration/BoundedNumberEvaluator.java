// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;

import com.amazon.dp.logger.DPLogger;

public class BoundedNumberEvaluator
{

    DPLogger log;
    final String mFieldName;
    final long mMax;
    final long mMin;
    final long mValue;

    public BoundedNumberEvaluator(String s, long l, long l1, long l2)
    {
        log = new DPLogger("BoundedNumberEvaluator");
        mMin = l;
        mMax = l1;
        if (l2 < mMin)
        {
            log.verbose("fieldName", "value", new Object[] {
                Long.valueOf(l2), "less than min value", Long.valueOf(mMin), "field name", "using min value"
            });
            mValue = mMin;
        } else
        if (l2 > mMax)
        {
            log.verbose("fieldName", "value", new Object[] {
                Long.valueOf(l2), "greater than max value", Long.valueOf(mMax), "using max value"
            });
            mValue = mMax;
        } else
        {
            mValue = l2;
        }
        mFieldName = s;
    }

    public long getValue()
    {
        return mValue;
    }
}
