// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.jakewharton.DiskLruCache;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheProvider
    implements Provider
{

    private final int appVersion;
    private final File cacheDir;
    private final int maxSizeOfCache;
    private final int numValuesPerEntry;

    public DiskLruCacheProvider(File file, int i, int j, int k)
    {
        maxSizeOfCache = j;
        cacheDir = file;
        appVersion = k;
        numValuesPerEntry = i;
    }

    public DiskLruCache get()
    {
        DiskLruCache disklrucache;
        try
        {
            disklrucache = DiskLruCache.open(cacheDir, appVersion, numValuesPerEntry, maxSizeOfCache);
        }
        catch (IOException ioexception)
        {
            throw new CimIOException(ioexception);
        }
        return disklrucache;
    }

    public volatile Object get()
    {
        return get();
    }
}
