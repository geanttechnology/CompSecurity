// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKLooksPromotionItemEvent extends BaseEvent
{

    public static String b = "1";

    public YMKLooksPromotionItemEvent(Operation operation, String s, String s1)
    {
        super("YMK_Looks_Promotion_Item");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("guid", String.valueOf(s));
        hashmap.put("look_name", s1);
        hashmap.put("ver", b);
        a(hashmap);
    }

    public YMKLooksPromotionItemEvent(String s, String s1, ButtonType buttontype)
    {
        super("YMK_Looks_Promotion_Item");
        HashMap hashmap = new HashMap();
        hashmap.put("guid", s);
        hashmap.put("look_name", s1);
        hashmap.put("button_type", buttontype.a());
        hashmap.put("ver", b);
        a(hashmap);
    }


    private class Operation extends Enum
    {

        public static final Operation a;
        private static final Operation b[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLooksPromotionItemEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])b.clone();
        }

        public abstract String a();

        static 
        {
            a = new Operation("Show", 0) {

                public String a()
                {
                    return "show";
                }

            };
            b = (new Operation[] {
                a
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }

    }


    private class ButtonType extends Enum
    {

        public static final ButtonType a;
        public static final ButtonType b;
        private static final ButtonType c[];

        public static ButtonType valueOf(String s)
        {
            return (ButtonType)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLooksPromotionItemEvent$ButtonType, s);
        }

        public static ButtonType[] values()
        {
            return (ButtonType[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new ButtonType("Download", 0) {

                public String a()
                {
                    return "download";
                }

            };
            b = new ButtonType("Use", 1) {

                public String a()
                {
                    return "use";
                }

            };
            c = (new ButtonType[] {
                a, b
            });
        }

        private ButtonType(String s, int i)
        {
            super(s, i);
        }

    }

}
