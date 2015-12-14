// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;


public final class Q extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/DownloadingState$State, s);
    }

    public static Q[] values()
    {
        return (Q[])d.clone();
    }

    static 
    {
        a = new <init>("Waiting", 0);
        b = new <init>("Running", 1);
        c = new <init>("None", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
