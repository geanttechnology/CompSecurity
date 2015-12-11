// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson;

import java.io.IOException;

// Referenced classes of package org.codehaus.jackson:
//            JsonProcessingException, JsonParser, JsonNode, JsonGenerator

public abstract class ObjectCodec
{

    protected ObjectCodec()
    {
    }

    public abstract JsonNode readTree(JsonParser jsonparser)
        throws IOException, JsonProcessingException;

    public abstract void writeValue(JsonGenerator jsongenerator, Object obj)
        throws IOException, JsonProcessingException;
}
