// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.Closeable;

// Referenced classes of package d:
//            f, ac

public interface ab
    extends Closeable
{

    public abstract void close();

    public abstract long read(f f, long l);

    public abstract ac timeout();
}
