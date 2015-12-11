// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

// Referenced classes of package com.google.common.collect:
//            Collections2

public final class Maps
{

    static final com.google.common.base.Joiner.MapJoiner STANDARD_JOINER;

    static int capacity(int i)
    {
        if (i < 3)
        {
            boolean flag;
            if (i >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            return i + 1;
        }
        if (i < 0x40000000)
        {
            return i / 3 + i;
        } else
        {
            return 0x7fffffff;
        }
    }

    public static HashMap newHashMap()
    {
        return new HashMap();
    }

    public static TreeMap newTreeMap()
    {
        return new TreeMap();
    }

    public static TreeMap newTreeMap(Comparator comparator)
    {
        return new TreeMap(comparator);
    }

    static 
    {
        STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
    }
}
