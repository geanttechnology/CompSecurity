// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.env;

import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.env:
//            EnvironmentUtils

public static final class  extends Enum
{

    private static final prod $VALUES[];
    public static final prod devo;
    public static final prod pre_prod;
    public static final prod prod;

    public static  fromString(String s)
    {
         a[] = values();
        int j = a.length;
        for (int i = 0; i < j; i++)
        {
              = a[i];
            if (.toString().equalsIgnoreCase(s))
            {
                return ;
            }
        }

        MAPLog.e(EnvironmentUtils.access$000(), String.format("Not able to determine environment for value %s. Defaulting to Prod", new Object[] {
            s
        }));
        return prod;
    }

    public static prod valueOf(String s)
    {
        return (prod)Enum.valueOf(com/amazon/identity/auth/device/env/EnvironmentUtils$Environment, s);
    }

    public static prod[] values()
    {
        return (prod[])$VALUES.clone();
    }

    static 
    {
        devo = new <init>("devo", 0);
        pre_prod = new <init>("pre_prod", 1);
        prod = new <init>("prod", 2);
        $VALUES = (new .VALUES[] {
            devo, pre_prod, prod
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
