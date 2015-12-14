// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ArtBitmapFactory
{

    private static final int DECODE_BUFFER_SIZE = 16384;
    private static final byte EOI_TAIL[] = {
        -1, -39
    };
    private final BitmapPool mBitmapPool;
    final android.support.v4.util.Pools.SynchronizedPool mDecodeBuffers;

    public ArtBitmapFactory(BitmapPool bitmappool, int i)
    {
        mBitmapPool = bitmappool;
        mDecodeBuffers = new android.support.v4.util.Pools.SynchronizedPool(i);
        for (int j = 0; j < i; j++)
        {
            mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }

    }

    private CloseableReference decodeStaticImageFromStream(InputStream inputstream, android.graphics.BitmapFactory.Options options)
    {
        ByteBuffer bytebuffer;
        Bitmap bitmap;
        Preconditions.checkNotNull(inputstream);
        bitmap = (Bitmap)mBitmapPool.get(options.outHeight * options.outWidth);
        if (bitmap == null)
        {
            throw new NullPointerException("BitmapPool.get returned null");
        }
        options.inBitmap = bitmap;
        ByteBuffer bytebuffer1 = (ByteBuffer)mDecodeBuffers.acquire();
        bytebuffer = bytebuffer1;
        if (bytebuffer1 == null)
        {
            bytebuffer = ByteBuffer.allocate(16384);
        }
        options.inTempStorage = bytebuffer.array();
        inputstream = BitmapFactory.decodeStream(inputstream, null, options);
        mDecodeBuffers.release(bytebuffer);
        if (bitmap != inputstream)
        {
            mBitmapPool.release(bitmap);
            inputstream.recycle();
            throw new IllegalStateException();
        } else
        {
            return CloseableReference.of(inputstream, mBitmapPool);
        }
        inputstream;
        mBitmapPool.release(bitmap);
        throw inputstream;
        inputstream;
        mDecodeBuffers.release(bytebuffer);
        throw inputstream;
    }

    private android.graphics.BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedimage)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = encodedimage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedimage.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1)
        {
            throw new IllegalArgumentException();
        } else
        {
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPreferredConfig = Bitmaps.BITMAP_CONFIG;
            options.inMutable = true;
            return options;
        }
    }

    CloseableReference createBitmap(int i, int j)
    {
        Bitmap bitmap = (Bitmap)mBitmapPool.get(i * j);
        Bitmaps.reconfigureBitmap(bitmap, i, j);
        return CloseableReference.of(bitmap, mBitmapPool);
    }

    CloseableReference decodeFromEncodedImage(EncodedImage encodedimage)
    {
        android.graphics.BitmapFactory.Options options = getDecodeOptionsForStream(encodedimage);
        return decodeStaticImageFromStream(encodedimage.getInputStream(), options);
    }

    CloseableReference decodeJPEGFromEncodedImage(EncodedImage encodedimage, int i)
    {
        boolean flag = encodedimage.isCompleteAt(i);
        android.graphics.BitmapFactory.Options options = getDecodeOptionsForStream(encodedimage);
        InputStream inputstream = encodedimage.getInputStream();
        Preconditions.checkNotNull(inputstream);
        if (encodedimage.getSize() > i)
        {
            encodedimage = new LimitedInputStream(inputstream, i);
        } else
        {
            encodedimage = inputstream;
        }
        if (!flag)
        {
            encodedimage = new TailAppendingInputStream(encodedimage, EOI_TAIL);
        }
        return decodeStaticImageFromStream(encodedimage, options);
    }

}
