// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            BitmapDecoder

public class VideoBitmapDecoder
    implements BitmapDecoder
{
    static class MediaMetadataRetrieverFactory
    {

        public MediaMetadataRetriever build()
        {
            return new MediaMetadataRetriever();
        }

        MediaMetadataRetrieverFactory()
        {
        }
    }


    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    private MediaMetadataRetrieverFactory factory;
    private int frame;

    public VideoBitmapDecoder()
    {
        this(DEFAULT_FACTORY, -1);
    }

    VideoBitmapDecoder(MediaMetadataRetrieverFactory mediametadataretrieverfactory, int i)
    {
        factory = mediametadataretrieverfactory;
        frame = i;
    }

    public Bitmap decode(ParcelFileDescriptor parcelfiledescriptor, BitmapPool bitmappool, int i, int j, DecodeFormat decodeformat)
        throws IOException
    {
        decodeformat = factory.build();
        decodeformat.setDataSource(parcelfiledescriptor.getFileDescriptor());
        if (frame >= 0)
        {
            bitmappool = decodeformat.getFrameAtTime(frame);
        } else
        {
            bitmappool = decodeformat.getFrameAtTime();
        }
        decodeformat.release();
        parcelfiledescriptor.close();
        return bitmappool;
    }

    public String getId()
    {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

}
