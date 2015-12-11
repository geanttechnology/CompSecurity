// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.sdk.event;


// Referenced classes of package com.openx.sdk.event:
//            OXMEvent

public static final class  extends Enum
{

    private static final LOG $VALUES[];
    public static final LOG ACTION_HAS_BEGAN;
    public static final LOG ACTION_HAS_DONE;
    public static final LOG CLOSE_ACTIVE_INTERNAL_WINDOW;
    public static final LOG CONFIGURATION_CHANGED;
    public static final LOG INTERSTITIAL_WINDOW_CLOSED;
    public static final LOG LOG;
    public static final LOG ORIENTATION_PROPERTIES_CHANGED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/openx/sdk/event/OXMEvent$OXMEventType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INTERSTITIAL_WINDOW_CLOSED = new <init>("INTERSTITIAL_WINDOW_CLOSED", 0);
        CLOSE_ACTIVE_INTERNAL_WINDOW = new <init>("CLOSE_ACTIVE_INTERNAL_WINDOW", 1);
        ACTION_HAS_BEGAN = new <init>("ACTION_HAS_BEGAN", 2);
        ACTION_HAS_DONE = new <init>("ACTION_HAS_DONE", 3);
        CONFIGURATION_CHANGED = new <init>("CONFIGURATION_CHANGED", 4);
        ORIENTATION_PROPERTIES_CHANGED = new <init>("ORIENTATION_PROPERTIES_CHANGED", 5);
        LOG = new <init>("LOG", 6);
        $VALUES = (new .VALUES[] {
            INTERSTITIAL_WINDOW_CLOSED, CLOSE_ACTIVE_INTERNAL_WINDOW, ACTION_HAS_BEGAN, ACTION_HAS_DONE, CONFIGURATION_CHANGED, ORIENTATION_PROPERTIES_CHANGED, LOG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
