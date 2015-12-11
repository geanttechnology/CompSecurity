// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;


// Referenced classes of package com.shazam.android.analytics.event.factory:
//            GooglePlusLogInEventFactory

public static final class action extends Enum
{

    private static final LOGIN $VALUES[];
    public static final LOGIN CANCEL;
    public static final LOGIN ERROR;
    public static final LOGIN LOGIN;
    public static final LOGIN SUCCESS;
    private final String action;

    public static action valueOf(String s)
    {
        return (action)Enum.valueOf(com/shazam/android/analytics/event/factory/GooglePlusLogInEventFactory$GooglePlusLoginActions, s);
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
        CANCEL = new <init>("CANCEL", 0, "cancel");
        ERROR = new <init>("ERROR", 1, "error");
        SUCCESS = new <init>("SUCCESS", 2, "success");
        LOGIN = new <init>("LOGIN", 3, "login");
        $VALUES = (new .VALUES[] {
            CANCEL, ERROR, SUCCESS, LOGIN
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        action = s1;
    }
}
