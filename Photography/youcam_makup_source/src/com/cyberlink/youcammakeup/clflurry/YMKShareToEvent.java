// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKShareToEvent extends BaseEvent
{

    public static Source b;

    public YMKShareToEvent(Operation operation, String s)
    {
        super("YMK_Share_to");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("source", b.a());
        if (Operation.b == operation)
        {
            hashmap.put("share_to", s);
        }
        hashmap.put("ver", "1");
        a(hashmap);
    }

    public static void a(Source source)
    {
        b = source;
    }

    static 
    {
        b = Source.b;
    }

    private class Operation extends Enum
    {

        public static final Operation a;
        public static final Operation b;
        private static final Operation c[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKShareToEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])c.clone();
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
            b = new Operation("Share", 1) {

                public String a()
                {
                    return "share";
                }

            };
            c = (new Operation[] {
                a, b
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }

    }


    private class Source extends Enum
    {

        public static final Source a;
        public static final Source b;
        private static final Source c[];

        public static Source valueOf(String s)
        {
            return (Source)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKShareToEvent$Source, s);
        }

        public static Source[] values()
        {
            return (Source[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new Source("BeforeAfter", 0) {

                public String a()
                {
                    return "B_A";
                }

            };
            b = new Source("ResultPage", 1) {

                public String a()
                {
                    return "result_page";
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
