// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;


final class  extends Enum
{

    private static final FLYING $VALUES[];
    public static final FLYING ABOUT_TO_ANIMATE;
    public static final FLYING ANIMATING;
    public static final FLYING FLYING;
    public static final FLYING READY;
    public static final FLYING TRACKING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/picsin/camera/view/Panel$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ABOUT_TO_ANIMATE = new <init>("ABOUT_TO_ANIMATE", 0);
        ANIMATING = new <init>("ANIMATING", 1);
        READY = new <init>("READY", 2);
        TRACKING = new <init>("TRACKING", 3);
        FLYING = new <init>("FLYING", 4);
        $VALUES = (new .VALUES[] {
            ABOUT_TO_ANIMATE, ANIMATING, READY, TRACKING, FLYING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
