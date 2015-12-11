// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.util.ByteArrayBuffer;

// Referenced classes of package org.apache.james.mime4j.io:
//            MaxLineLimitException

public abstract class LineReaderInputStream extends FilterInputStream
{

    protected LineReaderInputStream(InputStream inputstream)
    {
        super(inputstream);
    }

    public abstract int readLine(ByteArrayBuffer bytearraybuffer)
        throws MaxLineLimitException, IOException;

    public abstract boolean unread(ByteArrayBuffer bytearraybuffer);
}
