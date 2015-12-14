// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKLivePhotoEvent extends BaseEvent
{

    public YMKLivePhotoEvent(Operation operation)
    {
        super("YMK_LivePhoto");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("ver", "1");
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
        private static final Operation g[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLivePhotoEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])g.clone();
        }

        public abstract String a();

        static 
        {
            a = new Operation("Album", 0) {

                public String a()
                {
                    return "Album";
                }

            };
            b = new Operation("Makeup", 1) {

                public String a()
                {
                    return "Makeup";
                }

            };
            c = new Operation("Share", 2) {

                public String a()
                {
                    return "Share";
                }

            };
            d = new Operation("Delete", 3) {

                public String a()
                {
                    return "Delete";
                }

            };
            e = new Operation("LiveCam", 4) {

                public String a()
                {
                    return "LiveCam";
                }

            };
            f = new Operation("Show", 5) {

                public String a()
                {
                    return "Show";
                }

            };
            g = (new Operation[] {
                a, b, c, d, e, f
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }

    }

}
