// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;


// Referenced classes of package com.amazon.now.debug:
//            DebugActivity

public static final class  extends Enum
{

    private static final WEB_ACTIVITY $VALUES[];
    public static final WEB_ACTIVITY MAP_ACTIVITY;
    public static final WEB_ACTIVITY WEB_ACTIVITY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/now/debug/DebugActivity$DebugLaunchActivity, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MAP_ACTIVITY = new <init>("MAP_ACTIVITY", 0);
        WEB_ACTIVITY = new <init>("WEB_ACTIVITY", 1);
        $VALUES = (new .VALUES[] {
            MAP_ACTIVITY, WEB_ACTIVITY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
