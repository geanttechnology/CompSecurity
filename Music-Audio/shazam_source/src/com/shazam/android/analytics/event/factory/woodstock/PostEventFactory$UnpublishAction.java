// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory.woodstock;


// Referenced classes of package com.shazam.android.analytics.event.factory.woodstock:
//            PostEventFactory

public static final class value extends Enum
    implements value
{

    private static final ERROR $VALUES[];
    public static final ERROR ERROR;
    public static final ERROR SUCCESS;
    public static final ERROR UNPUBLISH;
    public static final ERROR UNPUBLISH_AND_DELETE;
    private final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/shazam/android/analytics/event/factory/woodstock/PostEventFactory$UnpublishAction, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public final String getValue()
    {
        return value;
    }

    static 
    {
        UNPUBLISH = new <init>("UNPUBLISH", 0, "unpublish");
        UNPUBLISH_AND_DELETE = new <init>("UNPUBLISH_AND_DELETE", 1, "unpublishdelete");
        SUCCESS = new <init>("SUCCESS", 2, "success");
        ERROR = new <init>("ERROR", 3, "error");
        $VALUES = (new .VALUES[] {
            UNPUBLISH, UNPUBLISH_AND_DELETE, SUCCESS, ERROR
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
