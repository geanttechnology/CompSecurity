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
import android.widget.RelativeLayout;
import com.google.gson.reflect.TypeToken;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.ListingsFilterUtils;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import com.poshmark.utils.meta_data.MySizePickerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PMFilterableFragment, MetaItemListViewFragment, MySizeFragment

public class MySizePickerFragment extends PMFragment
{
    static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE MY_SIZE;
        public static final MODE SEARCH_FILTER;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/ui/fragments/MySizePickerFragment$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            MY_SIZE = new MODE("MY_SIZE", 0);
            SEARCH_FILTER = new MODE("SEARCH_FILTER", 1);
            $VALUES = (new MODE[] {
                MY_SIZE, SEARCH_FILTER
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    boolean bIsMySizeSet;
    MySizePickerInfo info;
    boolean isG2FiltersEnabled;
    MODE mode;
    boolean mySizeSwitchChanged;
    PMTextView mySizeToggleButton;
    PMFilterableFragment parentFragment;
    RelativeLayout setCategoryButton;
    RelativeLayout setMySizeButton;
    android.view.View.OnClickListener sizeButtonListener;
    boolean sizeDataChanged;

    public MySizePickerFragment()
    {
        sizeDataChanged = false;
        mySizeSwitchChanged = false;
        mode = MODE.MY_SIZE;
        bIsMySizeSet = false;
        isG2FiltersEnabled = false;
        sizeButtonListener = new android.view.View.OnClickListener() {

            final MySizePickerFragment this$0;

            public void onClick(View view)
            {
                PMButton pmbutton = (PMButton)view;
                sizeDataChanged = true;
                view = (MetaItem)info.allItems.get(((Integer)view.getTag()).intValue());
                if (info.selectedItems.contains(view))
                {
                    info.selectedItems.remove(view);
                    pmbutton.setBackgroundColor(0);
                    pmbutton.setBackgroundDrawable(getResources().getDrawable(0x7f020014));
                    pmbutton.setTextColor(getResources().getColor(0x7f090035));
                    return;
                }
                if (info.selectedItems.size() == 4 && mode == MODE.MY_SIZE)
                {
                    showAlertMessage("", "You can select a maximum of 4 options. Please un select an existing option to select a new one");
                    return;
                } else
                {
                    pmbutton.setBackgroundDrawable(getResources().getDrawable(0x7f020015));
                    pmbutton.setTextColor(getResources().getColor(0x7f090040));
                    info.selectedItems.add(view);
                    return;
                }
            }

            
            {
                this$0 = MySizePickerFragment.this;
                super();
            }
        };
    }

    private boolean isMySizeSet()
    {
        UserStateSummary userstatesummary = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
        return userstatesummary != null && userstatesummary.user_info.isMySizeAvailable();
    }

    private void setupClickHandlers()
    {
        setCategoryButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MySizePickerFragment this$0;

            public void onClick(View view)
            {
                view = new MetaItemPickerInfo();
                Bundle bundle;
                if (info.categoryFacetList != null)
                {
                    view.allItems = info.categoryFacetList;
                } else
                {
                    view.allItems = DbApi.getAllCategories();
                }
                view.currentSelection = null;
                bundle = new Bundle();
                bundle.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.CATEGORY_MODE.ordinal());
                ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MetaItemListViewFragment, view, MySizePickerFragment.this, 4);
            }

            
            {
                this$0 = MySizePickerFragment.this;
                super();
            }
        });
        setMySizeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MySizePickerFragment this$0;

            public void onClick(View view)
            {
                ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/MySizeFragment, null);
            }

            
            {
                this$0 = MySizePickerFragment.this;
                super();
            }
        });
        mySizeToggleButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MySizePickerFragment this$0;

            public void onClick(View view)
            {
                if (!bIsMySizeSet)
                {
                    ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/MySizeFragment, null);
                    return;
                }
                mySizeSwitchChanged = true;
                if (info.bIsMySizeEnabled)
                {
                    info.bIsMySizeEnabled = false;
                    mySizeToggleButton.setTextColor(getResources().getColor(0x7f090035));
                    mySizeToggleButton.setTypeface(null, 0);
                    mySizeToggleButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    return;
                } else
                {
                    info.bIsMySizeEnabled = true;
                    mySizeToggleButton.setTextColor(getResources().getColor(0x7f09003c));
                    mySizeToggleButton.setTypeface(null, 1);
                    mySizeToggleButton.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f02007e), null);
                    return;
                }
            }

            
            {
                this$0 = MySizePickerFragment.this;
                super();
            }
        });
    }

    private void setupSizeGrid()
    {
        Object obj = (LinearLayout)getView().findViewById(0x7f0c015d);
        ((LinearLayout) (obj)).setVisibility(0);
        int j = 0;
        int i = 0;
        if (info.allItems != null)
        {
            j = info.allItems.size() / 3;
            i = info.allItems.size() % 3;
        }
        for (int k = 0; k < j; k++)
        {
            Object obj2 = LayoutInflater.from(getActivity()).inflate(0x7f030058, null);
            ((LinearLayout) (obj)).addView(((View) (obj2)));
            int l = k * 3;
            Object obj3 = (MetaItem)info.allItems.get(l);
            MetaItem metaitem3 = (MetaItem)info.allItems.get(l + 1);
            MetaItem metaitem2 = (MetaItem)info.allItems.get(l + 2);
            Button button2 = (Button)((View) (obj2)).findViewById(0x7f0c015f);
            button2.setText(((MetaItem) (obj3)).getFormattedDisplayStringBuilder());
            setupButton(button2, ((MetaItem) (obj3)), l);
            obj3 = (Button)((View) (obj2)).findViewById(0x7f0c0160);
            ((Button) (obj3)).setText(metaitem3.getFormattedDisplayStringBuilder());
            setupButton(((Button) (obj3)), metaitem3, l + 1);
            obj2 = (Button)((View) (obj2)).findViewById(0x7f0c0161);
            ((Button) (obj2)).setText(metaitem2.getFormattedDisplayStringBuilder());
            setupButton(((Button) (obj2)), metaitem2, l + 2);
        }

        if (i > 0)
        {
            Object obj1 = LayoutInflater.from(getActivity()).inflate(0x7f030058, null);
            ((LinearLayout) (obj)).addView(((View) (obj1)));
            j *= 3;
            obj = (MetaItem)info.allItems.get(j);
            Button button = (Button)((View) (obj1)).findViewById(0x7f0c015f);
            button.setText(((MetaItem) (obj)).getFormattedDisplayStringBuilder());
            setupButton(button, ((MetaItem) (obj)), j);
            if (i > 1)
            {
                MetaItem metaitem = (MetaItem)info.allItems.get(j + 1);
                Button button1 = (Button)((View) (obj1)).findViewById(0x7f0c0160);
                button1.setText(metaitem.getFormattedDisplayStringBuilder());
                setupButton(button1, metaitem, j + 1);
            }
            if (i > 2)
            {
                MetaItem metaitem1 = (MetaItem)info.allItems.get(j + 2);
                obj1 = (Button)((View) (obj1)).findViewById(0x7f0c0161);
                ((Button) (obj1)).setText(metaitem1.getFormattedDisplayStringBuilder());
                setupButton(((Button) (obj1)), metaitem1, j + 2);
            }
        }
    }

    public boolean isMetaItemInSelectedItemList(MetaItem metaitem)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (info.selectedItems == null)
            {
                break label0;
            }
            Iterator iterator = info.selectedItems.iterator();
            MetaItem metaitem1;
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                metaitem1 = (MetaItem)iterator.next();
            } while (metaitem1 == null || !metaitem1.getId().equals(metaitem.getId()));
            flag = true;
        }
        return flag;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (mode == MODE.SEARCH_FILTER)
        {
            bundle = getView();
            if (bundle != null)
            {
                bIsMySizeSet = isMySizeSet();
                mySizeToggleButton = (PMTextView)bundle.findViewById(0x7f0c02e5);
                setMySizeButton = (RelativeLayout)bundle.findViewById(0x7f0c02e6);
                setCategoryButton = (RelativeLayout)bundle.findViewById(0x7f0c02e8);
                setupClickHandlers();
                mySizeToggleButton.setVisibility(0);
                if (bIsMySizeSet)
                {
                    setMySizeButton.setVisibility(0);
                } else
                {
                    setMySizeButton.setVisibility(8);
                    info.bIsMySizeEnabled = false;
                }
                if (info.currentCategory == null)
                {
                    setCategoryButton.setVisibility(0);
                } else
                {
                    setupSizeGrid();
                }
                if (bIsMySizeSet && info.bIsMySizeEnabled)
                {
                    mySizeToggleButton.setTextColor(getResources().getColor(0x7f09003c));
                    mySizeToggleButton.setTypeface(null, 1);
                    mySizeToggleButton.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f02007e), null);
                }
            }
            return;
        } else
        {
            setupSizeGrid();
            return;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == 0) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 4 4: default 32
    //                   4 33;
           goto _L2 _L3
_L2:
        return;
_L3:
        Object obj = null;
        String s = intent.getBundleExtra("RETURNED_RESULTS").getString("DATA_SELECTED");
        intent = obj;
        if (s != null)
        {
            intent = (MetaItem)StringUtils.fromJson(s, com/poshmark/data_model/models/MetaItem);
        }
        if (intent != null)
        {
            info.currentCategory = intent;
            intent = DbApi.getSizesForCategory(info.currentCategory.getId());
            info.allItems = ListingsFilterUtils.getScrubbedList(intent, info.sizeFacetList);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isG2FiltersEnabled = FeatureManager.getGlobalFeatureManager().isFilterBarv2FeatureEnabled();
        mode = MODE.values()[getArguments().getInt("MODE")];
        info = (MySizePickerInfo)getFragmentDataOfType(com/poshmark/utils/meta_data/MySizePickerInfo);
        parentFragment = (PMFilterableFragment)getFragmentDataOfType(com/poshmark/ui/fragments/PMFilterableFragment);
        if (info == null)
        {
            info = new MySizePickerInfo();
            info.allItems = parentFragment.getFacetList(MetaItemListViewFragment.META_ITEM_MODES.SIZE_MODE);
            if (info.allItems == null)
            {
                info.allItems = new ArrayList();
            }
            info.selectedItems = new ArrayList();
            info.selectedItems.addAll(parentFragment.getFilterManager().getCurrentSizeSelections());
            info.categoryFacetList = parentFragment.getFacetList(MetaItemListViewFragment.META_ITEM_MODES.CATEGORY_MODE);
            info.sizeFacetList = parentFragment.getUnscrubbedFacetList(MetaItemListViewFragment.META_ITEM_MODES.SIZE_MODE);
            info.bIsMySizeEnabled = parentFragment.getFilterManager().isMySizeEnabled();
            info.currentCategory = parentFragment.getCurrentMetaItemSelection(MetaItemListViewFragment.META_ITEM_MODES.CATEGORY_MODE);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300c0, viewgroup, false);
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        i;
        JVM INSTR tableswitch 4 4: default 20
    //                   4 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        Object obj = null;
        String s = bundle.getString("DATA_SELECTED");
        bundle = obj;
        if (s != null)
        {
            bundle = (MetaItem)StringUtils.fromJson(s, com/poshmark/data_model/models/MetaItem);
        }
        if (bundle != null)
        {
            info.currentCategory = bundle;
            bundle = DbApi.getSizesForCategory(info.currentCategory.getId());
            info.allItems = ListingsFilterUtils.getScrubbedList(bundle, info.sizeFacetList);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean returnData()
    {
        Object obj = new Intent();
        Bundle bundle = new Bundle();
        PMFragment pmfragment;
        if (sizeDataChanged)
        {
            bundle.putBoolean("SIZE_CHANGED", true);
            java.lang.reflect.Type type = (new TypeToken() {

                final MySizePickerFragment this$0;

            
            {
                this$0 = MySizePickerFragment.this;
                super();
            }
            }).getType();
            bundle.putString("SIZE_LIST", StringUtils.toJson(info.selectedItems, type));
        } else
        {
            bundle.putBoolean("SIZE_CHANGED", false);
        }
        bundle.putBoolean("MYSIZE_SWITCH_STATE", info.bIsMySizeEnabled);
        if (info.currentCategory != null)
        {
            bundle.putString("DATA_SELECTED", StringUtils.toJson(info.currentCategory));
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
        if (mode == MODE.SEARCH_FILTER)
        {
            viewNameForAnalytics = "listing_select_size_filter_screen";
            return;
        } else
        {
            viewNameForAnalytics = "multi_selector_screen";
            return;
        }
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

            final MySizePickerFragment this$0;

            public void onClick(View view)
            {
                returnData();
            }

            
            {
                this$0 = MySizePickerFragment.this;
                super();
            }
        });
        setTitle("Select Size");
    }

    public void setupButton(Button button, MetaItem metaitem, int i)
    {
        button.setVisibility(0);
        if (isMetaItemInSelectedItemList(metaitem))
        {
            button.setBackgroundDrawable(getResources().getDrawable(0x7f020015));
            button.setTextColor(getResources().getColor(0x7f090040));
        }
        button.setTag(Integer.valueOf(i));
        button.setOnClickListener(sizeButtonListener);
    }
}
