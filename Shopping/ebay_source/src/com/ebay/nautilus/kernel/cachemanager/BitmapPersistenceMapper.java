// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BitmapPersistenceMapper
    implements CacheManager.PersitenceMapper
{

    private static final BitmapPersistenceMapper instance = new BitmapPersistenceMapper();

    private BitmapPersistenceMapper()
    {
    }

    public static BitmapPersistenceMapper get()
    {
        return instance;
    }

    public void deflateCached(OutputStream outputstream, Object obj)
        throws IOException
    {
        throw new IllegalStateException("For bitmap persisentence you must call putFlattenedBytes() instead of put().");
    }

    public Object inflateCached(InputStream inputstream, Class class1)
        throws IOException
    {
        return BitmapFactory.decodeStream(inputstream);
    }

}
