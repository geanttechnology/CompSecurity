// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;


final class  extends Enum
{

    public static final j a;
    public static final j b;
    public static final j c;
    public static final j d;
    public static final j e;
    public static final j f;
    public static final j g;
    public static final j h;
    public static final j i;
    public static final j j;
    private static final j k[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/LiveDemoConfigHelper$Configs, s);
    }

    public static [] values()
    {
        return ([])k.clone();
    }

    static 
    {
        a = new <init>("LookChangePeriod", 0);
        b = new <init>("CameraSwitch", 1);
        c = new <init>("EnableAutoFocus", 2);
        d = new <init>("EnableFaceAutoFocus", 3);
        e = new <init>("AutoEnterMakeupCam", 4);
        f = new <init>("AutoExitMakeupCamTime", 5);
        g = new <init>("EnableLiveFPS", 6);
        h = new <init>("LookGuidOrder", 7);
        i = new <init>("ZoomLevel", 8);
        j = new <init>("FlipMode", 9);
        k = (new k[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }

    private (String s, int l)
    {
        super(s, l);
    }
}
