// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;


// Referenced classes of package com.inmobi.commons.core.configs:
//            ConfigNetworkResponse

public static final class a extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN INTERNAL_ERROR;
    public static final UNKNOWN NOT_MODIFIED;
    public static final UNKNOWN PRODUCT_NOT_FOUND;
    public static final UNKNOWN SUCCESS;
    public static final UNKNOWN UNKNOWN;
    private int a;

    public static a fromValue(int i)
    {
        a aa[] = values();
        int k = aa.length;
        for (int j = 0; j < k; j++)
        {
            a a1 = aa[j];
            if (a1.a == i)
            {
                return a1;
            }
        }

        return UNKNOWN;
    }

    public static UNKNOWN valueOf(String s)
    {
        return (UNKNOWN)Enum.valueOf(com/inmobi/commons/core/configs/ConfigNetworkResponse$ConfigResponse$ConfigResponseStatus, s);
    }

    public static UNKNOWN[] values()
    {
        return (UNKNOWN[])$VALUES.clone();
    }

    public int getValue()
    {
        return a;
    }

    static 
    {
        SUCCESS = new <init>("SUCCESS", 0, 200);
        NOT_MODIFIED = new <init>("NOT_MODIFIED", 1, 304);
        PRODUCT_NOT_FOUND = new <init>("PRODUCT_NOT_FOUND", 2, 404);
        INTERNAL_ERROR = new <init>("INTERNAL_ERROR", 3, 500);
        UNKNOWN = new <init>("UNKNOWN", 4, -1);
        $VALUES = (new .VALUES[] {
            SUCCESS, NOT_MODIFIED, PRODUCT_NOT_FOUND, INTERNAL_ERROR, UNKNOWN
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
