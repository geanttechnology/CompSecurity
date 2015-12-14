// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKBeforeAfterEvent extends BaseEvent
{

    public static boolean b = false;

    public YMKBeforeAfterEvent(Operation operation)
    {
        super("YMK_B_A_Card");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("ver", "1");
        if (operation != Operation.a)
        {
            if (b)
            {
                operation = "yes";
            } else
            {
                operation = "no";
            }
            hashmap.put("B_A_slide", operation);
        }
        a(hashmap);
    }

    public static void a(boolean flag)
    {
        b = flag;
    }


    private class Operation extends Enum
    {

        public static final Operation a;
        public static final Operation b;
        public static final Operation c;
        private static final Operation d[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKBeforeAfterEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])d.clone();
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
            b = new Operation("Back", 1) {

                public String a()
                {
                    return "back";
                }

            };
            c = new Operation("Share", 2) {

                public String a()
                {
                    return "share";
                }

            };
            d = (new Operation[] {
                a, b, c
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }

    }

}
