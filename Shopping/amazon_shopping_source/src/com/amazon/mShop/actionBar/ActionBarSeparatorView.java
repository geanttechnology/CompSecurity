// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.account.LogoutActivity;
import com.amazon.mShop.home.GatewayActivity;
import com.amazon.mShop.home.HomeView;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryBar;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryView;

public class ActionBarSeparatorView extends LinearLayout
{
    private class TopMostViewChangedReceiver extends BroadcastReceiver
    {

        final ActionBarSeparatorView this$0;

        public void onReceive(Context context, Intent intent)
        {
            if ("com.amazon.mShop.TopMostViewChangedReceiverIntent".equals(intent.getAction()))
            {
                updateVisiblity();
            }
        }

        private TopMostViewChangedReceiver()
        {
            this$0 = ActionBarSeparatorView.this;
            super();
        }

    }


    private ImageView mActionBarSeparator;
    private AmazonActivity mAmazonActivity;
    private BroadcastReceiver mTopMostViewChangedReceiver;
    private TextView mWindowTitle;

    public ActionBarSeparatorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mAmazonActivity = (AmazonActivity)context;
        mTopMostViewChangedReceiver = new TopMostViewChangedReceiver();
        mAmazonActivity.registerReceiver(mTopMostViewChangedReceiver, new IntentFilter("com.amazon.mShop.TopMostViewChangedReceiverIntent"));
    }

    private void updateVisiblity()
    {
        Object obj;
        byte byte0;
        byte0 = 8;
        obj = mAmazonActivity.getCurrentView();
        updateWindowTitleVisibility(((View) (obj)));
        if (!(mAmazonActivity instanceof GatewayActivity)) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof HomeView)) goto _L4; else goto _L3
_L3:
        mActionBarSeparator.setVisibility(8);
_L6:
        return;
_L4:
        mActionBarSeparator.setVisibility(0);
        return;
_L2:
        if (mAmazonActivity instanceof SearchActivity)
        {
            if (obj instanceof RetailSearchEntryView)
            {
                mActionBarSeparator.setVisibility(8);
                return;
            }
            if (obj instanceof ViewGroup)
            {
                boolean flag1 = false;
                obj = (ViewGroup)obj;
                int i = 0;
                do
                {
label0:
                    {
                        boolean flag = flag1;
                        if (i < ((ViewGroup) (obj)).getChildCount())
                        {
                            if (!(((ViewGroup) (obj)).getChildAt(i) instanceof RetailSearchEntryBar))
                            {
                                break label0;
                            }
                            flag = true;
                        }
                        obj = mActionBarSeparator;
                        if (flag)
                        {
                            i = byte0;
                        } else
                        {
                            i = 0;
                        }
                        ((ImageView) (obj)).setVisibility(i);
                        return;
                    }
                    i++;
                } while (true);
            } else
            {
                mActionBarSeparator.setVisibility(0);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void updateWindowTitleVisibility(View view)
    {
        if (mAmazonActivity instanceof MShopWebActivity)
        {
            mWindowTitle.setVisibility(8);
            return;
        }
        if ((mAmazonActivity instanceof LogoutActivity) || (mAmazonActivity instanceof MShopWebActivity))
        {
            mWindowTitle.setVisibility(0);
            return;
        }
        CharSequence charsequence = mAmazonActivity.getTitle();
        if ((view instanceof TitleProvider) && !Util.isEmpty(charsequence))
        {
            mWindowTitle.setVisibility(0);
            return;
        } else
        {
            mWindowTitle.setVisibility(8);
            return;
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mAmazonActivity.unregisterReceiver(mTopMostViewChangedReceiver);
        mTopMostViewChangedReceiver = null;
    }

    protected void onFinishInflate()
    {
        mActionBarSeparator = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.action_bar_separator_image);
        mWindowTitle = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.window_title);
    }

}
