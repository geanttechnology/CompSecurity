// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.load.data:
//            AssetPathFetcher

public class FileDescriptorAssetPathFetcher extends AssetPathFetcher
{

    public FileDescriptorAssetPathFetcher(AssetManager assetmanager, String s)
    {
        super(assetmanager, s);
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

    protected ParcelFileDescriptor loadResource(AssetManager assetmanager, String s)
        throws IOException
    {
        return assetmanager.openFd(s).getParcelFileDescriptor();
    }

    protected volatile Object loadResource(AssetManager assetmanager, String s)
        throws IOException
    {
        return loadResource(assetmanager, s);
    }
}
