// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            BaseListFragment

public class HeaderViewListFragment extends BaseListFragment
{

    public HeaderViewListFragment()
    {
    }

    protected View[] onCreateFooterViews(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return null;
    }

    protected View[] onCreateHeaderViews(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return null;
    }

    protected View onCreateMainContentView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view1 = onCreateMainContentView(layoutinflater, viewgroup, bundle);
        View aview[] = onCreateHeaderViews(layoutinflater, viewgroup, bundle);
        View aview1[] = onCreateFooterViews(layoutinflater, viewgroup, bundle);
        bundle = aview;
        if (aview != null)
        {
            bundle = aview;
            if (aview.length == 0)
            {
                bundle = null;
            }
        }
        viewgroup = aview1;
        if (aview1 != null)
        {
            viewgroup = aview1;
            if (aview1.length == 0)
            {
                viewgroup = null;
            }
        }
        layoutinflater = layoutinflater.getContext();
        setListMargins(layoutinflater, (android.view.ViewGroup.MarginLayoutParams)view1.findViewById(0x102000a).getLayoutParams());
        if (bundle == null && viewgroup == null)
        {
            return view1;
        }
        LinearLayout linearlayout = new LinearLayout(layoutinflater);
        linearlayout.setOrientation(1);
        if (bundle != null)
        {
            int k = bundle.length;
            for (int i = 0; i < k; i++)
            {
                View view2 = bundle[i];
                android.view.ViewGroup.LayoutParams layoutparams = view2.getLayoutParams();
                layoutinflater = layoutparams;
                if (layoutparams == null)
                {
                    layoutinflater = new android.widget.LinearLayout.LayoutParams(-1, -2);
                }
                linearlayout.addView(view2, layoutinflater);
            }

        }
        linearlayout.addView(view1, new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F));
        if (viewgroup != null)
        {
            int l = viewgroup.length;
            for (int j = 0; j < l; j++)
            {
                View view = viewgroup[j];
                bundle = view.getLayoutParams();
                layoutinflater = bundle;
                if (bundle == null)
                {
                    layoutinflater = new android.widget.LinearLayout.LayoutParams(-1, -2);
                }
                linearlayout.addView(view, layoutinflater);
            }

        }
        linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        return linearlayout;
    }

    protected void setListMargins(Context context, android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
    }
}
