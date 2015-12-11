// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.util.ByteArrayBuffer;

// Referenced classes of package org.apache.james.mime4j.stream:
//            RawField

public interface FieldBuilder
{

    public abstract void append(ByteArrayBuffer bytearraybuffer)
        throws MimeException;

    public abstract RawField build()
        throws MimeException;

    public abstract ByteArrayBuffer getRaw();

    public abstract void reset();
}
