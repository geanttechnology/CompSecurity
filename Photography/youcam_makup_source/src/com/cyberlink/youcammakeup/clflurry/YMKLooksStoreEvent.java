// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKLooksStoreEvent extends BaseEvent
{

    private static String b = "1";
    private static String c = "";

    public YMKLooksStoreEvent(Operation operation, String s, String s1)
    {
        super("YMK_Looks_Store");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("source", c);
        if (s != null)
        {
            hashmap.put("look", s);
        }
        if (s1 != null)
        {
            hashmap.put("category", s1);
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
        public static final Operation e;
        private static final Operation f[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLooksStoreEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])f.clone();
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
            b = new Operation("Category", 1) {

                public String a()
                {
                    return "category";
                }

            };
            c = new Operation("Download", 2) {

                public String a()
                {
                    return "download";
                }

            };
            d = new Operation("Use", 3) {

                public String a()
                {
                    return "use";
                }

            };
            e = new Operation("Information", 4) {

                public String a()
                {
                    return "information";
                }

            };
            f = (new Operation[] {
                a, b, c, d, e
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }

    }

}
