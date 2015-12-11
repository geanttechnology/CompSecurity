// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


// Referenced classes of package com.amazon.identity.auth.device.utils:
//            AccountConstants

public static final class mName extends Enum
{

    private static final UNRECOGNIZED $VALUES[];
    public static final UNRECOGNIZED AUTHENTICATION_FAILED;
    public static final UNRECOGNIZED INVALID_INPUT;
    public static final UNRECOGNIZED NAME_ALREADY_USED;
    public static final UNRECOGNIZED NETWORK_FAILURE;
    public static final UNRECOGNIZED NO_AMAZON_ACCOUNT;
    public static final UNRECOGNIZED PARSE_ERROR;
    public static final UNRECOGNIZED UNRECOGNIZED;
    private final String mName;
    private final int mValue;

    public static mName fromValue(int i)
    {
        mName amname[] = values();
        int k = amname.length;
        for (int j = 0; j < k; j++)
        {
            mName mname = amname[j];
            if (mname.value() == i)
            {
                return mname;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    public int value()
    {
        return mValue;
    }

    static 
    {
        NETWORK_FAILURE = new <init>("NETWORK_FAILURE", 0, 0, "NetworkFailure");
        AUTHENTICATION_FAILED = new <init>("AUTHENTICATION_FAILED", 1, 1, "AuthenticationFailed");
        PARSE_ERROR = new <init>("PARSE_ERROR", 2, 2, "ParseError");
        NO_AMAZON_ACCOUNT = new <init>("NO_AMAZON_ACCOUNT", 3, 3, "NoAmazonAccount");
        NAME_ALREADY_USED = new <init>("NAME_ALREADY_USED", 4, 4, "NameAlreadyUsed");
        INVALID_INPUT = new <init>("INVALID_INPUT", 5, 5, "InvalidInputs");
        UNRECOGNIZED = new <init>("UNRECOGNIZED", 6, 6, "Unrecognized");
        $VALUES = (new .VALUES[] {
            NETWORK_FAILURE, AUTHENTICATION_FAILED, PARSE_ERROR, NO_AMAZON_ACCOUNT, NAME_ALREADY_USED, INVALID_INPUT, UNRECOGNIZED
        });
    }

    private (String s, int i, int j, String s1)
    {
        super(s, i);
        mValue = j;
        mName = s1;
    }
}
