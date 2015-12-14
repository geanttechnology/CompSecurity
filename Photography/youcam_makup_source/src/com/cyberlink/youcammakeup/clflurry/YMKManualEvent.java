// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKManualEvent extends BaseEvent
{

    private static String b = "1";
    private static boolean c = false;

    public YMKManualEvent(HintButton hintbutton, Operation operation)
    {
        super("YMK_Manual");
        HashMap hashmap = new HashMap();
        hashmap.put("ibutton", hintbutton.a());
        hashmap.put("operation", operation.a());
        hashmap.put("ver", b);
        a(hashmap);
    }


    private class HintButton extends Enum
    {

        public static final HintButton a;
        public static final HintButton b;
        private static final HintButton c[];

        public static HintButton valueOf(String s)
        {
            return (HintButton)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKManualEvent$HintButton, s);
        }

        public static HintButton[] values()
        {
            return (HintButton[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new HintButton("Yes", 0) {

                public String a()
                {
                    return "Yes";
                }

            };
            b = new HintButton("No", 1) {

                public String a()
                {
                    return "No";
                }

            };
            c = (new HintButton[] {
                a, b
            });
        }

        private HintButton(String s, int i)
        {
            super(s, i);
        }

    }


    private class Operation extends Enum
    {

        public static final Operation a;
        public static final Operation b;
        private static final Operation c[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKManualEvent$Operation, s);
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
                    return "Show";
                }

            };
            b = new Operation("Click", 1) {

                public String a()
                {
                    return "Click";
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
