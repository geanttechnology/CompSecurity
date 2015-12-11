// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.util.ArraySharedPreferences;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.groupon.models.payment:
//            AbstractPaymentMethod

public abstract class ECommercePaymentMethod extends AbstractPaymentMethod
{

    ECommercePaymentMethod(Activity activity, Context context, ArraySharedPreferences arraysharedpreferences, Deal deal, Option option, int i, boolean flag, 
            String s)
    {
        super(activity, context, arraysharedpreferences, deal, option, i, flag, s);
    }

    protected void addSpecificParams(List list)
    {
        list.addAll(Arrays.asList(new String[] {
            "billing_record[type]", getName()
        }));
    }

    public abstract String getDisplayName();

    public String getName()
    {
        return getId();
    }

    public boolean isEcommercePayment()
    {
        return true;
    }
}
