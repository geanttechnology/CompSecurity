// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.io.Serializable;

// Referenced classes of package com.google.common.collect:
//            Ordering, Range, ComparisonChain

private static class <init> extends Ordering
    implements Serializable
{

    private static final long serialVersionUID = 0L;

    public int compare(Range range, Range range1)
    {
        return ComparisonChain.start().compare(range.lowerBound, range1.lowerBound).compare(range.upperBound, range1.upperBound).result();
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Range)obj, (Range)obj1);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
