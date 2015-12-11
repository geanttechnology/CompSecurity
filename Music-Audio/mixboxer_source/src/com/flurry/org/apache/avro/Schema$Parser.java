// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonParseException;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema, SchemaParseException

public static class validate
{

    private validate names;
    private boolean validate;

    private Schema parse(JsonParser jsonparser)
        throws IOException
    {
        boolean flag = ((Boolean)Schema.access$1500().get()).booleanValue();
        Schema.access$1500().set(Boolean.valueOf(validate));
        jsonparser = Schema.parse(Schema.MAPPER.readTree(jsonparser), names);
        Schema.access$1500().set(Boolean.valueOf(flag));
        return jsonparser;
        jsonparser;
        throw new SchemaParseException(jsonparser);
        jsonparser;
        Schema.access$1500().set(Boolean.valueOf(flag));
        throw jsonparser;
    }

    public _cls1500 addTypes(Map map)
    {
        Schema schema;
        for (map = map.values().iterator(); map.hasNext(); names.dd(schema))
        {
            schema = (Schema)map.next();
        }

        return this;
    }

    public Map getTypes()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        Schema schema;
        for (Iterator iterator = names.alues().iterator(); iterator.hasNext(); linkedhashmap.put(schema.getFullName(), schema))
        {
            schema = (Schema)iterator.next();
        }

        return linkedhashmap;
    }

    public boolean getValidate()
    {
        return validate;
    }

    public Schema parse(File file)
        throws IOException
    {
        return parse(Schema.FACTORY.createJsonParser(file));
    }

    public Schema parse(InputStream inputstream)
        throws IOException
    {
        return parse(Schema.FACTORY.createJsonParser(inputstream));
    }

    public Schema parse(String s)
    {
        try
        {
            s = parse(Schema.FACTORY.createJsonParser(new StringReader(s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SchemaParseException(s);
        }
        return s;
    }

    public eption setValidate(boolean flag)
    {
        validate = flag;
        return this;
    }

    public Exception()
    {
        names = new init>();
        validate = true;
    }
}
