// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.util.PickupUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.List;

// Referenced classes of package com.ebay.mobile.inventory:
//            StorePickerActivity

private class redColor extends ArrayAdapter
{

    private final int greenColor;
    private final LayoutInflater inflater;
    private final com.ebay.common.model.cart.his._cls0 logisticsPlanType;
    private final int redColor;
    final StorePickerActivity this$0;

    public int getCount()
    {
        return super.getCount() + 2;
    }

    public StoreAvailability getItem(int i)
    {
        return (StoreAvailability)super.getItem(i - 1);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public int getItemViewType(int i)
    {
        if (i == 0 || i == getCount() - 1)
        {
            return -1;
        } else
        {
            return super.getItemViewType(i - 1);
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        StoreAvailability storeavailability;
        if (i == 0)
        {
            return inflater.inflate(0x7f03025a, viewgroup, false);
        }
        if (i == getCount() - 1)
        {
            view = DeviceConfiguration.getAsync();
            viewgroup = inflater.inflate(0x7f03025b, viewgroup, false);
            Object obj = getResources();
            view = view.get(DcsString.BopisTermsLink);
            if (!TextUtils.isEmpty(view))
            {
                view = String.format(((Resources) (obj)).getString(0x7f070478), new Object[] {
                    view, ((Resources) (obj)).getString(0x7f070b37)
                });
            } else
            {
                view = ((Resources) (obj)).getString(0x7f070b37);
            }
            view = String.format(((Resources) (obj)).getString(0x7f070b36), new Object[] {
                view
            });
            obj = (TextView)viewgroup.findViewById(0x7f100525);
            ((TextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) (obj)).setText(Html.fromHtml(view));
            return viewgroup;
        }
        StringBuilder stringbuilder;
        Object obj1;
        int j;
        if (view == null || getItemViewType(i) == -1)
        {
            view = inflater.inflate(0x7f03025c, viewgroup, false);
        }
        viewgroup = (FrameLayout)view.findViewById(0x7f100819);
        viewgroup.removeAllViews();
        storeavailability = getItem(i);
        if (com.ebay.common.model.cart.etItem != logisticsPlanType) goto _L2; else goto _L1
_L1:
        stringbuilder = new StringBuilder();
        i = 0;
        if (!TextUtils.isEmpty(storeavailability.name))
        {
            stringbuilder.append(storeavailability.name);
            i = 1;
        }
        j = i;
        if (!TextUtils.isEmpty(storeavailability.address.address1))
        {
            if (i != 0)
            {
                stringbuilder.append("\n");
            }
            stringbuilder.append(storeavailability.address.address1);
            j = 1;
        }
        obj1 = StorePickerActivity.access$1100(storeavailability);
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            if (j != 0)
            {
                stringbuilder.append("\n");
            }
            stringbuilder.append(((String) (obj1)));
        }
        if (stringbuilder.length() > 0)
        {
            obj1 = inflater.inflate(0x7f03025e, viewgroup, false);
            ((TextView)((View) (obj1)).findViewById(0x7f100189)).setText(stringbuilder.toString());
            viewgroup.addView(((View) (obj1)));
        }
_L4:
        ((TextView)view.findViewById(0x7f10081a)).setText(String.format("%.1f %s", new Object[] {
            Double.valueOf(storeavailability.distance), StorePickerActivity.access$1300(StorePickerActivity.this).()
        }));
        ((RadioButton)view.findViewById(0x7f100818)).setChecked(storeavailability.equals(StorePickerActivity.access$000(StorePickerActivity.this).getSelectedStore()));
        return view;
_L2:
        View view1;
        if (com.ebay.common.model.cart.his._fld0 != logisticsPlanType)
        {
            continue; /* Loop/switch isn't completed */
        }
        view1 = inflater.inflate(0x7f03025d, viewgroup, false);
        if (!TextUtils.isEmpty(storeavailability.address.address1))
        {
            TextView textview = (TextView)view1.findViewById(0x7f100352);
            textview.setText(storeavailability.address.address1);
            textview.setTypeface(null, 1);
        }
        if (storeavailability.availability != null)
        {
            View view2 = view.findViewById(0x7f100818);
            TextView textview1 = (TextView)view1.findViewById(0x7f100353);
            textview1.setText(StorePickerActivity.access$1200(StorePickerActivity.this, storeavailability.availability));
            textview1.setTextColor(greenColor);
            view2.setEnabled(true);
            if (!com.ebay.common.model.inventory.OCK.OCK(storeavailability.availability))
            {
                break; /* Loop/switch isn't completed */
            }
            textview1.setTextColor(redColor);
            view2.setEnabled(false);
        }
_L6:
        viewgroup.addView(view1);
        if (true) goto _L4; else goto _L3
_L3:
        if (storeavailability.fulfillmentTime == null) goto _L6; else goto _L5
_L5:
        ((TextView)view1.findViewById(0x7f100354)).setText(PickupUtil.formatFulfillmentTime(StorePickerActivity.this, storeavailability.fulfillmentTime));
          goto _L6
    }

    public (Context context, List list, com.ebay.common.model.cart. )
    {
        this$0 = StorePickerActivity.this;
        super(context, 0, list);
        logisticsPlanType = ;
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        storepickeractivity = getResources();
        greenColor = getColor(0x7f0d0063);
        redColor = getColor(0x7f0d00f0);
    }
}
