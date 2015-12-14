// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKLauncherTileClicksEvent extends BaseEvent
{

    public YMKLauncherTileClicksEvent(LauncherTileName launchertilename)
    {
        super("YMK_LauncherTile_Clicks");
        HashMap hashmap = new HashMap();
        hashmap.put("LauncherTileName", launchertilename.a());
        a(hashmap);
    }

    private class LauncherTileName extends Enum
    {

        public static final LauncherTileName a;
        public static final LauncherTileName b;
        public static final LauncherTileName c;
        public static final LauncherTileName d;
        public static final LauncherTileName e;
        public static final LauncherTileName f;
        public static final LauncherTileName g;
        public static final LauncherTileName h;
        public static final LauncherTileName i;
        public static final LauncherTileName j;
        public static final LauncherTileName k;
        private static final LauncherTileName l[];

        public static LauncherTileName valueOf(String s)
        {
            return (LauncherTileName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLauncherTileClicksEvent$LauncherTileName, s);
        }

        public static LauncherTileName[] values()
        {
            return (LauncherTileName[])l.clone();
        }

        public abstract String a();

        static 
        {
            a = new LauncherTileName("Camera", 0) {

                public String a()
                {
                    return "Camera";
                }

            };
            b = new LauncherTileName("LiveMakeup", 1) {

                public String a()
                {
                    return "Live Makeup";
                }

            };
            c = new LauncherTileName("NaturalMakeup", 2) {

                public String a()
                {
                    return "Natural Makeup";
                }

            };
            d = new LauncherTileName("CostumeLooks", 3) {

                public String a()
                {
                    return "Costume Looks";
                }

            };
            e = new LauncherTileName("BeautyCircle", 4) {

                public String a()
                {
                    return "Beauty Circle";
                }

            };
            f = new LauncherTileName("Templates", 5) {

                public String a()
                {
                    return "Templates";
                }

            };
            g = new LauncherTileName("MakeupTips", 6) {

                public String a()
                {
                    return "Makeup Tips";
                }

            };
            h = new LauncherTileName("Setting", 7) {

                public String a()
                {
                    return "Setting";
                }

            };
            i = new LauncherTileName("Notice", 8) {

                public String a()
                {
                    return "Notice";
                }

            };
            j = new LauncherTileName("APPRecommend", 9) {

                public String a()
                {
                    return "APP Recommend";
                }

            };
            k = new LauncherTileName("AD", 10) {

                public String a()
                {
                    return "AD";
                }

            };
            l = (new LauncherTileName[] {
                a, b, c, d, e, f, g, h, i, j, 
                k
            });
        }

        private LauncherTileName(String s, int i1)
        {
            super(s, i1);
        }

    }

}
