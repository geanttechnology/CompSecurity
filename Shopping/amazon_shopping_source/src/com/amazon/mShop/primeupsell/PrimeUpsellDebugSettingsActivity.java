// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeUpsellDatabaseHelper

public class PrimeUpsellDebugSettingsActivity extends AmazonActivity
{

    private CheckBox mClearUserCB;
    private CheckBox mForceEligible;
    private EditText mMaximumTimeToShow;
    private RadioButton mRadioAlways;
    private RadioButton mRadioNoShow;
    private RadioButton mRadioOnce;
    private EditText mURLEdit;

    public PrimeUpsellDebugSettingsActivity()
    {
    }

    public static String getPrimeUpsellDebugMode()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("primeUpsellDebugMode");
    }

    private void initSettings()
    {
        String s = getPrimeUpsellDebugMode();
        String s1;
        DataStore datastore;
        if ("never".equalsIgnoreCase(s))
        {
            mRadioNoShow.setChecked(true);
        } else
        if ("once".equalsIgnoreCase(s))
        {
            mRadioOnce.setChecked(true);
        } else
        {
            mRadioAlways.setChecked(true);
        }
        datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        s1 = datastore.getString("currentPrimeUpsellUrl");
        s = s1;
        if (Util.isEmpty(s1))
        {
            s = "";
        }
        mURLEdit.setText(s);
        mForceEligible.setChecked(datastore.getBoolean("primeUpsellForceEligibleToNonPrimeUserDebug", false));
        mMaximumTimeToShow.setText(Integer.toString(datastore.getInt("primeMaximumTimeToShowDebug")));
    }

    private void saveDebugSettings()
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        String s = "once";
        if (mRadioNoShow.isChecked())
        {
            s = "never";
        } else
        if (mRadioAlways.isChecked())
        {
            s = "always";
        } else
        {
            mClearUserCB.setChecked(true);
        }
        datastore.putString("primeUpsellDebugMode", s);
        datastore.putString("currentPrimeUpsellUrl", mURLEdit.getText().toString().trim());
        if (mClearUserCB.isChecked())
        {
            PrimeUpsellDatabaseHelper.getInstance().clearDatabase();
        }
        datastore.putBoolean("primeUpsellForceEligibleToNonPrimeUserDebug", mForceEligible.isChecked());
        datastore.putInt("primeMaximumTimeToShowDebug", Integer.valueOf(mMaximumTimeToShow.getText().toString()).intValue());
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (LinearLayout)LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.prime_upsell_debug_settings, null);
        mRadioNoShow = (RadioButton)bundle.findViewById(com.amazon.mShop.android.lib.R.id.prime_upsell_none);
        mRadioOnce = (RadioButton)bundle.findViewById(com.amazon.mShop.android.lib.R.id.prime_upsell_once);
        mRadioAlways = (RadioButton)bundle.findViewById(com.amazon.mShop.android.lib.R.id.prime_upsell_always);
        mClearUserCB = (CheckBox)bundle.findViewById(com.amazon.mShop.android.lib.R.id.prime_upsell_clear_data);
        mClearUserCB.setChecked(false);
        mURLEdit = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.prime_upsell_url);
        mForceEligible = (CheckBox)bundle.findViewById(com.amazon.mShop.android.lib.R.id.prime_force_eligible);
        mMaximumTimeToShow = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.prime_upsell_maximum_time);
        ((Button)bundle.findViewById(com.amazon.mShop.android.lib.R.id.prime_upsell_save)).setOnClickListener(new android.view.View.OnClickListener() {

            final PrimeUpsellDebugSettingsActivity this$0;

            public void onClick(View view)
            {
                saveDebugSettings();
                finish();
            }

            
            {
                this$0 = PrimeUpsellDebugSettingsActivity.this;
                super();
            }
        });
        initSettings();
        pushView(bundle);
    }

}
