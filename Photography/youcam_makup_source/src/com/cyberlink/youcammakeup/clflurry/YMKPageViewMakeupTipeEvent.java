// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKPageViewMakeupTipeEvent extends BaseEvent
{

    public YMKPageViewMakeupTipeEvent(SourceName sourcename)
    {
        super("YMK_PageView_MakeupTips");
        HashMap hashmap = new HashMap();
        hashmap.put("source_name", sourcename.a());
        a(hashmap);
    }

    private class SourceName extends Enum
    {

        public static final SourceName a;
        public static final SourceName b;
        private static final SourceName c[];

        public static SourceName valueOf(String s)
        {
            return (SourceName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKPageViewMakeupTipeEvent$SourceName, s);
        }

        public static SourceName[] values()
        {
            return (SourceName[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new SourceName("LauncherPage", 0) {

                public String a()
                {
                    return "launcher_page";
                }

            };
            b = new SourceName("BeautyCircle", 1) {

                public String a()
                {
                    return "beauty_circle";
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
