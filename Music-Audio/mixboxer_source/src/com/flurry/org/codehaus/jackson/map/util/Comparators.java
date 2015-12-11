// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.util;

import java.lang.reflect.Array;

public class Comparators
{

    public Comparators()
    {
    }

    public static Object getArrayComparator(Object obj)
    {
        return new Object(obj, Array.getLength(obj)) {

            final Object val$defaultValue;
            final int val$length;

            public boolean equals(Object obj1)
            {
                if (obj1 != this)
                {
                    if (obj1 == null || obj1.getClass() != defaultValue.getClass())
                    {
                        return false;
                    }
                    if (Array.getLength(obj1) != length)
                    {
                        return false;
                    }
                    int i = 0;
                    while (i < length) 
                    {
                        Object obj2 = Array.get(defaultValue, i);
                        Object obj3 = Array.get(obj1, i);
                        if (obj2 == obj3 || obj2 == null || obj2.equals(obj3))
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

            
            {
                defaultValue = obj;
                length = i;
                super();
            }
        };
    }
}
