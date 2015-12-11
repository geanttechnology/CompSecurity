// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema, SchemaParseException

private static class on extends 
{

    private final Map ordinals = new HashMap();
    private final List symbols;

    int computeHash()
    {
        return super.computeHash() + symbols.hashCode();
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ))
            {
                return false;
            }
            obj = ()obj;
            if (!equalCachedHash(((Schema) (obj))) || !equalNames((() (obj))) || !symbols.equals(((symbols) (obj)).symbols) || !props.s(((s) (obj)).props))
            {
                return false;
            }
        }
        return true;
    }

    public int getEnumOrdinal(String s)
    {
        return ((Integer)ordinals.get(s)).intValue();
    }

    public List getEnumSymbols()
    {
        return symbols;
    }

    public boolean hasEnumSymbol(String s)
    {
        return ordinals.containsKey(s);
    }

    void toJson( , JsonGenerator jsongenerator)
        throws IOException
    {
        if (writeNameRef(, jsongenerator))
        {
            return;
        }
        jsongenerator.writeStartObject();
        jsongenerator.writeStringField("type", "enum");
        writeName(, jsongenerator);
        if (getDoc() != null)
        {
            jsongenerator.writeStringField("doc", getDoc());
        }
        jsongenerator.writeArrayFieldStart("symbols");
        for ( = symbols.iterator(); .hasNext(); jsongenerator.writeString((String).next())) { }
        jsongenerator.writeEndArray();
        props.(jsongenerator);
        aliasesToJson(jsongenerator);
        jsongenerator.writeEndObject();
    }

    public ayList(ayList aylist, String s, ayList aylist1)
    {
        super(, aylist, s);
        symbols = aylist1.lock();
        int i = 0;
        for (aylist = aylist1.iterator(); aylist.hasNext();)
        {
            s = (String)aylist.next();
            if (ordinals.put(Schema.access$200(s), Integer.valueOf(i)) != null)
            {
                throw new SchemaParseException((new StringBuilder()).append("Duplicate enum symbol: ").append(s).toString());
            }
            i++;
        }

    }
}
