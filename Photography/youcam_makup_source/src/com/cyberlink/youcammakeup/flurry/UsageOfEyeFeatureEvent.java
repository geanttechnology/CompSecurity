// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class UsageOfEyeFeatureEvent extends BaseEvent
{

    public UsageOfEyeFeatureEvent(FeatureName featurename)
    {
        super("Usage of features in Eye");
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
            return (FeatureName)Enum.valueOf(com/cyberlink/youcammakeup/flurry/UsageOfEyeFeatureEvent$FeatureName, s);
        }

        public static FeatureName[] values()
        {
            return (FeatureName[])k.clone();
        }

        public abstract String a();

        static 
        {
            a = new FeatureName("EyeLiner", 0) {

                public String a()
                {
                    return "Eye Liner";
                }

            };
            b = new FeatureName("Eyelashes", 1) {

                public String a()
                {
                    return "Eyelashes";
                }

            };
            c = new FeatureName("EyeShadow", 2) {

                public String a()
                {
                    return "Eye Shadow";
                }

            };
            d = new FeatureName("Eyebrows", 3) {

                public String a()
                {
                    return "Eyebrows";
                }

            };
            e = new FeatureName("EyeColor", 4) {

                public String a()
                {
                    return "Eye Color";
                }

            };
            f = new FeatureName("EyeBagRemoval", 5) {

                public String a()
                {
                    return "Eye Bag Removal";
                }

            };
            g = new FeatureName("EyeEnlarger", 6) {

                public String a()
                {
                    return "Eye Enlarger";
                }

            };
            h = new FeatureName("RedEyeRemoval", 7) {

                public String a()
                {
                    return "Red-Eye Removal";
                }

            };
            i = new FeatureName("EyeSparkle", 8) {

                public String a()
                {
                    return "Eye Sparkle";
                }

            };
            j = new FeatureName("DoubleEyelid", 9) {

                public String a()
                {
                    return "Eyelid";
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
