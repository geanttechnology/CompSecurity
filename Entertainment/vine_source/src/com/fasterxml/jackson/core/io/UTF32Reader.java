// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.fasterxml.jackson.core.io:
//            BaseReader, IOContext

public class UTF32Reader extends BaseReader
{

    protected final boolean _bigEndian;
    protected int _byteCount;
    protected int _charCount;
    protected final boolean _managedBuffers;
    protected char _surrogate;

    public UTF32Reader(IOContext iocontext, InputStream inputstream, byte abyte0[], int i, int j, boolean flag)
    {
        boolean flag1 = false;
        super(iocontext, inputstream, abyte0, i, j);
        _surrogate = '\0';
        _charCount = 0;
        _byteCount = 0;
        _bigEndian = flag;
        flag = flag1;
        if (inputstream != null)
        {
            flag = true;
        }
        _managedBuffers = flag;
    }

    private boolean loadMore(int i)
        throws IOException
    {
        _byteCount = _byteCount + (_length - i);
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
            _length = i;
        } else
        {
            _ptr = 0;
            if (_in == null)
            {
                i = -1;
            } else
            {
                i = _in.read(_buffer);
            }
            if (i < 1)
            {
                _length = 0;
                if (i < 0)
                {
                    if (_managedBuffers)
                    {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            _length = i;
        }
        while (_length < 4) 
        {
            if (_in == null)
            {
                i = -1;
            } else
            {
                i = _in.read(_buffer, _length, _buffer.length - _length);
            }
            if (i < 1)
            {
                if (i < 0)
                {
                    if (_managedBuffers)
                    {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(_length, 4);
                }
                reportStrangeStream();
            }
            _length = i + _length;
        }
        return true;
    }

    private void reportInvalid(int i, int j, String s)
        throws IOException
    {
        int k = _byteCount;
        int l = _ptr;
        int i1 = _charCount;
        throw new CharConversionException((new StringBuilder()).append("Invalid UTF-32 character 0x").append(Integer.toHexString(i)).append(s).append(" at char #").append(i1 + j).append(", byte #").append((k + l) - 1).append(")").toString());
    }

    private void reportUnexpectedEOF(int i, int j)
        throws IOException
    {
        int k = _byteCount;
        int l = _charCount;
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
        int k = -1;
_L4:
        return k;
_L2:
        k = j;
        if (j < 1) goto _L4; else goto _L3
_L3:
        int k1;
        if (i < 0 || i + j > ac.length)
        {
            reportBounds(ac, i, j);
        }
        k1 = j + i;
        if (_surrogate == 0) goto _L6; else goto _L5
_L5:
        j = i + 1;
        ac[i] = _surrogate;
        _surrogate = '\0';
_L15:
        if (j >= k1) goto _L8; else goto _L7
_L7:
        int i1;
        k = _ptr;
        int j1;
        if (_bigEndian)
        {
            byte byte0 = _buffer[k];
            byte byte1 = _buffer[k + 1];
            byte byte3 = _buffer[k + 2];
            k = _buffer[k + 3] & 0xff | (byte0 << 24 | (byte1 & 0xff) << 16 | (byte3 & 0xff) << 8);
        } else
        {
            i1 = _buffer[k];
            byte byte2 = _buffer[k + 1];
            byte byte4 = _buffer[k + 2];
            k = _buffer[k + 3] << 24 | (i1 & 0xff | (byte2 & 0xff) << 8 | (byte4 & 0xff) << 16);
        }
        _ptr = _ptr + 4;
        if (k <= 65535) goto _L10; else goto _L9
_L9:
        if (k > 0x10ffff)
        {
            reportInvalid(k, j - i, (new StringBuilder()).append("(above ").append(Integer.toHexString(0x10ffff)).append(") ").toString());
        }
        i1 = k - 0x10000;
        k = j + 1;
        ac[j] = (char)(55296 + (i1 >> 10));
        j1 = i1 & 0x3ff | 0xdc00;
        i1 = j1;
        j = k;
        if (k < k1) goto _L12; else goto _L11
_L11:
        _surrogate = (char)j1;
        j = k;
_L8:
        i = j - i;
        _charCount = _charCount + i;
        return i;
_L6:
        j = _length - _ptr;
        if (j < 4 && !loadMore(j))
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L10:
        i1 = k;
_L12:
        int l = j + 1;
        ac[j] = (char)i1;
        j = l;
        if (_ptr < _length)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = l;
        if (true) goto _L8; else goto _L13
_L13:
        j = i;
        if (true) goto _L15; else goto _L14
_L14:
    }
}
