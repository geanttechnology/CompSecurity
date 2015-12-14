// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.appsearch.patchupdate;

import com.baidu.appsearch.patchupdate.patch.ByteBufferSeekableSource;
import com.baidu.appsearch.patchupdate.patch.PatchException;
import com.baidu.appsearch.patchupdate.patch.RandomAccessFileSeekableSource;
import com.baidu.appsearch.patchupdate.patch.SeekableSource;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;

public class GDiffPatcher
{

    private static final int BUF_SIZE = 5120;
    public static final int CHUNK_SIZE = 32767;
    public static final int COPY_INT_INT = 254;
    public static final int COPY_INT_UBYTE = 252;
    public static final int COPY_INT_USHORT = 253;
    public static final int COPY_LONG_INT = 255;
    public static final int COPY_UBYTE_INT = 246;
    public static final int COPY_UBYTE_UBYTE = 244;
    public static final int COPY_UBYTE_USHORT = 245;
    public static final int COPY_USHORT_INT = 251;
    public static final int COPY_USHORT_UBYTE = 249;
    public static final int COPY_USHORT_USHORT = 250;
    public static final int DATA_INT = 248;
    public static final int DATA_MAX = 246;
    public static final int DATA_USHORT = 247;
    private static final boolean DEBUG = false;
    public static final int DEFAULT_ZERO_MIN_BLOCK = 10;
    public static final double DEFAULT_ZERO_RATIO = 0.90000000000000002D;
    public static final byte EOF = 0;
    public static final int HALF_MB = 0x4e2000;
    public static final int ONE_MB = 0x100000;
    private static final String TAG = "GDiffPatcher";
    private ByteBuffer buf;
    private byte buf2[];
    private long currentOffset;
    private int dataMax;
    private int datalength;
    private boolean differential;
    private byte mDatas[];
    public long totalLength;

    public GDiffPatcher()
    {
        buf = ByteBuffer.allocate(5120);
        buf2 = buf.array();
        differential = false;
        currentOffset = 0L;
        dataMax = 246;
        totalLength = 0L;
        mDatas = new byte[0x100000];
        datalength = 0;
    }

    public static void unGZip(String s, String s1)
    {
        System.currentTimeMillis();
        if (s != null && !s.equals("") && s1 != null && !s1.equals("")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = new File(s);
        s = new File(s1);
        if (!((File) (obj)).exists()) goto _L1; else goto _L3
_L3:
        byte abyte0[];
        s1 = new FileInputStream(((File) (obj)));
        obj = new BufferedInputStream(new GZIPInputStream(s1));
        abyte0 = new byte[10240];
        s = new BufferedOutputStream(new FileOutputStream(s));
_L4:
        int i = ((BufferedInputStream) (obj)).read(abyte0, 0, abyte0.length);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                s.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
        }
          goto _L4
        s.flush();
        s.close();
        s1.close();
        ((BufferedInputStream) (obj)).close();
        return;
    }

    private void writeToBuffer(byte abyte0[], int i, int j, OutputStream outputstream)
    {
        try
        {
            if (datalength + j >= mDatas.length)
            {
                outputstream.write(mDatas, 0, datalength);
                datalength = 0;
                System.arraycopy(abyte0, 0, mDatas, 0, j);
                datalength = j;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return;
        }
        if (datalength != 0)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        System.arraycopy(abyte0, 0, mDatas, 0, j);
_L1:
        datalength = datalength + j;
        return;
        System.arraycopy(abyte0, 0, mDatas, datalength, j);
          goto _L1
    }

    void append(int i, InputStream inputstream, OutputStream outputstream)
    {
        int j;
        for (; i > 0; i -= j)
        {
            j = Math.min(buf2.length, i);
            j = inputstream.read(buf2, 0, j);
            if (j == -1)
            {
                throw new EOFException((new StringBuilder()).append("cannot read ").append(i).toString());
            }
            writeToBuffer(buf2, 0, j, outputstream);
        }

    }

    void copy(long l, int i, SeekableSource seekablesource, OutputStream outputstream)
    {
        seekablesource.seek(l);
        int j;
        for (; i > 0; i -= j)
        {
            j = Math.min(buf.capacity(), i);
            buf.clear().limit(j);
            j = seekablesource.read(buf);
            if (j == -1)
            {
                throw new EOFException((new StringBuilder()).append("in copy ").append(l).append(" ").append(i).toString());
            }
            writeToBuffer(buf.array(), 0, j, outputstream);
        }

    }

    void flush(OutputStream outputstream)
    {
        if (datalength > 0)
        {
            outputstream.write(mDatas, 0, datalength);
            datalength = 0;
        }
        outputstream.flush();
    }

    public void patch(SeekableSource seekablesource, InputStream inputstream, OutputStream outputstream)
    {
        outputstream = new DataOutputStream(outputstream);
        inputstream = new DataInputStream(new BufferedInputStream(inputstream, 0x4e2000));
        if (inputstream.readUnsignedByte() != 209 || inputstream.readUnsignedByte() != 255 || inputstream.readUnsignedByte() != 209 || inputstream.readUnsignedByte() != 255)
        {
            throw new PatchException("magic string not found, aborting!");
        }
        int i = inputstream.readUnsignedByte();
        if (i == 5)
        {
            differential = true;
            dataMax = 243;
        } else
        if (i != 4)
        {
            throw new PatchException("magic string not found, aborting!");
        }
        totalLength = 0L;
        do
        {
            do
            {
                i = inputstream.readUnsignedByte();
                if (i == 0)
                {
                    flush(outputstream);
                    return;
                }
                if (i > dataMax)
                {
                    break;
                }
                append(i, inputstream, outputstream);
                totalLength = totalLength + (long)i;
            } while (true);
            switch (i)
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("command ").append(i).toString());

            case 247: 
                int j = inputstream.readUnsignedShort();
                append(j, inputstream, outputstream);
                totalLength = totalLength + (long)j;
                break;

            case 248: 
                int k = inputstream.readInt();
                append(k, inputstream, outputstream);
                totalLength = totalLength + (long)k;
                break;

            case 249: 
                int l;
                long l3;
                if (differential)
                {
                    l3 = (long)inputstream.readShort() + currentOffset;
                    currentOffset = l3;
                } else
                {
                    l3 = inputstream.readUnsignedShort();
                }
                l = inputstream.readUnsignedByte();
                copy(l3, l, seekablesource, outputstream);
                totalLength = totalLength + (long)l;
                break;

            case 250: 
                int i1;
                long l4;
                if (differential)
                {
                    l4 = (long)inputstream.readShort() + currentOffset;
                    currentOffset = l4;
                } else
                {
                    l4 = inputstream.readUnsignedShort();
                }
                i1 = inputstream.readUnsignedShort();
                copy(l4, i1, seekablesource, outputstream);
                totalLength = totalLength + (long)i1;
                break;

            case 251: 
                int j1;
                long l5;
                if (differential)
                {
                    l5 = (long)inputstream.readShort() + currentOffset;
                    currentOffset = l5;
                } else
                {
                    l5 = inputstream.readUnsignedShort();
                }
                j1 = inputstream.readInt();
                copy(l5, j1, seekablesource, outputstream);
                totalLength = totalLength + (long)j1;
                break;

            case 244: 
                int k1;
                long l6;
                if (differential)
                {
                    l6 = (long)inputstream.readByte() + currentOffset;
                    currentOffset = l6;
                } else
                {
                    l6 = inputstream.readUnsignedByte();
                }
                k1 = inputstream.readUnsignedByte();
                copy(l6, k1, seekablesource, outputstream);
                totalLength = totalLength + (long)k1;
                break;

            case 245: 
                int l1;
                long l7;
                if (differential)
                {
                    l7 = (long)inputstream.readByte() + currentOffset;
                    currentOffset = l7;
                } else
                {
                    l7 = inputstream.readUnsignedByte();
                }
                l1 = inputstream.readUnsignedShort();
                copy(l7, l1, seekablesource, outputstream);
                totalLength = totalLength + (long)l1;
                break;

            case 246: 
                int i2;
                long l8;
                if (differential)
                {
                    l8 = (long)inputstream.readByte() + currentOffset;
                    currentOffset = l8;
                } else
                {
                    l8 = inputstream.readUnsignedByte();
                }
                i2 = inputstream.readInt();
                copy(l8, i2, seekablesource, outputstream);
                totalLength = totalLength + (long)i2;
                break;

            case 252: 
                long l13 = inputstream.readInt();
                long l9 = l13;
                if (differential)
                {
                    l9 = l13 + currentOffset;
                    currentOffset = l9;
                }
                int j2 = inputstream.readUnsignedByte();
                copy(l9, j2, seekablesource, outputstream);
                totalLength = totalLength + (long)j2;
                break;

            case 253: 
                long l14 = inputstream.readInt();
                long l10 = l14;
                if (differential)
                {
                    l10 = l14 + currentOffset;
                    currentOffset = l10;
                }
                int k2 = inputstream.readUnsignedShort();
                copy(l10, k2, seekablesource, outputstream);
                totalLength = totalLength + (long)k2;
                break;

            case 254: 
                long l15 = inputstream.readInt();
                long l11 = l15;
                if (differential)
                {
                    l11 = l15 + currentOffset;
                    currentOffset = l11;
                }
                int l2 = inputstream.readInt();
                copy(l11, l2, seekablesource, outputstream);
                totalLength = totalLength + (long)l2;
                break;

            case 255: 
                long l16 = inputstream.readLong();
                long l12 = l16;
                if (differential)
                {
                    l12 = l16 + currentOffset;
                    currentOffset = l12;
                }
                int i3 = inputstream.readInt();
                copy(l12, i3, seekablesource, outputstream);
                totalLength = totalLength + (long)i3;
                break;
            }
        } while (true);
    }

    public void patch(File file, File file1, File file2)
    {
        FileOutputStream fileoutputstream;
        file = new RandomAccessFileSeekableSource(new RandomAccessFile(file, "r"));
        file1 = new FileInputStream(file1);
        fileoutputstream = new FileOutputStream(file2);
        patch(((SeekableSource) (file)), ((InputStream) (file1)), ((OutputStream) (fileoutputstream)));
        file.close();
        file1.close();
        fileoutputstream.close();
        file2.length();
        return;
        Object obj;
        obj;
        throw obj;
        obj;
        file.close();
        file1.close();
        fileoutputstream.close();
        file2.length();
        throw obj;
    }

    public void patch(byte abyte0[], InputStream inputstream, OutputStream outputstream)
    {
        patch(((SeekableSource) (new ByteBufferSeekableSource(abyte0))), inputstream, outputstream);
    }

    public byte[] patch(byte abyte0[], byte abyte1[])
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        patch(abyte0, ((InputStream) (new ByteArrayInputStream(abyte1))), ((OutputStream) (bytearrayoutputstream)));
        return bytearrayoutputstream.toByteArray();
    }
}
