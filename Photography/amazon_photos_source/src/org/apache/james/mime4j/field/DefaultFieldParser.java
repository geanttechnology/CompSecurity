// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field;


// Referenced classes of package org.apache.james.mime4j.field:
//            DelegatingFieldParser, ContentTransferEncodingField, ContentTypeField, ContentDispositionField, 
//            DateTimeField, MailboxListField, MailboxField, AddressListField

public class DefaultFieldParser extends DelegatingFieldParser
{

    public DefaultFieldParser()
    {
        setFieldParser("Content-Transfer-Encoding", ContentTransferEncodingField.PARSER);
        setFieldParser("Content-Type", ContentTypeField.PARSER);
        setFieldParser("Content-Disposition", ContentDispositionField.PARSER);
        FieldParser fieldparser = DateTimeField.PARSER;
        setFieldParser("Date", fieldparser);
        setFieldParser("Resent-Date", fieldparser);
        fieldparser = MailboxListField.PARSER;
        setFieldParser("From", fieldparser);
        setFieldParser("Resent-From", fieldparser);
        fieldparser = MailboxField.PARSER;
        setFieldParser("Sender", fieldparser);
        setFieldParser("Resent-Sender", fieldparser);
        fieldparser = AddressListField.PARSER;
        setFieldParser("To", fieldparser);
        setFieldParser("Resent-To", fieldparser);
        setFieldParser("Cc", fieldparser);
        setFieldParser("Resent-Cc", fieldparser);
        setFieldParser("Bcc", fieldparser);
        setFieldParser("Resent-Bcc", fieldparser);
        setFieldParser("Reply-To", fieldparser);
    }
}
