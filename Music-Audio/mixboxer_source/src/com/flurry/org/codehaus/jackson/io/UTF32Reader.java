// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.flurry.org.codehaus.jackson.io:
//            BaseReader, IOContext

public final class UTF32Reader extends BaseReader
{

    final boolean mBigEndian;
    int mByteCount;
    int mCharCount;
    char mSurrogate;

    public UTF32Reader(IOContext iocontext, InputStream inputstream, byte abyte0[], int i, int j, boolean flag)
    {
        super(iocontext, inputstream, abyte0, i, j);
        mSurrogate = '\0';
        mCharCount = 0;
        mByteCount = 0;
        mBigEndian = flag;
    }

    private boolean loadMore(int i)
        throws IOException
    {
        mByteCount = mByteCount + (_length - i);
        if (i > 0)
        {
            if (_ptr > 0)
            {
                for (int j = 0; j < i; j++)
                {
                    _buffer[j] = _buffer[_ptr + j];
                }

                _ptr = 0;
            }
        } else
        {
            _ptr = 0;
            i = _in.read(_buffer);
            if (i < 1)
            {
                _length = 0;
                if (i < 0)
                {
                    freeBuffers();
                    return false;
                }
                reportStrangeStream();
            }
            _length = i;
        }
        for (_length = i; _length < 4; _length = _length + i)
        {
            i = _in.read(_buffer, _length, _buffer.length - _length);
            if (i < 1)
            {
                if (i < 0)
                {
                    freeBuffers();
                    reportUnexpectedEOF(_length, 4);
                }
                reportStrangeStream();
            }
        }

        return true;
    }

    private void reportInvalid(int i, int j, String s)
        throws IOException
    {
        int k = mByteCount;
        int l = _ptr;
        int i1 = mCharCount;
        throw new CharConversionException((new StringBuilder()).append("Invalid UTF-32 character 0x").append(Integer.toHexString(i)).append(s).append(" at char #").append(i1 + j).append(", byte #").append((k + l) - 1).append(")").toString());
    }

    private void reportUnexpectedEOF(int i, int j)
        throws IOException
    {
        int k = mByteCount;
        int l = mCharCount;
        throw new CharConversionException((new StringBuilder()).append("Unexpected EOF in the middle of a 4-byte UTF-32 char: got ").append(i).append(", needed ").append(j).append(", at char #").append(l).append(", byte #").append(k + i).append(")").toString());
    }

    public volatile void close()
        throws IOException
    {
        super.close();
    }

    public volatile int read()
        throws IOException
    {
        return super.read();
    }

    public int read(char ac[], int i, int j)
        throws IOException
    {
        if (_buffer != null) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int j1;
        if (j < 1)
        {
            return j;
        }
        if (i < 0 || i + j > ac.length)
        {
            reportBounds(ac, i, j);
        }
        j1 = j + i;
        if (mSurrogate == 0) goto _L4; else goto _L3
_L3:
        j = i + 1;
        ac[i] = mSurrogate;
        mSurrogate = '\0';
_L12:
        if (j >= j1) goto _L6; else goto _L5
_L5:
        int k;
        int l;
        k = _ptr;
        int i1;
        if (mBigEndian)
        {
            k = _buffer[k] << 24 | (_buffer[k + 1] & 0xff) << 16 | (_buffer[k + 2] & 0xff) << 8 | _buffer[k + 3] & 0xff;
        } else
        {
            k = _buffer[k] & 0xff | (_buffer[k + 1] & 0xff) << 8 | (_buffer[k + 2] & 0xff) << 16 | _buffer[k + 3] << 24;
        }
        _ptr = _ptr + 4;
        if (k <= 65535) goto _L8; else goto _L7
_L7:
        if (k > 0x10ffff)
        {
            reportInvalid(k, j - i, (new StringBuilder()).append("(above ").append(Integer.toHexString(0x10ffff)).append(") ").toString());
        }
        l = k - 0x10000;
        k = j + 1;
        ac[j] = (char)(55296 + (l >> 10));
        i1 = 0xdc00 | l & 0x3ff;
        l = i1;
        j = k;
        if (k < j1) goto _L10; else goto _L9
_L9:
        mSurrogate = (char)i1;
        j = k;
_L6:
        i = j - i;
        mCharCount = mCharCount + i;
        return i;
_L4:
        j = _length - _ptr;
        if (j < 4 && !loadMore(j)) goto _L1; else goto _L11
_L11:
        j = i;
          goto _L12
_L8:
        l = k;
_L10:
        k = j + 1;
        ac[j] = (char)l;
        j = k;
        if (_ptr < _length) goto _L12; else goto _L13
_L13:
        j = k;
          goto _L6
    }
}
