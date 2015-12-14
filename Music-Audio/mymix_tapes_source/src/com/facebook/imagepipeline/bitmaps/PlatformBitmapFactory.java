// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.bitmaps;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.List;

// Referenced classes of package com.facebook.imagepipeline.bitmaps:
//            DalvikBitmapFactory, ArtBitmapFactory, GingerbreadBitmapFactory

public class PlatformBitmapFactory
{

    private final ArtBitmapFactory mArtBitmapFactory;
    private final DalvikBitmapFactory mDalvikBitmapFactory;
    private final GingerbreadBitmapFactory mGingerbreadBitmapFactory;

    public PlatformBitmapFactory(GingerbreadBitmapFactory gingerbreadbitmapfactory, DalvikBitmapFactory dalvikbitmapfactory, ArtBitmapFactory artbitmapfactory)
    {
        mGingerbreadBitmapFactory = gingerbreadbitmapfactory;
        mDalvikBitmapFactory = dalvikbitmapfactory;
        mArtBitmapFactory = artbitmapfactory;
    }

    public List associateBitmapsWithBitmapCounter(List list)
    {
        this;
        JVM INSTR monitorenter ;
        list = mDalvikBitmapFactory.associateBitmapsWithBitmapCounter(list);
        this;
        JVM INSTR monitorexit ;
        return list;
        list;
        throw list;
    }

    public CloseableReference createBitmap(int i, int j)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return mArtBitmapFactory.createBitmap(i, j);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return mDalvikBitmapFactory.createBitmap((short)i, (short)j);
        } else
        {
            return mGingerbreadBitmapFactory.createBitmap(i, j);
        }
    }

    public CloseableReference decodeFromEncodedImage(EncodedImage encodedimage)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return mArtBitmapFactory.decodeFromEncodedImage(encodedimage);
        } else
        {
            return mDalvikBitmapFactory.decodeFromEncodedImage(encodedimage);
        }
    }

    public CloseableReference decodeJPEGFromEncodedImage(EncodedImage encodedimage, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return mArtBitmapFactory.decodeJPEGFromEncodedImage(encodedimage, i);
        } else
        {
            return mDalvikBitmapFactory.decodeJPEGFromEncodedImage(encodedimage, i);
        }
    }
}
