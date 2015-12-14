// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class PercentageOfCameraUsing extends BaseEvent
{

    public PercentageOfCameraUsing(CameraType cameratype)
    {
        super("Percentage of users choose to use YouCam Perfect and system camera");
        HashMap hashmap = new HashMap();
        hashmap.put("CameraType", cameratype.a());
        a(hashmap);
    }

    private class CameraType extends Enum
    {

        public static final CameraType a;
        public static final CameraType b;
        private static final CameraType c[];

        public static CameraType valueOf(String s)
        {
            return (CameraType)Enum.valueOf(com/cyberlink/youcammakeup/flurry/PercentageOfCameraUsing$CameraType, s);
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
                    return "YouCam Perfect";
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
