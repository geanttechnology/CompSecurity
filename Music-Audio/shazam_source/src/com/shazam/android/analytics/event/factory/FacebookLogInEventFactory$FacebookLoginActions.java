// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;


// Referenced classes of package com.shazam.android.analytics.event.factory:
//            FacebookLogInEventFactory

public static final class action extends Enum
{

    private static final DISCONNECT_SUCCESS $VALUES[];
    public static final DISCONNECT_SUCCESS CONNECT;
    public static final DISCONNECT_SUCCESS CONNECT_CANCEL;
    public static final DISCONNECT_SUCCESS CONNECT_ERROR;
    public static final DISCONNECT_SUCCESS CONNECT_SUCCESS;
    public static final DISCONNECT_SUCCESS DISCONNECT;
    public static final DISCONNECT_SUCCESS DISCONNECT_ERROR;
    public static final DISCONNECT_SUCCESS DISCONNECT_SUCCESS;
    private final String action;

    public static action valueOf(String s)
    {
        return (action)Enum.valueOf(com/shazam/android/analytics/event/factory/FacebookLogInEventFactory$FacebookLoginActions, s);
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
        CONNECT = new <init>("CONNECT", 0, "fbconnect");
        CONNECT_CANCEL = new <init>("CONNECT_CANCEL", 1, "fbconnectcancel");
        CONNECT_ERROR = new <init>("CONNECT_ERROR", 2, "fbconnecterror");
        CONNECT_SUCCESS = new <init>("CONNECT_SUCCESS", 3, "fbconnectsuccess");
        DISCONNECT = new <init>("DISCONNECT", 4, "fbdisconnect");
        DISCONNECT_ERROR = new <init>("DISCONNECT_ERROR", 5, "fbdisconnecterror");
        DISCONNECT_SUCCESS = new <init>("DISCONNECT_SUCCESS", 6, "fbdisconnectsuccess");
        $VALUES = (new .VALUES[] {
            CONNECT, CONNECT_CANCEL, CONNECT_ERROR, CONNECT_SUCCESS, DISCONNECT, DISCONNECT_ERROR, DISCONNECT_SUCCESS
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        action = s1;
    }
}
