// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema, AvroTypeException

private static abstract class _cls400 extends Schema
{

    Set aliases;
    final String doc;
    final name name;

    public void addAlias(String s)
    {
        if (aliases == null)
        {
            aliases = new LinkedHashSet();
        }
        aliases.add(new aliases(s, _mth600(name)));
    }

    public void aliasesToJson(JsonGenerator jsongenerator)
        throws IOException
    {
        if (aliases == null || aliases.size() == 0)
        {
            return;
        }
        jsongenerator.writeFieldName("aliases");
        jsongenerator.writeStartArray();
        for (Iterator iterator = aliases.iterator(); iterator.hasNext(); jsongenerator.writeString(((writeString)iterator.next()).ified(_mth600(name)))) { }
        jsongenerator.writeEndArray();
    }

    int computeHash()
    {
        return super.computeHash() + name.e();
    }

    public boolean equalNames(e e)
    {
        return name.name(e.name);
    }

    public Set getAliases()
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        if (aliases != null)
        {
            for (Iterator iterator = aliases.iterator(); iterator.hasNext(); linkedhashset.add(_mth400((_cls400)iterator.next()))) { }
        }
        return linkedhashset;
    }

    public String getDoc()
    {
        return doc;
    }

    public String getFullName()
    {
        return _mth400(name);
    }

    public String getName()
    {
        return _mth500(name);
    }

    public String getNamespace()
    {
        return _mth600(name);
    }

    public void writeName(name name1, JsonGenerator jsongenerator)
        throws IOException
    {
        name.me(name1, jsongenerator);
    }

    public boolean writeNameRef(me me, JsonGenerator jsongenerator)
        throws IOException
    {
        if (equals(me.equals(name)))
        {
            jsongenerator.writeString(name.ified(me.ified()));
            return true;
        }
        if (_mth500(name) != null)
        {
            me.name(name, this);
        }
        return false;
    }

    public ( ,  1, String s)
    {
        super();
        name = 1;
        doc = s;
        if (PRIMITIVES.containsKey(_mth400(1)))
        {
            throw new AvroTypeException((new StringBuilder()).append("Schemas may not be named after primitives: ").append(_mth400(1)).toString());
        } else
        {
            return;
        }
    }
}
