// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class UsageOfHairFeatureEvent extends BaseEvent
{

    public UsageOfHairFeatureEvent(FeatureName featurename)
    {
        super("Usage of features in Hair");
        HashMap hashmap = new HashMap();
        hashmap.put("FeatureName", featurename.a());
        a(hashmap);
    }

    private class FeatureName extends Enum
    {

        public static final FeatureName a;
        public static final FeatureName b;
        private static final FeatureName c[];

        public static FeatureName valueOf(String s)
        {
            return (FeatureName)Enum.valueOf(com/cyberlink/youcammakeup/flurry/UsageOfHairFeatureEvent$FeatureName, s);
        }

        public static FeatureName[] values()
        {
            return (FeatureName[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new FeatureName("Wig", 0) {

                public String a()
                {
                    return "Wig";
                }

            };
            b = new FeatureName("HairDye", 1) {

                public String a()
                {
                    return "Hair Dye";
                }

            };
            c = (new FeatureName[] {
                a, b
            });
        }

        private FeatureName(String s, int i)
        {
            super(s, i);
        }

    }

}
