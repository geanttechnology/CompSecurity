// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field;

import java.util.regex.Pattern;
import org.apache.james.mime4j.util.ByteSequence;

// Referenced classes of package org.apache.james.mime4j.field:
//            ParsedField, DefaultFieldParser

public abstract class AbstractField
    implements ParsedField
{

    private static final Pattern FIELD_NAME_PATTERN = Pattern.compile("^([\\x21-\\x39\\x3b-\\x7e]+):");
    private static final DefaultFieldParser parser = new DefaultFieldParser();
    private final String body;
    private final String name;
    private final ByteSequence raw;

    protected AbstractField(String s, String s1, ByteSequence bytesequence)
    {
        name = s;
        body = s1;
        raw = bytesequence;
    }

    public String getBody()
    {
        return body;
    }

    public String getName()
    {
        return name;
    }

    public ByteSequence getRaw()
    {
        return raw;
    }

    public String toString()
    {
        return (new StringBuilder()).append(name).append(": ").append(body).toString();
    }

}
