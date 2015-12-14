// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKMainFeaturesClicksEvent$FeatureName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])g.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKMainFeaturesClicksEvent.FeatureName("Looks", 0) {

            public String a()
            {
                return "Looks";
            }

        };
        b = new YMKMainFeaturesClicksEvent.FeatureName("Face", 1) {

            public String a()
            {
                return "Face";
            }

        };
        c = new YMKMainFeaturesClicksEvent.FeatureName("Eye", 2) {

            public String a()
            {
                return "Eye";
            }

        };
        d = new YMKMainFeaturesClicksEvent.FeatureName("Mouth", 3) {

            public String a()
            {
                return "Mouth";
            }

        };
        e = new YMKMainFeaturesClicksEvent.FeatureName("Accessories", 4) {

            public String a()
            {
                return "Accessory";
            }

        };
        f = new YMKMainFeaturesClicksEvent.FeatureName("Wig", 5) {

            public String a()
            {
                return "Wig";
            }

        };
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private _cls6(String s, int i)
    {
        super(s, i);
    }

    _cls6(String s, int i, _cls6 _pcls6)
    {
        this(s, i);
    }
}
