// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

public class UIUtils
{

    private UIUtils()
    {
    }

    public static void closeSoftKeyboard(View view)
    {
        InputMethodManager inputmethodmanager;
        if (view != null)
        {
            if ((inputmethodmanager = (InputMethodManager)view.getContext().getSystemService("input_method")) != null)
            {
                inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
        }
    }

    public static View inflate(Context context, int i, ViewGroup viewgroup, boolean flag)
    {
        return LayoutInflater.from(context).inflate(i, viewgroup, flag);
    }

    public static void setBackground(View view, Drawable drawable)
    {
        if (view == null)
        {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view.setBackground(drawable);
            return;
        } else
        {
            view.setBackgroundDrawable(drawable);
            return;
        }
    }

    public static void setVisibility(View view, int i)
    {
        if (view != null)
        {
            view.setVisibility(i);
        }
    }

    public static void showSoftKeyboard(View view)
    {
        if (view != null)
        {
            if ((view = (InputMethodManager)view.getContext().getSystemService("input_method")) != null)
            {
                view.toggleSoftInput(2, 2);
                return;
            }
        }
    }
}
