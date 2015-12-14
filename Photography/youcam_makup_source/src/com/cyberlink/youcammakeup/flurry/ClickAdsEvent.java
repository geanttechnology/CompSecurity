// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class ClickAdsEvent extends BaseEvent
{

    public static SourceName a;

    public ClickAdsEvent()
    {
        super("ClickAds");
        HashMap hashmap = new HashMap();
        hashmap.put("SourceName", String.valueOf(a));
        a(hashmap);
    }

    static 
    {
        a = SourceName.b;
    }

    private class SourceName extends Enum
    {

        public static final SourceName a;
        public static final SourceName b;
        public static final SourceName c;
        public static final SourceName d;
        public static final SourceName e;
        private static final SourceName f[];

        public static SourceName valueOf(String s)
        {
            return (SourceName)Enum.valueOf(com/cyberlink/youcammakeup/flurry/ClickAdsEvent$SourceName, s);
        }

        public static SourceName[] values()
        {
            return (SourceName[])f.clone();
        }

        static 
        {
            a = new SourceName("Share", 0);
            b = new SourceName("More", 1);
            c = new SourceName("LibraryPicker", 2);
            d = new SourceName("CameraNavigator", 3);
            e = new SourceName("MoreMakeup", 4);
            f = (new SourceName[] {
                a, b, c, d, e
            });
        }

        private SourceName(String s, int i)
        {
            super(s, i);
        }
    }

}
