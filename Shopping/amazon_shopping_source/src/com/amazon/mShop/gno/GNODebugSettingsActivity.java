// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

public class GNODebugSettingsActivity extends AmazonActivity
    implements android.view.View.OnClickListener
{

    private EditText mCollapseDuration;
    private EditText mExpandDuration;
    private Button mSaveButton;
    private EditText mUrlOverride;
    private CheckBox mUrlToast;

    public GNODebugSettingsActivity()
    {
    }

    public static long getAnimationDurationMillis(Context context, boolean flag)
    {
        Object obj1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        Object obj;
        if (flag)
        {
            obj = "GNOItem.ExpandDuration";
        } else
        {
            obj = "GNOItem.CollapseDuration";
        }
        obj1 = Long.valueOf(((DataStore) (obj1)).getLong(((String) (obj))));
        obj = obj1;
        if (((Long) (obj1)).longValue() == 0L)
        {
            context = context.getResources();
            int i;
            if (flag)
            {
                i = com.amazon.mShop.android.lib.R.integer.animation_gno_expand_duration_per_item;
            } else
            {
                i = com.amazon.mShop.android.lib.R.integer.animation_gno_collapse_duration_per_item;
            }
            obj = Long.valueOf(context.getInteger(i));
        }
        return ((Long) (obj)).longValue();
    }

    public static String getTargetUrlOverride()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("GNODebugSettings.TargetUrlOverride", AppLocale.getInstance().getCurrentLocaleName());
    }

    public static String getTargetUrlOverride(String s)
    {
        Object obj = getTargetUrlOverride();
        if (!Util.isEmpty(((String) (obj))))
        {
            obj = Uri.parse(((String) (obj)));
            return Uri.parse(s).buildUpon().encodedAuthority(((Uri) (obj)).getEncodedAuthority()).scheme(((Uri) (obj)).getScheme()).build().toString();
        } else
        {
            return s;
        }
    }

    private void init()
    {
        mSaveButton.setOnClickListener(this);
        String s = getTargetUrlOverride();
        if (!Util.isEmpty(s))
        {
            mUrlOverride.setText(s);
        }
        mUrlToast.setChecked(isUrlToastEnabled().booleanValue());
        mExpandDuration.setHint(String.valueOf(getAnimationDurationMillis(this, true)));
        mCollapseDuration.setHint(String.valueOf(getAnimationDurationMillis(this, false)));
    }

    public static Boolean isUrlToastEnabled()
    {
        return Boolean.valueOf(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("GNODebugSettings.TargetUrlToast", AppLocale.getInstance().getCurrentLocaleName()));
    }

    private void setAnimationDurationMillis()
    {
        String s = mExpandDuration.getText().toString();
        String s1 = mCollapseDuration.getText().toString();
        if (!Util.isEmpty(s))
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putLong("GNOItem.ExpandDuration", Long.parseLong(s));
        }
        if (!Util.isEmpty(s1))
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putLong("GNOItem.CollapseDuration", Long.parseLong(s1));
        }
    }

    private static void setIsUrlToastEnabled(Boolean boolean1)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("GNODebugSettings.TargetUrlToast", boolean1.booleanValue());
    }

    private static void setTargetUrlOverride(String s)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("GNODebugSettings.TargetUrlOverride", s, AppLocale.getInstance().getCurrentLocaleName());
    }

    public void onClick(View view)
    {
        setTargetUrlOverride(mUrlOverride.getText().toString());
        setIsUrlToastEnabled(Boolean.valueOf(mUrlToast.isChecked()));
        setAnimationDurationMillis();
        AppUtils.restartApp();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        pushView(com.amazon.mShop.android.lib.R.layout.gno_debug_settings);
        bundle = getCurrentView();
        mSaveButton = (Button)bundle.findViewById(com.amazon.mShop.android.lib.R.id.gno_debug_save);
        mUrlOverride = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.gno_debug_url_override);
        mUrlToast = (CheckBox)bundle.findViewById(com.amazon.mShop.android.lib.R.id.gno_debug_url_toast);
        mExpandDuration = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.gno_debug_anim_expand_duration);
        mCollapseDuration = (EditText)bundle.findViewById(com.amazon.mShop.android.lib.R.id.gno_debug_anim_collapse_duration);
        init();
    }
}
