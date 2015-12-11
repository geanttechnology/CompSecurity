// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.Spinner;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CountriesService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.AbstractRetryAsyncTask;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

private class this._cls0 extends AbstractRetryAsyncTask
{

    final EditCreditCardEu this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public List call()
        throws Exception
    {
        return EditCreditCardEu.access$300(EditCreditCardEu.this).getCountriesSyncTask();
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((List)obj);
    }

    protected void onSuccess(List list)
        throws Exception
    {
        super.onSuccess(list);
        for (list = list.iterator(); list.hasNext();)
        {
            Country country = (Country)list.next();
            if (Strings.equals(country.shortName, currentCountryManager.getCurrentCountry().shortName))
            {
                EditCreditCardEu.access$400(EditCreditCardEu.this, getFilteredCreditCards(country.getCreditCards()));
                paymentMethod.setEnabled(true);
                return;
            }
        }

        throw new RuntimeException("Could not find a country that matches.");
    }

    public ()
    {
        this$0 = EditCreditCardEu.this;
        super(EditCreditCardEu.this);
    }
}
