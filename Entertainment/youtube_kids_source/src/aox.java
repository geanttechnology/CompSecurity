// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioTrack;

public class aox
{

    public final AudioTrack a;
    private final int b;
    private long c;
    private long d;

    public aox(AudioTrack audiotrack)
    {
        a = audiotrack;
        b = audiotrack.getSampleRate();
    }

    public final long a()
    {
        long l = 0xffffffffL & (long)a.getPlaybackHeadPosition();
        if (c > l)
        {
            d = d + 1L;
        }
        c = l;
        return l + (d << 32);
    }

    public final long b()
    {
        return (a() * 0xf4240L) / (long)b;
    }

    public boolean c()
    {
        return false;
    }

    public long d()
    {
        throw new UnsupportedOperationException();
    }

    public long e()
    {
        throw new UnsupportedOperationException();
    }
}
