// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKMainFeaturesClicksEvent extends BaseEvent
{

    public YMKMainFeaturesClicksEvent(FeatureName featurename)
    {
        super("YMK_MainFeatures_Clicks");
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
        private static final FeatureName g[];

        public static FeatureName valueOf(String s)
        {
            return (FeatureName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKMainFeaturesClicksEvent$FeatureName, s);
        }

        public static FeatureName[] values()
        {
            return (FeatureName[])g.clone();
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
            b = new FeatureName("Face", 1) {

                public String a()
                {
                    return "Face";
                }

            };
            c = new FeatureName("Eye", 2) {

                public String a()
                {
                    return "Eye";
                }

            };
            d = new FeatureName("Mouth", 3) {

                public String a()
                {
                    return "Mouth";
                }

            };
            e = new FeatureName("Accessories", 4) {

                public String a()
                {
                    return "Accessory";
                }

            };
            f = new FeatureName("Wig", 5) {

                public String a()
                {
                    return "Wig";
                }

            };
            g = (new FeatureName[] {
                a, b, c, d, e, f
            });
        }

        private FeatureName(String s, int i)
        {
            super(s, i);
        }

    }

}
