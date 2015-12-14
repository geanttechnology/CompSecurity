// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field;

import java.util.HashMap;
import java.util.Map;
import org.apache.james.mime4j.util.ByteSequence;

// Referenced classes of package org.apache.james.mime4j.field:
//            FieldParser, UnstructuredField, ParsedField

public class DelegatingFieldParser
    implements FieldParser
{

    private FieldParser defaultParser;
    private Map parsers;

    public DelegatingFieldParser()
    {
        parsers = new HashMap();
        defaultParser = UnstructuredField.PARSER;
    }

    public FieldParser getParser(String s)
    {
        FieldParser fieldparser = (FieldParser)parsers.get(s.toLowerCase());
        s = fieldparser;
        if (fieldparser == null)
        {
            s = defaultParser;
        }
        return s;
    }

    public ParsedField parse(String s, String s1, ByteSequence bytesequence)
    {
        return getParser(s).parse(s, s1, bytesequence);
    }

    public void setFieldParser(String s, FieldParser fieldparser)
    {
        parsers.put(s.toLowerCase(), fieldparser);
    }
}
