// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.serialize;

import com.amazon.dp.logger.DPLogger;
import com.amazon.org.codehaus.jackson.JsonParser;
import com.amazon.org.codehaus.jackson.JsonProcessingException;
import com.amazon.org.codehaus.jackson.map.DeserializationContext;
import com.amazon.org.codehaus.jackson.map.DeserializationProblemHandler;
import com.amazon.org.codehaus.jackson.map.JsonDeserializer;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.communication.serialize:
//            JsonObjectMapper

class blemHandler extends DeserializationProblemHandler
{

    final JsonObjectMapper this$0;

    public boolean handleUnknownProperty(DeserializationContext deserializationcontext, JsonDeserializer jsondeserializer, Object obj, String s)
        throws IOException, JsonProcessingException
    {
        if (!JsonObjectMapper.access$000().contains(s))
        {
            JsonObjectMapper.access$100().debug("JsonObjectMapper", "Unknown field in Json input", new Object[] {
                "propertyName", s
            });
        }
        deserializationcontext.getParser().skipChildren();
        return true;
    }

    n()
    {
        this$0 = JsonObjectMapper.this;
        super();
    }
}
