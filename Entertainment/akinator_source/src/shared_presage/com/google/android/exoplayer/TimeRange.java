// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


public final class TimeRange
{

    public static final int TYPE_SNAPSHOT = 0;
    private final long endTimeUs;
    private final long startTimeUs;
    public final int type;

    public TimeRange(int i, long l, long l1)
    {
        type = i;
        startTimeUs = l;
        endTimeUs = l1;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof TimeRange)
            {
                if (((TimeRange) (obj = (TimeRange)obj)).type != type || ((TimeRange) (obj)).startTimeUs != startTimeUs || ((TimeRange) (obj)).endTimeUs != endTimeUs)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final long[] getCurrentBoundsMs(long al[])
    {
        al = getCurrentBoundsUs(al);
        al[0] = al[0] / 1000L;
        al[1] = al[1] / 1000L;
        return al;
    }

    public final long[] getCurrentBoundsUs(long al[])
    {
        long al1[];
label0:
        {
            if (al != null)
            {
                al1 = al;
                if (al.length >= 2)
                {
                    break label0;
                }
            }
            al1 = new long[2];
        }
        al1[0] = startTimeUs;
        al1[1] = endTimeUs;
        return al1;
    }

    public final int hashCode()
    {
        return (int)((long)(type << 30 | 0) | (startTimeUs + endTimeUs) / 1000L & 0x3fffffffL);
    }
}
