// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;

// Referenced classes of package com.fasterxml.jackson.databind.util:
//            Comparators

static final class val.length
{

    final Object val$defaultValue;
    final int val$length;

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null || obj.getClass() != val$defaultValue.getClass())
            {
                return false;
            }
            if (Array.getLength(obj) != val$length)
            {
                return false;
            }
            int i = 0;
            while (i < val$length) 
            {
                Object obj1 = Array.get(val$defaultValue, i);
                Object obj2 = Array.get(obj, i);
                if (obj1 == obj2 || obj1 == null || obj1.equals(obj2))
                {
                    i++;
                } else
                {
                    return false;
                }
            }
        }
        return true;
    }

    (Object obj, int i)
    {
        val$defaultValue = obj;
        val$length = i;
        super();
    }
}
