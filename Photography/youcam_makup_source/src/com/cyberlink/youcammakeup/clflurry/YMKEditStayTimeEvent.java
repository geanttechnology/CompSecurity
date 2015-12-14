// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKEditStayTimeEvent extends BaseEvent
{

    public YMKEditStayTimeEvent(Button button, String s)
    {
        super((new StringBuilder()).append("YMK_EditStayTime_").append(button.a()).toString());
        button = new HashMap();
        button.put("StayTime", s);
        a(button);
    }

    private class Button extends Enum
    {

        public static final Button a;
        public static final Button b;
        private static final Button c[];

        public static Button valueOf(String s)
        {
            return (Button)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKEditStayTimeEvent$Button, s);
        }

        public static Button[] values()
        {
            return (Button[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new Button("BACK", 0) {

                public String a()
                {
                    return "Back";
                }

            };
            b = new Button("SAVE", 1) {

                public String a()
                {
                    return "Save";
                }

            };
            c = (new Button[] {
                a, b
            });
        }

        private Button(String s, int i)
        {
            super(s, i);
        }

    }

}
