// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;


final class I extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/status/SessionState$SwapState, s);
    }

    public static I[] values()
    {
        return (I[])e.clone();
    }

    static 
    {
        a = new <init>("file", 0);
        b = new <init>("memory", 1);
        c = new <init>("both", 2);
        d = new <init>("none", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
