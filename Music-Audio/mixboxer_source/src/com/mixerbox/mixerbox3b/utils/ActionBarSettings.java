// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.view.View;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.mixerbox.mixerbox3b.MainPage;

public class ActionBarSettings
{

    public static Context ctx;

    public ActionBarSettings()
    {
    }

    public static void changeToBackActionBar(Context context)
    {
        ctx = context;
        context = ((SherlockFragmentActivity)context).getSupportActionBar();
        context.setDisplayShowTitleEnabled(false);
        context.setDisplayHomeAsUpEnabled(true);
    }

    public static void changeToNormalActionBar(Context context)
    {
        ctx = context;
        context = ((SherlockFragmentActivity)context).getSupportActionBar();
        context.setLogo(0x7f02011d);
        context.setDisplayHomeAsUpEnabled(false);
        context.setDisplayShowTitleEnabled(false);
        context.setCustomView(0x7f030016);
    }

    public static void hideOption(Menu menu, int i)
    {
        menu.findItem(i).setVisible(false);
    }

    public static void initActionBar(Context context)
    {
        ctx = context;
        context = ((SherlockFragmentActivity)context).getSupportActionBar();
        context.setLogo(0x7f02011d);
        context.setDisplayHomeAsUpEnabled(false);
        context.setDisplayShowTitleEnabled(false);
        context.setIcon(0x7f0200ec);
    }

    public static void setActionBarItems(Menu menu, int i, Context context)
    {
        context = menu.findItem(999);
        if (context != null)
        {
            context.getActionView().clearFocus();
            context.getActionView().setFocusable(false);
        }
        showOption(menu, 999);
        hideOption(menu, 1);
        hideOption(menu, 2);
        hideOption(menu, 3);
        hideOption(menu, 7);
        hideOption(menu, 8);
        hideOption(menu, 10);
        hideOption(menu, 13);
        showOption(menu, 11);
        ((SherlockFragmentActivity)ctx).setSupportProgressBarIndeterminateVisibility(false);
        i;
        JVM INSTR tableswitch 0 13: default 168
    //                   0 169
    //                   1 168
    //                   2 187
    //                   3 168
    //                   4 205
    //                   5 223
    //                   6 168
    //                   7 236
    //                   8 168
    //                   9 249
    //                   10 168
    //                   11 273
    //                   12 168
    //                   13 292;
           goto _L1 _L2 _L1 _L3 _L1 _L4 _L5 _L1 _L6 _L1 _L7 _L1 _L8 _L1 _L9
_L1:
        return;
_L2:
        showOption(menu, 1);
        showOption(menu, 12);
        showOption(menu, 6);
        return;
_L3:
        if (((MainPage)ctx).isLogIn)
        {
            showOption(menu, 3);
            return;
        }
          goto _L1
_L4:
        showOption(menu, 2);
        showOption(menu, 6);
        showOption(menu, 12);
        return;
_L5:
        hideOption(menu, 6);
        hideOption(menu, 12);
        return;
_L6:
        hideOption(menu, 6);
        hideOption(menu, 12);
        return;
_L7:
        showOption(menu, 2);
        hideOption(menu, 6);
        showOption(menu, 7);
        hideOption(menu, 12);
        return;
_L8:
        hideOption(menu, 999);
        hideOption(menu, 2);
        showOption(menu, 13);
        return;
_L9:
        hideOption(menu, 999);
        ((SherlockFragmentActivity)ctx).setSupportProgressBarIndeterminateVisibility(true);
        return;
    }

    private static void showOption(Menu menu, int i)
    {
        menu.findItem(i).setVisible(true);
    }
}
