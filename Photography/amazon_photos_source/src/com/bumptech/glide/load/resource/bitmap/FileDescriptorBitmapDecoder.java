// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            VideoBitmapDecoder, BitmapResource

public class FileDescriptorBitmapDecoder
    implements ResourceDecoder
{

    private final VideoBitmapDecoder bitmapDecoder;
    private final BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;

    public FileDescriptorBitmapDecoder(BitmapPool bitmappool, DecodeFormat decodeformat)
    {
        this(new VideoBitmapDecoder(), bitmappool, decodeformat);
    }

    public FileDescriptorBitmapDecoder(VideoBitmapDecoder videobitmapdecoder, BitmapPool bitmappool, DecodeFormat decodeformat)
    {
        bitmapDecoder = videobitmapdecoder;
        bitmapPool = bitmappool;
        decodeFormat = decodeformat;
    }

    public Resource decode(ParcelFileDescriptor parcelfiledescriptor, int i, int j)
        throws IOException
    {
        return BitmapResource.obtain(bitmapDecoder.decode(parcelfiledescriptor, bitmapPool, i, j, decodeFormat), bitmapPool);
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((ParcelFileDescriptor)obj, i, j);
    }

    public String getId()
    {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
