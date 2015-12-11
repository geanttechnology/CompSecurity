// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Comparator;

// Referenced classes of package com.google.common.collect:
//            ComparatorOrdering, NaturalOrdering, Maps, ByFunctionOrdering, 
//            ReverseOrdering

public abstract class Ordering
    implements Comparator
{

    protected Ordering()
    {
    }

    public static Ordering from(Comparator comparator)
    {
        if (comparator instanceof Ordering)
        {
            return (Ordering)comparator;
        } else
        {
            return new ComparatorOrdering(comparator);
        }
    }

    public static Ordering natural()
    {
        return NaturalOrdering.INSTANCE;
    }

    public abstract int compare(Object obj, Object obj1);

    Ordering onKeys()
    {
        return onResultOf(Maps.keyFunction());
    }

    public Ordering onResultOf(Function function)
    {
        return new ByFunctionOrdering(function, this);
    }

    public Ordering reverse()
    {
        return new ReverseOrdering(this);
    }
}
