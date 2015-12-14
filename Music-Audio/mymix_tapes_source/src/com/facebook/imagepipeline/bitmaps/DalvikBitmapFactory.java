// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.imagepipeline.bitmaps:
//            TooManyBitmapsException, EmptyJpegGenerator

public class DalvikBitmapFactory
{

    private final FlexByteArrayPool mFlexByteArrayPool;
    private final EmptyJpegGenerator mJpegGenerator;
    private final BitmapCounter mUnpooledBitmapsCounter = BitmapCounterProvider.get();
    private final ResourceReleaser mUnpooledBitmapsReleaser = new ResourceReleaser() {

        final DalvikBitmapFactory this$0;

        public void release(Bitmap bitmap)
        {
            mUnpooledBitmapsCounter.decrease(bitmap);
            bitmap.recycle();
            return;
            Exception exception;
            exception;
            bitmap.recycle();
            throw exception;
        }

        public volatile void release(Object obj)
        {
            release((Bitmap)obj);
        }

            
            {
                this$0 = DalvikBitmapFactory.this;
                super();
            }
    };

    public DalvikBitmapFactory(EmptyJpegGenerator emptyjpeggenerator, FlexByteArrayPool flexbytearraypool)
    {
        mJpegGenerator = emptyjpeggenerator;
        mFlexByteArrayPool = flexbytearraypool;
    }

    private Bitmap decodeByteArrayAsPurgeable(CloseableReference closeablereference, android.graphics.BitmapFactory.Options options)
    {
        PooledByteBuffer pooledbytebuffer;
        int i;
        pooledbytebuffer = (PooledByteBuffer)closeablereference.get();
        i = pooledbytebuffer.size();
        closeablereference = mFlexByteArrayPool.get(i);
        byte abyte0[] = (byte[])closeablereference.get();
        pooledbytebuffer.read(0, abyte0, 0, i);
        options = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeByteArray(abyte0, 0, i, options), "BitmapFactory returned null");
        CloseableReference.closeSafely(closeablereference);
        return options;
        options;
        CloseableReference.closeSafely(closeablereference);
        throw options;
    }

    private Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference closeablereference, int i, android.graphics.BitmapFactory.Options options)
    {
        PooledByteBuffer pooledbytebuffer;
        boolean flag = false;
        pooledbytebuffer = (PooledByteBuffer)closeablereference.get();
        if (i <= pooledbytebuffer.size())
        {
            flag = true;
        }
        Preconditions.checkArgument(flag);
        closeablereference = mFlexByteArrayPool.get(i + 2);
        byte abyte0[];
        abyte0 = (byte[])closeablereference.get();
        pooledbytebuffer.read(0, abyte0, 0, i);
        int j = i;
        if (endsWithEOI(abyte0, i))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        putEOI(abyte0, i);
        j = i + 2;
        options = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeByteArray(abyte0, 0, j, options), "BitmapFactory returned null");
        CloseableReference.closeSafely(closeablereference);
        return options;
        options;
        CloseableReference.closeSafely(closeablereference);
        throw options;
    }

    private static boolean endsWithEOI(byte abyte0[], int i)
    {
        return i >= 2 && abyte0[i - 2] == -1 && abyte0[i - 1] == -39;
    }

    private static android.graphics.BitmapFactory.Options getBitmapFactoryOptions(int i)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = Bitmaps.BITMAP_CONFIG;
        options.inPurgeable = true;
        options.inSampleSize = i;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            options.inMutable = true;
        }
        return options;
    }

    private CloseableReference pinBitmap(Bitmap bitmap)
    {
        try
        {
            Bitmaps.pinBitmap(bitmap);
        }
        catch (Exception exception)
        {
            bitmap.recycle();
            throw Throwables.propagate(exception);
        }
        if (!mUnpooledBitmapsCounter.increase(bitmap))
        {
            bitmap.recycle();
            throw new TooManyBitmapsException();
        } else
        {
            return CloseableReference.of(bitmap, mUnpooledBitmapsReleaser);
        }
    }

    private static void putEOI(byte abyte0[], int i)
    {
        abyte0[i] = -1;
        abyte0[i + 1] = -39;
    }

    List associateBitmapsWithBitmapCounter(List list)
    {
        int i = 0;
_L2:
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Bitmap bitmap = (Bitmap)list.get(i);
        Bitmaps.pinBitmap(bitmap);
        if (!mUnpooledBitmapsCounter.increase(bitmap))
        {
            throw new TooManyBitmapsException();
        }
        break MISSING_BLOCK_LABEL_106;
        Object obj;
        obj;
        if (list != null)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                Bitmap bitmap1 = (Bitmap)list.next();
                if (i > 0)
                {
                    mUnpooledBitmapsCounter.decrease(bitmap1);
                }
                bitmap1.recycle();
                i--;
            }

        }
        break MISSING_BLOCK_LABEL_165;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj = new ArrayList();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).add(CloseableReference.of((Bitmap)iterator.next(), mUnpooledBitmapsReleaser))) { }
        break MISSING_BLOCK_LABEL_170;
        throw Throwables.propagate(((Throwable) (obj)));
        return ((List) (obj));
    }

    CloseableReference createBitmap(short word0, short word1)
    {
        CloseableReference closeablereference = mJpegGenerator.generate(word0, word1);
        EncodedImage encodedimage;
        encodedimage = new EncodedImage(closeablereference);
        encodedimage.setImageFormat(ImageFormat.JPEG);
        CloseableReference closeablereference1;
        closeablereference1 = decodeJPEGFromEncodedImage(encodedimage, ((PooledByteBuffer)closeablereference.get()).size());
        ((Bitmap)closeablereference1.get()).eraseColor(0);
        EncodedImage.closeSafely(encodedimage);
        closeablereference.close();
        return closeablereference1;
        Exception exception1;
        exception1;
        EncodedImage.closeSafely(encodedimage);
        throw exception1;
        Exception exception;
        exception;
        closeablereference.close();
        throw exception;
    }

    CloseableReference decodeFromEncodedImage(EncodedImage encodedimage)
    {
        Object obj;
        obj = getBitmapFactoryOptions(encodedimage.getSampleSize());
        encodedimage = encodedimage.getByteBufferRef();
        Preconditions.checkNotNull(encodedimage);
        obj = pinBitmap(decodeByteArrayAsPurgeable(encodedimage, ((android.graphics.BitmapFactory.Options) (obj))));
        CloseableReference.closeSafely(encodedimage);
        return ((CloseableReference) (obj));
        Exception exception;
        exception;
        CloseableReference.closeSafely(encodedimage);
        throw exception;
    }

    CloseableReference decodeJPEGFromEncodedImage(EncodedImage encodedimage, int i)
    {
        Object obj;
        obj = getBitmapFactoryOptions(encodedimage.getSampleSize());
        encodedimage = encodedimage.getByteBufferRef();
        Preconditions.checkNotNull(encodedimage);
        obj = pinBitmap(decodeJPEGByteArrayAsPurgeable(encodedimage, i, ((android.graphics.BitmapFactory.Options) (obj))));
        CloseableReference.closeSafely(encodedimage);
        return ((CloseableReference) (obj));
        Exception exception;
        exception;
        CloseableReference.closeSafely(encodedimage);
        throw exception;
    }

}
