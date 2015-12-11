// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import java.io.InputStream;

// Referenced classes of package org.apache.james.mime4j.stream:
//            EntityStateMachine, EntityState, BodyDescriptor, Field, 
//            RawField, RecursionMode

public class RawEntity
    implements EntityStateMachine
{

    private EntityState state;
    private final InputStream stream;

    RawEntity(InputStream inputstream)
    {
        stream = inputstream;
        state = EntityState.T_RAW_ENTITY;
    }

    public EntityStateMachine advance()
    {
        state = EntityState.T_END_OF_STREAM;
        return null;
    }

    public BodyDescriptor getBodyDescriptor()
    {
        return null;
    }

    public InputStream getContentStream()
    {
        return stream;
    }

    public InputStream getDecodedContentStream()
        throws IllegalStateException
    {
        throw new IllegalStateException("Raw entity does not support stream decoding");
    }

    public volatile Field getField()
        throws IllegalStateException
    {
        return getField();
    }

    public RawField getField()
    {
        return null;
    }

    public String getFieldName()
    {
        return null;
    }

    public String getFieldValue()
    {
        return null;
    }

    public EntityState getState()
    {
        return state;
    }

    public void setRecursionMode(RecursionMode recursionmode)
    {
    }
}
