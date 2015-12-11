// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.adapters.MetaItemListAdapter;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PMFilterableFragment, MappPageFragment

public class MetaItemListViewFragment extends PMFragment
{
    public static final class META_ITEM_MODES extends Enum
    {

        private static final META_ITEM_MODES $VALUES[];
        public static final META_ITEM_MODES AVAILABILITY_MODE;
        public static final META_ITEM_MODES BRAND_MODE;
        public static final META_ITEM_MODES CATEGORY_MODE;
        public static final META_ITEM_MODES CONDITION_MODE;
        public static final META_ITEM_MODES NWT_MODE;
        public static final META_ITEM_MODES PRICE_MODE;
        public static final META_ITEM_MODES SIZE_MODE;
        public static final META_ITEM_MODES STYLE_TAGS;

        public static META_ITEM_MODES valueOf(String s)
        {
            return (META_ITEM_MODES)Enum.valueOf(com/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES, s);
        }

        public static META_ITEM_MODES[] values()
        {
            return (META_ITEM_MODES[])$VALUES.clone();
        }

        static 
        {
            CATEGORY_MODE = new META_ITEM_MODES("CATEGORY_MODE", 0);
            SIZE_MODE = new META_ITEM_MODES("SIZE_MODE", 1);
            BRAND_MODE = new META_ITEM_MODES("BRAND_MODE", 2);
            CONDITION_MODE = new META_ITEM_MODES("CONDITION_MODE", 3);
            AVAILABILITY_MODE = new META_ITEM_MODES("AVAILABILITY_MODE", 4);
            PRICE_MODE = new META_ITEM_MODES("PRICE_MODE", 5);
            NWT_MODE = new META_ITEM_MODES("NWT_MODE", 6);
            STYLE_TAGS = new META_ITEM_MODES("STYLE_TAGS", 7);
            $VALUES = (new META_ITEM_MODES[] {
                CATEGORY_MODE, SIZE_MODE, BRAND_MODE, CONDITION_MODE, AVAILABILITY_MODE, PRICE_MODE, NWT_MODE, STYLE_TAGS
            });
        }

        private META_ITEM_MODES(String s, int i)
        {
            super(s, i);
        }
    }


    MetaItemListAdapter adapter;
    boolean allowCustomCustomString;
    boolean allowMultiSelect;
    boolean backoutFlag;
    boolean clearAllRowEnabled;
    PMTextView clearAllTextBox;
    boolean customOptionEnabled;
    boolean dataReturned;
    MetaItemPickerInfo initInfo;
    ListView listView;
    MetaItem metaItem;
    META_ITEM_MODES metaItemMode;
    ArrayList multiSelectList;
    PMFilterableFragment parentFragment;
    EditText searchBox;
    boolean searchEnabled;
    boolean showBrandFollowButton;

    public MetaItemListViewFragment()
    {
        backoutFlag = false;
        clearAllRowEnabled = false;
        dataReturned = false;
        multiSelectList = new ArrayList();
    }

    private List getMetaItemListFromFilter()
    {
        return parentFragment.getFacetList(metaItemMode);
    }

    private void launchUrl(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com").append(s).toString());
        bundle.putString("ANALYTICS_PAGE_NAME", s1);
        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    private void removeCheckMark(View view)
    {
        ((ImageView)view.findViewById(0x7f0c0097)).setVisibility(8);
    }

    private void setTitleFromMode()
    {
        static class _cls5
        {

            static final int $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[];

            static 
            {
                $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES = new int[META_ITEM_MODES.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[META_ITEM_MODES.CATEGORY_MODE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[META_ITEM_MODES.SIZE_MODE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[META_ITEM_MODES.BRAND_MODE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[META_ITEM_MODES.CONDITION_MODE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[META_ITEM_MODES.NWT_MODE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[META_ITEM_MODES.AVAILABILITY_MODE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[META_ITEM_MODES.STYLE_TAGS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5..SwitchMap.com.poshmark.ui.fragments.MetaItemListViewFragment.META_ITEM_MODES[metaItemMode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            setTitle(0x7f060073);
            return;

        case 2: // '\002'
            if (customOptionEnabled)
            {
                setTitle(0x7f060243);
                return;
            } else
            {
                setTitle(0x7f060282);
                return;
            }

        case 3: // '\003'
            setTitle(0x7f060061);
            return;

        case 4: // '\004'
            setTitle(0x7f060091);
            return;

        case 5: // '\005'
            setTitle(0x7f06026b);
            return;

        case 6: // '\006'
            setTitle(0x7f06004e);
            return;

        case 7: // '\007'
            setTitle(0x7f06028d);
            return;
        }
    }

    private void setupAdapter()
    {
        if (parentFragment != null)
        {
            initInfo = new MetaItemPickerInfo();
            initInfo.allItems = getMetaItemListFromFilter();
            if (initInfo.allItems == null)
            {
                initInfo.allItems = new ArrayList();
            }
            initInfo.currentSelection = parentFragment.getCurrentMetaItemSelection(metaItemMode);
        }
        adapter = new MetaItemListAdapter(getActivity(), 0x7f03008a, initInfo, searchEnabled, customOptionEnabled, allowCustomCustomString, showBrandFollowButton);
    }

    private void setupFooterView()
    {
        if (metaItemMode == META_ITEM_MODES.CONDITION_MODE)
        {
            int i = (int)ViewUtils.dipToPixels(getActivity(), 10F);
            PMTextView pmtextview = new PMTextView(getActivity(), null);
            pmtextview.setPadding(i, i, i, i);
            pmtextview.setGravity(17);
            pmtextview.setTextSize(2, 15F);
            pmtextview.setTextColor(getResources().getColor(0x7f090039));
            pmtextview.setLinkTextColor(getResources().getColor(0x7f090039));
            pmtextview.setText(getString(0x7f060212));
            listView.addFooterView(pmtextview);
            pmtextview = new PMTextView(getActivity(), null);
            pmtextview.setPadding(i, i, i, i);
            pmtextview.setGravity(17);
            pmtextview.setTextSize(2, 15F);
            pmtextview.setTextColor(getResources().getColor(0x7f090039));
            pmtextview.setLinkTextColor(getResources().getColor(0x7f090039));
            pmtextview.setText(getString(0x7f060214));
            listView.addFooterView(pmtextview);
        }
    }

    private void setupListItemClickListener()
    {
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final MetaItemListViewFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                int j = i;
                if (listView.getHeaderViewsCount() <= 0) goto _L2; else goto _L1
_L1:
                if (i != 0) goto _L4; else goto _L3
_L3:
                returnData();
_L6:
                return;
_L4:
                j = i - 1;
_L2:
                if (searchBox != null && searchBox.getText().toString().length() > 0)
                {
                    if (j == 0)
                    {
                        metaItem = new MetaItem(searchBox.getText().toString(), searchBox.getText().toString());
                        hideKeyboard();
                        returnData();
                        return;
                    } else
                    {
                        i = ((Integer)view.getTag()).intValue();
                        metaItem = (MetaItem)initInfo.allItems.get(i);
                        hideKeyboard();
                        returnData();
                        return;
                    }
                }
                if (j < initInfo.allItems.size())
                {
                    i = ((Integer)view.getTag()).intValue();
                    metaItem = (MetaItem)initInfo.allItems.get(i);
                    if (allowMultiSelect)
                    {
                        if (multiSelectList.contains(metaItem))
                        {
                            multiSelectList.remove(metaItem);
                            removeCheckMark(view);
                            return;
                        } else
                        {
                            multiSelectList.add(metaItem);
                            showCheckMark(view);
                            return;
                        }
                    } else
                    {
                        returnData();
                        return;
                    }
                }
                if (listView.getFooterViewsCount() == 0)
                {
                    adapterview = new android.app.AlertDialog.Builder(getActivity());
                    adapterview.setTitle(getString(0x7f060032));
                    adapterview.setMessage("");
                    view = new EditText(getActivity());
                    adapterview.setView(view);
                    adapterview.setPositiveButton(getString(0x7f0601e1), view. new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;
                        final EditText val$input;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            metaItem = new MetaItem(input.getText().toString(), input.getText().toString());
                            dialoginterface.dismiss();
                            hideKeyboard();
                            returnData();
                        }

            
            {
                this$1 = final__pcls2;
                input = EditText.this;
                super();
            }
                    });
                    adapterview.setNegativeButton(getString(0x7f06006d), new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            hideKeyboard();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    adapterview.show();
                    showKeyboard();
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = MetaItemListViewFragment.this;
                super();
            }
        });
    }

    private void setupSearchListener()
    {
        if (searchBox == null)
        {
            return;
        } else
        {
            searchBox.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                final MetaItemListViewFragment this$0;

                public void onFocusChange(View view, boolean flag)
                {
                    if (flag && showBrandFollowButton)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_searched", null);
                    }
                }

            
            {
                this$0 = MetaItemListViewFragment.this;
                super();
            }
            });
            searchBox.addTextChangedListener(new TextWatcher() {

                final MetaItemListViewFragment this$0;

                public void afterTextChanged(Editable editable)
                {
                    adapter.getFilter().filter(editable);
                    searchBox.requestFocus();
                }

                public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                }

                public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                }

            
            {
                this$0 = MetaItemListViewFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void showCheckMark(View view)
    {
        ((ImageView)view.findViewById(0x7f0c0097)).setVisibility(0);
    }

    public boolean handleBack()
    {
        if (!dataReturned)
        {
            dataReturned = true;
            PMFragment pmfragment = (PMFragment)getTargetFragment();
            if (pmfragment != null)
            {
                pmfragment.onActivityResult(getTargetRequestCode(), 0, null);
            }
        }
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            listView = (ListView)getView().findViewById(0x7f0c0205);
            setupHeaderView();
            setupFooterView();
            listView.setAdapter(adapter);
            setupListItemClickListener();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            metaItemMode = META_ITEM_MODES.values()[getArguments().getInt("META_ITEM_MODE")];
            customOptionEnabled = getArguments().getBoolean("CUSTOM_OPTION_ENABLED");
            searchEnabled = getArguments().getBoolean("SEARCH_ENABLED");
            clearAllRowEnabled = getArguments().getBoolean("CLEAR_ALL_ROW_ENABLED", false);
            allowCustomCustomString = getArguments().getBoolean("CUSTOM_STRING_ENABLED");
            showBrandFollowButton = getArguments().getBoolean("BRAND_FOLLOW_BUTTON");
            allowMultiSelect = getArguments().getBoolean("MULTI_SELECT_ENABLED");
            parentFragment = (PMFilterableFragment)getFragmentDataOfType(com/poshmark/ui/fragments/PMFilterableFragment);
            initInfo = (MetaItemPickerInfo)getFragmentDataOfType(com/poshmark/utils/meta_data/MetaItemPickerInfo);
            setupAdapter();
            return;
        } else
        {
            backoutFlag = true;
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030088, viewgroup, false);
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (backoutFlag)
        {
            getActivity().onBackPressed();
        }
    }

    public void returnData()
    {
        Object obj = (PMFragment)getTargetFragment();
        String s = StringUtils.toJson(metaItem, com/poshmark/data_model/models/MetaItem);
        dataReturned = true;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("DATA_SELECTED", s);
        intent.putExtra("RETURNED_RESULTS", bundle);
        if (obj != null)
        {
            ((PMFragment) (obj)).onActivityResult(getTargetRequestCode(), -1, intent);
            obj = getActivity();
            if (obj != null)
            {
                ((Activity) (obj)).onBackPressed();
            }
            return;
        } else
        {
            finishActivityWithResult(-1, intent);
            return;
        }
    }

    public void setRecentBrandsLayout(boolean flag, View view)
    {
    }

    public void setViewNameForAnalytics()
    {
        if (backoutFlag) goto _L2; else goto _L1
_L1:
        _cls5..SwitchMap.com.poshmark.ui.fragments.MetaItemListViewFragment.META_ITEM_MODES[metaItemMode.ordinal()];
        JVM INSTR tableswitch 1 5: default 52
    //                   1 53
    //                   2 61
    //                   3 69
    //                   4 77
    //                   5 77;
           goto _L2 _L3 _L4 _L5 _L6 _L6
_L2:
        return;
_L3:
        viewNameForAnalytics = "listing_select_category_screen";
        return;
_L4:
        viewNameForAnalytics = "listing_select_size_screen";
        return;
_L5:
        viewNameForAnalytics = "listing_select_brand_screen";
        return;
_L6:
        viewNameForAnalytics = "listing_select_condition_status_screen";
        return;
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (allowMultiSelect)
        {
            setNextActionButton("DONE", new android.view.View.OnClickListener() {

                final MetaItemListViewFragment this$0;

                public void onClick(View view)
                {
                    if (!multiSelectList.isEmpty())
                    {
                        returnData();
                    }
                }

            
            {
                this$0 = MetaItemListViewFragment.this;
                super();
            }
            });
        }
        setTitleFromMode();
    }

    public void setupHeaderView()
    {
        View view = LayoutInflater.from(getActivity()).inflate(0x7f03005b, null, false);
        searchBox = (EditText)view.findViewById(0x7f0c0151);
        clearAllTextBox = (PMTextView)view.findViewById(0x7f0c0072);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f0c0166);
        LinearLayout linearlayout1 = (LinearLayout)view.findViewById(0x7f0c0071);
        if (searchEnabled)
        {
            linearlayout.setVisibility(0);
        } else
        {
            linearlayout.setVisibility(8);
        }
        if (clearAllRowEnabled)
        {
            linearlayout1.setVisibility(0);
            clearAllTextBox.setText("All");
            if (initInfo.currentSelection == null)
            {
                clearAllTextBox.setTextColor(getResources().getColor(0x7f09003c));
                clearAllTextBox.setTypeface(null, 1);
                clearAllTextBox.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f02007e), null);
            }
        } else
        {
            linearlayout1.setVisibility(8);
        }
        if (searchEnabled || clearAllRowEnabled)
        {
            setupSearchListener();
            listView.addHeaderView(view);
        }
    }


}
