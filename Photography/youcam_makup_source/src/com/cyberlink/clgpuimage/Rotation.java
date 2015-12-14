// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


public final class Rotation extends Enum
{

    public static final Rotation a;
    public static final Rotation b;
    public static final Rotation c;
    public static final Rotation d;
    private static final Rotation e[];

    private Rotation(String s, int i)
    {
        super(s, i);
    }

    public static Rotation valueOf(String s)
    {
        return (Rotation)Enum.valueOf(com/cyberlink/clgpuimage/Rotation, s);
    }

    public static Rotation[] values()
    {
        return (Rotation[])e.clone();
    }

    static 
    {
        a = new Rotation("NORMAL", 0);
        b = new Rotation("ROTATION_90", 1);
        c = new Rotation("ROTATION_180", 2);
        d = new Rotation("ROTATION_270", 3);
        e = (new Rotation[] {
            a, b, c, d
        });
    }
}
