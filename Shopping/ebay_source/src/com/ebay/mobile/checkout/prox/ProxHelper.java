// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.Address;

public class ProxHelper
{

    public ProxHelper()
    {
    }

    protected static void updateInputFormForCountry(Activity activity, View view, EbayCountry ebaycountry, String s)
    {
        if (ebaycountry != null)
        {
            int i = -1;
            View view1;
            boolean flag;
            if (EbayCountry.getInstance(EbaySite.AU) == ebaycountry)
            {
                i = 0x7f0e0000;
            } else
            if (EbayCountry.getInstance(EbaySite.CA) == ebaycountry)
            {
                i = 0x7f0e0001;
            } else
            if (EbayCountry.getInstance(EbaySite.IN) == ebaycountry)
            {
                i = 0x7f0e0002;
            } else
            if (EbayCountry.getInstance(EbaySite.IT) == ebaycountry)
            {
                i = 0x7f0e0003;
            } else
            if (EbayCountry.getInstance(EbaySite.US) == ebaycountry)
            {
                i = 0x7f0e0006;
            } else
            if (EbayCountry.getInstance("JP") == ebaycountry)
            {
                i = 0x7f0e0004;
            }
            view1 = view.findViewById(0x7f100508);
            if (i > 0)
            {
                Spinner spinner = (Spinner)view.findViewById(0x7f100506);
                activity = ArrayAdapter.createFromResource(activity, i, 0x7f030255);
                activity.setDropDownViewResource(0x1090009);
                spinner.setAdapter(activity);
                if (!TextUtils.isEmpty(s))
                {
                    i = activity.getPosition(s);
                    if (i > -1)
                    {
                        spinner.setSelection(i, false);
                    }
                }
                view1.setVisibility(0);
            } else
            {
                view1.setVisibility(8);
            }
            activity = (LinearLayout)view.findViewById(0x7f1004fd);
            s = (LinearLayout)activity.findViewById(0x7f100507);
            view = (EditText)view.findViewById(0x7f100505);
            flag = false;
            if (activity.getTag() != null)
            {
                flag = ((Boolean)activity.getTag()).booleanValue();
            }
            if (Address.countryHasReversedPostalCode(ebaycountry.getCountryCode()))
            {
                if (!flag)
                {
                    activity.removeView(s);
                    activity.removeView(view);
                    activity.addView(s);
                    activity.addView(view);
                    activity.setTag(Boolean.valueOf(true));
                }
            } else
            if (flag)
            {
                activity.removeView(s);
                activity.removeView(view);
                activity.addView(view);
                activity.addView(s);
                activity.setTag(Boolean.valueOf(false));
                return;
            }
        }
    }
}
