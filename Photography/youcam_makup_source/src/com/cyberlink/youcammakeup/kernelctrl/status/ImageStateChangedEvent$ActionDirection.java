// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;


public final class Y extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static Y valueOf(String s)
    {
        return (Y)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/status/ImageStateChangedEvent$ActionDirection, s);
    }

    public static Y[] values()
    {
        return (Y[])e.clone();
    }

    static 
    {
        a = new <init>("undo", 0);
        b = new <init>("redo", 1);
        c = new <init>("apply", 2);
        d = new <init>("init", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private Y(String s, int i)
    {
        super(s, i);
    }
}
