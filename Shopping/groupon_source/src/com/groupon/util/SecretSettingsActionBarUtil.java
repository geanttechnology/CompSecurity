// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.ActionBar;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecretSettingsActionBarUtil
{

    public SecretSettingsActionBarUtil()
    {
    }

    public static View addGlobalSearchButton(ActionBar actionbar, int i)
    {
        setCustomView(actionbar, 0x7f030105);
        return setGlobalSearchButton(actionbar, i);
    }

    public static ActionBar initializeActionBar(Context context, ActionBar actionbar, boolean flag, boolean flag1)
    {
        return initializeActionBar(context, actionbar, false, flag, flag1, null);
    }

    public static ActionBar initializeActionBar(Context context, ActionBar actionbar, boolean flag, boolean flag1, boolean flag2, String s)
    {
        int i;
        if (flag)
        {
            i = 0x7f02017e;
        } else
        {
            i = 0x7f0e0196;
        }
        actionbar.setIcon(i);
        actionbar.setDisplayShowTitleEnabled(flag1);
        actionbar.setDisplayHomeAsUpEnabled(flag2);
        if (flag1)
        {
            actionbar.setTitle(s);
        }
        return actionbar;
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

    public static void updateShoppingCartCounter(ActionBar actionbar, int i)
    {
        actionbar = actionbar.getCustomView();
        if (actionbar != null)
        {
            actionbar = actionbar.findViewById(0x7f10023a);
            if (actionbar != null)
            {
                actionbar = (TextView)actionbar.findViewById(0x7f10051c);
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
}
