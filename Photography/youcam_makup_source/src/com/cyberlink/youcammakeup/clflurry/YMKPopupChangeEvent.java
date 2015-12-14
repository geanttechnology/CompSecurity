// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKPopupChangeEvent extends BaseEvent
{

    public YMKPopupChangeEvent(Operation operation)
    {
        super("YMK_Popup_Change");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", operation.a());
        hashmap.put("ver", "1");
        a(hashmap);
    }

    private class Operation extends Enum
    {

        public static final Operation a;
        public static final Operation b;
        private static final Operation c[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKPopupChangeEvent$Operation, s);
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
            b = new Operation("Continue", 1) {

                public String a()
                {
                    return "continue";
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

}
