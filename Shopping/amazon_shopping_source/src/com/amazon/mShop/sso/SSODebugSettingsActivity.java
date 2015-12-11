// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SSODebugSettingsActivity extends AmazonActivity
{

    private static Map sStrToRadioButtonIdMap;
    private RadioGroup mAccountPhoneNumberGroup;
    private android.view.View.OnClickListener mClickListener;
    private RadioGroup mForceSignInGroup;
    private Button mSaveSettingsButon;

    public SSODebugSettingsActivity()
    {
        mSaveSettingsButon = null;
        mForceSignInGroup = null;
        mAccountPhoneNumberGroup = null;
        mClickListener = new android.view.View.OnClickListener() {

            final SSODebugSettingsActivity this$0;

            public void onClick(View view)
            {
                view = ((RadioButton)mForceSignInGroup.findViewById(mForceSignInGroup.getCheckedRadioButtonId())).getText().toString();
                DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
                datastore.putString("switchSSONonAuthForceSignIn", view);
                datastore.putString("accountPhoneNumber", ((RadioButton)mAccountPhoneNumberGroup.findViewById(mAccountPhoneNumberGroup.getCheckedRadioButtonId())).getText().toString());
                AppUtils.restartApp();
            }

            
            {
                this$0 = SSODebugSettingsActivity.this;
                super();
            }
        };
    }

    private void initSSODebugSettingsView()
    {
        View view = View.inflate(this, com.amazon.mShop.android.lib.R.layout.sso_debug_settings, null);
        mSaveSettingsButon = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.sso_saving_settings_btn);
        mForceSignInGroup = (RadioGroup)view.findViewById(com.amazon.mShop.android.lib.R.id.sso_non_auth_force_sign_in_rgrpbtn);
        mAccountPhoneNumberGroup = (RadioGroup)view.findViewById(com.amazon.mShop.android.lib.R.id.account_phone_number_option_rgrpbtn);
        setupRadioGroup(view);
        String s = ActivityUtils.getSSONonAuthForceSignInOption();
        setCheckedRadioButton(mForceSignInGroup, Integer.valueOf(com.amazon.mShop.android.lib.R.id.sso_non_auth_force_sign_in_rgrpbtn), s);
        s = ActivityUtils.getAccountPhoneNumberOption();
        setCheckedRadioButton(mAccountPhoneNumberGroup, Integer.valueOf(com.amazon.mShop.android.lib.R.id.account_phone_number_option_rgrpbtn), s);
        if (!ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_account_phone_number_support))
        {
            View view1 = view.findViewById(com.amazon.mShop.android.lib.R.id.account_phone_number_option);
            if (view1 != null)
            {
                view1.setVisibility(8);
            }
        }
        mSaveSettingsButon.setOnClickListener(mClickListener);
        setRootView(view);
    }

    private void setCheckedRadioButton(RadioGroup radiogroup, Integer integer, String s)
    {
        integer = (Map)sStrToRadioButtonIdMap.get(integer);
        if (integer != null && integer.get(s) != null)
        {
            radiogroup = (RadioButton)radiogroup.findViewById(((Integer)integer.get(s)).intValue());
            if (radiogroup != null)
            {
                radiogroup.setChecked(true);
            }
        }
    }

    private void setupRadioGroup(View view)
    {
        for (Iterator iterator = sStrToRadioButtonIdMap.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (Integer)iterator.next();
            obj = (Map)sStrToRadioButtonIdMap.get(obj);
            Iterator iterator1 = ((Map) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                RadioButton radiobutton = (RadioButton)view.findViewById(((Integer)((Map) (obj)).get(s)).intValue());
                if (radiobutton != null)
                {
                    radiobutton.setText(s);
                }
            }
        }

    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initSSODebugSettingsView();
    }

    static 
    {
        sStrToRadioButtonIdMap = new HashMap();
        HashMap hashmap = new HashMap();
        hashmap.put("Normal", Integer.valueOf(com.amazon.mShop.android.lib.R.id.sso_sign_in_normal_rbtn));
        hashmap.put("Force", Integer.valueOf(com.amazon.mShop.android.lib.R.id.sso_sign_in_force_rbtn));
        hashmap.put("Weblab", Integer.valueOf(com.amazon.mShop.android.lib.R.id.sso_sign_in_weblab_rbtn));
        sStrToRadioButtonIdMap.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.sso_non_auth_force_sign_in_rgrpbtn), hashmap);
        hashmap = new HashMap();
        hashmap.put("Email", Integer.valueOf(com.amazon.mShop.android.lib.R.id.account_email_rbtn));
        hashmap.put("Email or Phone Number", Integer.valueOf(com.amazon.mShop.android.lib.R.id.account_email_phone_number_rbtn));
        hashmap.put("Account Weblab Control", Integer.valueOf(com.amazon.mShop.android.lib.R.id.account_weblab_rbtn));
        sStrToRadioButtonIdMap.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.account_phone_number_option_rgrpbtn), hashmap);
    }


}
