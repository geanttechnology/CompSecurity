// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.setting;


// Referenced classes of package com.amazon.identity.platform.setting:
//            PlatformSettings

public static final class  extends Enum
{

    private static final Default $VALUES[];
    public static final Default Default;
    public static final Default DeviceGlobal;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/platform/setting/PlatformSettings$Namespace, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DeviceGlobal = new <init>("DeviceGlobal", 0);
        Default = new <init>("Default", 1);
        $VALUES = (new .VALUES[] {
            DeviceGlobal, Default
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
