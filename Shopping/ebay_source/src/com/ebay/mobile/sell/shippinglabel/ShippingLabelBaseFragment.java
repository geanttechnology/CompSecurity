// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelActivity

public class ShippingLabelBaseFragment extends BaseFragment
{

    protected Toolbar toolbar;

    public ShippingLabelBaseFragment()
    {
    }

    public void hideDoneButton()
    {
        toolbar.findViewById(0x7f1003aa).setVisibility(8);
        toolbar.findViewById(0x7f1003a5).setVisibility(0);
        toolbar.findViewById(0x7f1003ab).setVisibility(0);
    }

    public boolean isHomeUp()
    {
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (((ShippingLabelActivity)getActivity()).shippingLabelDraftDataManager != null && !((ShippingLabelActivity)getActivity()).shippingLabelDraftDataManager.isLoading())
        {
            updateUI();
            return;
        } else
        {
            getView().setVisibility(8);
            ((ShippingLabelActivity)getActivity()).showProgress();
            return;
        }
    }

    public boolean onBackPressed()
    {
        sendUpdates();
        if (getFragmentManager() != null)
        {
            getFragmentManager().popBackStack();
        }
        return true;
    }

    public void onResume()
    {
        super.onResume();
        toolbar = (Toolbar)((ShippingLabelActivity)getActivity()).toolbar;
        setActionBarState();
        if (((ShippingLabelActivity)getActivity()).shippingLabelDraft != null && !((ShippingLabelActivity)getActivity()).shippingLabelDraftDataManager.isLoading())
        {
            updateUI();
            return;
        } else
        {
            getView().setVisibility(8);
            ((ShippingLabelActivity)getActivity()).showProgress();
            return;
        }
    }

    public void sendUpdates()
    {
    }

    public void setActionBarState()
    {
        showDoneButton(new android.view.View.OnClickListener() {

            final ShippingLabelBaseFragment this$0;

            public void onClick(View view)
            {
                onBackPressed();
            }

            
            {
                this$0 = ShippingLabelBaseFragment.this;
                super();
            }
        });
    }

    public void setToolbarTitle(int i)
    {
        ((TextView)toolbar.findViewById(0x7f1003a5)).setText(i);
    }

    public void showDoneButton(android.view.View.OnClickListener onclicklistener)
    {
        View view = toolbar.findViewById(0x7f1003aa);
        view.setVisibility(0);
        view.setOnClickListener(onclicklistener);
        toolbar.findViewById(0x7f1003ab).setVisibility(8);
    }

    public void updateUI()
    {
    }
}
