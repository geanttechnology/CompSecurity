// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.ui.AmazonSwitchWidget;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

public class WeinreDebugSettingsView extends LinearLayout
{

    private AmazonActivity mActivity;
    private EditText mWeinreServerHostEditText;
    private EditText mWeinreServerPortEditText;

    public WeinreDebugSettingsView(final AmazonActivity dataStore, AttributeSet attributeset)
    {
        super(dataStore, attributeset);
        mActivity = dataStore;
        dataStore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        View.inflate(mActivity, com.amazon.mShop.android.lib.R.layout.weinre_debug_settings, this);
        mWeinreServerHostEditText = (EditText)findViewById(com.amazon.mShop.android.lib.R.id.weinre_server_host_edit_text);
        mWeinreServerPortEditText = (EditText)findViewById(com.amazon.mShop.android.lib.R.id.weinre_server_port_edit_text);
        mWeinreServerHostEditText.setText(dataStore.getString("weinreServerHost"));
        int j = dataStore.getInt("weinreServerPort");
        int i = j;
        if (j == 0)
        {
            i = getResources().getInteger(com.amazon.mShop.android.lib.R.integer.weinre_server_default_port);
        }
        mWeinreServerPortEditText.setText((new StringBuilder()).append(i).append("").toString());
        attributeset = (AmazonSwitchWidget)findViewById(com.amazon.mShop.android.lib.R.id.weinre_debug_checkbox);
        boolean flag = dataStore.getBoolean("weinreServerStatus", false);
        attributeset.setChecked(flag);
        mWeinreServerHostEditText.setEnabled(flag);
        mWeinreServerPortEditText.setEnabled(flag);
        attributeset.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final WeinreDebugSettingsView this$0;
            final DataStore val$dataStore;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                dataStore.putBoolean("weinreServerStatus", flag1);
                mWeinreServerHostEditText.setEnabled(flag1);
                mWeinreServerPortEditText.setEnabled(flag1);
            }

            
            {
                this$0 = WeinreDebugSettingsView.this;
                dataStore = datastore;
                super();
            }
        });
        ((Button)findViewById(com.amazon.mShop.android.lib.R.id.save_settings_and_restart_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final WeinreDebugSettingsView this$0;
            final DataStore val$dataStore;

            public void onClick(View view)
            {
                dataStore.putString("weinreServerHost", mWeinreServerHostEditText.getText().toString());
                view = dataStore;
                int k;
                if (Util.isEmpty(mWeinreServerPortEditText.getText()))
                {
                    k = getResources().getInteger(com.amazon.mShop.android.lib.R.integer.weinre_server_default_port);
                } else
                {
                    k = Integer.parseInt(mWeinreServerPortEditText.getText().toString());
                }
                view.putInt("weinreServerPort", k);
                AppUtils.restartApp();
            }

            
            {
                this$0 = WeinreDebugSettingsView.this;
                dataStore = datastore;
                super();
            }
        });
    }


}
