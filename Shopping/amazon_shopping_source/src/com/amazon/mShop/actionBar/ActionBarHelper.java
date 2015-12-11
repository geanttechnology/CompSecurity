// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.DelayedInitView;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.search.SearchActivity;

// Referenced classes of package com.amazon.mShop.actionBar:
//            ActionBarViewV2

public class ActionBarHelper
{

    public ActionBarHelper()
    {
    }

    public static View applyActionBar(AmazonActivity amazonactivity, View view)
    {
        ActionBarViewV2 actionbarviewv2 = (ActionBarViewV2)View.inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.action_bar_custom_v2, null);
        amazonactivity.getGNODrawer().addListener((ActionBarViewV2)actionbarviewv2);
        if (amazonactivity instanceof SearchActivity)
        {
            View view1 = actionbarviewv2.findViewById(com.amazon.mShop.android.lib.R.id.action_bar_search);
            if (view1 != null)
            {
                view1.setVisibility(8);
            }
        }
        amazonactivity = new LinearLayout(amazonactivity);
        amazonactivity.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        amazonactivity.setOrientation(1);
        view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        amazonactivity.addView(actionbarviewv2);
        amazonactivity.addView(view);
        return amazonactivity;
    }

    public static View applyActionBarSeparator(AmazonActivity amazonactivity, View view)
    {
        LinearLayout linearlayout = new LinearLayout(amazonactivity);
        linearlayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        linearlayout.setOrientation(1);
        linearlayout.addView(LayoutInflater.from(amazonactivity).inflate(com.amazon.mShop.android.lib.R.layout.action_bar_separator, linearlayout, false));
        linearlayout.addView(view);
        return linearlayout;
    }

    public static View applyWebGatewayCustomizedActionBar(AmazonActivity amazonactivity, View view, View view1)
    {
        LinearLayout linearlayout = new LinearLayout(amazonactivity);
        linearlayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        linearlayout.setOrientation(1);
        if (view1 != null)
        {
            linearlayout.addView(view1);
            if (view1 instanceof DelayedInitView)
            {
                amazonactivity.runOnUiThread(new Runnable(view1) {

                    final View val$webGatewayBar;

                    public void run()
                    {
                        ((DelayedInitView)webGatewayBar).onPushViewCompleted();
                    }

            
            {
                webGatewayBar = view;
                super();
            }
                });
            }
        }
        linearlayout.addView(LayoutInflater.from(amazonactivity).inflate(com.amazon.mShop.android.lib.R.layout.action_bar_separator, linearlayout, false));
        linearlayout.addView(view);
        return linearlayout;
    }

    private static View getActionBar(AmazonActivity amazonactivity)
    {
        amazonactivity = amazonactivity.getContentView();
        if (amazonactivity != null)
        {
            return amazonactivity.findViewById(com.amazon.mShop.android.lib.R.id.action_bar_view);
        } else
        {
            return null;
        }
    }

    public static void hideActionBar(AmazonActivity amazonactivity)
    {
        setActionBarVisibility(amazonactivity, 8);
    }

    public static void onOrientationChanged(AmazonActivity amazonactivity)
    {
        View view1;
label0:
        {
            View view = amazonactivity.getContentView();
            if (view != null)
            {
                view1 = view.findViewById(com.amazon.mShop.android.lib.R.id.action_bar_view);
                if (view1 != null)
                {
                    if (view.getResources().getConfiguration().orientation != 2)
                    {
                        break label0;
                    }
                    if (amazonactivity instanceof SearchActivity)
                    {
                        view1.setVisibility(8);
                    }
                }
            }
            return;
        }
        view1.setVisibility(0);
    }

    public static void onTitleChanged(AmazonActivity amazonactivity, CharSequence charsequence)
    {
        amazonactivity = amazonactivity.getContentView();
        if (amazonactivity != null)
        {
            amazonactivity = (TextView)amazonactivity.findViewById(com.amazon.mShop.android.lib.R.id.window_title);
            if (amazonactivity != null)
            {
                if ((charsequence instanceof SpannableString) || (charsequence instanceof Spanned))
                {
                    amazonactivity.setTypeface(Typeface.DEFAULT);
                } else
                {
                    amazonactivity.setTypeface(Typeface.DEFAULT_BOLD);
                }
                amazonactivity.setText(charsequence);
            }
        }
    }

    private static void setActionBarVisibility(AmazonActivity amazonactivity, int i)
    {
        amazonactivity = getActionBar(amazonactivity);
        if (amazonactivity != null)
        {
            amazonactivity.setVisibility(i);
        }
    }

    public static void showActionBar(AmazonActivity amazonactivity)
    {
        setActionBarVisibility(amazonactivity, 0);
    }
}
