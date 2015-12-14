// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.image;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.Closeable;
import java.io.InputStream;

public class EncodedImage
    implements Closeable
{

    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    private int mHeight;
    private ImageFormat mImageFormat;
    private final CloseableReference mPooledByteBufferRef;
    private int mRotationAngle;
    private int mSampleSize;
    private int mWidth;

    public EncodedImage(CloseableReference closeablereference)
    {
        mImageFormat = ImageFormat.UNKNOWN;
        mRotationAngle = -1;
        mWidth = -1;
        mHeight = -1;
        mSampleSize = 1;
        Preconditions.checkArgument(CloseableReference.isValid(closeablereference));
        mPooledByteBufferRef = closeablereference.clone();
    }

    public static EncodedImage cloneOrNull(EncodedImage encodedimage)
    {
        if (encodedimage != null)
        {
            return encodedimage.cloneOrNull();
        } else
        {
            return null;
        }
    }

    public static void closeSafely(EncodedImage encodedimage)
    {
        if (encodedimage != null)
        {
            encodedimage.close();
        }
    }

    public static boolean isMetaDataAvailable(EncodedImage encodedimage)
    {
        return encodedimage.mRotationAngle >= 0 && encodedimage.mWidth >= 0 && encodedimage.mHeight >= 0;
    }

    public static boolean isValid(EncodedImage encodedimage)
    {
        return encodedimage != null && encodedimage.isValid();
    }

    public EncodedImage cloneOrNull()
    {
        CloseableReference closeablereference = CloseableReference.cloneOrNull(mPooledByteBufferRef);
        if (closeablereference != null) goto _L2; else goto _L1
_L1:
        EncodedImage encodedimage = null;
_L4:
        CloseableReference.closeSafely(closeablereference);
        if (encodedimage != null)
        {
            encodedimage.copyMetaDataFrom(this);
        }
        return encodedimage;
_L2:
        encodedimage = new EncodedImage(closeablereference);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        CloseableReference.closeSafely(closeablereference);
        throw exception;
    }

    public void close()
    {
        CloseableReference.closeSafely(mPooledByteBufferRef);
    }

    public void copyMetaDataFrom(EncodedImage encodedimage)
    {
        mImageFormat = encodedimage.getImageFormat();
        mWidth = encodedimage.getWidth();
        mHeight = encodedimage.getHeight();
        mRotationAngle = encodedimage.getRotationAngle();
        mSampleSize = encodedimage.getSampleSize();
    }

    public CloseableReference getByteBufferRef()
    {
        return CloseableReference.cloneOrNull(mPooledByteBufferRef);
    }

    public int getHeight()
    {
        return mHeight;
    }

    public ImageFormat getImageFormat()
    {
        return mImageFormat;
    }

    public InputStream getInputStream()
    {
        CloseableReference closeablereference;
        closeablereference = CloseableReference.cloneOrNull(mPooledByteBufferRef);
        if (closeablereference == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        PooledByteBufferInputStream pooledbytebufferinputstream = new PooledByteBufferInputStream((PooledByteBuffer)closeablereference.get());
        CloseableReference.closeSafely(closeablereference);
        return pooledbytebufferinputstream;
        Exception exception;
        exception;
        CloseableReference.closeSafely(closeablereference);
        throw exception;
        return null;
    }

    public int getRotationAngle()
    {
        return mRotationAngle;
    }

    public int getSampleSize()
    {
        return mSampleSize;
    }

    public int getSize()
    {
        if (mPooledByteBufferRef != null && mPooledByteBufferRef.get() != null)
        {
            return ((PooledByteBuffer)mPooledByteBufferRef.get()).size();
        } else
        {
            return -1;
        }
    }

    public SharedReference getUnderlyingReferenceTestOnly()
    {
        this;
        JVM INSTR monitorenter ;
        if (mPooledByteBufferRef == null) goto _L2; else goto _L1
_L1:
        SharedReference sharedreference = mPooledByteBufferRef.getUnderlyingReferenceTestOnly();
_L4:
        this;
        JVM INSTR monitorexit ;
        return sharedreference;
_L2:
        sharedreference = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int getWidth()
    {
        return mWidth;
    }

    public boolean isCompleteAt(int i)
    {
        if (mImageFormat == ImageFormat.JPEG)
        {
            Preconditions.checkNotNull(mPooledByteBufferRef);
            PooledByteBuffer pooledbytebuffer = (PooledByteBuffer)mPooledByteBufferRef.get();
            if (pooledbytebuffer.read(i - 2) != -1 || pooledbytebuffer.read(i - 1) != -39)
            {
                return false;
            }
        }
        return true;
    }

    public boolean isValid()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = CloseableReference.isValid(mPooledByteBufferRef);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void parseMetaData()
    {
label0:
        {
            ImageFormat imageformat = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
            mImageFormat = imageformat;
            if (!ImageFormat.isWebpFormat(imageformat))
            {
                Pair pair = BitmapUtil.decodeDimensions(getInputStream());
                if (pair != null)
                {
                    mWidth = ((Integer)pair.first).intValue();
                    mHeight = ((Integer)pair.second).intValue();
                    if (imageformat != ImageFormat.JPEG)
                    {
                        break label0;
                    }
                    if (mRotationAngle == -1)
                    {
                        mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(JfifUtil.getOrientation(getInputStream()));
                    }
                }
            }
            return;
        }
        mRotationAngle = 0;
    }

    public void setHeight(int i)
    {
        mHeight = i;
    }

    public void setImageFormat(ImageFormat imageformat)
    {
        mImageFormat = imageformat;
    }

    public void setRotationAngle(int i)
    {
        mRotationAngle = i;
    }

    public void setSampleSize(int i)
    {
        mSampleSize = i;
    }

    public void setWidth(int i)
    {
        mWidth = i;
    }
}
