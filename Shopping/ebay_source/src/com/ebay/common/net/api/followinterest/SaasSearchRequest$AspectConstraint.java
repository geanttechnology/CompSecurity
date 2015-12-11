// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import java.util.List;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            SaasSearchRequest

public static class 
{

    public String name;
    public List value;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (getClass() == obj.getClass())
                {
                    obj = ()obj;
                    flag = flag1;
                    if (name.equals(((name) (obj)).name))
                    {
                        return value.equals(((value) (obj)).value);
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return name.hashCode() * 31 + value.hashCode();
    }

    public ()
    {
    }
}
