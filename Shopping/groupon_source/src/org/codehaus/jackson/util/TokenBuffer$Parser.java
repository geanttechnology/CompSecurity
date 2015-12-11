// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.impl.JsonParserMinimalBase;
import org.codehaus.jackson.impl.JsonReadContext;

// Referenced classes of package org.codehaus.jackson.util:
//            TokenBuffer, ByteArrayBuilder

protected static final class ateRootContext extends JsonParserMinimalBase
{

    protected transient ByteArrayBuilder _byteBuilder;
    protected boolean _closed;
    protected ObjectCodec _codec;
    protected JsonLocation _location;
    protected JsonReadContext _parsingContext;
    protected  _segment;
    protected int _segmentPtr;

    protected final void _checkIsNumber()
        throws JsonParseException
    {
        if (_currToken == null || !_currToken.isNumeric())
        {
            throw _constructError((new StringBuilder()).append("Current token (").append(_currToken).append(") not numeric, can not use numeric value accessors").toString());
        } else
        {
            return;
        }
    }

    protected final Object _currentObject()
    {
        return _segment.get(_segmentPtr);
    }

    protected void _decodeBase64(String s, ByteArrayBuilder bytearraybuilder, Base64Variant base64variant)
        throws IOException, JsonParseException
    {
        int i;
        int k;
        i = 0;
        k = s.length();
_L4:
        if (i >= k) goto _L2; else goto _L1
_L1:
        char c;
        int j;
        j = i + 1;
        c = s.charAt(i);
        if (j < k) goto _L3; else goto _L2
_L2:
        return;
_L3:
label0:
        {
            if (c <= ' ')
            {
                break label0;
            }
            int l = base64variant.decodeBase64Char(c);
            if (l < 0)
            {
                _reportInvalidBase64(base64variant, c, 0, null);
            }
            if (j >= k)
            {
                _reportBase64EOF();
            }
            i = j + 1;
            c = s.charAt(j);
            j = base64variant.decodeBase64Char(c);
            if (j < 0)
            {
                _reportInvalidBase64(base64variant, c, 1, null);
            }
            l = l << 6 | j;
            if (i >= k)
            {
                if (!base64variant.usesPadding())
                {
                    bytearraybuilder.append(l >> 4);
                    return;
                }
                _reportBase64EOF();
            }
            j = i + 1;
            c = s.charAt(i);
            i = base64variant.decodeBase64Char(c);
            if (i < 0)
            {
                if (i != -2)
                {
                    _reportInvalidBase64(base64variant, c, 2, null);
                }
                if (j >= k)
                {
                    _reportBase64EOF();
                }
                i = j + 1;
                c = s.charAt(j);
                if (!base64variant.usesPaddingChar(c))
                {
                    _reportInvalidBase64(base64variant, c, 3, (new StringBuilder()).append("expected padding character '").append(base64variant.getPaddingChar()).append("'").toString());
                }
                bytearraybuilder.append(l >> 4);
            } else
            {
                l = l << 6 | i;
                if (j >= k)
                {
                    if (!base64variant.usesPadding())
                    {
                        bytearraybuilder.appendTwoBytes(l >> 2);
                        return;
                    }
                    _reportBase64EOF();
                }
                i = j + 1;
                char c1 = s.charAt(j);
                j = base64variant.decodeBase64Char(c1);
                if (j < 0)
                {
                    if (j != -2)
                    {
                        _reportInvalidBase64(base64variant, c1, 3, null);
                    }
                    bytearraybuilder.appendTwoBytes(l >> 2);
                } else
                {
                    bytearraybuilder.appendThreeBytes(l << 6 | j);
                }
            }
        }
          goto _L4
        i = j;
          goto _L1
    }

    protected void _handleEOF()
        throws JsonParseException
    {
        _throwInternal();
    }

    protected void _reportBase64EOF()
        throws JsonParseException
    {
        throw _constructError("Unexpected end-of-String in base64 content");
    }

    protected void _reportInvalidBase64(Base64Variant base64variant, char c, int i, String s)
        throws JsonParseException
    {
        Object obj;
        if (c <= ' ')
        {
            base64variant = (new StringBuilder()).append("Illegal white space character (code 0x").append(Integer.toHexString(c)).append(") as character #").append(i + 1).append(" of 4-char base64 unit: can only used between units").toString();
        } else
        if (base64variant.usesPaddingChar(c))
        {
            base64variant = (new StringBuilder()).append("Unexpected padding character ('").append(base64variant.getPaddingChar()).append("') as character #").append(i + 1).append(" of 4-char base64 unit: padding only legal as 3rd or 4th character").toString();
        } else
        if (!Character.isDefined(c) || Character.isISOControl(c))
        {
            base64variant = (new StringBuilder()).append("Illegal character (code 0x").append(Integer.toHexString(c)).append(") in base64 content").toString();
        } else
        {
            base64variant = (new StringBuilder()).append("Illegal character '").append(c).append("' (code 0x").append(Integer.toHexString(c)).append(") in base64 content").toString();
        }
        obj = base64variant;
        if (s != null)
        {
            obj = (new StringBuilder()).append(base64variant).append(": ").append(s).toString();
        }
        throw _constructError(((String) (obj)));
    }

    public void close()
        throws IOException
    {
        if (!_closed)
        {
            _closed = true;
        }
    }

    public BigInteger getBigIntegerValue()
        throws IOException, JsonParseException
    {
        Number number = getNumberValue();
        if (number instanceof BigInteger)
        {
            return (BigInteger)number;
        }
        switch (chMap.org.codehaus.jackson.JsonParser.NumberType[getNumberType().ordinal()])
        {
        default:
            return BigInteger.valueOf(number.longValue());

        case 3: // '\003'
            return ((BigDecimal)number).toBigInteger();
        }
    }

    public byte[] getBinaryValue(Base64Variant base64variant)
        throws IOException, JsonParseException
    {
        if (_currToken == JsonToken.VALUE_EMBEDDED_OBJECT)
        {
            Object obj = _currentObject();
            if (obj instanceof byte[])
            {
                return (byte[])(byte[])obj;
            }
        }
        if (_currToken != JsonToken.VALUE_STRING)
        {
            throw _constructError((new StringBuilder()).append("Current token (").append(_currToken).append(") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary").toString());
        }
        String s = getText();
        if (s == null)
        {
            return null;
        }
        ByteArrayBuilder bytearraybuilder1 = _byteBuilder;
        ByteArrayBuilder bytearraybuilder = bytearraybuilder1;
        if (bytearraybuilder1 == null)
        {
            bytearraybuilder = new ByteArrayBuilder(100);
            _byteBuilder = bytearraybuilder;
        }
        _decodeBase64(s, bytearraybuilder, base64variant);
        return bytearraybuilder.toByteArray();
    }

    public ObjectCodec getCodec()
    {
        return _codec;
    }

    public JsonLocation getCurrentLocation()
    {
        if (_location == null)
        {
            return JsonLocation.NA;
        } else
        {
            return _location;
        }
    }

    public String getCurrentName()
    {
        return _parsingContext.getCurrentName();
    }

    public BigDecimal getDecimalValue()
        throws IOException, JsonParseException
    {
        Number number = getNumberValue();
        if (number instanceof BigDecimal)
        {
            return (BigDecimal)number;
        }
        switch (chMap.org.codehaus.jackson.JsonParser.NumberType[getNumberType().ordinal()])
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            return BigDecimal.valueOf(number.doubleValue());

        case 1: // '\001'
        case 5: // '\005'
            return BigDecimal.valueOf(number.longValue());

        case 2: // '\002'
            return new BigDecimal((BigInteger)number);
        }
    }

    public double getDoubleValue()
        throws IOException, JsonParseException
    {
        return getNumberValue().doubleValue();
    }

    public Object getEmbeddedObject()
    {
        if (_currToken == JsonToken.VALUE_EMBEDDED_OBJECT)
        {
            return _currentObject();
        } else
        {
            return null;
        }
    }

    public float getFloatValue()
        throws IOException, JsonParseException
    {
        return getNumberValue().floatValue();
    }

    public int getIntValue()
        throws IOException, JsonParseException
    {
        if (_currToken == JsonToken.VALUE_NUMBER_INT)
        {
            return ((Number)_currentObject()).intValue();
        } else
        {
            return getNumberValue().intValue();
        }
    }

    public long getLongValue()
        throws IOException, JsonParseException
    {
        return getNumberValue().longValue();
    }

    public org.codehaus.jackson.pe getNumberType()
        throws IOException, JsonParseException
    {
        Number number = getNumberValue();
        if (number instanceof Integer)
        {
            return org.codehaus.jackson.pe.INT;
        }
        if (number instanceof Long)
        {
            return org.codehaus.jackson.pe.LONG;
        }
        if (number instanceof Double)
        {
            return org.codehaus.jackson.pe.DOUBLE;
        }
        if (number instanceof BigDecimal)
        {
            return org.codehaus.jackson.pe.BIG_DECIMAL;
        }
        if (number instanceof Float)
        {
            return org.codehaus.jackson.pe.FLOAT;
        }
        if (number instanceof BigInteger)
        {
            return org.codehaus.jackson.pe.BIG_INTEGER;
        } else
        {
            return null;
        }
    }

    public final Number getNumberValue()
        throws IOException, JsonParseException
    {
        _checkIsNumber();
        return (Number)_currentObject();
    }

    public String getText()
    {
        Object obj = null;
        if (_currToken != JsonToken.VALUE_STRING && _currToken != JsonToken.FIELD_NAME) goto _L2; else goto _L1
_L1:
        Object obj1 = _currentObject();
        if (!(obj1 instanceof String)) goto _L4; else goto _L3
_L3:
        String s = (String)obj1;
_L6:
        return s;
_L4:
        s = obj;
        if (obj1 != null)
        {
            return obj1.toString();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        s = obj;
        if (_currToken != null)
        {
            Object obj2;
            switch (chMap.org.codehaus.jackson.JsonToken[_currToken.ordinal()])
            {
            default:
                return _currToken.asString();

            case 7: // '\007'
            case 8: // '\b'
                obj2 = _currentObject();
                break;
            }
            s = obj;
            if (obj2 != null)
            {
                return obj2.toString();
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public char[] getTextCharacters()
    {
        String s = getText();
        if (s == null)
        {
            return null;
        } else
        {
            return s.toCharArray();
        }
    }

    public int getTextLength()
    {
        String s = getText();
        if (s == null)
        {
            return 0;
        } else
        {
            return s.length();
        }
    }

    public int getTextOffset()
    {
        return 0;
    }

    public JsonLocation getTokenLocation()
    {
        return getCurrentLocation();
    }

    public boolean hasTextCharacters()
    {
        return false;
    }

    public JsonToken nextToken()
        throws IOException, JsonParseException
    {
        if (!_closed && _segment != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int i = _segmentPtr + 1;
        _segmentPtr = i;
        if (i < 16)
        {
            break; /* Loop/switch isn't completed */
        }
        _segmentPtr = 0;
        _segment = _segment.next();
        if (_segment == null) goto _L1; else goto _L3
_L3:
        _currToken = _segment.type(_segmentPtr);
        if (_currToken != JsonToken.FIELD_NAME) goto _L5; else goto _L4
_L4:
        Object obj = _currentObject();
        if (obj instanceof String)
        {
            obj = (String)obj;
        } else
        {
            obj = obj.toString();
        }
        _parsingContext.setCurrentName(((String) (obj)));
_L7:
        return _currToken;
_L5:
        if (_currToken == JsonToken.START_OBJECT)
        {
            _parsingContext = _parsingContext.createChildObjectContext(-1, -1);
        } else
        if (_currToken == JsonToken.START_ARRAY)
        {
            _parsingContext = _parsingContext.createChildArrayContext(-1, -1);
        } else
        if (_currToken == JsonToken.END_OBJECT || _currToken == JsonToken.END_ARRAY)
        {
            _parsingContext = _parsingContext.getParent();
            if (_parsingContext == null)
            {
                _parsingContext = JsonReadContext.createRootContext(-1, -1);
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void setLocation(JsonLocation jsonlocation)
    {
        _location = jsonlocation;
    }

    public ( , ObjectCodec objectcodec)
    {
        super(0);
        _location = null;
        _segment = ;
        _segmentPtr = -1;
        _codec = objectcodec;
        _parsingContext = JsonReadContext.createRootContext(-1, -1);
    }
}
