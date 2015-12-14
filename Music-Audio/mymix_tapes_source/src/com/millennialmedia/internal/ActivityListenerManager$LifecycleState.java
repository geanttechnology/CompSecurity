// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            ActivityListenerManager

public static final class I extends Enum
{

    private static final DESTROYED $VALUES[];
    public static final DESTROYED CREATED;
    public static final DESTROYED DESTROYED;
    public static final DESTROYED PAUSED;
    public static final DESTROYED RESUMED;
    public static final DESTROYED STARTED;
    public static final DESTROYED STOPPED;
    public static final DESTROYED UNKNOWN;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/millennialmedia/internal/ActivityListenerManager$LifecycleState, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        CREATED = new <init>("CREATED", 1);
        STARTED = new <init>("STARTED", 2);
        RESUMED = new <init>("RESUMED", 3);
        PAUSED = new <init>("PAUSED", 4);
        STOPPED = new <init>("STOPPED", 5);
        DESTROYED = new <init>("DESTROYED", 6);
        $VALUES = (new .VALUES[] {
            UNKNOWN, CREATED, STARTED, RESUMED, PAUSED, STOPPED, DESTROYED
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
