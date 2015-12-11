// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.util.LruCache;

// Referenced classes of package android.support.v7:
//            abj

class it> extends LruCache
{

    final a a;
    final abj b;

    protected int sizeOf(Object obj, Object obj1)
    {
        return a.a(obj, obj1);
    }

    (abj abj1, int i,  )
    {
        b = abj1;
        a = ;
        super(i);
    }
}
