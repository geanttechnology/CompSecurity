// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.data;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.Decoder;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.io.ResolvingDecoder;
import com.flurry.org.codehaus.jackson.JsonNode;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.data:
//            Json

public static class er
    implements DatumReader
{

    private ResolvingDecoder resolver;
    private Schema written;

    public JsonNode read(JsonNode jsonnode, Decoder decoder)
        throws IOException
    {
        if (written == null)
        {
            return Json.read(decoder);
        }
        if (resolver == null)
        {
            resolver = DecoderFactory.get().resolvingDecoder(written, Json.SCHEMA, null);
        }
        resolver.configure(decoder);
        jsonnode = Json.read(resolver);
        resolver.drain();
        return jsonnode;
    }

    public volatile Object read(Object obj, Decoder decoder)
        throws IOException
    {
        return read((JsonNode)obj, decoder);
    }

    public void setSchema(Schema schema)
    {
        if (Json.SCHEMA.equals(written))
        {
            schema = null;
        }
        written = schema;
    }

    public er()
    {
    }
}
