// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;


final class  extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/viewengine/ViewEngine$DecodeOpCode, s);
    }

    public static [] values()
    {
        return ([])f.clone();
    }

    static 
    {
        a = new <init>("DECODE_MASTER_FROM_FILE", 0);
        b = new <init>("DECODE_MASTER_FROM_STREAM", 1);
        c = new <init>("DECODE_THUMB_FROM_FILE", 2);
        d = new <init>("DECODE_THUMB_FROM_STREAM", 3);
        e = new <init>("STRETCH_DEFAULT", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
