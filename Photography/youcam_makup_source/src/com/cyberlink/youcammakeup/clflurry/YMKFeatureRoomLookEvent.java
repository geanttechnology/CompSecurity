// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKFeatureRoomLookEvent extends BaseEvent
{

    public static long b;
    private static String c = "1";
    private static String d = "";
    private static String e = "No";

    public YMKFeatureRoomLookEvent(Operation operation, long l, long l1, String s, String s1, 
            String s2)
    {
        super("YMK_Featureroom_Look");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("source", d);
        if (s != null)
        {
            hashmap.put("look", s);
        }
        if (s1 != null)
        {
            hashmap.put("intensity_change", s1);
        }
        if (s2 != null)
        {
            hashmap.put("intensity_value", s2);
        }
        l = l1 - l;
        if (l > 0L)
        {
            hashmap.put("staytime", String.valueOf(l));
        }
        hashmap.put("ver", c);
        a(hashmap);
    }

    public static void a(long l)
    {
        b = l;
    }

    public static void b(String s)
    {
        d = s;
    }

    public static void d()
    {
        e = "Yes";
    }

    public static String e()
    {
        return e;
    }

    public static long f()
    {
        return b;
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
        public static final Operation j;
        private static final Operation k[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKFeatureRoomLookEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])k.clone();
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
            c = new Operation("Apply", 2) {

                public String a()
                {
                    return "apply";
                }

            };
            d = new Operation("FineTune", 3) {

                public String a()
                {
                    return "finetune";
                }

            };
            e = new Operation("Compare", 4) {

                public String a()
                {
                    return "compare";
                }

            };
            f = new Operation("Redo", 5) {

                public String a()
                {
                    return "redo";
                }

            };
            g = new Operation("Undo", 6) {

                public String a()
                {
                    return "undo";
                }

            };
            h = new Operation("Looksclick", 7) {

                public String a()
                {
                    return "looksclick";
                }

            };
            i = new Operation("HowTo", 8) {

                public String a()
                {
                    return "how_to";
                }

            };
            j = new Operation("More", 9) {

                public String a()
                {
                    return "more";
                }

            };
            k = (new Operation[] {
                a, b, c, d, e, f, g, h, i, j
            });
        }

        private Operation(String s, int l)
        {
            super(s, l);
        }

    }

}
