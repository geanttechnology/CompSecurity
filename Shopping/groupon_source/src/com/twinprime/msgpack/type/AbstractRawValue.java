// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

// Referenced classes of package com.twinprime.msgpack.type:
//            RawValue, Value, ValueType, StringRawValueImpl

abstract class AbstractRawValue
    implements RawValue
{

    private static final char HEX_TABLE[] = "0123456789ABCDEF".toCharArray();

    AbstractRawValue()
    {
    }

    private void escapeChar(StringBuilder stringbuilder, int i)
    {
        stringbuilder.append("\\u");
        stringbuilder.append(HEX_TABLE[i >> 12 & 0xf]);
        stringbuilder.append(HEX_TABLE[i >> 8 & 0xf]);
        stringbuilder.append(HEX_TABLE[i >> 4 & 0xf]);
        stringbuilder.append(HEX_TABLE[i & 0xf]);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof Value)
            {
                obj = (Value)obj;
                flag = flag1;
                if (((Value) (obj)).getType() == ValueType.RAW)
                {
                    return Arrays.equals(getByteArray(), ((RawValue)(RawValue)((Value) (obj)).getValue()).getByteArray());
                }
            }
        }
        return flag;
    }

    public ValueType getType()
    {
        return ValueType.RAW;
    }

    public RawValue getValue()
    {
        return this;
    }

    public volatile Value getValue()
    {
        return getValue();
    }

    public int hashCode()
    {
        return Arrays.hashCode(getByteArray());
    }

    public String toString()
    {
        return toString(new StringBuilder()).toString();
    }

    public StringBuilder toString(StringBuilder stringbuilder)
    {
        char c;
        Object obj;
        int i;
        if (getClass() == com/twinprime/msgpack/type/StringRawValueImpl)
        {
            obj = getString();
        } else
        {
            obj = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.IGNORE).onUnmappableCharacter(CodingErrorAction.IGNORE);
            try
            {
                obj = ((CharsetDecoder) (obj)).decode(ByteBuffer.wrap(getByteArray())).toString();
            }
            catch (CharacterCodingException charactercodingexception)
            {
                charactercodingexception = new String(getByteArray());
            }
        }
        stringbuilder.append("\"");
        i = 0;
        if (i >= ((String) (obj)).length()) goto _L2; else goto _L1
_L1:
        c = ((String) (obj)).charAt(i);
        if (c >= ' ') goto _L4; else goto _L3
_L3:
        c;
        JVM INSTR tableswitch 8 13: default 84
    //                   8 194
    //                   9 174
    //                   10 154
    //                   11 84
    //                   12 184
    //                   13 164;
           goto _L5 _L6 _L7 _L8 _L5 _L9 _L10
_L5:
        escapeChar(stringbuilder, c);
_L11:
        i++;
        break MISSING_BLOCK_LABEL_24;
_L8:
        stringbuilder.append("\\n");
        continue; /* Loop/switch isn't completed */
_L10:
        stringbuilder.append("\\r");
        continue; /* Loop/switch isn't completed */
_L7:
        stringbuilder.append("\\t");
        continue; /* Loop/switch isn't completed */
_L9:
        stringbuilder.append("\\f");
        continue; /* Loop/switch isn't completed */
_L6:
        stringbuilder.append("\\b");
        if (true) goto _L11; else goto _L4
_L4:
        if (c <= '\177')
        {
            switch (c)
            {
            default:
                stringbuilder.append(c);
                break;

            case 92: // '\\'
                stringbuilder.append("\\\\");
                break;

            case 34: // '"'
                stringbuilder.append("\\\"");
                break;
            }
        } else
        if (c >= '\uD800' && c <= '\uDFFF')
        {
            escapeChar(stringbuilder, c);
        } else
        {
            stringbuilder.append(c);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        stringbuilder.append("\"");
        return stringbuilder;
        if (true) goto _L11; else goto _L12
_L12:
    }

}
