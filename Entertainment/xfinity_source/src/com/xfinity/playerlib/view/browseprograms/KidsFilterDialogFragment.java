// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            DibicProgramFilter

public class KidsFilterDialogFragment extends DialogFragment
{

    private RadioButton allButton;
    private CheckBox downloadableCheckBox;
    private android.content.DialogInterface.OnDismissListener onDismissListener;
    private ArrayList pairList;
    private RadioGroup programTypes;
    private CheckBox subscriptionOnlyCheckBox;
    protected PlayNowUserManager userManager;

    public KidsFilterDialogFragment()
    {
        userManager = PlayerContainer.getInstance().getUserManager();
        pairList = new ArrayList();
    }

    private void buildCheckBoxsViews(View view)
    {
        downloadableCheckBox = (CheckBox)view.findViewById(com.xfinity.playerlib.R.id.downloadable_checkbox);
        downloadableCheckBox.setChecked(getFilter().isDownloadableOn());
        subscriptionOnlyCheckBox = (CheckBox)view.findViewById(com.xfinity.playerlib.R.id.subscription_only_checkbox);
        subscriptionOnlyCheckBox.setChecked(getFilter().isHideLockOn());
        ((LinearLayout)view.findViewById(com.xfinity.playerlib.R.id.downloadable_checkbox_container)).setOnClickListener(new android.view.View.OnClickListener() {

            final KidsFilterDialogFragment this$0;

            public void onClick(View view1)
            {
                downloadableCheckBox.performClick();
            }

            
            {
                this$0 = KidsFilterDialogFragment.this;
                super();
            }
        });
        ((LinearLayout)view.findViewById(com.xfinity.playerlib.R.id.subscription_only_checkbox_container)).setOnClickListener(new android.view.View.OnClickListener() {

            final KidsFilterDialogFragment this$0;

            public void onClick(View view1)
            {
                subscriptionOnlyCheckBox.performClick();
            }

            
            {
                this$0 = KidsFilterDialogFragment.this;
                super();
            }
        });
    }

    private void buildProgramTypesView()
    {
        pairList.add(new Pair("movies", "Movies"));
        pairList.add(new Pair("tvseries", "TV Series"));
        pairList.add(new Pair("all", getString(com.xfinity.playerlib.R.string.movies_and_tv)));
        Map map = getFilter().getFiltersForCategory(DibicProgramFilter.FilterCategory.PROGRAM_TYPE);
        for (int i = 0; i < pairList.size(); i++)
        {
            Pair pair = (Pair)pairList.get(i);
            RadioButton radiobutton = (RadioButton)getActivity().getLayoutInflater().inflate(com.xfinity.playerlib.R.layout.kids_filter_radio_button, programTypes, false);
            radiobutton.setId(i);
            radiobutton.setText((CharSequence)pair.second);
            if (!map.isEmpty() && map.containsKey(pair.first) || map.isEmpty() && ((String)pair.first).equals("all"))
            {
                radiobutton.setChecked(true);
            }
            if (((String)pair.first).equals("all"))
            {
                allButton = radiobutton;
            }
            programTypes.addView(radiobutton);
        }

    }

    void clearAll()
    {
        downloadableCheckBox.setChecked(false);
        subscriptionOnlyCheckBox.setChecked(false);
        programTypes.clearCheck();
        allButton.setChecked(true);
    }

    protected DibicProgramFilter getFilter()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getKidsFilter();
    }

    void handleDone()
    {
        int i = programTypes.getCheckedRadioButtonId();
        Pair pair = (Pair)pairList.get(i);
        DibicProgramFilter dibicprogramfilter = getFilter();
        dibicprogramfilter.clearFiltersForCategory(DibicProgramFilter.FilterCategory.PROGRAM_TYPE);
        if (!((String)pair.first).equals("all"))
        {
            dibicprogramfilter.addToSelectedList((String)pair.first, (String)pair.second, DibicProgramFilter.FilterCategory.PROGRAM_TYPE);
        }
        dibicprogramfilter.setDownloadableOn(downloadableCheckBox.isChecked());
        dibicprogramfilter.setHideLockOn(subscriptionOnlyCheckBox.isChecked());
        dismiss();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(0, com.xfinity.playerlib.R.style.xfinity_remote_filter_dialog);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        getDialog().getWindow().requestFeature(1);
        getDialog().setCanceledOnTouchOutside(true);
        layoutinflater = layoutinflater.inflate(com.xfinity.playerlib.R.layout.kids_filter_dialog, viewgroup, false);
        viewgroup = (TextView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.label);
        if (viewgroup != null)
        {
            viewgroup.setText(com.xfinity.playerlib.R.string.filter_program_type);
            layoutinflater.findViewById(com.xfinity.playerlib.R.id.filterCountContainer).setVisibility(8);
            layoutinflater.findViewById(com.xfinity.playerlib.R.id.filter_dialog_category_item_layout).setSelected(true);
        }
        programTypes = (RadioGroup)layoutinflater.findViewById(com.xfinity.playerlib.R.id.program_types);
        buildProgramTypesView();
        buildCheckBoxsViews(layoutinflater);
        ((Button)layoutinflater.findViewById(com.xfinity.playerlib.R.id.apply)).setOnClickListener(new android.view.View.OnClickListener() {

            final KidsFilterDialogFragment this$0;

            public void onClick(View view)
            {
                handleDone();
            }

            
            {
                this$0 = KidsFilterDialogFragment.this;
                super();
            }
        });
        ((Button)layoutinflater.findViewById(com.xfinity.playerlib.R.id.clear)).setOnClickListener(new android.view.View.OnClickListener() {

            final KidsFilterDialogFragment this$0;

            public void onClick(View view)
            {
                clearAll();
            }

            
            {
                this$0 = KidsFilterDialogFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (onDismissListener != null)
        {
            onDismissListener.onDismiss(dialoginterface);
        }
        super.onDismiss(dialoginterface);
    }

    public void onStart()
    {
        super.onStart();
        if (getDialog() == null)
        {
            return;
        } else
        {
            int i = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.filter_layout_dialog_width);
            int j = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.kids_filter_layout_dialog_height);
            getDialog().getWindow().setLayout(i, j);
            return;
        }
    }

    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        onDismissListener = ondismisslistener;
    }


}
