// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.OutputStream;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.io.NumberOutput;
import org.codehaus.jackson.util.CharTypes;

// Referenced classes of package org.codehaus.jackson.impl:
//            JsonGeneratorBase, JsonWriteContext

public class Utf8Generator extends JsonGeneratorBase
{

    private static final byte FALSE_BYTES[] = {
        102, 97, 108, 115, 101
    };
    static final byte HEX_CHARS[] = CharTypes.copyHexBytes();
    private static final byte NULL_BYTES[] = {
        110, 117, 108, 108
    };
    private static final byte TRUE_BYTES[] = {
        116, 114, 117, 101
    };
    protected static final int sOutputEscapes[] = CharTypes.get7BitOutputEscapes();
    protected boolean _bufferRecyclable;
    protected char _charBuffer[];
    protected final int _charBufferLength;
    protected CharacterEscapes _characterEscapes;
    protected final IOContext _ioContext;
    protected int _maximumNonEscapedChar;
    protected byte _outputBuffer[];
    protected final int _outputEnd;
    protected int _outputEscapes[];
    protected final int _outputMaxContiguous;
    protected final OutputStream _outputStream;
    protected int _outputTail;

    public Utf8Generator(IOContext iocontext, int i, ObjectCodec objectcodec, OutputStream outputstream)
    {
        super(i, objectcodec);
        _outputEscapes = sOutputEscapes;
        _outputTail = 0;
        _ioContext = iocontext;
        _outputStream = outputstream;
        _bufferRecyclable = true;
        _outputBuffer = iocontext.allocWriteEncodingBuffer();
        _outputEnd = _outputBuffer.length;
        _outputMaxContiguous = _outputEnd >> 3;
        _charBuffer = iocontext.allocConcatBuffer();
        _charBufferLength = _charBuffer.length;
        if (isEnabled(org.codehaus.jackson.JsonGenerator.Feature.ESCAPE_NON_ASCII))
        {
            setHighestNonEscapedChar(127);
        }
    }

    private int _handleLongCustomEscape(byte abyte0[], int i, int j, byte abyte1[], int k)
        throws IOException, JsonGenerationException
    {
        int i1 = abyte1.length;
        int l = i;
        if (i + i1 > j)
        {
            _outputTail = i;
            _flushBuffer();
            i = _outputTail;
            if (i1 > abyte0.length)
            {
                _outputStream.write(abyte1, 0, i1);
                return i;
            }
            System.arraycopy(abyte1, 0, abyte0, i, i1);
            l = i + i1;
        }
        if (k * 6 + l > j)
        {
            _flushBuffer();
            return _outputTail;
        } else
        {
            return l;
        }
    }

    private final int _outputMultiByteChar(int i, int j)
        throws IOException
    {
        byte abyte0[] = _outputBuffer;
        if (i >= 55296 && i <= 57343)
        {
            int k = j + 1;
            abyte0[j] = 92;
            j = k + 1;
            abyte0[k] = 117;
            k = j + 1;
            abyte0[j] = HEX_CHARS[i >> 12 & 0xf];
            j = k + 1;
            abyte0[k] = HEX_CHARS[i >> 8 & 0xf];
            k = j + 1;
            abyte0[j] = HEX_CHARS[i >> 4 & 0xf];
            abyte0[k] = HEX_CHARS[i & 0xf];
            return k + 1;
        } else
        {
            int l = j + 1;
            abyte0[j] = (byte)(i >> 12 | 0xe0);
            j = l + 1;
            abyte0[l] = (byte)(i >> 6 & 0x3f | 0x80);
            abyte0[j] = (byte)(i & 0x3f | 0x80);
            return j + 1;
        }
    }

    private final int _outputRawMultiByteChar(int i, char ac[], int j, int k)
        throws IOException
    {
        if (i >= 55296 && i <= 57343)
        {
            if (j >= k)
            {
                _reportError("Split surrogate on writeRaw() input (last character)");
            }
            _outputSurrogates(i, ac[j]);
            return j + 1;
        } else
        {
            ac = _outputBuffer;
            k = _outputTail;
            _outputTail = k + 1;
            ac[k] = (byte)(i >> 12 | 0xe0);
            k = _outputTail;
            _outputTail = k + 1;
            ac[k] = (byte)(i >> 6 & 0x3f | 0x80);
            k = _outputTail;
            _outputTail = k + 1;
            ac[k] = (byte)(i & 0x3f | 0x80);
            return j;
        }
    }

    private int _writeCustomEscape(byte abyte0[], int i, SerializableString serializablestring, int j)
        throws IOException, JsonGenerationException
    {
        serializablestring = serializablestring.asUnquotedUTF8();
        int k = serializablestring.length;
        if (k > 6)
        {
            return _handleLongCustomEscape(abyte0, i, _outputEnd, serializablestring, j);
        } else
        {
            System.arraycopy(serializablestring, 0, abyte0, i, k);
            return i + k;
        }
    }

    private final void _writeCustomStringSegment2(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        if (_outputTail + (j - i) * 6 > _outputEnd)
        {
            _flushBuffer();
        }
        int k = _outputTail;
        byte abyte0[] = _outputBuffer;
        int ai[] = _outputEscapes;
        CharacterEscapes characterescapes;
        int i1;
        if (_maximumNonEscapedChar <= 0)
        {
            i1 = 65535;
        } else
        {
            i1 = _maximumNonEscapedChar;
        }
        characterescapes = _characterEscapes;
        do
        {
            while (i < j) 
            {
                int l = i + 1;
                int j1 = ac[i];
                if (j1 <= 127)
                {
                    if (ai[j1] == 0)
                    {
                        abyte0[k] = (byte)j1;
                        k++;
                        i = l;
                    } else
                    {
                        i = ai[j1];
                        if (i > 0)
                        {
                            j1 = k + 1;
                            abyte0[k] = 92;
                            k = j1 + 1;
                            abyte0[j1] = (byte)i;
                            i = l;
                        } else
                        if (i == -2)
                        {
                            SerializableString serializablestring = characterescapes.getEscapeSequence(j1);
                            if (serializablestring == null)
                            {
                                throw new JsonGenerationException((new StringBuilder()).append("Invalid custom escape definitions; custom escape not found for character code 0x").append(Integer.toHexString(j1)).append(", although was supposed to have one").toString());
                            }
                            k = _writeCustomEscape(abyte0, k, serializablestring, j - l);
                            i = l;
                        } else
                        {
                            k = _writeGenericEscape(j1, k);
                            i = l;
                        }
                    }
                } else
                if (j1 > i1)
                {
                    k = _writeGenericEscape(j1, k);
                    i = l;
                } else
                {
                    SerializableString serializablestring1 = characterescapes.getEscapeSequence(j1);
                    if (serializablestring1 != null)
                    {
                        k = _writeCustomEscape(abyte0, k, serializablestring1, j - l);
                        i = l;
                    } else
                    {
                        if (j1 <= 2047)
                        {
                            i = k + 1;
                            abyte0[k] = (byte)(j1 >> 6 | 0xc0);
                            abyte0[i] = (byte)(j1 & 0x3f | 0x80);
                            i++;
                        } else
                        {
                            i = _outputMultiByteChar(j1, k);
                        }
                        k = i;
                        i = l;
                    }
                }
            }
            _outputTail = k;
            return;
        } while (true);
    }

    private int _writeGenericEscape(int i, int j)
        throws IOException
    {
        byte abyte0[] = _outputBuffer;
        int k = j + 1;
        abyte0[j] = 92;
        j = k + 1;
        abyte0[k] = 117;
        if (i > 255)
        {
            k = i >> 8 & 0xff;
            int i1 = j + 1;
            abyte0[j] = HEX_CHARS[k >> 4];
            j = i1 + 1;
            abyte0[i1] = HEX_CHARS[k & 0xf];
            i &= 0xff;
        } else
        {
            int l = j + 1;
            abyte0[j] = 48;
            j = l + 1;
            abyte0[l] = 48;
        }
        k = j + 1;
        abyte0[j] = HEX_CHARS[i >> 4];
        abyte0[k] = HEX_CHARS[i & 0xf];
        return k + 1;
    }

    private final void _writeLongString(String s)
        throws IOException, JsonGenerationException
    {
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        byte abyte0[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        abyte0[i] = 34;
        _writeStringSegments(s);
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        s = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        s[i] = 34;
    }

    private final void _writeLongString(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        ac = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        ac[i] = '"';
        _writeStringSegments(_charBuffer, 0, j);
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        ac = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        ac[i] = '"';
    }

    private final void _writeNull()
        throws IOException
    {
        if (_outputTail + 4 >= _outputEnd)
        {
            _flushBuffer();
        }
        System.arraycopy(NULL_BYTES, 0, _outputBuffer, _outputTail, 4);
        _outputTail = _outputTail + 4;
    }

    private final void _writeQuotedInt(int i)
        throws IOException
    {
        if (_outputTail + 13 >= _outputEnd)
        {
            _flushBuffer();
        }
        byte abyte0[] = _outputBuffer;
        int j = _outputTail;
        _outputTail = j + 1;
        abyte0[j] = 34;
        _outputTail = NumberOutput.outputInt(i, _outputBuffer, _outputTail);
        abyte0 = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        abyte0[i] = 34;
    }

    private final void _writeQuotedLong(long l)
        throws IOException
    {
        if (_outputTail + 23 >= _outputEnd)
        {
            _flushBuffer();
        }
        byte abyte0[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        abyte0[i] = 34;
        _outputTail = NumberOutput.outputLong(l, _outputBuffer, _outputTail);
        abyte0 = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        abyte0[i] = 34;
    }

    private final void _writeSegmentedRaw(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        int l = _outputEnd;
        byte abyte0[] = _outputBuffer;
label0:
        do
        {
            if (i < j)
            {
                do
                {
                    int k = ac[i];
                    if (k >= 128)
                    {
                        if (_outputTail + 3 >= _outputEnd)
                        {
                            _flushBuffer();
                        }
                        k = i + 1;
                        i = ac[i];
                        int j1;
                        if (i < 2048)
                        {
                            int i1 = _outputTail;
                            _outputTail = i1 + 1;
                            abyte0[i1] = (byte)(i >> 6 | 0xc0);
                            i1 = _outputTail;
                            _outputTail = i1 + 1;
                            abyte0[i1] = (byte)(i & 0x3f | 0x80);
                        } else
                        {
                            _outputRawMultiByteChar(i, ac, k, j);
                        }
                        i = k;
                        continue label0;
                    }
                    if (_outputTail >= l)
                    {
                        _flushBuffer();
                    }
                    j1 = _outputTail;
                    _outputTail = j1 + 1;
                    abyte0[j1] = (byte)k;
                    k = i + 1;
                    i = k;
                } while (k < j);
            }
            return;
        } while (true);
    }

    private final void _writeStringSegment(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        int l = j + i;
        int k = _outputTail;
        byte abyte0[] = _outputBuffer;
        int ai[] = _outputEscapes;
        j = i;
        i = k;
label0:
        do
        {
            char c;
label1:
            {
                if (j < l)
                {
                    c = ac[j];
                    if (c <= '\177' && ai[c] == 0)
                    {
                        break label1;
                    }
                }
                _outputTail = i;
                if (j < l)
                {
                    if (_characterEscapes == null)
                    {
                        break label0;
                    }
                    _writeCustomStringSegment2(ac, j, l);
                }
                return;
            }
            abyte0[i] = (byte)c;
            j++;
            i++;
        } while (true);
        if (_maximumNonEscapedChar == 0)
        {
            _writeStringSegment2(ac, j, l);
            return;
        } else
        {
            _writeStringSegmentASCII2(ac, j, l);
            return;
        }
    }

    private final void _writeStringSegment2(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        if (_outputTail + (j - i) * 6 > _outputEnd)
        {
            _flushBuffer();
        }
        int k = _outputTail;
        byte abyte0[] = _outputBuffer;
        int ai[] = _outputEscapes;
        int i1 = i;
        i = k;
        for (int l = i1; l < j;)
        {
            int j1 = l + 1;
            int k1 = ac[l];
            if (k1 <= 127)
            {
                if (ai[k1] == 0)
                {
                    abyte0[i] = (byte)k1;
                    i++;
                    l = j1;
                } else
                {
                    l = ai[k1];
                    if (l > 0)
                    {
                        k1 = i + 1;
                        abyte0[i] = 92;
                        i = k1 + 1;
                        abyte0[k1] = (byte)l;
                        l = j1;
                    } else
                    {
                        i = _writeGenericEscape(k1, i);
                        l = j1;
                    }
                }
            } else
            {
                if (k1 <= 2047)
                {
                    l = i + 1;
                    abyte0[i] = (byte)(k1 >> 6 | 0xc0);
                    abyte0[l] = (byte)(k1 & 0x3f | 0x80);
                    i = l + 1;
                } else
                {
                    i = _outputMultiByteChar(k1, i);
                }
                l = j1;
            }
        }

        _outputTail = i;
    }

    private final void _writeStringSegmentASCII2(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        if (_outputTail + (j - i) * 6 > _outputEnd)
        {
            _flushBuffer();
        }
        int k = _outputTail;
        byte abyte0[] = _outputBuffer;
        int ai[] = _outputEscapes;
        int i1 = _maximumNonEscapedChar;
        do
        {
            while (i < j) 
            {
                int l = i + 1;
                int j1 = ac[i];
                if (j1 <= 127)
                {
                    if (ai[j1] == 0)
                    {
                        abyte0[k] = (byte)j1;
                        k++;
                        i = l;
                    } else
                    {
                        i = ai[j1];
                        if (i > 0)
                        {
                            j1 = k + 1;
                            abyte0[k] = 92;
                            k = j1 + 1;
                            abyte0[j1] = (byte)i;
                            i = l;
                        } else
                        {
                            k = _writeGenericEscape(j1, k);
                            i = l;
                        }
                    }
                } else
                if (j1 > i1)
                {
                    k = _writeGenericEscape(j1, k);
                    i = l;
                } else
                {
                    if (j1 <= 2047)
                    {
                        i = k + 1;
                        abyte0[k] = (byte)(j1 >> 6 | 0xc0);
                        abyte0[i] = (byte)(j1 & 0x3f | 0x80);
                        i++;
                    } else
                    {
                        i = _outputMultiByteChar(j1, k);
                    }
                    k = i;
                    i = l;
                }
            }
            _outputTail = k;
            return;
        } while (true);
    }

    private final void _writeStringSegments(String s)
        throws IOException, JsonGenerationException
    {
        int i = s.length();
        int j = 0;
        char ac[] = _charBuffer;
        int k;
        for (; i > 0; i -= k)
        {
            k = Math.min(_outputMaxContiguous, i);
            s.getChars(j, j + k, ac, 0);
            if (_outputTail + k > _outputEnd)
            {
                _flushBuffer();
            }
            _writeStringSegment(ac, 0, k);
            j += k;
        }

    }

    private final void _writeStringSegments(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        int k;
        do
        {
            k = Math.min(_outputMaxContiguous, j);
            if (_outputTail + k > _outputEnd)
            {
                _flushBuffer();
            }
            _writeStringSegment(ac, i, k);
            i += k;
            k = j - k;
            j = k;
        } while (k > 0);
    }

    protected final int _decodeSurrogate(int i, int j)
        throws IOException
    {
        if (j < 56320 || j > 57343)
        {
            _reportError((new StringBuilder()).append("Incomplete surrogate pair: first char 0x").append(Integer.toHexString(i)).append(", second 0x").append(Integer.toHexString(j)).toString());
        }
        return 0x10000 + (i - 55296 << 10) + (j - 56320);
    }

    protected final void _flushBuffer()
        throws IOException
    {
        int i = _outputTail;
        if (i > 0)
        {
            _outputTail = 0;
            _outputStream.write(_outputBuffer, 0, i);
        }
    }

    protected final void _outputSurrogates(int i, int j)
        throws IOException
    {
        i = _decodeSurrogate(i, j);
        if (_outputTail + 4 > _outputEnd)
        {
            _flushBuffer();
        }
        byte abyte0[] = _outputBuffer;
        j = _outputTail;
        _outputTail = j + 1;
        abyte0[j] = (byte)(i >> 18 | 0xf0);
        j = _outputTail;
        _outputTail = j + 1;
        abyte0[j] = (byte)(i >> 12 & 0x3f | 0x80);
        j = _outputTail;
        _outputTail = j + 1;
        abyte0[j] = (byte)(i >> 6 & 0x3f | 0x80);
        j = _outputTail;
        _outputTail = j + 1;
        abyte0[j] = (byte)(i & 0x3f | 0x80);
    }

    protected void _releaseBuffers()
    {
        char ac[] = _outputBuffer;
        if (ac != null && _bufferRecyclable)
        {
            _outputBuffer = null;
            _ioContext.releaseWriteEncodingBuffer(ac);
        }
        ac = _charBuffer;
        if (ac != null)
        {
            _charBuffer = null;
            _ioContext.releaseConcatBuffer(ac);
        }
    }

    protected final void _verifyPrettyValueWrite(String s, int i)
        throws IOException, JsonGenerationException
    {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 70
    //                   1 37
    //                   2 48
    //                   3 59;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        _cantHappen();
_L7:
        return;
_L3:
        _cfgPrettyPrinter.writeArrayValueSeparator(this);
        return;
_L4:
        _cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
        return;
_L5:
        _cfgPrettyPrinter.writeRootValueSeparator(this);
        return;
_L2:
        if (_writeContext.inArray())
        {
            _cfgPrettyPrinter.beforeArrayValues(this);
            return;
        }
        if (_writeContext.inObject())
        {
            _cfgPrettyPrinter.beforeObjectEntries(this);
            return;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected final void _verifyValueWrite(String s)
        throws IOException, JsonGenerationException
    {
        int i;
        i = _writeContext.writeValue();
        if (i == 5)
        {
            _reportError((new StringBuilder()).append("Can not ").append(s).append(", expecting field name").toString());
        }
        if (_cfgPrettyPrinter != null) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 3: default 76
    //                   1 77
    //                   2 116
    //                   3 122;
           goto _L3 _L4 _L5 _L6
_L3:
        return;
_L4:
        byte byte0 = 44;
_L7:
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        _outputBuffer[_outputTail] = byte0;
        _outputTail = _outputTail + 1;
        return;
_L5:
        byte0 = 58;
        continue; /* Loop/switch isn't completed */
_L6:
        byte0 = 32;
        if (true) goto _L7; else goto _L2
_L2:
        _verifyPrettyValueWrite(s, i);
        return;
    }

    protected final void _writeFieldName(String s)
        throws IOException, JsonGenerationException
    {
        if (!isEnabled(org.codehaus.jackson.JsonGenerator.Feature.QUOTE_FIELD_NAMES))
        {
            _writeStringSegments(s);
            return;
        }
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        byte abyte0[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        abyte0[i] = 34;
        i = s.length();
        if (i <= _charBufferLength)
        {
            s.getChars(0, i, _charBuffer, 0);
            if (i <= _outputMaxContiguous)
            {
                if (_outputTail + i > _outputEnd)
                {
                    _flushBuffer();
                }
                _writeStringSegment(_charBuffer, 0, i);
            } else
            {
                _writeStringSegments(_charBuffer, 0, i);
            }
        } else
        {
            _writeStringSegments(s);
        }
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        s = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        s[i] = 34;
    }

    protected final void _writePPFieldName(String s, boolean flag)
        throws IOException, JsonGenerationException
    {
        if (flag)
        {
            _cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else
        {
            _cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (isEnabled(org.codehaus.jackson.JsonGenerator.Feature.QUOTE_FIELD_NAMES))
        {
            if (_outputTail >= _outputEnd)
            {
                _flushBuffer();
            }
            byte abyte0[] = _outputBuffer;
            int i = _outputTail;
            _outputTail = i + 1;
            abyte0[i] = 34;
            i = s.length();
            if (i <= _charBufferLength)
            {
                s.getChars(0, i, _charBuffer, 0);
                if (i <= _outputMaxContiguous)
                {
                    if (_outputTail + i > _outputEnd)
                    {
                        _flushBuffer();
                    }
                    _writeStringSegment(_charBuffer, 0, i);
                } else
                {
                    _writeStringSegments(_charBuffer, 0, i);
                }
            } else
            {
                _writeStringSegments(s);
            }
            if (_outputTail >= _outputEnd)
            {
                _flushBuffer();
            }
            s = _outputBuffer;
            i = _outputTail;
            _outputTail = i + 1;
            s[i] = 34;
            return;
        } else
        {
            _writeStringSegments(s);
            return;
        }
    }

    public void close()
        throws IOException
    {
        super.close();
        if (_outputBuffer != null && isEnabled(org.codehaus.jackson.JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT))
        {
            do
            {
                JsonWriteContext jsonwritecontext = getOutputContext();
                if (jsonwritecontext.inArray())
                {
                    writeEndArray();
                    continue;
                }
                if (!jsonwritecontext.inObject())
                {
                    break;
                }
                writeEndObject();
            } while (true);
        }
        _flushBuffer();
        if (_outputStream == null) goto _L2; else goto _L1
_L1:
        if (!_ioContext.isResourceManaged() && !isEnabled(org.codehaus.jackson.JsonGenerator.Feature.AUTO_CLOSE_TARGET)) goto _L4; else goto _L3
_L3:
        _outputStream.close();
_L2:
        _releaseBuffers();
        return;
_L4:
        if (isEnabled(org.codehaus.jackson.JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))
        {
            _outputStream.flush();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final void flush()
        throws IOException
    {
        _flushBuffer();
        if (_outputStream != null && isEnabled(org.codehaus.jackson.JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))
        {
            _outputStream.flush();
        }
    }

    public JsonGenerator setCharacterEscapes(CharacterEscapes characterescapes)
    {
        _characterEscapes = characterescapes;
        if (characterescapes == null)
        {
            _outputEscapes = sOutputEscapes;
            return this;
        } else
        {
            _outputEscapes = characterescapes.getEscapeCodesForAscii();
            return this;
        }
    }

    public JsonGenerator setHighestNonEscapedChar(int i)
    {
        int j = i;
        if (i < 0)
        {
            j = 0;
        }
        _maximumNonEscapedChar = j;
        return this;
    }

    public void writeBoolean(boolean flag)
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("write boolean value");
        if (_outputTail + 5 >= _outputEnd)
        {
            _flushBuffer();
        }
        byte abyte0[];
        int i;
        if (flag)
        {
            abyte0 = TRUE_BYTES;
        } else
        {
            abyte0 = FALSE_BYTES;
        }
        i = abyte0.length;
        System.arraycopy(abyte0, 0, _outputBuffer, _outputTail, i);
        _outputTail = _outputTail + i;
    }

    public final void writeEndArray()
        throws IOException, JsonGenerationException
    {
        if (!_writeContext.inArray())
        {
            _reportError((new StringBuilder()).append("Current context not an ARRAY but ").append(_writeContext.getTypeDesc()).toString());
        }
        if (_cfgPrettyPrinter != null)
        {
            _cfgPrettyPrinter.writeEndArray(this, _writeContext.getEntryCount());
        } else
        {
            if (_outputTail >= _outputEnd)
            {
                _flushBuffer();
            }
            byte abyte0[] = _outputBuffer;
            int i = _outputTail;
            _outputTail = i + 1;
            abyte0[i] = 93;
        }
        _writeContext = _writeContext.getParent();
    }

    public final void writeEndObject()
        throws IOException, JsonGenerationException
    {
        if (!_writeContext.inObject())
        {
            _reportError((new StringBuilder()).append("Current context not an object but ").append(_writeContext.getTypeDesc()).toString());
        }
        if (_cfgPrettyPrinter != null)
        {
            _cfgPrettyPrinter.writeEndObject(this, _writeContext.getEntryCount());
        } else
        {
            if (_outputTail >= _outputEnd)
            {
                _flushBuffer();
            }
            byte abyte0[] = _outputBuffer;
            int i = _outputTail;
            _outputTail = i + 1;
            abyte0[i] = 125;
        }
        _writeContext = _writeContext.getParent();
    }

    public final void writeFieldName(String s)
        throws IOException, JsonGenerationException
    {
        boolean flag = true;
        int i = _writeContext.writeFieldName(s);
        if (i == 4)
        {
            _reportError("Can not write a field name, expecting a value");
        }
        if (_cfgPrettyPrinter != null)
        {
            if (i != 1)
            {
                flag = false;
            }
            _writePPFieldName(s, flag);
            return;
        }
        if (i == 1)
        {
            if (_outputTail >= _outputEnd)
            {
                _flushBuffer();
            }
            byte abyte0[] = _outputBuffer;
            int j = _outputTail;
            _outputTail = j + 1;
            abyte0[j] = 44;
        }
        _writeFieldName(s);
    }

    public void writeNull()
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("write null value");
        _writeNull();
    }

    public void writeNumber(double d)
        throws IOException, JsonGenerationException
    {
        if (_cfgNumbersAsStrings || (Double.isNaN(d) || Double.isInfinite(d)) && isEnabled(org.codehaus.jackson.JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))
        {
            writeString(String.valueOf(d));
            return;
        } else
        {
            _verifyValueWrite("write number");
            writeRaw(String.valueOf(d));
            return;
        }
    }

    public void writeNumber(int i)
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("write number");
        if (_outputTail + 11 >= _outputEnd)
        {
            _flushBuffer();
        }
        if (_cfgNumbersAsStrings)
        {
            _writeQuotedInt(i);
            return;
        } else
        {
            _outputTail = NumberOutput.outputInt(i, _outputBuffer, _outputTail);
            return;
        }
    }

    public void writeNumber(long l)
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("write number");
        if (_cfgNumbersAsStrings)
        {
            _writeQuotedLong(l);
            return;
        }
        if (_outputTail + 21 >= _outputEnd)
        {
            _flushBuffer();
        }
        _outputTail = NumberOutput.outputLong(l, _outputBuffer, _outputTail);
    }

    public void writeRaw(String s)
        throws IOException, JsonGenerationException
    {
        int j = 0;
        int k;
        for (int i = s.length(); i > 0; i -= k)
        {
            char ac[] = _charBuffer;
            k = ac.length;
            if (i < k)
            {
                k = i;
            }
            s.getChars(j, j + k, ac, 0);
            writeRaw(ac, 0, k);
            j += k;
        }

    }

    public final void writeRaw(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        int k = j + j + j;
        if (_outputTail + k <= _outputEnd) goto _L2; else goto _L1
_L1:
        if (_outputEnd >= k) goto _L4; else goto _L3
_L3:
        _writeSegmentedRaw(ac, i, j);
_L10:
        return;
_L4:
        _flushBuffer();
_L2:
        k = j + i;
_L8:
        if (i >= k)
        {
            continue; /* Loop/switch isn't completed */
        }
_L6:
label0:
        {
            j = ac[i];
            if (j <= 127)
            {
                break label0;
            }
            j = i + 1;
            i = ac[i];
            byte abyte1[];
            int i1;
            if (i < 2048)
            {
                byte abyte0[] = _outputBuffer;
                int l = _outputTail;
                _outputTail = l + 1;
                abyte0[l] = (byte)(i >> 6 | 0xc0);
                abyte0 = _outputBuffer;
                l = _outputTail;
                _outputTail = l + 1;
                abyte0[l] = (byte)(i & 0x3f | 0x80);
            } else
            {
                _outputRawMultiByteChar(i, ac, j, k);
            }
            i = j;
        }
        continue; /* Loop/switch isn't completed */
        abyte1 = _outputBuffer;
        i1 = _outputTail;
        _outputTail = i1 + 1;
        abyte1[i1] = (byte)j;
        j = i + 1;
        i = j;
        if (j < k) goto _L6; else goto _L5
_L5:
        return;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final void writeStartArray()
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("start an array");
        _writeContext = _writeContext.createChildArrayContext();
        if (_cfgPrettyPrinter != null)
        {
            _cfgPrettyPrinter.writeStartArray(this);
            return;
        }
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        byte abyte0[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        abyte0[i] = 91;
    }

    public final void writeStartObject()
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("start an object");
        _writeContext = _writeContext.createChildObjectContext();
        if (_cfgPrettyPrinter != null)
        {
            _cfgPrettyPrinter.writeStartObject(this);
            return;
        }
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        byte abyte0[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        abyte0[i] = 123;
    }

    public void writeString(String s)
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("write text value");
        if (s == null)
        {
            _writeNull();
            return;
        }
        int i = s.length();
        if (i > _charBufferLength)
        {
            _writeLongString(s);
            return;
        }
        s.getChars(0, i, _charBuffer, 0);
        if (i > _outputMaxContiguous)
        {
            _writeLongString(_charBuffer, 0, i);
            return;
        }
        if (_outputTail + i >= _outputEnd)
        {
            _flushBuffer();
        }
        s = _outputBuffer;
        int j = _outputTail;
        _outputTail = j + 1;
        s[j] = 34;
        _writeStringSegment(_charBuffer, 0, i);
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        s = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        s[i] = 34;
    }

}
