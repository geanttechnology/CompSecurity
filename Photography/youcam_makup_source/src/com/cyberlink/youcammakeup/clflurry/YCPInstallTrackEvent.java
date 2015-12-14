// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YCPInstallTrackEvent extends BaseEvent
{

    public YCPInstallTrackEvent(STATUS status)
    {
        super(status.toString());
        status = new HashMap();
        status.put("Country", Locale.getDefault().getCountry());
        a(status);
    }

    private class STATUS extends Enum
    {

        public static final STATUS a;
        public static final STATUS b;
        public static final STATUS c;
        private static final STATUS d[];

        public static STATUS valueOf(String s)
        {
            return (STATUS)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YCPInstallTrackEvent$STATUS, s);
        }

        public static STATUS[] values()
        {
            return (STATUS[])d.clone();
        }

        static 
        {
            a = new STATUS("YCPInstallTrack_Tile_Clicked", 0);
            b = new STATUS("YCPInstallTrack_Installed", 1);
            c = new STATUS("YCPInstallTrack_Uninstalled", 2);
            d = (new STATUS[] {
                a, b, c
            });
        }

        private STATUS(String s, int i)
        {
            super(s, i);
        }
    }

}
