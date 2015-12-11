// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.poshmark.application.AppInfo;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMTextView;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, MappPageFragment

public class AboutFragment extends PMFragment
{

    public AboutFragment()
    {
    }

    private void launchUrl(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com").append(s).toString());
        bundle.putString("ANALYTICS_PAGE_NAME", s1);
        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    private void setupButtons()
    {
        Button button = (Button)getView().findViewById(0x7f0c002b);
        Button button1 = (Button)getView().findViewById(0x7f0c002c);
        Button button2 = (Button)getView().findViewById(0x7f0c002d);
        PMTextView pmtextview = (PMTextView)getView().findViewById(0x7f0c002e);
        button.setText(0x7f060298);
        button1.setText(0x7f06021d);
        button2.setText(0x7f060162);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final AboutFragment this$0;

            public void onClick(View view)
            {
                launchUrl("/mapp/terms_and_conditions", "terms_and_conditions_screen");
            }

            
            {
                this$0 = AboutFragment.this;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final AboutFragment this$0;

            public void onClick(View view)
            {
                launchUrl("/mapp/privacy_policy", "privacy_policy_screen");
            }

            
            {
                this$0 = AboutFragment.this;
                super();
            }
        });
        button2.setOnClickListener(new android.view.View.OnClickListener() {

            final AboutFragment this$0;

            public void onClick(View view)
            {
                showAutoHideProgressDialogWithMessage("Coming Soon");
            }

            
            {
                this$0 = AboutFragment.this;
                super();
            }
        });
        pmtextview.setText((new StringBuilder()).append("v").append(AppInfo.getInstance().versionName).toString());
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupButtons();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        setTitle(0x7f06002c);
        return layoutinflater.inflate(0x7f030000, viewgroup, false);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "about_screen";
    }

}
