// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders;
import java.io.IOException;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.std:
//            PrimitiveArrayDeserializers

static final class  extends 
{

    private final double[] handleNonArray(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_STRING && deserializationcontext.isEnabled(com.flurry.org.codehaus.jackson.map.TY_STRING_AS_NULL_OBJECT) && jsonparser.getText().length() == 0)
        {
            return null;
        }
        if (!deserializationcontext.isEnabled(com.flurry.org.codehaus.jackson.map.GLE_VALUE_AS_ARRAY))
        {
            throw deserializationcontext.mappingException(_valueClass);
        } else
        {
            return (new double[] {
                _parseDoublePrimitive(jsonparser, deserializationcontext)
            });
        }
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public double[] deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (!jsonparser.isExpectedStartArrayToken())
        {
            return handleNonArray(jsonparser, deserializationcontext);
        }
        com.flurry.org.codehaus.jackson.map.util.eser eser = deserializationcontext.getArrayBuilders().getDoubleBuilder();
        double ad[] = (double[])eser.t();
        int i = 0;
        while (jsonparser.nextToken() != JsonToken.END_ARRAY) 
        {
            double d = _parseDoublePrimitive(jsonparser, deserializationcontext);
            double ad1[] = ad;
            int j = i;
            if (i >= ad.length)
            {
                ad1 = (double[])eser.tedChunk(ad, i);
                j = 0;
            }
            ad1[j] = d;
            i = j + 1;
            ad = ad1;
        }
        return (double[])eser.learBuffer(ad, i);
    }

    public ()
    {
        super([D);
    }
}
