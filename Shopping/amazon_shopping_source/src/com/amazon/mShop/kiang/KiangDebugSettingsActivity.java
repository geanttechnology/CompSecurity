// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.kiang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;

public class KiangDebugSettingsActivity extends AmazonActivity
{

    private EditText mApplicationVersionEditText;
    private EditText mAssociateTagEditText;
    private EditText mHardwareIdentifierEditText;
    private EditText mOSVersionEditText;
    private EditText mUBIDEditText;

    public KiangDebugSettingsActivity()
    {
    }

    private void initSettings()
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        mUBIDEditText.setText(datastore.getString("Ubid"));
        mHardwareIdentifierEditText.setText(datastore.getString("hardwareIdentifier"));
        mOSVersionEditText.setText(datastore.getString("osVersion"));
        mApplicationVersionEditText.setText(String.valueOf(datastore.getInt("globalApplicationVersion")));
        mAssociateTagEditText.setText(datastore.getString("associatesTagCheckChange"));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (LinearLayout)LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.kiang_debug_settings, null);
        mUBIDEditText = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.debug_kiang_ubid);
        mHardwareIdentifierEditText = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.debug_kiang_hardwareIdentifier);
        mOSVersionEditText = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.debug_kiang_osversion);
        mApplicationVersionEditText = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.debug_kiang_applicationVersion);
        mAssociateTagEditText = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.debug_kiang_associate);
        ((Button)bundle.findViewById(com.amazon.mShop.android.lib.R.id.kaing_save)).setOnClickListener(new android.view.View.OnClickListener() {

            final KiangDebugSettingsActivity this$0;

            public void onClick(View view)
            {
                saveDebugSettings();
                finish();
            }

            
            {
                this$0 = KiangDebugSettingsActivity.this;
                super();
            }
        });
        initSettings();
        pushView(bundle);
    }

    protected void saveDebugSettings()
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        datastore.putString("Ubid", mUBIDEditText.getText().toString());
        datastore.putString("hardwareIdentifier", mHardwareIdentifierEditText.getText().toString());
        datastore.putString("osVersion", mOSVersionEditText.getText().toString());
        datastore.putInt("globalApplicationVersion", Integer.parseInt(mApplicationVersionEditText.getText().toString()));
        datastore.putString("associatesTagCheckChange", mAssociateTagEditText.getText().toString());
    }
}
