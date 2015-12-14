// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import com.aviary.android.feather.common.utils.Objects;
import java.io.Serializable;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils

public static final class price
    implements Serializable
{

    public price option;
    public String price;

    public boolean equals(Object obj)
    {
        if (obj instanceof price)
        {
            if (Objects.equal(((price) (obj = (price)obj)).option, option) && Objects.equal(((option) (obj)).price, price))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int j = option.option();
        int i;
        if (price != null)
        {
            i = price.hashCode();
        } else
        {
            i = 0;
        }
        return i + (j + 1000);
    }

    public String toString()
    {
        return (new StringBuilder()).append("PackOptionWithPrice{ option: ").append(option.option()).append(", price: ").append(price).append("}").toString();
    }

    public A(A a)
    {
        this(a, null);
    }

    public <init>(<init> <init>1, String s)
    {
        option = <init>1;
        price = s;
    }
}
