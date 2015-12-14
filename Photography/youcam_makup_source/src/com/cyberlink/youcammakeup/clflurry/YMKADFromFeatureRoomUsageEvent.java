// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKADFromFeatureRoomUsageEvent extends BaseEvent
{

    public YMKADFromFeatureRoomUsageEvent(String s, String s1, ButtonName buttonname)
    {
        super("YMK_Click_AD_From_Room");
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
        private static final ButtonName f[];

        public static ButtonName valueOf(String s)
        {
            return (ButtonName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKADFromFeatureRoomUsageEvent$ButtonName, s);
        }

        public static ButtonName[] values()
        {
            return (ButtonName[])f.clone();
        }

        public abstract String a();

        static 
        {
            a = new ButtonName("Consult", 0) {

                public String a()
                {
                    return "Consult";
                }

            };
            b = new ButtonName("Shopping", 1) {

                public String a()
                {
                    return "Shopping";
                }

            };
            c = new ButtonName("MoreInfo", 2) {

                public String a()
                {
                    return "MoreInfo";
                }

            };
            d = new ButtonName("FreeSample", 3) {

                public String a()
                {
                    return "FreeSample";
                }

            };
            e = new ButtonName("Back", 4) {

                public String a()
                {
                    return "Back";
                }

            };
            f = (new ButtonName[] {
                a, b, c, d, e
            });
        }

        private ButtonName(String s, int i)
        {
            super(s, i);
        }

    }

}
