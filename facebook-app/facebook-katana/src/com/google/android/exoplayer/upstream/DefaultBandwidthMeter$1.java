// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;


// Referenced classes of package com.google.android.exoplayer.upstream:
//            DefaultBandwidthMeter

class c
    implements Runnable
{

    final int a;
    final long b;
    final long c;
    final DefaultBandwidthMeter d;

    public void run()
    {
    }

    (DefaultBandwidthMeter defaultbandwidthmeter, int i, long l, long l1)
    {
        d = defaultbandwidthmeter;
        a = i;
        b = l;
        c = l1;
        super();
    }
}
