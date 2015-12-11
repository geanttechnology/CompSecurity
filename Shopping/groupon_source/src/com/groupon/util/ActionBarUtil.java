// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.activity.DealDetails;
import com.groupon.activity.GrouponActivityDelegate;
import com.groupon.view.ActionBarClearableEditText;

public class ActionBarUtil
{

    public ActionBarUtil()
    {
    }

    public static void addCenteredLogo(ActionBar actionbar, boolean flag)
    {
        actionbar.setIcon(0x7f0e0196);
        actionbar.setDisplayHomeAsUpEnabled(flag);
        actionbar.setDisplayOptions(0, 8);
        actionbar.setDisplayShowCustomEnabled(true);
        actionbar.setCustomView(0x7f03001b);
        actionbar.setElevation(0.0F);
    }

    public static View addGlobalSearchButton(ActionBar actionbar, int i)
    {
        setCustomView(actionbar, 0x7f030105);
        return setGlobalSearchButton(actionbar, i);
    }

    public static View addGlobalSearchButtonWithRedesign(ActionBar actionbar, CharSequence charsequence)
    {
        actionbar.setDisplayShowCustomEnabled(true);
        actionbar.setCustomView(0x7f030106);
        return setGlobalSearchButtonWithRedesign(actionbar, charsequence);
    }

    public static void addLogo(ActionBar actionbar)
    {
        actionbar.setDisplayShowCustomEnabled(true);
        actionbar.setCustomView(0x7f03001a);
    }

    public static View addRedeemWebview(ActionBar actionbar)
    {
        actionbar.setDisplayShowCustomEnabled(true);
        actionbar.setCustomView(0x7f0301dd);
        return actionbar.getCustomView();
    }

    public static MenuItem addReportBugMenu(MenuInflater menuinflater, Menu menu)
    {
        menuinflater.inflate(0x7f110001, menu);
        return menu.findItem(0x7f100592);
    }

    public static ActionBarClearableEditText addSearchMenu(ActionBar actionbar, int i)
    {
        actionbar.setDisplayShowCustomEnabled(true);
        actionbar.setCustomView(0x7f030154);
        actionbar = (ActionBarClearableEditText)actionbar.getCustomView().findViewById(0x7f100308);
        actionbar.setHint(i);
        return actionbar;
    }

    public static MenuItem addShareMenu(MenuInflater menuinflater, Menu menu)
    {
        menuinflater.inflate(0x7f110004, menu);
        return menu.findItem(0x7f100595);
    }

    public static boolean navigateUpTo(Activity activity, Channel channel, Intent intent, Intent intent1)
    {
        if (activity instanceof DealDetails)
        {
            if (channel != null && channel.isNavigableTo() && intent != null)
            {
                channel = intent;
            } else
            {
                channel = intent1;
            }
        } else
        {
            channel = intent;
        }
        if (activity.getIntent().getBooleanExtra("isDeepLinked", false))
        {
            return GrouponActivityDelegate.startDeepLinkedUpButtonIntent(activity, channel);
        } else
        {
            return activity.navigateUpTo(channel);
        }
    }

    public static View setCustomView(ActionBar actionbar, int i)
    {
        actionbar.setDisplayShowCustomEnabled(true);
        actionbar.setCustomView(i);
        return actionbar.getCustomView();
    }

    public static View setGlobalSearchButton(ActionBar actionbar, int i)
    {
        View view = actionbar.getCustomView();
        if (view == null)
        {
            return addGlobalSearchButton(actionbar, i);
        }
        EditText edittext = (EditText)view.findViewById(0x7f100301);
        if (edittext == null)
        {
            actionbar = addGlobalSearchButton(actionbar, i);
        } else
        {
            edittext.setHint(i);
            actionbar = view;
        }
        return actionbar;
    }

    public static View setGlobalSearchButtonWithRedesign(ActionBar actionbar, CharSequence charsequence)
    {
        View view = actionbar.getCustomView();
        if (view == null)
        {
            return addGlobalSearchButtonWithRedesign(actionbar, charsequence);
        }
        TextView textview = (TextView)view.findViewById(0x7f10050f);
        if (textview == null)
        {
            actionbar = addGlobalSearchButtonWithRedesign(actionbar, charsequence);
        } else
        {
            textview.setText(charsequence);
            actionbar = view;
        }
        return actionbar;
    }

    public static void showShoppingCartNewBadge(ActionBar actionbar)
    {
        actionbar = actionbar.getCustomView();
        if (actionbar != null)
        {
            showShoppingCartNewBadge(actionbar.findViewById(0x7f10023a));
        }
    }

    public static void showShoppingCartNewBadge(View view)
    {
        if (view != null)
        {
            TextView textview = (TextView)view.findViewById(0x7f10051c);
            ((TextView)view.findViewById(0x7f10051d)).setVisibility(0);
            textview.setVisibility(8);
        }
    }

    public static void updateInAppMessageCounter(ActionBar actionbar, int i)
    {
        actionbar = actionbar.getCustomView();
        if (actionbar != null)
        {
            actionbar = actionbar.findViewById(0x7f1003c1);
            if (actionbar != null)
            {
                actionbar = (TextView)actionbar.findViewById(0x7f1003c4);
                actionbar.setText(String.valueOf(i));
                if (i > 0)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                actionbar.setVisibility(i);
            }
        }
    }

    public static void updateShoppingCartCounter(ActionBar actionbar, int i)
    {
        actionbar = actionbar.getCustomView();
        if (actionbar != null)
        {
            updateShoppingCartCounter(actionbar.findViewById(0x7f10023a), i);
        }
    }

    public static void updateShoppingCartCounter(View view, int i)
    {
        byte byte0 = 8;
        if (view != null)
        {
            TextView textview = (TextView)view.findViewById(0x7f10051c);
            ((TextView)view.findViewById(0x7f10051d)).setVisibility(8);
            textview.setText(String.valueOf(i));
            if (i > 0)
            {
                byte0 = 0;
            }
            textview.setVisibility(byte0);
        }
    }
}
