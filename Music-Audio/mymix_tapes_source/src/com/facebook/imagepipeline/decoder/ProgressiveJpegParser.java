// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteArrayBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProgressiveJpegParser
{

    private static final int BUFFER_SIZE = 16384;
    private static final int NOT_A_JPEG = 6;
    private static final int READ_FIRST_JPEG_BYTE = 0;
    private static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
    private static final int READ_MARKER_SECOND_BYTE = 3;
    private static final int READ_SECOND_JPEG_BYTE = 1;
    private static final int READ_SIZE_FIRST_BYTE = 4;
    private static final int READ_SIZE_SECOND_BYTE = 5;
    private int mBestScanEndOffset;
    private int mBestScanNumber;
    private final ByteArrayPool mByteArrayPool;
    private int mBytesParsed;
    private int mLastByteRead;
    private int mNextFullScanNumber;
    private int mParserState;

    public ProgressiveJpegParser(ByteArrayPool bytearraypool)
    {
        mByteArrayPool = (ByteArrayPool)Preconditions.checkNotNull(bytearraypool);
        mBytesParsed = 0;
        mLastByteRead = 0;
        mNextFullScanNumber = 0;
        mBestScanEndOffset = 0;
        mBestScanNumber = 0;
        mParserState = 0;
    }

    private boolean doParseMoreData(InputStream inputstream)
    {
        int i = mBestScanNumber;
_L11:
        if (mParserState == 6) goto _L2; else goto _L1
_L1:
        int j = inputstream.read();
        if (j == -1) goto _L2; else goto _L3
_L3:
        mBytesParsed = mBytesParsed + 1;
        mParserState;
        JVM INSTR tableswitch 0 5: default 286
    //                   0 113
    //                   1 137
    //                   2 161
    //                   3 176
    //                   4 236
    //                   5 244;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L4:
        Preconditions.checkState(false);
_L12:
        mLastByteRead = j;
          goto _L11
        inputstream;
        Throwables.propagate(inputstream);
_L2:
        return mParserState != 6 && mBestScanNumber != i;
_L5:
        if (j != 255)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        mParserState = 1;
          goto _L12
        mParserState = 6;
          goto _L12
_L6:
        if (j != 216)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        mParserState = 2;
          goto _L12
        mParserState = 6;
          goto _L12
_L7:
        if (j != 255) goto _L12; else goto _L13
_L13:
        mParserState = 3;
          goto _L12
_L8:
        if (j != 255)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        mParserState = 3;
          goto _L12
        if (j != 0) goto _L15; else goto _L14
_L14:
        mParserState = 2;
          goto _L12
_L18:
        newScanOrImageEndFound(mBytesParsed - 2);
_L19:
        if (!doesMarkerStartSegment(j)) goto _L17; else goto _L16
_L16:
        mParserState = 4;
          goto _L12
_L17:
        mParserState = 2;
          goto _L12
_L9:
        mParserState = 5;
          goto _L12
_L10:
        int k = ((mLastByteRead << 8) + j) - 2;
        StreamUtil.skip(inputstream, k);
        mBytesParsed = mBytesParsed + k;
        mParserState = 2;
          goto _L12
_L15:
        if (j != 218 && j != 217) goto _L19; else goto _L18
    }

    private static boolean doesMarkerStartSegment(int i)
    {
        boolean flag;
        for (flag = true; i == 1 || i >= 208 && i <= 215;)
        {
            return false;
        }

        if (i == 217 || i == 216)
        {
            flag = false;
        }
        return flag;
    }

    private void newScanOrImageEndFound(int i)
    {
        if (mNextFullScanNumber > 0)
        {
            mBestScanEndOffset = i;
        }
        i = mNextFullScanNumber;
        mNextFullScanNumber = i + 1;
        mBestScanNumber = i;
    }

    public int getBestScanEndOffset()
    {
        return mBestScanEndOffset;
    }

    public int getBestScanNumber()
    {
        return mBestScanNumber;
    }

    public boolean isJpeg()
    {
        return mBytesParsed > 1 && mParserState != 6;
    }

    public boolean parseMoreData(EncodedImage encodedimage)
    {
        if (mParserState == 6)
        {
            return false;
        }
        if (encodedimage.getSize() <= mBytesParsed)
        {
            return false;
        }
        encodedimage = new PooledByteArrayBufferedInputStream(encodedimage.getInputStream(), (byte[])mByteArrayPool.get(16384), mByteArrayPool);
        boolean flag;
        StreamUtil.skip(encodedimage, mBytesParsed);
        flag = doParseMoreData(encodedimage);
        Closeables.closeQuietly(encodedimage);
        return flag;
        Object obj;
        obj;
        Throwables.propagate(((Throwable) (obj)));
        Closeables.closeQuietly(encodedimage);
        return false;
        obj;
        Closeables.closeQuietly(encodedimage);
        throw obj;
    }
}
