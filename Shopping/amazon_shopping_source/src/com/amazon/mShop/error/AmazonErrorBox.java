// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.error;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AmazonErrorBox extends LinearLayout
    implements com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener
{
    public static interface AmazonErrorBoxActionListener
    {

        public abstract void onActionButtonClick(int i);
    }


    private Button mActionButton;
    private int mCurrentOrientation;
    private LinearLayout mDialogBox;
    private TextView mMsgTextView;

    public AmazonErrorBox(Context context)
    {
        super(context);
        mCurrentOrientation = 0;
        createDialog();
        handleConfigurationChanged(getResources().getConfiguration());
    }

    private void adjustLayout(int i)
    {
        int j = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(j, j, j, j);
        android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutparams1.setMargins(j, j, j, j);
        if (i == 2)
        {
            layoutparams.weight = getResources().getInteger(com.amazon.mShop.android.lib.R.integer.error_dialog_msg_weight_landscape);
            layoutparams1.gravity = 16;
            layoutparams1.weight = getResources().getInteger(com.amazon.mShop.android.lib.R.integer.error_dialog_positive_button_weight_landscape);
            mDialogBox.setOrientation(0);
        } else
        {
            layoutparams1.gravity = 1;
            mDialogBox.setOrientation(1);
        }
        mMsgTextView.setLayoutParams(layoutparams);
        mActionButton.setLayoutParams(layoutparams1);
    }

    private Button getButton(int i)
    {
        Button button = null;
        if (i == 1)
        {
            button = mActionButton;
        }
        return button;
    }

    protected void createDialog()
    {
        Context context = getContext();
        mCurrentOrientation = 1;
        inflate(context, com.amazon.mShop.android.lib.R.layout.amazon_error_box, this);
        mDialogBox = (LinearLayout)findViewById(com.amazon.mShop.android.lib.R.id.error_box_action_box);
        mMsgTextView = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.error_box_message);
        mActionButton = (Button)findViewById(com.amazon.mShop.android.lib.R.id.error_box_action_button);
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    public void handleConfigurationChanged(Configuration configuration)
    {
        if (mCurrentOrientation != configuration.orientation)
        {
            mCurrentOrientation = configuration.orientation;
            adjustLayout(mCurrentOrientation);
        }
    }

    public void setButtonOnClick(int i, android.view.View.OnClickListener onclicklistener)
    {
        Button button = getButton(i);
        if (button != null)
        {
            button.setOnClickListener(onclicklistener);
        }
    }

    public void setButtonText(int i, CharSequence charsequence)
    {
        Button button = getButton(i);
        if (button != null)
        {
            button.setText(charsequence);
        }
    }

    public void setMessage(CharSequence charsequence)
    {
        mMsgTextView.setText(charsequence);
    }
}
