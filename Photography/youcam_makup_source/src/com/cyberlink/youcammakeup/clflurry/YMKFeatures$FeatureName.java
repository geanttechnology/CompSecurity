// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final C A;
    public static final C B;
    public static final C C;
    private static final C D[];
    public static final C a;
    public static final C b;
    public static final C c;
    public static final C d;
    public static final C e;
    public static final C f;
    public static final C g;
    public static final C h;
    public static final C i;
    public static final C j;
    public static final C k;
    public static final C l;
    public static final C m;
    public static final C n;
    public static final C o;
    public static final C p;
    public static final C q;
    public static final C r;
    public static final C s;
    public static final C t;
    public static final C u;
    public static final C v;
    public static final C w;
    public static final C x;
    public static final C y;
    public static final C z;

    public static <init> valueOf(String s1)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKFeatures$FeatureName, s1);
    }

    public static <init>[] values()
    {
        return (<init>[])D.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKFeatures.FeatureName("Looks", 0) {

            public String a()
            {
                return "Looks";
            }

        };
        b = new YMKFeatures.FeatureName("SkinSmoothener", 1) {

            public String a()
            {
                return "SkinSmoothener";
            }

        };
        c = new YMKFeatures.FeatureName("Foundation", 2) {

            public String a()
            {
                return "Foundation";
            }

        };
        d = new YMKFeatures.FeatureName("Blush", 3) {

            public String a()
            {
                return "Blush";
            }

        };
        e = new YMKFeatures.FeatureName("FaceReshaper", 4) {

            public String a()
            {
                return "Face Reshaper";
            }

        };
        f = new YMKFeatures.FeatureName("FaceContour", 5) {

            public String a()
            {
                return "Face Contour";
            }

        };
        g = new YMKFeatures.FeatureName("NoseEnhance", 6) {

            public String a()
            {
                return "Nose Enhance";
            }

        };
        h = new YMKFeatures.FeatureName("BlemishRemoval", 7) {

            public String a()
            {
                return "Blemish Removal";
            }

        };
        i = new YMKFeatures.FeatureName("ShineRemoval", 8) {

            public String a()
            {
                return "Shine Removal";
            }

        };
        j = new YMKFeatures.FeatureName("FaceArt", 9) {

            public String a()
            {
                return "Face Art";
            }

        };
        k = new YMKFeatures.FeatureName("Mustache", 10) {

            public String a()
            {
                return "Mustache";
            }

        };
        l = new YMKFeatures.FeatureName("EyeLiner", 11) {

            public String a()
            {
                return "Eye Liner";
            }

        };
        m = new YMKFeatures.FeatureName("Eyelashes", 12) {

            public String a()
            {
                return "Eyelashes";
            }

        };
        n = new YMKFeatures.FeatureName("EyeShadow", 13) {

            public String a()
            {
                return "Eye Shadow";
            }

        };
        o = new YMKFeatures.FeatureName("Eyebrows", 14) {

            public String a()
            {
                return "Eyebrows";
            }

        };
        p = new YMKFeatures.FeatureName("EyeColor", 15) {

            public String a()
            {
                return "Eye Color";
            }

        };
        q = new YMKFeatures.FeatureName("EyeBagRemoval", 16) {

            public String a()
            {
                return "Eye Bag Removal";
            }

        };
        r = new YMKFeatures.FeatureName("EyeEnlarger", 17) {

            public String a()
            {
                return "Eye Enlarger";
            }

        };
        s = new YMKFeatures.FeatureName("RedEyeRemoval", 18) {

            public String a()
            {
                return "Red-Eye Removal";
            }

        };
        t = new YMKFeatures.FeatureName("DoubleEyelid", 19) {

            public String a()
            {
                return "Eyelid";
            }

        };
        u = new YMKFeatures.FeatureName("EyeSparkle", 20) {

            public String a()
            {
                return "Eye Sparkle";
            }

        };
        v = new YMKFeatures.FeatureName("LipColor", 21) {

            public String a()
            {
                return "Lip Color";
            }

        };
        w = new YMKFeatures.FeatureName("TeethWhitener", 22) {

            public String a()
            {
                return "Teeth Whitener";
            }

        };
        x = new YMKFeatures.FeatureName("Wig", 23) {

            public String a()
            {
                return "Wig";
            }

        };
        y = new YMKFeatures.FeatureName("HairDye", 24) {

            public String a()
            {
                return "HairDye";
            }

        };
        z = new YMKFeatures.FeatureName("EyeWear", 25) {

            public String a()
            {
                return "Eyewear";
            }

        };
        A = new YMKFeatures.FeatureName("HairBand", 26) {

            public String a()
            {
                return "Headband";
            }

        };
        B = new YMKFeatures.FeatureName("Necklace", 27) {

            public String a()
            {
                return "Necklace";
            }

        };
        C = new YMKFeatures.FeatureName("Earrings", 28) {

            public String a()
            {
                return "Earrings";
            }

        };
        D = (new D[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C
        });
    }

    private _cls9(String s1, int i1)
    {
        super(s1, i1);
    }

    _cls9(String s1, int i1, _cls9 _pcls9)
    {
        this(s1, i1);
    }
}
