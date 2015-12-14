// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity.mime;

import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.ContentUtil;

public class MinimalField
    implements Field
{

    private final String name;
    private ByteSequence raw;
    private final String value;

    MinimalField(String s, String s1)
    {
        name = s;
        value = s1;
        raw = null;
    }

    public String getBody()
    {
        return value;
    }

    public String getName()
    {
        return name;
    }

    public ByteSequence getRaw()
    {
        if (raw == null)
        {
            raw = ContentUtil.encode(toString());
        }
        return raw;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(name);
        stringbuilder.append(": ");
        stringbuilder.append(value);
        return stringbuilder.toString();
    }
}
