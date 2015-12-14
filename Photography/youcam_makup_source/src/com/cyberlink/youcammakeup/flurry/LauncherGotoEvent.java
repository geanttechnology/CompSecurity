// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class LauncherGotoEvent extends BaseEvent
{

    public LauncherGotoEvent(DestName destname)
    {
        super("Usage_of_features_in_Launcher");
        HashMap hashmap = new HashMap();
        hashmap.put("DestName", destname.a());
        a(hashmap);
    }

    private class DestName extends Enum
    {

        public static final DestName a;
        public static final DestName b;
        public static final DestName c;
        public static final DestName d;
        public static final DestName e;
        public static final DestName f;
        public static final DestName g;
        public static final DestName h;
        public static final DestName i;
        public static final DestName j;
        public static final DestName k;
        private static final DestName l[];

        public static DestName valueOf(String s)
        {
            return (DestName)Enum.valueOf(com/cyberlink/youcammakeup/flurry/LauncherGotoEvent$DestName, s);
        }

        public static DestName[] values()
        {
            return (DestName[])l.clone();
        }

        public abstract String a();

        static 
        {
            a = new DestName("Camera", 0) {

                public String a()
                {
                    return "Camera";
                }

            };
            b = new DestName("LiveMakeup", 1) {

                public String a()
                {
                    return "Live Makeup";
                }

            };
            c = new DestName("NaturalMakeup", 2) {

                public String a()
                {
                    return "Natural Makeup";
                }

            };
            d = new DestName("CostumeLooks", 3) {

                public String a()
                {
                    return "Costume Looks";
                }

            };
            e = new DestName("BeautyCircle", 4) {

                public String a()
                {
                    return "Beauty Circle";
                }

            };
            f = new DestName("Templates", 5) {

                public String a()
                {
                    return "Templates";
                }

            };
            g = new DestName("MakeupTips", 6) {

                public String a()
                {
                    return "Makeup Tips";
                }

            };
            h = new DestName("Setting", 7) {

                public String a()
                {
                    return "Setting";
                }

            };
            i = new DestName("Notice", 8) {

                public String a()
                {
                    return "Notice";
                }

            };
            j = new DestName("APPRecommend", 9) {

                public String a()
                {
                    return "APP Recommend";
                }

            };
            k = new DestName("AD", 10) {

                public String a()
                {
                    return "AD";
                }

            };
            l = (new DestName[] {
                a, b, c, d, e, f, g, h, i, j, 
                k
            });
        }

        private DestName(String s, int i1)
        {
            super(s, i1);
        }

    }

}
