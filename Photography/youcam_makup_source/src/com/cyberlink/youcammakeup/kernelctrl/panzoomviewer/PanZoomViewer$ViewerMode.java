// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;


final class  extends Enum
{

    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    private static final h i[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/panzoomviewer/PanZoomViewer$ViewerMode, s);
    }

    public static [] values()
    {
        return ([])i.clone();
    }

    static 
    {
        a = new <init>("unknown", 0);
        b = new <init>("imageViewing", 1);
        c = new <init>("imageSwitching", 2);
        d = new <init>("imageBouncing", 3);
        e = new <init>("imageFling", 4);
        f = new <init>("imageDoubleTaping", 5);
        g = new <init>("featurePoint", 6);
        h = new <init>("adjustWig", 7);
        i = (new i[] {
            a, b, c, d, e, f, g, h
        });
    }

    private (String s, int j)
    {
        super(s, j);
    }
}
