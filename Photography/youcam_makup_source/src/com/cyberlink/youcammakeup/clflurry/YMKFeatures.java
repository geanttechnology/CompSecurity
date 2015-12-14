// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import com.cyberlink.youcammakeup.utility.BeautyMode;

public class YMKFeatures
{

    public static FeatureName a(BeautyMode beautymode)
    {
        FeatureName featurename = null;
        if (beautymode == BeautyMode.d)
        {
            featurename = FeatureName.b;
        } else
        {
            if (beautymode == BeautyMode.b)
            {
                return FeatureName.c;
            }
            if (beautymode == BeautyMode.a)
            {
                return FeatureName.d;
            }
            if (beautymode == BeautyMode.h)
            {
                return FeatureName.e;
            }
            if (beautymode == BeautyMode.g)
            {
                return FeatureName.f;
            }
            if (beautymode == BeautyMode.f)
            {
                return FeatureName.g;
            }
            if (beautymode == BeautyMode.e)
            {
                return FeatureName.h;
            }
            if (beautymode == BeautyMode.c)
            {
                return FeatureName.i;
            }
            if (beautymode == BeautyMode.l)
            {
                return FeatureName.l;
            }
            if (beautymode == BeautyMode.m)
            {
                return FeatureName.m;
            }
            if (beautymode == BeautyMode.n)
            {
                return FeatureName.n;
            }
            if (beautymode == BeautyMode.r)
            {
                return FeatureName.o;
            }
            if (beautymode == BeautyMode.s)
            {
                return FeatureName.p;
            }
            if (beautymode == BeautyMode.p)
            {
                return FeatureName.q;
            }
            if (beautymode == BeautyMode.o)
            {
                return FeatureName.r;
            }
            if (beautymode == BeautyMode.u)
            {
                return FeatureName.u;
            }
            if (beautymode == BeautyMode.q)
            {
                return FeatureName.s;
            }
            if (beautymode == BeautyMode.t)
            {
                return FeatureName.t;
            }
            if (beautymode == BeautyMode.v)
            {
                return FeatureName.v;
            }
            if (beautymode == BeautyMode.w)
            {
                return FeatureName.w;
            }
            if (beautymode == BeautyMode.x)
            {
                return FeatureName.x;
            }
            if (beautymode == BeautyMode.z)
            {
                return FeatureName.z;
            }
            if (beautymode == BeautyMode.A)
            {
                return FeatureName.A;
            }
            if (beautymode == BeautyMode.B)
            {
                return FeatureName.B;
            }
            if (beautymode == BeautyMode.C)
            {
                return FeatureName.C;
            }
            if (beautymode == BeautyMode.y)
            {
                return FeatureName.y;
            }
        }
        return featurename;
    }

    private class FeatureName extends Enum
    {

        public static final FeatureName A;
        public static final FeatureName B;
        public static final FeatureName C;
        private static final FeatureName D[];
        public static final FeatureName a;
        public static final FeatureName b;
        public static final FeatureName c;
        public static final FeatureName d;
        public static final FeatureName e;
        public static final FeatureName f;
        public static final FeatureName g;
        public static final FeatureName h;
        public static final FeatureName i;
        public static final FeatureName j;
        public static final FeatureName k;
        public static final FeatureName l;
        public static final FeatureName m;
        public static final FeatureName n;
        public static final FeatureName o;
        public static final FeatureName p;
        public static final FeatureName q;
        public static final FeatureName r;
        public static final FeatureName s;
        public static final FeatureName t;
        public static final FeatureName u;
        public static final FeatureName v;
        public static final FeatureName w;
        public static final FeatureName x;
        public static final FeatureName y;
        public static final FeatureName z;

        public static FeatureName valueOf(String s1)
        {
            return (FeatureName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKFeatures$FeatureName, s1);
        }

        public static FeatureName[] values()
        {
            return (FeatureName[])D.clone();
        }

        public abstract String a();

        static 
        {
            a = new FeatureName("Looks", 0) {

                public String a()
                {
                    return "Looks";
                }

            };
            b = new FeatureName("SkinSmoothener", 1) {

                public String a()
                {
                    return "SkinSmoothener";
                }

            };
            c = new FeatureName("Foundation", 2) {

                public String a()
                {
                    return "Foundation";
                }

            };
            d = new FeatureName("Blush", 3) {

                public String a()
                {
                    return "Blush";
                }

            };
            e = new FeatureName("FaceReshaper", 4) {

                public String a()
                {
                    return "Face Reshaper";
                }

            };
            f = new FeatureName("FaceContour", 5) {

                public String a()
                {
                    return "Face Contour";
                }

            };
            g = new FeatureName("NoseEnhance", 6) {

                public String a()
                {
                    return "Nose Enhance";
                }

            };
            h = new FeatureName("BlemishRemoval", 7) {

                public String a()
                {
                    return "Blemish Removal";
                }

            };
            i = new FeatureName("ShineRemoval", 8) {

                public String a()
                {
                    return "Shine Removal";
                }

            };
            j = new FeatureName("FaceArt", 9) {

                public String a()
                {
                    return "Face Art";
                }

            };
            k = new FeatureName("Mustache", 10) {

                public String a()
                {
                    return "Mustache";
                }

            };
            l = new FeatureName("EyeLiner", 11) {

                public String a()
                {
                    return "Eye Liner";
                }

            };
            m = new FeatureName("Eyelashes", 12) {

                public String a()
                {
                    return "Eyelashes";
                }

            };
            n = new FeatureName("EyeShadow", 13) {

                public String a()
                {
                    return "Eye Shadow";
                }

            };
            o = new FeatureName("Eyebrows", 14) {

                public String a()
                {
                    return "Eyebrows";
                }

            };
            p = new FeatureName("EyeColor", 15) {

                public String a()
                {
                    return "Eye Color";
                }

            };
            q = new FeatureName("EyeBagRemoval", 16) {

                public String a()
                {
                    return "Eye Bag Removal";
                }

            };
            r = new FeatureName("EyeEnlarger", 17) {

                public String a()
                {
                    return "Eye Enlarger";
                }

            };
            s = new FeatureName("RedEyeRemoval", 18) {

                public String a()
                {
                    return "Red-Eye Removal";
                }

            };
            t = new FeatureName("DoubleEyelid", 19) {

                public String a()
                {
                    return "Eyelid";
                }

            };
            u = new FeatureName("EyeSparkle", 20) {

                public String a()
                {
                    return "Eye Sparkle";
                }

            };
            v = new FeatureName("LipColor", 21) {

                public String a()
                {
                    return "Lip Color";
                }

            };
            w = new FeatureName("TeethWhitener", 22) {

                public String a()
                {
                    return "Teeth Whitener";
                }

            };
            x = new FeatureName("Wig", 23) {

                public String a()
                {
                    return "Wig";
                }

            };
            y = new FeatureName("HairDye", 24) {

                public String a()
                {
                    return "HairDye";
                }

            };
            z = new FeatureName("EyeWear", 25) {

                public String a()
                {
                    return "Eyewear";
                }

            };
            A = new FeatureName("HairBand", 26) {

                public String a()
                {
                    return "Headband";
                }

            };
            B = new FeatureName("Necklace", 27) {

                public String a()
                {
                    return "Necklace";
                }

            };
            C = new FeatureName("Earrings", 28) {

                public String a()
                {
                    return "Earrings";
                }

            };
            D = (new FeatureName[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r, s, t, 
                u, v, w, x, y, z, A, B, C
            });
        }

        private FeatureName(String s1, int i1)
        {
            super(s1, i1);
        }

    }

}
