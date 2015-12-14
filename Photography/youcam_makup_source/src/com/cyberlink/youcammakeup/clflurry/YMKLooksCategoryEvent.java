// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKLooksCategoryEvent extends BaseEvent
{

    public YMKLooksCategoryEvent(Operation operation, String s, long l)
    {
        super("YMK_Looks_Category");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("category", s);
        hashmap.put("category_id", String.valueOf(l));
        hashmap.put("ver", "1");
        a(hashmap);
    }

    public YMKLooksCategoryEvent(Operation operation, String s, String s1)
    {
        super("YMK_Looks_Category");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("guid", s);
        hashmap.put("look_name", s1);
        hashmap.put("ver", "1");
        a(hashmap);
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
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLooksCategoryEvent$Operation, s);
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
            b = new Operation("LookShow", 1) {

                public String a()
                {
                    return "lookshow";
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
