// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;


// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationTrackingUtil

public static final class name extends Enum
{

    private static final DUPLICATE_NOTIFICATION $VALUES[];
    public static final DUPLICATE_NOTIFICATION DUPLICATE_NOTIFICATION;
    public static final DUPLICATE_NOTIFICATION MISMATCHED_TOKENS;
    public static final DUPLICATE_NOTIFICATION MISMATCHED_USERS;
    public static final DUPLICATE_NOTIFICATION MISSING_EVENT_TYPE;
    public static final DUPLICATE_NOTIFICATION NOT_LOGGED_IN;
    public static final DUPLICATE_NOTIFICATION NO_USERNAME;
    public static final DUPLICATE_NOTIFICATION REF_ID_EMPTY;
    public final String name;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/mobile/notifications/NotificationTrackingUtil$ErrorType, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        NO_USERNAME = new <init>("NO_USERNAME", 0, "N001");
        NOT_LOGGED_IN = new <init>("NOT_LOGGED_IN", 1, "N002");
        MISMATCHED_USERS = new <init>("MISMATCHED_USERS", 2, "N003");
        REF_ID_EMPTY = new <init>("REF_ID_EMPTY", 3, "N004");
        MISMATCHED_TOKENS = new <init>("MISMATCHED_TOKENS", 4, "N005");
        MISSING_EVENT_TYPE = new <init>("MISSING_EVENT_TYPE", 5, "N006");
        DUPLICATE_NOTIFICATION = new <init>("DUPLICATE_NOTIFICATION", 6, "N007");
        $VALUES = (new .VALUES[] {
            NO_USERNAME, NOT_LOGGED_IN, MISMATCHED_USERS, REF_ID_EMPTY, MISMATCHED_TOKENS, MISSING_EVENT_TYPE, DUPLICATE_NOTIFICATION
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
