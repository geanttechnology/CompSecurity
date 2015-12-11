// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.debug;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.mobile.appdrawer.utils.mshopservice.MShopServiceUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.debug:
//            DebugSettingsActivity

public class DebugSettingsView extends ScrollView
    implements TitleProvider
{
    private class LocaleSpinnerAdapter extends ArrayAdapter
    {

        final DebugSettingsView this$0;

        public LocaleSpinnerAdapter(Context context)
        {
            this$0 = DebugSettingsView.this;
            super(context, 0x1090008);
            setDropDownViewResource(0x1090009);
            debugsettingsview = ((DebugSettingsView) (AppLocale.getInstance().getSupportedLocaleNameArray()));
            for (int i = 0; i < DebugSettingsView.this.length; i++)
            {
                add((String)(String)DebugSettingsView.this[i]);
            }

        }
    }

    private class LocaleSpinnerOnItemSelectedListener
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final DebugSettingsView this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            recordEditedSettings(mSelectedLocaleName);
            mSelectedLocaleName = adapterview.getItemAtPosition(i).toString();
            loadToDisplay(mSelectedLocaleName);
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        private LocaleSpinnerOnItemSelectedListener()
        {
            this$0 = DebugSettingsView.this;
            super();
        }

    }


    private final TextView mCNGetuiVCID;
    protected final CheckBox mClearSessionCheckBox;
    protected final DebugSettingsActivity mDebugActivity;
    private final TextView mDefaultServiceSecureUrlLabel;
    private final TextView mDefaultServiceUrlLabel;
    private final Spinner mLocaleOptionsSpinner;
    private final RadioGroup mSSOUrlRadioGroup;
    private String mSelectedLocaleName;
    protected final EditText mServiceSecureUrlEditText;
    protected final EditText mServiceUrlEditText;
    private final Button mSimulateNPECrashButton;

    public DebugSettingsView(DebugSettingsActivity debugsettingsactivity)
    {
        super(debugsettingsactivity);
        mDebugActivity = debugsettingsactivity;
        Object obj = (LinearLayout)LayoutInflater.from(debugsettingsactivity).inflate(com.amazon.mShop.android.lib.R.layout.debug_settings_view, null);
        mServiceUrlEditText = (EditText)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.service_url_edit_text);
        mServiceSecureUrlEditText = (EditText)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.service_secure_url_edit_text);
        mDefaultServiceUrlLabel = (TextView)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.default_service_url_label);
        mDefaultServiceSecureUrlLabel = (TextView)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.default_service_secure_url_label);
        mSSOUrlRadioGroup = (RadioGroup)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.sso_check_login_url_radio_group);
        mSelectedLocaleName = AppLocale.getInstance().getCurrentLocaleName();
        mClearSessionCheckBox = (CheckBox)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.clear_session_data_checkbox);
        mLocaleOptionsSpinner = (Spinner)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.locale_options_spinner);
        debugsettingsactivity = new LocaleSpinnerAdapter(mDebugActivity);
        mLocaleOptionsSpinner.setAdapter(debugsettingsactivity);
        debugsettingsactivity = new LocaleSpinnerOnItemSelectedListener();
        mLocaleOptionsSpinner.setOnItemSelectedListener(debugsettingsactivity);
        mLocaleOptionsSpinner.setSelection(getPositionForLocaleName(mSelectedLocaleName));
        mCNGetuiVCID = (TextView)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cn_getui_vcid);
        ((Button)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.set_new_service_url_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugSettingsView this$0;

            public void onClick(View view)
            {
                view = mLocaleOptionsSpinner.getSelectedItem().toString();
                recordEditedSettings(view);
                mDebugActivity.saveChangesAndRestart(view);
            }

            
            {
                this$0 = DebugSettingsView.this;
                super();
            }
        });
        ((Button)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.reset_to_prod_service_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugSettingsView this$0;

            public void onClick(View view)
            {
                view = mLocaleOptionsSpinner.getSelectedItem().toString();
                reloadDefaultUrlToDisplay(view);
                recordEditedSettings(mLocaleOptionsSpinner.getSelectedItem().toString());
            }

            
            {
                this$0 = DebugSettingsView.this;
                super();
            }
        });
        ((TextView)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.application_id)).setText((new StringBuilder()).append("ApplicationID: ").append(com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationId()).append("\n Cookies: = \n").append(CookieBridge.getCookiesOfCurrentLocale(getContext(), true)).append("\n\n real Value of at-main/at-acb = ").append(CookieBridge.getAtMainCookie(getContext())).toString());
        showNotificationBlock(((LinearLayout) (obj)));
        showAIIDBlock(((LinearLayout) (obj)));
        addView(((View) (obj)));
        loadToDisplay(mSelectedLocaleName);
        mSimulateNPECrashButton = (Button)((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.simulate_npe_to_cause_crash);
        mSimulateNPECrashButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DebugSettingsView this$0;

            public void onClick(View view)
            {
                throw new NullPointerException();
            }

            
            {
                this$0 = DebugSettingsView.this;
                super();
            }
        });
        if ("zh_CN".equals(AppLocale.getInstance().getCurrentLocaleName()))
        {
            debugsettingsactivity = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("getuiRegistrationId");
            ((LinearLayout) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cn_getui_vcid_title).setVisibility(0);
            mCNGetuiVCID.setVisibility(0);
            obj = mCNGetuiVCID;
            if (Util.isEmpty(debugsettingsactivity))
            {
                debugsettingsactivity = "Not available";
            }
            ((TextView) (obj)).setText(debugsettingsactivity);
        }
    }

    private int getPositionForLocaleName(String s)
    {
        Object aobj[] = AppLocale.getInstance().getSupportedLocaleNameArray();
        for (int i = 0; i < aobj.length; i++)
        {
            if (((String)aobj[i]).equals(s))
            {
                return i;
            }
        }

        return -1;
    }

    private void showAIIDBlock(LinearLayout linearlayout)
    {
        Object obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("applicationInstallId");
        final String aiidText = ((String) (obj));
        if (Util.isEmpty(((String) (obj))))
        {
            aiidText = "null";
        }
        obj = (TextView)linearlayout.findViewById(com.amazon.mShop.android.lib.R.id.app_install_id);
        aiidText = (new StringBuilder()).append("App Install ID: ").append(aiidText).toString();
        ((TextView) (obj)).setText(aiidText);
        ((Button)linearlayout.findViewById(com.amazon.mShop.android.lib.R.id.mail_aiid_to_me)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugSettingsView this$0;
            final String val$aiidText;

            public void onClick(View view)
            {
                view = Uri.encode(aiidText);
                view = (new StringBuilder()).append("mailto:yourmail@amazon.com?body=").append(view).append("&subject=AIID").toString();
                WebUtils.handleMailtoLink(getContext(), view);
            }

            
            {
                this$0 = DebugSettingsView.this;
                aiidText = s;
                super();
            }
        });
    }

    private void showNotificationBlock(LinearLayout linearlayout)
    {
        Object obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("gcmRegistrationId");
        final String tokenText = ((String) (obj));
        if (Util.isEmpty(((String) (obj))))
        {
            tokenText = "null";
        }
        obj = (TextView)linearlayout.findViewById(com.amazon.mShop.android.lib.R.id.notification_token);
        tokenText = (new StringBuilder()).append("NotificationToken: ").append(tokenText).toString();
        ((TextView) (obj)).setText(tokenText);
        ((Button)linearlayout.findViewById(com.amazon.mShop.android.lib.R.id.mail_notification_to_me)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugSettingsView this$0;
            final String val$tokenText;

            public void onClick(View view)
            {
                view = Uri.encode(tokenText);
                view = (new StringBuilder()).append("mailto:yourmail@amazon.com?body=").append(view).append("&subject=NotificationToken").toString();
                WebUtils.handleMailtoLink(getContext(), view);
            }

            
            {
                this$0 = DebugSettingsView.this;
                tokenText = s;
                super();
            }
        });
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return (String)getResources().getText(com.amazon.mShop.android.lib.R.string.debug_title);
    }

    protected void loadToDisplay(String s)
    {
        String s3 = ConfigUtils.getStringForSpecificLocale(getContext(), com.amazon.mShop.android.lib.R.string.config_serviceURL, s);
        String s4 = ConfigUtils.getStringForSpecificLocale(getContext(), com.amazon.mShop.android.lib.R.string.config_serviceSecureURL, s);
        String s2 = mDebugActivity.getServiceUrlInMap(s);
        String s1 = s2;
        if (Util.isEmpty(s2))
        {
            s1 = s3;
        }
        String s5 = mDebugActivity.getServiceSecureUrlInMap(s);
        s2 = s5;
        if (Util.isEmpty(s5))
        {
            s2 = s4;
        }
        s5 = mDebugActivity.getSSOCheckLoginServerInMap(s);
        boolean flag;
        if (Util.isEmpty(s5))
        {
            if (s3.equals(s1))
            {
                mSSOUrlRadioGroup.check(com.amazon.mShop.android.lib.R.id.msh);
            } else
            {
                mSSOUrlRadioGroup.check(com.amazon.mShop.android.lib.R.id.shm1);
            }
        } else
        if ("MSH".equals(s5))
        {
            mSSOUrlRadioGroup.check(com.amazon.mShop.android.lib.R.id.msh);
        } else
        {
            mSSOUrlRadioGroup.check(com.amazon.mShop.android.lib.R.id.shm1);
        }
        flag = mDebugActivity.getClearSessionDataSettingInMap(s);
        mClearSessionCheckBox.setChecked(flag);
        mDefaultServiceUrlLabel.setText(s3);
        mDefaultServiceSecureUrlLabel.setText(s4);
        mServiceUrlEditText.setText(s1);
        mServiceSecureUrlEditText.setText(s2);
    }

    protected void recordEditedSettings(String s)
    {
        String s2 = mServiceUrlEditText.getText().toString().trim();
        String s3 = mServiceSecureUrlEditText.getText().toString().trim();
        boolean flag = mClearSessionCheckBox.isChecked();
        String s1 = "MSH";
        if (mSSOUrlRadioGroup.getCheckedRadioButtonId() == com.amazon.mShop.android.lib.R.id.shm1)
        {
            s1 = "SHM";
        }
        MShopServiceUtils.setServiceUrl(s, s3);
        mDebugActivity.recordInMap(s, s2, s3, s1, flag);
    }

    protected void reloadDefaultUrlToDisplay(String s)
    {
        String s1 = ConfigUtils.getStringForSpecificLocale(getContext(), com.amazon.mShop.android.lib.R.string.config_serviceURL, s);
        s = ConfigUtils.getStringForSpecificLocale(getContext(), com.amazon.mShop.android.lib.R.string.config_serviceSecureURL, s);
        mDefaultServiceUrlLabel.setText(s1);
        mDefaultServiceSecureUrlLabel.setText(s);
        mServiceUrlEditText.setText(s1);
        mServiceSecureUrlEditText.setText(s);
    }




/*
    static String access$202(DebugSettingsView debugsettingsview, String s)
    {
        debugsettingsview.mSelectedLocaleName = s;
        return s;
    }

*/
}
