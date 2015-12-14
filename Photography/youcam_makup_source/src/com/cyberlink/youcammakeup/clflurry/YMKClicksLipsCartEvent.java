// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKClicksLipsCartEvent extends BaseEvent
{

    public static SourceName b;

    public YMKClicksLipsCartEvent(String s, String s1)
    {
        super("YMK_Clicks_Lips_Cart");
        HashMap hashmap = new HashMap();
        hashmap.put("SKU ID", s);
        hashmap.put("SKU Item ID", s1);
        hashmap.put("Source name", b.a());
        a(hashmap);
    }

    public static void a(SourceName sourcename)
    {
        b = sourcename;
    }

    static 
    {
        b = SourceName.a;
    }

    private class SourceName extends Enum
    {

        public static final SourceName a;
        public static final SourceName b;
        private static final SourceName c[];

        public static SourceName valueOf(String s)
        {
            return (SourceName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKClicksLipsCartEvent$SourceName, s);
        }

        public static SourceName[] values()
        {
            return (SourceName[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new SourceName("LauncherBanner", 0) {

                public String a()
                {
                    return "from_LauncherBanner";
                }

            };
            b = new SourceName("Lipsticks", 1) {

                public String a()
                {
                    return "from_lipsticks";
                }

            };
            c = (new SourceName[] {
                a, b
            });
        }

        private SourceName(String s, int i)
        {
            super(s, i);
        }

    }

}
