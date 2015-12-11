// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import java.io.IOException;

// Referenced classes of package shared_presage.com.google.android.exoplayer.util:
//            ManifestFetcher

final class c
    implements Runnable
{

    final IOException a;
    final ManifestFetcher b;

    c(ManifestFetcher manifestfetcher, IOException ioexception)
    {
        b = manifestfetcher;
        a = ioexception;
        super();
    }

    public final void run()
    {
        ManifestFetcher.access$000(b).onManifestError(a);
    }
}
