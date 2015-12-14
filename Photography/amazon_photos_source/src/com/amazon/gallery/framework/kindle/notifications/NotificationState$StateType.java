// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;


// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            NotificationState

public static final class  extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR ERROR;
    public static final ERROR NO_PROGRESS;
    public static final ERROR PROGRESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/notifications/NotificationState$StateType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public boolean isOnGoing()
    {
        return this == PROGRESS;
    }

    static 
    {
        PROGRESS = new <init>("PROGRESS", 0);
        NO_PROGRESS = new <init>("NO_PROGRESS", 1);
        ERROR = new <init>("ERROR", 2);
        $VALUES = (new .VALUES[] {
            PROGRESS, NO_PROGRESS, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
