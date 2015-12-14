// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.data.ByteArrayFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

// Referenced classes of package com.bumptech.glide.load.model.stream:
//            StreamModelLoader

public class StreamByteArrayLoader
    implements StreamModelLoader
{
    public static class Factory
        implements ModelLoaderFactory
    {

        public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
        {
            return new StreamByteArrayLoader();
        }

        public void teardown()
        {
        }

        public Factory()
        {
        }
    }


    private final String id;

    public StreamByteArrayLoader()
    {
        this("");
    }

    public StreamByteArrayLoader(String s)
    {
        id = s;
    }

    public volatile DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        return getResourceFetcher((byte[])obj, i, j);
    }

    public DataFetcher getResourceFetcher(byte abyte0[], int i, int j)
    {
        return new ByteArrayFetcher(abyte0, id);
    }
}
