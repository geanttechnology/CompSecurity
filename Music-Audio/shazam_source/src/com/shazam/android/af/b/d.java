// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;


public final class d extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    private static final d f[];

    private d(String s, int i)
    {
        super(s, i);
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/shazam/android/af/b/d, s);
    }

    public static d[] values()
    {
        return (d[])f.clone();
    }

    static 
    {
        a = new d("TogglePlayPause", 0);
        b = new d("OnPreparedCallback", 1);
        c = new d("PlaybackFinished", 2);
        d = new d("Reset", 3);
        e = new d("Pause", 4);
        f = (new d[] {
            a, b, c, d, e
        });
    }
}
