// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

// Referenced classes of package com.fasterxml.jackson.core.json:
//            JsonReadContext

public class ReaderBasedJsonParser extends ParserBase
{

    protected static final int _icLatin1[] = CharTypes.getInputCodeLatin1();
    protected boolean _bufferRecyclable;
    protected final int _hashSeed;
    protected char _inputBuffer[];
    protected ObjectCodec _objectCodec;
    protected Reader _reader;
    protected final CharsToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete;

    public ReaderBasedJsonParser(IOContext iocontext, int i, Reader reader, ObjectCodec objectcodec, CharsToNameCanonicalizer charstonamecanonicalizer)
    {
        super(iocontext, i);
        _tokenIncomplete = false;
        _reader = reader;
        _inputBuffer = iocontext.allocTokenBuffer();
        _inputPtr = 0;
        _inputEnd = 0;
        _objectCodec = objectcodec;
        _symbols = charstonamecanonicalizer;
        _hashSeed = charstonamecanonicalizer.hashSeed();
        _bufferRecyclable = true;
    }

    public ReaderBasedJsonParser(IOContext iocontext, int i, Reader reader, ObjectCodec objectcodec, CharsToNameCanonicalizer charstonamecanonicalizer, char ac[], int j, 
            int k, boolean flag)
    {
        super(iocontext, i);
        _tokenIncomplete = false;
        _reader = reader;
        _inputBuffer = ac;
        _inputPtr = j;
        _inputEnd = k;
        _objectCodec = objectcodec;
        _symbols = charstonamecanonicalizer;
        _hashSeed = charstonamecanonicalizer.hashSeed();
        _bufferRecyclable = flag;
    }

    private String _handleOddName2(int i, int j, int ai[])
    {
        char ac[];
        int i1;
        _textBuffer.resetWithShared(_inputBuffer, i, _inputPtr - i);
        ac = _textBuffer.getCurrentSegment();
        i = _textBuffer.getCurrentSegmentSize();
        i1 = ai.length;
_L5:
        if (_inputPtr < _inputEnd || loadMore()) goto _L2; else goto _L1
_L1:
        char c;
        _textBuffer.setCurrentLength(i);
        ai = _textBuffer;
        ac = ai.getTextBuffer();
        i = ai.getTextOffset();
        int k = ai.size();
        return _symbols.findSymbol(ac, i, k, j);
_L2:
        int l;
        if ((c = _inputBuffer[_inputPtr]) > i1 ? Character.isJavaIdentifierPart(c) : ai[c] == 0) goto _L3; else goto _L1
_L3:
        _inputPtr = _inputPtr + 1;
        j = j * 33 + c;
        l = i + 1;
        ac[i] = c;
        if (l >= ac.length)
        {
            ac = _textBuffer.finishCurrentSegment();
            i = 0;
        } else
        {
            i = l;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    private final void _matchFalse()
    {
        int i = _inputPtr;
        if (i + 4 < _inputEnd)
        {
            char ac[] = _inputBuffer;
            if (ac[i] == 'a')
            {
                i++;
                if (ac[i] == 'l')
                {
                    i++;
                    if (ac[i] == 's')
                    {
                        i++;
                        if (ac[i] == 'e')
                        {
                            i++;
                            char c = ac[i];
                            if (c < '0' || c == ']' || c == '}')
                            {
                                _inputPtr = i;
                                return;
                            }
                        }
                    }
                }
            }
        }
        _matchToken("false", 1);
    }

    private final void _matchNull()
    {
        int i = _inputPtr;
        if (i + 3 < _inputEnd)
        {
            char ac[] = _inputBuffer;
            if (ac[i] == 'u')
            {
                i++;
                if (ac[i] == 'l')
                {
                    i++;
                    if (ac[i] == 'l')
                    {
                        i++;
                        char c = ac[i];
                        if (c < '0' || c == ']' || c == '}')
                        {
                            _inputPtr = i;
                            return;
                        }
                    }
                }
            }
        }
        _matchToken("null", 1);
    }

    private final void _matchTrue()
    {
        int i = _inputPtr;
        if (i + 3 < _inputEnd)
        {
            char ac[] = _inputBuffer;
            if (ac[i] == 'r')
            {
                i++;
                if (ac[i] == 'u')
                {
                    i++;
                    if (ac[i] == 'e')
                    {
                        i++;
                        char c = ac[i];
                        if (c < '0' || c == ']' || c == '}')
                        {
                            _inputPtr = i;
                            return;
                        }
                    }
                }
            }
        }
        _matchToken("true", 1);
    }

    private final JsonToken _nextAfterName()
    {
        JsonToken jsontoken;
        _nameCopied = false;
        jsontoken = _nextToken;
        _nextToken = null;
        if (jsontoken != JsonToken.START_ARRAY) goto _L2; else goto _L1
_L1:
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
_L4:
        _currToken = jsontoken;
        return jsontoken;
_L2:
        if (jsontoken == JsonToken.START_OBJECT)
        {
            _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private final JsonToken _parseFloat(int i, int j, int k, boolean flag, int l)
    {
        int i1;
        int l1;
        boolean flag1;
        int k2;
        l1 = 0;
        flag1 = false;
        k2 = _inputEnd;
        if (i != 46)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        i = 0;
        i1 = k;
_L6:
        if (i1 >= k2)
        {
            return _parseNumber2(flag, j);
        }
        char ac[] = _inputBuffer;
        k = i1 + 1;
        i1 = ac[i1];
        if (i1 >= '0' && i1 <= '9') goto _L2; else goto _L1
_L1:
        int k1;
        if (i == 0)
        {
            reportUnexpectedNumberChar(i1, "Decimal point not followed by a digit");
        }
        k1 = i;
        i = k;
        k = i1;
_L7:
        if (k == 101) goto _L4; else goto _L3
_L3:
        int i2;
        int j2;
        j2 = i;
        i2 = k;
        if (k != 69) goto _L5; else goto _L4
_L2:
        i++;
        i1 = k;
          goto _L6
_L4:
        if (i >= k2)
        {
            _inputPtr = j;
            return _parseNumber2(flag, j);
        }
        char ac1[] = _inputBuffer;
        i1 = i + 1;
        k = ac1[i];
        if (k == 45 || k == 43)
        {
            if (i1 >= k2)
            {
                _inputPtr = j;
                return _parseNumber2(flag, j);
            }
            char ac2[] = _inputBuffer;
            i = i1 + 1;
            k = ac2[i1];
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i = i1;
            i1 = ((flag1) ? 1 : 0);
        }
        while (k <= 57 && k >= 48) 
        {
            i1++;
            if (i >= k2)
            {
                _inputPtr = j;
                return _parseNumber2(flag, j);
            }
            k = _inputBuffer[i];
            i++;
        }
        l1 = i1;
        j2 = i;
        i2 = k;
        if (i1 == 0)
        {
            reportUnexpectedNumberChar(k, "Exponent indicator not followed by a digit");
            i2 = k;
            j2 = i;
            l1 = i1;
        }
_L5:
        i = j2 - 1;
        _inputPtr = i;
        if (_parsingContext.inRoot())
        {
            _verifyRootSpace(i2);
        }
        _textBuffer.resetWithShared(_inputBuffer, j, i - j);
        return resetFloat(flag, l, k1, l1);
        k1 = 0;
        int j1 = i;
        i = k;
        k = j1;
          goto _L7
    }

    private String _parseName2(int i, int j, int k)
    {
        char ac[];
        _textBuffer.resetWithShared(_inputBuffer, i, _inputPtr - i);
        ac = _textBuffer.getCurrentSegment();
        i = _textBuffer.getCurrentSegmentSize();
_L3:
        char c1;
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOF((new StringBuilder()).append(": was expecting closing '").append((char)k).append("' for name").toString());
        }
        char ac1[] = _inputBuffer;
        int l = _inputPtr;
        _inputPtr = l + 1;
        c1 = ac1[l];
        if (c1 > '\\')
        {
            break MISSING_BLOCK_LABEL_243;
        }
        if (c1 != '\\') goto _L2; else goto _L1
_L1:
        char c = _decodeEscaped();
_L4:
        j = j * 33 + c1;
        int i1 = i + 1;
        ac[i] = c;
        TextBuffer textbuffer;
        char ac2[];
        if (i1 >= ac.length)
        {
            ac = _textBuffer.finishCurrentSegment();
            i = 0;
        } else
        {
            i = i1;
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (c1 <= k)
        {
            if (c1 == k)
            {
                _textBuffer.setCurrentLength(i);
                textbuffer = _textBuffer;
                ac2 = textbuffer.getTextBuffer();
                i = textbuffer.getTextOffset();
                k = textbuffer.size();
                return _symbols.findSymbol(ac2, i, k, j);
            }
            if (c1 < ' ')
            {
                _throwUnquotedSpace(c1, "name");
            }
        }
        c = c1;
          goto _L4
    }

    private final JsonToken _parseNumber2(boolean flag, int i)
    {
        int j = i;
        if (flag)
        {
            j = i + 1;
        }
        _inputPtr = j;
        char ac2[] = _textBuffer.emptyAndGetCurrentSegment();
        char c;
        char c1;
        char ac1[];
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        char c2;
        if (flag)
        {
            i = 1;
            ac2[0] = '-';
        } else
        {
            i = 0;
        }
        j = 0;
        if (_inputPtr < _inputEnd)
        {
            char ac[] = _inputBuffer;
            int k = _inputPtr;
            _inputPtr = k + 1;
            c = ac[k];
        } else
        {
            c = getNextChar("No digit following minus sign");
        }
        c1 = c;
        if (c == '0')
        {
            c1 = _verifyNoLeadingZeroes();
        }
        j1 = 0;
        c = c1;
        if (c < '0' || c > '9')
        {
            break MISSING_BLOCK_LABEL_890;
        }
        j++;
        i1 = i;
        ac1 = ac2;
        if (i >= ac2.length)
        {
            ac1 = _textBuffer.finishCurrentSegment();
            i1 = 0;
        }
        l = i1 + 1;
        ac1[i1] = c;
        if (_inputPtr < _inputEnd || loadMore()) goto _L2; else goto _L1
_L1:
        i = 1;
        c = '\0';
        i1 = j;
        j = l;
_L20:
        if (i1 == 0)
        {
            reportInvalidNumber((new StringBuilder()).append("Missing integer part (next char ").append(_getCharDesc(c)).append(")").toString());
        }
        l = 0;
        if (c != '.') goto _L4; else goto _L3
_L3:
        j1 = j + 1;
        ac1[j] = c;
        j = j1;
_L15:
        if (_inputPtr < _inputEnd || loadMore()) goto _L6; else goto _L5
_L5:
        i = 1;
_L13:
        if (l == 0)
        {
            reportUnexpectedNumberChar(c, "Decimal point not followed by a digit");
        }
        j1 = l;
        l = j;
        j = i;
        ac2 = ac1;
        i = l;
_L18:
        k1 = 0;
        if (c != 'e' && c != 'E') goto _L8; else goto _L7
_L7:
        l = i;
        ac1 = ac2;
        if (i >= ac2.length)
        {
            ac1 = _textBuffer.finishCurrentSegment();
            l = 0;
        }
        i = l + 1;
        ac1[l] = c;
        if (_inputPtr < _inputEnd)
        {
            ac2 = _inputBuffer;
            l = _inputPtr;
            _inputPtr = l + 1;
            c = ac2[l];
        } else
        {
            c = getNextChar("expected a digit for number exponent");
        }
        if (c == '-' || c == '+')
        {
            if (i >= ac1.length)
            {
                ac1 = _textBuffer.finishCurrentSegment();
                i = 0;
            }
            ac1[i] = c;
            if (_inputPtr < _inputEnd)
            {
                ac2 = _inputBuffer;
                l = _inputPtr;
                _inputPtr = l + 1;
                c = ac2[l];
            } else
            {
                c = getNextChar("expected a digit for number exponent");
            }
            i++;
            l = k1;
        } else
        {
            l = k1;
        }
        if (c > '9' || c < '0') goto _L10; else goto _L9
_L9:
        l++;
        k1 = i;
        ac2 = ac1;
        if (i >= ac1.length)
        {
            ac2 = _textBuffer.finishCurrentSegment();
            k1 = 0;
        }
        i = k1 + 1;
        ac2[k1] = c;
        if (_inputPtr < _inputEnd || loadMore()) goto _L12; else goto _L11
_L11:
        k1 = l;
        j = 1;
        l = i;
        i = k1;
_L16:
        k1 = i;
        l1 = j;
        c2 = c;
        i2 = l;
        if (i == 0)
        {
            reportUnexpectedNumberChar(c, "Exponent indicator not followed by a digit");
            i2 = l;
            c2 = c;
            l1 = j;
            k1 = i;
        }
_L17:
        if (l1 == 0)
        {
            _inputPtr = _inputPtr - 1;
            if (_parsingContext.inRoot())
            {
                _verifyRootSpace(c2);
            }
        }
        _textBuffer.setCurrentLength(i2);
        return reset(flag, i1, j1, k1);
_L2:
        ac2 = _inputBuffer;
        i = _inputPtr;
        _inputPtr = i + 1;
        c = ac2[i];
        i = l;
        ac2 = ac1;
        break MISSING_BLOCK_LABEL_100;
_L6:
        ac2 = _inputBuffer;
        j1 = _inputPtr;
        _inputPtr = j1 + 1;
        c = ac2[j1];
        if (c >= '0' && c <= '9') goto _L14; else goto _L13
_L14:
        l++;
        if (j >= ac1.length)
        {
            ac1 = _textBuffer.finishCurrentSegment();
            j = 0;
        }
        j1 = j + 1;
        ac1[j] = c;
        j = j1;
          goto _L15
_L12:
        ac1 = _inputBuffer;
        k1 = _inputPtr;
        _inputPtr = k1 + 1;
        c = ac1[k1];
        ac1 = ac2;
        break MISSING_BLOCK_LABEL_466;
_L10:
        k1 = i;
        i = l;
        l = k1;
          goto _L16
_L8:
        c2 = c;
        k1 = 0;
        l1 = j;
        i2 = i;
          goto _L17
_L4:
        j1 = 0;
        l = i;
        i = j;
        ac2 = ac1;
        j = l;
          goto _L18
        i1 = j;
        ac1 = ac2;
        j = i;
        i = j1;
        if (true) goto _L20; else goto _L19
_L19:
    }

    private final int _skipAfterComma2()
    {
        do
        {
            if (_inputPtr >= _inputEnd && !loadMore())
            {
                break;
            }
            char ac[] = _inputBuffer;
            int i = _inputPtr;
            _inputPtr = i + 1;
            i = ac[i];
            if (i > ' ')
            {
                if (i == '/')
                {
                    _skipComment();
                } else
                if (i != '#' || !_skipYAMLComment())
                {
                    return i;
                }
            } else
            if (i < ' ')
            {
                if (i == '\n')
                {
                    _currInputRow = _currInputRow + 1;
                    _currInputRowStart = _inputPtr;
                } else
                if (i == '\r')
                {
                    _skipCR();
                } else
                if (i != '\t')
                {
                    _throwInvalidSpace(i);
                }
            }
        } while (true);
        throw _constructError((new StringBuilder()).append("Unexpected end-of-input within/between ").append(_parsingContext.getTypeDesc()).append(" entries").toString());
    }

    private void _skipCComment()
    {
        do
        {
            int i;
label0:
            {
label1:
                {
                    if (_inputPtr < _inputEnd || loadMore())
                    {
                        char ac[] = _inputBuffer;
                        i = _inputPtr;
                        _inputPtr = i + 1;
                        i = ac[i];
                        if (i > '*')
                        {
                            continue;
                        }
                        if (i != '*')
                        {
                            break label0;
                        }
                        if (_inputPtr < _inputEnd || loadMore())
                        {
                            break label1;
                        }
                    }
                    _reportInvalidEOF(" in a comment");
                    return;
                }
                if (_inputBuffer[_inputPtr] == '/')
                {
                    _inputPtr = _inputPtr + 1;
                    return;
                }
                continue;
            }
            if (i < ' ')
            {
                if (i == '\n')
                {
                    _currInputRow = _currInputRow + 1;
                    _currInputRowStart = _inputPtr;
                } else
                if (i == '\r')
                {
                    _skipCR();
                } else
                if (i != '\t')
                {
                    _throwInvalidSpace(i);
                }
            }
        } while (true);
    }

    private final int _skipColon()
    {
        int k;
label0:
        {
            if (_inputPtr + 4 >= _inputEnd)
            {
                return _skipColon2(false);
            }
            char c = _inputBuffer[_inputPtr];
            if (c == ':')
            {
                char ac[] = _inputBuffer;
                int i = _inputPtr + 1;
                _inputPtr = i;
                i = ac[i];
                if (i > ' ')
                {
                    if (i == '/' || i == '#')
                    {
                        return _skipColon2(true);
                    } else
                    {
                        _inputPtr = _inputPtr + 1;
                        return i;
                    }
                }
                if (i == ' ' || i == '\t')
                {
                    char ac1[] = _inputBuffer;
                    int j = _inputPtr + 1;
                    _inputPtr = j;
                    j = ac1[j];
                    if (j > ' ')
                    {
                        if (j == '/' || j == '#')
                        {
                            return _skipColon2(true);
                        } else
                        {
                            _inputPtr = _inputPtr + 1;
                            return j;
                        }
                    }
                }
                return _skipColon2(true);
            }
            if (c != ' ')
            {
                k = c;
                if (c != '\t')
                {
                    break label0;
                }
            }
            char ac2[] = _inputBuffer;
            k = _inputPtr + 1;
            _inputPtr = k;
            k = ac2[k];
        }
        if (k == 58)
        {
            char ac3[] = _inputBuffer;
            int l = _inputPtr + 1;
            _inputPtr = l;
            l = ac3[l];
            if (l > ' ')
            {
                if (l == '/' || l == '#')
                {
                    return _skipColon2(true);
                } else
                {
                    _inputPtr = _inputPtr + 1;
                    return l;
                }
            }
            if (l == ' ' || l == '\t')
            {
                char ac4[] = _inputBuffer;
                int i1 = _inputPtr + 1;
                _inputPtr = i1;
                i1 = ac4[i1];
                if (i1 > ' ')
                {
                    if (i1 == '/' || i1 == '#')
                    {
                        return _skipColon2(true);
                    } else
                    {
                        _inputPtr = _inputPtr + 1;
                        return i1;
                    }
                }
            }
            return _skipColon2(true);
        } else
        {
            return _skipColon2(false);
        }
    }

    private final int _skipColon2(boolean flag)
    {
        do
        {
            if (_inputPtr >= _inputEnd)
            {
                loadMoreGuaranteed();
            }
            char ac[] = _inputBuffer;
            int i = _inputPtr;
            _inputPtr = i + 1;
            i = ac[i];
            if (i > ' ')
            {
                if (i == '/')
                {
                    _skipComment();
                } else
                if (i != '#' || !_skipYAMLComment())
                {
                    if (flag)
                    {
                        return i;
                    }
                    if (i != ':')
                    {
                        if (i < ' ')
                        {
                            _throwInvalidSpace(i);
                        }
                        _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
                    }
                    flag = true;
                }
            } else
            if (i < ' ')
            {
                if (i == '\n')
                {
                    _currInputRow = _currInputRow + 1;
                    _currInputRowStart = _inputPtr;
                } else
                if (i == '\r')
                {
                    _skipCR();
                } else
                if (i != '\t')
                {
                    _throwInvalidSpace(i);
                }
            }
        } while (true);
    }

    private final int _skipComma(int i)
    {
        if (i != 44)
        {
            _reportUnexpectedChar(i, (new StringBuilder()).append("was expecting comma to separate ").append(_parsingContext.getTypeDesc()).append(" entries").toString());
        }
label0:
        do
        {
            char c;
label1:
            {
label2:
                {
                    if (_inputPtr >= _inputEnd)
                    {
                        break label0;
                    }
                    char ac[] = _inputBuffer;
                    i = _inputPtr;
                    _inputPtr = i + 1;
                    c = ac[i];
                    if (c <= ' ')
                    {
                        break label1;
                    }
                    if (c != '/')
                    {
                        i = c;
                        if (c != '#')
                        {
                            break label2;
                        }
                    }
                    _inputPtr = _inputPtr - 1;
                    i = _skipAfterComma2();
                }
                return i;
            }
            if (c < ' ')
            {
                if (c == '\n')
                {
                    _currInputRow = _currInputRow + 1;
                    _currInputRowStart = _inputPtr;
                } else
                if (c == '\r')
                {
                    _skipCR();
                } else
                if (c != '\t')
                {
                    _throwInvalidSpace(c);
                }
            }
        } while (true);
        return _skipAfterComma2();
    }

    private void _skipComment()
    {
        if (!isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_COMMENTS))
        {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOF(" in a comment");
        }
        char ac[] = _inputBuffer;
        int i = _inputPtr;
        _inputPtr = i + 1;
        i = ac[i];
        if (i == '/')
        {
            _skipLine();
            return;
        }
        if (i == '*')
        {
            _skipCComment();
            return;
        } else
        {
            _reportUnexpectedChar(i, "was expecting either '*' or '/' for a comment");
            return;
        }
    }

    private void _skipLine()
    {
        do
        {
            int i;
label0:
            {
                if (_inputPtr < _inputEnd || loadMore())
                {
                    char ac[] = _inputBuffer;
                    i = _inputPtr;
                    _inputPtr = i + 1;
                    i = ac[i];
                    if (i >= ' ')
                    {
                        continue;
                    }
                    if (i != '\n')
                    {
                        break label0;
                    }
                    _currInputRow = _currInputRow + 1;
                    _currInputRowStart = _inputPtr;
                }
                return;
            }
            if (i == '\r')
            {
                _skipCR();
                return;
            }
            if (i != '\t')
            {
                _throwInvalidSpace(i);
            }
        } while (true);
    }

    private final int _skipWSOrEnd()
    {
        if (_inputPtr < _inputEnd || loadMore()) goto _L2; else goto _L1
_L1:
        int i = _eofAsNextChar();
_L4:
        return i;
_L2:
        char c;
        char ac[] = _inputBuffer;
        i = _inputPtr;
        _inputPtr = i + 1;
        c = ac[i];
        if (c <= ' ')
        {
            break MISSING_BLOCK_LABEL_81;
        }
        if (c == '/')
        {
            break; /* Loop/switch isn't completed */
        }
        i = c;
        if (c != '#') goto _L4; else goto _L3
_L3:
        _inputPtr = _inputPtr - 1;
        return _skipWSOrEnd2();
        char ac1[];
        if (c != ' ')
        {
            if (c == '\n')
            {
                _currInputRow = _currInputRow + 1;
                _currInputRowStart = _inputPtr;
            } else
            if (c == '\r')
            {
                _skipCR();
            } else
            if (c != '\t')
            {
                _throwInvalidSpace(c);
            }
        }
_L6:
        if (_inputPtr >= _inputEnd)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        ac1 = _inputBuffer;
        i = _inputPtr;
        _inputPtr = i + 1;
        c = ac1[i];
        if (c <= ' ')
        {
            break MISSING_BLOCK_LABEL_205;
        }
        if (c == '/')
        {
            break; /* Loop/switch isn't completed */
        }
        i = c;
        if (c != '#') goto _L4; else goto _L5
_L5:
        _inputPtr = _inputPtr - 1;
        return _skipWSOrEnd2();
        if (c != ' ')
        {
            if (c == '\n')
            {
                _currInputRow = _currInputRow + 1;
                _currInputRowStart = _inputPtr;
            } else
            if (c == '\r')
            {
                _skipCR();
            } else
            if (c != '\t')
            {
                _throwInvalidSpace(c);
            }
        }
          goto _L6
        return _skipWSOrEnd2();
    }

    private int _skipWSOrEnd2()
    {
_L7:
        if (_inputPtr < _inputEnd || loadMore()) goto _L2; else goto _L1
_L1:
        int i = _eofAsNextChar();
_L4:
        return i;
_L2:
        char c;
        char ac[] = _inputBuffer;
        i = _inputPtr;
        _inputPtr = i + 1;
        c = ac[i];
        if (c <= ' ')
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (c == '/')
        {
            _skipComment();
            break; /* Loop/switch isn't completed */
        }
        i = c;
        if (c != '#') goto _L4; else goto _L3
_L3:
        i = c;
        if (!_skipYAMLComment()) goto _L4; else goto _L5
_L5:
        continue; /* Loop/switch isn't completed */
        if (c != ' ')
        {
            if (c == '\n')
            {
                _currInputRow = _currInputRow + 1;
                _currInputRowStart = _inputPtr;
            } else
            if (c == '\r')
            {
                _skipCR();
            } else
            if (c != '\t')
            {
                _throwInvalidSpace(c);
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private boolean _skipYAMLComment()
    {
        if (!isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_YAML_COMMENTS))
        {
            return false;
        } else
        {
            _skipLine();
            return true;
        }
    }

    private char _verifyNLZ2()
    {
        if (_inputPtr < _inputEnd || loadMore()) goto _L2; else goto _L1
_L1:
        char c = '0';
_L4:
        return c;
_L2:
        char c1;
        c1 = _inputBuffer[_inputPtr];
        if (c1 < '0' || c1 > '9')
        {
            return '0';
        }
        if (!isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS))
        {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        _inputPtr = _inputPtr + 1;
        c = c1;
        if (c1 != '0')
        {
            continue; /* Loop/switch isn't completed */
        }
        c = c1;
        do
        {
            if (_inputPtr >= _inputEnd && !loadMore())
            {
                continue; /* Loop/switch isn't completed */
            }
            c1 = _inputBuffer[_inputPtr];
            if (c1 < '0' || c1 > '9')
            {
                return '0';
            }
            _inputPtr = _inputPtr + 1;
            c = c1;
        } while (c1 == '0');
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        return c1;
    }

    private final char _verifyNoLeadingZeroes()
    {
        if (_inputPtr < _inputEnd)
        {
            char c = _inputBuffer[_inputPtr];
            if (c < '0' || c > '9')
            {
                return '0';
            }
        }
        return _verifyNLZ2();
    }

    private final void _verifyRootSpace(int i)
    {
        _inputPtr = _inputPtr + 1;
        switch (i)
        {
        default:
            _reportMissingRootWS(i);
            // fall through

        case 9: // '\t'
        case 32: // ' '
            return;

        case 13: // '\r'
            _skipCR();
            return;

        case 10: // '\n'
            _currInputRow = _currInputRow + 1;
            _currInputRowStart = _inputPtr;
            return;
        }
    }

    protected void _closeInput()
    {
        if (_reader != null)
        {
            if (_ioContext.isResourceManaged() || isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.AUTO_CLOSE_SOURCE))
            {
                _reader.close();
            }
            _reader = null;
        }
    }

    protected byte[] _decodeBase64(Base64Variant base64variant)
    {
        ByteArrayBuilder bytearraybuilder = _getByteArrayBuilder();
        do
        {
            char c;
            do
            {
                if (_inputPtr >= _inputEnd)
                {
                    loadMoreGuaranteed();
                }
                char ac[] = _inputBuffer;
                int i = _inputPtr;
                _inputPtr = i + 1;
                c = ac[i];
            } while (c <= ' ');
            int l = base64variant.decodeBase64Char(c);
            int j = l;
            if (l < 0)
            {
                if (c == '"')
                {
                    return bytearraybuilder.toByteArray();
                }
                j = _decodeBase64Escape(base64variant, c, 0);
                if (j < 0)
                {
                    continue;
                }
            }
            if (_inputPtr >= _inputEnd)
            {
                loadMoreGuaranteed();
            }
            char ac1[] = _inputBuffer;
            l = _inputPtr;
            _inputPtr = l + 1;
            c = ac1[l];
            int i1 = base64variant.decodeBase64Char(c);
            l = i1;
            if (i1 < 0)
            {
                l = _decodeBase64Escape(base64variant, c, 1);
            }
            int j1 = l | j << 6;
            if (_inputPtr >= _inputEnd)
            {
                loadMoreGuaranteed();
            }
            ac1 = _inputBuffer;
            j = _inputPtr;
            _inputPtr = j + 1;
            c = ac1[j];
            l = base64variant.decodeBase64Char(c);
            i1 = l;
            if (l < 0)
            {
                j = l;
                if (l != -2)
                {
                    if (c == '"' && !base64variant.usesPadding())
                    {
                        bytearraybuilder.append(j1 >> 4);
                        return bytearraybuilder.toByteArray();
                    }
                    j = _decodeBase64Escape(base64variant, c, 2);
                }
                i1 = j;
                if (j == -2)
                {
                    if (_inputPtr >= _inputEnd)
                    {
                        loadMoreGuaranteed();
                    }
                    ac1 = _inputBuffer;
                    j = _inputPtr;
                    _inputPtr = j + 1;
                    c = ac1[j];
                    if (!base64variant.usesPaddingChar(c))
                    {
                        throw reportInvalidBase64Char(base64variant, c, 3, (new StringBuilder()).append("expected padding character '").append(base64variant.getPaddingChar()).append("'").toString());
                    }
                    bytearraybuilder.append(j1 >> 4);
                    continue;
                }
            }
            j1 = j1 << 6 | i1;
            if (_inputPtr >= _inputEnd)
            {
                loadMoreGuaranteed();
            }
            ac1 = _inputBuffer;
            j = _inputPtr;
            _inputPtr = j + 1;
            c = ac1[j];
            l = base64variant.decodeBase64Char(c);
            i1 = l;
            if (l < 0)
            {
                int k = l;
                if (l != -2)
                {
                    if (c == '"' && !base64variant.usesPadding())
                    {
                        bytearraybuilder.appendTwoBytes(j1 >> 2);
                        return bytearraybuilder.toByteArray();
                    }
                    k = _decodeBase64Escape(base64variant, c, 3);
                }
                i1 = k;
                if (k == -2)
                {
                    bytearraybuilder.appendTwoBytes(j1 >> 2);
                    continue;
                }
            }
            bytearraybuilder.appendThreeBytes(i1 | j1 << 6);
        } while (true);
    }

    protected char _decodeEscaped()
    {
        int j = 0;
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOF(" in character escape sequence");
        }
        char ac[] = _inputBuffer;
        int i = _inputPtr;
        _inputPtr = i + 1;
        char c1 = ac[i];
        char c = c1;
        switch (c1)
        {
        default:
            c = _handleUnrecognizedCharacterEscape(c1);
            // fall through

        case 34: // '"'
        case 47: // '/'
        case 92: // '\\'
            return c;

        case 98: // 'b'
            return '\b';

        case 116: // 't'
            return '\t';

        case 110: // 'n'
            return '\n';

        case 102: // 'f'
            return '\f';

        case 114: // 'r'
            return '\r';

        case 117: // 'u'
            i = 0;
            break;
        }
        for (; i < 4; i++)
        {
            if (_inputPtr >= _inputEnd && !loadMore())
            {
                _reportInvalidEOF(" in character escape sequence");
            }
            char ac1[] = _inputBuffer;
            int k = _inputPtr;
            _inputPtr = k + 1;
            k = ac1[k];
            int l = CharTypes.charToHex(k);
            if (l < 0)
            {
                _reportUnexpectedChar(k, "expected a hex-digit for character escape sequence");
            }
            j = j << 4 | l;
        }

        return (char)j;
    }

    protected final void _finishString()
    {
        int i = _inputPtr;
        int k = _inputEnd;
        int j = i;
        if (i < k)
        {
            int ai[] = _icLatin1;
            int l = ai.length;
            do
            {
                char c = _inputBuffer[i];
                if (c < l && ai[c] != 0)
                {
                    j = i;
                    if (c == '"')
                    {
                        _textBuffer.resetWithShared(_inputBuffer, _inputPtr, i - _inputPtr);
                        _inputPtr = i + 1;
                        return;
                    }
                    break;
                }
                j = i + 1;
                i = j;
            } while (j < k);
        }
        _textBuffer.resetWithCopy(_inputBuffer, _inputPtr, j - _inputPtr);
        _inputPtr = j;
        _finishString2();
    }

    protected void _finishString2()
    {
        char ac[];
        int ai[];
        int i;
        int l;
        ac = _textBuffer.getCurrentSegment();
        i = _textBuffer.getCurrentSegmentSize();
        ai = _icLatin1;
        l = ai.length;
_L2:
        char c;
        char c1;
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOF(": was expecting closing quote for a string value");
        }
        char ac1[] = _inputBuffer;
        int j = _inputPtr;
        _inputPtr = j + 1;
        c1 = ac1[j];
        c = c1;
        if (c1 < l)
        {
            c = c1;
            if (ai[c1] != 0)
            {
                if (c1 == '"')
                {
                    _textBuffer.setCurrentLength(i);
                    return;
                }
                if (c1 != '\\')
                {
                    break; /* Loop/switch isn't completed */
                }
                c = _decodeEscaped();
            }
        }
_L3:
        if (i >= ac.length)
        {
            ac = _textBuffer.finishCurrentSegment();
            i = 0;
        }
        int k = i + 1;
        ac[i] = c;
        i = k;
        if (true) goto _L2; else goto _L1
_L1:
        c = c1;
        if (c1 < ' ')
        {
            _throwUnquotedSpace(c1, "string value");
            c = c1;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    protected final String _getText2(JsonToken jsontoken)
    {
        if (jsontoken == null)
        {
            return null;
        }
        switch (jsontoken.id())
        {
        default:
            return jsontoken.asString();

        case 5: // '\005'
            return _parsingContext.getCurrentName();

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            return _textBuffer.contentsAsString();
        }
    }

    protected JsonToken _handleApos()
    {
        char ac[];
        int i;
        ac = _textBuffer.emptyAndGetCurrentSegment();
        i = _textBuffer.getCurrentSegmentSize();
_L2:
        char c;
        char c1;
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOF(": was expecting closing quote for a string value");
        }
        char ac1[] = _inputBuffer;
        int j = _inputPtr;
        _inputPtr = j + 1;
        c1 = ac1[j];
        c = c1;
        if (c1 <= '\\')
        {
            if (c1 != '\\')
            {
                break; /* Loop/switch isn't completed */
            }
            c = _decodeEscaped();
        }
_L3:
        if (i >= ac.length)
        {
            ac = _textBuffer.finishCurrentSegment();
            i = 0;
        }
        int k = i + 1;
        ac[i] = c;
        i = k;
        if (true) goto _L2; else goto _L1
_L1:
        c = c1;
        if (c1 <= '\'')
        {
            if (c1 == '\'')
            {
                _textBuffer.setCurrentLength(i);
                return JsonToken.VALUE_STRING;
            }
            c = c1;
            if (c1 < ' ')
            {
                _throwUnquotedSpace(c1, "string value");
                c = c1;
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    protected JsonToken _handleInvalidNumberStart(int i, boolean flag)
    {
        double d;
        int j;
        d = (-1.0D / 0.0D);
        j = i;
        if (i != 73) goto _L2; else goto _L1
_L1:
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOFInValue();
        }
        char ac[] = _inputBuffer;
        i = _inputPtr;
        _inputPtr = i + 1;
        i = ac[i];
        if (i != 78) goto _L4; else goto _L3
_L3:
        String s;
        if (flag)
        {
            s = "-INF";
        } else
        {
            s = "+INF";
        }
        _matchToken(s, 3);
        if (isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
        {
            if (!flag)
            {
                d = (1.0D / 0.0D);
            }
            return resetAsNaN(s, d);
        }
        _reportError((new StringBuilder()).append("Non-standard token '").append(s).append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow").toString());
        j = i;
_L2:
        reportUnexpectedNumberChar(j, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
_L4:
        j = i;
        if (i == 110)
        {
            String s1;
            if (flag)
            {
                s1 = "-Infinity";
            } else
            {
                s1 = "+Infinity";
            }
            _matchToken(s1, 3);
            if (isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
            {
                if (!flag)
                {
                    d = (1.0D / 0.0D);
                }
                return resetAsNaN(s1, d);
            }
            _reportError((new StringBuilder()).append("Non-standard token '").append(s1).append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow").toString());
            j = i;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected String _handleOddName(int i)
    {
        if (i == 39 && isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES))
        {
            return _parseAposName();
        }
        if (!isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES))
        {
            _reportUnexpectedChar(i, "was expecting double-quote to start field name");
        }
        int ai[] = CharTypes.getInputCodeLatin1JsNames();
        int i1 = ai.length;
        int j;
        int k;
        int l;
        int j1;
        boolean flag;
        if (i < i1)
        {
            if (ai[i] == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = Character.isJavaIdentifierPart((char)i);
        }
        if (!flag)
        {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        l = _inputPtr;
        j = _hashSeed;
        j1 = _inputEnd;
        k = j;
        i = l;
        if (l < j1)
        {
            i = l;
            do
            {
                k = _inputBuffer[i];
                if (k < i1)
                {
                    if (ai[k] != 0)
                    {
                        k = _inputPtr - 1;
                        _inputPtr = i;
                        return _symbols.findSymbol(_inputBuffer, k, i - k, j);
                    }
                } else
                if (!Character.isJavaIdentifierPart((char)k))
                {
                    k = _inputPtr - 1;
                    _inputPtr = i;
                    return _symbols.findSymbol(_inputBuffer, k, i - k, j);
                }
                k = j * 33 + k;
                l = i + 1;
                j = k;
                i = l;
            } while (l < j1);
            i = l;
        }
        j = _inputPtr;
        _inputPtr = i;
        return _handleOddName2(j - 1, k, ai);
    }

    protected JsonToken _handleOddValue(int i)
    {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   39: 89
    //                   43: 182
    //                   73: 143
    //                   78: 104;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (Character.isJavaIdentifierStart(i))
        {
            _reportInvalidToken((new StringBuilder()).append("").append((char)i).toString(), "('true', 'false' or 'null')");
        }
        _reportUnexpectedChar(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
_L2:
        if (isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES))
        {
            return _handleApos();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        _matchToken("NaN", 1);
        if (isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
        {
            return resetAsNaN("NaN", (0.0D / 0.0D));
        }
        _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        continue; /* Loop/switch isn't completed */
_L4:
        _matchToken("Infinity", 1);
        if (isEnabled(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
        {
            return resetAsNaN("Infinity", (1.0D / 0.0D));
        }
        _reportError("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        if (true) goto _L1; else goto _L3
_L3:
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOFInValue();
        }
        char ac[] = _inputBuffer;
        i = _inputPtr;
        _inputPtr = i + 1;
        return _handleInvalidNumberStart(ac[i], false);
    }

    protected final void _matchToken(String s, int i)
    {
        int k = s.length();
        int j;
        do
        {
            if (_inputPtr >= _inputEnd && !loadMore())
            {
                _reportInvalidToken(s.substring(0, i));
            }
            if (_inputBuffer[_inputPtr] != s.charAt(i))
            {
                _reportInvalidToken(s.substring(0, i));
            }
            _inputPtr = _inputPtr + 1;
            j = i + 1;
            i = j;
        } while (j < k);
        char c;
        if (_inputPtr < _inputEnd || loadMore())
        {
            if ((c = _inputBuffer[_inputPtr]) >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c))
            {
                _reportInvalidToken(s.substring(0, j));
                return;
            }
        }
    }

    protected String _parseAposName()
    {
        int i;
        int j;
        int k;
        int i1;
        int k1;
        i1 = _inputPtr;
        k = _hashSeed;
        k1 = _inputEnd;
        i = k;
        j = i1;
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        int ai[];
        int l1;
        ai = _icLatin1;
        l1 = ai.length;
        j = i1;
        i = k;
_L4:
        int l = _inputBuffer[j];
        if (l == 39)
        {
            l = _inputPtr;
            _inputPtr = j + 1;
            return _symbols.findSymbol(_inputBuffer, l, j - l, i);
        }
        if (l >= l1 || ai[l] == 0)
        {
            int j1 = i * 33 + l;
            l = j + 1;
            i = j1;
            j = l;
            if (l < k1)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = j1;
            j = l;
        }
_L2:
        l = _inputPtr;
        _inputPtr = j;
        return _parseName2(l, i, 39);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final String _parseName()
    {
        int i = _inputPtr;
        int j = _hashSeed;
        int ai[] = _icLatin1;
        do
        {
            if (i >= _inputEnd)
            {
                break;
            }
            int k = _inputBuffer[i];
            if (k < ai.length && ai[k] != 0)
            {
                if (k == 34)
                {
                    k = _inputPtr;
                    _inputPtr = i + 1;
                    return _symbols.findSymbol(_inputBuffer, k, i - k, j);
                }
                break;
            }
            j = j * 33 + k;
            i++;
        } while (true);
        int l = _inputPtr;
        _inputPtr = i;
        return _parseName2(l, j, 34);
    }

    protected final JsonToken _parseNegNumber()
    {
        int i = _inputPtr;
        int l = i - 1;
        int i1 = _inputEnd;
        if (i >= i1)
        {
            return _parseNumber2(true, l);
        }
        char ac[] = _inputBuffer;
        int j = i + 1;
        i = ac[i];
        if (i > '9' || i < '0')
        {
            _inputPtr = j;
            return _handleInvalidNumberStart(i, true);
        }
        if (i == '0')
        {
            return _parseNumber2(true, l);
        }
        i = 1;
        int k;
        do
        {
            if (j >= i1)
            {
                return _parseNumber2(true, l);
            }
            char ac1[] = _inputBuffer;
            k = j + 1;
            j = ac1[j];
            if (j < '0' || j > '9')
            {
                if (j == '.' || j == 'e' || j == 'E')
                {
                    _inputPtr = k;
                    return _parseFloat(j, l, k, true, i);
                }
                break;
            }
            i++;
            j = k;
        } while (true);
        k--;
        _inputPtr = k;
        if (_parsingContext.inRoot())
        {
            _verifyRootSpace(j);
        }
        _textBuffer.resetWithShared(_inputBuffer, l, k - l);
        return resetInt(true, i);
    }

    protected final JsonToken _parsePosNumber(int i)
    {
        int j = _inputPtr;
        int l = j - 1;
        int i1 = _inputEnd;
        if (i == 48)
        {
            return _parseNumber2(false, l);
        }
        i = 1;
        int k;
        do
        {
            if (j >= i1)
            {
                _inputPtr = l;
                return _parseNumber2(false, l);
            }
            char ac[] = _inputBuffer;
            k = j + 1;
            j = ac[j];
            if (j < '0' || j > '9')
            {
                if (j == '.' || j == 'e' || j == 'E')
                {
                    _inputPtr = k;
                    return _parseFloat(j, l, k, false, i);
                }
                break;
            }
            i++;
            j = k;
        } while (true);
        k--;
        _inputPtr = k;
        if (_parsingContext.inRoot())
        {
            _verifyRootSpace(j);
        }
        _textBuffer.resetWithShared(_inputBuffer, l, k - l);
        return resetInt(false, i);
    }

    protected int _readBinary(Base64Variant base64variant, OutputStream outputstream, byte abyte0[])
    {
        int i;
        int j;
        int k1;
        k1 = abyte0.length;
        j = 0;
        i = 0;
_L8:
        char c;
        int l;
        int i1;
        do
        {
            if (_inputPtr >= _inputEnd)
            {
                loadMoreGuaranteed();
            }
            char ac[] = _inputBuffer;
            int k = _inputPtr;
            _inputPtr = k + 1;
            c = ac[k];
        } while (c <= ' ');
        l = base64variant.decodeBase64Char(c);
        i1 = l;
        if (l >= 0) goto _L2; else goto _L1
_L1:
        if (c != '"') goto _L4; else goto _L3
_L3:
        l = i;
        i = j;
_L6:
        _tokenIncomplete = false;
        j = i;
        if (l > 0)
        {
            j = i + l;
            outputstream.write(abyte0, 0, l);
        }
        return j;
_L4:
        i1 = _decodeBase64Escape(base64variant, c, 0);
        if (i1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        char c1;
        char ac1[];
        int j1;
        int l1;
        if (i > k1 - 3)
        {
            j += i;
            outputstream.write(abyte0, 0, i);
            l = 0;
            i = j;
        } else
        {
            l = i;
            i = j;
        }
        if (_inputPtr >= _inputEnd)
        {
            loadMoreGuaranteed();
        }
        ac1 = _inputBuffer;
        j = _inputPtr;
        _inputPtr = j + 1;
        c1 = ac1[j];
        j1 = base64variant.decodeBase64Char(c1);
        j = j1;
        if (j1 < 0)
        {
            j = _decodeBase64Escape(base64variant, c1, 1);
        }
        l1 = i1 << 6 | j;
        if (_inputPtr >= _inputEnd)
        {
            loadMoreGuaranteed();
        }
        ac1 = _inputBuffer;
        j = _inputPtr;
        _inputPtr = j + 1;
        c1 = ac1[j];
        i1 = base64variant.decodeBase64Char(c1);
        j1 = i1;
        if (i1 < 0)
        {
            j = i1;
            if (i1 != -2)
            {
                if (c1 == '"' && !base64variant.usesPadding())
                {
                    j = l + 1;
                    abyte0[l] = (byte)(l1 >> 4);
                    l = j;
                    continue; /* Loop/switch isn't completed */
                }
                j = _decodeBase64Escape(base64variant, c1, 2);
            }
            j1 = j;
            if (j == -2)
            {
                if (_inputPtr >= _inputEnd)
                {
                    loadMoreGuaranteed();
                }
                ac1 = _inputBuffer;
                j = _inputPtr;
                _inputPtr = j + 1;
                c1 = ac1[j];
                if (!base64variant.usesPaddingChar(c1))
                {
                    throw reportInvalidBase64Char(base64variant, c1, 3, (new StringBuilder()).append("expected padding character '").append(base64variant.getPaddingChar()).append("'").toString());
                }
                i1 = l + 1;
                abyte0[l] = (byte)(l1 >> 4);
                j = i;
                i = i1;
                continue; /* Loop/switch isn't completed */
            }
        }
        l1 = l1 << 6 | j1;
        if (_inputPtr >= _inputEnd)
        {
            loadMoreGuaranteed();
        }
        ac1 = _inputBuffer;
        j = _inputPtr;
        _inputPtr = j + 1;
        c1 = ac1[j];
        i1 = base64variant.decodeBase64Char(c1);
        j1 = i1;
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_689;
        }
        j = i1;
        if (i1 == -2)
        {
            break MISSING_BLOCK_LABEL_632;
        }
        if (c1 != '"' || base64variant.usesPadding())
        {
            break; /* Loop/switch isn't completed */
        }
        j = l1 >> 2;
        i1 = l + 1;
        abyte0[l] = (byte)(j >> 8);
        l = i1 + 1;
        abyte0[i1] = (byte)j;
        if (true) goto _L6; else goto _L5
_L5:
        j = _decodeBase64Escape(base64variant, c1, 3);
        j1 = j;
        if (j == -2)
        {
            j = l1 >> 2;
            i1 = l + 1;
            abyte0[l] = (byte)(j >> 8);
            l = i1 + 1;
            abyte0[i1] = (byte)j;
            j = i;
            i = l;
            continue; /* Loop/switch isn't completed */
        }
        j = l1 << 6 | j1;
        i1 = l + 1;
        abyte0[l] = (byte)(j >> 16);
        j1 = i1 + 1;
        abyte0[i1] = (byte)(j >> 8);
        l = j1 + 1;
        abyte0[j1] = (byte)j;
        j = i;
        i = l;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void _releaseBuffers()
    {
        super._releaseBuffers();
        _symbols.release();
        if (_bufferRecyclable)
        {
            char ac[] = _inputBuffer;
            if (ac != null)
            {
                _inputBuffer = null;
                _ioContext.releaseTokenBuffer(ac);
            }
        }
    }

    protected void _reportInvalidToken(String s)
    {
        _reportInvalidToken(s, "'null', 'true', 'false' or NaN");
    }

    protected void _reportInvalidToken(String s, String s1)
    {
        s = new StringBuilder(s);
_L5:
        if (_inputPtr < _inputEnd || loadMore()) goto _L2; else goto _L1
_L1:
        char c;
        _reportError((new StringBuilder()).append("Unrecognized token '").append(s.toString()).append("': was expecting ").append(s1).toString());
        return;
_L2:
        if (!Character.isJavaIdentifierPart(c = _inputBuffer[_inputPtr])) goto _L1; else goto _L3
_L3:
        _inputPtr = _inputPtr + 1;
        s.append(c);
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected final void _skipCR()
    {
        if ((_inputPtr < _inputEnd || loadMore()) && _inputBuffer[_inputPtr] == '\n')
        {
            _inputPtr = _inputPtr + 1;
        }
        _currInputRow = _currInputRow + 1;
        _currInputRowStart = _inputPtr;
    }

    protected final void _skipString()
    {
        _tokenIncomplete = false;
        int i = _inputPtr;
        int j = _inputEnd;
        char ac[] = _inputBuffer;
        do
        {
            int k = j;
            int l = i;
            if (i >= j)
            {
                _inputPtr = i;
                if (!loadMore())
                {
                    _reportInvalidEOF(": was expecting closing quote for a string value");
                }
                l = _inputPtr;
                k = _inputEnd;
            }
            i = l + 1;
            j = ac[l];
            if (j <= '\\')
            {
                if (j == '\\')
                {
                    _inputPtr = i;
                    _decodeEscaped();
                    i = _inputPtr;
                    j = _inputEnd;
                    continue;
                }
                if (j <= 34)
                {
                    if (j == 34)
                    {
                        _inputPtr = i;
                        return;
                    }
                    if (j < 32)
                    {
                        _inputPtr = i;
                        _throwUnquotedSpace(j, "string value");
                    }
                }
            }
            j = k;
        } while (true);
    }

    public byte[] getBinaryValue(Base64Variant base64variant)
    {
        if (_currToken != JsonToken.VALUE_STRING && (_currToken != JsonToken.VALUE_EMBEDDED_OBJECT || _binaryValue == null))
        {
            _reportError((new StringBuilder()).append("Current token (").append(_currToken).append(") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary").toString());
        }
        if (!_tokenIncomplete) goto _L2; else goto _L1
_L1:
        try
        {
            _binaryValue = _decodeBase64(base64variant);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw _constructError((new StringBuilder()).append("Failed to decode VALUE_STRING as base64 (").append(base64variant).append("): ").append(illegalargumentexception.getMessage()).toString());
        }
        _tokenIncomplete = false;
_L4:
        return _binaryValue;
_L2:
        if (_binaryValue == null)
        {
            ByteArrayBuilder bytearraybuilder = _getByteArrayBuilder();
            _decodeBase64(getText(), bytearraybuilder, base64variant);
            _binaryValue = bytearraybuilder.toByteArray();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ObjectCodec getCodec()
    {
        return _objectCodec;
    }

    protected char getNextChar(String s)
    {
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOF(s);
        }
        s = _inputBuffer;
        int i = _inputPtr;
        _inputPtr = i + 1;
        return s[i];
    }

    public final String getText()
    {
        JsonToken jsontoken = _currToken;
        if (jsontoken == JsonToken.VALUE_STRING)
        {
            if (_tokenIncomplete)
            {
                _tokenIncomplete = false;
                _finishString();
            }
            return _textBuffer.contentsAsString();
        } else
        {
            return _getText2(jsontoken);
        }
    }

    public final char[] getTextCharacters()
    {
        if (_currToken == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        _currToken.id();
        JVM INSTR tableswitch 5 8: default 44
    //                   5 52
    //                   6 131
    //                   7 147
    //                   8 147;
           goto _L1 _L2 _L3 _L4 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        return _currToken.asCharArray();
_L2:
        if (_nameCopied) goto _L6; else goto _L5
_L5:
        String s;
        int i;
        s = _parsingContext.getCurrentName();
        i = s.length();
        if (_nameCopyBuffer != null) goto _L8; else goto _L7
_L7:
        _nameCopyBuffer = _ioContext.allocNameCopyBuffer(i);
_L10:
        s.getChars(0, i, _nameCopyBuffer, 0);
        _nameCopied = true;
_L6:
        return _nameCopyBuffer;
_L8:
        if (_nameCopyBuffer.length < i)
        {
            _nameCopyBuffer = new char[i];
        }
        if (true) goto _L10; else goto _L9
_L9:
        break; /* Loop/switch isn't completed */
_L3:
        if (_tokenIncomplete)
        {
            _tokenIncomplete = false;
            _finishString();
        }
        return _textBuffer.getTextBuffer();
        return null;
    }

    public final int getTextLength()
    {
label0:
        {
label1:
            {
label2:
                {
                    int i = 0;
                    if (_currToken != null)
                    {
                        switch (_currToken.id())
                        {
                        default:
                            i = _currToken.asCharArray().length;
                            break;

                        case 5: // '\005'
                            break label2;

                        case 6: // '\006'
                            break label1;

                        case 7: // '\007'
                        case 8: // '\b'
                            break label0;
                        }
                    }
                    return i;
                }
                return _parsingContext.getCurrentName().length();
            }
            if (_tokenIncomplete)
            {
                _tokenIncomplete = false;
                _finishString();
            }
        }
        return _textBuffer.size();
    }

    public final int getTextOffset()
    {
        if (_currToken == null) goto _L2; else goto _L1
_L1:
        _currToken.id();
        JVM INSTR tableswitch 5 8: default 44
    //                   5 44
    //                   6 46
    //                   7 62
    //                   8 62;
           goto _L2 _L2 _L3 _L4 _L4
_L2:
        return 0;
_L3:
        if (_tokenIncomplete)
        {
            _tokenIncomplete = false;
            _finishString();
        }
_L4:
        return _textBuffer.getTextOffset();
    }

    public final String getValueAsString()
    {
        if (_currToken == JsonToken.VALUE_STRING)
        {
            if (_tokenIncomplete)
            {
                _tokenIncomplete = false;
                _finishString();
            }
            return _textBuffer.contentsAsString();
        } else
        {
            return super.getValueAsString(null);
        }
    }

    public final String getValueAsString(String s)
    {
        if (_currToken == JsonToken.VALUE_STRING)
        {
            if (_tokenIncomplete)
            {
                _tokenIncomplete = false;
                _finishString();
            }
            return _textBuffer.contentsAsString();
        } else
        {
            return super.getValueAsString(s);
        }
    }

    protected boolean loadMore()
    {
        boolean flag1 = false;
        _currInputProcessed = _currInputProcessed + (long)_inputEnd;
        _currInputRowStart = _currInputRowStart - _inputEnd;
        boolean flag = flag1;
        if (_reader != null)
        {
            int i = _reader.read(_inputBuffer, 0, _inputBuffer.length);
            if (i > 0)
            {
                _inputPtr = 0;
                _inputEnd = i;
                flag = true;
            } else
            {
                _closeInput();
                flag = flag1;
                if (i == 0)
                {
                    throw new IOException((new StringBuilder()).append("Reader returned 0 characters when trying to read ").append(_inputEnd).toString());
                }
            }
        }
        return flag;
    }

    public final JsonToken nextToken()
    {
        Object obj;
        int j;
        boolean flag;
        _numTypesValid = 0;
        if (_currToken == JsonToken.FIELD_NAME)
        {
            return _nextAfterName();
        }
        if (_tokenIncomplete)
        {
            _skipString();
        }
        j = _skipWSOrEnd();
        if (j < 0)
        {
            close();
            _currToken = null;
            return null;
        }
        _tokenInputTotal = (_currInputProcessed + (long)_inputPtr) - 1L;
        _tokenInputRow = _currInputRow;
        _tokenInputCol = _inputPtr - _currInputRowStart - 1;
        _binaryValue = null;
        if (j == 93)
        {
            if (!_parsingContext.inArray())
            {
                _reportMismatchedEndMarker(j, '}');
            }
            _parsingContext = _parsingContext.getParent();
            JsonToken jsontoken = JsonToken.END_ARRAY;
            _currToken = jsontoken;
            return jsontoken;
        }
        if (j == 125)
        {
            if (!_parsingContext.inObject())
            {
                _reportMismatchedEndMarker(j, ']');
            }
            _parsingContext = _parsingContext.getParent();
            JsonToken jsontoken1 = JsonToken.END_OBJECT;
            _currToken = jsontoken1;
            return jsontoken1;
        }
        int i = j;
        if (_parsingContext.expectComma())
        {
            i = _skipComma(j);
        }
        flag = _parsingContext.inObject();
        j = i;
        if (flag)
        {
            if (i == 34)
            {
                obj = _parseName();
            } else
            {
                obj = _handleOddName(i);
            }
            _parsingContext.setCurrentName(((String) (obj)));
            _currToken = JsonToken.FIELD_NAME;
            j = _skipColon();
        }
        j;
        JVM INSTR lookupswitch 19: default 412
    //                   34: 442
    //                   45: 557
    //                   48: 565
    //                   49: 565
    //                   50: 565
    //                   51: 565
    //                   52: 565
    //                   53: 565
    //                   54: 565
    //                   55: 565
    //                   56: 565
    //                   57: 565
    //                   91: 454
    //                   93: 516
    //                   102: 535
    //                   110: 546
    //                   116: 524
    //                   123: 485
    //                   125: 516;
           goto _L1 _L2 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L6
_L4:
        break MISSING_BLOCK_LABEL_565;
_L1:
        obj = _handleOddValue(j);
_L11:
        if (flag)
        {
            _nextToken = ((JsonToken) (obj));
            return _currToken;
        } else
        {
            _currToken = ((JsonToken) (obj));
            return ((JsonToken) (obj));
        }
_L2:
        _tokenIncomplete = true;
        obj = JsonToken.VALUE_STRING;
          goto _L11
_L5:
        if (!flag)
        {
            _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
        }
        obj = JsonToken.START_ARRAY;
          goto _L11
_L10:
        if (!flag)
        {
            _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        }
        obj = JsonToken.START_OBJECT;
          goto _L11
_L6:
        _reportUnexpectedChar(j, "expected a value");
_L9:
        _matchTrue();
        obj = JsonToken.VALUE_TRUE;
          goto _L11
_L7:
        _matchFalse();
        obj = JsonToken.VALUE_FALSE;
          goto _L11
_L8:
        _matchNull();
        obj = JsonToken.VALUE_NULL;
          goto _L11
_L3:
        obj = _parseNegNumber();
          goto _L11
        obj = _parsePosNumber(j);
          goto _L11
    }

    public int readBinaryValue(Base64Variant base64variant, OutputStream outputstream)
    {
        byte abyte0[];
        if (!_tokenIncomplete || _currToken != JsonToken.VALUE_STRING)
        {
            base64variant = getBinaryValue(base64variant);
            outputstream.write(base64variant);
            return base64variant.length;
        }
        abyte0 = _ioContext.allocBase64Buffer();
        int i = _readBinary(base64variant, outputstream, abyte0);
        _ioContext.releaseBase64Buffer(abyte0);
        return i;
        base64variant;
        _ioContext.releaseBase64Buffer(abyte0);
        throw base64variant;
    }

}
