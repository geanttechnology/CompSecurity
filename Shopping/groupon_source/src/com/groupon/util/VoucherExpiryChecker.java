// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.mygroupons.MyGrouponItem;
import java.util.Date;

public class VoucherExpiryChecker
{

    private final Date currentDate;

    private VoucherExpiryChecker()
    {
        currentDate = new Date();
    }

    public VoucherExpiryChecker(Date date)
    {
        currentDate = date;
    }

    public boolean isVoucherExpired(MyGrouponItem mygrouponitem)
    {
        mygrouponitem = mygrouponitem.expiresAt;
        return mygrouponitem != null && currentDate.after(mygrouponitem);
    }

    public boolean isVoucherExpiredAndHasRetainedValue(MyGrouponItem mygrouponitem)
    {
        return isVoucherExpired(mygrouponitem) && mygrouponitem.hasRetainedValue;
    }
}
