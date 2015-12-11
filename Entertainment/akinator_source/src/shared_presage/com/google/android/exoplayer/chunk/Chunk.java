// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            Format

public abstract class Chunk
    implements shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable
{

    public static final int TRIGGER_ADAPTIVE = 3;
    public static final int TRIGGER_CUSTOM_BASE = 10000;
    public static final int TRIGGER_INITIAL = 1;
    public static final int TRIGGER_MANUAL = 2;
    public static final int TRIGGER_TRICK_PLAY = 4;
    public static final int TRIGGER_UNSPECIFIED = 0;
    public static final int TYPE_CUSTOM_BASE = 10000;
    public static final int TYPE_DRM = 3;
    public static final int TYPE_MANIFEST = 4;
    public static final int TYPE_MEDIA = 1;
    public static final int TYPE_MEDIA_INITIALIZATION = 2;
    public static final int TYPE_UNSPECIFIED = 0;
    protected final DataSource dataSource;
    public final DataSpec dataSpec;
    public final Format format;
    public final int trigger;
    public final int type;

    public Chunk(DataSource datasource, DataSpec dataspec, int i, int j, Format format1)
    {
        dataSource = (DataSource)Assertions.checkNotNull(datasource);
        dataSpec = (DataSpec)Assertions.checkNotNull(dataspec);
        type = i;
        trigger = j;
        format = format1;
    }

    public abstract long bytesLoaded();
}
