// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;


// Referenced classes of package com.mopub.common.util:
//            DeviceUtils

public static final class mKey extends Enum
{

    private static final UNDEFINED $VALUES[];
    public static final UNDEFINED DEVICE_ORIENTATION;
    public static final UNDEFINED FORCE_LANDSCAPE;
    public static final UNDEFINED FORCE_PORTRAIT;
    public static final UNDEFINED UNDEFINED;
    private final String mKey;

    public static mKey getForceOrientation(String s)
    {
        mKey amkey[] = values();
        int j = amkey.length;
        for (int i = 0; i < j; i++)
        {
            mKey mkey = amkey[i];
            if (mkey.mKey.equalsIgnoreCase(s))
            {
                return mkey;
            }
        }

        return UNDEFINED;
    }

    public static UNDEFINED valueOf(String s)
    {
        return (UNDEFINED)Enum.valueOf(com/mopub/common/util/DeviceUtils$ForceOrientation, s);
    }

    public static UNDEFINED[] values()
    {
        return (UNDEFINED[])$VALUES.clone();
    }

    static 
    {
        FORCE_PORTRAIT = new <init>("FORCE_PORTRAIT", 0, "portrait");
        FORCE_LANDSCAPE = new <init>("FORCE_LANDSCAPE", 1, "landscape");
        DEVICE_ORIENTATION = new <init>("DEVICE_ORIENTATION", 2, "device");
        UNDEFINED = new <init>("UNDEFINED", 3, "");
        $VALUES = (new .VALUES[] {
            FORCE_PORTRAIT, FORCE_LANDSCAPE, DEVICE_ORIENTATION, UNDEFINED
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mKey = s1;
    }
}
