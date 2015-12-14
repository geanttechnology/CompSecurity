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
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/flurry/UsageOfFaceFeatureEvent$FeatureName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])k.clone();
    }

    public abstract String a();

    static 
    {
        a = new UsageOfFaceFeatureEvent.FeatureName("SkinSmoothener", 0) {

            public String a()
            {
                return "Skin Smoothener";
            }

        };
        b = new UsageOfFaceFeatureEvent.FeatureName("Foundation", 1) {

            public String a()
            {
                return "Foundation";
            }

        };
        c = new UsageOfFaceFeatureEvent.FeatureName("Blush", 2) {

            public String a()
            {
                return "Blush";
            }

        };
        d = new UsageOfFaceFeatureEvent.FeatureName("FaceReshaper", 3) {

            public String a()
            {
                return "Face Reshaper";
            }

        };
        e = new UsageOfFaceFeatureEvent.FeatureName("FaceContour", 4) {

            public String a()
            {
                return "Face Contour";
            }

        };
        f = new UsageOfFaceFeatureEvent.FeatureName("NoseEnhance", 5) {

            public String a()
            {
                return "Nose Enhance";
            }

        };
        g = new UsageOfFaceFeatureEvent.FeatureName("BlemishRemoval", 6) {

            public String a()
            {
                return "Blemish Removal";
            }

        };
        h = new UsageOfFaceFeatureEvent.FeatureName("ShineRemoval", 7) {

            public String a()
            {
                return "Shine Removal";
            }

        };
        i = new UsageOfFaceFeatureEvent.FeatureName("FaceArt", 8) {

            public String a()
            {
                return "Face Art";
            }

        };
        j = new UsageOfFaceFeatureEvent.FeatureName("Mustache", 9) {

            public String a()
            {
                return "Mustache";
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
