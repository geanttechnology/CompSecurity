// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.support.v4.util.LruCache;

// Referenced classes of package co.vine.android.util:
//            UrlResourceCache, UrlResource

private static class  extends LruCache
{

    protected int sizeOf(Object obj, UrlResource urlresource)
    {
        return urlresource.size();
    }

    protected volatile int sizeOf(Object obj, Object obj1)
    {
        return sizeOf(obj, (UrlResource)obj1);
    }

    public (int i)
    {
        super(i);
    }
}
