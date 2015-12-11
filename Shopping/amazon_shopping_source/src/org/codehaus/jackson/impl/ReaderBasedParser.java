// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.Reader;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.sym.CharsToNameCanonicalizer;
import org.codehaus.jackson.util.CharTypes;
import org.codehaus.jackson.util.TextBuffer;

// Referenced classes of package org.codehaus.jackson.impl:
//            ReaderBasedNumericParser, JsonReadContext

public final class ReaderBasedParser extends ReaderBasedNumericParser
{

    protected ObjectCodec _objectCodec;
    protected final CharsToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete;

    public ReaderBasedParser(IOContext iocontext, int i, Reader reader, ObjectCodec objectcodec, CharsToNameCanonicalizer charstonamecanonicalizer)
    {
        super(iocontext, i, reader);
        _tokenIncomplete = false;
        _objectCodec = objectcodec;
        _symbols = charstonamecanonicalizer;
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

    private String _parseFieldName2(int i, int j, int k)
        throws IOException, JsonParseException
    {
        char ac[];
        _textBuffer.resetWithShared(_inputBuffer, i, _inputPtr - i);
        ac = _textBuffer.getCurrentSegment();
        i = _textBuffer.getCurrentSegmentSize();
_L5:
        char c;
        char c1;
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOF((new StringBuilder()).append(": was expecting closing '").append((char)k).append("' for name").toString());
        }
        char ac1[] = _inputBuffer;
        int l = _inputPtr;
        _inputPtr = l + 1;
        c1 = ac1[l];
        c = c1;
        if (c1 > '\\') goto _L2; else goto _L1
_L1:
        if (c1 != '\\') goto _L4; else goto _L3
_L3:
        c = _decodeEscaped();
_L2:
        j = j * 31 + c1;
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
        if (true) goto _L5; else goto _L4
_L4:
        c = c1;
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
            c = c1;
            if (c1 < ' ')
            {
                _throwUnquotedSpace(c1, "name");
                c = c1;
            }
        }
          goto _L2
    }

    private String _parseUnusualFieldName2(int i, int j, int ai[])
        throws IOException, JsonParseException
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
        j = j * 31 + c;
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

    private final void _skipCComment()
        throws IOException, JsonParseException
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
                    _skipLF();
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

    private final void _skipComment()
        throws IOException, JsonParseException
    {
        if (!isEnabled(org.codehaus.jackson.JsonParser.Feature.ALLOW_COMMENTS))
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
            _skipCppComment();
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

    private final void _skipCppComment()
        throws IOException, JsonParseException
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
                    _skipLF();
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

    private final int _skipWS()
        throws IOException, JsonParseException
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
                if (i != '/')
                {
                    return i;
                }
                _skipComment();
            } else
            if (i != ' ')
            {
                if (i == '\n')
                {
                    _skipLF();
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

    private final int _skipWSOrEnd()
        throws IOException, JsonParseException
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
                if (i != '/')
                {
                    return i;
                }
                _skipComment();
            } else
            if (i != ' ')
            {
                if (i == '\n')
                {
                    _skipLF();
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
        _handleEOF();
        return -1;
    }

    protected final char _decodeEscaped()
        throws IOException, JsonParseException
    {
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOF(" in character escape sequence");
        }
        char ac[] = _inputBuffer;
        int i = _inputPtr;
        _inputPtr = i + 1;
        char c1 = ac[i];
        char c = c1;
        int k;
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
            k = 0;
            break;
        }
        for (int j = 0; j < 4; j++)
        {
            if (_inputPtr >= _inputEnd && !loadMore())
            {
                _reportInvalidEOF(" in character escape sequence");
            }
            char ac1[] = _inputBuffer;
            int l = _inputPtr;
            _inputPtr = l + 1;
            l = ac1[l];
            int i1 = CharTypes.charToHex(l);
            if (i1 < 0)
            {
                _reportUnexpectedChar(l, "expected a hex-digit for character escape sequence");
            }
            k = k << 4 | i1;
        }

        return (char)k;
    }

    protected void _finishString()
        throws IOException, JsonParseException
    {
        int i = _inputPtr;
        int k = _inputEnd;
        int j = i;
        if (i < k)
        {
            int ai[] = CharTypes.getInputCodeLatin1();
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
        throws IOException, JsonParseException
    {
        char ac[];
        int i;
        ac = _textBuffer.getCurrentSegment();
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
        char ac2[] = ac;
        int k = i;
        if (i >= ac.length)
        {
            ac2 = _textBuffer.finishCurrentSegment();
            k = 0;
        }
        ac2[k] = c;
        i = k + 1;
        ac = ac2;
        if (true) goto _L2; else goto _L1
_L1:
        c = c1;
        if (c1 <= '"')
        {
            if (c1 == '"')
            {
                _textBuffer.setCurrentLength(i);
                return;
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

    protected final String _getText2(JsonToken jsontoken)
    {
        if (jsontoken == null)
        {
            return null;
        }
        static class _cls1
        {

            static final int $SwitchMap$org$codehaus$jackson$JsonToken[];

            static 
            {
                $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.org.codehaus.jackson.JsonToken[jsontoken.ordinal()])
        {
        default:
            return jsontoken.asString();

        case 1: // '\001'
            return _parsingContext.getCurrentName();

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return _textBuffer.contentsAsString();
        }
    }

    protected final JsonToken _handleApostropheValue()
        throws IOException, JsonParseException
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
        char ac2[] = ac;
        int k = i;
        if (i >= ac.length)
        {
            ac2 = _textBuffer.finishCurrentSegment();
            k = 0;
        }
        ac2[k] = c;
        i = k + 1;
        ac = ac2;
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

    protected final JsonToken _handleUnexpectedValue(int i)
        throws IOException, JsonParseException
    {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   39: 46
    //                   43: 130
    //                   78: 61;
           goto _L1 _L2 _L3 _L4
_L1:
        _reportUnexpectedChar(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
_L2:
        if (isEnabled(org.codehaus.jackson.JsonParser.Feature.ALLOW_SINGLE_QUOTES))
        {
            return _handleApostropheValue();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (_matchToken("NaN", 1))
        {
            if (isEnabled(org.codehaus.jackson.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
            {
                return resetAsNaN("NaN", (0.0D / 0.0D));
            }
            _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
        char ac[] = _inputBuffer;
        int j = _inputPtr;
        _inputPtr = j + 1;
        _reportUnexpectedChar(ac[j], "expected 'NaN' or a valid value");
        if (true) goto _L1; else goto _L3
_L3:
        if (_inputPtr >= _inputEnd && !loadMore())
        {
            _reportInvalidEOFInValue();
        }
        char ac1[] = _inputBuffer;
        i = _inputPtr;
        _inputPtr = i + 1;
        return _handleInvalidNumberStart(ac1[i], false);
    }

    protected final String _handleUnusualFieldName(int i)
        throws IOException, JsonParseException
    {
        if (i == 39 && isEnabled(org.codehaus.jackson.JsonParser.Feature.ALLOW_SINGLE_QUOTES))
        {
            return _parseApostropheFieldName();
        }
        if (!isEnabled(org.codehaus.jackson.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES))
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
            if (ai[i] == 0 && (i < 48 || i > 57))
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
        j = _inputPtr;
        k = 0;
        l = 0;
        j1 = _inputEnd;
        i = j;
        if (j < j1)
        {
            i = j;
            j = l;
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
                k = j * 31 + k;
                l = i + 1;
                j = k;
                i = l;
            } while (l < j1);
            i = l;
        }
        j = _inputPtr;
        _inputPtr = i;
        return _parseUnusualFieldName2(j - 1, k, ai);
    }

    protected void _matchToken(JsonToken jsontoken)
        throws IOException, JsonParseException
    {
        jsontoken = jsontoken.asString();
        int i = 1;
        for (int j = jsontoken.length(); i < j; i++)
        {
            if (_inputPtr >= _inputEnd && !loadMore())
            {
                _reportInvalidEOF(" in a value");
            }
            if (_inputBuffer[_inputPtr] != jsontoken.charAt(i))
            {
                _reportInvalidToken(jsontoken.substring(0, i), "'null', 'true' or 'false'");
            }
            _inputPtr = _inputPtr + 1;
        }

    }

    protected final String _parseApostropheFieldName()
        throws IOException, JsonParseException
    {
        int i;
        int j;
        int k;
        boolean flag;
        int j1;
        k = _inputPtr;
        i = 0;
        flag = false;
        j1 = _inputEnd;
        j = k;
        if (k >= j1) goto _L2; else goto _L1
_L1:
        int ai[];
        int k1;
        ai = CharTypes.getInputCodeLatin1();
        k1 = ai.length;
        j = k;
        i = ((flag) ? 1 : 0);
_L4:
        int l = _inputBuffer[j];
        if (l == 39)
        {
            l = _inputPtr;
            _inputPtr = j + 1;
            return _symbols.findSymbol(_inputBuffer, l, j - l, i);
        }
        if (l >= k1 || ai[l] == 0)
        {
            int i1 = i * 31 + l;
            l = j + 1;
            i = i1;
            j = l;
            if (l < j1)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = i1;
            j = l;
        }
_L2:
        l = _inputPtr;
        _inputPtr = j;
        return _parseFieldName2(l, i, 39);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final String _parseFieldName(int i)
        throws IOException, JsonParseException
    {
        if (i != 34)
        {
            return _handleUnusualFieldName(i);
        }
        i = _inputPtr;
        int l = 0;
        int j = 0;
        int i1 = _inputEnd;
        int k = i;
        if (i < i1)
        {
            int ai[] = CharTypes.getInputCodeLatin1();
            int j1 = ai.length;
            do
            {
                char c = _inputBuffer[i];
                if (c < j1 && ai[c] != 0)
                {
                    l = j;
                    k = i;
                    if (c == '"')
                    {
                        k = _inputPtr;
                        _inputPtr = i + 1;
                        return _symbols.findSymbol(_inputBuffer, k, i - k, j);
                    }
                    break;
                }
                l = j * 31 + c;
                k = i + 1;
                j = l;
                i = k;
            } while (k < i1);
        }
        i = _inputPtr;
        _inputPtr = k;
        return _parseFieldName2(i, l, 34);
    }

    protected final void _skipCR()
        throws IOException
    {
        if ((_inputPtr < _inputEnd || loadMore()) && _inputBuffer[_inputPtr] == '\n')
        {
            _inputPtr = _inputPtr + 1;
        }
        _currInputRow = _currInputRow + 1;
        _currInputRowStart = _inputPtr;
    }

    protected final void _skipLF()
        throws IOException
    {
        _currInputRow = _currInputRow + 1;
        _currInputRowStart = _inputPtr;
    }

    protected void _skipString()
        throws IOException, JsonParseException
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

    public void close()
        throws IOException
    {
        super.close();
        _symbols.release();
    }

    public final String getText()
        throws IOException, JsonParseException
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

    public JsonToken nextToken()
        throws IOException, JsonParseException
    {
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
            if (j != 44)
            {
                _reportUnexpectedChar(j, (new StringBuilder()).append("was expecting comma to separate ").append(_parsingContext.getTypeDesc()).append(" entries").toString());
            }
            i = _skipWS();
        }
        flag = _parsingContext.inObject();
        j = i;
        if (flag)
        {
            String s = _parseFieldName(i);
            _parsingContext.setCurrentName(s);
            _currToken = JsonToken.FIELD_NAME;
            i = _skipWS();
            if (i != 58)
            {
                _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
            }
            j = _skipWS();
        }
        j;
        JVM INSTR lookupswitch 19: default 468
    //                   34: 489
    //                   45: 613
    //                   48: 613
    //                   49: 613
    //                   50: 613
    //                   51: 613
    //                   52: 613
    //                   53: 613
    //                   54: 613
    //                   55: 613
    //                   56: 613
    //                   57: 613
    //                   91: 501
    //                   93: 563
    //                   102: 585
    //                   110: 599
    //                   116: 571
    //                   123: 532
    //                   125: 563;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L5
_L3:
        break MISSING_BLOCK_LABEL_613;
_L1:
        JsonToken jsontoken2 = _handleUnexpectedValue(j);
_L10:
        if (flag)
        {
            _nextToken = jsontoken2;
            return _currToken;
        } else
        {
            _currToken = jsontoken2;
            return jsontoken2;
        }
_L2:
        _tokenIncomplete = true;
        jsontoken2 = JsonToken.VALUE_STRING;
          goto _L10
_L4:
        if (!flag)
        {
            _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
        }
        jsontoken2 = JsonToken.START_ARRAY;
          goto _L10
_L9:
        if (!flag)
        {
            _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        }
        jsontoken2 = JsonToken.START_OBJECT;
          goto _L10
_L5:
        _reportUnexpectedChar(j, "expected a value");
_L8:
        _matchToken(JsonToken.VALUE_TRUE);
        jsontoken2 = JsonToken.VALUE_TRUE;
          goto _L10
_L6:
        _matchToken(JsonToken.VALUE_FALSE);
        jsontoken2 = JsonToken.VALUE_FALSE;
          goto _L10
_L7:
        _matchToken(JsonToken.VALUE_NULL);
        jsontoken2 = JsonToken.VALUE_NULL;
          goto _L10
        jsontoken2 = parseNumberText(j);
          goto _L10
    }
}
