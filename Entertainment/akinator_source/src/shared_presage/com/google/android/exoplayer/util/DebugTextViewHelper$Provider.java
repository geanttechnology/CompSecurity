// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import shared_presage.com.google.android.exoplayer.CodecCounters;
import shared_presage.com.google.android.exoplayer.chunk.Format;
import shared_presage.com.google.android.exoplayer.upstream.BandwidthMeter;

// Referenced classes of package shared_presage.com.google.android.exoplayer.util:
//            DebugTextViewHelper

public static interface 
{

    public abstract BandwidthMeter getBandwidthMeter();

    public abstract CodecCounters getCodecCounters();

    public abstract long getCurrentPosition();

    public abstract Format getFormat();
}
