// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKCostumeMakeupEvent extends BaseEvent
{

    private static String b = "1";
    private static String c = "";

    public YMKCostumeMakeupEvent(Operation operation, String s)
    {
        super("YMK_Costume_Makeup");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("source", c);
        if (s != null)
        {
            hashmap.put("look", s);
        }
        hashmap.put("ver", b);
        a(hashmap);
    }

    public static void b(String s)
    {
        c = s;
    }


    private class Operation extends Enum
    {

        public static final Operation a;
        public static final Operation b;
        public static final Operation c;
        public static final Operation d;
        private static final Operation e[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKCostumeMakeupEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])e.clone();
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
            b = new Operation("Try_Now", 1) {

                public String a()
                {
                    return "try_now";
                }

            };
            c = new Operation("More", 2) {

                public String a()
                {
                    return "more";
                }

            };
            d = new Operation("Back", 3) {

                public String a()
                {
                    return "back";
                }

            };
            e = (new Operation[] {
                a, b, c, d
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }

    }

}
