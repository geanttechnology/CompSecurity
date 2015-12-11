// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.io.MergedStream;
import org.codehaus.jackson.io.UTF32Reader;
import org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import org.codehaus.jackson.sym.CharsToNameCanonicalizer;

// Referenced classes of package org.codehaus.jackson.impl:
//            Utf8StreamParser, ReaderBasedParser

public final class ByteSourceBootstrapper
{

    protected boolean _bigEndian;
    private final boolean _bufferRecyclable;
    protected int _bytesPerChar;
    protected final IOContext _context;
    protected final InputStream _in;
    protected final byte _inputBuffer[];
    private int _inputEnd;
    protected int _inputProcessed;
    private int _inputPtr;

    public ByteSourceBootstrapper(IOContext iocontext, InputStream inputstream)
    {
        _bigEndian = true;
        _bytesPerChar = 0;
        _context = iocontext;
        _in = inputstream;
        _inputBuffer = iocontext.allocReadIOBuffer();
        _inputPtr = 0;
        _inputEnd = 0;
        _inputProcessed = 0;
        _bufferRecyclable = true;
    }

    public ByteSourceBootstrapper(IOContext iocontext, byte abyte0[], int i, int j)
    {
        _bigEndian = true;
        _bytesPerChar = 0;
        _context = iocontext;
        _in = null;
        _inputBuffer = abyte0;
        _inputPtr = i;
        _inputEnd = i + j;
        _inputProcessed = -i;
        _bufferRecyclable = false;
    }

    private boolean checkUTF16(int i)
    {
        boolean flag = false;
        if ((0xff00 & i) != 0) goto _L2; else goto _L1
_L1:
        _bigEndian = true;
_L6:
        _bytesPerChar = 2;
        flag = true;
_L4:
        return flag;
_L2:
        if ((i & 0xff) != 0) goto _L4; else goto _L3
_L3:
        _bigEndian = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean checkUTF32(int i)
        throws IOException
    {
        boolean flag = false;
        if (i >> 8 == 0)
        {
            _bigEndian = true;
        } else
        if ((0xffffff & i) == 0)
        {
            _bigEndian = false;
        } else
        {
            if ((0xff00ffff & i) != 0)
            {
                continue;
            }
            reportWeirdUCS4("3412");
        }
        do
        {
            _bytesPerChar = 4;
            flag = true;
            do
            {
                return flag;
            } while ((0xffff00ff & i) != 0);
            reportWeirdUCS4("2143");
        } while (true);
    }

    private boolean handleBOM(int i)
        throws IOException
    {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   -16842752: 127
    //                   -131072: 99
    //                   65279: 77
    //                   65534: 121;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        int j;
        j = i >>> 16;
        if (j == 65279)
        {
            _inputPtr = _inputPtr + 2;
            _bytesPerChar = 2;
            _bigEndian = true;
            return true;
        }
        break; /* Loop/switch isn't completed */
_L4:
        _bigEndian = true;
        _inputPtr = _inputPtr + 4;
        _bytesPerChar = 4;
        return true;
_L3:
        _inputPtr = _inputPtr + 4;
        _bytesPerChar = 4;
        _bigEndian = false;
        return true;
_L5:
        reportWeirdUCS4("2143");
_L2:
        reportWeirdUCS4("3412");
        if (true) goto _L1; else goto _L6
_L6:
        if (j == 65534)
        {
            _inputPtr = _inputPtr + 2;
            _bytesPerChar = 2;
            _bigEndian = false;
            return true;
        }
        if (i >>> 8 == 0xefbbbf)
        {
            _inputPtr = _inputPtr + 3;
            _bytesPerChar = 1;
            _bigEndian = true;
            return true;
        } else
        {
            return false;
        }
    }

    private void reportWeirdUCS4(String s)
        throws IOException
    {
        throw new CharConversionException((new StringBuilder()).append("Unsupported UCS-4 endianness (").append(s).append(") detected").toString());
    }

    public JsonParser constructParser(int i, ObjectCodec objectcodec, BytesToNameCanonicalizer bytestonamecanonicalizer, CharsToNameCanonicalizer charstonamecanonicalizer)
        throws IOException, JsonParseException
    {
        JsonEncoding jsonencoding = detectEncoding();
        boolean flag = org.codehaus.jackson.JsonParser.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i);
        boolean flag1 = org.codehaus.jackson.JsonParser.Feature.INTERN_FIELD_NAMES.enabledIn(i);
        if (jsonencoding == JsonEncoding.UTF8 && flag)
        {
            bytestonamecanonicalizer = bytestonamecanonicalizer.makeChild(flag, flag1);
            return new Utf8StreamParser(_context, i, _in, objectcodec, bytestonamecanonicalizer, _inputBuffer, _inputPtr, _inputEnd, _bufferRecyclable);
        } else
        {
            return new ReaderBasedParser(_context, i, constructReader(), objectcodec, charstonamecanonicalizer.makeChild(flag, flag1));
        }
    }

    public Reader constructReader()
        throws IOException
    {
        Object obj;
        JsonEncoding jsonencoding;
        jsonencoding = _context.getEncoding();
        static class _cls1
        {

            static final int $SwitchMap$org$codehaus$jackson$JsonEncoding[];

            static 
            {
                $SwitchMap$org$codehaus$jackson$JsonEncoding = new int[JsonEncoding.values().length];
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonEncoding[JsonEncoding.UTF32_BE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonEncoding[JsonEncoding.UTF32_LE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonEncoding[JsonEncoding.UTF16_BE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonEncoding[JsonEncoding.UTF16_LE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonEncoding[JsonEncoding.UTF8.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.org.codehaus.jackson.JsonEncoding[jsonencoding.ordinal()])
        {
        default:
            throw new RuntimeException("Internal error");

        case 1: // '\001'
        case 2: // '\002'
            return new UTF32Reader(_context, _in, _inputBuffer, _inputPtr, _inputEnd, _context.getEncoding().isBigEndian());

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            obj = _in;
            break;
        }
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new ByteArrayInputStream(_inputBuffer, _inputPtr, _inputEnd);
_L4:
        return new InputStreamReader(((InputStream) (obj)), jsonencoding.getJavaName());
_L2:
        if (_inputPtr < _inputEnd)
        {
            obj = new MergedStream(_context, ((InputStream) (obj)), _inputBuffer, _inputPtr, _inputEnd);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public JsonEncoding detectEncoding()
        throws IOException, JsonParseException
    {
        boolean flag1 = false;
        if (!ensureLoaded(4)) goto _L2; else goto _L1
_L1:
        int i = _inputBuffer[_inputPtr] << 24 | (_inputBuffer[_inputPtr + 1] & 0xff) << 16 | (_inputBuffer[_inputPtr + 2] & 0xff) << 8 | _inputBuffer[_inputPtr + 3] & 0xff;
        if (!handleBOM(i)) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L10:
        if (flag) goto _L6; else goto _L5
_L5:
        JsonEncoding jsonencoding = JsonEncoding.UTF8;
_L8:
        _context.setEncoding(jsonencoding);
        return jsonencoding;
_L4:
        if (checkUTF32(i))
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (checkUTF16(i >>> 16))
            {
                flag = true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        flag = flag1;
        if (ensureLoaded(2))
        {
            flag = flag1;
            if (checkUTF16((_inputBuffer[_inputPtr] & 0xff) << 8 | _inputBuffer[_inputPtr + 1] & 0xff))
            {
                flag = true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        switch (_bytesPerChar)
        {
        case 3: // '\003'
        default:
            throw new RuntimeException("Internal error");

        case 1: // '\001'
            jsonencoding = JsonEncoding.UTF8;
            break;

        case 2: // '\002'
            if (_bigEndian)
            {
                jsonencoding = JsonEncoding.UTF16_BE;
            } else
            {
                jsonencoding = JsonEncoding.UTF16_LE;
            }
            break;

        case 4: // '\004'
            if (_bigEndian)
            {
                jsonencoding = JsonEncoding.UTF32_BE;
            } else
            {
                jsonencoding = JsonEncoding.UTF32_LE;
            }
            break;
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected boolean ensureLoaded(int i)
        throws IOException
    {
        boolean flag1 = true;
        int j = _inputEnd - _inputPtr;
        do
        {
            int k;
label0:
            {
                boolean flag = flag1;
                if (j < i)
                {
                    if (_in == null)
                    {
                        k = -1;
                    } else
                    {
                        k = _in.read(_inputBuffer, _inputEnd, _inputBuffer.length - _inputEnd);
                    }
                    if (k >= 1)
                    {
                        break label0;
                    }
                    flag = false;
                }
                return flag;
            }
            _inputEnd = _inputEnd + k;
            j += k;
        } while (true);
    }
}
