// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import java.io.IOException;
import org.joda.time.Period;
import org.joda.time.ReadablePeriod;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ext:
//            JodaDeserializers

public static class nit> extends nit>
{

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public ReadablePeriod deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        switch (dehaus.jackson.JsonToken[jsonparser.getCurrentToken().ordinal()])
        {
        default:
            throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.START_ARRAY, "expected JSON Number or String");

        case 1: // '\001'
            return new Period(jsonparser.getLongValue());

        case 2: // '\002'
            return new Period(jsonparser.getText());
        }
    }

    public ()
    {
        super(org/joda/time/ReadablePeriod);
    }
}
