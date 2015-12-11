// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import java.util.Arrays;
import shared_presage.com.google.android.exoplayer.chunk.DataChunk;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            HlsChunkSource

private static final class b extends DataChunk
{

    public final String a;
    public final int b;
    private byte c[];

    public final byte[] a()
    {
        return c;
    }

    protected final void consume(byte abyte0[], int i)
    {
        c = Arrays.copyOf(abyte0, i);
    }

    public (DataSource datasource, DataSpec dataspec, byte abyte0[], String s, int i)
    {
        super(datasource, dataspec, 3, 0, null, abyte0);
        a = s;
        b = i;
    }
}
