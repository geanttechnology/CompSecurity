// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.data:
//            LocalUriFetcher

public class StreamLocalUriFetcher extends LocalUriFetcher
{

    public StreamLocalUriFetcher(Context context, Uri uri)
    {
        super(context, uri);
    }

    protected void close(InputStream inputstream)
        throws IOException
    {
        inputstream.close();
    }

    protected volatile void close(Object obj)
        throws IOException
    {
        close((InputStream)obj);
    }

    protected InputStream loadResource(Uri uri, ContentResolver contentresolver)
        throws FileNotFoundException
    {
        return contentresolver.openInputStream(uri);
    }

    protected volatile Object loadResource(Uri uri, ContentResolver contentresolver)
        throws FileNotFoundException
    {
        return loadResource(uri, contentresolver);
    }
}
