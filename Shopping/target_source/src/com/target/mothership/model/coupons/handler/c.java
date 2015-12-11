// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.util.o;

public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c FAILED;
    public static final c PARTIAL_SUCCESS;
    public static final c PREASSIGNED;
    public static final c SUCCESS;
    public static final c UNKNOWN;
    private String mValue;

    private c(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static c a(String s)
    {
        if (o.g(s)) goto _L2; else goto _L1
_L1:
        c c1 = UNKNOWN;
_L4:
        return c1;
_L2:
        c ac[] = values();
        int j = ac.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                c c2 = ac[i];
                c1 = c2;
                if (s.equalsIgnoreCase(c2.a()))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return UNKNOWN;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/target/mothership/model/coupons/handler/c, s);
    }

    public static c[] values()
    {
        return (c[])$VALUES.clone();
    }

    public String a()
    {
        return mValue;
    }

    static 
    {
        FAILED = new c("FAILED", 0, "0");
        PREASSIGNED = new c("PREASSIGNED", 1, "1");
        SUCCESS = new c("SUCCESS", 2, "2");
        PARTIAL_SUCCESS = new c("PARTIAL_SUCCESS", 3, "3");
        UNKNOWN = new c("UNKNOWN", 4, "");
        $VALUES = (new c[] {
            FAILED, PREASSIGNED, SUCCESS, PARTIAL_SUCCESS, UNKNOWN
        });
    }
}
