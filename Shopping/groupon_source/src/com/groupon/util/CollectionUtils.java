// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils
{

    public CollectionUtils()
    {
    }

    public static Object getFirstItem(Collection collection, Object obj)
    {
        if (collection == null || collection.size() == 0)
        {
            return obj;
        } else
        {
            return collection.iterator().next();
        }
    }
}
