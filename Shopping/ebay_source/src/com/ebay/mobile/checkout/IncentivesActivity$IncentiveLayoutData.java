// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import com.ebay.common.model.cart.Incentive;
import com.ebay.nautilus.domain.data.CurrencyAmount;

// Referenced classes of package com.ebay.mobile.checkout:
//            IncentivesActivity

private static final class isApplied
    implements Comparable
{

    final CurrencyAmount amount;
    final String code;
    final String description;
    final boolean isApplied;
    final CurrencyAmount remainingAmount;

    public int compareTo(isApplied isapplied)
    {
        if (code != null && isapplied.code != null)
        {
            return code.compareTo(isapplied.code);
        }
        if (code == null)
        {
            return -1;
        }
        return isapplied != null ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    (com.ebay.common.model.cart. , String s, CurrencyAmount currencyamount)
    {
        code = .de;
        description = s;
        if (.scription != null)
        {
            amount = .ount;
        } else
        {
            amount = null;
        }
        remainingAmount = currencyamount;
        isApplied = true;
    }

    isApplied(Incentive incentive, String s)
    {
        code = incentive.redemptionCode;
        description = s;
        if (incentive.discountAmount != null)
        {
            amount = incentive.discountAmount;
        } else
        {
            amount = null;
        }
        remainingAmount = null;
        isApplied = false;
    }

    isApplied(com.ebay.common.model.cart.Applied applied, String s)
    {
        code = applied.de;
        description = s;
        if (applied. != null)
        {
            amount = applied.;
        } else
        {
            amount = null;
        }
        remainingAmount = null;
        isApplied = false;
    }
}
