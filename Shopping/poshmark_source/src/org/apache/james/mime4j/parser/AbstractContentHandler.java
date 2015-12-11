// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.parser;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.stream.BodyDescriptor;
import org.apache.james.mime4j.stream.Field;

// Referenced classes of package org.apache.james.mime4j.parser:
//            ContentHandler

public abstract class AbstractContentHandler
    implements ContentHandler
{

    public AbstractContentHandler()
    {
    }

    public void body(BodyDescriptor bodydescriptor, InputStream inputstream)
        throws MimeException, IOException
    {
    }

    public void endBodyPart()
        throws MimeException
    {
    }

    public void endHeader()
        throws MimeException
    {
    }

    public void endMessage()
        throws MimeException
    {
    }

    public void endMultipart()
        throws MimeException
    {
    }

    public void epilogue(InputStream inputstream)
        throws MimeException, IOException
    {
    }

    public void field(Field field1)
        throws MimeException
    {
    }

    public void preamble(InputStream inputstream)
        throws MimeException, IOException
    {
    }

    public void raw(InputStream inputstream)
        throws MimeException, IOException
    {
    }

    public void startBodyPart()
        throws MimeException
    {
    }

    public void startHeader()
        throws MimeException
    {
    }

    public void startMessage()
        throws MimeException
    {
    }

    public void startMultipart(BodyDescriptor bodydescriptor)
        throws MimeException
    {
    }
}
