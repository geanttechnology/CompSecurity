// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.Reader;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.util.TextBuffer;

// Referenced classes of package org.codehaus.jackson.impl:
//            ReaderBasedParserBase

public abstract class ReaderBasedNumericParser extends ReaderBasedParserBase
{

    public ReaderBasedNumericParser(IOContext iocontext, int i, Reader reader)
    {
        super(iocontext, i, reader);
    }

    private final char _verifyNoLeadingZeroes()
        throws IOException, JsonParseException
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
        if (!isEnabled(org.codehaus.jackson.JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS))
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

    private final JsonToken parseNumberText2(boolean flag)
        throws IOException, JsonParseException
    {
        char c;
        char c1;
        char ac1[];
        char ac2[];
        int i;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        ac2 = _textBuffer.emptyAndGetCurrentSegment();
        i = 0;
        if (flag)
        {
            ac2[0] = '-';
            i = 0 + 1;
        }
        l = 0;
        int i2;
        int j2;
        if (_inputPtr < _inputEnd)
        {
            char ac[] = _inputBuffer;
            int j = _inputPtr;
            _inputPtr = j + 1;
            c = ac[j];
        } else
        {
            c = getNextChar("No digit following minus sign");
        }
        c1 = c;
        if (c == '0')
        {
            c1 = _verifyNoLeadingZeroes();
        }
        i1 = 0;
        c = c1;
_L15:
        if (c < '0' || c > '9')
        {
            break MISSING_BLOCK_LABEL_906;
        }
        l++;
        ac1 = ac2;
        k = i;
        if (i >= ac2.length)
        {
            ac1 = _textBuffer.finishCurrentSegment();
            k = 0;
        }
        i = k + 1;
        ac1[k] = c;
        if (_inputPtr < _inputEnd || loadMore()) goto _L2; else goto _L1
_L1:
        c = '\0';
        k = 1;
        l1 = l;
_L21:
        if (l1 == 0)
        {
            reportInvalidNumber((new StringBuilder()).append("Missing integer part (next char ").append(_getCharDesc(c)).append(")").toString());
        }
        i2 = 0;
        i1 = 0;
        if (c != '.') goto _L4; else goto _L3
_L3:
        l = i + 1;
        ac1[i] = c;
        i = l;
_L19:
        if (_inputPtr < _inputEnd || loadMore()) goto _L6; else goto _L5
_L5:
        j1 = 1;
_L17:
        c1 = c;
        k = j1;
        i2 = i1;
        ac2 = ac1;
        l = i;
        if (i1 == 0)
        {
            reportUnexpectedNumberChar(c, "Decimal point not followed by a digit");
            l = i;
            ac2 = ac1;
            i2 = i1;
            k = j1;
            c1 = c;
        }
_L20:
        k1 = 0;
        i1 = 0;
        if (c1 == 'e') goto _L8; else goto _L7
_L7:
        i = k;
        j2 = l;
        if (c1 != 'E') goto _L9; else goto _L8
_L8:
        ac1 = ac2;
        i = l;
        if (l >= ac2.length)
        {
            ac1 = _textBuffer.finishCurrentSegment();
            i = 0;
        }
        l = i + 1;
        ac1[i] = c1;
        if (_inputPtr < _inputEnd)
        {
            ac2 = _inputBuffer;
            i = _inputPtr;
            _inputPtr = i + 1;
            c = ac2[i];
        } else
        {
            c = getNextChar("expected a digit for number exponent");
        }
        if (c == '-' || c == '+')
        {
            if (l >= ac1.length)
            {
                ac1 = _textBuffer.finishCurrentSegment();
                i = 0;
            } else
            {
                i = l;
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
            k1 = i1;
        } else
        {
            i = l;
            k1 = i1;
        }
        j1 = k;
        i1 = k1;
        l = i;
        if (c > '9') goto _L11; else goto _L10
_L10:
        j1 = k;
        i1 = k1;
        l = i;
        if (c < '0') goto _L11; else goto _L12
_L12:
        i1 = k1 + 1;
        ac2 = ac1;
        l = i;
        if (i >= ac1.length)
        {
            ac2 = _textBuffer.finishCurrentSegment();
            l = 0;
        }
        i = l + 1;
        ac2[l] = c;
        if (_inputPtr < _inputEnd || loadMore()) goto _L14; else goto _L13
_L13:
        j1 = 1;
        l = i;
_L11:
        i = j1;
        k1 = i1;
        j2 = l;
        if (i1 == 0)
        {
            reportUnexpectedNumberChar(c, "Exponent indicator not followed by a digit");
            j2 = l;
            k1 = i1;
            i = j1;
        }
_L9:
        if (i == 0)
        {
            _inputPtr = _inputPtr - 1;
        }
        _textBuffer.setCurrentLength(j2);
        return reset(flag, l1, i2, k1);
_L2:
        ac2 = _inputBuffer;
        k = _inputPtr;
        _inputPtr = k + 1;
        c = ac2[k];
        ac2 = ac1;
          goto _L15
_L6:
        ac2 = _inputBuffer;
        l = _inputPtr;
        _inputPtr = l + 1;
        c1 = ac2[l];
        c = c1;
        j1 = k;
        if (c1 < '0') goto _L17; else goto _L16
_L16:
        c = c1;
        j1 = k;
        if (c1 > '9') goto _L17; else goto _L18
_L18:
        i1++;
        ac2 = ac1;
        l = i;
        if (i >= ac1.length)
        {
            ac2 = _textBuffer.finishCurrentSegment();
            l = 0;
        }
        ac2[l] = c1;
        i = l + 1;
        c = c1;
        ac1 = ac2;
          goto _L19
_L14:
        ac1 = _inputBuffer;
        l = _inputPtr;
        _inputPtr = l + 1;
        c = ac1[l];
        k1 = i1;
        ac1 = ac2;
        break MISSING_BLOCK_LABEL_491;
_L4:
        c1 = c;
        ac2 = ac1;
        l = i;
          goto _L20
        k = i1;
        l1 = l;
        ac1 = ac2;
          goto _L21
    }

    protected JsonToken _handleInvalidNumberStart(int i, boolean flag)
        throws IOException, JsonParseException
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
        j = i;
        if (_matchToken(s, 3))
        {
            if (isEnabled(org.codehaus.jackson.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
            {
                if (!flag)
                {
                    d = (1.0D / 0.0D);
                }
                return resetAsNaN(s, d);
            }
            _reportError((new StringBuilder()).append("Non-standard token '").append(s).append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow").toString());
            j = i;
        }
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
            j = i;
            if (_matchToken(s1, 3))
            {
                if (isEnabled(org.codehaus.jackson.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
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
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected final JsonToken parseNumberText(int i)
        throws IOException, JsonParseException
    {
        int j;
        int k;
        int l1;
        int i2;
        boolean flag;
        if (i == 45)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = _inputPtr;
        l1 = k - 1;
        i2 = _inputEnd;
        j = k;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (k < _inputEnd) goto _L4; else goto _L3
_L3:
        i = l1;
        if (flag)
        {
            i = l1 + 1;
        }
        _inputPtr = i;
        return parseNumberText2(flag);
_L4:
        char ac[] = _inputBuffer;
        j = k + 1;
        i = ac[k];
        if (i > 57 || i < 48)
        {
            _inputPtr = j;
            return _handleInvalidNumberStart(i, true);
        }
_L2:
        if (i == 48) goto _L3; else goto _L5
_L5:
        int l;
        l = 1;
        i = j;
_L12:
        if (i >= _inputEnd) goto _L3; else goto _L6
_L6:
        int k1;
        char ac1[] = _inputBuffer;
        j = i + 1;
        k1 = ac1[i];
        if (k1 >= '0' && k1 <= '9') goto _L8; else goto _L7
_L7:
        int i1;
        int j1;
        i1 = 0;
        j1 = 0;
        i = j;
        k = k1;
        if (k1 != '.') goto _L10; else goto _L9
_L9:
        k = j;
        j = j1;
_L18:
        if (k < i2) goto _L11; else goto _L3
_L8:
        l++;
        i = j;
          goto _L12
_L11:
        char ac2[] = _inputBuffer;
        i = k + 1;
        k = ac2[k];
        if (k >= 48 && k <= 57) goto _L14; else goto _L13
_L13:
        if (j == 0)
        {
            reportUnexpectedNumberChar(k, "Decimal point not followed by a digit");
        }
        i1 = j;
_L10:
        j1 = 0;
        j = 0;
        if (k == 101)
        {
            continue; /* Loop/switch isn't completed */
        }
        k1 = i;
        if (k != 69) goto _L16; else goto _L15
_L15:
        if (i < i2) goto _L17; else goto _L3
_L14:
        j++;
        k = i;
          goto _L18
_L17:
        char ac3[] = _inputBuffer;
        j1 = i + 1;
        k = ac3[i];
        if (k != '-' && k != '+')
        {
            break MISSING_BLOCK_LABEL_451;
        }
        if (j1 >= i2) goto _L3; else goto _L19
_L19:
        char ac4[];
        ac4 = _inputBuffer;
        i = j1 + 1;
_L21:
        for (k = ac4[j1]; k > '9' || k < '0';)
        {
            break MISSING_BLOCK_LABEL_387;
        }

        j++;
        if (i < i2) goto _L20; else goto _L3
_L20:
        k = _inputBuffer[i];
        i++;
          goto _L21
        j1 = j;
        k1 = i;
        if (j == 0)
        {
            reportUnexpectedNumberChar(k, "Exponent indicator not followed by a digit");
            k1 = i;
            j1 = j;
        }
_L16:
        i = k1 - 1;
        _inputPtr = i;
        _textBuffer.resetWithShared(_inputBuffer, l1, i - l1);
        return reset(flag, l, i1, j1);
        i = j1;
          goto _L21
    }
}
