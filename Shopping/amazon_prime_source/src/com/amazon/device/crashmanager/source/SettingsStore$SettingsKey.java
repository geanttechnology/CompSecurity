// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;


// Referenced classes of package com.amazon.device.crashmanager.source:
//            SettingsStore

public static final class  extends Enum
{

    private static final VERSION_NUMBER $VALUES[];
    public static final VERSION_NUMBER DROPBOX_TIME_INDEX_KEY;
    public static final VERSION_NUMBER MAP_BUILD_INDEX_KEY;
    public static final VERSION_NUMBER RAMDUMP_TIME_INDEX_KEY;
    public static final VERSION_NUMBER VERSION_NUMBER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/crashmanager/source/SettingsStore$SettingsKey, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DROPBOX_TIME_INDEX_KEY = new <init>("DROPBOX_TIME_INDEX_KEY", 0);
        MAP_BUILD_INDEX_KEY = new <init>("MAP_BUILD_INDEX_KEY", 1);
        RAMDUMP_TIME_INDEX_KEY = new <init>("RAMDUMP_TIME_INDEX_KEY", 2);
        VERSION_NUMBER = new <init>("VERSION_NUMBER", 3);
        $VALUES = (new .VALUES[] {
            DROPBOX_TIME_INDEX_KEY, MAP_BUILD_INDEX_KEY, RAMDUMP_TIME_INDEX_KEY, VERSION_NUMBER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
