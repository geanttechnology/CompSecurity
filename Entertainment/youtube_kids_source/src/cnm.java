// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.LruCache;

final class cnm extends LruCache
{

    cnm(cnl cnl, int i)
    {
        super(i);
    }

    protected final int sizeOf(Object obj, Object obj1)
    {
        return ((ls)obj1).a.length;
    }
}
