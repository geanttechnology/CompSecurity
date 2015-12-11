// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;


// Referenced classes of package shared_presage.com.google.android.exoplayer.upstream:
//            DefaultBandwidthMeter

final class a
    implements Runnable
{

    final int a;
    final long b;
    final long c;
    final DefaultBandwidthMeter d;

    a(DefaultBandwidthMeter defaultbandwidthmeter, int i, long l, long l1)
    {
        d = defaultbandwidthmeter;
        a = i;
        b = l;
        c = l1;
        super();
    }

    public final void run()
    {
        DefaultBandwidthMeter.access$000(d).onBandwidthSample(a, b, c);
    }
}
