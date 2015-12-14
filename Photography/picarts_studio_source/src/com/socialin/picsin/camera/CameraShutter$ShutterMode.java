// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;


final class  extends Enum
{

    private static final STABLE $VALUES[];
    public static final STABLE BURST;
    public static final STABLE NORMAL;
    public static final STABLE STABLE;
    public static final STABLE TIMER;
    public static final STABLE TIME_LAPSE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/picsin/camera/CameraShutter$ShutterMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NORMAL = new <init>("NORMAL", 0);
        TIMER = new <init>("TIMER", 1);
        BURST = new <init>("BURST", 2);
        TIME_LAPSE = new <init>("TIME_LAPSE", 3);
        STABLE = new <init>("STABLE", 4);
        $VALUES = (new .VALUES[] {
            NORMAL, TIMER, BURST, TIME_LAPSE, STABLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
