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
    public static final ERROR CANCEL;
    public static final ERROR ERROR;
    public static final ERROR INIT;
    public static final ERROR LAUNCH_DIALOG;
    public static final ERROR POST;
    public static final ERROR SUCCESS;
    private final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/shazam/android/analytics/event/factory/woodstock/PostEventFactory$PublishAction, s);
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
        LAUNCH_DIALOG = new <init>("LAUNCH_DIALOG", 0, "launchdialog");
        INIT = new <init>("INIT", 1, "init");
        CANCEL = new <init>("CANCEL", 2, "cancel");
        POST = new <init>("POST", 3, "post");
        SUCCESS = new <init>("SUCCESS", 4, "success");
        ERROR = new <init>("ERROR", 5, "error");
        $VALUES = (new .VALUES[] {
            LAUNCH_DIALOG, INIT, CANCEL, POST, SUCCESS, ERROR
        });
    }

    private Y(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
