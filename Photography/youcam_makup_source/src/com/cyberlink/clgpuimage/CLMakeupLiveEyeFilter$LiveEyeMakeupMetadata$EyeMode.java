// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


public final class  extends Enum
{

    private static final BLINK $VALUES[];
    public static final BLINK BLINK;
    public static final BLINK NORMAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/clgpuimage/CLMakeupLiveEyeFilter$LiveEyeMakeupMetadata$EyeMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NORMAL = new <init>("NORMAL", 0);
        BLINK = new <init>("BLINK", 1);
        $VALUES = (new .VALUES[] {
            NORMAL, BLINK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
