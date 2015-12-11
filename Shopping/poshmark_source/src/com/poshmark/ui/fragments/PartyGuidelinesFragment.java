// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.inner_models.Theme;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.ViewUtils;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class PartyGuidelinesFragment extends PMFragment
{

    private PartyEvent event;

    public PartyGuidelinesFragment()
    {
    }

    private void setupView(View view)
    {
        ((PMTextView)view.findViewById(0x7f0c0236)).setText((new StringBuilder()).append(getString(0x7f06029b)).append(event.getTitle()).toString());
        Object obj = event.getTheme();
        LinearLayout linearlayout1 = (LinearLayout)view.findViewById(0x7f0c0239);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f0c023b);
        Object obj1 = (LinearLayout)view.findViewById(0x7f0c0187);
        if (obj == null)
        {
            linearlayout1.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
            int i = (int)ViewUtils.dipToPixels(getActivity(), 10F);
            linearlayout1.setPadding(i, i, i, i);
            view = (android.widget.LinearLayout.LayoutParams)linearlayout1.getLayoutParams();
            view.setMargins(0, 0, 0, 0);
            linearlayout1.setLayoutParams(view);
            linearlayout.setVisibility(8);
            ((LinearLayout) (obj1)).setVisibility(8);
        } else
        {
            ((PMTextView)view.findViewById(0x7f0c0238)).setText(((Theme) (obj)).getCommaSeparatedBrands(getActivity()));
            ((PMTextView)view.findViewById(0x7f0c023a)).setText(((Theme) (obj)).getCommaSeparatedCategories(getActivity()));
            int j = 1;
            boolean flag;
            if (((Theme) (obj)).getSizes().size() > 0)
            {
                j = 0;
                ((PMTextView)view.findViewById(0x7f0c023c)).setText(((Theme) (obj)).getCommaSeparatedSizes(getActivity()));
            } else
            {
                linearlayout.setVisibility(8);
            }
            flag = true;
            if (((Theme) (obj)).getMaxPrice() >= 0.0F || ((Theme) (obj)).getMinPrice() >= 0.0F)
            {
                boolean flag1 = false;
                boolean flag2 = false;
                obj1 = CurrencyUtils.getCurrencySymbol();
                view = (PMTextView)view.findViewById(0x7f0c023d);
                if (((Theme) (obj)).getMaxPrice() >= 0.0F && ((Theme) (obj)).getMinPrice() >= 0.0F)
                {
                    String s = (new StringBuilder()).append(((String) (obj1))).append(Integer.toString((int)((Theme) (obj)).getMinPrice())).toString();
                    obj = (new StringBuilder()).append(((String) (obj1))).append(Integer.toString((int)((Theme) (obj)).getMaxPrice())).toString();
                    view.setText((new StringBuilder()).append(s).append(" - ").append(((String) (obj))).toString());
                    flag = flag2;
                    j = ((flag1) ? 1 : 0);
                } else
                if (((Theme) (obj)).getMaxPrice() >= 0.0F)
                {
                    obj = (new StringBuilder()).append(((String) (obj1))).append(Integer.toString((int)((Theme) (obj)).getMaxPrice())).toString();
                    view.setText((new StringBuilder()).append(getString(0x7f060051)).append(" ").append(((String) (obj))).toString());
                    j = ((flag1) ? 1 : 0);
                    flag = flag2;
                } else
                {
                    j = ((flag1) ? 1 : 0);
                    flag = flag2;
                    if (((Theme) (obj)).getMinPrice() >= 0.0F)
                    {
                        obj = (new StringBuilder()).append(((String) (obj1))).append(Integer.toString((int)((Theme) (obj)).getMinPrice())).toString();
                        view.setText((new StringBuilder()).append(getString(0x7f06002d)).append(" ").append(((String) (obj))).toString());
                        j = ((flag1) ? 1 : 0);
                        flag = flag2;
                    }
                }
            } else
            {
                ((LinearLayout) (obj1)).setVisibility(8);
            }
            if (j != 0)
            {
                linearlayout1.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
                j = (int)ViewUtils.dipToPixels(getActivity(), 10F);
                linearlayout1.setPadding(j, j, j, j);
                view = (android.widget.LinearLayout.LayoutParams)linearlayout1.getLayoutParams();
                view.setMargins(0, 0, 0, 0);
                linearlayout1.setLayoutParams(view);
            }
            if (flag)
            {
                linearlayout.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
                j = (int)ViewUtils.dipToPixels(getActivity(), 10F);
                linearlayout.setPadding(j, j, j, j);
                view = (android.widget.LinearLayout.LayoutParams)linearlayout.getLayoutParams();
                view.setMargins(0, 0, 0, 0);
                linearlayout.setLayoutParams(view);
                return;
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((Bundle) (getFragmentDataOfType(com/poshmark/data_model/models/PartyEvent)));
        if (bundle != null)
        {
            event = (PartyEvent)bundle;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030095, viewgroup, false);
        setupView(layoutinflater);
        return layoutinflater;
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "party_theme_screen";
    }
}
