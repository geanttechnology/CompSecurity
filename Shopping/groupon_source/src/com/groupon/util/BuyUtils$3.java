// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.Date;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedProvider;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            BuyUtils, IntlDateFormat, CurrencyFormatter

class on_3B_ extends ArrayAdapter
{

    final BuyUtils this$0;
    final Context val$context;
    final Deal val$deal;
    final LayoutInflater val$inflater;

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = val$inflater.inflate(0x7f030169, null);
        Option option = (Option)getItem(i);
        String s1 = option.getTitle();
        TextView textview1 = (TextView)view1.findViewById(0x7f100330);
        TextView textview2 = (TextView)view1.findViewById(0x7f100419);
        TextView textview3 = (TextView)view1.findViewById(0x7f100334);
        TextView textview = (TextView)view1.findViewById(0x7f10041a);
        boolean flag1 = val$deal.getDisplayOption("quantity", true);
        boolean flag2 = val$deal.getDisplayOption("discount", true);
        Date date = option.getExpiresAt();
        boolean flag = option.isSoldOut();
        float f;
        String s;
        Resources resources;
        Integer integer;
        String s2;
        int j;
        int k;
        if (Strings.equalsIgnoreCase("closed", option.getStatus()) || date != null && date.before(new Date()))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (flag || j != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            k = 1;
        } else
        {
            k = option.getMinimumPurchaseQuantity();
        }
        if (((CurrentCountryManager)BuyUtils.access$500(BuyUtils.this).get(val$context)).getCurrentCountry().isUSACompatible())
        {
            view = option.getValue();
        } else
        {
            view = option.getDiscount();
        }
        if (view == null)
        {
            viewgroup = "";
        } else
        {
            viewgroup = ((CurrencyFormatter)BuyUtils.access$700(BuyUtils.this).get(val$context)).formatWithQuantity(view, k);
        }
        if (flag)
        {
            view = val$context.getString(0x7f08027b);
        } else
        if (j != 0)
        {
            view = val$context.getString(0x7f08027a);
        } else
        if (option.getPrice() == null)
        {
            view = "";
        } else
        {
            view = ((CurrencyFormatter)BuyUtils.access$700(BuyUtils.this).get(val$context)).formatWithQuantity(option.getPrice(), k);
        }
        integer = Integer.valueOf(option.getDiscountPercent());
        if (((CurrentCountryManager)BuyUtils.access$500(BuyUtils.this).get(val$context)).getCurrentCountry().isUSACompatible())
        {
            s = option.getSoldQuantityMessage();
        } else
        {
            s = Strings.toString(Integer.valueOf(option.getSoldQuantity()));
        }
        resources = val$context.getResources();
        if (((CurrentCountryManager)BuyUtils.access$500(BuyUtils.this).get(val$context)).getCurrentCountry().isUSACompatible())
        {
            j = 0x7f080278;
        } else
        {
            j = 0x7f080279;
        }
        s2 = resources.getString(j, new Object[] {
            integer, viewgroup, s
        });
        s = resources.getQuantityString(0x7f0c0001, option.getSoldQuantity(), new Object[] {
            s
        });
        viewgroup = resources.getString(0x7f080133, new Object[] {
            integer, viewgroup
        });
        if (option.getDiscountPercent() > 0 && flag2)
        {
            if (flag1)
            {
                viewgroup = (new StringBuilder()).append(s2).append(" ").append(resources.getQuantityString(0x7f0c0002, option.getSoldQuantity())).toString();
            }
        } else
        {
            viewgroup = s;
        }
        s = resources.getString(0x7f0801ae);
        textview1.setText(s1);
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        textview1.setEnabled(flag);
        textview2.setText(viewgroup);
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        textview2.setEnabled(flag);
        if (flag1 || flag2)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        textview2.setVisibility(j);
        textview3.setText(view);
        if (i != 0)
        {
            f = 20F;
        } else
        {
            f = 25F;
        }
        textview3.setTextSize(1, f);
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        textview3.setEnabled(flag);
        view = (IntlDateFormat)RoboGuice.getInjector(val$context).getInstance(com/groupon/util/IntlDateFormat);
        if (date != null)
        {
            view = String.format(s, new Object[] {
                view.format(date)
            });
        } else
        {
            view = "";
        }
        textview.setText(view);
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        textview.setEnabled(flag);
        return view1;
    }

    public boolean isEnabled(int i)
    {
        Option option = (Option)getItem(i);
        Date date = option.getExpiresAt();
        return !option.isSoldOut() && !Strings.equalsIgnoreCase("closed", option.getStatus()) && (date == null || !date.before(new Date()));
    }

    (LayoutInflater layoutinflater, Deal deal1, Context context2)
    {
        this$0 = final_buyutils;
        val$inflater = layoutinflater;
        val$deal = deal1;
        val$context = context2;
        super(final_context1, final_i, _5B_Lcom.groupon.db.models.Option_3B_.this);
    }
}
