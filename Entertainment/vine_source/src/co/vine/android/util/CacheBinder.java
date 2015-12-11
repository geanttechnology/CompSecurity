// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.os.Binder;
import android.support.v4.util.LruCache;

public class CacheBinder extends Binder
{

    public final LruCache cache;

    public CacheBinder(LruCache lrucache)
    {
        cache = lrucache;
    }
}
