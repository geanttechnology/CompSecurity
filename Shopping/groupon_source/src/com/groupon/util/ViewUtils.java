// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;

public class ViewUtils
{
    public static class Size
    {

        private int height;
        private int width;

        public int getHeight()
        {
            return height;
        }

        public int getWidth()
        {
            return width;
        }

        public void setHeight(int i)
        {
            height = i;
        }

        public void setWidth(int i)
        {
            width = i;
        }

        public Size(int i, int j)
        {
            width = i;
            height = j;
        }
    }


    public ViewUtils()
    {
    }

    public static void forceShowKeyboard(Context context, boolean flag)
    {
        int i = 0;
        context = (InputMethodManager)context.getSystemService("input_method");
        if (context != null)
        {
            byte byte0;
            if (flag)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            if (flag)
            {
                i = 1;
            }
            context.toggleSoftInput(byte0, i);
        }
    }

    public static void initWebView(WebView webview)
    {
        webview.setBackgroundColor(0);
        webview.setBackground(null);
        webview.setLayerType(1, null);
        webview.setVisibility(0);
    }

    public static void setEditTextError(EditText edittext, String s)
    {
        edittext.addTextChangedListener(new TextWatcher(edittext) {

            final EditText val$editText;

            public void afterTextChanged(Editable editable)
            {
                editText.setError(null);
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                editText = edittext;
                super();
            }
        });
        ForegroundColorSpan foregroundcolorspan = new ForegroundColorSpan(0x7f0e0031);
        (new SpannableStringBuilder(s)).setSpan(foregroundcolorspan, 0, s.length(), 0);
        edittext.setError(s);
        edittext.requestFocus();
    }

    public static void setEnabledOnAllChildren(ViewGroup viewgroup, boolean flag)
    {
        for (int i = 0; i < viewgroup.getChildCount(); i++)
        {
            viewgroup.getChildAt(i).setEnabled(flag);
        }

    }

    public static void setSoftKeyboardState(Context context, boolean flag, View view)
    {
label0:
        {
            if (view != null)
            {
                context = (InputMethodManager)context.getSystemService("input_method");
                if (!flag)
                {
                    break label0;
                }
                context.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            return;
        }
        context.showSoftInput(view, 1);
    }
}
