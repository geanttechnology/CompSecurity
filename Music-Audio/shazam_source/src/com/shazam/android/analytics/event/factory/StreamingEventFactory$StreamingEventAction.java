// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;


// Referenced classes of package com.shazam.android.analytics.event.factory:
//            StreamingEventFactory

public static final class action extends Enum
{

    private static final DONE $VALUES[];
    public static final DONE BACK;
    public static final DONE CANCEL;
    public static final DONE CONNECT;
    public static final DONE DONE;
    public static final DONE DOWNLOAD_APP;
    public static final DONE ERROR;
    public static final DONE LOGOUT;
    public static final DONE OPEN_APP;
    public static final DONE SUBSCRIBE;
    public static final DONE SUBSCRIBE_NO_APP_FOUND;
    public static final DONE SUCCESS;
    private final String action;

    public static action valueOf(String s)
    {
        return (action)Enum.valueOf(com/shazam/android/analytics/event/factory/StreamingEventFactory$StreamingEventAction, s);
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
        LOGOUT = new <init>("LOGOUT", 0, "logout");
        CANCEL = new <init>("CANCEL", 1, "cancel");
        SUCCESS = new <init>("SUCCESS", 2, "success");
        ERROR = new <init>("ERROR", 3, "error");
        BACK = new <init>("BACK", 4, "back");
        CONNECT = new <init>("CONNECT", 5, "connect");
        SUBSCRIBE = new <init>("SUBSCRIBE", 6, "subscribe");
        SUBSCRIBE_NO_APP_FOUND = new <init>("SUBSCRIBE_NO_APP_FOUND", 7, "subscribe");
        OPEN_APP = new <init>("OPEN_APP", 8, "openapp");
        DOWNLOAD_APP = new <init>("DOWNLOAD_APP", 9, "downloadapp");
        DONE = new <init>("DONE", 10, "done");
        $VALUES = (new .VALUES[] {
            LOGOUT, CANCEL, SUCCESS, ERROR, BACK, CONNECT, SUBSCRIBE, SUBSCRIBE_NO_APP_FOUND, OPEN_APP, DOWNLOAD_APP, 
            DONE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        action = s1;
    }
}
