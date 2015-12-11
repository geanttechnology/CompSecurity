// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import org.apache.james.mime4j.MimeException;

// Referenced classes of package org.apache.james.mime4j.stream:
//            RawField, Field, BodyDescriptor

public interface BodyDescriptorBuilder
{

    public abstract Field addField(RawField rawfield)
        throws MimeException;

    public abstract BodyDescriptor build();

    public abstract BodyDescriptorBuilder newChild();

    public abstract void reset();
}
