// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.avod.sdk:
//            Constants

public static final class mCode extends Enum
{

    private static final FAILURE $VALUES[];
    public static final FAILURE FAILURE;
    private static final Map RESPONSE_CODE_MAP;
    public static final FAILURE SUCCESS;
    private final int mCode;

    public static mCode fromResponseCode(int i)
    {
        return (mCode)RESPONSE_CODE_MAP.get(Integer.valueOf(i));
    }

    public static RESPONSE_CODE_MAP valueOf(String s)
    {
        return (RESPONSE_CODE_MAP)Enum.valueOf(com/amazon/avod/sdk/Constants$CallResponseType, s);
    }

    public static RESPONSE_CODE_MAP[] values()
    {
        return (RESPONSE_CODE_MAP[])$VALUES.clone();
    }

    public int getResponseCode()
    {
        return mCode;
    }

    static 
    {
        SUCCESS = new <init>("SUCCESS", 0, 0);
        FAILURE = new <init>("FAILURE", 1, 1);
        $VALUES = (new .VALUES[] {
            SUCCESS, FAILURE
        });
        RESPONSE_CODE_MAP = new HashMap();
        RESPONSE_CODE_MAP.put(Integer.valueOf(SUCCESS.getResponseCode()), SUCCESS);
        RESPONSE_CODE_MAP.put(Integer.valueOf(FAILURE.getResponseCode()), FAILURE);
    }

    private (String s, int i, int j)
    {
        super(s, i);
        mCode = j;
    }
}
