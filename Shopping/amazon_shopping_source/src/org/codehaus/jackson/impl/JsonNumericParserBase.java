// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.io.NumberInput;
import org.codehaus.jackson.util.TextBuffer;

// Referenced classes of package org.codehaus.jackson.impl:
//            JsonParserBase

public abstract class JsonNumericParserBase extends JsonParserBase
{

    static final BigDecimal BD_MAX_INT = new BigDecimal(0x7fffffffffffffffL);
    static final BigDecimal BD_MAX_LONG = new BigDecimal(0x7fffffffffffffffL);
    static final BigDecimal BD_MIN_INT = new BigDecimal(0x8000000000000000L);
    static final BigDecimal BD_MIN_LONG = new BigDecimal(0x8000000000000000L);
    protected int _expLength;
    protected int _fractLength;
    protected int _intLength;
    protected int _numTypesValid;
    protected BigDecimal _numberBigDecimal;
    protected BigInteger _numberBigInt;
    protected double _numberDouble;
    protected int _numberInt;
    protected long _numberLong;
    protected boolean _numberNegative;

    protected JsonNumericParserBase(IOContext iocontext, int i)
    {
        super(iocontext, i);
        _numTypesValid = 0;
    }

    private final void _parseSlowFloatValue(int i)
        throws IOException, JsonParseException
    {
        if (i == 16)
        {
            try
            {
                _numberBigDecimal = _textBuffer.contentsAsDecimal();
                _numTypesValid = 16;
                return;
            }
            catch (NumberFormatException numberformatexception)
            {
                _wrapError((new StringBuilder()).append("Malformed numeric value '").append(_textBuffer.contentsAsString()).append("'").toString(), numberformatexception);
            }
            break MISSING_BLOCK_LABEL_78;
        }
        _numberDouble = _textBuffer.contentsAsDouble();
        _numTypesValid = 8;
        return;
    }

    private final void _parseSlowIntValue(int i, char ac[], int j, int k)
        throws IOException, JsonParseException
    {
        String s = _textBuffer.contentsAsString();
        if (NumberInput.inLongRange(ac, j, k, _numberNegative))
        {
            _numberLong = Long.parseLong(s);
            _numTypesValid = 2;
            return;
        }
        try
        {
            _numberBigInt = new BigInteger(s);
            _numTypesValid = 4;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (char ac[])
        {
            _wrapError((new StringBuilder()).append("Malformed numeric value '").append(s).append("'").toString(), ac);
        }
        return;
    }

    protected void _parseNumericValue(int i)
        throws IOException, JsonParseException
    {
        if (_currToken == JsonToken.VALUE_NUMBER_INT)
        {
            char ac[] = _textBuffer.getTextBuffer();
            int k = _textBuffer.getTextOffset();
            int l = _intLength;
            int j = k;
            if (_numberNegative)
            {
                j = k + 1;
            }
            if (l <= 9)
            {
                j = NumberInput.parseInt(ac, j, l);
                i = j;
                if (_numberNegative)
                {
                    i = -j;
                }
                _numberInt = i;
                _numTypesValid = 1;
                return;
            }
            if (l <= 18)
            {
                long l2 = NumberInput.parseLong(ac, j, l);
                long l1 = l2;
                if (_numberNegative)
                {
                    l1 = -l2;
                }
                if (l == 10)
                {
                    if (_numberNegative)
                    {
                        if (l1 >= 0xffffffff80000000L)
                        {
                            _numberInt = (int)l1;
                            _numTypesValid = 1;
                            return;
                        }
                    } else
                    if (l1 <= 0x7fffffffL)
                    {
                        _numberInt = (int)l1;
                        _numTypesValid = 1;
                        return;
                    }
                }
                _numberLong = l1;
                _numTypesValid = 2;
                return;
            } else
            {
                _parseSlowIntValue(i, ac, j, l);
                return;
            }
        }
        if (_currToken == JsonToken.VALUE_NUMBER_FLOAT)
        {
            _parseSlowFloatValue(i);
            return;
        } else
        {
            _reportError((new StringBuilder()).append("Current token (").append(_currToken).append(") not numeric, can not use numeric value accessors").toString());
            return;
        }
    }

    protected void convertNumberToLong()
        throws IOException, JsonParseException
    {
        if ((_numTypesValid & 1) != 0)
        {
            _numberLong = _numberInt;
        } else
        if ((_numTypesValid & 4) != 0)
        {
            _numberLong = _numberBigInt.longValue();
        } else
        if ((_numTypesValid & 8) != 0)
        {
            if (_numberDouble < -9.2233720368547758E+18D || _numberDouble > 9.2233720368547758E+18D)
            {
                reportOverflowLong();
            }
            _numberLong = (long)_numberDouble;
        } else
        if ((_numTypesValid & 0x10) != 0)
        {
            if (BD_MIN_LONG.compareTo(_numberBigDecimal) > 0 || BD_MAX_LONG.compareTo(_numberBigDecimal) < 0)
            {
                reportOverflowLong();
            }
            _numberLong = _numberBigDecimal.longValue();
        } else
        {
            _throwInternal();
        }
        _numTypesValid = _numTypesValid | 2;
    }

    public long getLongValue()
        throws IOException, JsonParseException
    {
        if ((_numTypesValid & 2) == 0)
        {
            if (_numTypesValid == 0)
            {
                _parseNumericValue(2);
            }
            if ((_numTypesValid & 2) == 0)
            {
                convertNumberToLong();
            }
        }
        return _numberLong;
    }

    public Number getNumberValue()
        throws IOException, JsonParseException
    {
        if (_numTypesValid == 0)
        {
            _parseNumericValue(0);
        }
        if (_currToken == JsonToken.VALUE_NUMBER_INT)
        {
            if ((_numTypesValid & 1) != 0)
            {
                return Integer.valueOf(_numberInt);
            }
            if ((_numTypesValid & 2) != 0)
            {
                return Long.valueOf(_numberLong);
            }
            if ((_numTypesValid & 4) != 0)
            {
                return _numberBigInt;
            } else
            {
                return _numberBigDecimal;
            }
        }
        if ((_numTypesValid & 0x10) != 0)
        {
            return _numberBigDecimal;
        }
        if ((_numTypesValid & 8) == 0)
        {
            _throwInternal();
        }
        return Double.valueOf(_numberDouble);
    }

    protected void reportInvalidNumber(String s)
        throws JsonParseException
    {
        _reportError((new StringBuilder()).append("Invalid numeric value: ").append(s).toString());
    }

    protected void reportOverflowLong()
        throws IOException, JsonParseException
    {
        _reportError((new StringBuilder()).append("Numeric value (").append(getText()).append(") out of range of long (").append(0x8000000000000000L).append(" - ").append(0x7fffffffffffffffL).append(")").toString());
    }

    protected void reportUnexpectedNumberChar(int i, String s)
        throws JsonParseException
    {
        String s2 = (new StringBuilder()).append("Unexpected character (").append(_getCharDesc(i)).append(") in numeric value").toString();
        String s1 = s2;
        if (s != null)
        {
            s1 = (new StringBuilder()).append(s2).append(": ").append(s).toString();
        }
        _reportError(s1);
    }

    protected final JsonToken reset(boolean flag, int i, int j, int k)
    {
        if (j < 1 && k < 1)
        {
            return resetInt(flag, i);
        } else
        {
            return resetFloat(flag, i, j, k);
        }
    }

    protected final JsonToken resetAsNaN(String s, double d)
    {
        _textBuffer.resetWithString(s);
        _numberDouble = d;
        _numTypesValid = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    protected final JsonToken resetFloat(boolean flag, int i, int j, int k)
    {
        _numberNegative = flag;
        _intLength = i;
        _fractLength = j;
        _expLength = k;
        _numTypesValid = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    protected final JsonToken resetInt(boolean flag, int i)
    {
        _numberNegative = flag;
        _intLength = i;
        _fractLength = 0;
        _expLength = 0;
        _numTypesValid = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

}
