// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKResultPageEvent extends BaseEvent
{

    public static long b;

    public YMKResultPageEvent(Operation operation)
    {
        super("YMK_Result_Page");
        HashMap hashmap = new HashMap();
        hashmap.put("card", operation.a());
        hashmap.put("ver", "3");
        a(hashmap);
    }

    public YMKResultPageEvent(Operation operation, long l, long l1)
    {
        super("YMK_Result_Page");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("ver", "3");
        l = l1 - l;
        if (l > 0L)
        {
            hashmap.put("staytime", String.valueOf(l));
        }
        a(hashmap);
    }

    private class Operation extends Enum
    {

        public static final Operation a;
        public static final Operation b;
        public static final Operation c;
        public static final Operation d;
        public static final Operation e;
        public static final Operation f;
        public static final Operation g;
        public static final Operation h;
        public static final Operation i;
        private static final Operation j[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKResultPageEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])j.clone();
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
            b = new Operation("Home", 1) {

                public String a()
                {
                    return "home";
                }

            };
            c = new Operation("Share", 2) {

                public String a()
                {
                    return "share";
                }

            };
            d = new Operation("Camera", 3) {

                public String a()
                {
                    return "camera";
                }

            };
            e = new Operation("YCP_Use", 4) {

                public String a()
                {
                    return "ycp_use";
                }

            };
            f = new Operation("YCP_Inatall", 5) {

                public String a()
                {
                    return "ycp_install";
                }

            };
            g = new Operation("B_A_Card", 6) {

                public String a()
                {
                    return "b_a_card";
                }

            };
            h = new Operation("YCN_Use", 7) {

                public String a()
                {
                    return "ycn_use";
                }

            };
            i = new Operation("YCN_Install", 8) {

                public String a()
                {
                    return "ycn_install";
                }

            };
            j = (new Operation[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private Operation(String s, int k)
        {
            super(s, k);
        }

    }

}
