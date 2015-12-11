// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.JsonLocation;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonStreamContext;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.ObjectCodec;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            JsonDecoder

class pos extends JsonParser
{

    int pos;
    final JsonDecoder this$0;
    final List val$elements;

    public void close()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public BigInteger getBigIntegerValue()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public byte[] getBinaryValue(Base64Variant base64variant)
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public ObjectCodec getCodec()
    {
        throw new UnsupportedOperationException();
    }

    public JsonLocation getCurrentLocation()
    {
        throw new UnsupportedOperationException();
    }

    public String getCurrentName()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public JsonToken getCurrentToken()
    {
        return ((onElement)val$elements.get(pos)).token;
    }

    public BigDecimal getDecimalValue()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public double getDoubleValue()
        throws IOException
    {
        return Double.parseDouble(getText());
    }

    public float getFloatValue()
        throws IOException
    {
        return Float.parseFloat(getText());
    }

    public int getIntValue()
        throws IOException
    {
        return Integer.parseInt(getText());
    }

    public long getLongValue()
        throws IOException
    {
        return Long.parseLong(getText());
    }

    public com.flurry.org.codehaus.jackson.berType getNumberType()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public Number getNumberValue()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public JsonStreamContext getParsingContext()
    {
        throw new UnsupportedOperationException();
    }

    public String getText()
        throws IOException
    {
        return ((onElement)val$elements.get(pos)).value;
    }

    public char[] getTextCharacters()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public int getTextLength()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public int getTextOffset()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public JsonLocation getTokenLocation()
    {
        throw new UnsupportedOperationException();
    }

    public boolean isClosed()
    {
        throw new UnsupportedOperationException();
    }

    public JsonToken nextToken()
        throws IOException
    {
        pos = pos + 1;
        return ((onElement)val$elements.get(pos)).token;
    }

    public void setCodec(ObjectCodec objectcodec)
    {
        throw new UnsupportedOperationException();
    }

    public JsonParser skipChildren()
        throws IOException
    {
        int j = 0;
_L2:
        int i;
        int ai[] = .SwitchMap.org.codehaus.jackson.JsonToken;
        List list = val$elements;
        i = pos;
        pos = i + 1;
        switch (ai[((onElement)list.get(i)).token.ordinal()])
        {
        default:
            i = j;
            break;

        case 1: // '\001'
        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 3: // '\003'
        case 4: // '\004'
            break MISSING_BLOCK_LABEL_92;
        }
_L3:
        j = i;
        if (i <= 0)
        {
            return this;
        }
        if (true) goto _L2; else goto _L1
_L1:
        i = j + 1;
          goto _L3
        i = j - 1;
          goto _L3
    }

    ()
    {
        this$0 = final_jsondecoder;
        val$elements = List.this;
        super();
        pos = 0;
    }
}
