// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            NotificationFactory

public static final class notificationTypeString extends Enum
{

    private static final PROXIMITY $VALUES[];
    public static final PROXIMITY CLIENT_PULL;
    public static final PROXIMITY PROXIMITY;
    public static final PROXIMITY SERVER_PUSH;
    private String notificationTypeString;

    public static notificationTypeString valueOf(String s)
    {
        return (notificationTypeString)Enum.valueOf(com/groupon/util/NotificationFactory$NotificationDetail$NotificationType, s);
    }

    public static notificationTypeString[] values()
    {
        return (notificationTypeString[])$VALUES.clone();
    }

    static 
    {
        CLIENT_PULL = new <init>("CLIENT_PULL", 0, "{\"pushType\" : \"pull\"}");
        SERVER_PUSH = new <init>("SERVER_PUSH", 1, "{\"pushType\" : \"GCM\"}");
        PROXIMITY = new <init>("PROXIMITY", 2, "{\"pushType\" : \"proximity\"}");
        $VALUES = (new .VALUES[] {
            CLIENT_PULL, SERVER_PUSH, PROXIMITY
        });
    }


    private (String s, int i, String s1)
    {
        super(s, i);
        notificationTypeString = s1;
    }
}
