// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.view.View;
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
