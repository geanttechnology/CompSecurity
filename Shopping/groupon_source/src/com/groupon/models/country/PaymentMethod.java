// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.country;

import java.io.Serializable;

public abstract class PaymentMethod
    implements Serializable
{

    public String name;
    public String recurringType;

    public PaymentMethod()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PaymentMethod))
            {
                return false;
            }
            obj = (PaymentMethod)obj;
            if (name == null ? ((PaymentMethod) (obj)).name != null : !name.equals(((PaymentMethod) (obj)).name))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        if (name != null)
        {
            return name.hashCode();
        } else
        {
            return 0;
        }
    }
}
