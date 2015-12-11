// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.parser;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.stream.BodyDescriptor;
import org.apache.james.mime4j.stream.Field;

public interface ContentHandler
{

    public abstract void body(BodyDescriptor bodydescriptor, InputStream inputstream)
        throws MimeException, IOException;

    public abstract void endBodyPart()
        throws MimeException;

    public abstract void endHeader()
        throws MimeException;

    public abstract void endMessage()
        throws MimeException;

    public abstract void endMultipart()
        throws MimeException;

    public abstract void epilogue(InputStream inputstream)
        throws MimeException, IOException;

    public abstract void field(Field field1)
        throws MimeException;

    public abstract void preamble(InputStream inputstream)
        throws MimeException, IOException;

    public abstract void raw(InputStream inputstream)
        throws MimeException, IOException;

    public abstract void startBodyPart()
        throws MimeException;

    public abstract void startHeader()
        throws MimeException;

    public abstract void startMessage()
        throws MimeException;

    public abstract void startMultipart(BodyDescriptor bodydescriptor)
        throws MimeException;
}
