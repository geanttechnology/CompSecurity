// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            JsonPersistenceMapper

public class GzipJsonPersistenceMapper extends JsonPersistenceMapper
    implements CacheManager.PersitenceMapper
{

    protected GzipJsonPersistenceMapper(Gson gson)
    {
        super(gson);
    }

    public static GzipJsonPersistenceMapper create(Gson gson)
    {
        return new GzipJsonPersistenceMapper(gson);
    }

    public void deflateCached(OutputStream outputstream, Object obj)
        throws IOException
    {
        super.deflateCached(new GZIPOutputStream(outputstream), obj);
    }

    public Object inflateCached(InputStream inputstream, Class class1)
        throws IOException
    {
        return super.inflateCached(new GZIPInputStream(inputstream), class1);
    }
}
