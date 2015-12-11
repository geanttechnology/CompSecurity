// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ext:
//            JodaDeserializers

public static class Y extends Y
{

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.isExpectedStartArrayToken())
        {
            jsonparser.nextToken();
            int j = jsonparser.getIntValue();
            jsonparser.nextToken();
            int k = jsonparser.getIntValue();
            jsonparser.nextToken();
            int l = jsonparser.getIntValue();
            jsonparser.nextToken();
            int i1 = jsonparser.getIntValue();
            jsonparser.nextToken();
            int j1 = jsonparser.getIntValue();
            jsonparser.nextToken();
            int k1 = jsonparser.getIntValue();
            int i = 0;
            if (jsonparser.nextToken() != JsonToken.END_ARRAY)
            {
                i = jsonparser.getIntValue();
                jsonparser.nextToken();
            }
            if (jsonparser.getCurrentToken() != JsonToken.END_ARRAY)
            {
                throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.END_ARRAY, "after LocalDateTime ints");
            } else
            {
                return new LocalDateTime(j, k, l, i1, j1, k1, i);
            }
        }
        switch (jackson.JsonToken[jsonparser.getCurrentToken().ordinal()])
        {
        default:
            throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.START_ARRAY, "expected JSON Array or Number");

        case 1: // '\001'
            return new LocalDateTime(jsonparser.getLongValue());

        case 2: // '\002'
            jsonparser = parseLocal(jsonparser);
            break;
        }
        if (jsonparser == null)
        {
            return null;
        } else
        {
            return jsonparser.toLocalDateTime();
        }
    }

    public Y()
    {
        super(org/joda/time/LocalDateTime);
    }
}
