// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.featurepoints;


public final class  extends Enum
{

    public static final l a;
    public static final l b;
    public static final l c;
    public static final l d;
    public static final l e;
    public static final l f;
    public static final l g;
    public static final l h;
    public static final l i;
    public static final l j;
    public static final l k;
    public static final l l;
    private static final l m[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/featurepoints/FeaturePointsDef$FeatureSets, s);
    }

    public static [] values()
    {
        return ([])m.clone();
    }

    static 
    {
        a = new <init>("SkinSet", 0);
        b = new <init>("ReshapeSet", 1);
        c = new <init>("PimpleSet", 2);
        d = new <init>("EyeSet", 3);
        e = new <init>("ContourNoseSet", 4);
        f = new <init>("MouthSet", 5);
        g = new <init>("EyebrowSet", 6);
        h = new <init>("LookSet", 7);
        i = new <init>("FaceTattooSet", 8);
        j = new <init>("HairSet", 9);
        k = new <init>("EyeFeatureSet", 10);
        l = new <init>("AccessorySet", 11);
        m = (new m[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
