// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;


// Referenced classes of package com.shazam.android.analytics.event.factory:
//            RegistrationEventFactory

public static final class action extends Enum
{

    private static final CHOOSE_ACCOUNT $VALUES[];
    public static final CHOOSE_ACCOUNT CHOOSE_ACCOUNT;
    public static final CHOOSE_ACCOUNT REGISTER;
    private final String action;

    public static action valueOf(String s)
    {
        return (action)Enum.valueOf(com/shazam/android/analytics/event/factory/RegistrationEventFactory$RegistrationAction, s);
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
        REGISTER = new <init>("REGISTER", 0, "register");
        CHOOSE_ACCOUNT = new <init>("CHOOSE_ACCOUNT", 1, "chooseaccount");
        $VALUES = (new .VALUES[] {
            REGISTER, CHOOSE_ACCOUNT
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        action = s1;
    }
}
