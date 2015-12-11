// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.data;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.DatumWriter;
import com.flurry.org.apache.avro.io.Encoder;
import com.flurry.org.codehaus.jackson.JsonNode;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.data:
//            Json

public static class 
    implements DatumWriter
{

    public void setSchema(Schema schema)
    {
        if (!Json.SCHEMA.equals(schema))
        {
            throw new RuntimeException((new StringBuilder()).append("Not the Json schema: ").append(schema).toString());
        } else
        {
            return;
        }
    }

    public void write(JsonNode jsonnode, Encoder encoder)
        throws IOException
    {
        Json.write(jsonnode, encoder);
    }

    public volatile void write(Object obj, Encoder encoder)
        throws IOException
    {
        write((JsonNode)obj, encoder);
    }

    public ()
    {
    }
}
