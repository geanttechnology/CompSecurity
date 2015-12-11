// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.core:
//            JsonProcessingException, JsonFactory, JsonParser, TreeNode, 
//            JsonGenerator

public abstract class ObjectCodec
{

    protected ObjectCodec()
    {
    }

    public JsonFactory getFactory()
    {
        return getJsonFactory();
    }

    public abstract JsonFactory getJsonFactory();

    public abstract TreeNode readTree(JsonParser jsonparser)
        throws IOException, JsonProcessingException;

    public abstract Object readValue(JsonParser jsonparser, TypeReference typereference)
        throws IOException, JsonProcessingException;

    public abstract Object readValue(JsonParser jsonparser, Class class1)
        throws IOException, JsonProcessingException;

    public abstract void writeValue(JsonGenerator jsongenerator, Object obj)
        throws IOException, JsonProcessingException;
}
