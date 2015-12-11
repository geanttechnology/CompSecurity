// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DebugSettingsActivityForAds extends Activity
{
    private static class AdsTypeAdapter extends ArrayAdapter
    {

        public AdsTypeAdapter(Context context)
        {
            super(context, 0x1090008);
            setDropDownViewResource(0x1090009);
            for (int i = 0; i < DebugSettingsActivityForAds.ADS_TYPE_ARRAY.length; i++)
            {
                add(DebugSettingsActivityForAds.ADS_TYPE_ARRAY[i]);
            }

        }
    }

    private class AdsTypeSpinnerOnSelectedListener
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        private final String mAdsId;
        final DebugSettingsActivityForAds this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            DebugSettingsActivityForAds.mMapAdsType.put(mAdsId, DebugSettingsActivityForAds.ADS_TYPE_ARRAY[i]);
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        public AdsTypeSpinnerOnSelectedListener(String s)
        {
            this$0 = DebugSettingsActivityForAds.this;
            super();
            mAdsId = s;
        }
    }


    private static final String ADS_ID_ARRAY[] = {
        "GW_PROMO_LEFT", "GW_PROMO_RIGHT", "DEALS_TOP", "THANK_YOU_BOTTOM"
    };
    private static final String ADS_TYPE_ARRAY[] = {
        "NOT_SPECIFIED", "IMAGE_HTML", "IMAGE_MRAID", "CELTRA"
    };
    private static Map mMapAdsType = new HashMap();
    private static Map mMapAdsTypeKey;

    public DebugSettingsActivityForAds()
    {
    }

    public static String getAdIdWithTypePostfix(Context context, String s)
    {
        context = context.getSharedPreferences("MobileAdsDataStore", 0).getString((String)mMapAdsTypeKey.get(s), "NOT_SPECIFIED");
        if ("NOT_SPECIFIED".equals(context))
        {
            return s;
        } else
        {
            return (new StringBuilder()).append(s).append("_").append(context).toString();
        }
    }

    private View getAdsTypeDropList(String s)
    {
        AdsTypeAdapter adstypeadapter = new AdsTypeAdapter(this);
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        Object obj = new TextView(this);
        ((TextView) (obj)).setText(s);
        linearlayout.addView(((View) (obj)));
        obj = new Spinner(this);
        ((Spinner) (obj)).setAdapter(adstypeadapter);
        ((Spinner) (obj)).setOnItemSelectedListener(new AdsTypeSpinnerOnSelectedListener(s));
        ((Spinner) (obj)).setSelection(getAdsTypeIndex(s));
        linearlayout.addView(((View) (obj)));
        return linearlayout;
    }

    private static int getAdsTypeIndex(String s)
    {
        s = (String)mMapAdsType.get(s);
        for (int i = 0; i < ADS_TYPE_ARRAY.length; i++)
        {
            if (ADS_TYPE_ARRAY[i].equals(s))
            {
                return i;
            }
        }

        return -1;
    }

    public static String getChannel(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("MobileAdsDataStore", 0);
        String s = sharedpreferences.getString("Channel", "");
        context = s;
        if (Util.isEmpty(s))
        {
            context = "100";
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("Channel", "100");
            editor.commit();
        }
        return context;
    }

    public static boolean isLogging(Context context)
    {
        return context.getSharedPreferences("MobileAdsDataStore", 0).getBoolean("Logging", false);
    }

    private void loadAdsTypeSettings()
    {
        mMapAdsType.clear();
        SharedPreferences sharedpreferences = getSharedPreferences("MobileAdsDataStore", 0);
        for (int i = 0; i < ADS_ID_ARRAY.length; i++)
        {
            String s = ADS_ID_ARRAY[i];
            String s1 = (String)mMapAdsTypeKey.get(s);
            mMapAdsType.put(s, sharedpreferences.getString(s1, "NOT_SPECIFIED"));
        }

    }

    public static void writeSettingsMap(Context context, Map map)
    {
        context = context.getSharedPreferences("MobileAdsDataStore", 0);
        android.content.SharedPreferences.Editor editor = context.edit();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            if ("Logging".equals(s))
            {
                if (!context.getBoolean(s, false))
                {
                    editor.putBoolean(s, Boolean.parseBoolean(((String) (obj))));
                }
            } else
            if (Util.isEmpty(context.getString(s, "")))
            {
                editor.putString(s, ((String) (obj)));
            }
        } while (true);
        editor.commit();
    }

    public void onCreate(final Bundle logOption)
    {
        super.onCreate(logOption);
        final SharedPreferences pref = getSharedPreferences("MobileAdsDataStore", 0);
        logOption = new CheckBox(this);
        logOption.setText("Logging");
        logOption.setChecked(pref.getBoolean("Logging", false));
        TextView textview = new TextView(this);
        textview.setText("Test Channel (if left empty, then we will use 90 as default)");
        final EditText channelEditText = new EditText(this);
        channelEditText.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(10)
        });
        channelEditText.setHint("Input the test channel number");
        channelEditText.setText(pref.getString("Channel", ""));
        Button button = new Button(this);
        button.setText("Save and Restart");
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final DebugSettingsActivityForAds this$0;
            final EditText val$channelEditText;
            final CheckBox val$logOption;
            final SharedPreferences val$pref;

            public void onClick(View view)
            {
                android.content.SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("Logging", logOption.isChecked());
                String s = channelEditText.getText().toString().trim();
                view = s;
                if (Util.isEmpty(s))
                {
                    view = "100";
                }
                editor.putString("Channel", view);
                String s1;
                Object obj;
                for (view = DebugSettingsActivityForAds.mMapAdsType.entrySet().iterator(); view.hasNext(); editor.putString((String)DebugSettingsActivityForAds.mMapAdsTypeKey.get(s1), ((String) (obj))))
                {
                    obj = (java.util.Map.Entry)view.next();
                    s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                    obj = (String)((java.util.Map.Entry) (obj)).getValue();
                }

                editor.commit();
                AppUtils.restartApp();
                finish();
            }

            
            {
                this$0 = DebugSettingsActivityForAds.this;
                pref = sharedpreferences;
                logOption = checkbox;
                channelEditText = edittext;
                super();
            }
        });
        pref = new LinearLayout(this);
        pref.setOrientation(1);
        pref.addView(button);
        pref.addView(logOption);
        pref.addView(textview);
        pref.addView(channelEditText);
        loadAdsTypeSettings();
        for (int i = 0; i < ADS_ID_ARRAY.length; i++)
        {
            pref.addView(getAdsTypeDropList(ADS_ID_ARRAY[i]));
        }

        setContentView(pref);
        setTitle("Mobile Ads Debug Settings");
    }

    static 
    {
        mMapAdsTypeKey = new HashMap();
        mMapAdsTypeKey.put("GW_PROMO_LEFT", "AdsTypePromoLeft");
        mMapAdsTypeKey.put("GW_PROMO_RIGHT", "AdsTypePromoRight");
        mMapAdsTypeKey.put("DEALS_TOP", "AdsTypeDeal");
        mMapAdsTypeKey.put("THANK_YOU_BOTTOM", "AdsTypeThankYouPage");
    }



}
