// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKClicksADFromLauncherBannerEvent extends BaseEvent
{

    public YMKClicksADFromLauncherBannerEvent(String s, String s1, ButtonName buttonname)
    {
        super("YMK_Clicks_AD_From_Launcher_Banner");
        HashMap hashmap = new HashMap();
        hashmap.put("SKU ID", s);
        hashmap.put("SKU item ID", s1);
        hashmap.put("Button Name", buttonname.a());
        a(hashmap);
    }

    private class ButtonName extends Enum
    {

        public static final ButtonName a;
        public static final ButtonName b;
        public static final ButtonName c;
        public static final ButtonName d;
        public static final ButtonName e;
        public static final ButtonName f;
        private static final ButtonName g[];

        public static ButtonName valueOf(String s)
        {
            return (ButtonName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKClicksADFromLauncherBannerEvent$ButtonName, s);
        }

        public static ButtonName[] values()
        {
            return (ButtonName[])g.clone();
        }

        public abstract String a();

        static 
        {
            a = new ButtonName("Cart", 0) {

                public String a()
                {
                    return "Cart";
                }

            };
            b = new ButtonName("LearnMore", 1) {

                public String a()
                {
                    return "LearnMore";
                }

            };
            c = new ButtonName("TryIt", 2) {

                public String a()
                {
                    return "TryIt";
                }

            };
            d = new ButtonName("Back", 3) {

                public String a()
                {
                    return "Back";
                }

            };
            e = new ButtonName("TakePhoto", 4) {

                public String a()
                {
                    return "TakePhoto";
                }

            };
            f = new ButtonName("SelectPhoto", 5) {

                public String a()
                {
                    return "SelectPhoto";
                }

            };
            g = (new ButtonName[] {
                a, b, c, d, e, f
            });
        }

        private ButtonName(String s, int i)
        {
            super(s, i);
        }

    }

}
