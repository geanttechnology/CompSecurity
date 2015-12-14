// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            DataSpec

public interface DataSink
{

    public abstract void close()
        throws IOException;

    public abstract DataSink open(DataSpec dataspec)
        throws IOException;

    public abstract void write(byte abyte0[], int i, int j)
        throws IOException;
}
