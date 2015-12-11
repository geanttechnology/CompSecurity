// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableRow;
import android.widget.TextView;

public class MShopWebDebugSwitchNativeVSHTMLRow extends TableRow
    implements android.view.View.OnClickListener
{
    public static interface OnSelectionChangedListener
    {

        public abstract void onSelectionChanged(String s, String s1);
    }


    private String mFeatureKey;
    private TextView mFeatureTextView;
    private CheckBox mHTMLBox;
    private CheckBox mLastCheckedBox;
    private CheckBox mNativeBox;
    private OnSelectionChangedListener mSelectionChangeListener;
    private CheckBox mWeblabBox;

    public MShopWebDebugSwitchNativeVSHTMLRow(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public String getSelectedFeatureValue()
    {
        return (String)mLastCheckedBox.getTag();
    }

    public void onClick(View view)
    {
        view = (CheckBox)view;
        if (mLastCheckedBox != view)
        {
            mLastCheckedBox.setChecked(false);
            mLastCheckedBox = view;
            view = (String)mLastCheckedBox.getTag();
            if (mSelectionChangeListener != null)
            {
                mSelectionChangeListener.onSelectionChanged(view, mFeatureKey);
            }
            return;
        } else
        {
            mLastCheckedBox.setChecked(true);
            return;
        }
    }

    protected void onFinishInflate()
    {
        mFeatureTextView = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.web_debug_settings_item_feature_name);
        mNativeBox = (CheckBox)findViewById(com.amazon.mShop.android.lib.R.id.web_debug_settings_item_use_native);
        mHTMLBox = (CheckBox)findViewById(com.amazon.mShop.android.lib.R.id.web_debug_settings_item_use_html);
        mWeblabBox = (CheckBox)findViewById(com.amazon.mShop.android.lib.R.id.web_debug_settings_item_use_weblab);
        mNativeBox.setTag("featureNative");
        mHTMLBox.setTag("fatureHTML");
        mWeblabBox.setTag("featureWeblab");
        mWeblabBox.setOnClickListener(this);
        mNativeBox.setOnClickListener(this);
        mHTMLBox.setOnClickListener(this);
    }

    public void setFeatureKey(String s)
    {
        mFeatureKey = s;
    }

    public void setFeatureName(String s)
    {
        mFeatureTextView.setText(s);
    }

    public void setOnSelectionChangeListener(OnSelectionChangedListener onselectionchangedlistener)
    {
        mSelectionChangeListener = onselectionchangedlistener;
    }

    public void setSelectedFeatureValue(String s)
    {
        if ("fatureHTML".equals(s))
        {
            mHTMLBox.setChecked(true);
            mLastCheckedBox = mHTMLBox;
            return;
        }
        if ("featureNative".equals(s))
        {
            mNativeBox.setChecked(true);
            mLastCheckedBox = mNativeBox;
            return;
        } else
        {
            mWeblabBox.setChecked(true);
            mLastCheckedBox = mWeblabBox;
            return;
        }
    }
}
