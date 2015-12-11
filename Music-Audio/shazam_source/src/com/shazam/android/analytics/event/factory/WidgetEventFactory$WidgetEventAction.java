// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;


// Referenced classes of package com.shazam.android.analytics.event.factory:
//            WidgetEventFactory

public static final class action extends Enum
{

    private static final REMOVED $VALUES[];
    public static final REMOVED ADDED;
    public static final REMOVED PRESSED;
    public static final REMOVED REMOVED;
    private final String action;

    public static action valueOf(String s)
    {
        return (action)Enum.valueOf(com/shazam/android/analytics/event/factory/WidgetEventFactory$WidgetEventAction, s);
    }

    public static action[] values()
    {
        return (action[])$VALUES.clone();
    }

    public final String getAction()
    {
        return action;
    }

    static 
    {
        ADDED = new <init>("ADDED", 0, "added");
        PRESSED = new <init>("PRESSED", 1, "pressed");
        REMOVED = new <init>("REMOVED", 2, "removed");
        $VALUES = (new .VALUES[] {
            ADDED, PRESSED, REMOVED
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        action = s1;
    }
}
