// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            ListDeserializer, JsonDeserializer, SimpleDeserializers

public class SimpleListDeserializers
{
    private static class StringDeserializer
        implements JsonDeserializer
    {

        public volatile Object deserialize(JsonParser jsonparser)
            throws IOException
        {
            return deserialize(jsonparser);
        }

        public String deserialize(JsonParser jsonparser)
            throws IOException
        {
            return SimpleDeserializers.deserializeString(jsonparser);
        }

        StringDeserializer()
        {
        }
    }


    public static final JsonDeserializer STRING_LIST_DESERIALIZER = new ListDeserializer(new StringDeserializer());

}
