// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


public class RelativeTime
{

    private long end;
    public final long start;

    public RelativeTime(long l)
    {
        start = l;
    }

    public long getDuration(int i)
    {
        i = 1000 / i;
        long l1 = end - start;
        long l = l1;
        if (l1 < (long)i)
        {
            l = i + 1;
        }
        return l;
    }

    public long getEnd()
    {
        return end;
    }

    public void setEnd(long l)
    {
        end = l;
    }
}
