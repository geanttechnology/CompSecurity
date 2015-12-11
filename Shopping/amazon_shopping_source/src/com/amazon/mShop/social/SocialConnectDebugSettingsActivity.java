// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.social;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.social:
//            SocialConnectDatabaseHelper

public class SocialConnectDebugSettingsActivity extends AmazonActivity
{

    private CheckBox mClearUserCB;
    private RadioButton mRadioAlways;
    private RadioButton mRadioShowNever;
    private RadioButton mRadioShowOnce;
    private EditText mURLEdit;

    public SocialConnectDebugSettingsActivity()
    {
    }

    public static String getSocialConnectDebugMode()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("socialConnectDebugMode");
    }

    private void initSettings()
    {
        String s = getSocialConnectDebugMode();
        String s1;
        if ("never".equalsIgnoreCase(s))
        {
            mRadioShowNever.setChecked(true);
        } else
        if ("once".equalsIgnoreCase(s))
        {
            mRadioShowOnce.setChecked(true);
        } else
        {
            mRadioAlways.setChecked(true);
        }
        s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("socialConnectDebugUrl");
        s = s1;
        if (Util.isEmpty(s1))
        {
            s = "";
        }
        mURLEdit.setText(s);
    }

    private void saveDebugSettings()
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        String s = "once";
        if (mRadioShowNever.isChecked())
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
        datastore.putString("socialConnectDebugMode", s);
        datastore.putString("socialConnectDebugUrl", mURLEdit.getText().toString().trim());
        if (mClearUserCB.isChecked())
        {
            SocialConnectDatabaseHelper.getInstance().clearDatabase();
        }
    }

    public static boolean shouldAlwaysDisplay()
    {
        return "always".equalsIgnoreCase(getSocialConnectDebugMode());
    }

    public static boolean shouldDisplayOnce()
    {
        return "once".equalsIgnoreCase(getSocialConnectDebugMode());
    }

    public static boolean shouldNeverDisplay()
    {
        return "never".equalsIgnoreCase(getSocialConnectDebugMode());
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (ScrollView)LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.social_connect_debug_settings, null);
        mRadioShowOnce = (RadioButton)bundle.findViewById(com.amazon.mShop.android.lib.R.id.social_connect_once);
        mRadioShowNever = (RadioButton)bundle.findViewById(com.amazon.mShop.android.lib.R.id.social_connect_never);
        mRadioAlways = (RadioButton)bundle.findViewById(com.amazon.mShop.android.lib.R.id.social_connect_always);
        mClearUserCB = (CheckBox)bundle.findViewById(com.amazon.mShop.android.lib.R.id.social_connect_clear_data);
        mClearUserCB.setChecked(false);
        mURLEdit = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.social_connect_url);
        ((Button)bundle.findViewById(com.amazon.mShop.android.lib.R.id.social_connect_save)).setOnClickListener(new android.view.View.OnClickListener() {

            final SocialConnectDebugSettingsActivity this$0;

            public void onClick(View view)
            {
                saveDebugSettings();
                finish();
            }

            
            {
                this$0 = SocialConnectDebugSettingsActivity.this;
                super();
            }
        });
        initSettings();
        pushView(bundle);
    }

}
