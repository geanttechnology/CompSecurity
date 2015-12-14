// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKAfterSavePhotoEvent extends BaseEvent
{

    public YMKAfterSavePhotoEvent(FeatureName featurename)
    {
        super("YMK_AfterSavePhoto");
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
        private static final FeatureName h[];

        public static FeatureName valueOf(String s)
        {
            return (FeatureName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKAfterSavePhotoEvent$FeatureName, s);
        }

        public static FeatureName[] values()
        {
            return (FeatureName[])h.clone();
        }

        public abstract String a();

        static 
        {
            a = new FeatureName("U", 0) {

                public String a()
                {
                    return "U";
                }

            };
            b = new FeatureName("YouCamPerfectEdit", 1) {

                public String a()
                {
                    return "YouCam Perfect Edit";
                }

            };
            c = new FeatureName("YouCamPerfectCollage", 2) {

                public String a()
                {
                    return "YouCam Perfect Collage";
                }

            };
            d = new FeatureName("BeautyCircle", 3) {

                public String a()
                {
                    return "Beauty Circle";
                }

            };
            e = new FeatureName("Share", 4) {

                public String a()
                {
                    return "Share";
                }

            };
            f = new FeatureName("Home", 5) {

                public String a()
                {
                    return "Home";
                }

            };
            g = new FeatureName("Close", 6) {

                public String a()
                {
                    return "Close";
                }

            };
            h = (new FeatureName[] {
                a, b, c, d, e, f, g
            });
        }

        private FeatureName(String s, int i)
        {
            super(s, i);
        }

    }

}
