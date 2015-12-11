// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


final class > extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    private static final i j[];

    public static > valueOf(String s)
    {
        return (>)Enum.valueOf(com/flurry/sdk/dw$a, s);
    }

    public static Of[] values()
    {
        return (Of[])j.clone();
    }

    static 
    {
        a = new <init>("STATE_UNKNOWN", 0);
        b = new <init>("STATE_INIT", 1);
        c = new <init>("STATE_PREPARING", 2);
        d = new <init>("STATE_PREPARED", 3);
        e = new <init>("STATE_PLAYING", 4);
        f = new <init>("STATE_PAUSED", 5);
        g = new <init>("STATE_PLAYBACK_COMPLETED", 6);
        h = new <init>("STATE_SUSPEND", 7);
        i = new <init>("STATE_ERROR", 8);
        j = (new j[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private (String s, int k)
    {
        super(s, k);
    }
}
