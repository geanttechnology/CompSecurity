// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.NWTOptionsMetaData;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, MappPageFragment

public class ListingConditionPickerFragment extends PMFragment
{

    boolean backoutFlag;
    MetaItem currentCondition;
    ImageView ntw_no_checkmark;
    RelativeLayout ntw_no_container;
    RelativeLayout ntw_retail_container;
    ImageView ntw_yes_checkmark;
    RelativeLayout ntw_yes_container;
    TextView nwt_message;
    TextView nwt_no_text;
    TextView nwt_yes_text;
    TextView retailMessage;
    Switch retailSwitch;

    public ListingConditionPickerFragment()
    {
        backoutFlag = false;
    }

    private void initViewState(View view)
    {
        ntw_yes_container = (RelativeLayout)view.findViewById(0x7f0c0176);
        nwt_yes_text = (TextView)view.findViewById(0x7f0c0177);
        nwt_no_text = (TextView)view.findViewById(0x7f0c017d);
        ntw_retail_container = (RelativeLayout)view.findViewById(0x7f0c0179);
        ntw_no_container = (RelativeLayout)view.findViewById(0x7f0c017c);
        ntw_yes_checkmark = (ImageView)view.findViewById(0x7f0c0178);
        ntw_no_checkmark = (ImageView)view.findViewById(0x7f0c017e);
        retailMessage = (TextView)view.findViewById(0x7f0c0180);
        retailSwitch = (Switch)view.findViewById(0x7f0c017b);
        nwt_message = (TextView)view.findViewById(0x7f0c017f);
        SpannableStringBuilder spannablestringbuilder;
        String s;
        int i;
        int j;
        if (currentCondition != null)
        {
            if (currentCondition.getId().equalsIgnoreCase("nwt"))
            {
                ntw_yes_checkmark.setVisibility(0);
                ntw_retail_container.setVisibility(0);
                retailMessage.setVisibility(0);
                nwt_yes_text.setTextColor(getActivity().getResources().getColor(0x7f09003c));
                nwt_yes_text.setTypeface(null, 1);
                ntw_yes_checkmark.setImageDrawable(getActivity().getResources().getDrawable(0x7f02007e));
            } else
            if (currentCondition.getId().equalsIgnoreCase("ret"))
            {
                ntw_retail_container.setVisibility(0);
                ntw_yes_checkmark.setVisibility(0);
                retailSwitch.setVisibility(0);
                retailMessage.setVisibility(0);
                nwt_yes_text.setTextColor(getActivity().getResources().getColor(0x7f09003c));
                nwt_yes_text.setTypeface(null, 1);
                ntw_yes_checkmark.setImageDrawable(getActivity().getResources().getDrawable(0x7f02007e));
                ntw_retail_container.setVisibility(0);
                retailSwitch.setChecked(true);
            } else
            {
                ntw_no_checkmark.setVisibility(0);
                ntw_no_checkmark.setImageDrawable(getActivity().getResources().getDrawable(0x7f02007e));
            }
        }
        view = getString(0x7f060213);
        spannablestringbuilder = new SpannableStringBuilder(view);
        s = getString(0x7f0601d8);
        i = view.indexOf(s);
        j = s.length();
        spannablestringbuilder.setSpan(new ClickableSpan() {

            final ListingConditionPickerFragment this$0;

            public void onClick(View view1)
            {
            }

            
            {
                this$0 = ListingConditionPickerFragment.this;
                super();
            }
        }, i, i + j, 0);
        nwt_message.setMovementMethod(LinkMovementMethod.getInstance());
        nwt_message.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
        nwt_message.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingConditionPickerFragment this$0;

            public void onClick(View view1)
            {
                view1 = new Bundle();
                view1.putString("URL", "https://www.poshmark.com/mapp/nwt_policy");
                view1.putString("ANALYTICS_PAGE_NAME", "nwt_policy_screen");
                ((PMActivity)getActivity()).launchFragmentInNewActivity(view1, com/poshmark/ui/fragments/MappPageFragment, null);
            }

            
            {
                this$0 = ListingConditionPickerFragment.this;
                super();
            }
        });
    }

    private void returnData()
    {
        Object obj = (PMFragment)getTargetFragment();
        Object obj1 = StringUtils.toJson(currentCondition, com/poshmark/data_model/models/MetaItem);
        Bundle bundle = new Bundle();
        bundle.putString("DATA_SELECTED", ((String) (obj1)));
        obj1 = new Intent();
        ((Intent) (obj1)).putExtra("RETURNED_RESULTS", bundle);
        if (obj != null)
        {
            ((PMFragment) (obj)).onActivityResult(getTargetRequestCode(), -1, ((Intent) (obj1)));
            obj = getActivity();
            if (obj != null)
            {
                ((Activity) (obj)).onBackPressed();
            }
            return;
        } else
        {
            finishActivityWithResult(-1, ((Intent) (obj1)));
            return;
        }
    }

    private void setupHandlers()
    {
        ntw_yes_container.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingConditionPickerFragment this$0;

            public void onClick(View view)
            {
                ntw_retail_container.setVisibility(0);
                retailSwitch.setChecked(false);
                ntw_no_checkmark.setVisibility(4);
                ntw_yes_checkmark.setVisibility(0);
                nwt_yes_text.setTextColor(getActivity().getResources().getColor(0x7f09003c));
                nwt_yes_text.setTypeface(null, 1);
                nwt_no_text.setTextColor(getActivity().getResources().getColor(0x7f090035));
                nwt_no_text.setTypeface(null, 0);
                retailMessage.setVisibility(0);
                currentCondition = MetaItem.clone(NWTOptionsMetaData.getConditionMetaItemForListingFlow("nwt"));
            }

            
            {
                this$0 = ListingConditionPickerFragment.this;
                super();
            }
        });
        ntw_no_container.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingConditionPickerFragment this$0;

            public void onClick(View view)
            {
                ntw_retail_container.setVisibility(8);
                retailSwitch.setChecked(false);
                ntw_yes_checkmark.setVisibility(4);
                ntw_no_checkmark.setVisibility(0);
                nwt_no_text.setTextColor(getActivity().getResources().getColor(0x7f09003c));
                nwt_no_text.setTypeface(null, 1);
                nwt_yes_text.setTextColor(getActivity().getResources().getColor(0x7f090035));
                nwt_yes_text.setTypeface(null, 0);
                retailMessage.setVisibility(8);
                currentCondition = MetaItem.clone(NWTOptionsMetaData.getConditionMetaItemForListingFlow("not_nwt"));
            }

            
            {
                this$0 = ListingConditionPickerFragment.this;
                super();
            }
        });
        retailSwitch.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ListingConditionPickerFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    currentCondition = MetaItem.clone(NWTOptionsMetaData.getConditionMetaItemForListingFlow("ret"));
                    return;
                } else
                {
                    currentCondition = MetaItem.clone(NWTOptionsMetaData.getConditionMetaItemForListingFlow("nwt"));
                    return;
                }
            }

            
            {
                this$0 = ListingConditionPickerFragment.this;
                super();
            }
        });
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030060, viewgroup, false);
        if (bundle == null)
        {
            viewgroup = (MetaItem)getFragmentDataOfType(com/poshmark/data_model/models/MetaItem);
            if (viewgroup != null)
            {
                currentCondition = MetaItem.clone(viewgroup);
            }
            initViewState(layoutinflater);
            setupHandlers();
            return layoutinflater;
        } else
        {
            backoutFlag = true;
            return layoutinflater;
        }
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (backoutFlag)
        {
            getActivity().onBackPressed();
        }
    }

    public void setViewNameForAnalytics()
    {
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        showRefreshButton(false);
        setTitle(0x7f06026b);
        setNextActionButton("DONE", new android.view.View.OnClickListener() {

            final ListingConditionPickerFragment this$0;

            public void onClick(View view)
            {
                returnData();
            }

            
            {
                this$0 = ListingConditionPickerFragment.this;
                super();
            }
        });
    }

}
