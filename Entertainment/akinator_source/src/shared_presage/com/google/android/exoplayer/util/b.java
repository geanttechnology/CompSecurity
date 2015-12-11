// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;


// Referenced classes of package shared_presage.com.google.android.exoplayer.util:
//            ManifestFetcher

final class b
    implements Runnable
{

    final ManifestFetcher a;

    b(ManifestFetcher manifestfetcher)
    {
        a = manifestfetcher;
        super();
    }

    public final void run()
    {
        ManifestFetcher.access$000(a).onManifestRefreshed();
    }
}
