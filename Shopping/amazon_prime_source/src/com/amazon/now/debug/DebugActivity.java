// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.cookie.DebugCookieActivity;
import com.amazon.now.feature.DebugFeatureActivity;
import com.amazon.now.home.WelcomeScreen;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.location.Location;
import com.amazon.now.map.DebugMapWebActivity;
import com.amazon.now.map.MapWebActivity;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.DataStore;
import com.amazon.now.util.WeblabUtil;
import com.amazon.now.web.WebActivity;
import java.util.Locale;

// Referenced classes of package com.amazon.now.debug:
//            DebugDetailPageActivity, DebugWebActivity, DebugSearchActivity

public class DebugActivity extends AmazonActivity
{
    public static final class DebugLaunchActivity extends Enum
    {

        private static final DebugLaunchActivity $VALUES[];
        public static final DebugLaunchActivity MAP_ACTIVITY;
        public static final DebugLaunchActivity WEB_ACTIVITY;

        public static DebugLaunchActivity valueOf(String s)
        {
            return (DebugLaunchActivity)Enum.valueOf(com/amazon/now/debug/DebugActivity$DebugLaunchActivity, s);
        }

        public static DebugLaunchActivity[] values()
        {
            return (DebugLaunchActivity[])$VALUES.clone();
        }

        static 
        {
            MAP_ACTIVITY = new DebugLaunchActivity("MAP_ACTIVITY", 0);
            WEB_ACTIVITY = new DebugLaunchActivity("WEB_ACTIVITY", 1);
            $VALUES = (new DebugLaunchActivity[] {
                MAP_ACTIVITY, WEB_ACTIVITY
            });
        }

        private DebugLaunchActivity(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String SERVICE_URL_KEY = "service_url_key";
    public static final String SERVICE_URL_STATE_GAMMA = "GAMMA";
    public static final String SERVICE_URL_STATE_KEY = "service_url_state_key";
    public static final String SERVICE_URL_STATE_OVERRIDE = "OVERRIDE";
    public static final String SERVICE_URL_STATE_PROD = "PROD";
    private Context mContext;
    private EditText mServiceUrlText;

    public DebugActivity()
    {
    }

    private void setState(String s, String s1, String s2)
    {
        DataStore.putString("service_url_key", s);
        DataStore.putString("service_url_state_key", s1);
        mServiceUrlText.setText(s);
        WeblabUtil.saveWeblabs(null);
        Toast.makeText(mContext, s2, 0).show();
    }

    private void setupDebugSearchButton(View view)
    {
        ((Button)view.findViewById(0x7f0e0049)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;

            public void onClick(View view1)
            {
                view1 = new Intent(DebugActivity.this, com/amazon/now/debug/DebugSearchActivity);
                startActivity(view1);
            }

            
            {
                this$0 = DebugActivity.this;
                super();
            }
        });
    }

    private void setupDebugWebviewButton(View view)
    {
        ((Button)view.findViewById(0x7f0e0048)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;

            public void onClick(View view1)
            {
                view1 = new Intent(DebugActivity.this, com/amazon/now/debug/DebugWebActivity);
                startActivity(view1);
            }

            
            {
                this$0 = DebugActivity.this;
                super();
            }
        });
    }

    private void setupForceCrashButton(View view)
    {
        ((Button)view.findViewById(0x7f0e004a)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;

            public void onClick(View view1)
            {
                throw new NullPointerException("Forced Crash");
            }

            
            {
                this$0 = DebugActivity.this;
                super();
            }
        });
    }

    private void setupServiceUrlButton(View view)
    {
        mServiceUrlText = (EditText)view.findViewById(0x7f0e0043);
        Object obj = AppUtils.getServiceUrl(this);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            mServiceUrlText.setText(((CharSequence) (obj)));
        }
        obj = (Button)view.findViewById(0x7f0e0046);
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;

            public void onClick(View view1)
            {
                setState(getResources().getString(0x7f07008b), "PROD", "Service URL set to Prod!");
            }

            
            {
                this$0 = DebugActivity.this;
                super();
            }
        });
        Button button = (Button)view.findViewById(0x7f0e0047);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;

            public void onClick(View view1)
            {
                setState(getResources().getString(0x7f07007e), "GAMMA", "Service URL set to Gamma!");
            }

            
            {
                this$0 = DebugActivity.this;
                super();
            }
        });
        ((Button)view.findViewById(0x7f0e0044)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;

            public void onClick(View view1)
            {
                DataStore.removeKey("service_url_key");
                DataStore.removeKey("service_url_state_key");
                mServiceUrlText.setText(AppUtils.getServiceUrl(mContext));
                WeblabUtil.saveWeblabs(null);
                Toast.makeText(mContext, "Service URL Reset!", 0).show();
            }

            
            {
                this$0 = DebugActivity.this;
                super();
            }
        });
        ((Button)view.findViewById(0x7f0e0045)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;

            public void onClick(View view1)
            {
                setState(mServiceUrlText.getText().toString(), "OVERRIDE", "Service URL OVERRIDDEN!");
                Location.resetLocation();
            }

            
            {
                this$0 = DebugActivity.this;
                super();
            }
        });
        if (AppUtils.isDevo())
        {
            ((Button) (obj)).setVisibility(8);
            button.setVisibility(8);
        }
    }

    private void setupWeblabSection(final View view)
    {
        final EditText weblabEntryField = (EditText)view.findViewById(0x7f0e016a);
        final CheckBox clearAll = (CheckBox)view.findViewById(0x7f0e016c);
        Button button = (Button)view.findViewById(0x7f0e016d);
        Button button1 = (Button)view.findViewById(0x7f0e016e);
        ((TextView)view.findViewById(0x7f0e016b)).setText(WeblabUtil.getWeblabString());
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;
            final CheckBox val$clearAll;
            final View val$view;
            final EditText val$weblabEntryField;

            public void onClick(View view1)
            {
                if (clearAll.isChecked())
                {
                    WeblabUtil.clearWeblabs();
                }
                WeblabUtil.saveWeblabs(weblabEntryField.getText().toString().trim());
                clearAll.setChecked(false);
                weblabEntryField.setText("");
                setupWeblabSection(view);
            }

            
            {
                this$0 = DebugActivity.this;
                clearAll = checkbox;
                weblabEntryField = edittext;
                view = view1;
                super();
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;
            final View val$view;

            public void onClick(View view1)
            {
                WeblabUtil.saveWeblabs("HOUDINI_TOKYO_59025:T1|HOUDINI_MILAN_57474:T1");
                setupWeblabSection(view);
            }

            
            {
                this$0 = DebugActivity.this;
                view = view1;
                super();
            }
        });
    }

    public void launchContextTool(View view)
    {
        view = new Intent(this, com/amazon/now/web/WebActivity);
        view.putExtra("intentUrlKey", "/internal/context");
        startActivity(view);
    }

    public void launchCookieEditor(View view)
    {
        startActivity(new Intent(this, com/amazon/now/cookie/DebugCookieActivity));
    }

    public void launchDetailPageSettings(View view)
    {
        startActivity(new Intent(this, com/amazon/now/debug/DebugDetailPageActivity));
    }

    public void launchMapActivity(View view)
    {
        DebugMapWebActivity.startActivity(this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!AppUtils.isAppDebuggable(this))
        {
            finish();
        }
        mContext = this;
        bundle = new Intent();
        Object obj = getIntent().getStringExtra("launch");
        if (obj == null)
        {
            bundle = LayoutInflater.from(this).inflate(0x7f030009, null);
            setRootView(bundle, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
            setupServiceUrlButton(bundle);
            setupDebugWebviewButton(bundle);
            setupDebugSearchButton(bundle);
            setupForceCrashButton(bundle);
            setupWeblabSection(bundle);
            setupFeatureSection(bundle);
            ((Button)bundle.findViewById(0x7f0e004c)).setText(String.format(getResources().getString(0x7f0700b1), new Object[] {
                LocaleManager.getInstance().getLocale().getDisplayCountry()
            }));
            return;
        }
        obj = DebugLaunchActivity.valueOf(((String) (obj)));
        static class _cls12
        {

            static final int $SwitchMap$com$amazon$now$debug$DebugActivity$DebugLaunchActivity[];

            static 
            {
                $SwitchMap$com$amazon$now$debug$DebugActivity$DebugLaunchActivity = new int[DebugLaunchActivity.values().length];
                try
                {
                    $SwitchMap$com$amazon$now$debug$DebugActivity$DebugLaunchActivity[DebugLaunchActivity.MAP_ACTIVITY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$now$debug$DebugActivity$DebugLaunchActivity[DebugLaunchActivity.WEB_ACTIVITY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls12..SwitchMap.com.amazon.now.debug.DebugActivity.DebugLaunchActivity[((DebugLaunchActivity) (obj)).ordinal()])
        {
        default:
            finish();
            return;

        case 1: // '\001'
            MapWebActivity.startActivity(this, getIntent().getStringExtra("url"), false, false);
            return;

        case 2: // '\002'
            obj = getIntent().getStringExtra("url");
            break;
        }
        if (obj != null)
        {
            bundle.setClass(this, com/amazon/now/web/WebActivity);
            bundle.putExtra("intentUrlKey", ((String) (obj)));
        }
        startActivity(bundle);
    }

    public void setupFeatureSection(View view)
    {
        ((Button)view.findViewById(0x7f0e004b)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugActivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(DebugActivity.this, com/amazon/now/feature/DebugFeatureActivity));
            }

            
            {
                this$0 = DebugActivity.this;
                super();
            }
        });
    }

    public void showCountryChooser(final View locales)
    {
        locales = LocaleManager.getAvailableLocales();
        String as[] = new String[locales.length];
        for (int i = 0; i < locales.length; i++)
        {
            as[i] = locales[i].getDisplayCountry();
        }

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(0x7f070094);
        builder.setItems(as, new android.content.DialogInterface.OnClickListener() {

            final DebugActivity this$0;
            final Locale val$locales[];

            public void onClick(DialogInterface dialoginterface, int j)
            {
                while (j >= locales.length || locales[j] == LocaleManager.getInstance().getLocale()) 
                {
                    return;
                }
                Location.resetLocation();
                LocaleManager.getInstance().setLocale(locales[j]);
                dialoginterface = new Intent(DebugActivity.this, com/amazon/now/home/WelcomeScreen);
                dialoginterface.addFlags(0x14008000);
                startActivity(dialoginterface);
            }

            
            {
                this$0 = DebugActivity.this;
                locales = alocale;
                super();
            }
        });
        builder.create().show();
    }




}
