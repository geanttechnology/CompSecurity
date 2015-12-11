// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Closeable;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            apv, aql

public interface aqk
    extends Closeable
{

    public abstract void close()
        throws IOException;

    public abstract long read(apv apv, long l)
        throws IOException;

    public abstract aql timeout();
}
