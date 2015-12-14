// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;


public abstract class <init> extends Enum
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

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/flurry/UsageOfEyeFeatureEvent$FeatureName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])k.clone();
    }

    public abstract String a();

    static 
    {
        a = new UsageOfEyeFeatureEvent.FeatureName("EyeLiner", 0) {

            public String a()
            {
                return "Eye Liner";
            }

        };
        b = new UsageOfEyeFeatureEvent.FeatureName("Eyelashes", 1) {

            public String a()
            {
                return "Eyelashes";
            }

        };
        c = new UsageOfEyeFeatureEvent.FeatureName("EyeShadow", 2) {

            public String a()
            {
                return "Eye Shadow";
            }

        };
        d = new UsageOfEyeFeatureEvent.FeatureName("Eyebrows", 3) {

            public String a()
            {
                return "Eyebrows";
            }

        };
        e = new UsageOfEyeFeatureEvent.FeatureName("EyeColor", 4) {

            public String a()
            {
                return "Eye Color";
            }

        };
        f = new UsageOfEyeFeatureEvent.FeatureName("EyeBagRemoval", 5) {

            public String a()
            {
                return "Eye Bag Removal";
            }

        };
        g = new UsageOfEyeFeatureEvent.FeatureName("EyeEnlarger", 6) {

            public String a()
            {
                return "Eye Enlarger";
            }

        };
        h = new UsageOfEyeFeatureEvent.FeatureName("RedEyeRemoval", 7) {

            public String a()
            {
                return "Red-Eye Removal";
            }

        };
        i = new UsageOfEyeFeatureEvent.FeatureName("EyeSparkle", 8) {

            public String a()
            {
                return "Eye Sparkle";
            }

        };
        j = new UsageOfEyeFeatureEvent.FeatureName("DoubleEyelid", 9) {

            public String a()
            {
                return "Eyelid";
            }

        };
        k = (new k[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }

    private _cls9(String s, int l)
    {
        super(s, l);
    }

    _cls9(String s, int l, _cls9 _pcls9)
    {
        this(s, l);
    }
}
