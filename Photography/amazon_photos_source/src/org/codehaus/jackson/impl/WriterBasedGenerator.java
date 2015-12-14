// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.Writer;
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

public final class WriterBasedGenerator extends JsonGeneratorBase
{

    protected static final char HEX_CHARS[] = CharTypes.copyHexChars();
    protected static final int sOutputEscapes[] = CharTypes.get7BitOutputEscapes();
    protected CharacterEscapes _characterEscapes;
    protected SerializableString _currentEscape;
    protected char _entityBuffer[];
    protected final IOContext _ioContext;
    protected int _maximumNonEscapedChar;
    protected char _outputBuffer[];
    protected int _outputEnd;
    protected int _outputEscapes[];
    protected int _outputHead;
    protected int _outputTail;
    protected final Writer _writer;

    public WriterBasedGenerator(IOContext iocontext, int i, ObjectCodec objectcodec, Writer writer)
    {
        super(i, objectcodec);
        _outputEscapes = sOutputEscapes;
        _outputHead = 0;
        _outputTail = 0;
        _ioContext = iocontext;
        _writer = writer;
        _outputBuffer = iocontext.allocConcatBuffer();
        _outputEnd = _outputBuffer.length;
        if (isEnabled(org.codehaus.jackson.JsonGenerator.Feature.ESCAPE_NON_ASCII))
        {
            setHighestNonEscapedChar(127);
        }
    }

    private char[] _allocateEntityBuffer()
    {
        char ac[] = new char[14];
        ac[0] = '\\';
        ac[2] = '\\';
        ac[3] = 'u';
        ac[4] = '0';
        ac[5] = '0';
        ac[8] = '\\';
        ac[9] = 'u';
        _entityBuffer = ac;
        return ac;
    }

    private final int _prependOrWriteCharacterEscape(char ac[], int i, int j, char c, int k)
        throws IOException, JsonGenerationException
    {
        if (k >= 0)
        {
            if (i > 1 && i < j)
            {
                i -= 2;
                ac[i] = '\\';
                ac[i + 1] = (char)k;
            } else
            {
                char ac1[] = _entityBuffer;
                ac = ac1;
                if (ac1 == null)
                {
                    ac = _allocateEntityBuffer();
                }
                ac[1] = (char)k;
                _writer.write(ac, 0, 2);
            }
            return i;
        }
        if (k != -2)
        {
            if (i > 5 && i < j)
            {
                i -= 6;
                j = i + 1;
                ac[i] = '\\';
                i = j + 1;
                ac[j] = 'u';
                if (c > '\377')
                {
                    j = c >> 8 & 0xff;
                    k = i + 1;
                    ac[i] = HEX_CHARS[j >> 4];
                    i = k + 1;
                    ac[k] = HEX_CHARS[j & 0xf];
                    c &= '\377';
                } else
                {
                    j = i + 1;
                    ac[i] = '0';
                    i = j + 1;
                    ac[j] = '0';
                }
                j = i + 1;
                ac[i] = HEX_CHARS[c >> 4];
                ac[j] = HEX_CHARS[c & 0xf];
                i = j - 5;
            } else
            {
                char ac2[] = _entityBuffer;
                ac = ac2;
                if (ac2 == null)
                {
                    ac = _allocateEntityBuffer();
                }
                _outputHead = _outputTail;
                if (c > '\377')
                {
                    j = c >> 8 & 0xff;
                    c &= '\377';
                    ac[10] = HEX_CHARS[j >> 4];
                    ac[11] = HEX_CHARS[j & 0xf];
                    ac[12] = HEX_CHARS[c >> 4];
                    ac[13] = HEX_CHARS[c & 0xf];
                    _writer.write(ac, 8, 6);
                } else
                {
                    ac[6] = HEX_CHARS[c >> 4];
                    ac[7] = HEX_CHARS[c & 0xf];
                    _writer.write(ac, 2, 6);
                }
            }
            return i;
        }
        String s;
        if (_currentEscape == null)
        {
            s = _characterEscapes.getEscapeSequence(c).getValue();
        } else
        {
            s = _currentEscape.getValue();
            _currentEscape = null;
        }
        c = s.length();
        if (i >= c && i < j)
        {
            i -= c;
            s.getChars(0, c, ac, i);
        } else
        {
            _writer.write(s);
        }
        return i;
    }

    private final void _prependOrWriteCharacterEscape(char c, int i)
        throws IOException, JsonGenerationException
    {
        if (i >= 0)
        {
            if (_outputTail >= 2)
            {
                c = _outputTail - 2;
                _outputHead = c;
                _outputBuffer[c] = '\\';
                _outputBuffer[c + 1] = (char)i;
                return;
            }
            char ac3[] = _entityBuffer;
            char ac[] = ac3;
            if (ac3 == null)
            {
                ac = _allocateEntityBuffer();
            }
            _outputHead = _outputTail;
            ac[1] = (char)i;
            _writer.write(ac, 0, 2);
            return;
        }
        if (i != -2)
        {
            if (_outputTail >= 6)
            {
                char ac1[] = _outputBuffer;
                i = _outputTail - 6;
                _outputHead = i;
                ac1[i] = '\\';
                i++;
                ac1[i] = 'u';
                if (c > '\377')
                {
                    int j = c >> 8 & 0xff;
                    i++;
                    ac1[i] = HEX_CHARS[j >> 4];
                    i++;
                    ac1[i] = HEX_CHARS[j & 0xf];
                    c &= '\377';
                } else
                {
                    i++;
                    ac1[i] = '0';
                    i++;
                    ac1[i] = '0';
                }
                i++;
                ac1[i] = HEX_CHARS[c >> 4];
                ac1[i + 1] = HEX_CHARS[c & 0xf];
                return;
            }
            char ac4[] = _entityBuffer;
            char ac2[] = ac4;
            if (ac4 == null)
            {
                ac2 = _allocateEntityBuffer();
            }
            _outputHead = _outputTail;
            if (c > '\377')
            {
                i = c >> 8 & 0xff;
                c &= '\377';
                ac2[10] = HEX_CHARS[i >> 4];
                ac2[11] = HEX_CHARS[i & 0xf];
                ac2[12] = HEX_CHARS[c >> 4];
                ac2[13] = HEX_CHARS[c & 0xf];
                _writer.write(ac2, 8, 6);
                return;
            } else
            {
                ac2[6] = HEX_CHARS[c >> 4];
                ac2[7] = HEX_CHARS[c & 0xf];
                _writer.write(ac2, 2, 6);
                return;
            }
        }
        String s;
        if (_currentEscape == null)
        {
            s = _characterEscapes.getEscapeSequence(c).getValue();
        } else
        {
            s = _currentEscape.getValue();
            _currentEscape = null;
        }
        c = s.length();
        if (_outputTail >= c)
        {
            i = _outputTail - c;
            _outputHead = i;
            s.getChars(0, c, _outputBuffer, i);
            return;
        } else
        {
            _outputHead = _outputTail;
            _writer.write(s);
            return;
        }
    }

    private void _writeLongString(String s)
        throws IOException, JsonGenerationException
    {
        _flushBuffer();
        int k = s.length();
        int i = 0;
        do
        {
            int j = _outputEnd;
            if (i + j > k)
            {
                j = k - i;
            }
            s.getChars(i, i + j, _outputBuffer, 0);
            if (_characterEscapes != null)
            {
                _writeSegmentCustom(j);
            } else
            if (_maximumNonEscapedChar != 0)
            {
                _writeSegmentASCII(j, _maximumNonEscapedChar);
            } else
            {
                _writeSegment(j);
            }
            j = i + j;
            i = j;
        } while (j < k);
    }

    private final void _writeNull()
        throws IOException
    {
        if (_outputTail + 4 >= _outputEnd)
        {
            _flushBuffer();
        }
        int i = _outputTail;
        char ac[] = _outputBuffer;
        ac[i] = 'n';
        i++;
        ac[i] = 'u';
        i++;
        ac[i] = 'l';
        i++;
        ac[i] = 'l';
        _outputTail = i + 1;
    }

    private final void _writeQuotedInt(int i)
        throws IOException
    {
        if (_outputTail + 13 >= _outputEnd)
        {
            _flushBuffer();
        }
        char ac[] = _outputBuffer;
        int j = _outputTail;
        _outputTail = j + 1;
        ac[j] = '"';
        _outputTail = NumberOutput.outputInt(i, _outputBuffer, _outputTail);
        ac = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        ac[i] = '"';
    }

    private final void _writeQuotedLong(long l)
        throws IOException
    {
        if (_outputTail + 23 >= _outputEnd)
        {
            _flushBuffer();
        }
        char ac[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        ac[i] = '"';
        _outputTail = NumberOutput.outputLong(l, _outputBuffer, _outputTail);
        ac = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        ac[i] = '"';
    }

    private final void _writeSegment(int i)
        throws IOException, JsonGenerationException
    {
        int ai[];
        int j;
        int k;
        int j1;
        ai = _outputEscapes;
        j1 = ai.length;
        j = 0;
        k = 0;
_L8:
        if (j >= i) goto _L2; else goto _L1
_L1:
        char c = _outputBuffer[j];
        if (c >= j1 || ai[c] == 0) goto _L4; else goto _L3
_L3:
        int l = j - k;
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        _writer.write(_outputBuffer, k, l);
        if (j < i)
        {
            break MISSING_BLOCK_LABEL_98;
        }
_L2:
        return;
_L4:
        int i1 = j + 1;
        j = i1;
        if (i1 < i)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i1;
        if (true) goto _L3; else goto _L5
_L5:
        if (true) goto _L1; else goto _L6
_L6:
        j++;
        k = _prependOrWriteCharacterEscape(_outputBuffer, j, i, c, ai[c]);
        if (true) goto _L8; else goto _L7
_L7:
    }

    private final void _writeSegmentASCII(int i, int j)
        throws IOException, JsonGenerationException
    {
        int ai[];
        int k;
        int l;
        int i1;
        int l1;
        ai = _outputEscapes;
        l1 = Math.min(ai.length, j + 1);
        l = 0;
        k = 0;
        i1 = 0;
_L12:
        if (l >= i) goto _L2; else goto _L1
_L1:
        int j1 = k;
_L10:
        char c = _outputBuffer[l];
        if (c >= l1) goto _L4; else goto _L3
_L3:
        j1 = ai[c];
        k = j1;
        if (j1 == 0) goto _L6; else goto _L5
_L5:
        k = j1;
_L8:
        j1 = l - i1;
        if (j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        _writer.write(_outputBuffer, i1, j1);
        if (l < i)
        {
            break MISSING_BLOCK_LABEL_145;
        }
_L2:
        return;
_L4:
        k = j1;
        if (c > j)
        {
            k = -1;
            continue; /* Loop/switch isn't completed */
        }
_L6:
        int k1 = l + 1;
        l = k1;
        j1 = k;
        if (k1 < i)
        {
            break; /* Loop/switch isn't completed */
        }
        l = k1;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
        l++;
        i1 = _prependOrWriteCharacterEscape(_outputBuffer, l, i, c, k);
        if (true) goto _L12; else goto _L11
_L11:
    }

    private final void _writeSegmentCustom(int i)
        throws IOException, JsonGenerationException
    {
        char c;
        CharacterEscapes characterescapes;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int ai[] = _outputEscapes;
        int l1;
        if (_maximumNonEscapedChar < 1)
        {
            l = 65535;
        } else
        {
            l = _maximumNonEscapedChar;
        }
        l1 = Math.min(ai.length, l + 1);
        characterescapes = _characterEscapes;
        k = 0;
        j = 0;
        i1 = 0;
_L12:
        if (k >= i) goto _L2; else goto _L1
_L1:
        j1 = j;
_L10:
        c = _outputBuffer[k];
        if (c >= l1) goto _L4; else goto _L3
_L3:
        j1 = ai[c];
        j = j1;
        if (j1 == 0) goto _L6; else goto _L5
_L5:
        j = j1;
_L8:
        j1 = k - i1;
        if (j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        _writer.write(_outputBuffer, i1, j1);
        if (k < i)
        {
            break MISSING_BLOCK_LABEL_197;
        }
_L2:
        return;
_L4:
        if (c > l)
        {
            j = -1;
            continue; /* Loop/switch isn't completed */
        }
        SerializableString serializablestring = characterescapes.getEscapeSequence(c);
        _currentEscape = serializablestring;
        j = j1;
        if (serializablestring != null)
        {
            j = -2;
            continue; /* Loop/switch isn't completed */
        }
_L6:
        int k1 = k + 1;
        k = k1;
        j1 = j;
        if (k1 < i)
        {
            break; /* Loop/switch isn't completed */
        }
        k = k1;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
        k++;
        i1 = _prependOrWriteCharacterEscape(_outputBuffer, k, i, c, j);
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void _writeString(String s)
        throws IOException, JsonGenerationException
    {
        int i = s.length();
        if (i > _outputEnd)
        {
            _writeLongString(s);
            return;
        }
        if (_outputTail + i > _outputEnd)
        {
            _flushBuffer();
        }
        s.getChars(0, i, _outputBuffer, _outputTail);
        if (_characterEscapes != null)
        {
            _writeStringCustom(i);
            return;
        }
        if (_maximumNonEscapedChar != 0)
        {
            _writeStringASCII(i, _maximumNonEscapedChar);
            return;
        } else
        {
            _writeString2(i);
            return;
        }
    }

    private void _writeString2(int i)
        throws IOException, JsonGenerationException
    {
        i = _outputTail + i;
        int ai[] = _outputEscapes;
        int j = ai.length;
label0:
        do
        {
            int k;
            if (_outputTail < i)
            {
                do
                {
                    k = _outputBuffer[_outputTail];
                    if (k < j && ai[k] != 0)
                    {
                        k = _outputTail - _outputHead;
                        if (k > 0)
                        {
                            _writer.write(_outputBuffer, _outputHead, k);
                        }
                        char ac[] = _outputBuffer;
                        k = _outputTail;
                        _outputTail = k + 1;
                        char c = ac[k];
                        _prependOrWriteCharacterEscape(c, ai[c]);
                        continue label0;
                    }
                    k = _outputTail + 1;
                    _outputTail = k;
                } while (k < i);
            }
            return;
        } while (true);
    }

    private void _writeStringASCII(int i, int j)
        throws IOException, JsonGenerationException
    {
        int ai[];
        int k;
        int l;
        k = _outputTail + i;
        ai = _outputEscapes;
        l = Math.min(ai.length, j + 1);
_L8:
        if (_outputTail >= k) goto _L2; else goto _L1
_L1:
        char c = _outputBuffer[_outputTail];
        if (c >= l) goto _L4; else goto _L3
_L3:
        i = ai[c];
        if (i == 0) goto _L6; else goto _L5
_L5:
        int i1 = _outputTail - _outputHead;
        if (i1 > 0)
        {
            _writer.write(_outputBuffer, _outputHead, i1);
        }
        _outputTail = _outputTail + 1;
        _prependOrWriteCharacterEscape(c, i);
        continue; /* Loop/switch isn't completed */
_L4:
        if (c <= j)
        {
            break; /* Loop/switch isn't completed */
        }
        i = -1;
        if (true) goto _L5; else goto _L6
_L6:
        i = _outputTail + 1;
        _outputTail = i;
        if (i < k) goto _L1; else goto _L2
_L2:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void _writeStringCustom(int i)
        throws IOException, JsonGenerationException
    {
        char c;
        CharacterEscapes characterescapes;
        int j;
        int k;
        k = _outputTail + i;
        int ai[] = _outputEscapes;
        int l;
        int i1;
        if (_maximumNonEscapedChar < 1)
        {
            j = 65535;
        } else
        {
            j = _maximumNonEscapedChar;
        }
        l = Math.min(ai.length, j + 1);
        characterescapes = _characterEscapes;
_L8:
        if (_outputTail >= k) goto _L2; else goto _L1
_L1:
        c = _outputBuffer[_outputTail];
        if (c >= l) goto _L4; else goto _L3
_L3:
        i = ai[c];
        if (i == 0) goto _L6; else goto _L5
_L5:
        i1 = _outputTail - _outputHead;
        if (i1 > 0)
        {
            _writer.write(_outputBuffer, _outputHead, i1);
        }
        _outputTail = _outputTail + 1;
        _prependOrWriteCharacterEscape(c, i);
        continue; /* Loop/switch isn't completed */
_L4:
        if (c > j)
        {
            i = -1;
            continue; /* Loop/switch isn't completed */
        }
        SerializableString serializablestring = characterescapes.getEscapeSequence(c);
        _currentEscape = serializablestring;
        if (serializablestring == null)
        {
            break; /* Loop/switch isn't completed */
        }
        i = -2;
        if (true) goto _L5; else goto _L6
_L6:
        i = _outputTail + 1;
        _outputTail = i;
        if (i < k) goto _L1; else goto _L2
_L2:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void writeRawLong(String s)
        throws IOException, JsonGenerationException
    {
        int i = _outputEnd - _outputTail;
        s.getChars(0, i, _outputBuffer, _outputTail);
        _outputTail = _outputTail + i;
        _flushBuffer();
        int j = i;
        int k;
        for (i = s.length() - i; i > _outputEnd; i -= k)
        {
            k = _outputEnd;
            s.getChars(j, j + k, _outputBuffer, 0);
            _outputHead = 0;
            _outputTail = k;
            _flushBuffer();
            j += k;
        }

        s.getChars(j, j + i, _outputBuffer, 0);
        _outputHead = 0;
        _outputTail = i;
    }

    protected final void _flushBuffer()
        throws IOException
    {
        int i = _outputTail - _outputHead;
        if (i > 0)
        {
            int j = _outputHead;
            _outputHead = 0;
            _outputTail = 0;
            _writer.write(_outputBuffer, j, i);
        }
    }

    protected void _releaseBuffers()
    {
        char ac[] = _outputBuffer;
        if (ac != null)
        {
            _outputBuffer = null;
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
        char c = ',';
_L7:
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        _outputBuffer[_outputTail] = c;
        _outputTail = _outputTail + 1;
        return;
_L5:
        c = ':';
        continue; /* Loop/switch isn't completed */
_L6:
        c = ' ';
        if (true) goto _L7; else goto _L2
_L2:
        _verifyPrettyValueWrite(s, i);
        return;
    }

    protected void _writeFieldName(String s, boolean flag)
        throws IOException, JsonGenerationException
    {
        if (_cfgPrettyPrinter != null)
        {
            _writePPFieldName(s, flag);
            return;
        }
        if (_outputTail + 1 >= _outputEnd)
        {
            _flushBuffer();
        }
        if (flag)
        {
            char ac[] = _outputBuffer;
            int i = _outputTail;
            _outputTail = i + 1;
            ac[i] = ',';
        }
        if (!isEnabled(org.codehaus.jackson.JsonGenerator.Feature.QUOTE_FIELD_NAMES))
        {
            _writeString(s);
            return;
        }
        char ac1[] = _outputBuffer;
        int j = _outputTail;
        _outputTail = j + 1;
        ac1[j] = '"';
        _writeString(s);
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        s = _outputBuffer;
        j = _outputTail;
        _outputTail = j + 1;
        s[j] = '"';
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
            char ac[] = _outputBuffer;
            int i = _outputTail;
            _outputTail = i + 1;
            ac[i] = '"';
            _writeString(s);
            if (_outputTail >= _outputEnd)
            {
                _flushBuffer();
            }
            s = _outputBuffer;
            i = _outputTail;
            _outputTail = i + 1;
            s[i] = '"';
            return;
        } else
        {
            _writeString(s);
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
        if (_writer == null) goto _L2; else goto _L1
_L1:
        if (!_ioContext.isResourceManaged() && !isEnabled(org.codehaus.jackson.JsonGenerator.Feature.AUTO_CLOSE_TARGET)) goto _L4; else goto _L3
_L3:
        _writer.close();
_L2:
        _releaseBuffers();
        return;
_L4:
        if (isEnabled(org.codehaus.jackson.JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))
        {
            _writer.flush();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final void flush()
        throws IOException
    {
        _flushBuffer();
        if (_writer != null && isEnabled(org.codehaus.jackson.JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))
        {
            _writer.flush();
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
        int i = _outputTail;
        char ac[] = _outputBuffer;
        if (flag)
        {
            ac[i] = 't';
            i++;
            ac[i] = 'r';
            i++;
            ac[i] = 'u';
            i++;
            ac[i] = 'e';
        } else
        {
            ac[i] = 'f';
            i++;
            ac[i] = 'a';
            i++;
            ac[i] = 'l';
            i++;
            ac[i] = 's';
            i++;
            ac[i] = 'e';
        }
        _outputTail = i + 1;
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
            char ac[] = _outputBuffer;
            int i = _outputTail;
            _outputTail = i + 1;
            ac[i] = ']';
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
            char ac[] = _outputBuffer;
            int i = _outputTail;
            _outputTail = i + 1;
            ac[i] = '}';
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
        if (i != 1)
        {
            flag = false;
        }
        _writeFieldName(s, flag);
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
        if (_cfgNumbersAsStrings)
        {
            _writeQuotedInt(i);
            return;
        }
        if (_outputTail + 11 >= _outputEnd)
        {
            _flushBuffer();
        }
        _outputTail = NumberOutput.outputInt(i, _outputBuffer, _outputTail);
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
        int k = s.length();
        int j = _outputEnd - _outputTail;
        int i = j;
        if (j == 0)
        {
            _flushBuffer();
            i = _outputEnd - _outputTail;
        }
        if (i >= k)
        {
            s.getChars(0, k, _outputBuffer, _outputTail);
            _outputTail = _outputTail + k;
            return;
        } else
        {
            writeRawLong(s);
            return;
        }
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
        char ac[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        ac[i] = '[';
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
        char ac[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        ac[i] = '{';
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
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        char ac[] = _outputBuffer;
        int i = _outputTail;
        _outputTail = i + 1;
        ac[i] = '"';
        _writeString(s);
        if (_outputTail >= _outputEnd)
        {
            _flushBuffer();
        }
        s = _outputBuffer;
        i = _outputTail;
        _outputTail = i + 1;
        s[i] = '"';
    }

}
