// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field;

import org.apache.james.mime4j.util.ByteSequence;

// Referenced classes of package org.apache.james.mime4j.field:
//            AbstractField, FieldParser, ParsedField

public class ContentTransferEncodingField extends AbstractField
{

    static final FieldParser PARSER = new FieldParser() {

        public ParsedField parse(String s, String s1, ByteSequence bytesequence)
        {
            return new ContentTransferEncodingField(s, s1, bytesequence);
        }

    };
    private String encoding;

    ContentTransferEncodingField(String s, String s1, ByteSequence bytesequence)
    {
        super(s, s1, bytesequence);
        encoding = s1.trim().toLowerCase();
    }

    public static String getEncoding(ContentTransferEncodingField contenttransferencodingfield)
    {
        if (contenttransferencodingfield != null && contenttransferencodingfield.getEncoding().length() != 0)
        {
            return contenttransferencodingfield.getEncoding();
        } else
        {
            return "7bit";
        }
    }

    public String getEncoding()
    {
        return encoding;
    }

}
