// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import java.util.Comparator;

// Referenced classes of package com.amazon.ansel.fetch:
//            LoaderContext, Prioritized

static final class 
    implements Comparator
{

    public int compare(Object obj, Object obj1)
    {
        long l;
        long l1;
        if (obj instanceof Prioritized)
        {
            l = ((Prioritized)obj).getPriority();
        } else
        {
            l = 0L;
        }
        if (obj1 instanceof Prioritized)
        {
            l1 = ((Prioritized)obj1).getPriority();
        } else
        {
            l1 = 0L;
        }
        if (l < l1)
        {
            return 1;
        }
        return l != l1 ? -1 : 0;
    }

    ()
    {
    }
}
