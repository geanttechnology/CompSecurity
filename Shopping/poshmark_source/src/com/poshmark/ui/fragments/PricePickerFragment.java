// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.gson.reflect.TypeToken;
import com.poshmark.data_model.models.PriceInfo;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.PricePickerInfo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PMFilterableFragment

public class PricePickerFragment extends PMFragment
{

    boolean dataChanged;
    PricePickerInfo info;
    boolean isG2FiltersEnabled;
    PMFilterableFragment parentFragment;
    android.view.View.OnClickListener sizeButtonListener;

    public PricePickerFragment()
    {
        dataChanged = false;
        isG2FiltersEnabled = false;
        sizeButtonListener = new android.view.View.OnClickListener() {

            final PricePickerFragment this$0;

            public void onClick(View view)
            {
                dataChanged = true;
                PriceInfo priceinfo = (PriceInfo)info.allItems.get(((Integer)view.getTag()).intValue());
                view = (PMButton)view;
                if (info.selectedItems.contains(priceinfo))
                {
                    info.selectedItems.remove(priceinfo);
                    view.setBackgroundColor(0);
                    view.setBackgroundDrawable(getResources().getDrawable(0x7f020014));
                    view.setTextColor(getResources().getColor(0x7f090035));
                    return;
                } else
                {
                    view.setBackgroundDrawable(getResources().getDrawable(0x7f020015));
                    view.setTextColor(getResources().getColor(0x7f090040));
                    info.selectedItems.add(priceinfo);
                    return;
                }
            }

            
            {
                this$0 = PricePickerFragment.this;
                super();
            }
        };
    }

    private void setupSizeGrid()
    {
        Object obj = (LinearLayout)getView().findViewById(0x7f0c015d);
        int l = info.allItems.size() / 3;
        int k = info.allItems.size() % 3;
        for (int i = 0; i < l; i++)
        {
            Object obj2 = LayoutInflater.from(getActivity()).inflate(0x7f030058, null);
            ((LinearLayout) (obj)).addView(((View) (obj2)));
            int i1 = i * 3;
            Object obj3 = (PriceInfo)info.allItems.get(i1);
            PriceInfo priceinfo3 = (PriceInfo)info.allItems.get(i1 + 1);
            PriceInfo priceinfo2 = (PriceInfo)info.allItems.get(i1 + 2);
            Button button2 = (Button)((View) (obj2)).findViewById(0x7f0c015f);
            button2.setText(((PriceInfo) (obj3)).getDisplay());
            setupButton(button2, ((PriceInfo) (obj3)), i1);
            obj3 = (Button)((View) (obj2)).findViewById(0x7f0c0160);
            ((Button) (obj3)).setText(priceinfo3.getDisplay());
            setupButton(((Button) (obj3)), priceinfo3, i1 + 1);
            obj2 = (Button)((View) (obj2)).findViewById(0x7f0c0161);
            ((Button) (obj2)).setText(priceinfo2.getDisplay());
            setupButton(((Button) (obj2)), priceinfo2, i1 + 2);
        }

        if (k > 0)
        {
            Object obj1 = LayoutInflater.from(getActivity()).inflate(0x7f030058, null);
            ((LinearLayout) (obj)).addView(((View) (obj1)));
            int j = l * 3;
            obj = (PriceInfo)info.allItems.get(j);
            Button button = (Button)((View) (obj1)).findViewById(0x7f0c015f);
            button.setText(((PriceInfo) (obj)).getDisplay());
            setupButton(button, ((PriceInfo) (obj)), j);
            if (k > 1)
            {
                PriceInfo priceinfo = (PriceInfo)info.allItems.get(j + 1);
                Button button1 = (Button)((View) (obj1)).findViewById(0x7f0c0160);
                button1.setText(priceinfo.getDisplay());
                setupButton(button1, priceinfo, j + 1);
            }
            if (k > 2)
            {
                PriceInfo priceinfo1 = (PriceInfo)info.allItems.get(j + 2);
                obj1 = (Button)((View) (obj1)).findViewById(0x7f0c0161);
                ((Button) (obj1)).setText(priceinfo1.getDisplay());
                setupButton(((Button) (obj1)), priceinfo1, j + 2);
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupSizeGrid();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isG2FiltersEnabled = FeatureManager.getGlobalFeatureManager().isFilterBarv2FeatureEnabled();
        info = (PricePickerInfo)getFragmentDataOfType(com/poshmark/utils/meta_data/PricePickerInfo);
        parentFragment = (PMFilterableFragment)getFragmentDataOfType(com/poshmark/ui/fragments/PMFilterableFragment);
        if (info == null)
        {
            info = new PricePickerInfo();
            info.allItems = parentFragment.getPriceList();
            info.selectedItems = new ArrayList();
            info.selectedItems.addAll(parentFragment.getFilterManager().getCurrentPriceSelections());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030057, viewgroup, false);
    }

    public boolean returnData()
    {
        Object obj = new Intent();
        Bundle bundle = new Bundle();
        PMFragment pmfragment;
        if (dataChanged)
        {
            bundle.putBoolean("PRICE_CHANGED", true);
            java.lang.reflect.Type type = (new TypeToken() {

                final PricePickerFragment this$0;

            
            {
                this$0 = PricePickerFragment.this;
                super();
            }
            }).getType();
            bundle.putString("PRICE_LIST", StringUtils.toJson(info.selectedItems, type));
        } else
        {
            bundle.putBoolean("PRICE_CHANGED", false);
        }
        pmfragment = (PMFragment)getTargetFragment();
        if (pmfragment != null)
        {
            ((Intent) (obj)).putExtra("RETURNED_RESULTS", bundle);
            pmfragment.onActivityResult(getTargetRequestCode(), -1, ((Intent) (obj)));
            obj = getActivity();
            if (obj != null)
            {
                ((Activity) (obj)).onBackPressed();
            }
            return false;
        } else
        {
            ((Intent) (obj)).putExtras(bundle);
            finishActivityWithResult(-1, ((Intent) (obj)));
            return false;
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "listing_select_price_filter_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        String s;
        if (isG2FiltersEnabled)
        {
            s = getString(0x7f06004a);
        } else
        {
            s = getString(0x7f0600bf);
        }
        setNextActionButton(s, new android.view.View.OnClickListener() {

            final PricePickerFragment this$0;

            public void onClick(View view)
            {
                returnData();
            }

            
            {
                this$0 = PricePickerFragment.this;
                super();
            }
        });
        setTitle(0x7f060219);
    }

    public void setupButton(Button button, PriceInfo priceinfo, int i)
    {
        button.setVisibility(0);
        if (info.selectedItems.contains(priceinfo))
        {
            button.setBackgroundDrawable(getResources().getDrawable(0x7f020015));
            button.setTextColor(getResources().getColor(0x7f090040));
        }
        button.setTag(Integer.valueOf(i));
        button.setOnClickListener(sizeButtonListener);
    }
}
