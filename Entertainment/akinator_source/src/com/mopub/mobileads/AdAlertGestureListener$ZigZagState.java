// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            AdAlertGestureListener

static final class  extends Enum
{

    private static final FAILED $VALUES[];
    public static final FAILED FAILED;
    public static final FAILED FINISHED;
    public static final FAILED GOING_LEFT;
    public static final FAILED GOING_RIGHT;
    public static final FAILED UNSET;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/mobileads/AdAlertGestureListener$ZigZagState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNSET = new <init>("UNSET", 0);
        GOING_RIGHT = new <init>("GOING_RIGHT", 1);
        GOING_LEFT = new <init>("GOING_LEFT", 2);
        FINISHED = new <init>("FINISHED", 3);
        FAILED = new <init>("FAILED", 4);
        $VALUES = (new .VALUES[] {
            UNSET, GOING_RIGHT, GOING_LEFT, FINISHED, FAILED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
