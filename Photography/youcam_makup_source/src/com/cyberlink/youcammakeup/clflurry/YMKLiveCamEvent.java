// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKLiveCamEvent extends BaseEvent
{

    private static String b;
    private static String c = "No";
    private static String d = "Original";

    public YMKLiveCamEvent(boolean flag, long l, long l1, Operation operation, boolean flag1, 
            boolean flag2)
    {
        super("YMK_LiveCam");
        HashMap hashmap = new HashMap();
        if (flag)
        {
            hashmap.put("source", b);
        }
        hashmap.put("operation", operation.a());
        if (flag1)
        {
            hashmap.put("look", d);
        }
        l = l1 - l;
        if (l > 0L)
        {
            hashmap.put("staytime", String.valueOf(l));
        }
        if (flag2)
        {
            hashmap.put("change_feature", c);
        }
        hashmap.put("ver", "2");
        a(hashmap);
    }

    public static void a(boolean flag)
    {
        c = "Yes";
    }

    public static void b(String s)
    {
        b = s;
    }

    public static void c(String s)
    {
        d = s;
    }

    static 
    {
        b = Source.a.a();
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
        public static final Operation k;
        public static final Operation l;
        private static final Operation m[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLiveCamEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])m.clone();
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
            b = new Operation("LooksClick", 1) {

                public String a()
                {
                    return "LooksClick";
                }

            };
            c = new Operation("LooksSlip", 2) {

                public String a()
                {
                    return "LooksSlip";
                }

            };
            d = new Operation("FeatureClick", 3) {

                public String a()
                {
                    return "FeatureClick";
                }

            };
            e = new Operation("FeatureSlip", 4) {

                public String a()
                {
                    return "FeatureSlip";
                }

            };
            f = new Operation("Capture", 5) {

                public String a()
                {
                    return "Capture";
                }

            };
            g = new Operation("Back", 6) {

                public String a()
                {
                    return "Back";
                }

            };
            h = new Operation("Setting", 7) {

                public String a()
                {
                    return "Setting";
                }

            };
            i = new Operation("ChangeCamera", 8) {

                public String a()
                {
                    return "ChangeCamera";
                }

            };
            j = new Operation("HideEffects", 9) {

                public String a()
                {
                    return "HideEffects";
                }

            };
            k = new Operation("Flash", 10) {

                public String a()
                {
                    return "Flash";
                }

            };
            l = new Operation("MoreLooks", 11) {

                public String a()
                {
                    return "more_looks";
                }

            };
            m = (new Operation[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l
            });
        }

        private Operation(String s, int i1)
        {
            super(s, i1);
        }

    }


    private class Source extends Enum
    {

        public static final Source a;
        public static final Source b;
        private static final Source c[];

        public static Source valueOf(String s)
        {
            return (Source)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLiveCamEvent$Source, s);
        }

        public static Source[] values()
        {
            return (Source[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new Source("Launcher", 0) {

                public String a()
                {
                    return "Launcher";
                }

            };
            b = new Source("ResultPageCam", 1) {

                public String a()
                {
                    return "ResultPageCam";
                }

            };
            c = (new Source[] {
                a, b
            });
        }

        private Source(String s, int i)
        {
            super(s, i);
        }

    }

}
