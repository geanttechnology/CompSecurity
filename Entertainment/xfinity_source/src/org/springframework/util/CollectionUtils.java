// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.util;

import java.util.Collection;
import java.util.Map;

public abstract class CollectionUtils
{

    public static boolean isEmpty(Collection collection)
    {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map map)
    {
        return map == null || map.isEmpty();
    }
}
