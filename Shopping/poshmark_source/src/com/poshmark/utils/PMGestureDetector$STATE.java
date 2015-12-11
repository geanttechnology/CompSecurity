// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            PMGestureDetector

static final class  extends Enum
{

    private static final MULTI_FINGER_DRAG $VALUES[];
    public static final MULTI_FINGER_DRAG MULTI_FINGER_DRAG;
    public static final MULTI_FINGER_DRAG MULTI_TAP_START;
    public static final MULTI_FINGER_DRAG NONE;
    public static final MULTI_FINGER_DRAG SINGLE_FINGER_DRAG;
    public static final MULTI_FINGER_DRAG SINGLE_TAP_START;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/utils/PMGestureDetector$STATE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        SINGLE_TAP_START = new <init>("SINGLE_TAP_START", 1);
        MULTI_TAP_START = new <init>("MULTI_TAP_START", 2);
        SINGLE_FINGER_DRAG = new <init>("SINGLE_FINGER_DRAG", 3);
        MULTI_FINGER_DRAG = new <init>("MULTI_FINGER_DRAG", 4);
        $VALUES = (new .VALUES[] {
            NONE, SINGLE_TAP_START, MULTI_TAP_START, SINGLE_FINGER_DRAG, MULTI_FINGER_DRAG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
