// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import java.io.ByteArrayInputStream;
import shared_presage.com.google.android.exoplayer.chunk.DataChunk;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            HlsChunkSource, HlsPlaylistParser, HlsMediaPlaylist

private static final class c extends DataChunk
{

    public final int a;
    private final HlsPlaylistParser b;
    private final String c;
    private HlsMediaPlaylist d;

    public final HlsMediaPlaylist a()
    {
        return d;
    }

    protected final void consume(byte abyte0[], int i)
    {
        d = (HlsMediaPlaylist)b.parse(c, new ByteArrayInputStream(abyte0, 0, i));
    }

    public (DataSource datasource, DataSpec dataspec, byte abyte0[], HlsPlaylistParser hlsplaylistparser, int i, String s)
    {
        super(datasource, dataspec, 4, 0, null, abyte0);
        a = i;
        b = hlsplaylistparser;
        c = s;
    }
}
