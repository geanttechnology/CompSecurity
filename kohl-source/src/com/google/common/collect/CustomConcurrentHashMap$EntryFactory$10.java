// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            CustomConcurrentHashMap

static final class it> extends it>
{

    it> copyEntry(CustomConcurrentHashMap customconcurrenthashmap, it> it>, it> it>1)
    {
        customconcurrenthashmap = super.yEntry(customconcurrenthashmap, it>, it>1);
        copyExpirableEntry(it>, customconcurrenthashmap);
        return customconcurrenthashmap;
    }

    copyExpirableEntry newEntry(CustomConcurrentHashMap customconcurrenthashmap, Object obj, int i, copyExpirableEntry copyexpirableentry)
    {
        return new ry(customconcurrenthashmap, obj, i, copyexpirableentry);
    }

    ry(String s, int i)
    {
        super(s, i, null);
    }
}
