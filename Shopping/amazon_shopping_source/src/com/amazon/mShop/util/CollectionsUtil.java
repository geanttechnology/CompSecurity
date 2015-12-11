// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionsUtil
{

    public CollectionsUtil()
    {
    }

    public static Collection sum(Collection collection, Collection collection1)
    {
        collection = new ArrayList(collection);
        collection.addAll(collection1);
        return collection;
    }
}
