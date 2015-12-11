// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import android.util.SparseArray;
import java.io.IOException;
import java.nio.charset.Charset;

// Referenced classes of package com.amazon.client.framework.androidresparser:
//            WordReader, ResChunk_header

public class ResStringPool
{
    public static class Span
    {

        public static final int END = -1;
        int firstChar;
        int index;
        int lastChar;

        public Span()
        {
        }
    }


    public static final int SORTED_FLAG = 1;
    public static final int UTF8_FLAG = 256;
    private final int mFlags;
    private final SparseArray mStringCache = new SparseArray();
    private final byte mStringData[];
    private final int mStringOffsets[];
    private final int mStyleData[];
    private final int mStyleOffsets[];

    private ResStringPool(int ai[], byte abyte0[], int ai1[], int ai2[], int i)
    {
        mStringOffsets = ai;
        mStringData = abyte0;
        mStyleOffsets = ai1;
        mStyleData = ai2;
        mFlags = i;
    }

    private static String newString(byte abyte0[], int i, boolean flag)
    {
        if (flag)
        {
            int j1 = abyte0[i] & 0xff;
            int l = j1;
            int j = i;
            if ((j1 & 0x80) != 0)
            {
                j = i + 1;
                l = (j1 & 0x7f) << 8 | abyte0[j] & 0xff;
            }
            byte abyte1[] = new byte[l];
            System.arraycopy(abyte0, j + 1, abyte1, 0, l);
            return new String(abyte1, Charset.forName("UTF-8"));
        }
        int i1 = WordReader.readBytesFrom(abyte0, i, 2);
        int k1 = i + 2;
        int k = i1;
        i = k1;
        if ((0x8000 & i1) != 0)
        {
            k = (i1 & 0x7fff) << 16 | WordReader.readBytesFrom(abyte0, k1, 2);
            i = k1 + 2;
        }
        char ac[] = new char[k];
        k1 = 0;
        i1 = i;
        for (i = k1; i < k; i++)
        {
            ac[i] = (char)(WordReader.readBytesFrom(abyte0, i1, 2) & 0xffff);
            i1 += 2;
        }

        return new String(ac);
    }

    public static ResStringPool readStringPool(ResChunk_header reschunk_header, WordReader wordreader)
        throws IOException
    {
        if (reschunk_header.type != 1)
        {
            throw new IllegalArgumentException("Expected a RES_STRING_POOL_TYPE header.");
        }
        int i = wordreader.readDWord();
        int j1 = wordreader.readDWord();
        int k = wordreader.readDWord();
        int l = wordreader.readDWord();
        int j = wordreader.readDWord();
        int ai[] = new int[i];
        int ai1[] = new int[j1];
        int i1 = 28 + wordreader.readIntArray(ai) + wordreader.readIntArray(ai1);
        if (i == 0)
        {
            return null;
        }
        if (j1 == 0)
        {
            i = reschunk_header.size - l;
            j = 0;
        } else
        {
            if (j >= reschunk_header.size - 2)
            {
                throw new IOException("Bad style block.");
            }
            if (j <= l)
            {
                throw new IOException("Bad style block");
            }
            i = j - l;
            j = reschunk_header.size - j;
        }
        if (i == 0)
        {
            throw new IOException("Bad string block.");
        }
        if (i1 > l)
        {
            throw new RuntimeException("String reader overran the string data start. Fixme!");
        }
        if (i1 < l)
        {
            throw new IOException("String header was too small?");
        }
        byte abyte0[] = new byte[i];
        int ai2[] = new int[j];
        i = i1 + wordreader.readByteArray(abyte0) + wordreader.readIntArray(ai2);
        if (i > reschunk_header.size)
        {
            throw new RuntimeException("String reader overran the string data area. Fixme!");
        }
        if (i < reschunk_header.size)
        {
            throw new IOException("String header was too small?");
        } else
        {
            return new ResStringPool(ai, abyte0, ai1, ai2, k);
        }
    }

    public int indexOfString(String s)
    {
        return -1;
    }

    public boolean isSorted()
    {
        return (mFlags & 1) != 0;
    }

    public boolean isUTF8()
    {
        return (mFlags & 0x100) != 0;
    }

    public int size()
    {
        return mStringOffsets.length;
    }

    public String stringAt(int i)
    {
        if (mStringCache.indexOfKey(i) >= 0)
        {
            return (String)mStringCache.get(i);
        } else
        {
            boolean flag = isUTF8();
            int j = mStringOffsets[i];
            String s = newString(mStringData, j, flag);
            mStringCache.put(i, s);
            return s;
        }
    }

    public void styleAt(int i, Span span)
    {
        if (i < mStyleOffsets.length)
        {
            i = mStyleOffsets[i] / 4;
            if (i < mStyleData.length)
            {
                span.index = mStyleData[i];
                span.firstChar = mStyleData[i + 1];
                span.lastChar = mStyleData[i + 2];
            }
        }
    }

    public int styleCount()
    {
        return mStyleOffsets.length;
    }
}
