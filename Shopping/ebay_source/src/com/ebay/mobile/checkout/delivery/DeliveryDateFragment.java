// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.local.EbayNowDeliveryTimeSlot;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.checkout.delivery:
//            TimeSlotAdapter, DeliverySchedulingActivity, DeliveryDate

public class DeliveryDateFragment extends ListFragment
    implements TextWatcher, android.widget.AdapterView.OnItemClickListener
{

    static final String ARG_DELIVERY_DATE = "delivery_date";
    static final String ARG_MULTIPLE_EBN_ITEMS = "multiple_ebn_items";
    static final String ARG_SELLER_NAME = "seller_name";
    private EditText deliveryInstructions;
    private boolean hasMultipleEbnItems;
    private String sellerName;
    TimeSlotAdapter timeSlotAdapter;

    public DeliveryDateFragment()
    {
    }

    private void setSelectedPositionByToken(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        int i = timeSlotAdapter.getCount() - 1;
_L7:
        if (i < 0) goto _L2; else goto _L3
_L3:
        if (!s.equals(((EbayNowDeliveryTimeSlot)timeSlotAdapter.getItem(i)).reservationToken)) goto _L5; else goto _L4
_L4:
        getListView().setSelection(i);
_L2:
        return;
_L5:
        i--;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void afterTextChanged(Editable editable)
    {
        ((DeliverySchedulingActivity)getActivity()).onDeliveryInstructionsChanged(editable.toString());
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!(activity instanceof DeliverySchedulingActivity))
        {
            throw new IllegalStateException("activity must be a DeliverySchedulingActivity");
        } else
        {
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        hasMultipleEbnItems = bundle.getBoolean("multiple_ebn_items");
        sellerName = bundle.getString("seller_name");
        bundle = (DeliveryDate)bundle.getParcelable("delivery_date");
        timeSlotAdapter = new TimeSlotAdapter((DeliverySchedulingActivity)getActivity(), bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0302bd, viewgroup, false);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        timeSlotAdapter.onClick(view, i - getListView().getHeaderViewsCount());
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        bundle = getListView();
        DeliverySchedulingActivity deliveryschedulingactivity;
        View view1;
        TextView textview;
        if (hasMultipleEbnItems)
        {
            view = getActivity().getLayoutInflater().inflate(0x7f0302c3, bundle, false);
            ((TextView)view.findViewById(0x7f10097a)).setText(String.format(getText(0x7f070c92).toString(), new Object[] {
                sellerName
            }));
            bundle.addHeaderView(view, null, false);
        } else
        {
            bundle.addHeaderView(getActivity().getLayoutInflater().inflate(0x7f0302c2, bundle, false), null, false);
        }
        deliveryschedulingactivity = (DeliverySchedulingActivity)getActivity();
        view1 = View.inflate(deliveryschedulingactivity, 0x7f0302bf, null);
        deliveryInstructions = (EditText)view1.findViewById(0x7f100976);
        deliveryInstructions.setText(deliveryschedulingactivity.getDeliveryInstructions());
        if (isVisible())
        {
            deliveryInstructions.addTextChangedListener(this);
        }
        view = DeviceConfiguration.getAsync();
        textview = (TextView)view1.findViewById(0x7f100977);
        view = view.get(DcsString.EbayNowTermsOfServiceUrl);
        if (view == null)
        {
            view = "";
        } else
        {
            view = String.format(view, new Object[] {
                MyApp.getPrefs().getCurrentCountry().getSiteLanguageCode()
            });
        }
        textview.setText(Html.fromHtml(getString(0x7f070086, new Object[] {
            view
        })));
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        bundle.addFooterView(view1);
        bundle.addFooterView(View.inflate(deliveryschedulingactivity, 0x7f03003b, null));
        bundle.setAdapter(timeSlotAdapter);
        bundle.setOnItemClickListener(this);
        view = deliveryschedulingactivity.getSelectedReservationToken();
        if (view != null)
        {
            setSelectedPositionByToken(view);
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
label0:
        {
            super.setUserVisibleHint(flag);
            if (deliveryInstructions != null)
            {
                if (!flag)
                {
                    break label0;
                }
                deliveryInstructions.addTextChangedListener(this);
                DeliverySchedulingActivity deliveryschedulingactivity = (DeliverySchedulingActivity)getActivity();
                deliveryInstructions.setText(deliveryschedulingactivity.getDeliveryInstructions());
            }
            return;
        }
        deliveryInstructions.removeTextChangedListener(this);
    }
}
