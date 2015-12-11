// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import java.util.Comparator;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            Variant

final class b
    implements Comparator
{

    private final Comparator a = new shared_presage.com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator();

    b()
    {
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (Variant)obj;
        obj1 = (Variant)obj1;
        return a.compare(((Variant) (obj)).format, ((Variant) (obj1)).format);
    }
}
