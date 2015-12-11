// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;


// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            HlsSampleSource

final class f
    implements Runnable
{

    final long a;
    final HlsSampleSource b;

    f(HlsSampleSource hlssamplesource, long l)
    {
        b = hlssamplesource;
        a = l;
        super();
    }

    public final void run()
    {
        HlsSampleSource.access$100(b).onLoadCanceled(HlsSampleSource.access$000(b), a);
    }
}
