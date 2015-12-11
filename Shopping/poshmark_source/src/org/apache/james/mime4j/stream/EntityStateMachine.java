// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.MimeException;

// Referenced classes of package org.apache.james.mime4j.stream:
//            BodyDescriptor, Field, EntityState, RecursionMode

public interface EntityStateMachine
{

    public abstract EntityStateMachine advance()
        throws IOException, MimeException;

    public abstract BodyDescriptor getBodyDescriptor()
        throws IllegalStateException;

    public abstract InputStream getContentStream()
        throws IllegalStateException;

    public abstract InputStream getDecodedContentStream()
        throws IllegalStateException;

    public abstract Field getField()
        throws IllegalStateException;

    public abstract EntityState getState();

    public abstract void setRecursionMode(RecursionMode recursionmode);
}
