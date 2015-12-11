// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;


// Referenced classes of package com.shazam.android.analytics.event.factory:
//            AccountLoginEventFactory

public static final class name extends Enum
{

    private static final EMAIL $VALUES[];
    public static final EMAIL EMAIL;
    public static final EMAIL FACEBOOK;
    private final String name;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/shazam/android/analytics/event/factory/AccountLoginEventFactory$AccountLoginProviderName, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    public final String getName()
    {
        return name;
    }

    static 
    {
        FACEBOOK = new <init>("FACEBOOK", 0, "fb");
        EMAIL = new <init>("EMAIL", 1, "email");
        $VALUES = (new .VALUES[] {
            FACEBOOK, EMAIL
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
