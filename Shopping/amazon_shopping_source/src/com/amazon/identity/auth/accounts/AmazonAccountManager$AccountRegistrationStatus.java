// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;


// Referenced classes of package com.amazon.identity.auth.accounts:
//            AmazonAccountManager

public static final class mValue extends Enum
{

    private static final NotFound $VALUES[];
    public static final NotFound Deregistering;
    public static final NotFound NotFound;
    public static final NotFound Registered;
    private final String mValue;

    public static mValue fromValue(String s)
    {
        mValue amvalue[] = values();
        int j = amvalue.length;
        for (int i = 0; i < j; i++)
        {
            mValue mvalue = amvalue[i];
            if (mvalue.getValue().equals(s))
            {
                return mvalue;
            }
        }

        return null;
    }

    public static getValue valueOf(String s)
    {
        return (getValue)Enum.valueOf(com/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus, s);
    }

    public static getValue[] values()
    {
        return (getValue[])$VALUES.clone();
    }

    String getValue()
    {
        return mValue;
    }

    static 
    {
        Registered = new <init>("Registered", 0, "Registered");
        Deregistering = new <init>("Deregistering", 1, "Deregistering");
        NotFound = new <init>("NotFound", 2, "NotFound");
        $VALUES = (new .VALUES[] {
            Registered, Deregistering, NotFound
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }
}
