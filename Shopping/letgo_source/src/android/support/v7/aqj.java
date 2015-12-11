// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            aql, apv

public interface aqj
    extends Closeable, Flushable
{

    public abstract void close()
        throws IOException;

    public abstract void flush()
        throws IOException;

    public abstract aql timeout();

    public abstract void write(apv apv, long l)
        throws IOException;
}
