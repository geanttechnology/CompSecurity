// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.Closeable;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            OkBuffer

public interface Sink
    extends Closeable
{

    public abstract void close()
        throws IOException;

    public abstract void flush()
        throws IOException;

    public abstract void write(OkBuffer okbuffer, long l)
        throws IOException;
}
