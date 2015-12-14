// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


public class ObjectComparator
{

    public static int compare(Object obj, Object obj1)
    {
        int i = -1;
        if (obj == obj1) goto _L2; else goto _L1
_L1:
        if (obj != null) goto _L4; else goto _L3
_L3:
        return i;
_L4:
        if (obj1 == null)
        {
            return 1;
        }
        if (obj instanceof Comparable)
        {
            int j = ((Comparable)obj).compareTo(obj1);
            i = j;
            if (j != 0)
            {
                continue; /* Loop/switch isn't completed */
            }
        } else
        if (!obj.equals(obj1))
        {
            int k = obj.hashCode();
            int l = obj1.hashCode();
            if (k < l)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k > l)
            {
                return 1;
            }
        }
_L2:
        return 0;
        if (true) goto _L3; else goto _L5
_L5:
    }
}
