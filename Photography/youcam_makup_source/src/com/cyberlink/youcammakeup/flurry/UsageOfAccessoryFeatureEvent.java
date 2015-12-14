// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class UsageOfAccessoryFeatureEvent extends BaseEvent
{

    public UsageOfAccessoryFeatureEvent(FeatureName featurename)
    {
        super("Usage of features in Accessory");
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
        private static final FeatureName e[];

        public static FeatureName valueOf(String s)
        {
            return (FeatureName)Enum.valueOf(com/cyberlink/youcammakeup/flurry/UsageOfAccessoryFeatureEvent$FeatureName, s);
        }

        public static FeatureName[] values()
        {
            return (FeatureName[])e.clone();
        }

        public abstract String a();

        static 
        {
            a = new FeatureName("Earrings", 0) {

                public String a()
                {
                    return "Earrings";
                }

            };
            b = new FeatureName("HairBand", 1) {

                public String a()
                {
                    return "Hair Band";
                }

            };
            c = new FeatureName("Necklace", 2) {

                public String a()
                {
                    return "Necklace";
                }

            };
            d = new FeatureName("EyeWear", 3) {

                public String a()
                {
                    return "Eye Wear";
                }

            };
            e = (new FeatureName[] {
                a, b, c, d
            });
        }

        private FeatureName(String s, int i)
        {
            super(s, i);
        }

    }

}
