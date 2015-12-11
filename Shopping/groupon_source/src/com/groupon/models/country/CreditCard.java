// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.country;


// Referenced classes of package com.groupon.models.country:
//            PaymentMethod

public class CreditCard extends PaymentMethod
{

    public boolean requireCVV;

    public CreditCard()
    {
    }

    public CreditCard(com.groupon.models.country.json.CreditCard creditcard)
    {
        name = creditcard.name;
        requireCVV = creditcard.requireCVV;
        recurringType = creditcard.recurringType;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            if (!super.equals(obj))
            {
                return false;
            }
            obj = (CreditCard)obj;
            if (requireCVV != ((CreditCard) (obj)).requireCVV)
            {
                return false;
            }
            if (recurringType == null ? ((CreditCard) (obj)).recurringType != null : !recurringType.equals(((CreditCard) (obj)).recurringType))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int k = super.hashCode();
        int i;
        if (requireCVV)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (recurringType != null)
        {
            j = recurringType.hashCode();
        }
        return (k * 31 + i) * 31 + j;
    }
}
