// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.nautilus.shell.app.FwLoaderManager;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity

public class VoidLabelFragment extends ShippingLabelBaseFragment
{
    public class VoidLabelAdapter extends ArrayAdapter
    {

        protected final LayoutInflater inflater;
        final VoidLabelFragment this$0;

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            TextView textview = (TextView)view;
            view = textview;
            if (textview == null)
            {
                view = (TextView)inflater.inflate(0x1090009, viewgroup, false);
            }
            view.setText(((ShippingLabelActivity.VoidLabelReasons)getItem(i)).getDisplayStringResourceId());
            return view;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            TextView textview = (TextView)view;
            view = textview;
            if (textview == null)
            {
                view = (TextView)inflater.inflate(0x7f030223, viewgroup, false);
            }
            view.setText(((ShippingLabelActivity.VoidLabelReasons)getItem(i)).getDisplayStringResourceId());
            return view;
        }

        public VoidLabelAdapter(Context context)
        {
            this$0 = VoidLabelFragment.this;
            super(context, 0, ShippingLabelActivity.VoidLabelReasons.values());
            inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }


    public static final String VOID_BACKSTACK = "voidFragment";

    public VoidLabelFragment()
    {
    }

    public boolean isHomeUp()
    {
        return true;
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup voidLabelReasons, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030240, voidLabelReasons, false);
        voidLabelReasons = (Spinner)layoutinflater.findViewById(0x7f1007b1);
        voidLabelReasons.setAdapter(new VoidLabelAdapter(layoutinflater.getContext()));
        layoutinflater.findViewById(0x7f100770).setOnClickListener(new android.view.View.OnClickListener() {

            final VoidLabelFragment this$0;
            final Spinner val$voidLabelReasons;

            public void onClick(View view)
            {
                ((ShippingLabelActivity)getActivity()).cancelLabel((ShippingLabelActivity.VoidLabelReasons)voidLabelReasons.getSelectedItem());
                getView().setVisibility(8);
            }

            
            {
                this$0 = VoidLabelFragment.this;
                voidLabelReasons = spinner;
                super();
            }
        });
        return layoutinflater;
    }

    public void setActionBarState()
    {
        hideDoneButton();
        setToolbarTitle(0x7f07087f);
    }

    public void updateUI()
    {
        if (getFwLoaderManager().getRunningLoader(2) == null)
        {
            ((ShippingLabelActivity)getActivity()).hideProgress();
            getView().setVisibility(0);
            return;
        } else
        {
            ((ShippingLabelActivity)getActivity()).showProgress();
            getView().setVisibility(8);
            return;
        }
    }
}
