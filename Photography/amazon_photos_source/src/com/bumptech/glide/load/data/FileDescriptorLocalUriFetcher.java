// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.load.data:
//            LocalUriFetcher

public class FileDescriptorLocalUriFetcher extends LocalUriFetcher
{

    public FileDescriptorLocalUriFetcher(Context context, Uri uri)
    {
        super(context, uri);
    }

    protected void close(ParcelFileDescriptor parcelfiledescriptor)
        throws IOException
    {
        parcelfiledescriptor.close();
    }

    protected volatile void close(Object obj)
        throws IOException
    {
        close((ParcelFileDescriptor)obj);
    }

    protected ParcelFileDescriptor loadResource(Uri uri, ContentResolver contentresolver)
        throws FileNotFoundException
    {
        return contentresolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }

    protected volatile Object loadResource(Uri uri, ContentResolver contentresolver)
        throws FileNotFoundException
    {
        return loadResource(uri, contentresolver);
    }
}
