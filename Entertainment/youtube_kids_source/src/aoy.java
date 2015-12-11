// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioTimestamp;
import android.media.AudioTrack;

final class aoy extends aox
{

    private final AudioTimestamp b = new AudioTimestamp();
    private long c;
    private long d;
    private long e;

    public aoy(AudioTrack audiotrack)
    {
        super(audiotrack);
    }

    public final boolean c()
    {
        boolean flag = a.getTimestamp(b);
        if (flag)
        {
            long l = b.framePosition;
            if (d > l)
            {
                c = c + 1L;
            }
            d = l;
            e = l + (c << 32);
        }
        return flag;
    }

    public final long d()
    {
        return b.nanoTime;
    }

    public final long e()
    {
        return e;
    }
}
