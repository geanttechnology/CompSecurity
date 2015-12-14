// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKClicksSaveMyLookEvent extends BaseEvent
{

    public YMKClicksSaveMyLookEvent(ButtonName buttonname)
    {
        super("YMK_Clicks_SaveMyLook");
        HashMap hashmap = new HashMap();
        hashmap.put("ButtonName", buttonname.a());
        a(hashmap);
    }

    private class ButtonName extends Enum
    {

        public static final ButtonName a;
        public static final ButtonName b;
        public static final ButtonName c;
        public static final ButtonName d;
        private static final ButtonName e[];

        public static ButtonName valueOf(String s)
        {
            return (ButtonName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKClicksSaveMyLookEvent$ButtonName, s);
        }

        public static ButtonName[] values()
        {
            return (ButtonName[])e.clone();
        }

        public abstract String a();

        static 
        {
            a = new ButtonName("Back", 0) {

                public String a()
                {
                    return "Back";
                }

            };
            b = new ButtonName("Save", 1) {

                public String a()
                {
                    return "Save";
                }

            };
            c = new ButtonName("Compare", 2) {

                public String a()
                {
                    return "Compare";
                }

            };
            d = new ButtonName("Go_to_Looks", 3) {

                public String a()
                {
                    return "Go to Looks";
                }

            };
            e = (new ButtonName[] {
                a, b, c, d
            });
        }

        private ButtonName(String s, int i)
        {
            super(s, i);
        }

    }

}
