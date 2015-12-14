// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field;

import org.apache.james.mime4j.util.ByteSequence;

// Referenced classes of package org.apache.james.mime4j.field:
//            FieldParser, MailboxField, ParsedField

static final class 
    implements FieldParser
{

    public ParsedField parse(String s, String s1, ByteSequence bytesequence)
    {
        return new MailboxField(s, s1, bytesequence);
    }

    ()
    {
    }
}
