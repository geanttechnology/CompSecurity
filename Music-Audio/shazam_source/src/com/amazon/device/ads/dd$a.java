// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            dd

public static final class  extends Enum
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

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/dd$a, s);
    }

    public static [] values()
    {
        return ([])j.clone();
    }

    static 
    {
        a = new <init>("RENDERED", 0);
        b = new <init>("VISIBLE", 1);
        c = new <init>("HIDDEN", 2);
        d = new <init>("DESTROYED", 3);
        e = new <init>("CLOSED", 4);
        f = new <init>("READY", 5);
        g = new <init>("RESIZED", 6);
        h = new <init>("BRIDGE_ADDED", 7);
        i = new <init>("BACK_BUTTON_PRESSED", 8);
        j = (new j[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private (String s, int k)
    {
        super(s, k);
    }
}
