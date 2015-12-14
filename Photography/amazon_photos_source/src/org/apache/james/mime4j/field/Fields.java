// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field;

import java.util.regex.Pattern;
import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.util.ContentUtil;
import org.apache.james.mime4j.util.MimeUtil;

// Referenced classes of package org.apache.james.mime4j.field:
//            ContentTypeField, FieldParser

public class Fields
{

    private static final Pattern FIELD_NAME_PATTERN = Pattern.compile("[\\x21-\\x39\\x3b-\\x7e]+");

    public static ContentTypeField contentType(String s)
    {
        return (ContentTypeField)parse(ContentTypeField.PARSER, "Content-Type", s);
    }

    private static Field parse(FieldParser fieldparser, String s, String s1)
    {
        return fieldparser.parse(s, s1, ContentUtil.encode(MimeUtil.fold((new StringBuilder()).append(s).append(": ").append(s1).toString(), 0)));
    }

}
