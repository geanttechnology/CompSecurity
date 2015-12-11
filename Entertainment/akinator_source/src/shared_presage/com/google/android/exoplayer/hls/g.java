// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import java.io.IOException;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            HlsSampleSource

final class g
    implements Runnable
{

    final IOException a;
    final HlsSampleSource b;

    g(HlsSampleSource hlssamplesource, IOException ioexception)
    {
        b = hlssamplesource;
        a = ioexception;
        super();
    }

    public final void run()
    {
        HlsSampleSource.access$100(b).onLoadError(HlsSampleSource.access$000(b), a);
    }
}
