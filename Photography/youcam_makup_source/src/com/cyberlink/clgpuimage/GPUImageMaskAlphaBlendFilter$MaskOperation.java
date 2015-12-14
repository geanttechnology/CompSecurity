// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


final class I extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/cyberlink/clgpuimage/GPUImageMaskAlphaBlendFilter$MaskOperation, s);
    }

    public static I[] values()
    {
        return (I[])g.clone();
    }

    static 
    {
        a = new <init>("Normal", 0);
        b = new <init>("Invert", 1);
        c = new <init>("Undo", 2);
        d = new <init>("Apply", 3);
        e = new <init>("HideLast", 4);
        f = new <init>("ExternalMask", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
