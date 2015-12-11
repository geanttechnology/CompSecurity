// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.ebay.common.Preferences;
import com.ebay.common.model.local.EbayNowDeliveryTimeSlot;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.EbaySite;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.checkout.delivery:
//            DeliveryDate, DeliveryDateFragment, DeliverySchedulingActivity

public class DeliveryDateAdapter extends FragmentStatePagerAdapter
{

    final List deliveryDates = new ArrayList();
    private final DeliverySchedulingActivity deliverySchedulingActivity;
    private final SparseArray pagerFragments = new SparseArray();

    public DeliveryDateAdapter(DeliverySchedulingActivity deliveryschedulingactivity, FragmentManager fragmentmanager, EbayNowDeliveryTimeSlot aebaynowdeliverytimeslot[])
    {
        super(fragmentmanager);
        deliverySchedulingActivity = deliveryschedulingactivity;
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        int j = aebaynowdeliverytimeslot.length;
        for (int i = 0; i < j; i++)
        {
            EbayNowDeliveryTimeSlot ebaynowdeliverytimeslot = aebaynowdeliverytimeslot[i];
            Date date = Util.getZeroTimeDate(ebaynowdeliverytimeslot.start);
            fragmentmanager = (List)hashmap.get(date);
            deliveryschedulingactivity = fragmentmanager;
            if (fragmentmanager == null)
            {
                deliveryschedulingactivity = new ArrayList();
                hashmap.put(date, deliveryschedulingactivity);
                arraylist.add(date);
            }
            deliveryschedulingactivity.add(ebaynowdeliverytimeslot);
        }

        for (deliveryschedulingactivity = arraylist.iterator(); deliveryschedulingactivity.hasNext(); deliveryDates.add(fragmentmanager))
        {
            fragmentmanager = (Date)deliveryschedulingactivity.next();
            fragmentmanager = new DeliveryDate(fragmentmanager, (List)hashmap.get(fragmentmanager));
        }

    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        super.destroyItem(viewgroup, i, obj);
        pagerFragments.remove(i);
    }

    public int getCount()
    {
        return deliveryDates.size();
    }

    DeliveryDateFragment getFragment(int i)
    {
        return (DeliveryDateFragment)pagerFragments.get(i);
    }

    public volatile Fragment getItem(int i)
    {
        return getItem(i);
    }

    public DeliveryDateFragment getItem(int i)
    {
        boolean flag = true;
        DeliveryDateFragment deliverydatefragment = new DeliveryDateFragment();
        Bundle bundle = new Bundle();
        if (deliverySchedulingActivity.lineItems.size() <= 1)
        {
            flag = false;
        }
        bundle.putBoolean("multiple_ebn_items", flag);
        bundle.putString("seller_name", deliverySchedulingActivity.getSellerName());
        bundle.putParcelable("delivery_date", (Parcelable)deliveryDates.get(i));
        deliverydatefragment.setArguments(bundle);
        return deliverydatefragment;
    }

    public CharSequence getPageTitle(int i)
    {
        DeliveryDate deliverydate = (DeliveryDate)deliveryDates.get(i);
        java.util.Locale locale = MyApp.getPrefs().getCurrentSite().getLocale();
        long l = deliverydate.date.getTime();
        if (DateUtils.isToday(l))
        {
            return deliverySchedulingActivity.getString(0x7f070cb4, new Object[] {
                DateUtils.formatDateTime(deliverySchedulingActivity, l, 0x18018)
            }).toUpperCase(locale);
        } else
        {
            return DateUtils.formatDateTime(deliverySchedulingActivity, l, 0x1801a).toUpperCase(locale);
        }
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        viewgroup = (DeliveryDateFragment)super.instantiateItem(viewgroup, i);
        pagerFragments.put(i, viewgroup);
        return viewgroup;
    }
}
