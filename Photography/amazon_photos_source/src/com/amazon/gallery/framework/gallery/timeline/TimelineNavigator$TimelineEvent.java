// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.timeline;


// Referenced classes of package com.amazon.gallery.framework.gallery.timeline:
//            TimelineNavigator

public static final class  extends Enum
{

    private static final AUTO_CLOSE $VALUES[];
    public static final AUTO_CLOSE AUTO_CLOSE;
    public static final AUTO_CLOSE AUTO_OPEN;
    public static final AUTO_CLOSE SWIPE_CLOSE;
    public static final AUTO_CLOSE SWIPE_OPEN;
    public static final AUTO_CLOSE SYSTEM_CLOSE;
    public static final AUTO_CLOSE TAP_CLOSE;
    public static final AUTO_CLOSE TAP_OPEN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/timeline/TimelineNavigator$TimelineEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SWIPE_OPEN = new <init>("SWIPE_OPEN", 0);
        TAP_OPEN = new <init>("TAP_OPEN", 1);
        AUTO_OPEN = new <init>("AUTO_OPEN", 2);
        SWIPE_CLOSE = new <init>("SWIPE_CLOSE", 3);
        TAP_CLOSE = new <init>("TAP_CLOSE", 4);
        SYSTEM_CLOSE = new <init>("SYSTEM_CLOSE", 5);
        AUTO_CLOSE = new <init>("AUTO_CLOSE", 6);
        $VALUES = (new .VALUES[] {
            SWIPE_OPEN, TAP_OPEN, AUTO_OPEN, SWIPE_CLOSE, TAP_CLOSE, SYSTEM_CLOSE, AUTO_CLOSE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
