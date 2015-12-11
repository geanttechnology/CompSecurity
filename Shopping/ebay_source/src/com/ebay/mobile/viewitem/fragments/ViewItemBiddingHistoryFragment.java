// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.AllBiddersData;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewBiddingActivity;
import com.ebay.mobile.viewitem.ViewItemViewData;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment, ViewItemSpecificsFragment

public class ViewItemBiddingHistoryFragment extends ViewItemBaseFragment
    implements android.view.View.OnClickListener
{

    private View bidCountLayout;
    private TextView bidCountTextView;
    private TextView biddersCountTextView;
    private View biddersLayout;
    private TextView containerHeaderTextView;
    private ViewGroup timeLeftLayout;

    public ViewItemBiddingHistoryFragment()
    {
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131756220 2131756220: default 24
    //                   2131756220 30;
           goto _L1 _L2
_L1:
        super.onClick(view);
_L4:
        return;
_L2:
        if (!(getActivity() instanceof ItemViewActivity))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = (ItemViewActivity)getActivity();
        if (item.bidCount > 0 && !MyApp.getPrefs().isSignedIn())
        {
            viewData.waitForBidding = true;
        }
        if (item.bidCount <= 0 || view.needSignIn(com.ebay.mobile.viewitem.ItemViewActivity.UserAction.BIDDING_ACTIVITY)) goto _L4; else goto _L3
_L3:
        seeAllClicked();
        return;
        if (!MyApp.getPrefs().isSignedIn() || item.bidCount <= 0) goto _L4; else goto _L5
_L5:
        seeAllClicked();
        return;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f030282, viewgroup, false);
        bidCountTextView = (TextView)view.findViewById(0x7f100895);
        biddersCountTextView = (TextView)view.findViewById(0x7f100897);
        containerHeaderTextView = (TextView)view.findViewById(0x7f100892);
        bidCountLayout = view.findViewById(0x7f100894);
        timeLeftLayout = (ViewGroup)view.findViewById(0x7f100893);
        biddersLayout = view.findViewById(0x7f100896);
        setupFragment(view);
        return view;
    }

    protected void render(Item item, ViewItemViewData viewitemviewdata, ViewItemBaseFragment.ExpandState expandstate)
    {
        boolean flag;
        flag = false;
        super.render(item, viewitemviewdata, expandstate);
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState = new int[ViewItemBaseFragment.ExpandState.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$fragments$ViewItemBaseFragment$ExpandState[ViewItemBaseFragment.ExpandState.COLLAPSED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        _cls1..SwitchMap.com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ExpandState[expandstate.ordinal()];
        JVM INSTR tableswitch 1 1: default 36
    //                   1 197;
           goto _L1 _L2
_L1:
        bidCountTextView.setText(String.valueOf(item.bidCount));
        boolean flag1 = MyApp.getPrefs().isSignedIn();
        int i;
        if (item.bidCount > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag1)
        {
            int j;
            if (item.allBidders != null)
            {
                j = item.allBidders.countBidders();
            } else
            {
                j = 0;
            }
            biddersCountTextView.setText(String.valueOf(j));
            biddersLayout.setVisibility(0);
        } else
        {
            biddersLayout.setVisibility(8);
        }
        containerHeaderTextView.setVisibility(0);
        bidCountLayout.setVisibility(0);
        viewitemviewdata = view.findViewById(0x7f1004bc);
        if (i != 0)
        {
            item = this;
        } else
        {
            item = null;
        }
        viewitemviewdata.setOnClickListener(item);
        item = view.findViewById(0x7f1004bc);
        if (i != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        item.setEnabled(flag1);
        setSeeAllVisibility(false);
        item = chevronIcon;
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        item.setVisibility(i);
        return;
_L2:
        timeLeftLayout.removeAllViews();
        if (!item.isHideTimeLeft)
        {
            ViewItemSpecificsFragment.setupEndTime(timeLeftLayout, item, getActivity(), inflater);
            if (timeLeftLayout.getChildCount() > 0)
            {
                viewitemviewdata = timeLeftLayout.getChildAt(0);
                i = getResources().getDimensionPixelSize(0x7f090141);
                viewitemviewdata.setPadding(i, i, i, i);
            }
            timeLeftLayout.setVisibility(0);
        } else
        {
            timeLeftLayout.setVisibility(8);
        }
          goto _L1
    }

    protected void seeAllClicked()
    {
        ItemViewBiddingActivity.StartActivity(getActivity(), viewData, item.thumbnailImage);
    }
}
