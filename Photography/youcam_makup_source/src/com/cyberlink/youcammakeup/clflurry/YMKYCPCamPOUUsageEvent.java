// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKYCPCamPOUUsageEvent extends BaseEvent
{

    public YMKYCPCamPOUUsageEvent(CameraType cameratype)
    {
        super("YMK_YCPCamPOU_Usage");
        HashMap hashmap = new HashMap();
        hashmap.put("DisplayName", cameratype.a());
        a(hashmap);
    }

    private class CameraType extends Enum
    {

        public static final CameraType a;
        public static final CameraType b;
        private static final CameraType c[];

        public static CameraType valueOf(String s)
        {
            return (CameraType)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKYCPCamPOUUsageEvent$CameraType, s);
        }

        public static CameraType[] values()
        {
            return (CameraType[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new CameraType("YouCamPerfect", 0) {

                public String a()
                {
                    return "YouCam Perfect Beauty Camera";
                }

            };
            b = new CameraType("SystemCamera", 1) {

                public String a()
                {
                    return "System Camera";
                }

            };
            c = (new CameraType[] {
                a, b
            });
        }

        private CameraType(String s, int i)
        {
            super(s, i);
        }

    }

}
