// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.file;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LenticularArchive
    implements Closeable
{

    private static final String TAG = com/amazon/boombox/file/LenticularArchive.getSimpleName();
    private FileInputStream mFileInputStream;
    private List mFrameSizes;
    private MappedByteBuffer mInBuffer;
    private FileChannel mInChannel;
    private File mLenticularFile;

    public LenticularArchive(File file)
        throws IOException
    {
        mLenticularFile = file;
        if (!isLenticular(mLenticularFile.getName()))
        {
            throw new UnsupportedOperationException("Uri does not point to a Lenticular image.");
        } else
        {
            mFileInputStream = new FileInputStream(mLenticularFile);
            mInChannel = mFileInputStream.getChannel();
            mInBuffer = mInChannel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, mInChannel.size());
            mFrameSizes = getFrameSizes(mInBuffer);
            return;
        }
    }

    private static int findFrameSizesPosition(int i, int j)
    {
        return i - (j * 4 + 1);
    }

    private static int findNumberOfFramesPosition(int i)
    {
        return i - 1;
    }

    private static List getFrameSizes(MappedByteBuffer mappedbytebuffer)
    {
        ArrayList arraylist = new ArrayList();
        int i = mappedbytebuffer.limit();
        mappedbytebuffer.position(findNumberOfFramesPosition(i));
        byte byte0 = mappedbytebuffer.get();
        mappedbytebuffer.position(findFrameSizesPosition(i, byte0));
        for (int j = 0; j < byte0; j++)
        {
            arraylist.add(Integer.valueOf(mappedbytebuffer.getInt()));
        }

        mappedbytebuffer.position(0);
        return arraylist;
    }

    public static boolean isLenticular(String s)
    {
        return Pattern.compile(".*\\.len\\.jpe?g", 2).matcher(s).matches();
    }

    public void close()
        throws IOException
    {
        if (mFileInputStream != null)
        {
            mFileInputStream.close();
        }
    }

    public byte[] getFrameBytes(int i)
        throws IOException, IndexOutOfBoundsException
    {
        if (i >= getFrameCount())
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Tried to access position ").append(i).append(" out of ").append(getFrameCount()).toString());
        }
        int k = 0;
        for (int j = 0; j < i; j++)
        {
            k += ((Integer)mFrameSizes.get(j)).intValue();
        }

        mInBuffer.position(k);
        ByteBuffer bytebuffer = mInBuffer.slice();
        bytebuffer.limit(((Integer)mFrameSizes.get(i)).intValue());
        byte abyte0[] = new byte[bytebuffer.remaining()];
        bytebuffer.duplicate().get(abyte0);
        return abyte0;
    }

    public int getFrameCount()
    {
        return mFrameSizes.size();
    }

}
