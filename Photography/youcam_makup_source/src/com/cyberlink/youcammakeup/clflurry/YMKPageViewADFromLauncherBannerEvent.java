// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKPageViewADFromLauncherBannerEvent extends BaseEvent
{

    public YMKPageViewADFromLauncherBannerEvent(BannerType bannertype, String s)
    {
        super("YMK_PageView_AD_From_Launcher_Banner");
        HashMap hashmap = new HashMap();
        if (bannertype == BannerType.a)
        {
            hashmap.put("Banner ID", s);
            a(hashmap);
        } else
        if (bannertype == BannerType.b)
        {
            hashmap.put("PageID", s);
            a(hashmap);
            return;
        }
    }

    private class BannerType extends Enum
    {

        public static final BannerType a;
        public static final BannerType b;
        private static final BannerType c[];

        public static BannerType valueOf(String s)
        {
            return (BannerType)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKPageViewADFromLauncherBannerEvent$BannerType, s);
        }

        public static BannerType[] values()
        {
            return (BannerType[])c.clone();
        }

        static 
        {
            a = new BannerType("Banner", 0);
            b = new BannerType("Page", 1);
            c = (new BannerType[] {
                a, b
            });
        }

        private BannerType(String s, int i)
        {
            super(s, i);
        }
    }

}
