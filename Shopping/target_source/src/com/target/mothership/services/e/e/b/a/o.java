// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b.a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.mothership.services.e.e.b.a:
//            r, k

public class o extends r
{

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private String mCategoryName;
    private ArrayList mEyeBrow;
    private boolean mFreeShipping;
    private k mLimitedAvailableQuantity;
    private boolean mMinAdPriceExists;
    private String mPreOrderDate;

    public boolean a()
    {
        return mMinAdPriceExists;
    }

    public Date b()
    {
        if (mPreOrderDate == null)
        {
            return null;
        }
        Date date;
        try
        {
            date = (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).parse(mPreOrderDate);
        }
        catch (ParseException parseexception)
        {
            return null;
        }
        return date;
    }

    public List c()
    {
        return mEyeBrow;
    }

    public String d()
    {
        return mCategoryName;
    }

    public boolean e()
    {
        return mFreeShipping;
    }

    public k f()
    {
        return mLimitedAvailableQuantity;
    }
}
