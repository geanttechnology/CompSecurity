// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import java.util.Comparator;

final class e
    implements Comparator
{

    e()
    {
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (SlidingPercentile.a)obj;
        obj1 = (SlidingPercentile.a)obj1;
        if (((SlidingPercentile.a) (obj)).c < ((SlidingPercentile.a) (obj1)).c)
        {
            return -1;
        }
        return ((SlidingPercentile.a) (obj1)).c >= ((SlidingPercentile.a) (obj)).c ? 0 : 1;
    }
}
