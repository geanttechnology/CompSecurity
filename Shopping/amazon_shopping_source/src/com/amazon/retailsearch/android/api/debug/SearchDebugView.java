// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchConfigurationManager;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import java.util.Locale;

public class SearchDebugView extends LinearLayout
{
    private class SearchDebugOnCheckedChangeListener
        implements android.widget.RadioGroup.OnCheckedChangeListener
    {

        final SearchDebugView this$0;

        public void onCheckedChanged(RadioGroup radiogroup, int i)
        {
            if (i != com.amazon.retailsearch.R.id.prod_env_selected) goto _L2; else goto _L1
_L1:
            SearchConfigurationManager.getInstance().setConfigurationId("amazon");
            info.setText("");
_L4:
            radiogroup = SearchConfiguration.getConfiguration();
            radiogroup.setRealm(radiogroup.getRealmForLocale(Locale.getDefault()));
            AndroidRetailSearchClient.resetClient();
            envUrl.setText(SearchConfiguration.getConfiguration().getRealm().getSecureSearchServiceUrl());
            return;
_L2:
            if (i == com.amazon.retailsearch.R.id.gamma_env_selected)
            {
                SearchConfigurationManager.getInstance().setConfigurationId("test1");
                info.setText(getResources().getString(com.amazon.retailsearch.R.string.rs_external_warning));
            } else
            if (i == com.amazon.retailsearch.R.id.beta_env_selected)
            {
                SearchConfigurationManager.getInstance().setConfigurationId("test2");
                info.setText(getResources().getString(com.amazon.retailsearch.R.string.rs_external_warning));
            } else
            if (i == com.amazon.retailsearch.R.id.integ_beta_env_selected)
            {
                SearchConfigurationManager.getInstance().setConfigurationId("test3");
                info.setText(getResources().getString(com.amazon.retailsearch.R.string.rs_ilaw_warning));
            } else
            if (i == com.amazon.retailsearch.R.id.integ_gamma_env_selected)
            {
                SearchConfigurationManager.getInstance().setConfigurationId("test4");
                info.setText(getResources().getString(com.amazon.retailsearch.R.string.rs_ilaw_warning));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private SearchDebugOnCheckedChangeListener()
        {
            this$0 = SearchDebugView.this;
            super();
        }

    }


    private final TextView envUrl;
    private final TextView info;

    public SearchDebugView(Context context)
    {
        super(context);
        setOrientation(1);
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        inflate(context, com.amazon.retailsearch.R.layout.rs_debug_settings, this);
        envUrl = (TextView)findViewById(com.amazon.retailsearch.R.id.retail_search_env_url);
        info = (TextView)findViewById(com.amazon.retailsearch.R.id.retail_search_debug_info_line);
        ((RadioGroup)findViewById(com.amazon.retailsearch.R.id.retail_search_env_group)).setOnCheckedChangeListener(new SearchDebugOnCheckedChangeListener());
    }


}
