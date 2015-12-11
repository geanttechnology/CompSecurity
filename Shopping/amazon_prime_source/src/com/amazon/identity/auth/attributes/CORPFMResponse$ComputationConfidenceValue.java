// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CORPFMResponse

public static final class mIsGuess extends Enum
{

    private static final getValue $VALUES[];
    public static final getValue CUSTOMER_BASED_GUESS;
    public static final getValue CUSTOMER_PROVIDED;
    public static final getValue DEVICE_BASED_GUESS;
    private static final Map LOOKUP_BY_VALUE;
    private final boolean mIsGuess;
    private final String mValue;

    public static mIsGuess parseFromValue(String s, mIsGuess misguess)
    {
        s = (mIsGuess)LOOKUP_BY_VALUE.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return misguess;
        }
    }

    public static LOOKUP_BY_VALUE valueOf(String s)
    {
        return (LOOKUP_BY_VALUE)Enum.valueOf(com/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue, s);
    }

    public static LOOKUP_BY_VALUE[] values()
    {
        return (LOOKUP_BY_VALUE[])$VALUES.clone();
    }

    public String getValue()
    {
        return mValue;
    }

    public boolean isGuess()
    {
        return mIsGuess;
    }

    static 
    {
        CUSTOMER_PROVIDED = new <init>("CUSTOMER_PROVIDED", 0, "CUSTOMER_PROVIDED", false);
        CUSTOMER_BASED_GUESS = new <init>("CUSTOMER_BASED_GUESS", 1, "CUSTOMER_BASED_GUESS", true);
        DEVICE_BASED_GUESS = new <init>("DEVICE_BASED_GUESS", 2, "DEVICE_BASED_GUESS", true);
        $VALUES = (new .VALUES[] {
            CUSTOMER_PROVIDED, CUSTOMER_BASED_GUESS, DEVICE_BASED_GUESS
        });
        LOOKUP_BY_VALUE = new HashMap();
        mIsGuess amisguess[] = values();
        int j = amisguess.length;
        for (int i = 0; i < j; i++)
        {
            mIsGuess misguess = amisguess[i];
            LOOKUP_BY_VALUE.put(misguess.getValue(), misguess);
        }

    }

    private (String s, int i, String s1, boolean flag)
    {
        super(s, i);
        mValue = s1;
        mIsGuess = flag;
    }
}
