// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKTemplateStoreEvent extends BaseEvent
{

    public static long b;
    public static String c = "1";

    public YMKTemplateStoreEvent(Feature feature, long l, long l1)
    {
        super("YMK_Template_Store");
        HashMap hashmap = new HashMap();
        hashmap.put("feature", feature.a());
        l = l1 - l;
        if (l > 0L)
        {
            hashmap.put("staytime", String.valueOf(l));
        }
        hashmap.put("ver", c);
        a(hashmap);
    }

    public YMKTemplateStoreEvent(Operation operation)
    {
        super("YMK_Template_Store");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("ver", c);
        a(hashmap);
    }


    private class Feature extends Enum
    {

        public static final Feature a;
        public static final Feature b;
        public static final Feature c;
        public static final Feature d;
        public static final Feature e;
        public static final Feature f;
        public static final Feature g;
        public static final Feature h;
        private static final Feature i[];

        public static Feature valueOf(String s)
        {
            return (Feature)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKTemplateStoreEvent$Feature, s);
        }

        public static Feature[] values()
        {
            return (Feature[])i.clone();
        }

        public abstract String a();

        static 
        {
            a = new Feature("NaturalMakeup", 0) {

                public String a()
                {
                    return "natural_makeup";
                }

            };
            b = new Feature("Costume", 1) {

                public String a()
                {
                    return "costume";
                }

            };
            c = new Feature("Eyeliner", 2) {

                public String a()
                {
                    return "eyeliner";
                }

            };
            d = new Feature("Eyeshadow", 3) {

                public String a()
                {
                    return "eyeshadow";
                }

            };
            e = new Feature("Hair", 4) {

                public String a()
                {
                    return "hair";
                }

            };
            f = new Feature("Eyelash", 5) {

                public String a()
                {
                    return "eyelash";
                }

            };
            g = new Feature("Accessory", 6) {

                public String a()
                {
                    return "accessory";
                }

            };
            h = new Feature("Glasses", 7) {

                public String a()
                {
                    return "glasses";
                }

            };
            i = (new Feature[] {
                a, b, c, d, e, f, g, h
            });
        }

        private Feature(String s, int j)
        {
            super(s, j);
        }

    }


    private class Operation extends Enum
    {

        public static final Operation a;
        private static final Operation b[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKTemplateStoreEvent$Operation, s);
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

}
