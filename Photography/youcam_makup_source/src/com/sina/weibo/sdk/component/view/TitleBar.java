// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

public class TitleBar extends RelativeLayout
{

    public static final int TITLE_BAR_HEIGHT = 45;
    private ListenerOnTitleBtnClicked mClickListener;
    private TextView mLeftBtn;
    private TextView mTitleText;

    public TitleBar(Context context)
    {
        super(context);
        initViews();
    }

    public TitleBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initViews();
    }

    public TitleBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initViews();
    }

    private void initViews()
    {
        mLeftBtn = new TextView(getContext());
        mLeftBtn.setClickable(true);
        mLeftBtn.setTextSize(2, 17F);
        mLeftBtn.setTextColor(ResourceManager.createColorStateList(-32256, 0x66ff8200));
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(5);
        layoutparams.addRule(15);
        layoutparams.leftMargin = ResourceManager.dp2px(getContext(), 10);
        layoutparams.rightMargin = ResourceManager.dp2px(getContext(), 10);
        mLeftBtn.setLayoutParams(layoutparams);
        mLeftBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final TitleBar this$0;

            public void onClick(View view)
            {
                if (mClickListener != null)
                {
                    mClickListener.onLeftBtnClicked();
                }
            }

            
            {
                this$0 = TitleBar.this;
                super();
            }

            private class ListenerOnTitleBtnClicked
            {

                public abstract void onLeftBtnClicked();
            }

        });
        addView(mLeftBtn);
        mTitleText = new TextView(getContext());
        mTitleText.setTextSize(2, 18F);
        mTitleText.setTextColor(0xff525252);
        mTitleText.setEllipsize(android.text.TextUtils.TruncateAt.END);
        mTitleText.setSingleLine(true);
        mTitleText.setGravity(17);
        mTitleText.setMaxWidth(ResourceManager.dp2px(getContext(), 160));
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        mTitleText.setLayoutParams(layoutparams);
        addView(mTitleText);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, ResourceManager.dp2px(getContext(), 45)));
        setBackgroundDrawable(ResourceManager.getNinePatchDrawable(getContext(), "weibosdk_navigationbar_background.9.png"));
    }

    public void setLeftBtnBg(Drawable drawable)
    {
        mLeftBtn.setBackgroundDrawable(drawable);
    }

    public void setLeftBtnText(String s)
    {
        mLeftBtn.setText(s);
    }

    public void setTitleBarClickListener(ListenerOnTitleBtnClicked listenerontitlebtnclicked)
    {
        mClickListener = listenerontitlebtnclicked;
    }

    public void setTitleBarText(String s)
    {
        mTitleText.setText(s);
    }

}
