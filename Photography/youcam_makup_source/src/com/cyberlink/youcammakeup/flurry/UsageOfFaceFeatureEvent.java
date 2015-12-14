// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class UsageOfFaceFeatureEvent extends BaseEvent
{

    public UsageOfFaceFeatureEvent(FeatureName featurename)
    {
        super("Usage of features in Face");
        HashMap hashmap = new HashMap();
        hashmap.put("FeatureName", featurename.a());
        a(hashmap);
    }

    private class FeatureName extends Enum
    {

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
        private static final FeatureName k[];

        public static FeatureName valueOf(String s)
        {
            return (FeatureName)Enum.valueOf(com/cyberlink/youcammakeup/flurry/UsageOfFaceFeatureEvent$FeatureName, s);
        }

        public static FeatureName[] values()
        {
            return (FeatureName[])k.clone();
        }

        public abstract String a();

        static 
        {
            a = new FeatureName("SkinSmoothener", 0) {

                public String a()
                {
                    return "Skin Smoothener";
                }

            };
            b = new FeatureName("Foundation", 1) {

                public String a()
                {
                    return "Foundation";
                }

            };
            c = new FeatureName("Blush", 2) {

                public String a()
                {
                    return "Blush";
                }

            };
            d = new FeatureName("FaceReshaper", 3) {

                public String a()
                {
                    return "Face Reshaper";
                }

            };
            e = new FeatureName("FaceContour", 4) {

                public String a()
                {
                    return "Face Contour";
                }

            };
            f = new FeatureName("NoseEnhance", 5) {

                public String a()
                {
                    return "Nose Enhance";
                }

            };
            g = new FeatureName("BlemishRemoval", 6) {

                public String a()
                {
                    return "Blemish Removal";
                }

            };
            h = new FeatureName("ShineRemoval", 7) {

                public String a()
                {
                    return "Shine Removal";
                }

            };
            i = new FeatureName("FaceArt", 8) {

                public String a()
                {
                    return "Face Art";
                }

            };
            j = new FeatureName("Mustache", 9) {

                public String a()
                {
                    return "Mustache";
                }

            };
            k = (new FeatureName[] {
                a, b, c, d, e, f, g, h, i, j
            });
        }

        private FeatureName(String s, int l)
        {
            super(s, l);
        }

    }

}
